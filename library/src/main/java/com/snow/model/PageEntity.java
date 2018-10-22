package com.snow.model;

/**
 * 分页类
 */
public class PageEntity {
	/**总行，条数*/
	private Integer totalRows;//
	/**分页总数*/
	private Integer toalPage;
	/**当前分页，要显示的页*/
	private Integer curPage;
	/**从第几条数据开始查询起*/
	private Integer startRow;
	/**每页显示多少条*/
	private Integer curPageSize; //
	/*---------------------------------------------------------------------------------------*/

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getToalPage() {
		return toalPage;
	}

	public void setToalPage(Integer toalPage) {
		this.toalPage = toalPage;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getCurPageSize() {
		return curPageSize;
	}

	public void setCurPageSize(Integer curPageSize) {
		this.curPageSize = curPageSize;
	}

	public PageEntity() {
		super();
	}

	public PageEntity(Integer totalRows, Integer toalPage, Integer curPage, Integer startRow, Integer curPageSize) {
		this.totalRows = totalRows;
		this.toalPage = toalPage;
		this.curPage = curPage;
		this.startRow = startRow;
		this.curPageSize = curPageSize;
	}

	@Override
	public String toString() {
		return "PageEntity{" +
				"totalRows=" + totalRows +
				", toalPage=" + toalPage +
				", curPage=" + curPage +
				", startRow=" + startRow +
				", curPageSize=" + curPageSize +
				'}';
	}
}
