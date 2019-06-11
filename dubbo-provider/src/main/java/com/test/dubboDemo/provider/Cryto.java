package com.test.dubboDemo.provider;

//import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

/**
 * @Description:
 * 
 * @Copyright: Copyright (c) 2007 FFCS All Rights Reserved
 * 
 * @Company: 北京福富软件技术股份有限公司福州分公司
 * 
 * @author jizhp 2007-12-19
 * @version 1.00.000
 * @history
 * 
 */
//@Slf4j
public class Cryto {

    private static String algorithm = "DESede";

    private static String default_charset = "UTF-8";

    private static final String DE_SEDE = "DESede/CBC/PKCS7Padding";

    private static final String DES_NUMBER = "0102030405060708";

    private Cryto() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateAuthenticator(String source, String key) {
        return generateAuthenticator(source, key, default_charset);
    }

    public static String generateAuthenticator(String source, String key,
            String charset) {
        String s2 = null;
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            if (source != null) {
                messagedigest.update(source.getBytes(charset));
            }
            byte abyte0[] = messagedigest.digest();
            byte abyte1[] = Hex.decode(key);
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(DE_SEDE, "BC");
            cipher.init(1, new SecretKeySpec(abyte1, algorithm),
                    new IvParameterSpec(Hex.decode(DES_NUMBER)));
            byte abyte2[] = cipher.doFinal(abyte0);
            s2 = base64Encode(abyte2);
        } catch (Exception exception) {
//            log.error("生成Authenticator认证信息时出错!@" + exception.getMessage());
        }
        return s2;
    }

    public static byte[] SHA1(String source, String charset) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update(source.getBytes(charset));
            byte abyte0[] = messagedigest.digest();
            return abyte0;
        } catch (Exception exception) {
//            log.error("SHA-1出错!@" + exception.getMessage());
            return new byte[0];
        }
    }

    public static boolean validateAuthenticator(String s, String s1, String s2) {
        String s3 = generateAuthenticator(s1, s);
        return s2.equals(s3);
    }

    public static String encryptBase643DES(String source, String key) {
//        log.info("encryptBase643DES:{}",source);
//        log.info("encryptBase643DES1:{}",encryptBase643DES(source, key, default_charset));
        return encryptBase643DES(source, key, default_charset);


    }

    public static String encryptBase643DES(String source, String key,
            String charset) {
        try {
            byte abyte1[];
            byte abyte0[] = Hex.decode(key);
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(DE_SEDE, "BC");
            cipher.init(1, new SecretKeySpec(abyte0, algorithm),
                    new IvParameterSpec(Hex.decode(DES_NUMBER)));
            abyte1 = cipher.doFinal(source.getBytes(charset));
            return base64Encode(abyte1);
        } catch (Exception e) {
//            log.error("对字符串进行3DES加密时出错!@" + e.getMessage());
            return null;
        }
    }
    
    public static String decryptBase643DES(String source, String key) {
        return decryptBase643DES(source, key, default_charset);
    }

    public static String decryptBase643DES(String source, String key,
            String charset) {
        try {
            byte[] abyte1;
            byte[] abyte0 = Hex.decode(key);
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(DE_SEDE, "BC");
            cipher.init(2, new SecretKeySpec(abyte0, algorithm),
                    new IvParameterSpec(Hex.decode(DES_NUMBER)));

            byte[] base64ed = base64Decode(source);
            if (base64ed == null)
                return null;

            abyte1 = cipher.doFinal(base64ed);
            return new String(abyte1, charset);
        } catch (Exception e) {
//            log.error("对字符串进行3DES解密时出错!@");
        }

        return null;
    }

    public static byte[] base64Decode(String str) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            return  decoder.decode(str);
        } catch (Exception e) {
//            log.error("使用增强型BASE64编码格式对字符串进行解码时出错!" + e.getMessage());
        }
        return new byte[0];
    }

    public static String base64Encode(byte[] b) {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(b);
        } catch (Exception e) {
//            log.error("使用增强型BASE64编码格式对字节数组进行编码时出错!@" + e.getMessage());
        }
        return null;
    }

    public static String binToAscii(byte[] bySourceByte) {
        int len, i;
        byte tb;
        char high, tmp, low;
        StringBuilder result = new StringBuilder();
        len = bySourceByte.length;
        for (i = 0; i < len; i++) {
            tb = bySourceByte[i];

            tmp = (char) ((tb >>> 4) & 0x000f);
            if (tmp >= 10)
                high = (char) ('a' + tmp - 10);
            else
                high = (char) ('0' + tmp);
            result.append(high);
            tmp = (char) (tb & 0x000f);
            if (tmp >= 10)
                low = (char) ('a' + tmp - 10);
            else
                low = (char) ('0' + tmp);

            result.append(low);
        }
        return result.toString();
    }

    /**
     * 采用MD5对字符进行加密后返回(HEX格式)
     * 
     * @param str
     *            源字符串
     * @return String 返回加密后的字符串
     * 
     * 
     */
    public static String cryptMD5ToHEX(String str) {
        return cryptMD5ToHEX(str, default_charset);
    }

    /**
     * 采用MD5对字符进行加密后返回(HEX格式)
     * 
     * @param str
     *            源字符串
     * @return String 返回加密后的字符串
     * 
     * 
     */
    public static String cryptMD5ToHEX(String str, String charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex(md.digest(str.getBytes(charset)));
        } catch (NoSuchAlgorithmException e) {
//            log.error("" + e.getMessage());
            return null;
        } catch (UnsupportedEncodingException e) {
//            log.error("" + e.getMessage());
            return null;
        }
    }

    /**
     * 以十六进制的无符号整数形式返回一个整数参数的字符串表示形式
     * 
     * 
     * @param array
     *            字节数组
     * @return String 返回一个整数参数的字符串
     * 
     * 
     */
    public static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }
    }
