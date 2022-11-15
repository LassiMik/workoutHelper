package com.example.workoutHelper.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long>{
	List<Workout> findByDate(String date);
}