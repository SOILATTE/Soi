package org.hdcd.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Notice {

	private Long noticeNo;
	
	@NotBlank
	private String title;
	
	private String content;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
