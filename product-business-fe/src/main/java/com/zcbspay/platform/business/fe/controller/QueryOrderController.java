package com.zcbspay.platform.business.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.business.fe.bean.BeanCopyUtil;
import com.zcbspay.platform.business.fe.bean.ResultBean;
import com.zcbspay.platform.business.order.service.OrderQueryService;

@Controller
@RequestMapping("/order")
public class QueryOrderController {
	private static final Logger logger = LoggerFactory.getLogger(QueryOrderController.class);

	@Autowired
	private OrderQueryService orderQueryService;
	
	@RequestMapping(value = "/queryOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean queryOrder(String merchNo, String orderId){
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryOrder(merchNo, orderId));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
	
	@RequestMapping(value = "/queryOrderByTN", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean queryOrderByTN(String tn){
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryOrderByTN(tn));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
	@RequestMapping(value = "/queryConcentrateCollectionOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean queryConcentrateCollectionOrder(String tn){
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryConcentrateCollectionOrder(tn));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询实时代收订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
	@RequestMapping(value = "/queryConcentratePaymentOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean queryConcentratePaymentOrder(String tn){
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryConcentratePaymentOrder(tn));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询实时代付订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
	@RequestMapping(value = "/queryConcentrateCollectionBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean queryConcentrateCollectionBatch(String merchNo, String batchNo, String txnDate){
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryConcentrateCollectionBatch(merchNo, batchNo, txnDate));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询批量代收订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
	@RequestMapping(value = "/queryConcentratePaymentBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean queryConcentratePaymentBatch(String merchNo, String batchNo, String txnDate){
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryConcentratePaymentBatch(merchNo, batchNo, txnDate));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询批量代付订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
}
