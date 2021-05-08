package com.prafulla.cloud;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Import(DemoConfiguration.class)
@ImportResource("/simple-context.xml")
public class SpringMicroservicesApplication {

	@Autowired
	@Resource(name="circus")
	private List<String> list;
	
	@RequestMapping("/")
	public String sayHiThere() {
		return String.join(", ", list);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesApplication.class, args);
	}

}
