package com.uc.weex.j;

import android.text.TextUtils;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.u;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/* compiled from: ProGuard */
public final class b {
    public static String a(String str) {
        Exception e;
        Throwable th;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine).append('\n');
                    }
                    str2 = stringBuilder.toString();
                    a(bufferedReader);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        WXLogUtils.d("IoUtils loadFile：", e.getMessage());
                        a(bufferedReader);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                Object obj = str2;
                WXLogUtils.d("IoUtils loadFile：", e.getMessage());
                a(bufferedReader);
                return str2;
            } catch (Throwable th3) {
                bufferedReader = str2;
                th = th3;
                a(bufferedReader);
                throw th;
            }
        }
        return str2;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                WXLogUtils.e("IoUtils sefeClose: ", e);
            }
        }
    }

    public static boolean a(String str, byte[] bArr) {
        Throwable e;
        Throwable th;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return false;
        }
        Closeable closeable = null;
        try {
            File parentFile = new File(str).getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            Closeable fileOutputStream = new FileOutputStream(str, false);
            try {
                fileOutputStream.write(bArr);
                a(fileOutputStream);
                return true;
            } catch (Exception e2) {
                e = e2;
                closeable = fileOutputStream;
                try {
                    WXLogUtils.e("IoUtils saveFile: " + WXLogUtils.getStackTrace(e));
                    a(closeable);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    a(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = fileOutputStream;
                a(closeable);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            WXLogUtils.e("IoUtils saveFile: " + WXLogUtils.getStackTrace(e));
            a(closeable);
            return false;
        }
    }

    public static String b(String str) {
        try {
            return u.b(str, i.e);
        } catch (Throwable e) {
            WXLogUtils.e("IoUtils loadAssetFile: " + WXLogUtils.getStackTrace(e));
            return null;
        }
    }
}
