package com.springnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
// identifies which classes should be used by a JPA persistence context.
@EntityScan("com.springnotes.model")
// create repository classes from Spring Data interfaces.
@EnableJpaRepositories("com.springnotes.repository")
public class SpringNotesApplication {

	public static void main(String[] args) {
		// Just toying around with streams and filters
		Set<String> toySet = new HashSet<>();
		toySet.add("banana");
		toySet.add("apple");
		toySet.add("peach");

		Stream<String> filteredStream = toySet.stream().filter(item -> item.contains("ban"));
		Set<String> filteredSet = filteredStream.collect(Collectors.toSet());

		Stream<String> mappedStream= toySet.stream().map(String::toUpperCase);
		Set<String> mappedSet = mappedStream.collect(Collectors.toSet());
		System.out.println("============================ TOYSET ============================");
		System.out.println(toySet);
		System.out.println("============================ FILTEREDSET ============================");
		System.out.println(filteredSet);
		System.out.println("============================ MAPPEDSET ============================");
		System.out.println(mappedSet);
		SpringApplication.run(SpringNotesApplication.class, args);
	}

}
