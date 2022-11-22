package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Pds;
import org.hdcd.mapper.PdsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PdsServiceImpl implements PdsService {

	private final PdsMapper mapper;

	@Transactional
	@Override
	public void register(Pds pds) throws Exception {
		mapper.create(pds);
		
		Long createdItemId = pds.getItemId();
		
		String[] files = pds.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			mapper.addAttach(fileName, createdItemId);
		}
	}

	@Override
	public Pds read(Long itemId) throws Exception {
		mapper.updateViewCnt(itemId);
		
		return mapper.read(itemId);
	}

	@Transactional
	@Override
	public void modify(Pds pds) throws Exception {
		mapper.update(pds);

		Long itemId = pds.getItemId();

		mapper.deleteAttach(itemId);

		String[] files = pds.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			mapper.replaceAttach(fileName, itemId);
		}
	}

	@Transactional
	@Override
	public void remove(Long itemId) throws Exception {
		mapper.deleteAttach(itemId);
		mapper.delete(itemId);
	}

	@Override
	public List<Pds> list() throws Exception {
		return mapper.list();
	}

	@Override
	public List<String> getAttach(Long itemId) throws Exception {
		return mapper.getAttach(itemId);
	}

	@Override
	public void updateAttachDownCnt(String fullName) throws Exception {
		mapper.updateAttachDownCnt(fullName);
	}
	
}
