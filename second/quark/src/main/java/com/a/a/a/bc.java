package com.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class bc {
    public static bc b;
    cv a = null;
    private final String c = "umeng_it.cache";
    private File d;
    private long e;
    private long f;
    private Set<as> g = new HashSet();
    private ay h = null;

    private bc(Context context) {
        this.d = new File(context.getFilesDir(), "umeng_it.cache");
        this.f = 86400000;
        this.h = new ay(context);
        this.h.b();
    }

    public static synchronized bc a(Context context) {
        bc bcVar;
        Object obj = 1;
        synchronized (bc.class) {
            if (b == null) {
                bc bcVar2 = new bc(context);
                b = bcVar2;
                bcVar2.a(new av(context));
                b.a(new ba(context));
                b.a(new az(context));
                b.a(new ax(context));
                b.a(new bf(context));
                b.a(new aw(context));
                b.a(new at());
                b.a(new bg(context));
                as bhVar = new bh(context);
                bhVar.f = bb.a(bhVar.d).c.d;
                if (!TextUtils.isEmpty(bhVar.f)) {
                    bhVar.f = fg.c(bhVar.f);
                    Object a = fu.a(new File("/sdcard/Android/data/.um/sysid.dat"));
                    Object a2 = fu.a(new File("/sdcard/Android/obj/.um/sysid.dat"));
                    Object a3 = fu.a(new File("/data/local/tmp/.um/sysid.dat"));
                    if (TextUtils.isEmpty(a)) {
                        bhVar.e();
                    } else if (!bhVar.f.equals(a)) {
                        bhVar.e = a;
                        if (obj != null) {
                            b.a(bhVar);
                            b.a(new au(context));
                            try {
                                bhVar.e();
                                bhVar.d();
                                bhVar.c();
                            } catch (Exception e) {
                            }
                        }
                        b.d();
                    }
                    if (TextUtils.isEmpty(a2)) {
                        bhVar.d();
                    } else if (!bhVar.f.equals(a2)) {
                        bhVar.e = a2;
                        if (obj != null) {
                            b.a(bhVar);
                            b.a(new au(context));
                            bhVar.e();
                            bhVar.d();
                            bhVar.c();
                        }
                        b.d();
                    }
                    if (TextUtils.isEmpty(a3)) {
                        bhVar.c();
                    } else if (!bhVar.f.equals(a3)) {
                        bhVar.e = a3;
                        if (obj != null) {
                            b.a(bhVar);
                            b.a(new au(context));
                            bhVar.e();
                            bhVar.d();
                            bhVar.c();
                        }
                        b.d();
                    }
                }
                obj = null;
                if (obj != null) {
                    b.a(bhVar);
                    b.a(new au(context));
                    bhVar.e();
                    bhVar.d();
                    bhVar.c();
                }
                b.d();
            }
            bcVar = b;
        }
        return bcVar;
    }

    private boolean a(as asVar) {
        boolean z;
        ay ayVar = this.h;
        if (ayVar.a.contains(asVar.a)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return this.g.add(asVar);
        }
        return false;
    }

    public final void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.e >= this.f) {
            int i = 0;
            for (as asVar : this.g) {
                if (asVar.a()) {
                    String str;
                    int i2;
                    int i3;
                    do doVar = asVar.c;
                    if (doVar == null) {
                        str = null;
                    } else {
                        str = doVar.a;
                    }
                    if (doVar == null) {
                        i2 = 0;
                    } else {
                        i2 = doVar.c;
                    }
                    String b = asVar.b();
                    if (b == null) {
                        b = null;
                    } else {
                        b = b.trim();
                        if (b.length() == 0) {
                            b = null;
                        } else if (SettingsConst.FALSE.equals(b)) {
                            b = null;
                        } else if ("unknown".equals(b.toLowerCase(Locale.US))) {
                            b = null;
                        }
                    }
                    if (b == null || b.equals(str)) {
                        i2 = 0;
                    } else {
                        if (doVar == null) {
                            doVar = new do();
                        }
                        doVar.a = b;
                        doVar.b = System.currentTimeMillis();
                        doVar.a();
                        doVar.c = i2 + 1;
                        doVar.b();
                        du duVar = new du();
                        duVar.a = asVar.a;
                        duVar.c = b;
                        duVar.b = str;
                        duVar.d = doVar.b;
                        duVar.b();
                        if (asVar.b == null) {
                            asVar.b = new ArrayList(2);
                        }
                        asVar.b.add(duVar);
                        if (asVar.b.size() > 10) {
                            asVar.b.remove(0);
                        }
                        asVar.c = doVar;
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        if (!asVar.a()) {
                            ay ayVar = this.h;
                            ayVar.a.add(asVar.a);
                        }
                        i3 = 1;
                    } else {
                        i3 = i;
                    }
                    i = i3;
                }
            }
            if (i != 0) {
                c();
                this.h.a();
                e();
            }
            this.e = currentTimeMillis;
        }
    }

    private void c() {
        cv cvVar = new cv();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (as asVar : this.g) {
            if (asVar.a()) {
                if (asVar.c != null) {
                    hashMap.put(asVar.a, asVar.c);
                }
                if (!(asVar.b == null || asVar.b.isEmpty())) {
                    arrayList.addAll(asVar.b);
                }
            }
        }
        cvVar.b = arrayList;
        cvVar.a = hashMap;
        synchronized (this) {
            this.a = cvVar;
        }
    }

    public final void b() {
        boolean z = false;
        for (as asVar : this.g) {
            if (asVar.a()) {
                boolean z2;
                if (asVar.b == null || asVar.b.isEmpty()) {
                    z2 = z;
                } else {
                    asVar.b = null;
                    z2 = true;
                }
                z = z2;
            }
        }
        if (z) {
            this.a.a(false);
            e();
        }
    }

    private void d() {
        cv f = f();
        if (f != null) {
            List<as> arrayList = new ArrayList(this.g.size());
            synchronized (this) {
                this.a = f;
                for (as asVar : this.g) {
                    asVar.a(this.a);
                    if (!asVar.a()) {
                        arrayList.add(asVar);
                    }
                }
                for (as asVar2 : arrayList) {
                    this.g.remove(asVar2);
                }
            }
            c();
        }
    }

    private void e() {
        if (this.a != null) {
            c cVar = this.a;
            if (cVar != null) {
                try {
                    byte[] a;
                    synchronized (this) {
                        a = new e().a(cVar);
                    }
                    if (a != null) {
                        fu.a(this.d, a);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private cv f() {
        InputStream inputStream;
        Throwable th;
        if (!this.d.exists()) {
            return null;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(this.d);
            try {
                byte[] b = fu.b(fileInputStream);
                c cvVar = new cv();
                new b().a(cvVar, b);
                fu.c(fileInputStream);
                return cvVar;
            } catch (Exception e) {
                inputStream = fileInputStream;
                fu.c(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fu.c(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            inputStream = null;
            fu.c(inputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            fu.c(fileInputStream);
            throw th;
        }
    }
}
