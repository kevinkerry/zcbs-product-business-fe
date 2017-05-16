package com.zcbspay.platform.business.fe.controller;

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
import com.zcbspay.platform.business.concentrate.bean.RealtimeCollectionBean;
import com.zcbspay.platform.business.concentrate.bean.RealtimePaymentBean;
import com.zcbspay.platform.business.concentrate.bean.ResultBean;
import com.zcbspay.platform.business.concentrate.realtime.service.RealtimeCollection;
import com.zcbspay.platform.business.concentrate.realtime.service.RealtimePayment;
import com.zcbspay.platform.support.signaturn.bean.AdditBean;
import com.zcbspay.platform.support.signaturn.bean.MessageBean;
import com.zcbspay.platform.support.signaturn.service.MessageDecodeService;
import com.zcbspay.platform.support.signaturn.service.MessageEncryptService;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;


@Controller
@RequestMapping("/sign")
public class SignatureController {
	private static final Logger logger = LoggerFactory.getLogger(SignatureController.class);

	@Autowired
	private MessageDecodeService messageDecodeService;
	@Autowired
	private MessageEncryptService messageEncryptService;
	/**
	 * 解密验签
	 * @author: zhangshd
	 * @param data
	 * @return MessageBean
	 * @date: 2017年5月16日 下午3:00:39 
	 * @version v1.0
	 */
	@RequestMapping(value = "/decode", method = RequestMethod.POST)
	@ResponseBody
	public MessageBean realtimeCollection(String data){
		MessageBean messageBean=(MessageBean) JSONObject.toBean(JSONObject.fromObject(data), MessageBean.class) ;
		MessageBean requestBean= messageDecodeService.decodeAndVerify(messageBean);
	    return requestBean;
	}
	/**
	 * 
	 * @author: zhangshd
	 * @param data
	 * @return MessageBean
	 * @date: 2017年5月16日 下午3:01:25 
	 * @version v1.0
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/encrypt", method = RequestMethod.POST)
	@ResponseBody
	public MessageBean realtimePayment(String enData,String additBean){
		AdditBean additBeang=(AdditBean) JSONObject.toBean(JSONObject.fromObject(additBean), AdditBean.class) ;
		MessageBean requestBean=null;
		try {
			requestBean = messageEncryptService.encryptAndSigntrue(enData, additBeang);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return requestBean;
	}
}

