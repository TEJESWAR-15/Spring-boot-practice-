package com.telusko.JobApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.JobApp.model.JobPost;

@Repository
public interface JobRepos extends JpaRepository<JobPost, Integer>{
	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String Desc);
	
	@Query("select J from JobPost J where J.Id = ?1")
	JobPost findById(int Id);
}
