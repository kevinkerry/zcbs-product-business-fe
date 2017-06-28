package com.zcbspay.platform.business.fe.controller.portal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.portal.system.bean.FileBean;
import com.zcbspay.platform.portal.system.service.FileService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/file")
@SuppressWarnings("all")
public class FileController {
	private final String admin ="admin";
	@Autowired
	private FileService fileService;
	@ResponseBody
	@RequestMapping("/queryFiles")
	public Map<String, Object> queryFiles(String fileBeanStr, String page, String rows) {
		FileBean fileBean=(FileBean) JSONObject.toBean(JSONObject.fromObject(fileBeanStr),FileBean.class);
		return fileService.queryFiles(fileBean, page, rows);
	}
	@ResponseBody
	@RequestMapping("/saveFile")
	public Map<String, Object> saveFile(String fileBeanStr) {
		FileBean fileBean=(FileBean) JSONObject.toBean(JSONObject.fromObject(fileBeanStr),FileBean.class);
		return fileService.saveFile(fileBean);
	}
}
