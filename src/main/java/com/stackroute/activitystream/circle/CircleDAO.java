package com.stackroute.activitystream.circle;

import java.util.List;


public interface CircleDAO {

	//for creating circle
	Boolean createCircle(Circle circle);
	
	//for updating circle
	Boolean updateCircle(Circle circle);
	
	//for deleting circle
	Boolean deleteCircle(int circleId);
	
	//getting a circle by id
	Circle getCircleById(int circleId);
	
	//getting circle by name
	Circle getCircleByName(String name);
	
	//to get all circle
	List<Circle> getAllCircles();
}
