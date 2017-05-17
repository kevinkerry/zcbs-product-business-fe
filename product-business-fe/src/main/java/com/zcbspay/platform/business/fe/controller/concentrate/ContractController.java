package com.zcbspay.platform.business.fe.controller.concentrate;

import java.util.HashMap;
import java.util.Map;

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
import com.zcbspay.platform.business.merch.bean.BatchImportFileContent;
import com.zcbspay.platform.business.merch.bean.BatchImportReqBean;
import com.zcbspay.platform.business.merch.service.ContractBizService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/contract")
public class ContractController {
	private static final Logger logger = LoggerFactory.getLogger(ContractController.class);
	
	@Autowired
	private ContractBizService contractBizService;
	
	@RequestMapping(value = "/findByCode/{contractNum}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findByCode(@PathVariable("contractNum") String contractNum) {
		try {
			return BeanCopyUtil.copyBean(ResultBean.class, contractBizService.findByCode(contractNum));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("合同服务异常!");
			return new ResultBean("BC004", "合同服务异常!");
		}
	} 
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/importBatchContract", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean importBatchContract(String data) {
		try {
			Map<String, Class> map = new HashMap<>();
			map.put("fileContents", BatchImportFileContent.class);
			BatchImportReqBean batchImportReqBean = (BatchImportReqBean) JSONObject.toBean(JSONObject.fromObject(data),
					BatchImportReqBean.class, map);
			return BeanCopyUtil.copyBean(ResultBean.class, contractBizService.importBatchContract(batchImportReqBean));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("合同服务异常!");
			return new ResultBean("BC004", "合同服务异常!");
		}
	}
}
