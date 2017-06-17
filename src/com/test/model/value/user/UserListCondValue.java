/**
 * 2017年3月11日 下午1:43:52
 */
package com.test.model.value.user;

/**
 * @author Esion
 *
 */
public class UserListCondValue {
	/** 用户ID */
	private String userId;
	/** 当前页 */
	private int pageNum;
	/** 搜索关键字 */
	private String searchKey;
	/** 起始位置 */
	private int startIndex;
	/** 检索最大数 */
	private int maxCount;

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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

	/**
	 * @return startIndex
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * @param startIndex 要设置的 startIndex
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return maxCount
	 */
	public int getMaxCount() {
		return maxCount;
	}

	/**
	 * @param maxCount 要设置的 maxCount
	 */
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserListCondValue [userId=" + userId + ", pageNum=" + pageNum + ", searchKey=" + searchKey + ", startIndex=" + startIndex + ", maxCount=" + maxCount + "]";
	}

}
