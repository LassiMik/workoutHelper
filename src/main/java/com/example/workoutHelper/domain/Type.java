package com.example.workoutHelper.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="type")
    private List<Workout> workout;
    
    public Type() {}
    
    public List<Workout> getWorkouts() {
		return workout;
	}

	public void setWorkout(List<Workout> workout) {
		this.workout = workout;
	}

	public Type(String name) {
    	super();
    	this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
