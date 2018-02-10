package com.loc;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class de {
    private static boolean A = true;
    private static int B = -1;
    private static long C = 0;
    private static ArrayList<String> D = new ArrayList();
    private static String E;
    private static String F;
    private static boolean G = false;
    private static boolean H = false;
    private static int I = SettingsConst.SDK_SETTINGS;
    private static int J = SettingsConst.SDK_SETTINGS;
    private static boolean K = true;
    private static long L = 300000;
    private static int M = -1;
    private static boolean N = false;
    private static boolean O = false;
    private static boolean P = false;
    private static boolean Q = false;
    private static List<df> R = new ArrayList();
    private static boolean S = false;
    private static long T = 0;
    private static int U = 0;
    private static int V = 0;
    static boolean a = false;
    private static Context b;
    private static String c = "提示信息";
    private static String d = "确认";
    private static String e = "取消";
    private static String f = "";
    private static String g = "";
    private static String h = "";
    private static boolean i = false;
    private static long j = 0;
    private static long k = 0;
    private static long l = 5000;
    private static boolean m = false;
    private static int n = 0;
    private static boolean o = false;
    private static int p = 0;
    private static boolean q = false;
    private static boolean r = true;
    private static int s = 3600000;
    private static int t = 0;
    private static int u = 0;
    private static boolean v = true;
    private static boolean w = true;
    private static int x = -1;
    private static long y = 0;
    private static ArrayList<String> z = new ArrayList();

    private static dd a(JSONObject jSONObject, String str) {
        dd ddVar;
        Throwable th;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    ddVar = new dd();
                    try {
                        ddVar.a = ee.a(jSONObject2.optString("b"), false);
                        ddVar.b = jSONObject2.optString("t");
                        ddVar.c = ee.a(jSONObject2.getString("st"), false);
                        ddVar.d = jSONObject2.optInt("i", 0);
                        return ddVar;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                ddVar = null;
                th = th4;
                cq.a(th, "AuthUtil", "getLocateObj");
                return ddVar;
            }
        }
        return null;
    }

    public static boolean a() {
        return m;
    }

    public static boolean a(long j) {
        long b = dm.b();
        return i && b - k <= j && b - j >= l;
    }

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (de.class) {
            b = context;
            z = false;
            try {
                ec a = ee.a(context, cq.a("loc", "2.8.0"), cq.b(context));
                M = a.b;
                z = a(a);
            } catch (Throwable th) {
                cq.a(th, "AuthUtil", "getConfig");
            }
        }
        return z;
    }

    private static synchronized boolean a(dz dzVar, String str, String str2) {
        boolean z;
        synchronized (de.class) {
            z = false;
            if (dzVar != null) {
                try {
                    z = dzVar.a;
                    Object obj = dzVar.b;
                    Object obj2 = dzVar.c;
                    CharSequence charSequence = dzVar.d;
                    if (!(!z || TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj) || TextUtils.isEmpty(charSequence))) {
                        ep a = cq.a(str, str2);
                        ac.a(b, new aa(obj, obj2), a);
                    }
                } catch (Throwable th) {
                    cq.a(th, "AuthUtil", "downLoadPluginDex");
                }
            }
        }
        return z;
    }

    private static boolean a(ec ecVar) {
        JSONObject jSONObject;
        dz dzVar;
        JSONArray jSONArray;
        int i;
        int optInt;
        try {
            jSONObject = ecVar.h;
            if (jSONObject != null) {
                boolean a = ee.a(jSONObject.getString("opflag"), true);
                r = a;
                ch.a = a;
            }
        } catch (Throwable th) {
            cq.a(th, "AuthUtil", "loadconfig");
            return false;
        }
        if (r) {
            try {
                dzVar = ecVar.r;
                if (dzVar != null) {
                    O = a(dzVar, "OfflineLocation", "1.0.0");
                    dl.a(b, "pref", "oAble", O);
                }
            } catch (Throwable th2) {
                cq.a(th2, "AuthUtil", "loadConfigData_OfflineDex");
            }
        }
        try {
            jSONObject = ecVar.c;
            if (jSONObject != null) {
                boolean a2;
                a2 = ee.a(jSONObject.getString("callamapflag"), true);
                w = a2;
                if (a2) {
                    x = jSONObject.getInt("count");
                    y = jSONObject.getLong("sysTime");
                    jSONArray = jSONObject.getJSONArray("sn");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (i = 0; i < jSONArray.length(); i++) {
                            z.add(jSONArray.getString(i));
                        }
                    }
                    if (!(x == -1 || y == 0)) {
                        if (!dm.b(y, dl.a(b, "pref", "nowtime"))) {
                            d(b);
                        }
                    }
                }
            }
        } catch (Throwable th22) {
            cq.a(th22, "AuthUtil", "loadConfigData_callAMapSer");
        }
        try {
            jSONObject = ecVar.e;
            if (jSONObject != null) {
                a2 = ee.a(jSONObject.getString("amappushflag"), false);
                A = a2;
                if (a2) {
                    B = jSONObject.getInt("count");
                    C = jSONObject.getLong("sysTime");
                    jSONArray = jSONObject.getJSONArray("sn");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (i = 0; i < jSONArray.length(); i++) {
                            D.add(jSONArray.getString(i));
                        }
                    }
                    if (!(B == -1 || C == 0)) {
                        if (!dm.b(C, dl.a(b, "pref", "pushSerTime"))) {
                            e(b);
                        }
                    }
                }
            }
        } catch (Throwable th222) {
            cq.a(th222, "AuthUtil", "loadConfigData_callAMapPush");
        }
        try {
            jSONObject = ecVar.f;
            if (jSONObject != null) {
                G = ee.a(jSONObject.getString("f"), false);
                t = jSONObject.optInt("mco", 0);
                u = jSONObject.optInt("co", 0);
                optInt = jSONObject.optInt("it", 3600) * 1000;
                s = optInt;
                if (optInt < 3600000) {
                    s = 3600000;
                }
                c = jSONObject.optString("a", "提示信息");
                d = jSONObject.optString("o", "确认");
                e = jSONObject.optString("c", "取消");
                f = jSONObject.optString("i", "");
                g = jSONObject.optString("u", "");
                h = jSONObject.optString("t", "");
                if (((TextUtils.isEmpty(f) || "null".equals(f)) && (TextUtils.isEmpty(g) || "null".equals(g))) || u > t) {
                    G = false;
                }
            }
        } catch (Throwable th2222) {
            cq.a(th2222, "AuthUtil", "loadConfigData_openAMap");
        }
        try {
            ep a3 = cq.a("loc", "2.8.0");
            eb ebVar = ecVar.o;
            ea eaVar;
            en enVar;
            dy dyVar;
            JSONObject jSONObject2;
            dd a4;
            if (ebVar != null) {
                Object obj = ebVar.b;
                Object obj2 = ebVar.a;
                CharSequence charSequence = ebVar.c;
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || TextUtils.isEmpty(charSequence)) {
                    ac.a(b, null, a3);
                    try {
                        eaVar = ecVar.p;
                        if (eaVar != null) {
                            E = eaVar.a;
                            F = eaVar.b;
                            if (!(TextUtils.isEmpty(E) || TextUtils.isEmpty(F))) {
                                enVar = new en(b, "loc", E, F);
                                if (enVar.a != null && !TextUtils.isEmpty(enVar.a.a) && enVar.a.a.contains("libJni_wgs2gcj.so") && enVar.a.a.contains(Build.CPU_ABI)) {
                                    if (!new File(enVar.b).exists()) {
                                        enVar.start();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th22222) {
                        cq.a(th22222, "AuthUtil", "loadConfigData_groupOffset");
                    }
                    try {
                        dyVar = ecVar.n;
                        if (dyVar != null) {
                            v = dyVar.a;
                            dl.a(b, "pref", "exception", v);
                        }
                    } catch (Throwable th222222) {
                        cq.a(th222222, "AuthUtil", "loadConfigData_uploadException");
                    }
                    try {
                        jSONObject2 = ecVar.g;
                        if (jSONObject2 != null && ee.a(jSONObject2.getString("able"), false)) {
                            a4 = a(jSONObject2, "fs");
                            if (a4 != null) {
                                m = a4.c;
                                n = Integer.parseInt(a4.b);
                            }
                            a4 = a(jSONObject2, "us");
                            if (a4 != null) {
                                o = a4.c;
                                q = a4.a;
                                try {
                                    p = Integer.parseInt(a4.b);
                                } catch (Throwable th2222222) {
                                    cq.a(th2222222, "AuthUtil", "loadconfig part1");
                                }
                                if (p < 2) {
                                    o = false;
                                }
                            }
                            a4 = a(jSONObject2, "rs");
                            if (a4 != null) {
                                a2 = a4.c;
                                i = a2;
                                if (a2) {
                                    k = dm.b();
                                    l = (long) (a4.d * 1000);
                                }
                                try {
                                    j = (long) (Integer.parseInt(a4.b) * 1000);
                                } catch (Throwable th22222222) {
                                    cq.a(th22222222, "AuthUtil", "loadconfig part");
                                }
                            }
                        }
                    } catch (Throwable th222222222) {
                        cq.a(th222222222, "AuthUtil", "loadConfigData_locate");
                    }
                    try {
                        jSONObject = ecVar.i;
                        if (jSONObject != null) {
                            a2 = ee.a(jSONObject.getString("able"), false);
                            H = a2;
                            if (a2) {
                                optInt = jSONObject.getInt("c");
                                if (optInt == 0) {
                                    I = SettingsConst.SDK_SETTINGS;
                                } else {
                                    I = optInt * 1000;
                                }
                                J = jSONObject.getInt("t") / 2;
                            }
                        }
                    } catch (Throwable th2222222222) {
                        cq.a(th2222222222, "AuthUtil", "loadConfigData_ngps");
                    }
                    try {
                        jSONObject = ecVar.j;
                        if (jSONObject != null) {
                            a2 = ee.a(jSONObject.getString("able"), true);
                            K = a2;
                            if (a2) {
                                L = (long) (jSONObject.getInt("c") * 1000);
                            }
                        }
                    } catch (Throwable th22222222222) {
                        cq.a(th22222222222, "AuthUtil", "loadConfigData_cacheAble");
                    }
                    try {
                        dzVar = ecVar.q;
                        if (dzVar != null) {
                            N = a(dzVar, "Collection", "1.0.0");
                        }
                    } catch (Throwable th222222222222) {
                        cq.a(th222222222222, "AuthUtil", "loadConfigData_CollectorDex");
                    }
                    b(ecVar);
                    c(ecVar);
                    return true;
                }
                ac.a(b, new aa(obj2, obj), a3);
                eaVar = ecVar.p;
                if (eaVar != null) {
                    E = eaVar.a;
                    F = eaVar.b;
                    enVar = new en(b, "loc", E, F);
                    if (new File(enVar.b).exists()) {
                        enVar.start();
                    }
                }
                dyVar = ecVar.n;
                if (dyVar != null) {
                    v = dyVar.a;
                    dl.a(b, "pref", "exception", v);
                }
                jSONObject2 = ecVar.g;
                a4 = a(jSONObject2, "fs");
                if (a4 != null) {
                    m = a4.c;
                    n = Integer.parseInt(a4.b);
                }
                a4 = a(jSONObject2, "us");
                if (a4 != null) {
                    o = a4.c;
                    q = a4.a;
                    p = Integer.parseInt(a4.b);
                    if (p < 2) {
                        o = false;
                    }
                }
                a4 = a(jSONObject2, "rs");
                if (a4 != null) {
                    a2 = a4.c;
                    i = a2;
                    if (a2) {
                        k = dm.b();
                        l = (long) (a4.d * 1000);
                    }
                    j = (long) (Integer.parseInt(a4.b) * 1000);
                }
                jSONObject = ecVar.i;
                if (jSONObject != null) {
                    a2 = ee.a(jSONObject.getString("able"), false);
                    H = a2;
                    if (a2) {
                        optInt = jSONObject.getInt("c");
                        if (optInt == 0) {
                            I = optInt * 1000;
                        } else {
                            I = SettingsConst.SDK_SETTINGS;
                        }
                        J = jSONObject.getInt("t") / 2;
                    }
                }
                jSONObject = ecVar.j;
                if (jSONObject != null) {
                    a2 = ee.a(jSONObject.getString("able"), true);
                    K = a2;
                    if (a2) {
                        L = (long) (jSONObject.getInt("c") * 1000);
                    }
                }
                dzVar = ecVar.q;
                if (dzVar != null) {
                    N = a(dzVar, "Collection", "1.0.0");
                }
                b(ecVar);
                c(ecVar);
                return true;
            }
            ac.a(b, null, a3);
            eaVar = ecVar.p;
            if (eaVar != null) {
                E = eaVar.a;
                F = eaVar.b;
                enVar = new en(b, "loc", E, F);
                if (new File(enVar.b).exists()) {
                    enVar.start();
                }
            }
            dyVar = ecVar.n;
            if (dyVar != null) {
                v = dyVar.a;
                dl.a(b, "pref", "exception", v);
            }
            jSONObject2 = ecVar.g;
            a4 = a(jSONObject2, "fs");
            if (a4 != null) {
                m = a4.c;
                n = Integer.parseInt(a4.b);
            }
            a4 = a(jSONObject2, "us");
            if (a4 != null) {
                o = a4.c;
                q = a4.a;
                p = Integer.parseInt(a4.b);
                if (p < 2) {
                    o = false;
                }
            }
            a4 = a(jSONObject2, "rs");
            if (a4 != null) {
                a2 = a4.c;
                i = a2;
                if (a2) {
                    k = dm.b();
                    l = (long) (a4.d * 1000);
                }
                j = (long) (Integer.parseInt(a4.b) * 1000);
            }
            jSONObject = ecVar.i;
            if (jSONObject != null) {
                a2 = ee.a(jSONObject.getString("able"), false);
                H = a2;
                if (a2) {
                    optInt = jSONObject.getInt("c");
                    if (optInt == 0) {
                        I = SettingsConst.SDK_SETTINGS;
                    } else {
                        I = optInt * 1000;
                    }
                    J = jSONObject.getInt("t") / 2;
                }
            }
            jSONObject = ecVar.j;
            if (jSONObject != null) {
                a2 = ee.a(jSONObject.getString("able"), true);
                K = a2;
                if (a2) {
                    L = (long) (jSONObject.getInt("c") * 1000);
                }
            }
            dzVar = ecVar.q;
            if (dzVar != null) {
                N = a(dzVar, "Collection", "1.0.0");
            }
            b(ecVar);
            c(ecVar);
            return true;
        } catch (Throwable th2222222222222) {
            cq.a(th2222222222222, "AuthUtil", "loadConfigData_sdkUpdate");
        }
    }

    public static int b() {
        return n;
    }

    public static void b(Context context) {
        try {
            v = dl.b(context, "pref", "exception", true);
            c(context);
        } catch (Throwable th) {
            cq.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            O = dl.b(context, "pref", "oAble", false);
        } catch (Throwable th2) {
            cq.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
    }

    private static synchronized void b(ec ecVar) {
        synchronized (de.class) {
            try {
                JSONObject jSONObject = ecVar.k;
                if (jSONObject != null) {
                    boolean a = ee.a(jSONObject.getString("able"), true);
                    a = a;
                    if (a) {
                        ac.a(b, "loc");
                    }
                }
            } catch (Throwable th) {
                cq.a(th, "AuthUtil", "loadConfigData_CallBackDex");
            }
        }
    }

    public static boolean b(long j) {
        if (!H) {
            return false;
        }
        long a = dm.a();
        if (a - j < ((long) I)) {
            return false;
        }
        if (J == -1) {
            return true;
        }
        if (dm.c(a, dl.a(b, "pref", "ngpsTime"))) {
            int b = dl.b(b, "pref", "ngpsCount");
            if (b >= J) {
                return false;
            }
            dl.a(b, "pref", "ngpsCount", b + 1);
            return true;
        }
        try {
            Editor edit = b.getSharedPreferences("pref", 0).edit();
            edit.putLong("ngpsTime", a);
            edit.putInt("ngpsCount", 0);
            dl.a(edit);
        } catch (Throwable th) {
            cq.a(th, "AuthUtil", "resetPrefsNGPS");
        }
        dl.a(b, "pref", "ngpsCount", 1);
        return true;
    }

    public static synchronized void c(Context context) {
        synchronized (de.class) {
            try {
                ep a = cq.a("loc", "2.8.0");
                a.a = v ? 1 : 0;
                fa.a(context, a);
            } catch (Throwable th) {
            }
        }
    }

    private static synchronized void c(ec ecVar) {
        synchronized (de.class) {
            try {
                JSONObject jSONObject = ecVar.d;
                if (jSONObject != null) {
                    S = ee.a(jSONObject.getString("able"), false);
                    T = jSONObject.optLong("sysTime", dm.a());
                    U = jSONObject.optInt("n", 1);
                    V = jSONObject.optInt("nh", 1);
                    if (S && (U == -1 || U >= V)) {
                        JSONArray jSONArray = jSONObject.getJSONArray("l");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                df dfVar = new df();
                                boolean a = ee.a(jSONObject2.optString("able", "false"), false);
                                dfVar.a = a;
                                if (a) {
                                    dfVar.b = jSONObject2.optString("pn", "");
                                    dfVar.c = jSONObject2.optString("cn", "");
                                    dfVar.e = jSONObject2.optString("a", "");
                                    JSONArray optJSONArray = jSONObject2.optJSONArray("b");
                                    if (optJSONArray != null) {
                                        List arrayList = new ArrayList();
                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                            JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                                            Map hashMap = new HashMap();
                                            try {
                                                hashMap.put(jSONObject3.getString("k"), jSONObject3.getString("v"));
                                                arrayList.add(hashMap);
                                            } catch (Throwable th) {
                                            }
                                        }
                                        dfVar.d = arrayList;
                                    }
                                    dfVar.f = ee.a(jSONObject2.optString("is", "false"), false);
                                    R.add(dfVar);
                                }
                            } catch (Throwable th2) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                cq.a(th3, "AuthUtil", "loadConfigData_otherServiceList");
            }
        }
        return;
    }

    public static boolean c() {
        return o;
    }

    public static boolean c(long j) {
        if (!K) {
            return false;
        }
        return L < 0 || dm.a() - j < L;
    }

    public static int d() {
        return p;
    }

    private static void d(Context context) {
        Editor edit;
        try {
            edit = context.getSharedPreferences("pref", 0).edit();
            if (y == 0) {
                edit.remove("nowtime");
            } else {
                edit.putLong("nowtime", y);
            }
        } catch (Throwable th) {
            cq.a(th, "AuthUtil", "resetPrefsBind");
            return;
        }
        if (x == -1) {
            edit.remove("count");
        } else {
            edit.putInt("count", 0);
        }
        dl.a(edit);
    }

    private static void e(Context context) {
        Editor edit;
        try {
            edit = context.getSharedPreferences("pref", 0).edit();
            if (C == 0) {
                edit.remove("pushSerTime");
            } else {
                edit.putLong("pushSerTime", C);
            }
        } catch (Throwable th) {
            cq.a(th, "AuthUtil", "resetPrefsBind");
            return;
        }
        if (B == -1) {
            edit.remove("pushCount");
        } else {
            edit.putInt("pushCount", 0);
        }
        dl.a(edit);
    }

    public static boolean e() {
        return q;
    }

    public static boolean f() {
        ch.a = r;
        return r;
    }

    public static String g() {
        return c;
    }

    public static String h() {
        return d;
    }

    public static String i() {
        return e;
    }

    public static String j() {
        return f;
    }

    public static String k() {
        return g;
    }

    public static String l() {
        return h;
    }

    public static ArrayList<String> m() {
        return z;
    }

    public static ArrayList<String> n() {
        return D;
    }

    public static boolean o() {
        return v;
    }

    public static boolean p() {
        if (!w) {
            return false;
        }
        if (x == -1 || y == 0) {
            return true;
        }
        if (dm.b(y, dl.a(b, "pref", "nowtime"))) {
            int b = dl.b(b, "pref", "count");
            if (b >= x) {
                return false;
            }
            dl.a(b, "pref", "count", b + 1);
            return true;
        }
        d(b);
        dl.a(b, "pref", "count", 1);
        return true;
    }

    public static boolean q() {
        if (!A) {
            return false;
        }
        if (B == -1 || C == 0) {
            return true;
        }
        if (dm.b(C, dl.a(b, "pref", "pushSerTime"))) {
            int b = dl.b(b, "pref", "pushCount");
            if (b >= B) {
                return false;
            }
            dl.a(b, "pref", "pushCount", b + 1);
            return true;
        }
        e(b);
        dl.a(b, "pref", "pushCount", 1);
        return true;
    }

    public static synchronized boolean r() {
        boolean z = false;
        synchronized (de.class) {
            if (G) {
                if (u > 0 && t > 0 && u <= t) {
                    long a = dl.a(b, "abcd", "lct");
                    long a2 = dl.a(b, "abcd", "lst");
                    long b = dm.b();
                    if (b < a) {
                        dl.a(b, "abcd", "lct", b);
                    } else {
                        if (b - a > 86400000) {
                            dl.a(b, "abcd", "lct", b);
                            dl.a(b, "abcd", "t", 0);
                        }
                        if (b - a2 >= ((long) s)) {
                            int b2 = dl.b(b, "abcd", "t") + 1;
                            if (b2 <= t) {
                                dl.a(b, "abcd", "lst", b);
                                dl.a(b, "abcd", "t", b2);
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public static boolean s() {
        return K;
    }

    public static synchronized int t() {
        int i;
        synchronized (de.class) {
            i = M;
        }
        return i;
    }

    public static boolean u() {
        return N;
    }

    public static boolean v() {
        return O;
    }

    public static synchronized boolean w() {
        boolean z = true;
        synchronized (de.class) {
            if (!S || U == 0 || V == 0 || T == 0 || (U != -1 && U < V)) {
                z = false;
            } else if (!(U == -1 && V == -1)) {
                long a = dl.a(b, "pref", "ots");
                long a2 = dl.a(b, "pref", "otsh");
                int b = dl.b(b, "pref", "otn");
                int b2 = dl.b(b, "pref", "otnh");
                if (U != -1) {
                    if (!dm.b(T, a)) {
                        try {
                            Editor edit = b.getSharedPreferences("pref", 0).edit();
                            edit.putLong("ots", T);
                            edit.putLong("otsh", T);
                            edit.putInt("otn", 0);
                            edit.putInt("otnh", 0);
                            dl.a(edit);
                        } catch (Throwable th) {
                            cq.a(th, "AuthUtil", "resetPrefsBind");
                        }
                        dl.a(b, "pref", "otn", 1);
                        dl.a(b, "pref", "otnh", 1);
                    } else if (b < U) {
                        if (V == -1) {
                            dl.a(b, "pref", "otn", b + 1);
                            dl.a(b, "pref", "otnh", 0);
                        } else if (!dm.a(T, a2)) {
                            dl.a(b, "pref", "otsh", T);
                            dl.a(b, "pref", "otn", b + 1);
                            dl.a(b, "pref", "otnh", 1);
                        } else if (b2 < V) {
                            int i = b + 1;
                            b = b2 + 1;
                            dl.a(b, "pref", "otn", i);
                            dl.a(b, "pref", "otnh", b);
                        }
                    }
                }
                if (U == -1) {
                    dl.a(b, "pref", "otn", 0);
                    if (V == -1) {
                        dl.a(b, "pref", "otnh", 0);
                    } else if (!dm.a(T, a2)) {
                        dl.a(b, "pref", "otsh", T);
                        dl.a(b, "pref", "otnh", 1);
                    } else if (b2 < V) {
                        dl.a(b, "pref", "otnh", b2 + 1);
                    }
                }
                z = false;
            }
        }
        return z;
    }

    public static synchronized List<df> x() {
        List<df> list;
        synchronized (de.class) {
            list = R;
        }
        return list;
    }
}
