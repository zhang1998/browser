package com.taobao.weex.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class u {
    public static String a(String str, Context context) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return b(str, context);
            }
            try {
                return a(new FileInputStream(file), str);
            } catch (FileNotFoundException e) {
            }
        }
        return "";
    }

    public static String b(String str, Context context) throws Exception {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream open = context.getAssets().open(str);
                if (open != null) {
                    return a(open, str);
                }
                throw new Exception("open assets file, inputStream is null.");
            } catch (IOException e) {
                return "";
            }
        } else if (context != null) {
            return null;
        } else {
            throw new Exception("open assets file, context is null.");
        }
    }

    private static String a(InputStream inputStream, String str) throws Exception {
        BufferedReader bufferedReader;
        Throwable e;
        try {
            StringBuilder stringBuilder = new StringBuilder(inputStream.available() + 10);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                int read;
                char[] cArr = new char[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                while (true) {
                    read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
                if (stringBuilder.length() <= 0) {
                    throw new Exception("open assets file " + str + ", file len is " + read);
                }
                String stringBuilder2 = stringBuilder.toString();
                try {
                    bufferedReader.close();
                } catch (Throwable e2) {
                    WXLogUtils.e("WXFileUtils loadAsset: ", e2);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22) {
                        WXLogUtils.e("WXFileUtils loadAsset: ", e22);
                    }
                }
                return stringBuilder2;
            } catch (IOException e3) {
                e = e3;
                try {
                    WXLogUtils.e("", e);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e222) {
                            WXLogUtils.e("WXFileUtils loadAsset: ", e222);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2222) {
                            WXLogUtils.e("WXFileUtils loadAsset: ", e2222);
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            WXLogUtils.e("", e);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw e;
        }
    }

    public static boolean a(String str, byte[] bArr, Context context) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        if (TextUtils.isEmpty(str) || bArr == null || context == null) {
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    WXLogUtils.e("WXFileUtils saveFile: " + WXLogUtils.getStackTrace(e));
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            WXLogUtils.e("WXFileUtils saveFile: " + WXLogUtils.getStackTrace(e));
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
