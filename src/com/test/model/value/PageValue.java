/**
 * 2017年3月11日 下午2:22:52
 */
package com.test.model.value;

import java.util.List;

/**
 * @author Esion
 *
 */
public class PageValue {
	/** 总数量 */
	private int totalCount;
	/** 总页数 */
	private int totalPages;
	/** 当前页码 */
	private int pageNum;
	/** 上一页 */
	private boolean previous;
	/** 下一页 */
	private boolean next;
	/** 页码列表 */
	private List<String> pageList;

	/**
	 * @return totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 要设置的 totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages 要设置的 totalPages
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum 要设置的 pageNum
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return previous
	 */
	public boolean isPrevious() {
		return previous;
	}

	/**
	 * @param previous 要设置的 previous
	 */
	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	/**
	 * @return next
	 */
	public boolean isNext() {
		return next;
	}

	/**
	 * @param next 要设置的 next
	 */
	public void setNext(boolean next) {
		this.next = next;
	}

	/**
	 * @return pageList
	 */
	public List<String> getPageList() {
		return pageList;
	}

	/**
	 * @param pageList 要设置的 pageList
	 */
	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageValue [totalCount=" + totalCount + ", totalPages=" + totalPages + ", pageNum=" + pageNum + ", previous=" + previous + ", next=" + next + ", pageList=" + pageList + "]";
	}

}
