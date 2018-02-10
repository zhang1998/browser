package com.loc;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: ProGuard */
public final class bt {
    static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        bc bcVar = null;
        try {
            bcVar = bc.a(new File(str), 204800);
            File file = new File(str);
            if (file.exists()) {
                for (String str2 : file.list()) {
                    String str22;
                    if (str22.contains(".0")) {
                        str22 = eq.a(bx.a(bcVar, str22.split("\\.")[0]));
                        if (obj != null) {
                            obj = null;
                        } else {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append("{\"log\":\"").append(str22).append("\"}");
                    }
                }
            }
            if (bcVar != null) {
                bcVar.close();
            }
        } catch (Throwable e) {
            es.a(e, "StatisticsManager", "getContent");
            if (bcVar != null) {
                bcVar.close();
            }
        } catch (Throwable th) {
        }
        return stringBuilder.toString();
    }

    public static synchronized void a(br brVar, Context context) {
        synchronized (bt.class) {
            fa.b().submit(new bs(brVar, context));
        }
    }

    static boolean a(Context context) {
        try {
            if (ei.m(context) == 1) {
                return System.currentTimeMillis() - d(context) > 604800000 || c(context) >= 100;
            }
        } catch (Throwable th) {
            es.a(th, "StatisticsManager", "isUpdate");
        }
        return false;
    }

    static String b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"key\":\"").append(dx.f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(ei.q(context)).append("\",\"mac\":\"").append(ei.i(context)).append("\",\"tid\":\"").append(ei.f(context)).append("\",\"manufacture\":\"").append(Build.MANUFACTURER).append("\",\"device\":\"").append(Build.DEVICE).append("\",\"sim\":\"").append(ei.r(context)).append("\",\"pkg\":\"").append(dx.c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appversion\":\"").append(dx.d(context)).append("\"");
        } catch (Throwable th) {
            es.a(th, "CInfo", "getPublicJSONInfo");
        }
        return stringBuilder.toString();
    }

    private static int c(Context context) {
        int i = 0;
        try {
            File file = new File(ew.a(context, ew.f));
            if (file.exists()) {
                i = file.list().length;
            }
        } catch (Throwable th) {
            es.a(th, "OfflineLocManager", "getFileNum");
        }
        return i;
    }

    private static long d(Context context) {
        Throwable th;
        File file = new File(ew.a(context, "f.log"));
        if (!file.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                long parseLong = Long.parseLong(eq.a(bArr));
                if (fileInputStream2 == null) {
                    return parseLong;
                }
                try {
                    fileInputStream2.close();
                    return parseLong;
                } catch (Throwable th2) {
                    return parseLong;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            es.a(th, "OfflineLocManager", "getUpdateTime");
            if (file.exists()) {
                file.delete();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return System.currentTimeMillis();
        }
    }
}
