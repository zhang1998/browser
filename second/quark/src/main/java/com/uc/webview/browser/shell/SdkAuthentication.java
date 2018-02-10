package com.uc.webview.browser.shell;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.uc.webview.export.Build.Version;
import com.uc.webview.export.annotations.Jni;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IOpenFileChooser;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.UCMPackageInfo;
import java.io.Closeable;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import javax.crypto.Cipher;

/* compiled from: ProGuard */
public class SdkAuthentication {
    private static final String a = SdkAuthentication.class.getSimpleName();

    /* compiled from: ProGuard */
    final class a {
        private static String a;
        private static String b;
        private static String[] c;
        private static String d;
        private static String[] e;
        private static String f;
        private static HashMap<String, a> g = new b();

        /* compiled from: ProGuard */
        final class a {
            public String a;
            public String b;

            public a(String str, String str2) {
                this.a = str2;
                this.b = str;
            }
        }

        static /* synthetic */ boolean a() {
            Log.d(SdkAuthentication.a, "isFrameworkCompatible:" + VERSION.SDK_INT);
            return VERSION.SDK_INT <= 26;
        }

        static /* synthetic */ boolean a(UCMPackageInfo uCMPackageInfo) {
            return !new File(uCMPackageInfo.disabledFilePath).exists();
        }

        public static final boolean a(HashMap<String, Object> hashMap) {
            int intValue;
            if (hashMap != null) {
                Integer num = (Integer) hashMap.get(UCCore.OPTION_COMPATIBLE_POLICY);
                if (num != null) {
                    intValue = num.intValue();
                    Log.d(SdkAuthentication.a, "isArchCompatible: policy=" + intValue);
                    if (intValue == 0) {
                        return true;
                    }
                    Log.d(SdkAuthentication.a, "isArchCompatible: CPU_ARCH=" + Build.CPU_ARCH);
                    if (Build.CPU_ARCH.length() == 0) {
                        return false;
                    }
                    if (a("x86")) {
                        Log.d(SdkAuthentication.a, "isArchCompatible: device=x86");
                        if ((intValue & 4) != 0) {
                            if (Build.CPU_ARCH.startsWith("x86")) {
                                return true;
                            }
                            throw new RuntimeException("9101: device[x86] is not compatible with CPU_ARCH[" + Build.CPU_ARCH + "]");
                        }
                    } else if (!a("v7") || a("v8")) {
                        Log.d(SdkAuthentication.a, "isArchCompatible: device=armv7/v8");
                        if ((intValue & 2) != 0) {
                            if (!Build.CPU_ARCH.startsWith("x86")) {
                                return true;
                            }
                            throw new RuntimeException("9102: device[armv7/v8] is not compatible with CPU_ARCH[" + Build.CPU_ARCH + "]");
                        }
                    } else if (a("v5") || a("v6") || a("arm")) {
                        Log.d(SdkAuthentication.a, "isArchCompatible: device=armv5/v6");
                        if ((intValue & 1) != 0) {
                            if (Build.CPU_ARCH.equals("armv5te")) {
                                return true;
                            }
                            throw new RuntimeException("9103: device[armv5/v6] is not compatible with CPU_ARCH[" + Build.CPU_ARCH + "]");
                        }
                    } else {
                        Log.d(SdkAuthentication.a, "isArchCompatible: device=unknown");
                    }
                    return true;
                }
            }
            intValue = 7;
            Log.d(SdkAuthentication.a, "isArchCompatible: policy=" + intValue);
            if (intValue == 0) {
                return true;
            }
            Log.d(SdkAuthentication.a, "isArchCompatible: CPU_ARCH=" + Build.CPU_ARCH);
            if (Build.CPU_ARCH.length() == 0) {
                return false;
            }
            if (a("x86")) {
                Log.d(SdkAuthentication.a, "isArchCompatible: device=x86");
                if ((intValue & 4) != 0) {
                    if (Build.CPU_ARCH.startsWith("x86")) {
                        return true;
                    }
                    throw new RuntimeException("9101: device[x86] is not compatible with CPU_ARCH[" + Build.CPU_ARCH + "]");
                }
            }
            if (a("v7")) {
            }
            Log.d(SdkAuthentication.a, "isArchCompatible: device=armv7/v8");
            if ((intValue & 2) != 0) {
                if (!Build.CPU_ARCH.startsWith("x86")) {
                    return true;
                }
                throw new RuntimeException("9102: device[armv7/v8] is not compatible with CPU_ARCH[" + Build.CPU_ARCH + "]");
            }
            return true;
        }

        private static boolean a(String str) {
            if (f == null) {
                f = System.getProperty("os.arch");
            }
            if (f != null && f.toLowerCase().contains(str)) {
                return true;
            }
            if (a == null) {
                try {
                    a = Build.CPU_ABI;
                    b = Build.CPU_ABI2;
                } catch (Exception e) {
                }
            }
            if (a != null && a.toLowerCase().contains(str)) {
                return true;
            }
            if (c == null && VERSION.SDK_INT >= 21) {
                try {
                    c = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                } catch (Exception e2) {
                }
            }
            if (c != null && c.length > 0 && c[0] != null && c[0].toLowerCase().contains(str)) {
                return true;
            }
            if (d == null) {
                d = b("ro.product.cpu.abi");
            }
            if (d != null && d.toLowerCase().contains(str)) {
                return true;
            }
            if (e == null) {
                String b = b("ro.product.cpu.abilist");
                if (!(b == null || b.length() == 0)) {
                    e = b.split(",");
                }
            }
            if (e == null || e.length <= 0 || e[0] == null || !e[0].toLowerCase().contains(str)) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String b(java.lang.String r8) {
            /*
            r0 = 0;
            r1 = new java.io.File;
            r2 = "/system/build.prop";
            r1.<init>(r2);
            r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0055, all -> 0x0063 }
            r3.<init>(r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0063 }
            r2 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0080, all -> 0x0073 }
            r2.<init>(r3);	 Catch:{ Throwable -> 0x0080, all -> 0x0073 }
            r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0084, all -> 0x0079 }
            r1.<init>(r2);	 Catch:{ Throwable -> 0x0084, all -> 0x0079 }
        L_0x0017:
            r4 = r1.readLine();	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            if (r4 == 0) goto L_0x004b;
        L_0x001d:
            r5 = r4.contains(r8);	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            if (r5 == 0) goto L_0x0017;
        L_0x0023:
            r5 = "=";
            r4 = r4.split(r5);	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            r5 = r4.length;	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            r6 = 2;
            if (r5 != r6) goto L_0x0017;
        L_0x002d:
            r5 = 0;
            r5 = r4[r5];	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            r5 = r5.trim();	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            r5 = r5.equals(r8);	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            if (r5 == 0) goto L_0x0017;
        L_0x003a:
            r5 = 1;
            r4 = r4[r5];	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            r0 = r4.trim();	 Catch:{ Throwable -> 0x0087, all -> 0x007e }
            a(r1);
            a(r2);
            a(r3);
        L_0x004a:
            return r0;
        L_0x004b:
            a(r1);
            a(r2);
            a(r3);
            goto L_0x004a;
        L_0x0055:
            r1 = move-exception;
            r1 = r0;
            r2 = r0;
            r3 = r0;
        L_0x0059:
            a(r1);
            a(r2);
            a(r3);
            goto L_0x004a;
        L_0x0063:
            r1 = move-exception;
            r2 = r0;
            r3 = r0;
            r7 = r1;
            r1 = r0;
            r0 = r7;
        L_0x0069:
            a(r1);
            a(r2);
            a(r3);
            throw r0;
        L_0x0073:
            r1 = move-exception;
            r2 = r0;
            r7 = r0;
            r0 = r1;
            r1 = r7;
            goto L_0x0069;
        L_0x0079:
            r1 = move-exception;
            r7 = r1;
            r1 = r0;
            r0 = r7;
            goto L_0x0069;
        L_0x007e:
            r0 = move-exception;
            goto L_0x0069;
        L_0x0080:
            r1 = move-exception;
            r1 = r0;
            r2 = r0;
            goto L_0x0059;
        L_0x0084:
            r1 = move-exception;
            r1 = r0;
            goto L_0x0059;
        L_0x0087:
            r4 = move-exception;
            goto L_0x0059;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.browser.shell.SdkAuthentication.a.b(java.lang.String):java.lang.String");
        }

        private static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                }
            }
        }

        private static final boolean b(Context context, HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                try {
                    String[] strArr = (String[]) hashMap.get(UCCore.OPTION_PROVIDED_KEYS);
                    if (strArr != null) {
                        byte[] i = i(context);
                        byte[] j = j(context);
                        for (String a : strArr) {
                            byte[] a2 = a(a, "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKBdPBr97YTGk+S6oehFhFsuE+BU9+2Pxbn1/NX3+g9q\nh+r3xET8vSem7YwRpBOgQ38wDqbf/IpIZSKyuXD7o9sCAwEAAQ==\n");
                            if (a(i, a2, context.getPackageName()) || a(j, a2, context.getPackageName())) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }

        private static final boolean c(Context context) {
            try {
                return a(j(context), a(g(context), "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKBdPBr97YTGk+S6oehFhFsuE+BU9+2Pxbn1/NX3+g9q\nh+r3xET8vSem7YwRpBOgQ38wDqbf/IpIZSKyuXD7o9sCAwEAAQ==\n"), context.getPackageName());
            } catch (Exception e) {
                return false;
            }
        }

        private static final boolean d(Context context) {
            try {
                String packageName = context.getPackageName();
                if (!packageName.startsWith("com.UCMobile") && !packageName.equals("com.ucsdk.cts") && !packageName.startsWith("com.eg.android.AlipayGphone") && !packageName.startsWith("com.ucmobile.lite")) {
                    return a(i(context), a(h(context), "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKBdPBr97YTGk+S6oehFhFsuE+BU9+2Pxbn1/NX3+g9q\nh+r3xET8vSem7YwRpBOgQ38wDqbf/IpIZSKyuXD7o9sCAwEAAQ==\n"), packageName);
                }
                Log.d(SdkAuthentication.a, "starts width com.UCMobile or equals com.ucsdk.cts");
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private static boolean a(byte[] bArr, byte[] bArr2, String str) {
            boolean z = false;
            if (!(bArr == null || bArr2 == null || bArr.length > bArr2.length)) {
                byte[] a;
                if (bArr2.length > bArr.length) {
                    a = a(bArr2, 0, bArr.length);
                } else {
                    a = bArr2;
                }
                if (a != null && bArr != null) {
                    boolean z2;
                    if (a.length == bArr.length) {
                        z2 = false;
                    } else if (a.length == bArr.length - 2) {
                        z2 = true;
                    }
                    int i = z2;
                    int i2 = 0;
                    for (int i3 = 0; i3 < a.length; i3++) {
                        if (a[i2] != bArr[i]) {
                            break;
                        }
                        i2++;
                        i++;
                    }
                    z = true;
                }
                if (z) {
                    if (bArr.length == bArr2.length) {
                        a aVar = (a) g.get(str);
                        if (aVar != null) {
                            com.uc.webview.export.Build.SDK_PROFILE_ID = aVar.b;
                            com.uc.webview.export.Build.SDK_PRD = aVar.a;
                            Log.d(SdkAuthentication.a, "prd=" + aVar.a + " pfid=" + aVar.b);
                        }
                    } else {
                        try {
                            String[] split = new String(a(bArr2, bArr.length, bArr2.length - bArr.length), "ISO-8859-1").split(":");
                            if (split.length == 2) {
                                com.uc.webview.export.Build.SDK_PROFILE_ID = split[1];
                                com.uc.webview.export.Build.SDK_PRD = split[0];
                                Log.d(SdkAuthentication.a, "prd=" + split[0] + " pfid=" + split[1]);
                            }
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                }
            }
            return z;
        }

        private static byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            for (int i3 = i; i3 < i + i2; i3++) {
                bArr2[i3 - i] = bArr[i3];
            }
            return bArr2;
        }

        private static final boolean d() {
            try {
                String a = a(Version.class, "NAME");
                String a2 = a(Version.class, "SUPPORT_U4_MIN");
                String a3 = a(Build.Version.class, "NAME");
                String a4 = a(Build.Version.class, "SUPPORT_SDK_MIN");
                Log.d(SdkAuthentication.a, "sdk版本:" + a);
                Log.d(SdkAuthentication.a, "sdk支持的最小内核版本:" + a2);
                Log.d(SdkAuthentication.a, "内核版本:" + a3);
                Log.d(SdkAuthentication.a, "内核支持的最小sdk版本:" + a4);
                int[] c = c(a3);
                int[] c2 = c(a2);
                if (c == null || c2 == null) {
                    return false;
                }
                if (c[0] < c2[0] || (c[0] == c2[0] && (c[1] < c2[1] || (c[1] == c2[1] && (c[2] < c2[2] || (c[2] == c2[2] && c[3] < c2[3])))))) {
                    Log.d(SdkAuthentication.a, "最小内核版本不通过");
                    return false;
                }
                int[] c3 = c(a);
                c2 = c(a4);
                if (c3 == null || c2 == null) {
                    return false;
                }
                if (c3[0] >= c2[0]) {
                    if (c3[0] != c2[0]) {
                        return true;
                    }
                    if (c3[1] >= c2[1]) {
                        if (c3[1] != c2[1]) {
                            return true;
                        }
                        if (c3[2] >= c2[2] && (c3[2] != c2[2] || c3[3] >= c2[3])) {
                            return true;
                        }
                    }
                }
                Log.d(SdkAuthentication.a, "最小SDK版本不通过");
                return false;
            } catch (Exception e) {
                return false;
            }
        }

        private static final String a(Class cls, String str) {
            try {
                return cls.getField(str).get(null).toString();
            } catch (Exception e) {
                return "";
            }
        }

        private static final int[] c(String str) {
            if (str != null) {
                if (str.split("\\.").length > 3) {
                    return new int[]{Integer.parseInt(str.split("\\.")[0]), Integer.parseInt(str.split("\\.")[1]), Integer.parseInt(str.split("\\.")[2]), Integer.parseInt(str.split("\\.")[3])};
                }
            }
            return null;
        }

        private static final boolean e() {
            try {
                int i = IOpenFileChooser.class.getField("FLAG").getInt(null);
                Log.d(SdkAuthentication.a, "flag=" + i);
                if (i == 1001) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                Log.d(SdkAuthentication.a, "hasFlag", th);
                return false;
            }
        }

        private static final byte[] e(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            } catch (Exception e) {
                return null;
            }
        }

        private static final byte[] a(byte[] bArr) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(bArr);
                return instance.digest();
            } catch (Exception e) {
                return null;
            }
        }

        private static final String f(Context context) {
            byte[] a = a(e(context));
            StringBuilder stringBuilder = new StringBuilder("");
            if (a == null || a.length <= 0) {
                return null;
            }
            for (int i = 0; i < a.length; i++) {
                String toUpperCase = Integer.toHexString(a[i] & 255).toUpperCase();
                if (i > 0) {
                    stringBuilder.append(":");
                }
                if (toUpperCase.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(toUpperCase);
            }
            return stringBuilder.toString();
        }

        private static final String g(Context context) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("UCSDKCompanyKey");
            } catch (NameNotFoundException e) {
                return null;
            }
        }

        private static final String h(Context context) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("UCSDKAppKey");
            } catch (NameNotFoundException e) {
                return null;
            }
        }

        private static final byte[] d(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }

        private static final byte[] i(Context context) {
            String f = f(context);
            Log.d(SdkAuthentication.a, "apk 包名:" + context.getPackageName() + ",签名:" + f);
            return d(context.getPackageName() + f);
        }

        private static final byte[] j(Context context) {
            String f = f(context);
            Log.d(SdkAuthentication.a, "apk 签名:" + f);
            return d(f);
        }

        private static final byte[] a(byte[] bArr, byte[] bArr2) {
            try {
                Cipher instance = Cipher.getInstance("RSA");
                instance.init(2, b(bArr2));
                return instance.doFinal(bArr);
            } catch (Exception e) {
                return null;
            }
        }

        private static final PublicKey b(byte[] bArr) {
            PublicKey publicKey = null;
            KeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
            } catch (NoSuchAlgorithmException e) {
                Object obj = publicKey;
            }
            try {
                publicKey = instance.generatePublic(x509EncodedKeySpec);
            } catch (InvalidKeySpecException e2) {
            }
            return publicKey;
        }

        private static final byte[] a(String str, String str2) {
            Log.d(SdkAuthentication.a, "apk 授权码:" + str);
            return a(Base64.decode(str, 0), Base64.decode(str2, 0));
        }
    }

    /* compiled from: ProGuard */
    final class b {
        private static final boolean b() {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[]{"ro.yunos.version"});
                if (invoke == null) {
                    return false;
                }
                String obj = invoke.toString();
                if (obj == null || obj.length() == 0) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                return false;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static final boolean a() {
            /*
            r0 = 1;
            r1 = 0;
            r2 = b();	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            if (r2 == 0) goto L_0x0037;
        L_0x0008:
            r2 = "com.yunos.weblight.config.Config";
            r2 = java.lang.Class.forName(r2);	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            if (r2 == 0) goto L_0x0035;
        L_0x0010:
            r3 = "YUNOS_CLIENT";
            r3 = r2.getDeclaredField(r3);	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            if (r3 == 0) goto L_0x0035;
        L_0x0018:
            r4 = 1;
            r3.setAccessible(r4);	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r2 = r2.newInstance();	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r2 = r3.get(r2);	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r2 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r3 = "true";
            r2 = r2.equalsIgnoreCase(r3);	 Catch:{ IllegalArgumentException -> 0x0041, IllegalAccessException -> 0x003f, InstantiationException -> 0x003d, NoSuchFieldException -> 0x003b, ClassNotFoundException -> 0x0039 }
            if (r2 == 0) goto L_0x0035;
        L_0x0030:
            r2 = r0;
        L_0x0031:
            if (r2 == 0) goto L_0x0037;
        L_0x0033:
            r1 = r0;
        L_0x0034:
            return r1;
        L_0x0035:
            r2 = r1;
            goto L_0x0031;
        L_0x0037:
            r0 = r1;
            goto L_0x0033;
        L_0x0039:
            r0 = move-exception;
            goto L_0x0034;
        L_0x003b:
            r0 = move-exception;
            goto L_0x0034;
        L_0x003d:
            r0 = move-exception;
            goto L_0x0034;
        L_0x003f:
            r0 = move-exception;
            goto L_0x0034;
        L_0x0041:
            r0 = move-exception;
            goto L_0x0034;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.browser.shell.SdkAuthentication.b.a():boolean");
        }
    }

    @Jni
    public static final boolean tryLoadUCCore(Context context, UCMPackageInfo uCMPackageInfo, HashMap<String, Object> hashMap) throws Exception {
        String str;
        if (!a.a((HashMap) hashMap)) {
            str = "9001:isArchCompatible return false.";
            Log.d(a, str);
            throw new RuntimeException(str);
        } else if (!a.a()) {
            str = "9002:isFrameworkCompatible return false.";
            Log.d(a, str);
            throw new RuntimeException(str);
        } else if (!a.e() && !a.b(context, hashMap) && !a.d(context) && !a.c(context) && !b.a()) {
            str = "9003:isUCSDKAppKeyCorrect return false.";
            Log.d(a, str);
            throw new RuntimeException(str);
        } else if (!a.d()) {
            str = "9004:isVersionCompatible return false.";
            Log.d(a, str);
            throw new RuntimeException(str);
        } else if (a.a(uCMPackageInfo)) {
            return true;
        } else {
            str = "9005:isConfigEnabled return false.";
            Log.d(a, str);
            throw new RuntimeException(str);
        }
    }

    @Jni
    public static final boolean tryLoadUCCore(Context context, UCMPackageInfo uCMPackageInfo) throws Exception {
        return tryLoadUCCore(context, uCMPackageInfo, null);
    }

    @Jni
    public static boolean checkedSoSize(String str, HashMap<String, Object> hashMap) {
        return true;
    }
}
