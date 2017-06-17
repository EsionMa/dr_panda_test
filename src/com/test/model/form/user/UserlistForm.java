/**
 * 2017年3月11日 下午12:04:11
 */
package com.test.model.form.user;

/**
 * @author Esion
 *
 */
public class UserlistForm {
	/** 当前页 */
	private String pageNum;
	/** 搜索关键字 */
	private String searchKey;

	/**
	 * @return pageNum
	 */
	public String getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum 要设置的 pageNum
	 */
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return searchKey
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * @param searchKey 要设置的 searchKey
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

}
