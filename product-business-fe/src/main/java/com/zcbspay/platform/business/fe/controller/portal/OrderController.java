package com.zcbspay.platform.business.fe.controller.portal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.portal.query.statistics.bean.TxnsForPortalBean;
import com.zcbspay.platform.portal.query.statistics.service.QueryAndStatService;

import net.sf.json.JSONObject;

/**
 * 交易报表模块
 * 
 * @author: zhangshd
 * @date: 2017年5月2日 下午2:36:04
 * @version :v1.0
 */
@Controller
@RequestMapping("/order")
@SuppressWarnings("all")
public class OrderController {

	@Autowired
	private QueryAndStatService queryAndStatService;
	
	/**
	 * 订单查询 页面
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年5月9日 上午9:41:25 
	 * @version v1.0
	 */
	@RequestMapping("showOrder")
	public String showOrder() {
		return "order/order";
	}
	/**
	 * 订单查询
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年5月9日 上午9:41:45 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping(value="/orderForBatchAndSingle", method = RequestMethod.POST)
	public Map<String, Object> orderForBatchAndSingle(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.orderForBatchAndSingle(page, rows, txnsForPortalBean);
	}
}
