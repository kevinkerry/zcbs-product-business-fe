package com.zcbspay.platform.business.fe.controller.portal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.portal.system.bean.UserBean;
import com.zcbspay.platform.portal.system.service.UserService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {
	private final String admin ="admin";
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("/queryUsers")
	public Map<String, Object> queryUsers(String userBeanStr, String page, String rows) {
		UserBean userBean=(UserBean) JSONObject.toBean(JSONObject.fromObject(userBeanStr),UserBean.class);
		return userService.queryUsers(userBean, page, rows);
	}
	@ResponseBody
	@RequestMapping("/saveUser")
	public Map<String, Object> saveUser(String userBeanStr) {
		UserBean userBean=(UserBean) JSONObject.toBean(JSONObject.fromObject(userBeanStr),UserBean.class);
		return userService.saveUser(userBean);
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public Map<String, Object> register(String userBeanStr) {
		UserBean userBean=(UserBean) JSONObject.toBean(JSONObject.fromObject(userBeanStr),UserBean.class);
		userBean.setLoginName(admin);
		userBean.setCreator("1");
		return userService.saveUser(userBean);
	}

	@ResponseBody
	@RequestMapping("/updateUser")
	public Map<String, Object> updateUser(String userBeanStr) {
		UserBean userBean=(UserBean) JSONObject.toBean(JSONObject.fromObject(userBeanStr),UserBean.class);
		Map<String, Object> message = userService.updateUser(userBean);
		return message;
	}
	/**
	 * 
	 * @author: zhangshd
	 * @param userBean
	 * @return Map<String,Object>
	 * @date: 2017年5月9日 下午1:28:44 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("/modifyPwd")
	public Map<String, Object> modifyPwd(String password,String passwordnew,String confirm_passwordnew,String userBeanStr) {
		UserBean userBean=new UserBean();
		UserBean loginUser=(UserBean) JSONObject.toBean(JSONObject.fromObject(userBeanStr),UserBean.class);
		userBean.setPwd(password);
		userBean.setMemberid(loginUser.getMemberid());
		userBean.setLoginName(loginUser.getLoginName());
		Map<String, Object> returnMap = userService.login(userBean);
		Map<String, Object> message =  new HashMap<>();
		if (returnMap.get("code").equals("00")) {
			loginUser.setPwd(passwordnew);
			message= userService.updateUser(loginUser);
		}else{
			message.put("RET", "error");
			message.put("INFO","更新失败");
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("/test")
	public Map<String, Object> saveUser(UserBean userBean, String page, String rows) {
		return userService.queryUsers(userBean, "1", "10");
	}
}
