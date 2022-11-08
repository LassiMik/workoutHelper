package com.example.workoutHelper.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.workoutHelper.domain.Workout;
import com.example.workoutHelper.domain.WorkoutRepository;
import com.example.workoutHelper.domain.TypeRepository;

@Controller
public class WorkoutController {
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
    @RequestMapping(value= {"/", "/workoutlist", "/booklist"})
    public String workoutList(Model model) {	
        model.addAttribute("workouts", workoutRepository.findAll());
        return "/workoutlist";
    }
    
    @RequestMapping(value="/workouts", method = RequestMethod.GET)
    public @ResponseBody List<Workout> workoutListRest() {	
        return (List<Workout>) workoutRepository.findAll();
    }
    
    @RequestMapping(value="/workout/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Workout> findWorkoutRest(@PathVariable("id") Long workoutId) {	
    	return workoutRepository.findById(workoutId);
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchWorkout(@RequestParam (value = "search", required = false) String date, Model model) {
        model.addAttribute("search", workoutRepository.findByDate(date));
        return "workouts";
    }
  
    @RequestMapping(value = "/add")
    public String addWorkout(Model model){
    	model.addAttribute("workout", new Workout());
    	model.addAttribute("type", typeRepository.findAll());
        return "/addworkout";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("workout") Workout workout){
    	workoutRepository.save(workout);
        return "redirect:/workoutlist";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteWorkout(@PathVariable("id") Long workoutId, Model model) {
    	workoutRepository.deleteById(workoutId);
        return "redirect:/workoutlist";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editWorkout(@PathVariable("id") Long workoutId, Model model) { 
    	model.addAttribute("workout", workoutRepository.findById(workoutId));
    	model.addAttribute("type", typeRepository.findAll());
        return "/editworkout";
    }
    @RequestMapping(value = "/delete1/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteWorkout1(@PathVariable("id") Long workoutId, Model model) {
    	workoutRepository.deleteById(workoutId);
        return "redirect:/workoutlist";
    }
    
    @RequestMapping(value = "/edit1/{id}", method = RequestMethod.GET)
    public String editWorkout1(@PathVariable("id") Long workoutId, Model model) { 
    	model.addAttribute("workout", workoutRepository.findById(workoutId));
    	model.addAttribute("type", typeRepository.findAll());
        return "/editworkout1";
    }
    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    public String save1(@ModelAttribute("workout") Workout workout){
    	workoutRepository.save(workout);
        return "workouts";
    }
}