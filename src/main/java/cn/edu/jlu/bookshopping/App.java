package cn.edu.jlu.bookshopping;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
//扫描数据访问层接口的包名。
@MapperScan("cn.edu.jlu.bookshopping.repository") 
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
