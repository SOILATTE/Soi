package org.hdcd.common.mapper;

import java.util.List;

import org.hdcd.common.domain.LoginLog;

public interface LoginLogMapper {

	// 등록 처리
	public void create(LoginLog loginLog) throws Exception;

	public List<LoginLog> list() throws Exception;

}
