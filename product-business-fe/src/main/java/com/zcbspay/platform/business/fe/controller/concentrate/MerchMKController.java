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

import com.zcbspay.platform.member.merchant.bean.MerchMK;
import com.zcbspay.platform.member.merchant.service.MerchMKService;

/**
 * 商户
 * @author: zhangshd
 * @date:   2017年5月17日 下午1:51:42   
 * @version :v1.0
 */
@Controller
@RequestMapping("/merch")
public class MerchMKController {
	@Autowired
	private MerchMKService merchMKService;
	/**
	 * 
	 * @author: zhangshd
	 * @param data
	 * @return MerchMK
	 * @date: 2017年5月17日 上午9:02:21 
	 * @version v1.0
	 */
	@RequestMapping(value = "/mk", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> realtimeCollection(String data){
		MerchMK merchMk = merchMKService.get(data);
		Map<String, Object> re=new HashMap<>();
		re.put("localpub", merchMk.getLocalPubKey());
		re.put("localpri", merchMk.getLocalPriKey());
	    return re;
	}
}

