package com.ucweb.c.d;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import com.uc.imagecodec.export.IPictureView;
import com.ucweb.c.c.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

/* compiled from: ProGuard */
public final class c {
    private static Object a = new Object();

    private static List<PackageInfo> a() {
        List<PackageInfo> installedPackages;
        PackageManager packageManager = b.a().getPackageManager();
        synchronized (a) {
            try {
                installedPackages = packageManager.getInstalledPackages(0);
            } catch (Throwable th) {
                installedPackages = null;
            }
        }
        return installedPackages;
    }

    public static PackageInfo a(String str) {
        if (str == null) {
            return null;
        }
        synchronized (a) {
            List a = a();
            if (a == null) {
                return null;
            }
            for (int i = 0; i < a.size(); i++) {
                PackageInfo packageInfo = (PackageInfo) a.get(i);
                if (str.equals(packageInfo.packageName)) {
                    return packageInfo;
                }
            }
            return null;
        }
    }

    public static boolean b(String str) {
        return a(str) != null;
    }

    public static int a(String str, String str2) {
        int i = 0;
        if (str == null && str2 == null) {
            return 0;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        String[] split = TextUtils.split(str, ".");
        String[] split2 = TextUtils.split(str2, ".");
        int min = Math.min(split.length, split2.length);
        while (i < min) {
            int d = d(split[i]);
            int d2 = d(split2[i]);
            if (d != d2) {
                return d - d2;
            }
            i++;
        }
        return split.length - split2.length;
    }

    private static int d(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean startsWith = str.startsWith("0x");
        if (startsWith) {
            str = str.substring(2);
        }
        if (startsWith) {
            return (int) Long.parseLong(str, 16);
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Bitmap c(String str) {
        Bitmap decodeFile;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options);
            options.inJustDecodeBounds = false;
            decodeFile = BitmapFactory.decodeFile(str, options);
            b e = e(str);
            if (e.a == 0 && !e.b) {
                return decodeFile;
            }
            if (decodeFile == null || decodeFile.getWidth() <= 0 || decodeFile.getHeight() <= 0) {
                return null;
            }
            Matrix matrix = new Matrix();
            if (e.b) {
                matrix.postScale(-1.0f, IPictureView.DEFAULT_MIN_SCALE);
            }
            if (e.a != 0) {
                matrix.postRotate((float) e.a);
            }
            Bitmap a = a.a(decodeFile, decodeFile.getWidth(), decodeFile.getHeight(), matrix);
            decodeFile.recycle();
            return a;
        } catch (Throwable th) {
            return decodeFile;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.ucweb.c.d.b e(java.lang.String r5) {
        /*
        r1 = 0;
        r0 = 1;
        r2 = new android.media.ExifInterface;	 Catch:{ IOException -> 0x0018 }
        r2.<init>(r5);	 Catch:{ IOException -> 0x0018 }
        r3 = "Orientation";
        r4 = 1;
        r2 = r2.getAttributeInt(r3, r4);	 Catch:{ IOException -> 0x0018 }
    L_0x000e:
        switch(r2) {
            case 1: goto L_0x0011;
            case 2: goto L_0x0012;
            case 3: goto L_0x001f;
            case 4: goto L_0x0020;
            case 5: goto L_0x0024;
            case 6: goto L_0x001b;
            case 7: goto L_0x001c;
            case 8: goto L_0x0023;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r1;
    L_0x0012:
        r2 = new com.ucweb.c.d.b;
        r2.<init>(r1, r0);
        return r2;
    L_0x0018:
        r2 = move-exception;
        r2 = r1;
        goto L_0x000e;
    L_0x001b:
        r0 = r1;
    L_0x001c:
        r1 = 90;
        goto L_0x0012;
    L_0x001f:
        r0 = r1;
    L_0x0020:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0012;
    L_0x0023:
        r0 = r1;
    L_0x0024:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucweb.c.d.c.e(java.lang.String):com.ucweb.c.d.b");
    }

    public static String a(Bundle bundle) {
        Set<String> keySet = bundle.keySet();
        if (keySet == null || keySet.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : keySet) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    try {
                        stringBuilder.append(URLEncoder.encode(str, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                    }
                } else {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str)).append("=");
                    String[] strArr = (String[]) obj;
                    int i2 = 0;
                    while (i2 < strArr.length) {
                        try {
                            String str3 = strArr[i2];
                            if (i2 == 0) {
                                stringBuilder.append(URLEncoder.encode(str3, "UTF-8"));
                            } else {
                                stringBuilder.append(URLEncoder.encode("," + str3, "UTF-8"));
                            }
                            i2++;
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                }
                i++;
            }
        }
        return stringBuilder.toString();
    }

    private static int a(Options options) {
        int ceil = (int) Math.ceil(Math.sqrt((((double) options.outWidth) * ((double) options.outHeight)) / 19600.0d));
        if (ceil > 8) {
            return ((ceil + 7) / 8) * 8;
        }
        int i = 1;
        while (i < ceil) {
            i <<= 1;
        }
        return i;
    }
}
