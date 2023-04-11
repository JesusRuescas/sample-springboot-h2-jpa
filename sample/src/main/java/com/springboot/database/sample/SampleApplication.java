package com.springboot.database.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.database.sample.entities.SampleEntity;
import com.springboot.database.sample.repository.SampleRepository;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner{

	@Autowired
	private SampleRepository sampleRepository;
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SampleEntity sample1 = new SampleEntity("Sample session 1");
		SampleEntity sample2 = new SampleEntity("Sample session 2");

		sampleRepository.save(sample1);
		sampleRepository.save(sample2);
	}

}
