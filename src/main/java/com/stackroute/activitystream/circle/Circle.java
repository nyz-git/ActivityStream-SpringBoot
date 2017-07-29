package com.stackroute.activitystream.circle;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@Entity
public class Circle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("circle_id")
	private int circleId;

	@JsonProperty("circle_name")
	private String circleName;

	@JsonProperty("circle_owner")
	private String circleOwner;

	@JsonProperty("circle_description")
	private String circleDescription;

	@JsonProperty("circle_creation_date")
	private Date circleCreationDate;

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getCircleOwner() {
		return circleOwner;
	}

	public void setCircleOwner(String circleOwner) {
		this.circleOwner = circleOwner;
	}

	public String getCircleDescription() {
		return circleDescription;
	}

	public void setCircleDescription(String circleDescription) {
		this.circleDescription = circleDescription;
	}

	public Date getCircleCreationDate() {
		return circleCreationDate;
	}

	public void setCircleCreationDate() {
		this.circleCreationDate = new Date();
	}

	@Override
	public String toString() {
		return "Circle [circleId=" + circleId + ", circleName=" + circleName + ", circleOwner=" + circleOwner
				+ ", circleDescription=" + circleDescription + ", circleCreationDate=" + circleCreationDate + "]";
	}

	
}
