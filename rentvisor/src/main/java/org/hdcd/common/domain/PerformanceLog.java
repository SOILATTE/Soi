package org.hdcd.common.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PerformanceLog {

	private String signatureName;
	private String signatureTypeName;
	private Long durationTime;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
