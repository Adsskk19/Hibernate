package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int traineeId;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trainees_courses",
	joinColumns = {@JoinColumn(name = "traineeId")},
	inverseJoinColumns = {@JoinColumn(name = "course_Id")})
	private List<Course> courses;
	
	public Trainee() {
		
	}
	
	public Trainee(String name) {
		super();
		this.name = name;
	}

	public Trainee(String name, List<Course> courses) {
		super();
		this.name = name;
		this.courses = courses;
	}

	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + "]";
	}
	
	

}
