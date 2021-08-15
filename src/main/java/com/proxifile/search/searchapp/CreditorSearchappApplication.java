package com.proxifile.search.searchapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.proxifile.search.searchapp.indexing.CreditorElasticsearchRepository;

@SpringBootApplication
@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CreditorElasticsearchRepository.class))
@EnableElasticsearchRepositories(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CreditorElasticsearchRepository.class))
public class CreditorSearchappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditorSearchappApplication.class, args);
	}

}
