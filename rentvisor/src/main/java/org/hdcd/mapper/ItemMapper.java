package org.hdcd.mapper;

import java.util.List;
import org.hdcd.domain.Item;

public interface ItemMapper {

	public void create(Item item) throws Exception;

	public Item read(Long itemId) throws Exception;

	public void update(Item item) throws Exception;

	public void delete(Long itemId) throws Exception;

	public List<Item> list() throws Exception;
	
	public List<Item> listCamera() throws Exception;
	
	public List<Item> listBycicle() throws Exception;
	
	public List<Item> listHiking() throws Exception;
	
	public List<Item> listSwimming() throws Exception;
	
	public List<Item> listCamping() throws Exception;
	
	public List<Item> listFishing() throws Exception;
	
	public List<Item> listBoardgame() throws Exception;
	
	public List<Item> listOthers() throws Exception;

	public String getPicture(Long itemId) throws Exception;

	public String getPreview(Long itemId) throws Exception;

}
