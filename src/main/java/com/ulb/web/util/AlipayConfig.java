package com.ulb.web.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088121767113621";
	
	// 收款支付宝账号，一般情况下收款账号就是签约账号
	public static String seller_email = "caiwu@wannengxiaoge.com";
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = seller_email;
	// 商户的私钥
	public static String KEY = "epucylexxn22qymeasnxswh7i9pnjq1t";
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "d:\\";
	
	// notify_url 交易过程中服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	public static String notify_url = "";
	// 支付宝的公钥，无需修改该值
	public static String ALIPAY_PUBLIC_KEY_APP  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	// 付完款后跳转的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	public static String return_url = "";

	// 网站商品的展示地址，不允许加?id=123这类自定义参数
	public static String show_url = "";
	 
	//收款方名称，如：公司名称、网站名称、收款人姓名等
	public static String mainname = "";
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	


	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	
	//访问模式,根据自己的服务器是否支持ssl访问，若支持请选择https；若不支持请选择http
    public static String transport = "http";
    
    // 签名方式 不需修改
	public static String sign_type_md5 = "MD5";
	
	public static String sign_type = "RSA";//扫码支付
	/**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET          = "GBK";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";
    /** 服务窗appId  */
    public static final String APP_ID            = "2016011201085543";
    
    //TODO !!!! 注：开发者必须设置自己的公钥 ,否则会存在安全隐患
//    public static final String PRIVATE_KEY       = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIOdoCVrr/bWnmPEaDYoPJSH7cfrtGBTMFQjeE2v73GlTEWPjJNs7T6aTPcmXNeIiyLmLzOL8AgArrn2pjgpw04nIetW3ZaiczrRzK3E+zadfEDf4KighWgGeYVgLRfNYirDBnaqQMk3XcvDhYoF6hTZWg4q8ABNcvXTI4FLGWtVAgMBAAECgYBdbCp7xWee55KAMK7kGkV+DMo8iVN8uC/q2U6QnlxxJ6rvCUj4cG4qbK5LFID8QKC6gfdpOGCF3a4otCoiXYqSTxEUuntEqS5rtovxvW/fP3TPLZ3DFFIwt2F7np6dvRQ5sLqRvHWNS4r716XDXfxV/BsflEwaaxAOZ4/6uG1nVQJBAMC28NxyRb/9MdrEufKDjMcuZEnw1TjSJVyuKlS8eSdTvq12viH+ZWeFHYcq9U8ZVN0vKEWUBmCHV8qZlyKS2RMCQQCu1j8cMG0bkQuB8WHtNvs80lRXqIMvfsyDco06JjAdUJfULs187qwSrMN2nhwWQf+8gFSPv7YFfqcfAYHRF173AkEAqVxcwq9eYwJl3OfErr8zahx4II8ZI61zDkc1hnB4XLp5OULAh2llvps6vv5exVvyu8tkrfkPvadT3QYrz0OUpwJBAK2kSV+01Ng5EQXId6rCHXoFpxC8YzYLqBCw94SWItkqjvCEXz/CR5Hwldy8IUcV22kax2FRVPVWGaMYuxawMHcCQGir3STI2uP/RIcShyA12ZfwzYRbJqtAVt3C991l8piDrf5n0lxtSP1TeFZ/L5zjDjCGEveNa5HJuj4re8xhyps=";
    public static final String PRIVATE_KEY       = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK3nOBSC9RJVFT52"+
    "49mEKt0vXTKqgmrzeQwdsx35EuV7+b7sOKSOh3wukvvcRKaAwa6VbGzAC9Is2DP3"+
    "wOpfXMcmbA2PSxNcw5Oo7fyLdVUAaXrovuFddMq/Zyb04uy0qssgSkofR+SFyd8t"+
    "JApBeMwWhnG7qBIHufdb4NPqOPs9AgMBAAECgYEAokiRluKWnKL1jjMYcdXawkn+"+
    "6NchmXjXzyywCBp1Pd4xs69xNG8llAdKduqYzeB93dPnOJ0G6v2aTPS4/H49brhj"+
    "yZfFk+M7IQFZVwIbfBiRY7JSsJWBdfFe2ad2ecr+80jWejZgACkkYxcWjH0MIV/Q"+
    "M6vsrqjGjV07F2VCnUECQQDivs5DlD2sipbOYvG/XRaYoQURONkSYAjwXZr+0M5T"+
    "9OWGpzwnSvToOVAMbD9pL7eeaFfr4rPF2/Rro6datx7lAkEAxFcVzqKeTCRxQs/b"+
    "Rej7/fUyqOQpIGKKl/B+f4SMBmBLYobSEtXauSFucDNvx1A1/5MMTrO8HYda1Z1n"+
    "oVbNeQJAKgh/Ci4P5M1oOWhEMlpaVv76hn/IVcyxu4VOt1AT/6JVbknQL+SIVAhT"+
    "24mxk5lB676iFdtXwiUNQWr8Gif6NQJAMmxnFlVfMBDf4Ze+KZsnNFaHdyZ5hW6p"+
    "R1IlOpyQ1YZfdeNICjxP2uHCGiCroVVxOLzMGV5BfpfndRripWXEiQJAYqD2Q+mV"+
    "vAFaeMS7lXg4d/qE72QUauJxeNGKwnNsPkDANouUUqYbGcQpWmkH/3YrZRhJGJAh"+
    "eqUNHjHntGU+Ig==";


	//TODO !!!! 注：开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDnaAla6/21p5jxGg2KDyUh+3H67RgUzBUI3hNr+9xpUxFj4yTbO0+mkz3JlzXiIsi5i8zi/AIAK659qY4KcNOJyHrVt2WonM60cytxPs2nXxA3+CooIVoBnmFYC0XzWIqwwZ2qkDJN13Lw4WKBeoU2VoOKvAATXL10yOBSxlrVQIDAQAB";
    /**支付宝公钥-从支付宝服务窗获取*/
    public static final String ALIPAY_PUBLIC_KEY_QR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    
 // 调用的接口名，无需修改即时到账
	//public static String service = "create_direct_pay_by_user";
	public static String service ="mobile.securitypay.pay";
	// 支付类型 ，无需修改
	public static String payment_type = "1";
	// MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public static String key = "";

	public static class RSA{

        public static final String  SIGN_ALGORITHMS = "SHA1WithRSA";

        /**
        * RSA签名
        * @param content 待签名数据
        * @param privateKey 商户私钥
        * @param input_charset 编码格式
        * @return 签名值
        */
        public static String sign(String content, String privateKey, String input_charset)
        {
            try
            {
                PKCS8EncodedKeySpec priPKCS8 	= new PKCS8EncodedKeySpec( Base64.decode(privateKey) );
                KeyFactory keyf 				= KeyFactory.getInstance("RSA");
                PrivateKey priKey 				= keyf.generatePrivate(priPKCS8);

                java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

                signature.initSign(priKey);
                signature.update( content.getBytes(input_charset) );

                byte[] signed = signature.sign();

                return Base64.encode(signed);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        /**
        * RSA验签名检查
        * @param content 待签名数据
        * @param sign 签名值
        * @param ali_public_key 支付宝公钥
        * @param input_charset 编码格式
        * @return 布尔值
        */
        public static boolean verify(String content, String sign, String ali_public_key, String input_charset)
        {
            try
            {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                byte[] encodedKey = Base64.decode(ali_public_key);
                PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


                java.security.Signature signature = java.security.Signature
                .getInstance(SIGN_ALGORITHMS);

                signature.initVerify(pubKey);
                signature.update( content.getBytes(input_charset) );

                boolean bverify = signature.verify( Base64.decode(sign) );
                return bverify;

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return false;
        }

        /**
        * 解密
        * @param content 密文
        * @param private_key 商户私钥
        * @param input_charset 编码格式
        * @return 解密后的字符串
        */
        public static String decrypt(String content, String private_key, String input_charset) throws Exception {
            PrivateKey prikey = getPrivateKey(private_key);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, prikey);

            InputStream ins = new ByteArrayInputStream(Base64.decode(content));
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            //rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
            byte[] buf = new byte[128];
            int bufl;

            while ((bufl = ins.read(buf)) != -1) {
                byte[] block = null;

                if (buf.length == bufl) {
                    block = buf;
                } else {
                    block = new byte[bufl];
                    for (int i = 0; i < bufl; i++) {
                        block[i] = buf[i];
                    }
                }

                writer.write(cipher.doFinal(block));
            }

            return new String(writer.toByteArray(), input_charset);
        }


        /**
        * 得到私钥
        * @param key 密钥字符串（经过base64编码）
        * @throws Exception
        */
        public static PrivateKey getPrivateKey(String key) throws Exception {

            byte[] keyBytes;

            keyBytes = Base64.decode(key);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            return privateKey;
        }
    }
}
