package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class l {
    ep a;
    int b;
    private bd c;
    private bc d;

    protected l(int i) {
        this.b = i;
    }

    private bd a(u uVar) {
        try {
            if (this.c == null) {
                this.c = new k(this, uVar);
            }
        } catch (Throwable th) {
        }
        return this.c;
    }

    private static String a(Context context, ep epVar) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sim\":\"").append(ei.e(context)).append("\",\"sdkversion\":\"").append(epVar.b()).append("\",\"product\":\"").append(epVar.a()).append("\",\"ed\":\"").append(epVar.c()).append("\",\"nt\":\"").append(ei.c(context)).append("\",\"np\":\"").append(ei.a(context)).append("\",\"mnc\":\"").append(ei.b(context)).append("\",\"ant\":\"").append(ei.d(context)).append("\"");
        } catch (Throwable th) {
        }
        return stringBuilder.toString();
    }

    private static String a(Context context, String str) {
        String str2 = null;
        try {
            str2 = eg.b(context, eq.a(str));
        } catch (Throwable th) {
        }
        return str2;
    }

    private static String a(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str).append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    private static String a(Throwable th) {
        String str = null;
        try {
            String a = eq.a(th);
            if (a != null) {
                str = a.replaceAll("\n", "<br/>");
            }
        } catch (Throwable th2) {
        }
        return str;
    }

    private static void a(u uVar, String str, String str2, int i) {
        Object b = ew.b(i);
        b.a(0);
        b.a = eq.b(str);
        b.a(str2);
        if (b != null) {
            String b2 = v.b(b.b());
            List a = uVar.a.a(b2, b.getClass(), true);
            if (a.size() == 0) {
                uVar.a.a(b);
                return;
            }
            Object obj = (v) a.get(0);
            if (b.a() == 0) {
                obj.b(obj.c() + 1);
            } else {
                obj.b(0);
            }
            uVar.a.a(b2, obj, true);
        }
    }

    private void a(List<? extends v> list, u uVar) {
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (b(obj.b())) {
                    try {
                        uVar.a(obj.b(), obj.getClass());
                    } catch (Throwable th) {
                        es.a(th, "LogDB", "delLog");
                    }
                } else {
                    obj.a(2);
                    try {
                        uVar.a.a(v.b(obj.b()), obj, false);
                    } catch (Throwable th2) {
                        es.a(th2, "LogDB", "updateLogInfo");
                    }
                }
            }
        }
    }

    private boolean a(Context context, String str, String str2, String str3, u uVar) {
        ba baVar;
        Object obj;
        OutputStream outputStream;
        Object obj2;
        OutputStream outputStream2;
        Throwable th;
        ba baVar2 = null;
        OutputStream outputStream3 = null;
        bc bcVar = null;
        ba baVar3 = null;
        bc a;
        try {
            File file = new File(ew.a(context, str2));
            if (file.exists() || file.mkdirs()) {
                a = bc.a(file, 20480);
                try {
                    a.b = a(uVar);
                    ba a2 = a.a(str);
                    if (a2 != null) {
                        if (baVar2 != null) {
                            try {
                                outputStream3.close();
                            } catch (Throwable th2) {
                            }
                        }
                        if (a2 != null) {
                            try {
                                a2.close();
                            } catch (Throwable th3) {
                            }
                        }
                        if (a == null || a.a()) {
                            return false;
                        }
                        a.close();
                        return false;
                    }
                    byte[] a3;
                    az b;
                    OutputStream a4;
                    try {
                        a3 = eq.a(str3);
                        b = a.b(str);
                        a4 = b.a();
                    } catch (IOException e) {
                        baVar = a2;
                        bcVar = a;
                        obj = baVar2;
                        baVar2 = baVar;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th4) {
                            }
                        }
                        if (baVar2 != null) {
                            try {
                                baVar2.close();
                            } catch (Throwable th5) {
                            }
                        }
                        return bcVar == null ? false : false;
                    } catch (Throwable th6) {
                        th = th6;
                        baVar = a2;
                        obj2 = baVar2;
                        baVar2 = baVar;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable th7) {
                            }
                        }
                        if (baVar2 != null) {
                            try {
                                baVar2.close();
                            } catch (Throwable th8) {
                            }
                        }
                        try {
                            a.close();
                        } catch (Throwable th9) {
                        }
                        throw th;
                    }
                    try {
                        a4.write(a3);
                        b.b();
                        a.b();
                        if (a4 != null) {
                            try {
                                a4.close();
                            } catch (Throwable th10) {
                            }
                        }
                        if (a2 != null) {
                            try {
                                a2.close();
                            } catch (Throwable th11) {
                            }
                        }
                        if (!(a == null || a.a())) {
                            try {
                                a.close();
                            } catch (Throwable th12) {
                            }
                        }
                        return true;
                    } catch (IOException e2) {
                        baVar = a2;
                        bcVar = a;
                        outputStream = a4;
                        baVar2 = baVar;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (baVar2 != null) {
                            baVar2.close();
                        }
                        if (bcVar == null) {
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        baVar = a2;
                        outputStream2 = a4;
                        baVar2 = baVar;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (baVar2 != null) {
                            baVar2.close();
                        }
                        a.close();
                        throw th;
                    }
                } catch (IOException e3) {
                    bcVar = a;
                    obj = baVar2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (baVar2 != null) {
                        baVar2.close();
                    }
                    if (bcVar == null) {
                    }
                } catch (Throwable th14) {
                    th = th14;
                    obj2 = baVar2;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (baVar2 != null) {
                        baVar2.close();
                    }
                    a.close();
                    throw th;
                }
            }
            if (baVar2 != null) {
                try {
                    outputStream3.close();
                } catch (Throwable th15) {
                }
            }
            if (baVar2 != null) {
                try {
                    baVar3.close();
                } catch (Throwable th16) {
                }
            }
            if (baVar2 == null || baVar2.a()) {
                return false;
            }
            try {
                bcVar.close();
                return false;
            } catch (Throwable th17) {
                return false;
            }
        } catch (IOException e4) {
            bcVar = baVar2;
            outputStream = baVar2;
            if (outputStream != null) {
                outputStream.close();
            }
            if (baVar2 != null) {
                baVar2.close();
            }
            if (bcVar == null && !bcVar.a()) {
                bcVar.close();
                return false;
            }
        } catch (Throwable th18) {
            th = th18;
            a = baVar2;
            outputStream2 = baVar2;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (baVar2 != null) {
                baVar2.close();
            }
            if (!(a == null || a.a())) {
                a.close();
            }
            throw th;
        }
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            String[] split = str.split("<br/>");
            for (CharSequence charSequence : strArr) {
                for (String trim : split) {
                    String trim2 = trim2.trim();
                    if (trim2.startsWith("at ") && trim2.contains(charSequence) && trim2.endsWith(")")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static bc b(Context context, String str) {
        bc bcVar = null;
        try {
            File file = new File(ew.a(context, str));
            if (file.exists() || file.mkdirs()) {
                bcVar = bc.a(file, 20480);
            }
        } catch (Throwable e) {
            es.a(e, "LogProcessor", "initDiskLru");
        } catch (Throwable e2) {
            es.a(e2, "LogProcessor", "initDiskLru");
        }
        return bcVar;
    }

    private static String b() {
        return eq.a(new Date().getTime());
    }

    private boolean b(String str) {
        boolean z = false;
        if (this.d != null) {
            try {
                z = this.d.c(str);
            } catch (Throwable th) {
                es.a(th, "LogUpdateProcessor", "deleteLogData");
            }
        }
        return z;
    }

    private static int c(String str) {
        int i = 0;
        bp exVar = new ex(eq.c(eq.a(str)));
        try {
            bi.a();
            byte[] b = bi.b(exVar);
            if (b == null) {
                return 0;
            }
            try {
                JSONObject jSONObject = new JSONObject(eq.a(b));
                String str2 = "code";
                return jSONObject.has(str2) ? jSONObject.getInt(str2) : 0;
            } catch (Throwable e) {
                es.a(e, "LogProcessor", "processUpdate");
                return 1;
            }
        } catch (Throwable e2) {
            if (e2.b != 27) {
                i = 1;
            }
            es.a(e2, "LogProcessor", "processUpdate");
            return i;
        }
    }

    private String d(String str) {
        Throwable e;
        String str2;
        String str3;
        InputStream inputStream;
        Throwable th;
        Object obj;
        String str4 = null;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            if (this.d == null) {
                if (str4 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        es.a(e2, "LogProcessor", "readLog1");
                    }
                }
                if (str4 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                        e = e3;
                        str2 = "LogProcessor";
                        str3 = "readLog2";
                        es.a(e, str2, str3);
                        return str4;
                    }
                }
                return str4;
            }
            ba a = this.d.a(str);
            if (a == null) {
                if (str4 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e22) {
                        es.a(e22, "LogProcessor", "readLog1");
                    }
                }
                if (str4 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e4) {
                        e = e4;
                        str2 = "LogProcessor";
                        str3 = "readLog2";
                        es.a(e, str2, str3);
                        return str4;
                    }
                }
                return str4;
            }
            inputStream = a.a[0];
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str4 = eq.a(byteArrayOutputStream.toByteArray());
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e5) {
                            es.a(e5, "LogProcessor", "readLog1");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            e5 = e6;
                            str2 = "LogProcessor";
                            str3 = "readLog2";
                            es.a(e5, str2, str3);
                            return str4;
                        }
                    }
                } catch (Throwable th2) {
                    e5 = th2;
                    try {
                        es.a(e5, "LogProcessor", "readLog");
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e52) {
                                es.a(e52, "LogProcessor", "readLog1");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                                e52 = e7;
                                str2 = "LogProcessor";
                                str3 = "readLog2";
                                es.a(e52, str2, str3);
                                return str4;
                            }
                        }
                        return str4;
                    } catch (Throwable th3) {
                        th = th3;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e522) {
                                es.a(e522, "LogProcessor", "readLog1");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e5222) {
                                es.a(e5222, "LogProcessor", "readLog2");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable e52222) {
                obj = str4;
                th = e52222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
            return str4;
        } catch (Throwable e522222) {
            byteArrayOutputStream = str4;
            inputStream = str4;
            th = e522222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static List<ep> d(Context context) {
        Throwable th;
        List<ep> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    List<ep> a = new w(context, false).a();
                    try {
                        return a;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        list = a;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        throw th;
                    } catch (Throwable th5) {
                        return list;
                    }
                }
            }
        } catch (Throwable th6) {
            return null;
        }
    }

    private static String e(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"key\":\"").append(dx.f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(ei.q(context)).append("\",\"pkg\":\"").append(dx.c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appname\":\"").append(dx.b(context)).append("\",\"appversion\":\"").append(dx.d(context)).append("\",\"sysversion\":\"").append(VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            es.a(th, "CInfo", "getPublicJSONInfo");
        }
        return stringBuilder.toString();
    }

    private static String f(Context context) {
        String str = null;
        try {
            String e = e(context);
            if (!"".equals(e)) {
                str = eg.a(context, eq.a(e));
            }
        } catch (Throwable th) {
            es.a(th, "LogProcessor", "getPublicInfo");
        }
        return str;
    }

    protected abstract String a(List<ep> list);

    final void a() {
        try {
            if (this.d != null && !this.d.a()) {
                this.d.close();
            }
        } catch (Throwable e) {
            es.a(e, "LogProcessor", "closeDiskLru");
        } catch (Throwable e2) {
            es.a(e2, "LogProcessor", "closeDiskLru");
        }
    }

    final void a(Context context) {
        List d = d(context);
        if (d != null && d.size() != 0) {
            String a = a(d);
            if (a != null && !"".equals(a)) {
                String b = b();
                String a2 = a(context, this.a);
                dx.a(context);
                int i = this.b;
                b = a(a2, b, i, "ANR", a);
                if (b != null && !"".equals(b)) {
                    a2 = a(a);
                    String a3 = a(context, b);
                    String c = ew.c(this.b);
                    synchronized (Looper.getMainLooper()) {
                        u uVar = new u(context);
                        a(context, a2, c, a3, uVar);
                        a(uVar, this.a.a(), a2, i);
                    }
                }
            }
        }
    }

    final void a(Context context, Throwable th, String str, String str2) {
        List<ep> d = d(context);
        if (d != null && d.size() != 0) {
            String a = a(th);
            if (a != null && !"".equals(a)) {
                for (ep epVar : d) {
                    if (a(epVar.d(), a)) {
                        a(epVar, context, th, a, str, str2);
                        return;
                    }
                }
                if (a.contains("com.amap.api.col")) {
                    try {
                        a(new eo("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a(), context, th, a, str, str2);
                    } catch (dw e) {
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void b(android.content.Context r12) {
        /*
        r11 = this;
        r2 = 1;
        r3 = 0;
        r0 = r11.b;	 Catch:{ Throwable -> 0x0015 }
        r0 = com.loc.ew.c(r0);	 Catch:{ Throwable -> 0x0015 }
        r0 = b(r12, r0);	 Catch:{ Throwable -> 0x0015 }
        r11.d = r0;	 Catch:{ Throwable -> 0x0015 }
    L_0x000e:
        r0 = r11.c(r12);	 Catch:{ Throwable -> 0x001e }
        if (r0 != 0) goto L_0x0027;
    L_0x0014:
        return;
    L_0x0015:
        r0 = move-exception;
        r1 = "LogProcessor";
        r4 = "LogUpDateProcessor";
        com.loc.es.a(r0, r1, r4);	 Catch:{ Throwable -> 0x001e }
        goto L_0x000e;
    L_0x001e:
        r0 = move-exception;
        r1 = "LogProcessor";
        r2 = "processUpdateLog";
        com.loc.es.a(r0, r1, r2);
        goto L_0x0014;
    L_0x0027:
        r4 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x001e }
        monitor-enter(r4);	 Catch:{ Throwable -> 0x001e }
        r5 = new com.loc.u;	 Catch:{ all -> 0x0054 }
        r5.<init>(r12);	 Catch:{ all -> 0x0054 }
        r0 = r11.b;	 Catch:{ all -> 0x0054 }
        r1 = 2;
        r0 = com.loc.ew.a(r0);	 Catch:{ Throwable -> 0x0057 }
        r0 = r5.a(r1, r0);	 Catch:{ Throwable -> 0x0057 }
        r11.a(r0, r5);	 Catch:{ Throwable -> 0x0057 }
    L_0x003f:
        r0 = 0;
        r1 = r11.b;	 Catch:{ all -> 0x0054 }
        r1 = com.loc.ew.a(r1);	 Catch:{ all -> 0x0054 }
        r6 = r5.a(r0, r1);	 Catch:{ all -> 0x0054 }
        if (r6 == 0) goto L_0x0052;
    L_0x004c:
        r0 = r6.size();	 Catch:{ all -> 0x0054 }
        if (r0 != 0) goto L_0x0060;
    L_0x0052:
        monitor-exit(r4);	 Catch:{ all -> 0x0054 }
        goto L_0x0014;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0054 }
        throw r0;	 Catch:{ Throwable -> 0x001e }
    L_0x0057:
        r0 = move-exception;
        r1 = "LogProcessor";
        r6 = "processDeleteFail";
        com.loc.es.a(r0, r1, r6);	 Catch:{ all -> 0x0054 }
        goto L_0x003f;
    L_0x0060:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0054 }
        r7.<init>();	 Catch:{ all -> 0x0054 }
        r0 = "{\"pinfo\":\"";
        r0 = r7.append(r0);	 Catch:{ all -> 0x0054 }
        r1 = f(r12);	 Catch:{ all -> 0x0054 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0054 }
        r1 = "\",\"els\":[";
        r0.append(r1);	 Catch:{ all -> 0x0054 }
        r8 = r6.iterator();	 Catch:{ all -> 0x0054 }
        r1 = r2;
    L_0x007d:
        r0 = r8.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x00d1;
    L_0x0083:
        r0 = r8.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.loc.v) r0;	 Catch:{ all -> 0x0054 }
        r9 = r0.b();	 Catch:{ all -> 0x0054 }
        r9 = r11.d(r9);	 Catch:{ all -> 0x0054 }
        if (r9 == 0) goto L_0x00ef;
    L_0x0093:
        r10 = "";
        r10 = r10.equals(r9);	 Catch:{ all -> 0x0054 }
        if (r10 != 0) goto L_0x00ef;
    L_0x009b:
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0054 }
        r10.<init>();	 Catch:{ all -> 0x0054 }
        r9 = r10.append(r9);	 Catch:{ all -> 0x0054 }
        r10 = "||";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0054 }
        r0 = r0.c();	 Catch:{ all -> 0x0054 }
        r0 = r9.append(r0);	 Catch:{ all -> 0x0054 }
        r9 = r0.toString();	 Catch:{ all -> 0x0054 }
        if (r1 == 0) goto L_0x00ca;
    L_0x00b8:
        r0 = r3;
    L_0x00b9:
        r1 = "{\"log\":\"";
        r1 = r7.append(r1);	 Catch:{ all -> 0x0054 }
        r1 = r1.append(r9);	 Catch:{ all -> 0x0054 }
        r9 = "\"}";
        r1.append(r9);	 Catch:{ all -> 0x0054 }
    L_0x00c8:
        r1 = r0;
        goto L_0x007d;
    L_0x00ca:
        r0 = ",";
        r7.append(r0);	 Catch:{ all -> 0x0054 }
        r0 = r1;
        goto L_0x00b9;
    L_0x00d1:
        if (r1 == 0) goto L_0x00d9;
    L_0x00d3:
        r0 = 0;
    L_0x00d4:
        if (r0 != 0) goto L_0x00e3;
    L_0x00d6:
        monitor-exit(r4);	 Catch:{ all -> 0x0054 }
        goto L_0x0014;
    L_0x00d9:
        r0 = "]}";
        r7.append(r0);	 Catch:{ all -> 0x0054 }
        r0 = r7.toString();	 Catch:{ all -> 0x0054 }
        goto L_0x00d4;
    L_0x00e3:
        r0 = c(r0);	 Catch:{ all -> 0x0054 }
        if (r0 != r2) goto L_0x00ec;
    L_0x00e9:
        r11.a(r6, r5);	 Catch:{ all -> 0x0054 }
    L_0x00ec:
        monitor-exit(r4);	 Catch:{ all -> 0x0054 }
        goto L_0x0014;
    L_0x00ef:
        r0 = r1;
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.l.b(android.content.Context):void");
    }

    protected abstract boolean c(Context context);

    final void a(ep epVar, Context context, Throwable th, String str, String str2, String str3) {
        a(epVar, context, th.toString(), str, str2, str3);
    }

    final void a(ep epVar, Context context, String str, String str2, String str3, String str4) {
        this.a = epVar;
        String b = b();
        String a = a(context, epVar);
        dx.a(context);
        if (str != null && !"".equals(str)) {
            int i = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            if (str3 != null) {
                stringBuilder.append("class:").append(str3);
            }
            if (str4 != null) {
                stringBuilder.append(" method:").append(str4).append("$<br/>");
            }
            stringBuilder.append(str2);
            String a2 = a(str2);
            b = a(a, b, i, str, stringBuilder.toString());
            if (b != null && !"".equals(b)) {
                String a3 = a(context, b);
                String c = ew.c(this.b);
                synchronized (Looper.getMainLooper()) {
                    u uVar = new u(context);
                    a(context, a2, c, a3, uVar);
                    a(uVar, epVar.a(), a2, i);
                }
            }
        }
    }

    protected String a(String str) {
        return eq.e(ek.c(str));
    }
}
