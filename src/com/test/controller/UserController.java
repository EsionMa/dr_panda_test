/**
 * 2017年2月28日 下午1:33:17
 */
package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.constants.UrlConstants;
import com.test.model.form.user.DeleteUserForm;
import com.test.model.form.user.DetailUserForm;
import com.test.model.form.user.EditUserForm;
import com.test.model.form.user.UserlistForm;
import com.test.model.value.user.UserCondValue;
import com.test.model.value.user.UserListCondValue;
import com.test.model.value.user.UserListValue;
import com.test.model.value.user.UserValue;
import com.test.service.IUserService;
import com.test.utility.StringUtility;

/**
 * @author Esion
 *
 */
@Controller
public class UserController extends CommonController {

	@Autowired
	private IUserService userService;

	/**
	 * 用户列表（数据分页）
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param userListForm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(UrlConstants.WEB_USER_LIST)
	public String showUserList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, UserlistForm userListForm) throws Exception {
		// 自动登录
		autoLogin(request, response);
		// 检测登录
		UserValue userInfo = getSessionUser(request);
		if (userInfo == null || StringUtility.isEmptyAfterTrim(userInfo.getUserId())) {
			// 重定向Url
			return "redirect:" + "/login";
		}

		try {
			UserListCondValue userListCondValue = new UserListCondValue();
			userListCondValue.setUserId(userInfo.getUserId());
			if (!StringUtility.isEmptyAfterTrim(userListForm.getSearchKey())) {
				userListCondValue.setSearchKey(userListForm.getSearchKey());
			} else {
				userListCondValue.setSearchKey("");
			}
			if (StringUtility.isInteger(userListForm.getPageNum())) {
				userListCondValue.setPageNum(Integer.valueOf(userListForm.getPageNum()));
			} else {
				userListCondValue.setPageNum(1);
			}
			UserListValue userListValue = userService.getUserList(userListCondValue);
			modelMap.put("searchKey", userListForm.getSearchKey());
			modelMap.put("userListValue", userListValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user_manage/user_list";
	}

	/**
	 * 用户编辑
	 * 
	 * @param request
	 * @param response
	 * @param editUserForm
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = UrlConstants.WEB_USER_EDIT, method = RequestMethod.POST)
	public String editlUser(HttpServletRequest request, HttpServletResponse response, EditUserForm editUserForm, ModelMap modelMap) {
		if (editUserForm != null && !"".equals(editUserForm.getUserId())) {
			UserCondValue userDetailCondValue = new UserCondValue();
			userDetailCondValue.setUserId(editUserForm.getUserId());
			try {
				// UserDetailValue userDetailInfo =
				// userService.getUserDetailById(userDetailCondValue);
				// request.setAttribute("userDetailInfo", userDetailInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "user_manage/user_edit";
	}

	// /**
	// * 编辑用户页面保存用户信息
	// */
	// @RequestMapping("user/doedit")
	// public void doEditUser(HttpServletRequest request, HttpServletResponse
	// response, EditUserForm editUserForm, ModelMap modelMap) {
	// try {
	// EditUserCondValue editUserCondValue = new EditUserCondValue();
	// editUserCondValue.setUserAddress(editUserForm.getAddress());
	// editUserCondValue.setUserAge(editUserForm.getAge());
	// if (StringUtility.isEmptyAfterTrim(editUserForm.getBirth())) {
	// editUserCondValue.setUserBirth(null);
	// } else {
	// editUserCondValue.setUserBirth(Timestamp.valueOf(editUserForm.getBirth()));
	// }
	// editUserCondValue.setUserHeadImg(editUserForm.getHeadImg());
	// editUserCondValue.setUserEmail(editUserForm.getEmail());
	// editUserCondValue.setUserGender(editUserForm.getGender());
	// editUserCondValue.setUserMajor(editUserForm.getMajor());
	// editUserCondValue.setUserMood(editUserForm.getMood());
	// editUserCondValue.setUserNickname(editUserForm.getNickname());
	// editUserCondValue.setUserRealName(editUserForm.getRealName());
	// editUserCondValue.setUserSchool(editUserForm.getSchool());
	// editUserCondValue.setUserId(editUserForm.getUserId());
	// userService.editUserInfo(editUserCondValue);
	// PrintWriter writer = response.getWriter();
	// writer.write("success");
	// writer.flush();
	// writer.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 用户详情
	 * 
	 * @param request
	 * @param response
	 * @param detailUserForm
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = UrlConstants.WEB_USER_DETAIL, method = RequestMethod.POST)
	public String detailUser(HttpServletRequest request, HttpServletResponse response, DetailUserForm detailUserForm, ModelMap modelMap) {
		if (detailUserForm != null && !"".equals(detailUserForm.getUserId())) {
			UserCondValue userDetailCondValue = new UserCondValue();
			userDetailCondValue.setUserId(detailUserForm.getUserId());
			try {
				// UserDetailValue userDetailInfo =
				// userService.getUserDetailById(userDetailCondValue);
				// List<UserDetailValue> friendList =
				// userService.getUserFriendByUserId(userDetailCondValue);
				// request.setAttribute("userDetailInfo", userDetailInfo);
				// request.setAttribute("friendList", friendList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "user_manage/user_detail";
	}

	/**
	 * 用户删除
	 * 
	 * @param request
	 * @param response
	 * @param deleteUserForm
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = UrlConstants.WEB_USER_DELETE, method = RequestMethod.POST)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response, DeleteUserForm deleteUserForm, ModelMap modelMap) {
		if (deleteUserForm != null && !"".equals(deleteUserForm.getUserId())) {
			UserCondValue userDetailCondValue = new UserCondValue();
			userService.deleteUserInfo(deleteUserForm.getUserId());
		}
	}
}
