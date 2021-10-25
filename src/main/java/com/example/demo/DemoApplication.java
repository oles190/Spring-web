package com.example.demo;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DemoApplication {




	public static void main(String[] args) {





		ConfigurableApplicationContext context= SpringApplication.run(DemoApplication.class,args);
		PostService service= context.getBean(PostService.class);

		Post post = new Post(23,"csacs","ascas","csacsa",12);


	//	service.save(post);

		System.out.println(service.findAll());





	}

}
