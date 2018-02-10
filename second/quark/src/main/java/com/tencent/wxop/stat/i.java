package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.taobao.weex.ui.component.ab;
import com.tencent.b.a.a.a.g;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.p;
import com.tencent.wxop.stat.a.q;
import com.tencent.wxop.stat.a.s;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.export.LogType;
import java.net.URI;
import java.util.Iterator;
import java.util.Random;
import org.android.spdy.SpdyProtocol;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    private static int A = 1;
    private static String B = null;
    private static String C;
    private static String D;
    private static String E = "mta_channel";
    private static int F = 180;
    private static int G = 1024;
    private static long H = 0;
    private static long I = 300000;
    private static volatile String J = "http://pingma.qq.com:80/mstat/report";
    private static int K = 0;
    private static volatile int L = 0;
    private static int M = 20;
    private static int N = 0;
    private static boolean O = false;
    private static int P = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
    private static boolean Q = false;
    private static String R = null;
    private static boolean S = false;
    private static j T = null;
    static h a = new h(2);
    static h b = new h(1);
    static String c = "__HIBERNATE__";
    static String d = "__HIBERNATE__TIME";
    static String e = "__MTA_KILL__";
    static String f = "";
    static boolean g = false;
    static int h = 100;
    static long i = 10000;
    static boolean j = true;
    public static boolean k = true;
    static volatile String l = "pingma.qq.com:80";
    static boolean m = true;
    static int n = 0;
    static long o = 10000;
    static int p = 512;
    private static p q = n.c();
    private static o r = o.APP_LAUNCH;
    private static boolean s = false;
    private static boolean t = true;
    private static int u = 30000;
    private static int v = 100000;
    private static int w = 30;
    private static int x = 10;
    private static int y = 100;
    private static int z = 30;

    public static o a() {
        return r;
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (i.class) {
            if (C != null) {
                str = C;
            } else {
                if (context != null) {
                    if (C == null) {
                        C = n.f(context);
                    }
                }
                if (C == null || C.trim().length() == 0) {
                    q.d("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = C;
            }
        }
        return str;
    }

    static String a(String str) {
        try {
            String string = b.b.getString(str);
            if (string != null) {
                return string;
            }
        } catch (Throwable th) {
            q.c("can't find custom key:" + str);
        }
        return null;
    }

    private static void a(long j) {
        q.a(n.a(), c, j);
        a(false);
        q.b((Object) "MTA is disable for current SDK version");
    }

    static void a(Context context, h hVar) {
        if (hVar.a == b.a) {
            b = hVar;
            a(hVar.b);
            if (!b.b.isNull("iplist")) {
                d a = d.a(context);
                String string = b.b.getString("iplist");
                if (s) {
                    a.g.a("updateIpList " + string);
                }
                try {
                    if (n.c(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        if (jSONObject.length() > 0) {
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                string = jSONObject.getString((String) keys.next());
                                if (n.c(string)) {
                                    for (String str : string.split(";")) {
                                        String str2;
                                        if (n.c(str2)) {
                                            String[] split = str2.split(":");
                                            if (split.length > 1) {
                                                str2 = split[0];
                                                if (d.a(str2) && !a.a.contains(str2)) {
                                                    if (s) {
                                                        a.g.a("add new ip:" + str2);
                                                    }
                                                    a.a.add(str2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable e) {
                    a.g.b(e);
                }
                a.e = new Random().nextInt(a.a.size());
            }
        } else if (hVar.a == a.a) {
            a = hVar;
        }
    }

    private static void a(Context context, h hVar, JSONObject jSONObject) {
        try {
            String str;
            Object obj;
            Iterator keys = jSONObject.keys();
            Object obj2 = null;
            while (keys.hasNext()) {
                str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    if (hVar.d != i) {
                        obj = 1;
                    } else {
                        obj = obj2;
                    }
                    hVar.d = i;
                    obj2 = obj;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        hVar.b = new JSONObject(str);
                    }
                } else {
                    try {
                        if (str.equalsIgnoreCase(ab.PROP_FS_MATCH_PARENT)) {
                            hVar.c = jSONObject.getString(ab.PROP_FS_MATCH_PARENT);
                        }
                    } catch (JSONException e) {
                        q.g("__HIBERNATE__ not found.");
                    } catch (Throwable th) {
                        q.b(th);
                    }
                }
            }
            if (obj2 == 1) {
                as a = as.a(n.a());
                if (!(a == null || hVar == null)) {
                    a.a.a(new an(a, hVar));
                }
                if (hVar.a == b.a) {
                    a(hVar.b);
                    JSONObject jSONObject2 = hVar.b;
                    if (!(jSONObject2 == null || jSONObject2.length() == 0)) {
                        Context a2 = n.a();
                        try {
                            str = jSONObject2.optString(e);
                            if (n.c(str)) {
                                JSONObject jSONObject3 = new JSONObject(str);
                                if (jSONObject3.length() != 0) {
                                    if (!jSONObject3.isNull("sm")) {
                                        obj = jSONObject3.get("sm");
                                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                                        if (intValue > 0) {
                                            if (s) {
                                                q.a("match sleepTime:" + intValue + " minutes");
                                            }
                                            q.a(a2, d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                                            a(false);
                                            q.b((Object) "MTA is disable for current SDK version");
                                        }
                                    }
                                    if (a(jSONObject3, "sv", "2.0.3")) {
                                        q.a((Object) "match sdk version:2.0.3");
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (a(jSONObject3, "md", Build.MODEL)) {
                                        q.a("match MODEL:" + Build.MODEL);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "av", n.j(a2))) {
                                        q.a("match app version:" + n.j(a2));
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "mf", Build.MANUFACTURER)) {
                                        q.a("match MANUFACTURER:" + Build.MANUFACTURER);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "osv", VERSION.SDK_INT)) {
                                        q.a("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "ov", VERSION.SDK_INT)) {
                                        q.a("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "ui", as.a(a2).b(a2).a)) {
                                        q.a("match imei:" + as.a(a2).b(a2).a);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "mid", e(a2))) {
                                        q.a("match mid:" + e(a2));
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        a(n.b("2.0.3"));
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            q.b(th2);
                        }
                        str = jSONObject2.getString(c);
                        if (s) {
                            q.g("hibernateVer:" + str + ", current version:2.0.3");
                        }
                        long b = n.b(str);
                        if (n.b("2.0.3") <= b) {
                            a(b);
                        }
                    }
                }
            }
            a(context, hVar);
        } catch (Throwable th22) {
            q.b(th22);
        } catch (Throwable th222) {
            q.b(th222);
        }
    }

    public static void a(Context context, String str) {
        if (context == null) {
            q.d("ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > LogType.UNEXP) {
            q.d("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (C == null) {
                C = s.a(q.a(context, "_mta_ky_tag_", null));
            }
            if ((d(str) | d(n.f(context))) != 0) {
                String str2 = C;
                if (str2 != null) {
                    q.b(context, "_mta_ky_tag_", s.b(str2));
                }
            }
        }
    }

    static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(b.a))) {
                    a(context, b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(a.a))) {
                    a(context, a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    o a = o.a(jSONObject.getInt(str));
                    if (a != null) {
                        r = a;
                        if (s) {
                            q.g("Change to ReportStrategy:" + a.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            q.b(e);
        }
    }

    public static void a(o oVar) {
        r = oVar;
        if (oVar != o.PERIOD) {
            ah.c = 0;
        }
        if (s) {
            q.g("Change to statSendStrategy: " + oVar);
        }
    }

    private static void a(JSONObject jSONObject) {
        try {
            o a = o.a(jSONObject.getInt("rs"));
            if (a != null) {
                a(a);
            }
        } catch (JSONException e) {
            if (s) {
                q.a((Object) "rs not found.");
            }
        }
    }

    public static void a(boolean z) {
        t = z;
        if (!z) {
            q.b((Object) "!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    private static boolean a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (n.c(str2) && n.c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized String b(Context context) {
        String str;
        synchronized (i.class) {
            if (D != null) {
                str = D;
            } else {
                str = q.a(context, E, "");
                D = str;
                if (str == null || D.trim().length() == 0) {
                    D = n.g(context);
                }
                if (D == null || D.trim().length() == 0) {
                    q.c("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = D;
            }
        }
        return str;
    }

    public static void b(Context context, String str) {
        if (str.length() > 128) {
            q.d("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        D = str;
        q.b(context, E, str);
    }

    public static void b(String str) {
        if (str.length() > 128) {
            q.d("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            D = str;
        }
    }

    public static boolean b() {
        return s;
    }

    public static String c(Context context) {
        return q.a(context, "mta.acc.qq", f);
    }

    public static void c(String str) {
        if (str == null || str.length() == 0) {
            q.d("statReportUrl cannot be null or empty.");
            return;
        }
        J = str;
        try {
            l = new URI(J).getHost();
        } catch (Exception e) {
            q.c(e);
        }
        if (s) {
            q.a("url:" + J + ", domain:" + l);
        }
    }

    public static boolean c() {
        return t;
    }

    public static int d() {
        return u;
    }

    public static String d(Context context) {
        if (context == null) {
            q.d("Context for getCustomUid is null.");
            return null;
        }
        if (R == null) {
            R = q.a(context, "MTA_CUSTOM_UID", "");
        }
        return R;
    }

    private static boolean d(String str) {
        if (str == null) {
            return false;
        }
        if (C == null) {
            C = str;
            return true;
        } else if (C.contains(str)) {
            return false;
        } else {
            C += "|" + str;
            return true;
        }
    }

    public static int e() {
        return y;
    }

    public static String e(Context context) {
        return context != null ? g.a(context).a().c : SettingsConst.FALSE;
    }

    public static int f() {
        return z;
    }

    public static int g() {
        return x;
    }

    public static int h() {
        return A;
    }

    static int i() {
        return w;
    }

    public static int j() {
        return v;
    }

    public static void k() {
        F = 60;
    }

    public static int l() {
        return F;
    }

    public static int m() {
        return G;
    }

    public static void n() {
        j = true;
    }

    public static boolean o() {
        return k;
    }

    public static String p() {
        return J;
    }

    static synchronized void q() {
        synchronized (i.class) {
            L = 0;
        }
    }

    public static int r() {
        return M;
    }

    static void s() {
        N++;
    }

    static void t() {
        N = 0;
    }

    static int u() {
        return N;
    }

    public static boolean v() {
        return Q;
    }

    public static j w() {
        return T;
    }
}
