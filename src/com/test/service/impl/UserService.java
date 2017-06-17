/**
 * 2016年12月10日 下午11:47:36
 */
package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserMapper;
import com.test.model.entity.TrUserEntity;
import com.test.model.value.user.EditUserCondValue;
import com.test.model.value.user.UserCondValue;
import com.test.model.value.user.UserListCondValue;
import com.test.model.value.user.UserListValue;
import com.test.model.value.user.UserValue;
import com.test.service.IUserService;
import com.test.utility.DateUtility;
import com.test.utility.PageUtility;

/**
 * @author Esion
 *
 */
@Service
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbs.service.IUserService#getUserList(com.bbs.model.value.user.
	 * UserListCondValue)
	 */
	@Override
	public UserListValue getUserList(UserListCondValue userListCondValue) throws Exception {
		UserListValue userListValue = new UserListValue();
		List<UserValue> userList = new ArrayList<>();
		// 当前页
		int pageNum = userListCondValue.getPageNum();
		userListValue.setPageNum(pageNum);
		// 总数量
		int totalCount = userMapper.getUserCount();
		userListValue.setTotalCount(totalCount);
		// 总页数
		int totalPages = PageUtility.getTotalPage(totalCount, 5);
		userListValue.setTotalPages(totalPages);
		if (pageNum > 1) {
			userListValue.setPrevious(false);
		} else if (pageNum < totalPages) {
			userListValue.setNext(true);
		}
		// 所有导航页号
		List<String> pageList = PageUtility.createPageList(userListCondValue.getPageNum(), totalPages);
		userListValue.setPageList(pageList);
		// 起始位置
		if (pageNum > totalPages) {
			userListCondValue.setStartIndex((totalPages - 1) * 5);
		} else {
			userListCondValue.setStartIndex((pageNum - 1) * 5);
		}
		// 检索最大数
		userListCondValue.setMaxCount(5);
		List<TrUserEntity> trUserEntities = userMapper.getUserList(userListCondValue);
		if (trUserEntities.size() > 0) {
			for (TrUserEntity trUserEntity : trUserEntities) {
				UserValue userValue = new UserValue();
				if (trUserEntity != null) {
					userValue.setUserId(trUserEntity.getUserId());
					userValue.setUserName(trUserEntity.getUserName());
					userValue.setLastName(trUserEntity.getLastName());
					userValue.setFirstName(trUserEntity.getFirstName());
					userValue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trUserEntity.getCreateTime()));
					userList.add(userValue);
				}
			}
		}
		userListValue.setUserList(userList);
		return userListValue;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbs.service.IUserService#getUserById(com.bbs.model.value.user.
	 * UserCondValue)
	 */
	// @Override
	// public UserDetailValue getUserDetailById(UserCondValue userCondValue)
	// throws Exception {
	// UserDetailValue userDetailInfo = new UserDetailValue();
	// TrUserDetailEntity trUserDetailEntity =
	// userMapper.getUserDetailById(userDetailCondValue.getUserId());
	// if (trUserDetailEntity != null) {
	// userDetailInfo.setUserId(trUserDetailEntity.getUserId());
	// userDetailInfo.setUserAccount(trUserDetailEntity.getUserAccount());
	// userDetailInfo.setUserNickname(trUserDetailEntity.getUserNickname());
	// userDetailInfo.setUserRealName(trUserDetailEntity.getUserRealName());
	// userDetailInfo.setUserRank(trUserDetailEntity.getUserRank());
	// userDetailInfo.setUserHeadImg(trUserDetailEntity.getUserHeadImg());
	// userDetailInfo.setUserMood(trUserDetailEntity.getUserMood());
	// userDetailInfo.setUserEmail(trUserDetailEntity.getUserEmail());
	// userDetailInfo.setUserCreateTime(DateUtility.toStringDate("yyyy-MM-dd
	// HH:mm:ss", trUserDetailEntity.getUserCreateTime()));
	// userDetailInfo.setUserAge(trUserDetailEntity.getUserAge());
	// userDetailInfo.setUserGender(trUserDetailEntity.getUserGender());
	// userDetailInfo.setUserBirth(DateUtility.toStringDate("yyyy-MM-dd
	// HH:mm:ss", trUserDetailEntity.getUserBirth()));
	// userDetailInfo.setUserMajor(trUserDetailEntity.getUserMajor());
	// userDetailInfo.setUserSchool(trUserDetailEntity.getUserSchool());
	// userDetailInfo.setUserAddress(trUserDetailEntity.getUserAddress());
	// } else {
	// throw new Exception("该用户不存在");
	// }
	// return userDetailInfo;
	// }

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbs.service.IUserService#editUserDetail()
	 */
	@Override
	public void editUserInfo(EditUserCondValue editUserCondValue) throws Exception {
		UserCondValue userCondValue = new UserCondValue();
		userCondValue.setUserId(editUserCondValue.getUserId());
		TrUserEntity trUserEntity = userMapper.getUserById(userCondValue);
		// 检验用户是否存在
		if (trUserEntity != null) {
			userMapper.editUser(editUserCondValue);
		} else {
			throw new Exception("该用户不存在");
		}
	}

	@Override
	public void deleteUserInfo(String userId) {
		if (userId != null && !"".equals(userId)) {
			userMapper.deleteUserByUserId(userId);
		}
	}
}
