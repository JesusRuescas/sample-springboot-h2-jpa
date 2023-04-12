package com.springboot.database.sample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.database.sample.entities.SampleEntity;
import com.springboot.database.sample.repository.SampleRepository;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	@Autowired
	private SampleRepository sampleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SampleEntity sample1 = new SampleEntity("Sample session 1", "Compile");
		SampleEntity sample2 = new SampleEntity("Sample session 2", "Compile");
		SampleEntity sample3 = new SampleEntity("Sample session 3", "Compile");
		SampleEntity sample4 = new SampleEntity("Sample session Test 1", "Test");
		SampleEntity sample5 = new SampleEntity("Sample session test 2", "Test");
		sampleRepository.save(sample1);
		sampleRepository.save(sample2);
		sampleRepository.save(sample3);
		sampleRepository.save(sample4);
		sampleRepository.save(sample5);
		Thread.sleep(3000);
		sample2.setName("Sample session update");
		sampleRepository.save(sample2);

		List<SampleEntity> sampleList = sampleRepository.findAll();
		sampleList.forEach(sample -> System.out.println(sample));
		System.out.println("The DB have " + sampleRepository.count() + " fields");

		Optional<SampleEntity> sampleSearch = sampleRepository.findById(3);
		SampleEntity sampleFinal = sampleSearch.orElse(null);

		System.out.println("The name of the searched field is '" + sampleFinal.getName() + "'");

		List<SampleEntity> sampleFindByName = sampleRepository.findByName("Sample session 1");
		sampleFindByName.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<SampleEntity> sampleFindByNameContaining = sampleRepository.findByNameContaining("session");
		sampleFindByNameContaining.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<SampleEntity> sampleFindByNameLike = sampleRepository.findByNameLike("%3%");
		sampleFindByNameLike.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<SampleEntity> sampleFindByNameLikeIgnoreCase = sampleRepository.findByNameLikeIgnoreCase("%Test%");
		sampleFindByNameLikeIgnoreCase.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<SampleEntity> findByQueryName = sampleRepository.findByQueryName();
		findByQueryName.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<String> findByQueryNamePeerArea = sampleRepository.findByQueryNamePeerArea();
		findByQueryNamePeerArea.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<String> findByQueryNamePeerSelectedArea = sampleRepository.findByQueryNamePeerSelectedArea("Compile");
		findByQueryNamePeerSelectedArea.forEach(SampleEntity -> System.out.println(SampleEntity));

		List<String> findByQueryNamePeerAreaParam = sampleRepository.findByQueryNamePeerAreaParam("Compile",
				"Sample session");
		findByQueryNamePeerAreaParam.forEach(SampleEntity -> System.out.println(SampleEntity));
	}

}
