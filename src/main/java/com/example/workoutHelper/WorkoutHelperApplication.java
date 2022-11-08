package com.example.workoutHelper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.workoutHelper.domain.Type;
import com.example.workoutHelper.domain.TypeRepository;
import com.example.workoutHelper.domain.Workout;
import com.example.workoutHelper.domain.WorkoutRepository;
import com.example.workoutHelper.domain.UserClass;
import com.example.workoutHelper.domain.UserRepository;

@SpringBootApplication
public class WorkoutHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutHelperApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner WorkoutDemo(WorkoutRepository workoutRepository, TypeRepository typeRepository, UserRepository userRepository) {
		return (args) -> {
			UserClass userClass1 = new UserClass("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "testi@testi.com");
			UserClass userClass2 = new UserClass("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "testi@testi.com");
			userRepository.save(userClass1);
			userRepository.save(userClass2);
			
			typeRepository.save(new Type("Squat"));
			typeRepository.save(new Type("Deadlift"));
			typeRepository.save(new Type("Bench press"));
			typeRepository.save(new Type("Bicep curl"));
			typeRepository.save(new Type("Romanian deadlift"));
			
			workoutRepository.save(new Workout(12, 3, 100, "2022-11-05", typeRepository.findByName("Squat").get(0)));
			workoutRepository.save(new Workout(12, 3, 100, "2022-11-05", typeRepository.findByName("Deadlift").get(0)));
			workoutRepository.save(new Workout(12, 3, 100, "2022-11-05", typeRepository.findByName("Bench press").get(0)));
		};
	}
}
