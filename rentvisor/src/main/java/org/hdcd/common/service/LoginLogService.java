package org.hdcd.common.service;

import java.util.List;

import org.hdcd.common.domain.LoginLog;

// 로그인 로깅 처리
public interface LoginLogService {

	public void register(LoginLog loginLog) throws Exception;

	public List<LoginLog> list() throws Exception;

}
