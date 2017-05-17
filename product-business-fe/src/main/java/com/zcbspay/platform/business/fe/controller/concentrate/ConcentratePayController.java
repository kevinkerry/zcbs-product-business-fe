package com.zcbspay.platform.business.fe.controller.concentrate;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.business.concentrate.batch.service.BatchCollection;
import com.zcbspay.platform.business.concentrate.batch.service.BatchPayment;
import com.zcbspay.platform.business.concentrate.bean.BatchCollectionBean;
import com.zcbspay.platform.business.concentrate.bean.BatchPaymentBean;
import com.zcbspay.platform.business.concentrate.bean.FileContentBean;
import com.zcbspay.platform.business.concentrate.bean.RealtimeCollectionBean;
import com.zcbspay.platform.business.concentrate.bean.RealtimePaymentBean;
import com.zcbspay.platform.business.concentrate.realtime.service.RealtimeCollection;
import com.zcbspay.platform.business.concentrate.realtime.service.RealtimePayment;

import net.sf.json.JSONObject;

import com.zcbspay.platform.business.fe.bean.BeanCopyUtil;
import com.zcbspay.platform.business.fe.bean.ResultBean;
import com.zcbspay.platform.business.fe.utils.JSONUtils;

@Controller
@RequestMapping("/concentrate/pay")
public class ConcentratePayController {
	private static final Logger logger = LoggerFactory.getLogger(ConcentratePayController.class);

	@Autowired
	private RealtimeCollection realtimeCollection;
	@Autowired
	private RealtimePayment realtimePayment;
	@Autowired
	private BatchCollection batchCollection;
	@Autowired
	private BatchPayment batchPayment;

	@RequestMapping(value = "/realtimeCollection", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean realtimeCollection(String data) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class,
					realtimeCollection.pay(JSONUtils.fromJson(data, RealtimeCollectionBean.class)));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("实时代收服务异常！");
			return new ResultBean("BP003", "实时代收异常！");
		}
	}

	@RequestMapping(value = "/realtimePayment", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean realtimePayment(String data) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class,
					realtimePayment.pay(JSONUtils.fromJson(data, RealtimePaymentBean.class)));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("实时代付服务异常！");
			return new ResultBean("BP004", "实时代付异常！");
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/batchCollection", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean batchCollection(String data) {
		try {
			Map<String, Class> map = new HashMap<>();
			map.put("fileContent", FileContentBean.class);
			BatchCollectionBean batchCollectionBean = (BatchCollectionBean) JSONObject
					.toBean(JSONObject.fromObject(data), BatchCollectionBean.class, map);
			return BeanCopyUtil.copyBean(ResultBean.class, batchCollection.pay(batchCollectionBean));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("批量代收服务异常！");
			return new ResultBean("BP001", "批量代收异常！");
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/batchPayment", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean batchPayment(String data) {
		try {
			Map<String, Class> map = new HashMap<>();
			map.put("fileContent", FileContentBean.class);
			BatchPaymentBean batchPaymentBean = (BatchPaymentBean) JSONObject.toBean(JSONObject.fromObject(data),
					BatchPaymentBean.class, map);
			return BeanCopyUtil.copyBean(ResultBean.class, batchPayment.pay(batchPaymentBean));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("批量代收服务异常！");
			return new ResultBean("BP001", "批量代收异常！");
		}
	}
}
