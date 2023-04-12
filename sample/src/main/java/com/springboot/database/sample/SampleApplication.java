package com.springboot.database.sample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.database.sample.entities.CourseEntity;
import com.springboot.database.sample.repository.SampleRepository;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	@Autowired
	private SampleRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CourseEntity course1 = new CourseEntity("Bachelor of Information Systems", "Development");
		CourseEntity course2 = new CourseEntity("Technologist in systems analysis and development", "Development");
		CourseEntity course3 = new CourseEntity("Technical course in computer networks", "Infrastructure");
		CourseEntity course4 = new CourseEntity("Bachelor in Computer Engineering", "Data Science");
		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		Thread.sleep(3000);
		course2.setName("Sample session update");
		courseRepository.save(course2);

		List<CourseEntity> courseList = courseRepository.findAll();
		courseList.forEach(course -> System.out.println(course));
		System.out.println("The DB have " + courseRepository.count() + " fields");

		Optional<CourseEntity> courseSearch = courseRepository.findById(3);
		CourseEntity courseFinal = courseSearch.orElse(null);

		System.out.println("The name of the searched field is '" + courseFinal.getName() + "'");

		List<CourseEntity> courseFindByName = courseRepository.findByName("Bachelor of Information Systems");
		courseFindByName.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<CourseEntity> courseFindByNameContaining = courseRepository.findByNameContaining("networks");
		courseFindByNameContaining.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<CourseEntity> courseFindByNameLike = courseRepository.findByNameLike("%Systems%");
		courseFindByNameLike.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<CourseEntity> courseFindByNameLikeIgnoreCase = courseRepository.findByNameLikeIgnoreCase("%systems%");
		courseFindByNameLikeIgnoreCase.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<CourseEntity> findByQueryName = courseRepository.findByQueryName();
		findByQueryName.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<String> findByQueryNamePeerArea = courseRepository.findByQueryNamePeerArea();
		findByQueryNamePeerArea.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<String> findByQueryNamePeerSelectedArea = courseRepository.findByQueryNamePeerSelectedArea("Development");
		findByQueryNamePeerSelectedArea.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<String> findByQueryNamePeerAreaParam = courseRepository.findByQueryNamePeerAreaParam("Development",
				"Sample session");
		findByQueryNamePeerAreaParam.forEach(SampleEntity -> System.out.println(SampleEntity));
	}

}
