package com.zcbspay.platform.business.fe.controller.portal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.merchant.bean.FtpBean;
import com.zcbspay.platform.manager.merchant.service.FtpService;
import com.zcbspay.platform.portal.system.bean.FileBean;
import com.zcbspay.platform.portal.system.service.FileService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/ftp")
@SuppressWarnings("all")
public class FtpController {
	@Autowired
	private FtpService ftpService;
	@ResponseBody
	@RequestMapping("/query")
	public FtpBean query() {
		return ftpService.query();
	}
}
