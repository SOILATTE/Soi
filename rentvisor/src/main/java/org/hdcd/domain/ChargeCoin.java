package org.hdcd.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChargeCoin {

	private Long historyNo;
	private Long userNo;
	
	private Integer amount;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
