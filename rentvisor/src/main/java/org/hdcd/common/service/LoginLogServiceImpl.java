package org.hdcd.common.service;

import java.util.List;

import org.hdcd.common.domain.LoginLog;
import org.hdcd.common.mapper.LoginLogMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginLogServiceImpl implements LoginLogService {

	private final LoginLogMapper mapper;

	// 로그인 로깅 처리
	@Override
	public void register(LoginLog loginLog) throws Exception {
		mapper.create(loginLog);
	}
	
	@Override
	public List<LoginLog> list() throws Exception {
		return mapper.list();
	}

}
