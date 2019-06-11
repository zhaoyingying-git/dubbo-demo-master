package com.test.dubboDemo.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.crypto.Cipher;

import org.apache.commons.httpclient.HttpException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

//仅仅测试辅助类
@Slf4j
public class TestQuerySaleProductInGpCallwayHelper {
//	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	public SimpleDateFormat ymdHHMmSsFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public Random rand = new Random();

	public static void main(String[] args) throws  HttpException, IOException, Exception {

		TestQuerySaleProductInGpCallwayHelper  testHttpClient = new TestQuerySaleProductInGpCallwayHelper();

		testHttpClient.qurerySaleProduct();

	}


	// 测试给集团调用的查询销售品信息
	public void qurerySaleProduct() throws  HttpException, IOException, Exception {
		Map<String, String> requestMap = new HashMap<String, String>();
		
		JSONObject dataInJson = new JSONObject();
		dataInJson.put("cellPhone", "18102816388"); //18102816388 15322896606  13380710404 18102816388  销户:18122708447 //橙分期用户 13380710404   ，17722396364
		dataInJson.put("userIDCard", "");
		
		requestMap.put("data", dataInJson.toJSONString());
		commonSend("crmSaleProductQuery", requestMap);
//		logger.info("finish");
	}

	// 通用发送请求到集团
	public void commonSend(String functionName, Map<String, String> requestMap)
			throws HttpException, IOException, Exception {

//		logger.info("Current call api is:" + functionName);
		try {
//			String path = "D:\\workspace_wkutf8new\\biweb\\src\\main\\resources\\config\\encrypt";
//
//			String certFile = path + "\\gdups.cer";
//			String signFile = path + "\\gdlocalwaywx.p12";
//
//			InputStream resourceAsStream = new FileInputStream(signFile);
//
//			String passwd ="12345678";
//			String alias = null;
//			String keyStoreType = "PKCS12";
//			KeyCertInfo keyCertInfo = CryptoUtil.fileStreamToKeyCertInfo(resourceAsStream, passwd, keyStoreType, alias);
//
//			InputStream pubStream = new FileInputStream(certFile);
//
//			byte pubByte[] = new byte[2048];
//			pubStream.read(pubByte);
//			pubStream.close();
//			X509Certificate x509Certificate = CryptoUtil.base64StrToCert(Base64Encrypt.getBASE64ForByte(pubByte));
//
//			BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();
//			Signature signature = Signature.getInstance("SHA512withRSA", bouncyCastleProvider);

			// 公用的参数
			requestMap.put("channelCode", "20000052");
			requestMap.put("version", "1");
			requestMap.put("timestamp", ymdHHMmSsFormat.format(new Date()));
//			requestMap.put("tracelogID", UUIDUtil.get32UUID());
			requestMap.put("tracelogID", UUID.randomUUID().toString());


			//对data部分拿出来加密
			String dataInPlainText = requestMap.get("data");
//			if (dataInPlainText != null && dataInPlainText.trim().length() >0) {
//				byte[] dataBytes = CryptoUtil.enDecryptByRsa(dataInPlainText.getBytes("utf-8"),
//						x509Certificate.getPublicKey(), Cipher.ENCRYPT_MODE);
//
//				String dataBase64Str = Base64.getEncoder().encodeToString(dataBytes);
//
				requestMap.put("data", dataInPlainText);
//			}
//
//			String content = SignatureUtil.assembelSignaturingData(requestMap);
//
//			logger.info("验签原始数据：" + content);
			
//			String sign = SignatureUtil.sign(signature, content, (PrivateKey) keyCertInfo.getPrivateKey());
			requestMap.put("sign", "");
			System.out.println(JSON.toJSONString(requestMap));
			log.info("请求数据：" + JSON.toJSONString(requestMap));
			// --------------生成签名demo------------

			HttpRequest request = HttpRequest
					.post("http://14.146.225.221/biweb/gdyzfgpcallway/" + functionName)
					.body(JSON.toJSONString(requestMap).getBytes("utf-8"), "application/json");
			request.timeout(60000);
			HttpResponse response = request.send();
			int status = response.statusCode();
//			logger.info("响应status：" + status);
			if (status != 200) {
//				throw new BiWebException(BiwebRet.EsbHttpCallFail);
			}
			String retData = new String(response.bodyBytes(), "utf-8");
//			logger.info("响应数据：" + retData);
			JSONObject retDataInJson = JSONObject.parseObject(retData);
			System.out.println(retDataInJson);
			if (!retDataInJson.getBooleanValue("success")) {
//				throw new BiWebException(retDataInJson.getString("errorMsg"));
			}
			
			//对data部分拿出来解密
//			JSONObject resultInJson = (JSONObject)retDataInJson.get("result");
//			String respDataInText = resultInJson.getString("data");
//			if (respDataInText != null && respDataInText.trim().length() >0) {
//				byte[] respDataBytes = CryptoUtil.enDecryptByRsa(Base64.getDecoder().decode(respDataInText),
//						 (PrivateKey) keyCertInfo.getPrivateKey(), Cipher.DECRYPT_MODE);
//
//				String respDataInJsonStr = new String(respDataBytes, "utf-8");
//				JSONObject respDataInJsonObj = JSONObject.parseObject(respDataInJsonStr);
//				logger.info("解密处理data中的cellPhone：" + respDataInJsonObj.getString("cellPhone"));
//				logger.info("解密处理data中的userIDCard：" + respDataInJsonObj.getString("userIDCard"));
//				logger.info("解密处理data中的userName：" + respDataInJsonObj.getString("userName"));
//			}


		} catch (Exception ex) {
			log.error("Has Exception here:", ex);
		}
	}

	
}
