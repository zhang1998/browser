package com.ucweb.a;

import android.os.Build;
import com.d.a.a.a;
import com.d.a.a.b;
import com.d.a.b.f;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.b.c.c;
import com.ucweb.a.b.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class t extends a {
    e b;
    d c;

    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    private static f a(String str, String str2) {
        c cVar;
        f fVar = new f();
        fVar.a = c.a(str);
        if (str2 == null) {
            cVar = null;
        } else {
            cVar = c.a(str2);
        }
        fVar.b = cVar;
        return fVar;
    }

    public final String c() {
        String d = this.b.d();
        if (d.contains("?")) {
            return d + "&from=pb_query";
        }
        return d + "?from=pb_query";
    }

    public final String d() {
        return SpdyRequest.POST_METHOD;
    }

    public final byte[] e() {
        c cVar;
        boolean z;
        int i = 1;
        byte[] bArr = null;
        a aVar = new a();
        String a = com.ucweb.a.a.c.c().a();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        aVar.a = cVar;
        a = Build.MODEL;
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        aVar.b = cVar;
        aVar.c = com.ucweb.a.a.c.c().b();
        aVar.d = com.ucweb.a.a.c.c().c();
        a = com.ucweb.a.a.c.c().d();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        aVar.e = cVar;
        a = com.ucweb.a.a.c.c().e();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        aVar.f = cVar;
        a = com.ucweb.a.a.c.c().f();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        aVar.g = cVar;
        b bVar = new b();
        bVar.a(com.ucweb.a.a.c.c().s());
        bVar.b(com.ucweb.a.a.c.c().t());
        bVar.c(com.ucweb.a.a.c.c().u());
        bVar.d(com.ucweb.a.a.c.c().v());
        bVar.e(com.ucweb.a.a.c.c().w());
        bVar.f(com.ucweb.a.a.c.c().x());
        bVar.h(com.ucweb.a.a.c.c().y());
        bVar.i(com.ucweb.a.a.c.c().z());
        a = com.ucweb.a.a.c.c().A();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        bVar.a = cVar;
        a = com.ucweb.a.a.c.c().B();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        bVar.b = cVar;
        bVar.j(com.ucweb.a.a.c.c().C());
        bVar.g(com.ucweb.a.a.c.c().D());
        a = com.ucweb.a.a.c.c().E();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        bVar.c = cVar;
        a = com.ucweb.a.a.c.c().F();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        bVar.d = cVar;
        a = com.ucweb.a.a.c.c().G();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        bVar.e = cVar;
        bVar.f = c.a("");
        bVar.g = c.a("");
        com.d.a.b.c cVar2 = new com.d.a.b.c();
        cVar2.b = aVar;
        cVar2.a = bVar;
        s a2 = this.b.a();
        cVar2.c = this.b.b();
        ArrayList arrayList = cVar2.d;
        arrayList.add(a("os_ver", com.ucweb.a.a.c.c().g()));
        arrayList.add(a("cpu_arch", com.ucweb.a.a.c.c().h()));
        String i2 = com.ucweb.a.a.c.c().i();
        arrayList.add(a("cpu_vfp", i2));
        arrayList.add(a("net_type", String.valueOf(com.ucweb.a.a.c.c().j())));
        arrayList.add(a("fromhost", a2.d));
        arrayList.add(a("plugin_ver", a2.e));
        arrayList.add(a("target_lang", a2.h));
        arrayList.add(a("cur_ver_md5", a2.c));
        arrayList.add(a("vitamio_cpu_arch", a2.i));
        arrayList.add(a("vitamio_vfp", a2.j));
        arrayList.add(a("vitamio_vfp3", a2.k));
        arrayList.add(a("plugin_child_ver", a2.m));
        arrayList.add(a("ver_series", a2.l));
        arrayList.add(a("child_ver", com.ucweb.a.a.c.c().q()));
        if ("------".equalsIgnoreCase(this.b.c())) {
            File file = new File(com.ucweb.a.a.c.c().I() + "upgrade_log");
            if (file.exists()) {
                byte[] a3 = com.ucweb.a.a.c.b().a(file);
                if (a3 == null || a3.length <= 0) {
                    a = null;
                } else {
                    a = new String(a3);
                }
            } else {
                a = null;
            }
            arrayList.add(a("upgrade_log", a));
        }
        arrayList.add(a("md5_type", SettingsConst.FALSE));
        arrayList.add(a("md5_str", ""));
        arrayList.add(a("cpu_archit", com.ucweb.a.a.c.c().k()));
        arrayList.add(a("cpu_set", "thumb"));
        if (i2 == null || !i2.contains("neon")) {
            z = false;
        } else {
            z = true;
        }
        arrayList.add(a("neon", String.valueOf(z)));
        arrayList.add(a("cpu_cores", String.valueOf(com.ucweb.a.a.c.c().l())));
        arrayList.add(a("ram_1", String.valueOf(com.ucweb.a.a.c.c().m())));
        arrayList.add(a("totalram", String.valueOf(com.ucweb.a.a.c.c().n())));
        arrayList.add(a("rom_1", com.ucweb.a.a.c.c().g()));
        int b = com.ucweb.a.a.c.c().b();
        i2 = "ss";
        arrayList.add(a(i2, b + "*" + com.ucweb.a.a.c.c().c()));
        arrayList.add(a("api_level", com.ucweb.a.a.c.c().o()));
        arrayList.add(a("uc_apk_list", com.ucweb.a.a.c.c().p()));
        if (com.ucweb.common.util.n.a.b(a2.o)) {
            arrayList.add(a("dv", a2.o));
        }
        cVar2.f = a2.n;
        h.a().a(a2.n);
        a = this.b.c();
        if (a == null) {
            cVar = null;
        } else {
            cVar = c.a(a);
        }
        cVar2.e = cVar;
        byte[] l_ = cVar2.l_();
        if (l_ != null) {
            Object a4 = com.ucweb.a.a.c.b().a(l_);
            if (a4 != null) {
                bArr = new byte[(a4.length + 16)];
                Object obj = new byte[16];
                Arrays.fill(obj, (byte) 0);
                obj[0] = (byte) 95;
                if (com.ucweb.a.a.c.a() == com.ucweb.a.a.b.b) {
                    i = 11;
                } else if (com.ucweb.a.a.c.a() == com.ucweb.a.a.b.c) {
                    i = 31;
                }
                obj[2] = (byte) i;
                obj[3] = (byte) -50;
                System.arraycopy(obj, 0, bArr, 0, 16);
                System.arraycopy(a4, 0, bArr, 16, a4.length);
            }
        }
        return bArr;
    }

    public final Object a(byte[] bArr) {
        return this.c != null ? this.c.a(bArr) : null;
    }

    public final void a(Object obj) {
        if (this.c != null) {
            this.c.a(this.b, obj);
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c.a(this.b);
        }
    }
}
