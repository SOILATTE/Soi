package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ChargeCoin;
import org.hdcd.domain.PayCoin;
import org.hdcd.mapper.CoinMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CoinServiceImpl implements CoinService {

	private final CoinMapper mapper;

	@Transactional
	@Override
	public void charge(ChargeCoin chargeCoin) throws Exception {
		mapper.charge(chargeCoin);
		mapper.create(chargeCoin);
	}

	@Override
	public List<ChargeCoin> list(Long userNo) throws Exception {
		return mapper.list(userNo);
	}
	
	@Override
	public List<PayCoin> listPayHistory(Long userNo) throws Exception {
		return mapper.listPayHistory(userNo);
	}
	
}
