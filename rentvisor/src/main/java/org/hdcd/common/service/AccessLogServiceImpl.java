package org.hdcd.common.service;

import java.util.List;

import org.hdcd.common.domain.AccessLog;
import org.hdcd.common.mapper.AccessLogMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccessLogServiceImpl implements AccessLogService {

	private final AccessLogMapper mapper;

	@Override
	public void register(AccessLog accessLog) throws Exception {
		mapper.create(accessLog);
	}

	@Override
	public List<AccessLog> list() throws Exception {
		return mapper.list();
	}

}
