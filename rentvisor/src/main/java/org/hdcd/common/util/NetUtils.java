package org.hdcd.common.util;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

// 로그인을 시도한 클라이언트 IP 주소를 얻는 유틸리티 클래스를 정의한다.
// 시스템 네트워크 구성에 따라 기능에 차이가 있을 수 있다.
@Slf4j
public class NetUtils {
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		 
		log.info(">>>> X-FORWARDED-FOR : " + ip);
	 
		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
			log.info(">>>> Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			log.info(">>>> WL-Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			log.info(">>>> HTTP_CLIENT_IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		log.info(">>>> Result : IP Address : "+ip);
	 
		return ip;
	}
}
