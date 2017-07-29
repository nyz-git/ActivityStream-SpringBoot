package com.stackroute.activitystream.circle;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("circleDAO")
@Transactional
@Component
public class CircleDaoImpl implements CircleDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Boolean createCircle(Circle circle) {
		// TODO Auto-generated method stub
		try {
			circle.setCircleCreationDate();
			sessionFactory.getCurrentSession().save(circle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean updateCircle(Circle circle) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(circle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteCircle(int circleId) {
		// TODO Auto-generated method stub
		try {
			Circle circle = getCircleById(circleId);
			sessionFactory.getCurrentSession().delete(circle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Circle getCircleById(int circleId) {
		// TODO Auto-generated method stub
		try {
			Circle circle = sessionFactory.getCurrentSession().get(Circle.class, circleId);
			return circle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public Circle getCircleByName(String name) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Circle where circleName = ?");
			query.setParameter(0, name);
			Circle circle = (Circle) query.uniqueResult();
			return circle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Circle> getAllCircles() {
		// TODO Auto-generated method stub
		try {
			List<Circle> listOfCircles = sessionFactory.getCurrentSession().createQuery("from Circle").list();
			return listOfCircles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
