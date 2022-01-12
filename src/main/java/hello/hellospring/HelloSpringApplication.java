package hello.hellospring;//이 패키지 포함 하위만 컴포넌트 스캔 대상

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
	}

}

