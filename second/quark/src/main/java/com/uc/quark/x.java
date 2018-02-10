package com.uc.quark;

import android.app.Notification;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.uc.quark.a.c;
import com.uc.quark.a.e;
import com.uc.quark.a.m;
import com.uc.quark.b.a;
import com.uc.quark.b.h;
import com.uc.quark.filedownloader.ah;
import com.uc.quark.filedownloader.ai;
import com.uc.quark.filedownloader.ak;
import com.uc.quark.filedownloader.as;
import com.uc.quark.filedownloader.at;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.n;
import com.uc.quark.filedownloader.r;
import com.uc.quark.filedownloader.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

/* compiled from: ProGuard */
public class x {
    public static String a = "image/gif, image/png, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*";
    public static String b = "identity";
    public static String c = "utf-8";
    public static String d = "zh-CN";
    private static int g = 10;
    private static t l;
    public final Object e;
    public a f;
    private ai h;
    private boolean i;
    private ArrayList<r> j;
    private Notification k;
    private boolean m;

    public static x a() {
        return aa.a;
    }

    private x() {
        this.e = new Object();
        this.i = false;
        this.j = new ArrayList();
        this.m = false;
        this.f = new a();
    }

    public static void a(String str) {
        b.c(str);
    }

    public static String b() {
        return b.d();
    }

    public static Runnable a(Context context, m mVar, ad adVar) {
        Assert.assertEquals(Looper.getMainLooper(), Looper.myLooper());
        c.a(context);
        as.a(context, adVar);
        return new q(mVar, context);
    }

    public static void c() {
        as.a();
        if (!as.f()) {
            as.a();
            as.c();
        }
    }

    public static void a(Notification notification) {
        if (notification != null) {
            as.a();
            as.a(4627, notification);
        }
    }

    public static void d() {
        as.a();
        as.h();
    }

    private String d(String str) {
        int i = 1;
        while (this.f.a(str)) {
            Object obj;
            int i2;
            String str2;
            if (TextUtils.isEmpty(str)) {
                obj = "";
            } else {
                int lastIndexOf = str.lastIndexOf(".");
                if (lastIndexOf == -1) {
                    obj = "";
                } else {
                    if (lastIndexOf + 1 < str.length()) {
                        lastIndexOf++;
                    }
                    obj = str.substring(lastIndexOf, str.length());
                    if (!e.a(obj)) {
                        obj = "";
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (i >= 2) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                int lastIndexOf2 = str.lastIndexOf(".");
                if (-1 == lastIndexOf2 || lastIndexOf2 == 0 || lastIndexOf2 == 1) {
                    lastIndexOf2 = str.length();
                    i2 = i2 != 0 ? str.length() > 3 ? 3 : 0 : 0;
                    str2 = str.substring(0, lastIndexOf2 - i2);
                } else {
                    i2 = i2 != 0 ? lastIndexOf2 > 3 ? 3 : 0 : 0;
                    str2 = str.substring(0, lastIndexOf2 - i2);
                }
            }
            str = stringBuilder.append(str2).append("(").append(i).append(")").append(TextUtils.isEmpty(obj) ? "" : "." + obj).toString();
            i++;
        }
        return str;
    }

    public final s a(y yVar) {
        s c;
        synchronized (this.e) {
            if (yVar.a.g) {
                int length = yVar.a.d.length();
                yVar.a.d = d(yVar.a.d);
                yVar.a.e = yVar.a.e.substring(0, yVar.a.e.length() - length) + yVar.a.d;
            }
            int a = b.a(yVar.a.a, yVar.a.e);
            if (this.f.b(a)) {
                c = this.f.c(a);
            } else {
                c = new z(a, yVar, System.currentTimeMillis());
                this.f.a(c);
            }
        }
        return c;
    }

    public static int a(int i, String str) {
        as.a();
        return as.a(i, str);
    }

    public static long a(int i) {
        as.a();
        if (((byte) com.uc.quark.filedownloader.contentprovider.a.c(i)) == (byte) -3) {
            return com.uc.quark.filedownloader.contentprovider.a.b(i);
        }
        if (!as.f()) {
            return com.uc.quark.filedownloader.contentprovider.a.b(i);
        }
        at b = ak.a.b(i);
        if (b == null) {
            return n.a.c(i);
        }
        return b.M().q();
    }

    public static long b(int i) {
        as.a();
        if (((byte) com.uc.quark.filedownloader.contentprovider.a.c(i)) == (byte) -3) {
            return com.uc.quark.filedownloader.contentprovider.a.a(i);
        }
        if (!as.f()) {
            return com.uc.quark.filedownloader.contentprovider.a.a(i);
        }
        at b = ak.a.b(i);
        if (b == null) {
            return n.a.b(i);
        }
        return b.M().o();
    }

    public static long c(int i) {
        as.a();
        if (!as.f()) {
            return 0;
        }
        at b = ak.a.b(i);
        if (b != null) {
            return b.M().r();
        }
        return 0;
    }

    protected final List<s> e() {
        List<s> a;
        synchronized (x.class) {
            a = this.f.a();
        }
        return a;
    }

    public final List<s> f() {
        List arrayList = new ArrayList();
        Collection a = this.f.a();
        synchronized (this.e) {
            arrayList.addAll(a);
        }
        return arrayList;
    }

    protected final List<s> g() {
        List<s> b;
        synchronized (x.class) {
            b = this.f.b();
        }
        return b;
    }

    public final synchronized List<s> h() {
        List arrayList;
        arrayList = new ArrayList();
        Collection b = this.f.b();
        synchronized (this.e) {
            arrayList.addAll(b);
        }
        return arrayList;
    }

    public final void a(int i, boolean z) {
        synchronized (this.e) {
            a(i, z, null, "", 0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void a(int r5, boolean r6, java.lang.Object r7, java.lang.String r8, int r9) {
        /*
        r4 = this;
        r1 = r4.e;
        monitor-enter(r1);
        r0 = r4.f;	 Catch:{ all -> 0x0025 }
        r0 = r0.c(r5);	 Catch:{ all -> 0x0025 }
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r0 = r4.f;	 Catch:{ all -> 0x0025 }
        r0 = r0.d(r5);	 Catch:{ all -> 0x0025 }
    L_0x0011:
        if (r0 != 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
    L_0x0014:
        return;
    L_0x0015:
        r0.a(r7);	 Catch:{ all -> 0x0025 }
        r0.a = r9;	 Catch:{ all -> 0x0025 }
        r0.a(r8);	 Catch:{ all -> 0x0025 }
        r2 = r0.a();	 Catch:{ all -> 0x0025 }
        if (r2 == r5) goto L_0x0028;
    L_0x0023:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        goto L_0x0014;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0025 }
        r2 = com.uc.quark.filedownloader.as.f();	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x006a;
    L_0x0031:
        r2 = 0;
        r4.i = r2;	 Catch:{ all -> 0x0025 }
        r2 = r4.j;	 Catch:{ all -> 0x0025 }
        r3 = new com.uc.quark.r;	 Catch:{ all -> 0x0025 }
        r3.<init>(r6, r0);	 Catch:{ all -> 0x0025 }
        r2.add(r3);	 Catch:{ all -> 0x0025 }
        r0 = r4.j;	 Catch:{ all -> 0x0025 }
        r0 = r0.size();	 Catch:{ all -> 0x0025 }
        r2 = 1;
        if (r0 != r2) goto L_0x0068;
    L_0x0047:
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0025 }
        com.uc.quark.filedownloader.as.c();	 Catch:{ all -> 0x0025 }
        r0 = r4.h;	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0025 }
        r0 = r4.h;	 Catch:{ all -> 0x0025 }
        com.uc.quark.filedownloader.as.b(r0);	 Catch:{ all -> 0x0025 }
    L_0x0059:
        r0 = new com.uc.quark.d;	 Catch:{ all -> 0x0025 }
        r0.<init>(r4);	 Catch:{ all -> 0x0025 }
        r4.h = r0;	 Catch:{ all -> 0x0025 }
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0025 }
        r0 = r4.h;	 Catch:{ all -> 0x0025 }
        com.uc.quark.filedownloader.as.a(r0);	 Catch:{ all -> 0x0025 }
    L_0x0068:
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        goto L_0x0014;
    L_0x006a:
        r0.c(r6);	 Catch:{ all -> 0x0025 }
        r4.a(r0);	 Catch:{ all -> 0x0025 }
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.x.a(int, boolean, java.lang.Object, java.lang.String, int):void");
    }

    public static void a(t tVar) {
        l = tVar;
    }

    private void a(s sVar) {
        m.a(0, new o(this, sVar));
    }

    public static boolean i() {
        as.a();
        return as.f();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<com.uc.quark.s> r3) {
        /*
        r2 = this;
        r1 = r2.e;
        monitor-enter(r1);
        if (r3 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x0006:
        return;
    L_0x0007:
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0029 }
        r0 = com.uc.quark.filedownloader.as.f();	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x002c;
    L_0x0010:
        r0 = 1;
        r2.i = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r2.m = r0;	 Catch:{ all -> 0x0029 }
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0029 }
        com.uc.quark.filedownloader.as.c();	 Catch:{ all -> 0x0029 }
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0029 }
        r0 = new com.uc.quark.ab;	 Catch:{ all -> 0x0029 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0029 }
        com.uc.quark.filedownloader.as.a(r0);	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x0006;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        d(r3);	 Catch:{ all -> 0x0029 }
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.x.a(java.util.ArrayList):void");
    }

    private static void d(ArrayList<s> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            r rVar = new r();
            rVar.a = sVar.g();
            rVar.b = sVar.h();
            rVar.f = 950;
            rVar.c = false;
            rVar.d = false;
            rVar.g = g;
            String str = null;
            if (l != null) {
                str = l.a(sVar.g());
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(sVar.j())) {
                str = l.a(sVar.j());
            }
            rVar.a("Cookie", str).a("User-Agent", l != null ? l.b(sVar.g()) : "").a("Referer", sVar.j()).a("Connection", "keep-alive").a("Accept", a).a("Accept-Encoding", b).a("Accept-Charset", c).a("Accept-Language", d);
            arrayList2.add(rVar);
        }
        as.a();
        as.a(arrayList2);
    }

    public final void d(int i) {
        synchronized (this.e) {
            as.a();
            if (as.f()) {
                as.a().a(i);
                return;
            }
        }
    }

    public final void j() {
        synchronized (this.e) {
            as a = as.a();
            z.a.a();
            synchronized (as.b) {
                for (at M : ak.a.a()) {
                    M.M().d();
                }
            }
            if (n.a.d()) {
                n.a.b();
            } else {
                if (a.a == null) {
                    a.a = new ah(a);
                }
                n.a.a(com.uc.quark.filedownloader.e.e.a(), a.a);
            }
        }
    }

    public final void b(ArrayList<Integer> arrayList) {
        synchronized (this.e) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a(((Integer) it.next()).intValue(), true, true);
            }
            as.a();
            if (as.f()) {
                as.a();
                as.a((ArrayList) arrayList, true);
                return;
            }
        }
    }

    private void a(int i, boolean z, boolean z2) {
        synchronized (this.e) {
            com.uc.quark.filedownloader.contentprovider.a.d(i);
            s c = this.f.c(i);
            if (c == null) {
                c = this.f.d(i);
            }
            this.f.a(i);
            if (!z2) {
                as.a().a(i);
                n.a.e(i);
            }
            if (z && c != null) {
                c.a(c.h());
                c.a(b.d(b.a(c.h(), false, c.b())));
            }
            if (!(c == null || c.l() || z)) {
                i.a.a();
            }
        }
    }

    public final void b(int i, boolean z) {
        a(i, z, false);
    }

    public final void a(int i, String str, String str2, boolean z) {
        synchronized (this.e) {
            d(i);
            com.uc.quark.filedownloader.contentprovider.a.d(i);
            if (z && !TextUtils.isEmpty(str)) {
                c.a(str);
                c.a(b.d(b.a(str, false, str2)));
            }
            this.f.a(i);
        }
    }

    public static boolean k() {
        as.a();
        return as.g();
    }

    public static byte[] l() {
        as.a();
        return as.b();
    }

    public final synchronized int[] m() {
        int[] iArr;
        iArr = new int[]{0, 0};
        Iterator it = this.f.a.a().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if (com.uc.quark.filedownloader.contentprovider.a.c(((h) it.next()).a) == -3) {
                i++;
            } else {
                i2++;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public final void n() {
        synchronized (this.e) {
            ArrayList a = this.f.a.a();
            ArrayList arrayList = new ArrayList();
            Iterator it = a.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                as.a();
                if (as.a(hVar.a, hVar.b) != (byte) -3) {
                    arrayList.add(hVar);
                }
            }
            if (arrayList.size() > 0) {
                as.a();
                if (as.f()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        m.b(new ag(this, (h) it2.next()));
                    }
                } else {
                    this.i = true;
                    this.m = false;
                    as.a();
                    as.c();
                    as.a();
                    as.a(new e(this, arrayList));
                }
            }
        }
    }

    public final boolean b(String str) {
        return this.f.a(str);
    }

    public final boolean a(y yVar, long j) {
        long j2 = 0;
        boolean z = false;
        synchronized (this.e) {
            int length;
            if (yVar.a.g) {
                length = yVar.a.d.length();
                yVar.a.d = d(yVar.a.d);
                yVar.a.e = yVar.a.e.substring(0, yVar.a.e.length() - length) + yVar.a.d;
            }
            length = b.a(yVar.a.a, yVar.a.e);
            if (this.f.b(length)) {
            } else {
                if (j >= 0) {
                    j2 = j;
                }
                this.f.a(new z(length, yVar, System.currentTimeMillis()));
                com.uc.quark.filedownloader.contentprovider.a.a(length, j2, j2, yVar.a.e);
                z = true;
            }
        }
        return z;
    }

    public static int a(String str, String str2) {
        return b.a(str, str2);
    }

    public static String c(String str) {
        return b.d() + File.separator + str;
    }

    public static boolean e(int i) {
        as.a();
        if (as.f()) {
            return n.a.f(i);
        }
        return false;
    }

    public static void a(j jVar) {
        k.b().e = jVar;
    }

    public static void a(h hVar) {
        k b = k.b();
        synchronized (b.a) {
            k.b = true;
            if (!b.c.contains(hVar)) {
                b.c.add(hVar);
            }
            if (b.d.contains(hVar)) {
                b.d.remove(hVar);
            }
        }
    }

    public static void b(h hVar) {
        k b = k.b();
        synchronized (b.a) {
            if (b.c.contains(hVar)) {
                b.d.add(hVar);
            }
        }
    }

    public static void a(af afVar) {
        i.a.a(afVar);
    }

    static /* synthetic */ void d(x xVar) {
        if (xVar.k != null) {
            as.a();
            as.a(291, xVar.k);
        }
    }

    static /* synthetic */ void o() {
        as.a();
        as.d();
    }

    static /* synthetic */ void a(x xVar, int i) {
        s c = xVar.f.c(i);
        if (c != null && c.a() == i) {
            c.c(false);
            xVar.a(c);
        }
    }
}
