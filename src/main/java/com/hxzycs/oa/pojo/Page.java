package com.hxzycs.oa.pojo;

import java.util.List;

public class Page {
	protected Long total;
	protected List<?> rows;
	protected Integer limit;
	protected Integer offset;
	protected String search;
	protected String sort;
	protected String order;
	
	public Page() {
		offset = 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Page{limit = %d, offset = %d, search = %s, sort = %s, order = %s}",limit,offset,search,sort,order);
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
