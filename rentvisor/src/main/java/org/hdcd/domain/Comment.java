package org.hdcd.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {

	private int commentId;
	private int parentId;
	private String content;
	@DateTimeFormat(pattern="yyMMdd")
	private LocalDate writeDate;
	private String userId;
	private long userNo;
	private long boardNo;
}
