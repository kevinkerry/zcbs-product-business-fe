package com.zcbspay.platform.business.fe.controller.portal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.portal.system.bean.UserBean;
import com.zcbspay.platform.portal.system.service.UserService;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping("/login")
@SuppressWarnings("all")
public class LoginController {

    @Autowired
	private UserService userService;
    
    
    
    /**
	 * 验证用户登录信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/test")
	public void test(UserBean userBean,HttpServletRequest request,String randcode) {
		userBean.setCreateTime("19891212");
		userBean.setCreator("1");
		userBean.setEmail("bema@126.com");
		userBean.setMemberid("121212");
		userBean.setPwd("123");
		userBean.setUserName("bema");
		userBean.setLoginName("bema");
		userBean.setUserId("2");
		//System.out.println(JSONUtils.valueToString(userService.saveUser(userBean)));
		//System.out.println(JSONUtils.valueToString(userService.updateUser(userBean)));
		//System.out.println(JSONUtils.valueToString(userService.queryUsers(userBean, "1", "10")));
		System.out.println(JSONUtils.valueToString(userService.login(userBean)));
	}

	/**
	 * 验证用户登录信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Map<String, Object> validateUser(String userBeanStr) {
		UserBean user=(UserBean) JSONObject.toBean(JSONObject.fromObject(userBeanStr), UserBean.class);
		Map<String, Object> returnmap = userService.login(user);
		return returnmap;
	}
}
