package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.UserItem;

public interface UserItemMapper {

	public void create(UserItem userItem) throws Exception;

	public UserItem read(Long userItemNo) throws Exception;

	public List<UserItem> list(Long userNo) throws Exception;
	
}
