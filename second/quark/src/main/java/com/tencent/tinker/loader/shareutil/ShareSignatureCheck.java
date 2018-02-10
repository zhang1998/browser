package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* compiled from: ProGuard */
public class ShareSignatureCheck {
    private static final String TAG = "ShareSignatureCheck";
    private static PublicKey sPublicKey = null;

    public static boolean check(Context context, File file, Certificate[] certificateArr) {
        if (ganrantiInitPublicKey(context) && certificateArr.length > 0) {
            int length = certificateArr.length - 1;
            while (length >= 0) {
                try {
                    certificateArr[length].verify(sPublicKey);
                    return true;
                } catch (Throwable e) {
                    Log.e(TAG, file.getAbsolutePath(), e);
                    length--;
                }
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static boolean ganrantiInitPublicKey(Context context) {
        Throwable e;
        if (sPublicKey == null) {
            Closeable closeable = null;
            Closeable byteArrayInputStream;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                try {
                    sPublicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                    SharePatchFileUtil.closeQuietly(byteArrayInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e(TAG, "get publicKey fail.", e);
                        SharePatchFileUtil.closeQuietly(byteArrayInputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        closeable = byteArrayInputStream;
                        SharePatchFileUtil.closeQuietly(closeable);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayInputStream = null;
                Log.e(TAG, "get publicKey fail.", e);
                SharePatchFileUtil.closeQuietly(byteArrayInputStream);
                return false;
            } catch (Throwable th2) {
                e = th2;
                SharePatchFileUtil.closeQuietly(closeable);
                throw e;
            }
        }
        return true;
    }
}
