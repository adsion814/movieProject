package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082600314901";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC5q4VvTUBz0vGyJRbaOnyWODyBDqYum3Zma0NS8EviOZj4/lPWN1v8IYjHZDv31ec+kSB+YtKaFTvBh/FVac4Xkk0mUdSbjTW6U8BiSWq4jKPe9tInB0gPDdzgxkpSQWnSAhmlJh3eYEWpHKePnbWse/398kwlmkrwFrEFx2yBcoaxVGr2arLoJYEDaBCHo+obwYd9NLL8DUWgsUzxfFd6O/7jClZ359wvVyvfPRDfNJbEhj1NcYrmkMuZdTkhExz4Cme3PweZsh1QtmhVxpOlHnuZRkBfvzMRzZZstuupKfMSxASyjHUY0zm2jXyZ+xp2FLQQ1FOd3aMtINWp/VExAgMBAAECggEBAJtCjgNj0zjHteslTrXQYKxxfE7jhB3HTLwaiCLL5HjZd00Hx+2DP31YQXuTGv6FNalBTK3DT58fkGemmS22m2tkoPUhSquE6t/T9zV5dS+8E7B4L4YJdb149zJTPoUIREgkD3PlquZxFO90kb3rwKbqzJtVyU1Md8vK/d76Q4b+ZErcW6mBv9Z8PD/NOw32Z3/DIl1APDPS8U72HptceOLPD61Nl8pShFv1UXxMNQXgbV299BLUlkwJ8zuF5l5pZ1KfE7l41bzWFexFMD3ileac+EOHjVXPYsHcgZzSMsYW2ZaH+FDl4AUyqz+wDiRlYugqPNlDiCZ1mMVbIJVQm60CgYEA4RB12PnphuRgo2sWW+9DFpMkWyoV0SW7+FcOx/7W5wJJWwyneGRVkHd52fuKAgGHzm31e+fzi5WlAohCio8T47zCDjVtMhYiddp/przwJkNRYgk+0oO7Gfnz+rBL9k7QOxBPV2X2CX28iPL7MtDGvFoq8rgvLNkfeZk7faupyjcCgYEA0zDbxj6bHCQAHzseygkVrDIwDTBXFbm29SaCbzEDGOd19hoC0iffFDw41TI4areDXt1VwN/Q2eaiYmZO2tpA2zLakExynR5+hWIVt/SFhZGotN3BWLrEZKZg+Z4ofO92zIrxdiQvT8YlLvFcz+7/VUvi7jKRWRQGYRiX47pc69cCgYBBn5ANHQl3eH2pCJ9zXPc9zNeL8WB9JDiDt7aqn+a/Ys5KywzFsNO2FPAlnA9oeFPF4A/0+fPsXkzHyT1Fs2REQhR/GhrlwMh5fqU709ld/sDrCfEUZq6Wa2g1T1RG1EIpBp9rx2IO8GeZsueFsJRR9SSSsxumQwTHauOKyBPwzwKBgBBY+toopHcULlI8kFCRTXUr2V5b/JG483mchoI26Ad4e0AWmVtNLM5zLu8J2SYhmHCyb13jtVX4rV8yji4QsO6GzDZZRJH291I52naH3gIN2WJOvBWzN1qXKnCIFpg9LRP+OVysxmDFdMFie4248VjX6/QGRAwCKdBASBmfpmu3AoGAf1W7bGqM+tQ4z4W8FVVQ3ZoaakrnDACrQF77InOk7VprH0P1dXIdSSY+vMji/pYper5z19iLM/KXDz+tlbj0XQCexKopCj4dcVgtgVPsSK4zOjF7ODDRloS2LnwRmkTNqMei9nPGH0OGEPwGKx0eTC4WLE57xzFZ7yf973JG5sU=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu6eXSROZvK8ee4fEagGtfsYsDBrLpm1b6h1RKvmOaInjq6a17nkHDI+RZaY9u5GlEVOoFQE+c7w9+CAW5M8TvGyMohUN3vxQmhcEqoCwxS1guWBJv/Kwa8TbVfQ8xWfBEFhtzxlaiOpshreWxCjG62VtphdtZCHNz2fTdawNm/kQedCnALSpDb5SbzV+qPmLuDxHcSgMEfFs8MkVisskhxgnXALGLCLdDGWQuPLIaDsbqJ3yb6x1UWIb19RSdFyKDEgOBnHiQulC7Lfq20FoQCjOyP2BLLENusDaDLcuch3YFHhQMC8NwAYTNVgbt8dlmHZtuP4oO1Hk4QyMb+oyDwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://linwanmin.jios.org:8008/movieProject/payState";


	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://linwanmin.jios.org:8008/movieProject/payResult";


	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

