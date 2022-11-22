package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Item;
import org.hdcd.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

	private final ItemMapper mapper;

	@Override
	public void register(Item item) throws Exception {
		mapper.create(item);
	}

	@Override
	public Item read(Long itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);
	}

	@Override
	public void remove(Long itemId) throws Exception {
		mapper.delete(itemId);
	}

	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}
	
	@Override
	public List<Item> listCamera() throws Exception {
		return mapper.listCamera();
	}
	
	@Override
	public List<Item> listBycicle() throws Exception {
		return mapper.listBycicle();
	}

	@Override
	public List<Item> listHiking() throws Exception {
		return mapper.listHiking();
	}

	@Override
	public List<Item> listSwimming() throws Exception {
		return mapper.listSwimming();
	}

	@Override
	public List<Item> listCamping() throws Exception {
		return mapper.listCamping();
	}

	@Override
	public List<Item> listFishing() throws Exception {
		return mapper.listFishing();
	}

	@Override
	public List<Item> listBoardgame() throws Exception {
		return mapper.listBoardgame();
	}

	@Override
	public List<Item> listOthers() throws Exception {
		return mapper.listOthers();
	}

	@Override
	public String getPreview(Long itemId) throws Exception {
		return mapper.getPreview(itemId);
	}
	
	@Override
	public String getPicture(Long itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	
}
