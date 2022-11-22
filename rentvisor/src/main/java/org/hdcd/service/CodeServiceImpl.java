package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.mapper.CodeMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CodeServiceImpl implements CodeService {

	private final CodeMapper mapper;

	@Override
	public List<CodeLabelValue> getGroupCodeList() throws Exception {
		return mapper.getGroupCodeList();
	}

	@Override
	public List<CodeLabelValue> getCodeList(String groupCode) throws Exception {
		return mapper.getCodeList(groupCode);
	}
	
}
