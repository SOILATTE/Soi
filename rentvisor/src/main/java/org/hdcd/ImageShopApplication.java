package org.hdcd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* mapper 패키지에 들어있는 Mapper 인터페이스를 스캔해오겠다. */
@SpringBootApplication
@MapperScan(basePackages = {"org.hdcd.mapper", "org.hdcd.common.mapper"})
public class ImageShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageShopApplication.class, args);
	}

}
