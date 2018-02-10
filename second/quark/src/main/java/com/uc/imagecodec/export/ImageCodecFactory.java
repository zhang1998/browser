package com.uc.imagecodec.export;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.annotations.Api;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Api
/* compiled from: ProGuard */
public final class ImageCodecFactory {
    private static IImageCodec a = null;
    private static IImageCodecView b = null;
    private static DexClassLoader c = null;
    private static String d = "";
    private static int e = 0;

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        try {
                            delete.delete();
                        } catch (Exception e) {
                        }
                    }
                }
            } else {
                file.mkdirs();
            }
            File file2 = new File(str + File.separator + str2);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e2) {
                }
            }
        }
    }

    private static boolean a(Context context, String str, String str2, InputStream inputStream) {
        IOException e;
        Throwable th;
        OutputStream outputStream = null;
        boolean z = false;
        File file = new File(str2);
        File file2 = new File(str2 + "tmp" + Process.myPid());
        if (file2.exists()) {
            file2.delete();
        }
        if (file.exists()) {
            file.delete();
        }
        if (inputStream == null) {
            try {
                inputStream = context.getApplicationContext().getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("imagecodec", "open dex failed:" + e.toString());
                    d += "[1]" + e.toString();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            throw th;
                        }
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            }
        }
        OutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            byte[] bArr = new byte[8096];
            int i = z;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                i += read;
            }
            d = "[b:" + i + "]" + d;
            fileOutputStream.flush();
            fileOutputStream.close();
            z = file2.renameTo(file);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = fileOutputStream;
            Log.e("imagecodec", "open dex failed:" + e.toString());
            d += "[1]" + e.toString();
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            outputStream = fileOutputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
        return z;
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(Integer.toHexString(b & 255));
        }
        return stringBuffer.toString();
    }

    private static String a(Context context, byte[] bArr) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e) {
        }
        String str = "";
        if (bArr == null || packageInfo == null) {
            return str;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(bArr, 0, bArr.length);
            return a(instance.digest()) + packageInfo.lastUpdateTime + packageInfo.versionCode + packageInfo.versionName;
        } catch (NoSuchAlgorithmException e2) {
            return str;
        }
    }

    private static DexClassLoader a(Context context) {
        if (c == null) {
            synchronized (ImageCodecFactory.class) {
                if (c == null) {
                    if (context == null) {
                        return null;
                    }
                    byte[] bArr;
                    int i;
                    File cacheDir = context.getCacheDir();
                    String str = cacheDir.getAbsolutePath() + File.separator + "imagecodec_java.jar";
                    String str2 = cacheDir.getAbsolutePath() + File.separator + "imagecodec_dexinfo";
                    InputStream inputStream = null;
                    byte[] bArr2 = null;
                    Object obj = null;
                    int i2 = 0;
                    try {
                        inputStream = context.getApplicationContext().getAssets().open("dexes/imagecodec_java.jar");
                        obj = inputStream != null ? 1 : null;
                        if (obj != null) {
                            bArr2 = new byte[40];
                            i2 = inputStream.available();
                            inputStream.mark(41);
                            inputStream.read(bArr2);
                            inputStream.reset();
                        }
                        int i3 = i2;
                        bArr = bArr2;
                        i = i3;
                    } catch (IOException e) {
                        IOException iOException = e;
                        i = 0;
                        IOException iOException2 = iOException;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        d += "[0]" + iOException2.toString();
                        inputStream = null;
                        bArr = null;
                    }
                    if (obj == null) {
                        return null;
                    }
                    Object obj2;
                    String a = a(context, bArr);
                    if (TextUtils.isEmpty(a)) {
                        obj2 = 1;
                    } else {
                        File file = new File(str);
                        obj2 = !file.exists() ? 1 : ((long) i) != file.length() ? 1 : !new File(new StringBuilder().append(str2).append(File.separator).append(a).toString()).exists() ? 1 : null;
                    }
                    if (obj2 != null) {
                        if (!cacheDir.exists()) {
                            cacheDir.mkdirs();
                        }
                        if (a(context, "dexes/imagecodec_java.jar", str, inputStream)) {
                            a(str2, a);
                        } else {
                            d += "[cp fail]";
                        }
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    d = "[dex:]" + i + d;
                    String str3 = str + ShareConstants.ODEX_SUFFIX;
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    c = new DexClassLoader(str, str3, context.getApplicationInfo().dataDir + "/lib", context.getClassLoader());
                }
            }
        }
        return c;
    }

    public static String getError() {
        return d;
    }

    public static IImageCodec getImageCodecImpl(Context context) {
        if (a == null) {
            d = "";
            try {
                Class cls;
                if (a("com.uc.imagecodec.decoder.ImageCodecImpl")) {
                    cls = Class.forName("com.uc.imagecodec.decoder.ImageCodecImpl");
                } else {
                    DexClassLoader a = a(context);
                    c = a;
                    if (a == null) {
                        d += "imagecodec no dex";
                        Log.e("imagecodec", "no dex found");
                        return null;
                    }
                    cls = c.loadClass("com.uc.imagecodec.decoder.ImageCodecImpl");
                }
                a = (IImageCodec) cls.getDeclaredMethod("with", new Class[]{Context.class}).invoke(null, new Object[]{context});
            } catch (Exception e) {
                d += "[2]" + e.toString();
                if (e < 20) {
                    File file = new File(context.getCacheDir().getAbsolutePath() + File.separator + "imagecodec_java.jar");
                    File file2 = new File(context.getCacheDir().getAbsolutePath() + File.separator + "imagecodec_java.jartmp" + Process.myPid());
                    File file3 = new File(context.getCacheDir().getAbsolutePath() + File.separator + "imagecodec_java.jar.odex" + File.separator + "imagecodec_java.dex");
                    d = (file.exists() ? SettingsConst.TRUE : SettingsConst.FALSE) + "[" + file.length() + "]" + (file2.exists() ? SettingsConst.TRUE : SettingsConst.FALSE) + "[" + file2.length() + "]" + (file3.exists() ? SettingsConst.TRUE : SettingsConst.FALSE) + "[" + file3.length() + "]" + d;
                    Log.e("imagecodec", "init failed:" + d);
                }
                e++;
            }
        }
        return a;
    }

    public static IImageCodecView getImageCodecViewImpl(Context context) {
        if (b == null) {
            try {
                Class cls;
                if (a("com.uc.imagecodec.ui.ImageCodecViewImpl")) {
                    cls = Class.forName("com.uc.imagecodec.ui.ImageCodecViewImpl");
                } else {
                    DexClassLoader a = a(context);
                    c = a;
                    if (a == null) {
                        Log.e("imagecodec", "no dex found");
                        return null;
                    }
                    cls = c.loadClass("com.uc.imagecodec.ui.ImageCodecViewImpl");
                }
                b = (IImageCodecView) cls.getDeclaredMethod("with", new Class[]{Context.class}).invoke(null, new Object[]{context});
            } catch (Exception e) {
                Log.e("imagecodec", "init view failed:" + e.toString());
            }
        }
        return b;
    }

    private static boolean a(String str) {
        try {
            if (Class.forName(str) == null) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            Log.e("imagecodec", "existClass:ImageCodecImpl false");
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}
