package org.hdcd.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {

	private Long itemId;

	@NotBlank
	private String itemName;
	
	private Integer price;
	private String description;
	
	private MultipartFile picture;
	private String pictureUrl;

	private MultipartFile preview;
	private String previewUrl;

	private LocalDateTime regDate;
	private LocalDateTime updDate;
	
	private String itemCategory;
	
	

}
