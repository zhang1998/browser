package com.alibaba.analytics;

import android.app.Application;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.s;
import com.alibaba.analytics.core.a;
import com.alibaba.analytics.core.a.d;
import com.alibaba.analytics.core.a.f;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.b.e;
import com.alibaba.analytics.core.c.c;
import com.alibaba.appmonitor.d.j;
import com.alibaba.appmonitor.f.h;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.e.b.i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class o extends q {
    private static Application a;

    public o(Application application) {
        a = application;
    }

    public final void a() throws RemoteException {
        af.a("start..", new Object[0]);
        b.a().a(a);
        af.a("end..", new Object[0]);
    }

    public static Application i() {
        return a;
    }

    public final void a(String str, String str2) throws RemoteException {
        try {
            i.a();
            b a = b.a();
            a.h = str;
            if (!TextUtils.isEmpty(str)) {
                a.i = str;
            }
            if (!(TextUtils.isEmpty(str) || a.b == null)) {
                try {
                    Editor edit = a.b.getSharedPreferences("UTCommon", 0).edit();
                    edit.putString("_lun", new String(s.c(str.getBytes("UTF-8"))));
                    edit.commit();
                } catch (UnsupportedEncodingException e) {
                }
            }
            a.j = str2;
            if (!TextUtils.isEmpty(str2)) {
                a.k = str2;
            }
            if (!TextUtils.isEmpty(str2) && a.b != null) {
                try {
                    Editor edit2 = a.b.getSharedPreferences("UTCommon", 0).edit();
                    edit2.putString("_luid", new String(s.c(str2.getBytes("UTF-8"))));
                    edit2.commit();
                } catch (UnsupportedEncodingException e2) {
                }
            }
        } catch (Throwable e3) {
            af.b(null, e3, new Object[0]);
        } catch (Throwable e32) {
            af.b(null, e32, new Object[0]);
        }
    }

    public final void a(String str) throws RemoteException {
        try {
            i.a();
            b.a().g = str;
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void b(String str) throws RemoteException {
        try {
            i.a();
            af.a(null, "channel", str);
            b a = b.a();
            af.a(null, str, str);
            a.f = str;
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void a(Map map) throws RemoteException {
        try {
            i.a();
            Map f = b.a().f();
            Map hashMap = new HashMap();
            if (f != null) {
                hashMap.putAll(f);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            b.a().a(hashMap);
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void b(Map map) throws RemoteException {
        try {
            i.a();
            b.a().a(map);
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void b() throws RemoteException {
        try {
            i.a();
            b.a().j();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void c(Map map) throws RemoteException {
        af.b();
        try {
            if (!b.a().m) {
                b.a().a(a);
            }
            i.a();
            i.a(map);
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void c() throws RemoteException {
        try {
            f.a();
            f.e();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void d() throws RemoteException {
        try {
            i.a();
            com.alibaba.analytics.core.f.f.a().b();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void e() throws RemoteException {
        try {
            a();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void g() throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void h() throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.b();
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(int i) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.b(i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(boolean z) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(z);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final String d(String str) throws RemoteException {
        String str2 = null;
        try {
            c.a();
            str2 = c.a(str);
        } catch (Throwable th) {
            af.b(str2, th, new Object[0]);
        }
        return str2;
    }

    public final void a(boolean z, boolean z2, String str, String str2) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(z, z2, str, str2);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void d(Map map) throws RemoteException {
        try {
            b.a().b(map);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void f() throws RemoteException {
        try {
            b a = b.a();
            a.l = a.a;
            a.i();
            a.a(null);
            f.a().a(d.INTERVAL);
            a.c(null);
            a.r = false;
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, double d) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.a.a(str, str2, null, d);
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void a(String str, String str2, String str3, double d) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.a.a(str, str2, str3, d);
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void e(String str, String str2) throws RemoteException {
        try {
            j.a(str, str2, null);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, String str3) throws RemoteException {
        try {
            j.a(str, str2, str3);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, String str3, String str4) throws RemoteException {
        try {
            j.a(str, str2, null, str3, str4);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) throws RemoteException {
        try {
            j.a(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void b(int i) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, MeasureSet measureSet) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(str, str2, measureSet);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(str, str2, measureSet, z);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(str, str2, measureSet, dimensionSet);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(str, str2, measureSet, dimensionSet, z);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void c(String str, String str2, String str3) throws RemoteException {
        try {
            if (com.alibaba.appmonitor.d.f.b) {
                b.l();
                if (h.STAT.e && (com.alibaba.appmonitor.d.f.a || com.alibaba.appmonitor.a.d.a().a(h.STAT, str, str2))) {
                    af.a("statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                    com.alibaba.appmonitor.f.d a = com.alibaba.appmonitor.f.d.a();
                    String a2 = com.alibaba.appmonitor.f.d.a(str, str2);
                    if (a2 != null) {
                        a.a(a2, str3, true);
                        return;
                    }
                    return;
                }
            }
            af.c("log discard !", " module ", str, "monitorPoint", str2, " measureName", str3);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void c(String str, String str2, double d) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.d.a(str, str2, null, d);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.d.a(str, str2, dimensionValueSet, d);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.d.a(str, str2, dimensionValueSet, measureValueSet);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void a(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException {
        com.alibaba.appmonitor.d.f.a(str, str2, str3, d, d2, d3);
    }

    public final String c(String str) throws RemoteException {
        try {
            if ("sw_plugin".equals(str)) {
                if (b.a().p) {
                    return "true";
                }
                return "false";
            } else if ("tpk_md5".equals(str)) {
                b a = b.a();
                if (a.q != null) {
                    return a.q.hashCode();
                }
                return null;
            } else if ("tpk_string".equals(str)) {
                return b.a().q;
            } else {
                if ("session_timestamp".equals(str)) {
                    return e.a().a;
                }
                return null;
            }
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
            return null;
        }
    }

    public final void a(int i, int i2) throws RemoteException {
        try {
            com.alibaba.appmonitor.d.f.a(h.a(i), i2);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void c(int i) throws RemoteException {
        try {
            h.COUNTER.h = i;
            com.alibaba.appmonitor.d.f.a(h.COUNTER, i);
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
        } catch (Throwable e2) {
            af.b(null, e2, new Object[0]);
        }
    }

    public final void d(int i) throws RemoteException {
        try {
            com.alibaba.appmonitor.a.d.a().a(h.COUNTER, i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final boolean b(String str, String str2) throws RemoteException {
        boolean z = false;
        try {
            z = com.alibaba.appmonitor.a.d.a().a(h.COUNTER, str, str2);
        } catch (Throwable th) {
            af.b(null, th, new Object[z]);
        }
        return z;
    }

    public final void g(int i) throws RemoteException {
        try {
            h.ALARM.h = i;
            com.alibaba.appmonitor.d.f.a(h.ALARM, i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void h(int i) throws RemoteException {
        try {
            com.alibaba.appmonitor.a.d.a().a(h.ALARM, i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final boolean d(String str, String str2) throws RemoteException {
        boolean z = false;
        try {
            z = com.alibaba.appmonitor.a.d.a().a(str, str2, Boolean.valueOf(true));
        } catch (Throwable th) {
            af.b(null, th, new Object[z]);
        }
        return z;
    }

    public final void e(int i) throws RemoteException {
        try {
            h.COUNTER.h = i;
            com.alibaba.appmonitor.d.f.a(h.COUNTER, i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void f(int i) throws RemoteException {
        com.alibaba.appmonitor.a.d.a().a(h.COUNTER, i);
    }

    public final boolean c(String str, String str2) throws RemoteException {
        return com.alibaba.appmonitor.a.d.a().a(h.COUNTER, str, str2);
    }

    public final void b(String str, String str2, double d) throws RemoteException {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                af.c("AppMonitorDelegate", "module & monitorPoint must not null");
                return;
            }
            if (com.alibaba.appmonitor.d.f.b) {
                b.l();
                if (h.COUNTER.e && (com.alibaba.appmonitor.d.f.a || com.alibaba.appmonitor.a.d.a().a(h.COUNTER, str, str2))) {
                    af.a("commitOffLineCount", "module", str, "monitorPoint", str2, "value", Double.valueOf(d));
                    com.alibaba.appmonitor.f.d.a().a(h.COUNTER.d, str, str2, null, d);
                    return;
                }
            }
            af.c("log discard !", "");
        } catch (Throwable th) {
            com.alibaba.analytics.core.c.a.c.a(com.alibaba.analytics.core.c.a.b.b, th);
        }
    }

    public final void b(String str, String str2, String str3) throws RemoteException {
        try {
            if (com.alibaba.appmonitor.d.f.b) {
                b.l();
                if (h.STAT.e && (com.alibaba.appmonitor.d.f.a || com.alibaba.appmonitor.a.d.a().a(h.STAT, str, str2))) {
                    af.a("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                    com.alibaba.appmonitor.f.d a = com.alibaba.appmonitor.f.d.a();
                    Integer valueOf = Integer.valueOf(h.STAT.d);
                    String a2 = com.alibaba.appmonitor.f.d.a(str, str2);
                    if (a2 != null) {
                        a.a(a2, valueOf, str, str2, str3);
                        return;
                    }
                    return;
                }
            }
            af.c("log discard !", "");
        } catch (Throwable th) {
        }
    }

    public final void i(int i) throws RemoteException {
        try {
            h.STAT.h = i;
            com.alibaba.appmonitor.d.f.a(h.STAT, i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final void j(int i) throws RemoteException {
        try {
            com.alibaba.appmonitor.a.d.a().a(h.STAT, i);
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }

    public final boolean f(String str, String str2) throws RemoteException {
        return com.alibaba.appmonitor.a.d.a().a(h.STAT, str, str2);
    }

    public final void a(Transaction transaction, String str) throws RemoteException {
        try {
            if (com.alibaba.appmonitor.d.f.b && transaction != null) {
                af.a("TransactionDelegate", "statEvent begin. module: ", transaction.b, " monitorPoint: ", transaction.c, " measureName: ", str);
                if (!h.STAT.e) {
                    return;
                }
                if (com.alibaba.appmonitor.d.f.a || com.alibaba.appmonitor.a.d.a().a(h.STAT, transaction.b, transaction.c)) {
                    com.alibaba.appmonitor.f.d.a().a(transaction.e, transaction.a, transaction.b, transaction.c, str);
                    com.alibaba.appmonitor.d.c.a(transaction);
                }
            }
        } catch (Throwable th) {
            com.alibaba.analytics.core.c.a.c.a(com.alibaba.analytics.core.c.a.b.b, th);
        }
    }

    public final void b(Transaction transaction, String str) throws RemoteException {
        try {
            if (com.alibaba.appmonitor.d.f.b && transaction != null) {
                af.a("TransactionDelegate", "statEvent end. module: ", transaction.b, " monitorPoint: ", transaction.c, " measureName: ", str);
                if (!h.STAT.e) {
                    return;
                }
                if (com.alibaba.appmonitor.d.f.a || com.alibaba.appmonitor.a.d.a().a(h.STAT, transaction.b, transaction.c)) {
                    com.alibaba.appmonitor.d.c.a(transaction);
                    com.alibaba.appmonitor.f.d.a().a(transaction.e, str, false);
                }
            }
        } catch (Throwable th) {
            af.b(null, th, new Object[0]);
        }
    }
}
