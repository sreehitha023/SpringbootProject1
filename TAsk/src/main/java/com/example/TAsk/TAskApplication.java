package com.example.TAsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TAskApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TAskApplication.class, args);
	}

}
