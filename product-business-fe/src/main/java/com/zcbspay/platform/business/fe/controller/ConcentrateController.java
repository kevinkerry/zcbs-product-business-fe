package com.zcbspay.platform.business.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.business.concentrate.batch.service.BatchCollection;
import com.zcbspay.platform.business.concentrate.batch.service.BatchPayment;
import com.zcbspay.platform.business.concentrate.bean.RealtimeCollectionBean;
import com.zcbspay.platform.business.concentrate.bean.RealtimePaymentBean;
import com.zcbspay.platform.business.concentrate.bean.ResultBean;
import com.zcbspay.platform.business.concentrate.realtime.service.RealtimeCollection;
import com.zcbspay.platform.business.concentrate.realtime.service.RealtimePayment;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;


@Controller
@RequestMapping("/concentrate")
public class ConcentrateController {
	private static final Logger logger = LoggerFactory.getLogger(ConcentrateController.class);

	@Autowired
	private RealtimeCollection realtimeCollection;
	@Autowired
	private RealtimePayment realtimePayment;
	@Autowired
	private BatchCollection batchCollection;
	@Autowired
	private BatchPayment batchPayment;
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject realtimeCollection(String data){
		try {
			RealtimeCollectionBean realtimeCollectionBean = com.zcbspay.platform.business.fe.utils.JSONUtils.fromJson(data, RealtimeCollectionBean.class);
			ResultBean resultBean= realtimeCollection.pay(realtimeCollectionBean);
			return JSONObject.fromObject(resultBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("实时代收服务异常！");
			return JSONObject.fromObject(new ResultBean("BP003", "实时代收异常！"));
		}
	}
	
	@RequestMapping(value = "/pay1", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject realtimePayment(String data){
		try {
			RealtimePaymentBean realtimePaymentBean = com.zcbspay.platform.business.fe.utils.JSONUtils.fromJson(data, RealtimePaymentBean.class);
			ResultBean resultBean= realtimePayment.pay(realtimePaymentBean);
			return JSONObject.fromObject(resultBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("实时代付服务异常！");
			return JSONObject.fromObject(new ResultBean("BP004", "实时代付异常！"));
		}
	}
}

