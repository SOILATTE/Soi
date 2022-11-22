package org.hdcd.common.service;

import java.util.List;

import org.hdcd.common.domain.PerformanceLog;
import org.hdcd.common.mapper.PerformanceLogMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PerformanceLogServiceImpl implements PerformanceLogService {

	private final PerformanceLogMapper mapper;

	@Override
	public void register(PerformanceLog performanceLog) throws Exception {
		mapper.create(performanceLog);
	}

	@Override
	public List<PerformanceLog> list() throws Exception {
		return mapper.list();
	}

}
