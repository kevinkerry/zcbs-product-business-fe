package com.zcbspay.platform.business.fe.controller.portal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.portal.query.statistics.bean.TxnsForPortalBean;
import com.zcbspay.platform.portal.query.statistics.service.QueryAndStatService;
import com.zcbspay.platform.portal.system.bean.UserBean;

import net.sf.json.JSONObject;

/**
 * 交易报表模块
 * 
 * @author: zhangshd
 * @date: 2017年5月2日 下午2:36:04
 * @version :v1.0
 */
@Controller
@RequestMapping(value="/queryAndStat", method = RequestMethod.POST)
@SuppressWarnings("all")
public class QueryAndStatController {

	@Autowired
	private QueryAndStatService queryAndStatService;

	// 交易明细报表 报表预查询功能，报表下载功能，生成的报表文件放入ftp服务器中并从ftp服务器中下载pck_forms_txns_deta
	/**
	 * 1.交易明细报表查询
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping(value="/txnsDeta", method = RequestMethod.POST)
	public Map<String, Object> txnsDeta(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.queryTxnsDeta(page, rows, txnsForPortalBean);
	}

	/**
	 * 2.交易明细生成excel报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsDetaExcelForms", method = RequestMethod.POST)
	public Map<String, Object> txnsDetaExcelForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsDetaExcelForms(txnsForPortalBean);
	}

	/**
	 * 3.交易明细生成Txt报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsDetaTxtForms", method = RequestMethod.POST)
	public Map<String, Object> txnsDetaTxtForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsDetaTxtForms(txnsForPortalBean);
	}

	// 交易汇总报表 报表预查询功能，报表下载功能，生成的报表文件放入ftp服务器中并从ftp服务器中下载pck_forms_txns_stat
	/**
	 * 1.交易汇总报表 报表预查询功能
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping(value="/txnsStat", method = RequestMethod.POST)
	public Map<String, Object> txnsStat(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.queryTxnsStat(page, rows, txnsForPortalBean);
	}

	/**
	 * 2.交易汇总报表生成excel报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsStatExcelForms", method = RequestMethod.POST)
	public Map<String, Object> txnsStatExcelForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsStatExcelForms(txnsForPortalBean);
	}

	/**
	 * 3.交易汇总报表功能生成Txt报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsStatTxtForms", method = RequestMethod.POST)
	public Map<String, Object> txnsStatTxtForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsStatTxtForms(txnsForPortalBean);
	}

	// 结算单报表 报表预查询功能，报表下载功能，生成的报表文件放入ftp服务器中并从ftp服务器中下载pck_forms_setl
	/**
	 * 1.结算单报表 报表预查询功能
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping(value="/txnsSetl", method = RequestMethod.POST)
	public Map<String, Object> txnsSetl(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.queryTxnsSetl(page, rows, txnsForPortalBean);
	}

	/**
	 * 2.结算单报表生成excel报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsSetlExcelForms", method = RequestMethod.POST)
	public Map<String, Object> txnsSetlExcelForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsSetlExcelForms(txnsForPortalBean);
	}

	/**
	 * 3.结算单报表功能生成Txt报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsSetlTxtForms", method = RequestMethod.POST)
	public Map<String, Object> txnsSetlTxtForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsSetlTxtForms(txnsForPortalBean);
	}

	// 对账单 报表预查询功能，报表下载功能，生成的报表文件放入ftp服务器中并从ftp服务器中下载pck_forms_bill
	/**
	 * 1.结算单报表 报表预查询功能
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping(value="/txnsBill", method = RequestMethod.POST)
	public Map<String, Object> txnsBill(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.queryTxnsBill(page, rows, txnsForPortalBean);
	}

	/**
	 * 2.结算单报表生成excel报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsBillExcelForms", method = RequestMethod.POST)
	public Map<String, Object> txnsBillExcelForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);
		return queryAndStatService.createTxnsBillExcelForms(txnsForPortalBean);
	}

	/**
	 * 3.结算单报表功能生成Txt报表文件放入ftp
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/txnsBillTxtForms", method = RequestMethod.POST)
	public Map<String, Object> txnsBillTxtForms(String page, String rows, String txnsForPortalBeanStr) {
		TxnsForPortalBean txnsForPortalBean=(TxnsForPortalBean) JSONObject.toBean(JSONObject.fromObject(txnsForPortalBeanStr),TxnsForPortalBean.class);		
		return queryAndStatService.createTxnsBillTxtForms(txnsForPortalBean);
	}

	/**
	 * 文件下载
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/downloadFile", method = RequestMethod.POST)
	public void downloadFile(String fileName, HttpServletRequest request,HttpServletResponse response,String packageName) {
		File file = queryAndStatService.downForms(fileName,packageName);
		String filenames = file.getName();
		InputStream inputStream;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();
			// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			os.write(buffer);// 输出文件
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取ftp文件信息
	 * 
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param txnsForPortalBean
	 * @return Map<String,Object>
	 * @date: 2017年5月2日 下午2:42:32
	 * @version v1.0
	 */
//	@ResponseBody
//	@RequestMapping(value="/getFileInfo", method = RequestMethod.POST)
	public Map<String, Object> getFileInfo(String packageName) {
		return queryAndStatService.getFileInfo(packageName);
		
	}
	
}
