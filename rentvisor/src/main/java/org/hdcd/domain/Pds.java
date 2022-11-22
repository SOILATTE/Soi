package org.hdcd.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pds {

	private Long itemId;

	@NotBlank
	private String itemName;
	
	private String description;
	private String[] files;
	private Integer viewCnt;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;	
	
}
