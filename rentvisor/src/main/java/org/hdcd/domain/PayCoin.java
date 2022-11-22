package org.hdcd.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayCoin {

	private Long historyNo;
	
	private Long userNo;
	private Long itemId;
	private String itemName;
	private Integer amount;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
