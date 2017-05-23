package com.zcbspay.platform.business.fe.controller.portal;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.business.fe.bean.ResultBean;
import com.zcbspay.platform.portal.email.service.MailService;

@Controller
@RequestMapping("/mail")
public class EMailController {
	private static final Logger logger = LoggerFactory.getLogger(EMailController.class);

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean sendMail(String receiver, String subject, String maiBody){
		
		try {
			com.zcbspay.platform.portal.email.bean.ResultBean sourceBean = mailService.sendMail(receiver, subject, maiBody);
			if (sourceBean.isResultBool()) {
				return new ResultBean("邮件发送成功！");
			}else {
				logger.error("邮件发送失败！");
				return new ResultBean("", "邮件发送失败！");
			}
			
		} catch (Exception e) {
			logger.error("邮件发送失败！");
			return new ResultBean("", "邮件发送失败！");
		}
	}
	@RequestMapping(value = "/sendMailByTemplate", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean sendMailByTemplate(String receiver){
		
		try {
			String templateName = "template_1.ftl";
			Map<String, String> map = new HashMap<String, String>();
			map.put("content", "test");
			com.zcbspay.platform.portal.email.bean.ResultBean result = mailService.sendMailByTemplate(receiver, "test", map, templateName);
			System.out.println(result.toString());			
			if (result.isResultBool()) {
				return new ResultBean("邮件发送成功！");
			}else {
				logger.error("邮件发送失败！");
				return new ResultBean("", "邮件发送失败！");
			}
			
		} catch (Exception e) {
			logger.error("邮件发送失败！");
			return new ResultBean("", "邮件发送失败！");
		}
	}
}
