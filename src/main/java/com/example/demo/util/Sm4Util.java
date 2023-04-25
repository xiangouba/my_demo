package com.example.demo.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * @Author gxx
 * @Date 2023年04月07日11时23分
 */
public class Sm4Util {
    private static String priKey = "369F5560201C4E11A2B825F9583C47F5";
    private static String pubKey = "369F5560201C4E11A2B825F9583C47F5";


    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String ENCODING = "UTF-8";
    public static final String ALGORITHM_NAME = "SM4";
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";
    public static final int DEFAULT_KEY_SIZE = 128;

    // 生成ECB暗号
    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_NAME);

        cipher.init(mode, sm4Key);
        return cipher;
    }

    // sm4加密
    public static String encryptEcb(String hexKey, String paramStr) {
        try {
            String cipherText = "";
            byte[] keyData = ByteUtils.fromHexString(hexKey);
            byte[] srcData = paramStr.getBytes(ENCODING);
            // 加密后的数组
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            cipherText = ByteUtils.toHexString(cipherArray);
            return cipherText;
        } catch (Exception e) {
            return paramStr;
        }
    }

    // sm4加密
    public static String encryptEcb(String paramStr) {
        try {
            String hexKey = priKey;
            if (hexKey == null) {
                hexKey = "JFF8U9wIpOMfs2Y3";
            }
            String cipherText = "";
            byte[] keyData = ByteUtils.fromHexString(hexKey);
            byte[] srcData = paramStr.trim().getBytes(ENCODING);
            // 加密后的数组
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            cipherText = ByteUtils.toHexString(cipherArray);
            return cipherText;
        } catch (Exception e) {
            return paramStr;
        }
    }

    // 加密模式之Ecb
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    // sm4解密
    public static String decryptEcb(String hexKey, String cipherText) {
        // 用于接收解密后的字符串
        String decryptStr = "";
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
        byte[] srcData = new byte[0];
        try {
            srcData = decrypt_Ecb_Padding(keyData, cipherData);
            decryptStr = new String(srcData, ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptStr;
    }

    // sm4解密
    public static String decryptEcb(String cipherText) {
        String hexKey = priKey;
        // 用于接收解密后的字符串
        String decryptStr = "";
        if (hexKey == null) {
            hexKey = "369F5560201C4E11A2B825F9583C47F6";
        }
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
        byte[] srcData = new byte[0];
        try {
            srcData = decrypt_Ecb_Padding(keyData, cipherData);
            decryptStr = new String(srcData, ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptStr;
    }

    // 解密
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }

    /**
     * @param hexKey 密钥 , cipherText  加密后数据，     paramStr  加密前数据，
     * @Return: 是否是同一数据，true，是，fale,否
     * @Description: 校验加密前后的字符串是否为同一数据
     */
    public static boolean verifyEcb(String hexKey, String cipherText, String paramStr) throws Exception {
        boolean flag = false;
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
        byte[] decryptData = decrypt_Ecb_Padding(keyData, cipherData);
        byte[] srcData = paramStr.getBytes(ENCODING);
        flag = Arrays.equals(decryptData, srcData);
        return flag;
    }
}
