package org.hdcd.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserItem {

	private Long userItemNo;
	private Long userNo;
	
	private Long itemId;
	private String itemName;
	private Integer price;
	private String description;
	private String pictureUrl;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
