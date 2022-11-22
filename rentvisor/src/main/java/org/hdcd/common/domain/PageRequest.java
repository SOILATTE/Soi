package org.hdcd.common.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageRequest {

	private int page;
	private int sizePerPage;
	
	private String searchType;
	private String keyword;

	public PageRequest() {
		this.page = 1;
		this.sizePerPage = 10;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public int getPageStart() {
		return (this.page - 1) * sizePerPage;
	}

	public int getSizePerPage() {
		return this.sizePerPage;
	}
	
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String toUriStringByPage(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			.queryParam("page", page)
			.queryParam("searchType", this.searchType)
			.queryParam("keyword", this.keyword)
			.build();

		return uriComponents.toUriString();
	}
	
	public String toUriString() {
		return toUriStringByPage(this.page);
	}
	
	public String toUriStringForSearchAction(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			.queryParam("page", page)
			.build();
	
		return uriComponents.toUriString();
	}		
	
}
