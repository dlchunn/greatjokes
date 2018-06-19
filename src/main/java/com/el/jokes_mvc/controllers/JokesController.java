package com.el.jokes_mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.el.jokes_mvc.models.Joke;
import com.el.jokes_mvc.repositories.JokeRepository;

@Controller
public class JokesController {
	
	@Autowired
	private JokeRepository jokeRepository;

	public JokesController() {
		
	}
	
	@GetMapping("/")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		List<Joke> jokes = jokeRepository.findAll();
		mv.addObject("jokes", jokes);
		mv.setViewName("read");
		return mv;
	}
	@GetMapping("/add")
	public ModelAndView addJoke()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Greatjokes");
		return mv;
	}
	@PostMapping("/add")
	public ModelAndView addJoke(String joke,String punchline, Integer rating)
	{
	ModelAndView mv = new ModelAndView();
	Joke j = new Joke(joke, punchline, rating);
	jokeRepository.save(j);
	mv.setViewName("Greatjokes");
	return mv;
}
	}