package com.stackroute.activitystream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.circle.Circle;
import com.stackroute.activitystream.circle.CircleDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class CircleServiceApplicationTests {

	/*@Autowired
	private static AnnotationConfigApplicationContext context;*/

	
	private static Circle circle;

	@Autowired
	private  CircleDAO circleDAO;

	@BeforeClass
	public static void init() {
		/*context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
		circle = context.getBean(Circle.class);
		circleDAO = (CircleDAO) context.getBean("circleDAO");*/
		circle = new Circle();
		//circleDAO = new CircleDaoImpl();
	}

	//@Test
	public void createCircleTest() {
		Circle circle = new Circle();
		// circle.setCircleId(1);
		circle.setCircleName("Bangalore");
		circle.setCircleDescription("This circle is created");
		circle.setCircleOwner("zaid.ansari@niit.com");
		circle.setCircleCreationDate();

		// Hibernate Validation
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		factory.getValidator().validate(circle);*/

		assertEquals("Circle Creation Done ", true, circleDAO.createCircle(circle));
	}

	 //@Test
	public void updateCircleNameTest() {
		circle = circleDAO.getCircleById(2);
		circle.setCircleName("NIIT-MUMBAI");
		assertEquals("Circle Name Updated", true, circleDAO.updateCircle(circle));
	}

	//@Test
	public void deleteCircleByIdTest() {
		assertEquals("Circle Deleted", true, circleDAO.deleteCircle(2));

	}

	//@Test
	public void getCircleByIdTest() {
		circle = circleDAO.getCircleById(1);
		assertNotNull(circle);
		assertEquals("Circle Retived Correctly", "StackRoute", circle.getCircleName());
		display(circle);
	}

	@Test
	public void getCircleByName() {
		circle = circleDAO.getCircleByName("VEG");
		assertNotNull(circle);
		display(circle);
	}

	//@Test
	public void getAllCircles() {
		List<Circle> allCircles = circleDAO.getAllCircles();
		assertNotNull(allCircles);
		for (Circle c : allCircles) {
			display(c);
		}
	}

	public void display(Circle circle) {
		System.out.println(circle);
	}
}

