package org.hdcd.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// 설정 프로퍼티 클래스 정의
@Getter
@Setter
@Component
@ConfigurationProperties("org.hdcd")
public class ShopProperties {

	private String uploadPath = "C:/images/";
	
}
