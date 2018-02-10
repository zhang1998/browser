package com.uc.webview.export.cd;

import android.util.Base64;
import com.uc.webview.export.cd.platform.Log;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* compiled from: ProGuard */
public class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator instance = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        instance.initialize(1024);
        KeyPair generateKeyPair = instance.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        Map<String, Object> hashMap = new HashMap(2);
        hashMap.put(PUBLIC_KEY, rSAPublicKey);
        hashMap.put(PRIVATE_KEY, rSAPrivateKey);
        return hashMap;
    }

    public static String sign(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM);
        instance.initSign(generatePrivate);
        instance.update(bArr);
        return Base64.encodeToString(instance.sign(), 0);
    }

    public static boolean verify(byte[] bArr, String str, String str2) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM);
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(Base64.decode(str2, 0));
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, PrivateKey privateKey) throws Exception {
        byte[] doFinal;
        Cipher instance = Cipher.getInstance(KEY_ALGORITHM);
        instance.init(2, privateKey);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > 128) {
                doFinal = instance.doFinal(bArr, i2, 128);
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= 128;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        byte[] doFinal;
        Cipher instance = Cipher.getInstance(KEY_ALGORITHM);
        instance.init(2, publicKey);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > 128) {
                doFinal = instance.doFinal(bArr, i2, 128);
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= 128;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static byte[] encryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        byte[] doFinal;
        Cipher instance = Cipher.getInstance(KEY_ALGORITHM);
        instance.init(1, publicKey);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > MAX_ENCRYPT_BLOCK) {
                doFinal = instance.doFinal(bArr, i2, MAX_ENCRYPT_BLOCK);
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= MAX_ENCRYPT_BLOCK;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, PrivateKey privateKey) throws Exception {
        byte[] doFinal;
        Cipher instance = Cipher.getInstance(KEY_ALGORITHM);
        instance.init(1, privateKey);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > MAX_ENCRYPT_BLOCK) {
                doFinal = instance.doFinal(bArr, i2, MAX_ENCRYPT_BLOCK);
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= MAX_ENCRYPT_BLOCK;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        return Base64.encodeToString(((Key) map.get(PRIVATE_KEY)).getEncoded(), 0);
    }

    public static String getPublicKey(Map<String, Object> map) throws Exception {
        return Base64.encodeToString(((Key) map.get(PUBLIC_KEY)).getEncoded(), 0);
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    public static PrivateKey getPrivateKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
    }

    public static String getKeyString(Key key) throws Exception {
        return Base64.encodeToString(key.getEncoded(), 0);
    }

    public static String encrypt(String str, String str2) {
        new StringBuilder("data: ").append(str2).append(" pubKey: ").append(str);
        if (str2 == null || str == null) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = new String(decryptByPublicKey(Base64.decode(str2, 0), getPublicKey(str)));
            Log.d(CDController.JSON_CD_ENCRYPT_KEY, "rsa time: " + (System.currentTimeMillis() - currentTimeMillis) + " milliseconds");
            return str3;
        } catch (Throwable e) {
            Log.printStackTraceString("cd exception encryptjson data ", e);
            return null;
        }
    }
}
