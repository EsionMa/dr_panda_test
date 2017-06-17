/**
 * 2017年3月11日 下午4:24:32
 */
package com.test.utility;

import java.util.ArrayList;
import java.util.List;

import com.test.constants.Constants;

/**
 * @author Esion
 *
 */
public class PageUtility {
	public static int getTotalPage(int totalCount, int pageSize) {
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		return totalPage;
	}

	public static List<String> createPageList(Integer page, Integer totalPages) {
		return createPageList(page, Constants.PAGE_LIST_COUNT_MAX, totalPages);
	}

	public static List<String> createPageList(Integer page, Integer pageMaxCount, Integer totalPages) {
		List<String> pageList = new ArrayList<String>();

		if (pageMaxCount % 2 == 0) {
			if (page <= pageMaxCount / 2 || totalPages <= pageMaxCount - 1) {
				int maxPage = totalPages <= pageMaxCount - 1 ? totalPages : pageMaxCount - 1;
				for (int i = 1; i <= maxPage; i++) {
					pageList.add(String.valueOf(i));
				}
			} else if (page > pageMaxCount / 2 && totalPages > pageMaxCount - 1) {
				if (page <= totalPages - pageMaxCount / 2) {
					for (int i = page - (pageMaxCount - 1 - 1) / 2; i <= page + (pageMaxCount - 1 - 1) / 2; i++) {
						pageList.add(String.valueOf(i));
					}
				} else if (page > totalPages - pageMaxCount / 2) {
					for (int i = totalPages - (pageMaxCount - 1 - 1); i <= totalPages; i++) {
						pageList.add(String.valueOf(i));
					}
				}
			}
		} else {
			if (page < (pageMaxCount + 1) / 2 || totalPages <= pageMaxCount - 1) {
				int maxPage = totalPages <= pageMaxCount ? totalPages : pageMaxCount;
				for (int i = 1; i <= maxPage; i++) {
					pageList.add(String.valueOf(i));
				}
			} else if (page >= (pageMaxCount + 1) / 2 && totalPages > pageMaxCount - 1) {
				if (page <= totalPages - ((pageMaxCount + 1) / 2)) {
					for (int i = page - (pageMaxCount - 1) / 2; i <= page + (pageMaxCount - 1) / 2; i++) {
						pageList.add(String.valueOf(i));
					}
				} else if (page > totalPages - ((pageMaxCount + 1) / 2)) {
					for (int i = totalPages - (pageMaxCount - 1); i <= totalPages; i++) {
						pageList.add(String.valueOf(i));
					}
				}
			}
		}
		return pageList;
	}

}
