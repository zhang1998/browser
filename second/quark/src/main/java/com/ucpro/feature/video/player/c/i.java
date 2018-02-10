package com.ucpro.feature.video.player.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.uc.a.d.j;
import com.uc.apollo.impl.SettingsConst;
import com.uc.media.interfaces.IApolloHelper.Apollo;
import com.uc.media.interfaces.IApolloHelper.CPU;
import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.uc.media.interfaces.IApolloHelper.Global;
import com.uc.quark.h;
import com.uc.quark.n;
import com.uc.quark.x;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.business.e.a.a;
import com.ucpro.c.b;
import com.ucweb.a.b.c;
import com.ucweb.a.r;
import com.ucweb.a.s;
import com.ucweb.a.u;
import com.ucweb.common.util.d;
import com.ucweb.common.util.e;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* compiled from: ProGuard */
public final class i implements j, c, g, c {
    public static final Runnable b = new j();
    public static final Runnable c = new e();
    private static i d = null;
    boolean a = false;
    private List<WeakReference<d>> e = new ArrayList();
    private Handler f = new e(getClass().getName() + 125);
    private String g = null;
    private boolean h = true;
    private h i = new h(this);
    private int j;
    private m k = new m();
    private k l = new k(this);
    private l m = new l(this);
    private int n;

    public static synchronized i e() {
        i iVar;
        synchronized (i.class) {
            if (d == null) {
                d = new i();
            }
            iVar = d;
        }
        return iVar;
    }

    private i() {
        a.a().a(SettingKeys.VideoSoUpgradeRule, (j) this);
    }

    public final void a(String str, com.uc.a.b.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            m.a(0, new a(this, str, com.ucpro.business.e.f.a.b(eVar)));
        }
    }

    public final void a(boolean z) {
        boolean z2 = false;
        if (this.h && !g()) {
            if (!z || com.ucweb.common.util.i.c.b()) {
                int i;
                int e;
                boolean z3;
                k kVar;
                l lVar;
                File file;
                String str;
                String str2;
                l lVar2;
                String str3;
                m mVar = this.k;
                if (!com.ucweb.common.util.n.a.a(mVar.k)) {
                    if ("A".equals(mVar.k)) {
                        i = 20;
                    } else if ("V".equals(mVar.k)) {
                        i = 10;
                    } else if ("AV".equals(mVar.k)) {
                        i = 21;
                    } else if ("VA".equals(mVar.k)) {
                        i = 11;
                    }
                    this.n = i;
                    i = this.n;
                    e = com.ucpro.model.a.e("3D732F2EB5350B125B101FA7E47309ED");
                    if (i == e) {
                        z3 = false;
                    } else if (i / 10 != e / 10) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        a(0, 0);
                        com.ucpro.model.a.a("last_check_video_so_second", -1);
                        com.ucpro.model.a.a("447EC9698209622E80A965638A7007D6", "");
                        kVar = this.l;
                        kVar.c = false;
                        kVar.d = false;
                        com.ucpro.model.a.b("2692979B693227B5BAD97907D129C8C8", 0);
                        k.b();
                        lVar = this.m;
                        lVar.b = 0;
                        lVar.d = false;
                        lVar.g = false;
                        lVar.e = false;
                        lVar.c.clear();
                        com.ucweb.common.util.k.a.b(new File(ContextUtils.getDataDir(d.a()) + "VitamioTemp/"));
                        l.a();
                    }
                    com.ucpro.model.a.b("3D732F2EB5350B125B101FA7E47309ED", this.n);
                    if (this.n >= 20) {
                        try {
                            if (b.b()) {
                                com.ucpro.ui.b.e.a().a("开始检查更新ApolloSo", 0);
                            }
                            i = com.ucpro.model.a.e("2519247797BA400FFDE7E9EFE568F560");
                            try {
                                file = new File(ContextUtils.getDataDir(d.a()) + Global.getLibsPath((com.ucpro.feature.video.b.c.c + 1) % Global.getLibsPathLength()));
                                if (file.exists() && com.ucpro.feature.video.b.c.c == i) {
                                    com.ucweb.common.util.k.a.b(file);
                                }
                            } catch (Exception e2) {
                            }
                            com.ucpro.model.a.b("567DE2436BE8422FCD6ED90184AC9F76", com.ucpro.feature.video.b.c.c);
                            if (com.ucweb.common.util.n.a.a(this.g)) {
                                this.g = com.ucpro.model.a.b("447EC9698209622E80A965638A7007D6", "");
                            }
                            if (new File(ContextUtils.getDataDir(d.a()) + "VitamioTemp/").exists()) {
                                if (Apollo.isInitialized(d.a())) {
                                    if ((System.currentTimeMillis() / 1000) - com.ucpro.model.a.c("last_check_video_so_second") <= ((long) ((this.k.j * 24) * 60)) * 60) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (i == 0) {
                                        if (b.b()) {
                                            com.ucpro.ui.b.e.a().a("仍在版本检查时间间隔中，不可再检查", 0);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (!g() && Apollo.isInitSoLoaded()) {
                                    String str4;
                                    this.j = this.k.g;
                                    String a = com.ucpro.feature.video.b.e.a(com.ucpro.feature.video.f.a.APOLLO);
                                    str = null;
                                    if (com.ucpro.feature.video.f.a.APOLLO.equals(com.ucpro.feature.video.f.a.APOLLO)) {
                                        str = Apollo.getChildVer();
                                    }
                                    if (com.ucweb.common.util.n.a.a(str)) {
                                        str4 = "";
                                    } else {
                                        str4 = str;
                                    }
                                    String str5 = "4";
                                    String str6 = "ApolloSo";
                                    if (this.h) {
                                        str2 = Build.MODEL;
                                        m mVar2 = this.k;
                                        if (mVar2.c) {
                                            z3 = true;
                                        } else if (com.ucweb.common.util.n.a.a(str2) || mVar2.a == null || mVar2.a.isEmpty()) {
                                            z3 = false;
                                        } else {
                                            z3 = mVar2.a.contains(str2.replace(" ", ""));
                                            if (mVar2.b) {
                                                z3 = !z3;
                                            }
                                        }
                                        if (z3) {
                                            i = 1;
                                        } else {
                                            mVar2 = this.k;
                                            if (mVar2.f) {
                                                z3 = true;
                                            } else if (com.ucweb.common.util.n.a.a(str2) || mVar2.d == null || mVar2.d.isEmpty()) {
                                                z3 = false;
                                            } else {
                                                z3 = mVar2.d.contains(str2.replace(" ", ""));
                                                if (mVar2.e) {
                                                    z3 = !z3;
                                                }
                                            }
                                            if (!z3) {
                                                if (this.k.h) {
                                                    i = 1;
                                                } else if (!this.k.i && com.ucweb.common.util.d.e.l() / 1024 > ((long) this.j)) {
                                                    i = 1;
                                                }
                                            }
                                            i = 0;
                                        }
                                        if (i != 0 && !h() && j()) {
                                            int i2;
                                            int i3;
                                            str2 = SettingsConst.FALSE;
                                            str = SettingsConst.FALSE;
                                            int feature = CPU.getFeature();
                                            if ((CPU.getInt("FEATURE_ARM_V7A") & feature) > 0) {
                                                e = 0;
                                                i2 = 0;
                                                i3 = 1;
                                            } else if ((CPU.getInt("FEATURE_ARM_V6") & feature) > 0) {
                                                e = 0;
                                                i2 = 1;
                                                i3 = 0;
                                            } else if ((CPU.getInt("FEATURE_X86") & feature) > 0) {
                                                e = 1;
                                                i2 = 0;
                                                i3 = 0;
                                            } else {
                                                e = 0;
                                                i2 = 0;
                                                i3 = 0;
                                            }
                                            if (i3 == 0 && i2 == 0 && r4 == 0) {
                                                k();
                                                return;
                                            }
                                            String str7;
                                            if (i3 != 0) {
                                                str7 = "v7";
                                            } else if (i2 != 0) {
                                                str7 = "v6";
                                            } else {
                                                str7 = "x86";
                                            }
                                            if ((CPU.getInt("FEATURE_ARM_VFP") & feature) > 0) {
                                                e = 1;
                                            } else {
                                                e = 0;
                                            }
                                            if ((CPU.getInt("FEATURE_ARM_VFPV3") & feature) > 0) {
                                                z2 = true;
                                            }
                                            if (e != 0) {
                                                str2 = SettingsConst.TRUE;
                                            }
                                            if (z2) {
                                                str = SettingsConst.TRUE;
                                            }
                                            s sVar = new s();
                                            sVar.a = str6;
                                            sVar.e = a;
                                            sVar.i = str7;
                                            sVar.j = str2;
                                            sVar.k = str;
                                            sVar.m = str4;
                                            sVar.l = str5;
                                            r.a().a = this;
                                            r.a().a(sVar);
                                            com.ucpro.model.a.a("last_check_video_so_second", System.currentTimeMillis() / 1000);
                                            this.h = false;
                                            this.f.postDelayed(this.i, 300000);
                                            int[] i4 = i();
                                            a(i4[2] + 1, i4[3] + 1);
                                            com.ucpro.business.stat.m.a("apolloso", "req_upd_i", new String[0]);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            str = ContextUtils.getDataDir(d.a());
                            str2 = str + Apollo.Get_DOWNLOADED_LIB();
                            str = str + Global.getLibsPath(f());
                            lVar2 = this.m;
                            str3 = this.g;
                            e = this.n;
                            if (!lVar2.g && !lVar2.d) {
                                if (new File(ContextUtils.getDataDir(d.a()) + "VitamioTemp/").exists()) {
                                    try {
                                        File file2 = new File(ContextUtils.getDataDir(d.a()) + "VitamioMd5");
                                        if (file2.exists()) {
                                            String[] a2 = com.ucweb.common.util.k.a.a(file2);
                                            if (a2 != null && a2.length > 0) {
                                                lVar2.a(a2[0]);
                                            }
                                        }
                                    } catch (Exception e3) {
                                    }
                                    lVar2.e = true;
                                    lVar2.a(str2, str, str3, e);
                                }
                                lVar2.d = true;
                                return;
                            }
                        } catch (Throwable th) {
                            return;
                        }
                    }
                }
                i = 0;
                this.n = i;
                i = this.n;
                e = com.ucpro.model.a.e("3D732F2EB5350B125B101FA7E47309ED");
                if (i == e) {
                    z3 = false;
                } else if (i / 10 != e / 10) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    a(0, 0);
                    com.ucpro.model.a.a("last_check_video_so_second", -1);
                    com.ucpro.model.a.a("447EC9698209622E80A965638A7007D6", "");
                    kVar = this.l;
                    kVar.c = false;
                    kVar.d = false;
                    com.ucpro.model.a.b("2692979B693227B5BAD97907D129C8C8", 0);
                    k.b();
                    lVar = this.m;
                    lVar.b = 0;
                    lVar.d = false;
                    lVar.g = false;
                    lVar.e = false;
                    lVar.c.clear();
                    com.ucweb.common.util.k.a.b(new File(ContextUtils.getDataDir(d.a()) + "VitamioTemp/"));
                    l.a();
                }
                com.ucpro.model.a.b("3D732F2EB5350B125B101FA7E47309ED", this.n);
                if (this.n >= 20) {
                    if (b.b()) {
                        com.ucpro.ui.b.e.a().a("开始检查更新ApolloSo", 0);
                    }
                    i = com.ucpro.model.a.e("2519247797BA400FFDE7E9EFE568F560");
                    file = new File(ContextUtils.getDataDir(d.a()) + Global.getLibsPath((com.ucpro.feature.video.b.c.c + 1) % Global.getLibsPathLength()));
                    com.ucweb.common.util.k.a.b(file);
                    com.ucpro.model.a.b("567DE2436BE8422FCD6ED90184AC9F76", com.ucpro.feature.video.b.c.c);
                    if (com.ucweb.common.util.n.a.a(this.g)) {
                        this.g = com.ucpro.model.a.b("447EC9698209622E80A965638A7007D6", "");
                    }
                    if (new File(ContextUtils.getDataDir(d.a()) + "VitamioTemp/").exists()) {
                        if (Apollo.isInitialized(d.a())) {
                            if ((System.currentTimeMillis() / 1000) - com.ucpro.model.a.c("last_check_video_so_second") <= ((long) ((this.k.j * 24) * 60)) * 60) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i == 0) {
                                if (b.b()) {
                                    com.ucpro.ui.b.e.a().a("仍在版本检查时间间隔中，不可再检查", 0);
                                    return;
                                }
                                return;
                            }
                        }
                        if (!g()) {
                            return;
                        }
                        return;
                    }
                    str = ContextUtils.getDataDir(d.a());
                    str2 = str + Apollo.Get_DOWNLOADED_LIB();
                    str = str + Global.getLibsPath(f());
                    lVar2 = this.m;
                    str3 = this.g;
                    e = this.n;
                    if (!lVar2.g) {
                    }
                }
            }
        }
    }

    private static void a(u uVar) {
        com.ucpro.business.stat.m.a("apolloso", "req_upd_f", new String[0]);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("Apollo更新请求失败", 0);
        }
        if (uVar != null) {
        }
    }

    public final void c() {
        if (this.n >= 20) {
            String dataDir = ContextUtils.getDataDir(d.a());
            this.m.a(dataDir + Apollo.Get_DOWNLOADED_LIB(), dataDir + Global.getLibsPath(f()), this.g, this.n);
        }
        x.b(this.l);
        com.ucpro.business.stat.m.a("apolloso", "so_dow_s", new String[0]);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("Apollo下载成功，去解压", 0);
        }
    }

    public final void d() {
        k();
        x.b(this.l);
        com.ucpro.business.stat.m.a("apolloso", "so_dow_f", new String[0]);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("Apollo下载失败", 0);
        }
    }

    public final void a(long j) {
        int i = (int) j;
        for (WeakReference weakReference : this.e) {
            d dVar = (d) weakReference.get();
            if (dVar != null) {
                dVar.a(i);
            }
        }
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("Apollo下载中： " + j + "%", 0);
        }
    }

    public final void a() {
        if (this.n >= 20) {
            com.ucpro.model.a.b("2519247797BA400FFDE7E9EFE568F560", f());
        }
        a(0, 0);
        for (WeakReference weakReference : this.e) {
            d dVar = (d) weakReference.get();
            if (dVar != null) {
                dVar.a();
            }
        }
        com.ucpro.business.stat.m.a("apolloso", "so_ext_s", new String[0]);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("Apollo解压成功，整个流程完成", 0);
        }
    }

    public final void b() {
        com.ucpro.business.stat.m.a("apolloso", "so_ext_f", new String[0]);
        if (b.b()) {
            com.ucpro.ui.b.e.a().a("Apollo解压失败", 0);
        }
    }

    private static int f() {
        Context a = d.a();
        String dataDir = ContextUtils.getDataDir(a);
        int i = com.ucpro.feature.video.b.c.c;
        if (i < 0 && i >= Global.getLibsPathLength()) {
            i = 0;
        }
        try {
            File file = new File(dataDir + Global.getLibsPath(i));
            if (!file.exists()) {
                return i;
            }
            if (!Apollo.isInitialized(a.getApplicationContext())) {
                com.ucweb.common.util.k.a.b(file);
                return i;
            }
            return (i + 1) % Global.getLibsPathLength();
        } catch (Exception e) {
        }
    }

    private static void a(int i, int i2) {
        try {
            int c = com.ucweb.common.util.g.a.c();
            Context a = d.a();
            int i3 = Calendar.getInstance().get(6);
            String[] strArr = new String[]{String.valueOf(c), String.valueOf(i3), String.valueOf(i), String.valueOf(i2)};
            File file = new File(ContextUtils.getDataDir(a) + "VitamioCheckedTime");
            if (!file.exists()) {
                file.createNewFile();
            }
            com.ucweb.common.util.k.a.a(file, strArr, false);
        } catch (Exception e) {
        }
    }

    private static boolean h() {
        int[] i = i();
        try {
            PackageInfo a = com.ucweb.common.util.g.a.a(d.a().getPackageName());
            if (!(a == null || i[0] == a.versionCode)) {
                a(0, 0);
                return false;
            }
        } catch (Throwable th) {
        }
        if (i[3] >= 20) {
            return true;
        }
        if (Calendar.getInstance().get(6) != i[1]) {
            a(0, i[3]);
            return false;
        } else if (i[2] >= 5) {
            return true;
        } else {
            return false;
        }
    }

    private static int[] i() {
        int[] iArr = new int[]{0, 0, 0, 0};
        try {
            String[] a = com.ucweb.common.util.k.a.a(ContextUtils.getDataDir(d.a()) + "VitamioCheckedTime");
            if (!(a == null || com.ucweb.common.util.n.a.a(a[0]) || a.length != 4)) {
                for (int i = 0; i < a.length; i++) {
                    iArr[i] = Integer.parseInt(a[i]);
                }
            }
        } catch (Exception e) {
        }
        return iArr;
    }

    private boolean j() {
        return this.k.a() || com.ucweb.common.util.i.c.d();
    }

    public final void a(u uVar, boolean z) {
        if (!z) {
            a(uVar);
        } else if (uVar != null) {
            if (uVar.a()) {
                String str;
                if (b.b()) {
                    com.ucpro.ui.b.e.a().a("Apollo有新版本，去下载", 0);
                }
                String str2 = uVar.c;
                int i = uVar.b;
                String str3 = uVar.d;
                String str4 = uVar.n;
                String a = uVar.a("extract_md5");
                l lVar = this.m;
                if (!com.ucweb.common.util.n.a.a(a) && a.startsWith("md5:")) {
                    str = "";
                    int indexOf = a.indexOf("md5:") + 4;
                    if (indexOf > 0 && indexOf < a.length()) {
                        a = a.substring(indexOf, a.length());
                        indexOf = a.indexOf(":md5");
                        if (indexOf > 0 && indexOf < a.length()) {
                            str = a.substring(0, indexOf);
                        }
                    }
                    if (!com.ucweb.common.util.n.a.a(str)) {
                        lVar.a(str);
                        if (!com.ucweb.common.util.n.a.a(str)) {
                            try {
                                File file = new File(ContextUtils.getDataDir(d.a()) + "VitamioMd5");
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                com.ucweb.common.util.k.a.a(file, new String[]{str}, false);
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                lVar.b = 0;
                this.g = uVar.j;
                a = SettingsConst.FALSE;
                if (!(com.ucweb.common.util.n.a.a(str2) || !j() || g())) {
                    str = "";
                    if (this.n >= 20) {
                        str = Apollo.Get_DOWNLOADED_LIB();
                    }
                    k kVar = this.l;
                    String str5 = this.g;
                    boolean a2 = this.k.a();
                    int i2 = this.n;
                    kVar.e = str5;
                    kVar.f = a2;
                    kVar.g = i2;
                    kVar.h = str;
                    h hVar = this.l;
                    if (!com.ucweb.common.util.n.a.a(str2)) {
                        Object obj;
                        k.b();
                        if (20971520 < com.ucweb.common.util.k.a.e(ContextUtils.getDataDir(d.a()))) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            hVar.a.d();
                        } else {
                            str = ContextUtils.getDataDir(d.a());
                            n nVar = new n();
                            nVar.a = str2;
                            nVar.e = str + hVar.h;
                            nVar.d = hVar.h;
                            nVar.f = true;
                            nVar.g = false;
                            com.uc.quark.s a3 = x.a().a(nVar.a()).a(hVar);
                            if (a3 != null) {
                                Object bundle = new Bundle();
                                bundle.putString("key_product_name", "product_video_so");
                                bundle.putString("key_full_size", String.valueOf(i));
                                bundle.putString("key_safe_download_url", str3);
                                bundle.putString("key_download_mode", a);
                                bundle.putString("key_md5", str4);
                                a3.a(bundle);
                                a3.k();
                                hVar.c = false;
                                hVar.d = false;
                            }
                        }
                    }
                }
                com.ucpro.model.a.a("447EC9698209622E80A965638A7007D6", this.g);
            } else if (b.b()) {
                com.ucpro.ui.b.e.a().a("Apollo没有新版本", 0);
            }
            com.ucpro.business.stat.m.a("apolloso", "req_upd_s", new String[0]);
        }
    }

    public final void a(d dVar) {
        this.e.add(new WeakReference(dVar));
    }

    private void k() {
        for (WeakReference weakReference : this.e) {
            d dVar = (d) weakReference.get();
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    private boolean g() {
        boolean z;
        com.uc.quark.s a = k.a();
        if (a == null || !(a.e() == 6 || a.e() == 3 || a.e() == 2 || a.e() == 1)) {
            z = false;
        } else {
            z = true;
        }
        if (z || this.m.g) {
            return true;
        }
        return false;
    }
}
