package com.ulb.web.utils;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;



public class HttpUtils {

	private static Logger log = Logger.getLogger(HttpUtils.class);

	/**
	 * 
	 * @Title: PostUrl
	 * @Description: TODO(post请求)
	 * @param @param urlstr 请求地址
	 * @param @param paramMp 请求参数
	 * @param @param json 是否转为json参数
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String PostUrl(String urlstr, Map paramMp, Boolean json) {
		String resultString = "";
		try {
			/**
			 * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。 比如： // Using
			 * java.net.URL and //java.net.URLConnection
			 */
			URL url;
			url = new URL(urlstr);
			log.debug("请求：" + urlstr);
			HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
			/**
			 * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
			 * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
			 */
			connection.setDoOutput(true);

            connection.setRequestMethod("POST");
            String param="";
            if(json){
                // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
                /*
                 *  application/x-javascript text/xml->xml数据 
                 *  application/x-javascript->json对象 
                 *  application/x-www-form-urlencoded->表单数据
                 */
                connection.setRequestProperty("Content-Type", "application/json");
                param=JSONObject.fromObject(paramMp).toString();
            }else{
                param=maptoparam(paramMp);
            }
            log.debug("参数：" + param);
            
			/**
			 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
			 */
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "utf-8");
			out.write(param);// post的关键所在！
			out.flush();
			out.close();
			/**
			 * 这样就可以发送一个看起来象这样的POST： POST /jobsearch/jobsearch.cgi HTTP 1.0
			 * ACCEPT: text/plain Content-type:
			 * application/x-www-form-urlencoded Content-length: 99 username=bob
			 * password=someword
			 */
			// 一旦发送成功，用以下方法就可以得到服务器的回应：
			String sCurrentLine;
			String sTotalString;
			sCurrentLine = "";
			sTotalString = "";
			InputStream l_urlStream;
			l_urlStream = connection.getInputStream();
			// 传说中的三层包装阿！
			BufferedReader l_reader = new BufferedReader(new InputStreamReader(
					l_urlStream, "utf-8"));
			while ((sCurrentLine = l_reader.readLine()) != null) {
				sTotalString += sCurrentLine + "\r\n";
			}
			log.debug("返回：" + sTotalString);
			resultString = sTotalString;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultString;
	}

	public static String maptoparam(Map mapData) {
		String strparam = "";
		// 循环表名
		Set setKey = mapData.keySet();
		for (Object obj : setKey) {
			strparam += obj.toString() + "="
					+ mapData.get(obj.toString()).toString() + "&";
		}
		if (strparam.endsWith("&")) {
			strparam = strparam.substring(0, strparam.length() - 1);
		}
		return strparam;
	}



	public void test() {

		Map mp = new HashMap();
		// mp.put("userCode", "11302375");
		PostUrl("http://www.baidu.com", mp, false);

		// PostUrl("http://10.152.72.116:8080/fprs/apps/fprs/expressCount.do?method=expressCount",
		// new HashMap<String, String>(), false);
	}
}
