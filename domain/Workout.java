package com.example.workoutHelper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Workout {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private double repetitions;
    private double sets;
    private double weight;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String name) {
		this.date = name;
	}

	@ManyToOne
    @JoinColumn(name="typeId")
    private Type type;

	public Workout() {}
	
	public Workout(double repetitions, double sets, double weight, String date, Type type) {
		super();
		this.repetitions = repetitions;
		this.sets = sets;
		this.weight = weight;
		this.type = type;
		this.date = date;	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(double repetitions) {
		this.repetitions = repetitions;
	}

	public double getSets() {
		return sets;
	}

	public void setSets(double sets) {
		this.sets = sets;
	}
    
    public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
