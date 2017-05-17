package com.zcbspay.platform.business.fe.controller.concentrate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/queryOrder/{merchNo}/{orderId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean queryOrder(@PathVariable("merchNo") String merchNo, @PathVariable("orderId") String orderId) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryOrder(merchNo, orderId));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}

	@RequestMapping(value = "/queryOrderByTN/{tn}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean queryOrderByTN(@PathVariable("tn") String tn) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryOrderByTN(tn));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}

	@RequestMapping(value = "/queryConcentrateCollectionOrder/{tn}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean queryConcentrateCollectionOrder(@PathVariable("tn") String tn) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryConcentrateCollectionOrder(tn));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询实时代收订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}

	@RequestMapping(value = "/queryConcentratePaymentOrder/{tn}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean queryConcentratePaymentOrder(@PathVariable("tn") String tn) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, orderQueryService.queryConcentratePaymentOrder(tn));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询实时代付订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}

	@RequestMapping(value = "/queryConcentrateCollectionBatch/{merchNo}/{batchNo}/{txnDate}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean queryConcentrateCollectionBatch(@PathVariable("merchNo") String merchNo,
			@PathVariable("batchNo") String batchNo, @PathVariable("txnDate") String txnDate) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class,
					orderQueryService.queryConcentrateCollectionBatch(merchNo, batchNo, txnDate));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询批量代收订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}

	@RequestMapping(value = "/queryConcentratePaymentBatch/{merchNo}/{batchNo}/{txnDate}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean queryConcentratePaymentBatch(@PathVariable("merchNo") String merchNo,
			@PathVariable("batchNo") String batchNo, @PathVariable("txnDate") String txnDate) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class,
					orderQueryService.queryConcentratePaymentBatch(merchNo, batchNo, txnDate));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询批量代付订单服务异常!");
			return new ResultBean("PC013", "订单服务异常!");
		}
	}
}
