package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Item;
import org.hdcd.domain.Member;
import org.hdcd.domain.PayCoin;
import org.hdcd.domain.UserItem;
import org.hdcd.exception.NotEnoughCoinException;
import org.hdcd.mapper.CoinMapper;
import org.hdcd.mapper.UserItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserItemServiceImpl implements UserItemService {

	private final UserItemMapper mapper;
	
	private final CoinMapper coinMapper;

	@Transactional
	@Override
	public void register(Member member, Item item) throws Exception {
		Long userNo = member.getUserNo();
		Integer coin = member.getCoin();
		
		Long itemId = item.getItemId();
		Integer price = item.getPrice();
		
		if(coin < price) {
			throw new NotEnoughCoinException("There is Not Enough Coin.");
		}
		
		UserItem userItem = new UserItem();
		userItem.setUserNo(userNo);
		userItem.setItemId(itemId);
		
		PayCoin payCoin = new PayCoin();
		payCoin.setUserNo(userNo);
		payCoin.setItemId(itemId);
		payCoin.setAmount(price);
		
		coinMapper.pay(payCoin);
		coinMapper.createPayHistory(payCoin);
		
		mapper.create(userItem);
	}

	@Override
	public UserItem read(Long userItemNo) throws Exception {
		return mapper.read(userItemNo);
	}

	@Override
	public List<UserItem> list(Long userNo) throws Exception {
		return mapper.list(userNo);
	}
	
}
