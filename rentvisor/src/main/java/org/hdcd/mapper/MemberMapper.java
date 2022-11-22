package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Member;
import org.hdcd.domain.MemberAuth;

public interface MemberMapper {
	
	public int countAll() throws Exception;

	public void create(Member member) throws Exception;

	public void createAuth(MemberAuth memberAuth) throws Exception;
	
	public Member readByUserId(String userId);

	public Member read(Long userNo) throws Exception;

	public void update(Member member) throws Exception;

	public void delete(Long userNo) throws Exception;

	public List<Member> list() throws Exception;

	public void deleteAuth(Long userNo) throws Exception;
	
}
