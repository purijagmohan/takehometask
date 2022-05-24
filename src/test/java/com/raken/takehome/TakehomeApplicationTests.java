package com.raken.takehome;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;

@SpringBootTest
class TakehomeApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void fluxTest() {
		Flux<String> stringFlux = Flux.just("Spring", "Spring boot", "Reactive Spring");
		stringFlux.subscribe(System.out::println, (e) -> System.out.println("Exception is" + e));
		
	}

}
