package com.uc.webview.export.internal.uc.wa;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.Build;
import com.uc.webview.export.Build.Version;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.utility.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.android.spdy.SpdyRequest;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class a {
    public static boolean a = true;
    public static int d = 20480;
    public static int e = 5242880;
    public static int f = (d + 1024);
    private static a i;
    public Handler b;
    public List<b> c;
    public SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Object h = new Object();
    private Context j;
    private HandlerThread k = new HandlerThread("SDKWaStatThread", 0);
    private Map<String, a> l;
    private SimpleDateFormat m = new SimpleDateFormat("yyyyMMdd");

    /* compiled from: ProGuard */
    final class a {
        Map<String, Integer> a;
        Map<String, String> b;
        final /* synthetic */ a c;

        private a(a aVar) {
            this.c = aVar;
            this.a = new HashMap();
            this.b = new HashMap();
        }

        public final String toString() {
            return "Int Data: " + this.a.toString() + " String Data: " + this.b.toString();
        }
    }

    /* compiled from: ProGuard */
    public final class b {
        String a;
        Map<String, String> b;
        final /* synthetic */ a c;

        public b(a aVar, String str, Map<String, String> map) {
            this.c = aVar;
            this.a = str;
            this.b = map;
        }

        public final String toString() {
            return "Key: " + this.a + " Data: " + this.b.toString();
        }
    }

    static /* synthetic */ String a(String str, boolean z) {
        String str2 = "27120f2b4115";
        String valueOf = String.valueOf(System.currentTimeMillis());
        String a = f.a(str2 + str + valueOf + "AppChk#2014");
        StringBuilder stringBuilder = new StringBuilder("https://applog.uc.cn/collect?uc_param_str=&chk=");
        stringBuilder.append(a.substring(a.length() - 8, a.length())).append("&vno=").append(valueOf).append("&uuid=").append(str).append("&app=").append(str2);
        if (z) {
            stringBuilder.append("&enc=aes");
        }
        return stringBuilder.toString();
    }

    static /* synthetic */ void a(a aVar, long j, String str) {
        Editor edit = aVar.j.getSharedPreferences("UC_WA_STAT", 4).edit();
        edit.putLong(h(), j);
        if (str != null) {
            edit.putString("4", str);
        }
        edit.commit();
    }

    static /* synthetic */ byte[] a(a aVar, String[] strArr) {
        Object[] i = aVar.i();
        if (i == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lt=uc");
        Map map = (Map) i[0];
        List<b> list = (List) i[1];
        List b = b(aVar.j);
        List<String[]> b2 = aVar.b(b);
        strArr[0] = b(map, (List) list);
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() >= d) {
                if (Utils.sWAPrintLog) {
                    Log.d("SDKWaStat", "getUploadData MergeData size(" + stringBuilder.length() + ") more then " + d);
                }
                for (b bVar : list) {
                    if (stringBuilder.length() < d) {
                        if (Utils.sWAPrintLog) {
                            Log.d("SDKWaStat", "getUploadData UnMergeData size(" + stringBuilder.length() + ") more then " + d);
                        }
                        if (Utils.sWAPrintLog) {
                            Log.i("SDKWaStat", "getUploadData:\n" + stringBuilder.toString());
                        }
                        stringBuilder.append("\n");
                        a(stringBuilder, "stat_size", String.valueOf(stringBuilder.toString().getBytes().length));
                        return stringBuilder.toString().getBytes();
                    }
                    stringBuilder.append("\n");
                    for (String[] strArr2 : b2) {
                        a(stringBuilder, strArr2[0], strArr2[1]);
                    }
                    for (Entry entry2 : bVar.b.entrySet()) {
                        a(stringBuilder, (String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                if (Utils.sWAPrintLog) {
                    Log.i("SDKWaStat", "getUploadData:\n" + stringBuilder.toString());
                }
                stringBuilder.append("\n");
                a(stringBuilder, "stat_size", String.valueOf(stringBuilder.toString().getBytes().length));
                return stringBuilder.toString().getBytes();
            }
            String b3 = b(((a) entry2.getValue()).b);
            stringBuilder.append("\n");
            for (String[] strArr3 : b2) {
                a(stringBuilder, strArr3[0], strArr3[1]);
            }
            if (!d.d() && b3.equals(strArr[0])) {
                for (String[] strArr32 : aVar.a(b, strArr[0])) {
                    a(stringBuilder, strArr32[0], strArr32[1]);
                }
            }
            for (Entry entry3 : ((a) entry2.getValue()).a.entrySet()) {
                a(stringBuilder, (String) entry3.getKey(), String.valueOf(entry3.getValue()));
            }
            for (Entry entry22 : ((a) entry22.getValue()).b.entrySet()) {
                a(stringBuilder, (String) entry22.getKey(), (String) entry22.getValue());
            }
            for (Entry entry222 : SDKFactory.z.entrySet()) {
                a(stringBuilder, (String) entry222.getKey(), String.valueOf(((Integer) entry222.getValue()).intValue()));
            }
        }
        for (b bVar2 : list) {
            if (stringBuilder.length() < d) {
                stringBuilder.append("\n");
                for (String[] strArr22 : b2) {
                    a(stringBuilder, strArr22[0], strArr22[1]);
                }
                for (Entry entry2222 : bVar2.b.entrySet()) {
                    a(stringBuilder, (String) entry2222.getKey(), (String) entry2222.getValue());
                }
            } else {
                if (Utils.sWAPrintLog) {
                    Log.d("SDKWaStat", "getUploadData UnMergeData size(" + stringBuilder.length() + ") more then " + d);
                }
                if (Utils.sWAPrintLog) {
                    Log.i("SDKWaStat", "getUploadData:\n" + stringBuilder.toString());
                }
                stringBuilder.append("\n");
                a(stringBuilder, "stat_size", String.valueOf(stringBuilder.toString().getBytes().length));
                return stringBuilder.toString().getBytes();
            }
        }
        if (Utils.sWAPrintLog) {
            Log.i("SDKWaStat", "getUploadData:\n" + stringBuilder.toString());
        }
        stringBuilder.append("\n");
        a(stringBuilder, "stat_size", String.valueOf(stringBuilder.toString().getBytes().length));
        return stringBuilder.toString().getBytes();
    }

    static /* synthetic */ void b(String str) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setStringValue("SDKUUID", str);
        }
    }

    static /* synthetic */ void c(a aVar) {
        if (b()) {
            new e(aVar).start();
        }
    }

    private a() {
        this.k.start();
        this.b = new Handler(this.k.getLooper());
    }

    public static a a() {
        if (i == null && SDKFactory.e != null) {
            a(SDKFactory.e);
        }
        return i;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (b()) {
                if (i == null) {
                    i = new a();
                }
                i.j = context.getApplicationContext();
            }
        }
    }

    public static boolean b() {
        return ((Boolean) SDKFactory.invoke(10006, "stat", Boolean.valueOf(true))).booleanValue();
    }

    public final void a(String str) {
        if (b()) {
            a(str, 0, 0, 1, null);
        }
    }

    public static void a(Pair<String, HashMap<String, String>> pair) {
        UCLogger create = UCLogger.create("d", "SDKWaStat");
        if (create != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ev_ac=").append((String) pair.first);
            for (Entry entry : ((HashMap) pair.second).entrySet()) {
                String str = (String) entry.getKey();
                stringBuilder.append("`").append(str).append("=").append((String) entry.getValue());
            }
            create.print(stringBuilder.toString(), new Throwable[0]);
        }
    }

    public final void a(String str, int i, int i2, int i3, String str2) {
        Date date = new Date(System.currentTimeMillis());
        int intValue = ((Boolean) SDKFactory.invoke(10010, new Object[0])).booleanValue() ? ((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() : 0;
        if (!(intValue == 2 || intValue == 0)) {
            intValue = (intValue * 10) + SDKFactory.n;
        }
        String str3 = this.m.format(date) + "~" + intValue;
        synchronized (this.h) {
            a aVar;
            if (this.l == null) {
                this.l = new HashMap();
            }
            a aVar2 = (a) this.l.get(str3);
            if (aVar2 == null) {
                aVar2 = new a();
                this.l.put(str3, aVar2);
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
            aVar.b.put("tm", this.g.format(date));
            Integer num;
            switch (i) {
                case 0:
                    num = (Integer) aVar.a.get(str);
                    if (num != null) {
                        aVar.a.put(str, Integer.valueOf(num.intValue() + i3));
                        break;
                    } else {
                        aVar.a.put(str, Integer.valueOf(i3));
                        break;
                    }
                case 1:
                    if (i2 != 1) {
                        aVar.b.put(str, ((String) aVar.b.get(str)) + "|" + str2);
                        break;
                    } else {
                        aVar.b.put(str, str2);
                        break;
                    }
                case 2:
                    num = (Integer) aVar.a.get(str);
                    if (num == null || Integer.MAX_VALUE - num.intValue() >= i3) {
                        if (num != null) {
                            aVar.a.put(str, Integer.valueOf(num.intValue() + i3));
                            aVar.a.put(str + "_sc", Integer.valueOf(((Integer) aVar.a.get(str + "_sc")).intValue() + 1));
                            break;
                        }
                        aVar.a.put(str, Integer.valueOf(i3));
                        aVar.a.put(str + "_sc", Integer.valueOf(1));
                        break;
                    }
            }
        }
    }

    public final void a(boolean z) {
        if (b() && !com.uc.webview.export.internal.utility.a.a((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
            try {
                new b(this).start();
                if (z) {
                    Thread.sleep(20);
                }
            } catch (Throwable e) {
                Log.e("SDKWaStat", "saveData", e);
            }
        }
    }

    private synchronized void e() {
        if (b()) {
            try {
                if (Utils.sWAPrintLog) {
                    Log.d("SDKWaStat", "saveData");
                }
                Map hashMap = new HashMap();
                List arrayList = new ArrayList();
                synchronized (this.h) {
                    if (((Boolean) SDKFactory.invoke(10010, new Object[0])).booleanValue() && !a(this.l)) {
                        hashMap.putAll(this.l);
                        this.l.clear();
                    }
                    if (!a(this.c)) {
                        arrayList.addAll(this.c);
                        this.c.clear();
                    }
                }
                a(hashMap, arrayList);
            } catch (Exception e) {
            }
        }
    }

    private String f() {
        String str = this.j.getApplicationContext().getApplicationInfo().dataDir + "/ucwa";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    private static String g() {
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (com.uc.webview.export.internal.utility.a.a(str) || str.equals(SettingsConst.FALSE)) {
            return "wa_upload_new.wa";
        }
        return "wa_upload_new.wa_" + str;
    }

    private static String h() {
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (com.uc.webview.export.internal.utility.a.a(str) || str.equals(SettingsConst.FALSE)) {
            return SettingsConst.TRUE;
        }
        return "1_" + str;
    }

    private static boolean a(List list) {
        return list == null || list.size() == 0;
    }

    private static boolean a(Map map) {
        return map == null || map.size() == 0;
    }

    private void a(Map<String, a> map, List<b> list) {
        Closeable closeable;
        Object obj;
        Closeable closeable2;
        Closeable closeable3;
        Closeable closeable4;
        Throwable th;
        int i = 0;
        Closeable closeable5 = null;
        if (!a((Map) map) || !a((List) list)) {
            File file = new File(f(), g());
            if (Utils.sWAPrintLog) {
                Log.d("SDKWaStat", "savePVToFile:" + file);
            }
            try {
                int available;
                int i2;
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        available = fileInputStream.available();
                        fileInputStream.close();
                        i2 = available;
                    } catch (Exception e) {
                        closeable = null;
                        obj = fileInputStream;
                        closeable2 = null;
                        UCCyclone.close(closeable2);
                        UCCyclone.close(closeable5);
                        UCCyclone.close(closeable);
                        UCCyclone.close(closeable3);
                    } catch (Throwable th2) {
                        closeable4 = null;
                        closeable = null;
                        Throwable th3 = th2;
                        obj = fileInputStream;
                        th = th3;
                        UCCyclone.close(closeable4);
                        UCCyclone.close(closeable);
                        UCCyclone.close(closeable5);
                        UCCyclone.close(closeable3);
                        throw th;
                    }
                }
                i2 = 0;
                if (i2 >= d) {
                    if (Utils.sWAPrintLog) {
                        Log.d("SDKWaStat", "file size(" + i2 + ") more then " + d);
                    }
                    UCCyclone.close(null);
                    UCCyclone.close(null);
                    UCCyclone.close(null);
                    UCCyclone.close(null);
                    return;
                }
                closeable = new FileOutputStream(file, true);
                try {
                    closeable4 = new BufferedWriter(new OutputStreamWriter(closeable), 1024);
                    try {
                        b bVar;
                        int a;
                        available = 0;
                        for (Entry entry : map.entrySet()) {
                            if (available + i2 >= d) {
                                if (Utils.sWAPrintLog) {
                                    Log.d("SDKWaStat", "write merge data, size(" + (available + i2) + ") more then " + d);
                                }
                                while (i < 10 && i < list.size()) {
                                    if (available + i2 >= d) {
                                        Log.d("SDKWaStat", "write un merge data, size(" + (available + i2) + ") more then " + d);
                                        break;
                                    }
                                    bVar = (b) list.get(i);
                                    closeable4.write("@1");
                                    available += 2;
                                    closeable4.write("@k@");
                                    available += 3;
                                    closeable4.write(bVar.a);
                                    available += bVar.a.length();
                                    closeable4.write("@d@");
                                    a = a((BufferedWriter) closeable4, bVar.b, 1) + (available + 3);
                                    closeable4.newLine();
                                    i++;
                                    available = a;
                                }
                                UCCyclone.close(closeable4);
                                UCCyclone.close(closeable);
                                UCCyclone.close(closeable);
                                UCCyclone.close(null);
                            }
                            closeable4.write("@0");
                            available += 2;
                            closeable4.write("@k@");
                            int i3 = available + 3;
                            String str = (String) entry.getKey();
                            String[] split = str.split("~");
                            if (split[1].equals(SettingsConst.FALSE)) {
                                available = ((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue();
                                if (available != 2) {
                                    available = (available * 10) + SDKFactory.n;
                                }
                                str = split[0] + "~" + available;
                            }
                            closeable4.write(str);
                            available = str.length() + i3;
                            closeable4.write("@d@");
                            available = (a((BufferedWriter) closeable4, ((a) entry.getValue()).a, 0) + (available + 3)) + a((BufferedWriter) closeable4, ((a) entry.getValue()).b, 1);
                            closeable4.newLine();
                        }
                        while (i < 10) {
                            if (available + i2 >= d) {
                                Log.d("SDKWaStat", "write un merge data, size(" + (available + i2) + ") more then " + d);
                                break;
                            }
                            bVar = (b) list.get(i);
                            closeable4.write("@1");
                            available += 2;
                            closeable4.write("@k@");
                            available += 3;
                            closeable4.write(bVar.a);
                            available += bVar.a.length();
                            closeable4.write("@d@");
                            a = a((BufferedWriter) closeable4, bVar.b, 1) + (available + 3);
                            closeable4.newLine();
                            i++;
                            available = a;
                        }
                        UCCyclone.close(closeable4);
                        UCCyclone.close(closeable);
                        UCCyclone.close(closeable);
                        UCCyclone.close(null);
                    } catch (Exception e2) {
                        closeable2 = closeable4;
                        closeable3 = null;
                        closeable5 = closeable;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable3 = null;
                        closeable5 = closeable;
                    }
                } catch (Exception e3) {
                    closeable2 = null;
                    closeable3 = null;
                    closeable5 = closeable;
                    UCCyclone.close(closeable2);
                    UCCyclone.close(closeable5);
                    UCCyclone.close(closeable);
                    UCCyclone.close(closeable3);
                } catch (Throwable th5) {
                    th = th5;
                    closeable4 = null;
                    closeable3 = null;
                    closeable5 = closeable;
                    UCCyclone.close(closeable4);
                    UCCyclone.close(closeable);
                    UCCyclone.close(closeable5);
                    UCCyclone.close(closeable3);
                    throw th;
                }
            } catch (Exception e4) {
                closeable2 = null;
                closeable = null;
                closeable3 = null;
                UCCyclone.close(closeable2);
                UCCyclone.close(closeable5);
                UCCyclone.close(closeable);
                UCCyclone.close(closeable3);
            } catch (Throwable th6) {
                th = th6;
                closeable4 = null;
                closeable = null;
                closeable3 = null;
                UCCyclone.close(closeable4);
                UCCyclone.close(closeable);
                UCCyclone.close(closeable5);
                UCCyclone.close(closeable3);
                throw th;
            }
        }
    }

    private static <T> int a(BufferedWriter bufferedWriter, Map<String, T> map, int i) throws Exception {
        if (a((Map) map)) {
            return 0;
        }
        int i2 = 0;
        for (Entry entry : map.entrySet()) {
            bufferedWriter.write((String) entry.getKey());
            bufferedWriter.write("=");
            bufferedWriter.write("#" + i);
            bufferedWriter.write(entry.getValue() + "`");
            i2 = ((entry.getValue() + "`").length() + ((((String) entry.getKey()).length() + 1) + ("#" + i).length())) + i2;
        }
        return i2;
    }

    private Object[] i() {
        Closeable fileInputStream;
        Throwable th;
        File file = new File(f(), g());
        if (Utils.sWAPrintLog) {
            Log.d("SDKWaStat", "getPVFromFile:" + file + " exists:" + file.exists());
        }
        if (!file.exists()) {
            return null;
        }
        Closeable closeable = null;
        Closeable closeable2 = null;
        Closeable closeable3 = null;
        file.length();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String readLine;
                closeable2 = new BufferedReader(new InputStreamReader(fileInputStream), 1024);
                int i = 0;
                while (true) {
                    try {
                        readLine = closeable2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (Utils.sWAPrintLog) {
                            Log.d("SDKWaStat", readLine);
                        }
                        if (!com.uc.webview.export.internal.utility.a.a(readLine)) {
                            if (readLine.length() + i > d) {
                                break;
                            }
                            int length = i + readLine.length();
                            String trim = readLine.trim();
                            if (trim.startsWith("@0") || trim.startsWith("@1")) {
                                int indexOf = trim.indexOf("@k@");
                                int indexOf2 = trim.indexOf("@d@");
                                if (indexOf >= 0 && indexOf2 >= 0) {
                                    readLine = trim.substring(indexOf + 3, indexOf2);
                                    String[] split = trim.substring(indexOf2 + 3).split("`");
                                    if (trim.startsWith("@0")) {
                                        String[] split2 = readLine.split("~");
                                        if (split2.length == 2 && split2[0].length() == 8 && split2[1].length() <= 2) {
                                            a aVar;
                                            a aVar2 = (a) hashMap.get(readLine);
                                            if (aVar2 != null) {
                                                aVar = aVar2;
                                            } else if (hashMap.size() == 8) {
                                                if (arrayList.size() == 10) {
                                                    break;
                                                }
                                            } else {
                                                a aVar3 = this;
                                                aVar2 = new a();
                                                hashMap.put(readLine, aVar2);
                                                aVar = aVar2;
                                            }
                                            for (String trim2 : split) {
                                                String[] split3 = trim2.split("=");
                                                if (split3.length == 2 && split3[1].length() > 2) {
                                                    String substring = split3[1].substring(2);
                                                    if (split3[1].startsWith("#0")) {
                                                        Integer num = (Integer) aVar.a.get(split3[0]);
                                                        if (num == null) {
                                                            aVar.a.put(split3[0], Integer.valueOf(Integer.parseInt(substring)));
                                                        } else {
                                                            aVar.a.put(split3[0], Integer.valueOf(num.intValue() + Integer.parseInt(substring)));
                                                        }
                                                    } else if (split3[1].startsWith("#1")) {
                                                        aVar.b.put(split3[0], substring);
                                                    }
                                                }
                                            }
                                            aVar.b.put("core_t", split2[1]);
                                            i = length;
                                        }
                                    } else if (arrayList.size() != 10) {
                                        Map hashMap2 = new HashMap(split.length);
                                        for (String split4 : split) {
                                            String[] split5 = split4.split("=");
                                            if (split5.length == 2) {
                                                hashMap2.put(split5[0], split5[1].substring(2));
                                            }
                                        }
                                        hashMap2.put("ev_ac", readLine);
                                        arrayList.add(new b(this, readLine, hashMap2));
                                        i = length;
                                    }
                                }
                            }
                            i = length;
                        }
                    } catch (Exception e) {
                        closeable3 = closeable2;
                        closeable2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = fileInputStream;
                    }
                }
                if (Utils.sWAPrintLog) {
                    Log.d("SDKWaStat", "upload data size(" + (i + readLine.length()) + ") more then " + d);
                }
                if (hashMap.size() > 0 || arrayList.size() > 0) {
                    Object[] objArr = new Object[]{hashMap, arrayList};
                    UCCyclone.close(closeable2);
                    UCCyclone.close(fileInputStream);
                    UCCyclone.close(fileInputStream);
                    return objArr;
                }
                UCCyclone.close(closeable2);
                UCCyclone.close(fileInputStream);
                UCCyclone.close(fileInputStream);
                return null;
            } catch (Exception e2) {
                closeable2 = fileInputStream;
                UCCyclone.close(closeable3);
                UCCyclone.close(closeable2);
                UCCyclone.close(fileInputStream);
                return null;
            } catch (Throwable th3) {
                closeable = fileInputStream;
                th = th3;
                closeable2 = null;
                UCCyclone.close(closeable2);
                UCCyclone.close(fileInputStream);
                UCCyclone.close(closeable);
                throw th;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            UCCyclone.close(closeable3);
            UCCyclone.close(closeable2);
            UCCyclone.close(fileInputStream);
            return null;
        } catch (Throwable th4) {
            Throwable th5 = th4;
            fileInputStream = null;
            closeable2 = null;
            th = th5;
            UCCyclone.close(closeable2);
            UCCyclone.close(fileInputStream);
            UCCyclone.close(closeable);
            throw th;
        }
    }

    private List<String[]> b(List<PackageInfo> list) {
        int i;
        String str;
        Object obj;
        for (PackageInfo packageInfo : list) {
            if (!packageInfo.packageName.equals("com.UCMobile")) {
                if (packageInfo.packageName.equals("com.UCMobile.intl")) {
                    i = 2;
                    break;
                }
            }
            i = 1;
            break;
        }
        i = 0;
        List<String[]> arrayList = new ArrayList();
        arrayList.add(new String[]{"lt", "ev"});
        arrayList.add(new String[]{"ct", "corepv"});
        arrayList.add(new String[]{"ver", Version.NAME});
        arrayList.add(new String[]{"pkg", this.j.getPackageName()});
        arrayList.add(new String[]{"sdk_sn", Build.TIME});
        Object obj2 = new String[2];
        obj2[0] = "sdk_pm";
        obj2[1] = com.uc.webview.export.internal.utility.a.a(android.os.Build.MODEL) ? "unknown" : android.os.Build.MODEL.trim().replaceAll("[`|=]", "");
        arrayList.add(obj2);
        obj2 = new String[2];
        obj2[0] = "sdk_f";
        StringBuilder stringBuilder = new StringBuilder();
        if (!((Boolean) SDKFactory.invoke(10003, Long.valueOf(524288))).booleanValue()) {
            if (SDKFactory.invoke(10036, this.j) != null) {
                str = SettingsConst.TRUE;
                stringBuilder.append(str).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(1))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(SDKFactory.k ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(2))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(4))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(8))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(16))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(32))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(64))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(128))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(256))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(512))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(1024))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(2048))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(4096))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(8192))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(16384))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(32768))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(65536))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(131072))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(262144))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE);
                obj2[1] = stringBuilder.toString();
                arrayList.add(obj2);
                arrayList.add(new String[]{"sdk_uf", String.valueOf(i)});
                obj2 = new String[2];
                obj2[0] = "sdk_bd";
                if (com.uc.webview.export.internal.utility.a.a(android.os.Build.BRAND)) {
                    str = android.os.Build.BRAND.trim().replaceAll("[`|=]", "");
                } else {
                    str = "unknown";
                }
                obj2[1] = str;
                arrayList.add(obj2);
                arrayList.add(new String[]{"sdk_osv", VERSION.RELEASE});
                arrayList.add(new String[]{"sdk_prd", Build.SDK_PRD});
                arrayList.add(new String[]{"sdk_pfid", Build.SDK_PROFILE_ID});
                arrayList.add(new String[]{"sdk_cos", d.c()});
                arrayList.add(new String[]{"pro_sf", (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION)});
                arrayList.add(new String[]{"uuid", a(this.j.getSharedPreferences("UC_WA_STAT", 4))});
                if (!com.uc.webview.export.internal.utility.a.a((String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_TIMING))) {
                    arrayList.add(new String[]{"ab_sn", (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_TIMING)});
                }
                if (!com.uc.webview.export.internal.utility.a.a((String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM))) {
                    arrayList.add(new String[]{"ab_ve", (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM)});
                }
                if (!com.uc.webview.export.internal.utility.a.a(Build.CORE_VERSION)) {
                    arrayList.add(new String[]{"sdk_sdk_cv", Build.CORE_VERSION.trim()});
                }
                if (i == 0) {
                    obj = new String[2];
                    obj[0] = "sdk_ucbackup";
                    obj[1] = new File("/sdcard/Backucup/com.UCMobile").exists() ? SettingsConst.TRUE : SettingsConst.FALSE;
                    arrayList.add(obj);
                }
                obj = new String[2];
                obj[0] = IWaStat.VIDEO_AC;
                obj[1] = ((Boolean) SDKFactory.invoke(10003, Long.valueOf(1048576))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE;
                arrayList.add(obj);
                if (com.uc.webview.export.internal.utility.a.a(com.uc.webview.export.internal.utility.d.a.a(this.j))) {
                    arrayList.add(new String[]{IWaStat.UTDID_KEY, com.uc.webview.export.internal.utility.d.a.a(this.j)});
                } else {
                    arrayList.add(new String[]{IWaStat.UTDID_KEY, "null"});
                }
                arrayList.add(new String[]{"data_dir", this.j.getApplicationInfo().dataDir});
                if (((File) ReflectionUtil.invokeNoThrow(this.j, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{"UC_WA_STAT"})) != null) {
                    arrayList.add(new String[]{"sp_dir", ((File) ReflectionUtil.invokeNoThrow(this.j, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{"UC_WA_STAT"})).getAbsolutePath()});
                }
                return arrayList;
            }
        }
        str = SettingsConst.FALSE;
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(1))).booleanValue()) {
        }
        if (SDKFactory.k) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(2))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(4))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(8))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(16))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(32))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(64))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(128))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(256))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(512))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(1024))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(2048))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(4096))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(8192))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(16384))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(32768))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(65536))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(131072))).booleanValue()) {
        }
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(262144))).booleanValue()) {
        }
        stringBuilder.append(str).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(1))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(SDKFactory.k ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(2))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(4))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(8))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(16))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(32))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(64))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(128))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(256))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(512))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(1024))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(2048))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(4096))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(8192))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(16384))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(32768))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(65536))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(131072))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).append(((Boolean) SDKFactory.invoke(10003, Long.valueOf(262144))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE);
        obj2[1] = stringBuilder.toString();
        arrayList.add(obj2);
        arrayList.add(new String[]{"sdk_uf", String.valueOf(i)});
        obj2 = new String[2];
        obj2[0] = "sdk_bd";
        if (com.uc.webview.export.internal.utility.a.a(android.os.Build.BRAND)) {
            str = android.os.Build.BRAND.trim().replaceAll("[`|=]", "");
        } else {
            str = "unknown";
        }
        obj2[1] = str;
        arrayList.add(obj2);
        arrayList.add(new String[]{"sdk_osv", VERSION.RELEASE});
        arrayList.add(new String[]{"sdk_prd", Build.SDK_PRD});
        arrayList.add(new String[]{"sdk_pfid", Build.SDK_PROFILE_ID});
        arrayList.add(new String[]{"sdk_cos", d.c()});
        arrayList.add(new String[]{"pro_sf", (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION)});
        arrayList.add(new String[]{"uuid", a(this.j.getSharedPreferences("UC_WA_STAT", 4))});
        if (com.uc.webview.export.internal.utility.a.a((String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_TIMING))) {
            arrayList.add(new String[]{"ab_sn", (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_TIMING)});
        }
        if (com.uc.webview.export.internal.utility.a.a((String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM))) {
            arrayList.add(new String[]{"ab_ve", (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM)});
        }
        if (com.uc.webview.export.internal.utility.a.a(Build.CORE_VERSION)) {
            arrayList.add(new String[]{"sdk_sdk_cv", Build.CORE_VERSION.trim()});
        }
        if (i == 0) {
            obj = new String[2];
            obj[0] = "sdk_ucbackup";
            if (new File("/sdcard/Backucup/com.UCMobile").exists()) {
            }
            obj[1] = new File("/sdcard/Backucup/com.UCMobile").exists() ? SettingsConst.TRUE : SettingsConst.FALSE;
            arrayList.add(obj);
        }
        obj = new String[2];
        obj[0] = IWaStat.VIDEO_AC;
        if (((Boolean) SDKFactory.invoke(10003, Long.valueOf(1048576))).booleanValue()) {
        }
        obj[1] = ((Boolean) SDKFactory.invoke(10003, Long.valueOf(1048576))).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE;
        arrayList.add(obj);
        if (com.uc.webview.export.internal.utility.a.a(com.uc.webview.export.internal.utility.d.a.a(this.j))) {
            arrayList.add(new String[]{IWaStat.UTDID_KEY, "null"});
        } else {
            arrayList.add(new String[]{IWaStat.UTDID_KEY, com.uc.webview.export.internal.utility.d.a.a(this.j)});
        }
        arrayList.add(new String[]{"data_dir", this.j.getApplicationInfo().dataDir});
        if (((File) ReflectionUtil.invokeNoThrow(this.j, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{"UC_WA_STAT"})) != null) {
            arrayList.add(new String[]{"sp_dir", ((File) ReflectionUtil.invokeNoThrow(this.j, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{"UC_WA_STAT"})).getAbsolutePath()});
        }
        return arrayList;
    }

    private List<String[]> a(List<PackageInfo> list, String str) {
        if (str == null) {
            return new ArrayList(0);
        }
        List<String[]> arrayList = new ArrayList();
        String string = this.j.getSharedPreferences("UC_WA_STAT", 4).getString("4", null);
        if (string != null && string.equals(str)) {
            return arrayList;
        }
        arrayList.add(new String[]{"sdk_3rdappf", c((List) list)});
        return arrayList;
    }

    private static String b(Map<String, a> map, List<b> list) {
        String str = null;
        String[] strArr = new String[]{"01", "10", "20"};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            for (Entry value : map.entrySet()) {
                String b = b(((a) value.getValue()).b);
                if (b == null || !b.endsWith(str2) || (str != null && b.compareTo(str) <= 0)) {
                    b = str;
                }
                str = b;
            }
            for (b bVar : list) {
                b = b(bVar.b);
                if (b != null && b.endsWith(str2)) {
                    if (str == null || b.compareTo(str) > 0) {
                        str = b;
                    }
                }
            }
            if (str != null) {
                break;
            }
        }
        return str;
    }

    private static String b(Map<String, String> map) {
        String str = (String) map.get("tm");
        if (str == null || str.length() <= 10) {
            return null;
        }
        return str.substring(0, 10);
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str).append("=").append(str2).append("`");
    }

    private String a(String[] strArr) {
        Object[] i = i();
        if (i == null) {
            return null;
        }
        Map map = (Map) i[0];
        List<b> list = (List) i[1];
        try {
            JSONObject jSONObject = new JSONObject();
            List b = b(this.j);
            for (String[] strArr2 : b(b)) {
                jSONObject.put(strArr2[0], strArr2[1]);
            }
            if (!d.d()) {
                strArr[0] = b(map, (List) list);
                for (String[] strArr22 : a(b, strArr[0])) {
                    jSONObject.put(strArr22[0], strArr22[1]);
                }
            }
            for (Entry entry : SDKFactory.z.entrySet()) {
                jSONObject.put((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry2 : map.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                for (Entry entry3 : ((a) entry2.getValue()).a.entrySet()) {
                    jSONObject2.put((String) entry3.getKey(), String.valueOf(entry3.getValue()));
                }
                for (Entry entry32 : ((a) entry2.getValue()).b.entrySet()) {
                    jSONObject2.put((String) entry32.getKey(), entry32.getValue());
                }
                jSONArray.put(jSONObject2);
            }
            for (b bVar : list) {
                JSONObject jSONObject3 = new JSONObject();
                for (Entry entry322 : bVar.b.entrySet()) {
                    jSONObject3.put((String) entry322.getKey(), entry322.getValue());
                }
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("items", jSONArray);
            jSONObject.put("stat_size", String.valueOf(jSONObject.toString().length()));
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.e("SDKWaStat", "getJsonUploadData", e);
            return null;
        }
    }

    private String a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(Global.APOLLO_SERIES, "");
        if (!com.uc.webview.export.internal.utility.a.a(string)) {
            return string;
        }
        string = UUID.randomUUID().toString();
        Editor edit = this.j.getSharedPreferences("UC_WA_STAT", 4).edit();
        edit.putString(Global.APOLLO_SERIES, string);
        edit.commit();
        return string;
    }

    private static boolean b(String str, byte[] bArr) {
        Throwable th;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            if (!SDKFactory.f && Boolean.parseBoolean(UCCore.getParam(UCCore.CD_ENABLE_TRAFFIC_STAT)) && VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(40962);
            }
        } catch (Throwable th2) {
        }
        Closeable outputStream;
        Closeable inputStream;
        Closeable byteArrayOutputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(d.a);
            httpURLConnection.setReadTimeout(d.b);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                if (httpURLConnection.getResponseCode() != 200) {
                    if (Utils.sWAPrintLog) {
                        Log.e("SDKWaStat", "response == null", new Throwable());
                    }
                    UCCyclone.close(outputStream);
                    UCCyclone.close(null);
                    UCCyclone.close(null);
                    return false;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (Throwable th3) {
                            th = th3;
                            closeable2 = inputStream;
                        }
                    }
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    if (Utils.sWAPrintLog) {
                        Log.i("SDKWaStat", "response:" + str2);
                    }
                    if (str2.contains("retcode=0")) {
                        UCCyclone.close(outputStream);
                        UCCyclone.close(inputStream);
                        UCCyclone.close(byteArrayOutputStream);
                        return true;
                    }
                    UCCyclone.close(outputStream);
                    UCCyclone.close(inputStream);
                    UCCyclone.close(byteArrayOutputStream);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    closeable2 = inputStream;
                    UCCyclone.close(outputStream);
                    UCCyclone.close(closeable2);
                    UCCyclone.close(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                UCCyclone.close(outputStream);
                UCCyclone.close(closeable2);
                UCCyclone.close(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream = null;
            byteArrayOutputStream = null;
            UCCyclone.close(outputStream);
            UCCyclone.close(closeable2);
            UCCyclone.close(byteArrayOutputStream);
            throw th;
        }
    }

    private static List<PackageInfo> b(Context context) {
        return context.getPackageManager().getInstalledPackages(0);
    }

    private static String c(List<PackageInfo> list) {
        long currentTimeMillis = System.currentTimeMillis();
        HashSet hashSet = new HashSet(list.size());
        for (PackageInfo packageInfo : list) {
            hashSet.add(Integer.valueOf(packageInfo.packageName.hashCode()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int[] iArr = new int[]{744792033, -796004189, 1536737232, -1864872766, -245593387, 559984781, 1254578009, 460049591, -103524201, -191341086, 2075805265, -860300598, 195266379, 851655498, -172581751, -1692253156, -1709882794, 978047406, -1447376190, 1085732649, 400412247, 1007750384, 321803898, 1319538838, -1459422248, -173313837, 1488133239, 551552610, 1310504938, 633261597, -548160304, 1971200218, 757982267, 996952171, 1855462465, 2049668591, -189253699, -761937585, -1102972298, 195210534, -1433071276, -118960061, 810513273, 1659293491, 1552103645, 361910168, -973170826, -1805061386, -1635328017, -1131240456, 1429484426, -918490570, 1791072826, -894368837, -1394248969, -1476255283, 1994036591, 1219220171, 201325446, -1215205363, -257645900, 1197124177, 1765779203, 313184810, 308524937, -1652150487, 1174097286, -69877540, 2123438483, -1769871671};
        for (int i = 0; i < 70; i++) {
            if (hashSet.contains(Integer.valueOf(iArr[i]))) {
                stringBuilder.append(SettingsConst.TRUE);
            } else {
                stringBuilder.append(SettingsConst.FALSE);
            }
        }
        Log.i("SDKWaStat", "getOtherAppInstallFlag用时:" + (System.currentTimeMillis() - currentTimeMillis) + " " + stringBuilder);
        return stringBuilder.toString();
    }
}
