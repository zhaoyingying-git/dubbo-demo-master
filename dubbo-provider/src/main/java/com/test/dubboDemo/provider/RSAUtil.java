package com.test.dubboDemo.provider;


import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(512,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        System.out.println("随机生成的公钥为:"+publicKeyString);
        System.out.println("随机生成的私钥为:"+privateKeyString);
    }

    /**
     * RSA公钥加密
     * @param str 加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception  加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     * @param str 加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception  解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey){
        String outStr = "";
        try {
            //64位解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
            //base64编码的私钥
            byte[] decoded = Base64.decodeBase64(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            outStr = new String(cipher.doFinal(inputByte));
        } catch (Exception e) {
            outStr = "";
            e.printStackTrace();
        }
        return outStr;
    }

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();

//        String publicKeyString ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJjvHmYfb5j2G/q3UUJzIUBlvStYZtZ4yUKFDaLimG2HT9kUtFjTiN9Bdbf4QIBl0uSF4O+QtSRMuTolJUY4jqkCAwEAAQ==";
//        String privateKeyString ="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAmO8eZh9vmPYb+rdRQnMhQGW9K1hm1njJQoUNouKYbYdP2RS0WNOI30F1t/hAgGXS5IXg75C1JEy5OiUlRjiOqQIDAQABAkAvNJfYg9mJiGXohI8jiK/51a2HZJkRmGTfEHy+C11raP9ST/BjQ03MzsiZh3G4kGx1IYdZ/sWl/EhiWVa9NaCRAiEA1o8FA8NziBZ6wD1/F1x1U6KbZNxLvDqk0T5+X/kydjUCIQC2eQihzL62iRAkKynI5fPzoHMg2caXITzqUPNIRjK1JQIhANGybkBDYkL7VXVVpUT7xF+9aQqmlA6fcj5fSbwbHcqRAiAEF8bnyi3k7kIcbZNsXCwSpOCwNfJMZYR2RQaP8nMkuQIgSgAnMMsUXL+B4SLEi2K5CBUJ+GnquMjbI820ic+8dV0=";
//
//        String message = "\"cellPhone\":\"18980086886\"";
//        String messageEn = encrypt(message,publicKeyString);
//        System.out.println(message + "加密后的字符串为:" + messageEn);
//        String messageDe = decrypt(messageEn,privateKeyString);
//        System.out.println("还原后的字符串为:" + messageDe);
    }
}
