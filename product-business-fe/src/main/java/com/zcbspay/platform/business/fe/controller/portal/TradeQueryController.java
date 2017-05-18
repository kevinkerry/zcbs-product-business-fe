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

import com.zcbspay.platform.business.fe.utils.JSONUtils;
import com.zcbspay.platform.portal.query.statistics.bean.TxnsForPortalBean;
import com.zcbspay.platform.portal.query.statistics.service.QueryAndStatService;

@Controller
@RequestMapping("/trade")
public class TradeQueryController {

	private static final Logger logger = LoggerFactory.getLogger(TradeQueryController.class);

	@Autowired
	private QueryAndStatService tradeService;

	@ResponseBody
	@RequestMapping(value = "/selTxnsSingle", method = RequestMethod.POST)
	public Map<String, Object> selTxnsSingle(String page, String rows, String data) {
		try {
			return tradeService.selTxnsSingle(page, rows, JSONUtils.fromJson(data, TxnsForPortalBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务异常！");
			Map<String, Object> mapRet = new HashMap<>();
			Map<String, Object> mapErr = new HashMap<>();
			mapErr.put("RET", "err");
			mapErr.put("INFO", "服务异常！");
			mapRet.put("tatal", 0);
			mapRet.put("rows", mapErr);
			return mapRet;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/selTxnsDeta", method = RequestMethod.POST)
	public Map<String, Object> selTxnsDeta(String page, String rows, String data) {
		try {
			return tradeService.selTxnsDeta(page, rows, JSONUtils.fromJson(data, TxnsForPortalBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务异常！");
			Map<String, Object> mapRet = new HashMap<>();
			Map<String, Object> mapErr = new HashMap<>();
			mapErr.put("RET", "err");
			mapErr.put("INFO", "服务异常！");
			mapRet.put("tatal", 0);
			mapRet.put("rows", mapErr);
			return mapRet;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/selTxnsInfo", method = RequestMethod.POST)
	public Map<String, Object> selTxnsInfo(String page, String rows, String data) {
		try {
			return tradeService.selTxnsInfo(page, rows, JSONUtils.fromJson(data, TxnsForPortalBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务异常！");
			Map<String, Object> mapRet = new HashMap<>();
			Map<String, Object> mapErr = new HashMap<>();
			mapErr.put("RET", "err");
			mapErr.put("INFO", "服务异常！");
			mapRet.put("tatal", 0);
			mapRet.put("rows", mapErr);
			return mapRet;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/selTxnsStat", method = RequestMethod.POST)
	public Map<String, Object> selTxnsStat(String data) {
		try {
			return tradeService.selTxnsStat(JSONUtils.fromJson(data, TxnsForPortalBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务异常！");
			Map<String, Object> mapRet = new HashMap<>();
			Map<String, Object> mapErr = new HashMap<>();
			mapErr.put("RET", "err");
			mapErr.put("INFO", "服务异常！");
			mapRet.put("tatal", 0);
			mapRet.put("rows", mapErr);
			return mapRet;
		}
	}
}
