package com.telusko.JobApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.repo.JobRepos;
import com.telusko.JobApp.service.JobService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
	
	@Autowired
	JobRepos repo;
	
	@Autowired
	private JobService service;
	
	@GetMapping("jobPosts")
	@ResponseBody
	public List<JobPost> getAllJobs() {
		
		return repo.findAll();
		
	}
	
	@GetMapping("jobPost/{postId}")
	@ResponseBody
	public JobPost getJob(@PathVariable("postId") int postId) {
		return repo.getById(postId);
	}
	
	@PostMapping("jobPost")
	@ResponseBody
	public void addJob(@RequestBody JobPost jobPost) {
		 repo.save(jobPost);
	}
	
	@PutMapping("jobPost")
	@ResponseBody
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		return repo.save(jobPost);
	}
	@DeleteMapping("jobPost")
	@ResponseBody
	public void deleteJob(@RequestBody JobPost jobPost) {
		repo.delete(jobPost);
	}
	
	@GetMapping("jobPost/keyword/{Keyword}")
	@ResponseBody
	public List<JobPost> searchJob(@PathVariable("Keyword") String Keyword) {
		return repo.findByPostProfileContainingOrPostDescContaining(Keyword, Keyword);
	}
}
