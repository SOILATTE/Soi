package org.hdcd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hdcd.domain.Pds;

public interface PdsMapper {

	public void create(Pds pds) throws Exception;

	public Pds read(Long itemId) throws Exception;

	public void update(Pds pds) throws Exception;

	public void delete(Long itemId) throws Exception;

	public List<Pds> list() throws Exception;

	public void addAttach(@Param("fullName") String fullName, @Param("itemId") Long itemId) throws Exception;

	public List<String> getAttach(Long itemId) throws Exception;

	public void deleteAttach(Long itemId) throws Exception;

	public void replaceAttach(@Param("fullName") String fullName, @Param("itemId") Long itemId) throws Exception;

	public void updateAttachDownCnt(String fullName) throws Exception;

	public void updateViewCnt(Long itemId) throws Exception;
	
}
