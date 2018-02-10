package com.ucpro.feature.video.player;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.uc.apollo.android.GuideDialog;
import com.uc.apollo.widget.MediaController;
import com.uc.apollo.widget.VideoView;
import com.uc.media.interfaces.IProxyHandler;
import com.uc.media.interfaces.PlayerType;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.feature.video.al;
import com.ucpro.feature.video.an;
import com.ucpro.feature.video.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.b.f;
import com.ucpro.feature.video.player.b.k;
import com.ucpro.feature.video.player.b.l;
import com.ucpro.feature.video.player.b.m;
import com.ucpro.feature.video.player.b.n;
import com.ucpro.feature.video.player.b.r;
import com.ucpro.feature.video.player.b.s;
import com.ucpro.feature.video.player.b.y;
import com.ucpro.feature.video.player.d.o;
import com.ucpro.feature.video.player.d.p;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.e.d;
import com.ucpro.feature.video.player.view.au;
import com.ucweb.common.util.c;
import com.ucweb.common.util.e;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@SuppressLint({"ViewConstructor"})
/* compiled from: ProGuard */
public final class h implements g, i, a {
    Context a;
    g b;
    public an c;
    public r d;
    public e e;
    boolean f;
    private b g;
    private d h;
    private e i;
    private Runnable j;
    private Runnable k;
    private Integer l;
    private List<Integer> m;
    private int n;
    private boolean o;

    public h(Context context, g gVar) {
        this(context, gVar, (byte) 0);
    }

    private h(Context context, g gVar, byte b) {
        this(context, gVar, null, true, 0);
    }

    public h(Context context, g gVar, Integer num, boolean z, int i) {
        this.a = null;
        this.b = null;
        this.g = null;
        this.c = null;
        this.d = null;
        this.h = null;
        this.i = null;
        this.f = false;
        this.n = 0;
        this.o = true;
        this.a = context;
        this.b = gVar;
        this.l = num;
        this.e = new e();
        this.f = z;
        this.n = i;
        Map hashMap = new HashMap();
        hashMap.put(s.class, s.HoverOn);
        hashMap.put(r.class, r.Prepare);
        hashMap.put(f.class, f.MiniScreen);
        hashMap.put(m.class, m.UnLock);
        hashMap.put(l.class, l.Idle);
        hashMap.put(y.class, y.Idle);
        hashMap.put(n.class, n.None);
        this.h = new k(this, hashMap);
        hashMap.clear();
        this.g = new j(this);
        k a = k.a();
        Context context2 = this.a;
        int i2 = this.n;
        if (a.a == null) {
            a.a = new l(context2, this, this, i2);
        }
        this.c = al.a(this.a, PlayerType.APOLLO, this.g, this.l, this.f);
        if (!(this.c == null || this.c.m() == null)) {
            View m = this.c.m();
            c.b(m instanceof VideoView);
            MediaController mediaController = k.a().getMediaController((VideoView) m);
            c.b(mediaController instanceof l);
            Object obj = ((l) mediaController).c;
            c.a(obj);
            c.b(obj instanceof r);
            this.d = (r) obj;
        }
        this.j = new m(this);
        this.k = new i(this);
        this.m = new ArrayList();
        this.m.add(Integer.valueOf(10009));
        this.m.add(Integer.valueOf(UCAsyncTask.getPriority));
        this.m.add(Integer.valueOf(10010));
        this.m.add(Integer.valueOf(10011));
        this.m.add(Integer.valueOf(10012));
        this.m.add(Integer.valueOf(UCAsyncTask.getTaskCount));
        this.m.add(Integer.valueOf(UCAsyncTask.inThread));
        this.m.add(Integer.valueOf(UCAsyncTask.getPercent));
        this.m.add(Integer.valueOf(UCAsyncTask.isPaused));
        this.m.add(Integer.valueOf(10001));
        this.m.add(Integer.valueOf(10006));
        this.m.add(Integer.valueOf(10021));
        this.m.add(Integer.valueOf(UCMPackageInfo.compareVersion));
        this.m.add(Integer.valueOf(SDKFactory.handlePerformanceTests));
        this.m.add(Integer.valueOf(UCMPackageInfo.expectCreateDirFile2P));
        this.m.add(Integer.valueOf(10036));
        this.m.add(Integer.valueOf(UCMPackageInfo.deleteTempDecFiles));
        this.m.add(Integer.valueOf(UCMPackageInfo.initUCMBuildInfo));
        this.m.add(Integer.valueOf(UCMPackageInfo.makeDirDeleteFlg));
        this.m.add(Integer.valueOf(UCMPackageInfo.getRepairApolloRoot));
        this.m.add(Integer.valueOf(UCMPackageInfo.getKernalShareJarLnkRoot));
        this.m.add(Integer.valueOf(10048));
        this.m.add(Integer.valueOf(10052));
        this.m.add(Integer.valueOf(10053));
        this.m.add(Integer.valueOf(10054));
        this.m.add(Integer.valueOf(10050));
        this.m.add(Integer.valueOf(10074));
        this.m.add(Integer.valueOf(UCMPackageInfo.getLibFilter));
        this.m.add(Integer.valueOf(10075));
        this.m.add(Integer.valueOf(10076));
        this.m.add(Integer.valueOf(10081));
        this.m.add(Integer.valueOf(10082));
        this.m.add(Integer.valueOf(10091));
        this.m.add(Integer.valueOf(10092));
        this.m.add(Integer.valueOf(10093));
        this.m.add(Integer.valueOf(10094));
        this.m.add(Integer.valueOf(10095));
        this.m.add(Integer.valueOf(10096));
        this.m.add(Integer.valueOf(10097));
        this.h.a(f.class, new n(this));
        this.h.a((int) UCMPackageInfo.expectDirFile1F, m.class, f.class);
        this.h.a((int) UCMPackageInfo.getLibFilter, f.class);
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.e.o = bundle.getString(IProxyHandler.KEY_PAGE_URL);
            this.e.q = bundle.getString(GuideDialog.TITLE);
            this.e.p = bundle.getString(IProxyHandler.KEY_VIDEO_URL);
            if (this.d != null) {
                r rVar = this.d;
                if (rVar.c != null) {
                    p pVar = rVar.c;
                    if (pVar.c != null) {
                        au auVar = pVar.c;
                        if (!(auVar.r == null || auVar.r.f() == null || com.ucpro.feature.video.b.e.b(auVar.r.f().o))) {
                            auVar.d.setVisibility(8);
                        }
                    }
                }
                if (rVar.d != null) {
                    o oVar = rVar.d;
                    if (oVar.c != null) {
                        com.ucpro.feature.video.player.view.k kVar = oVar.c;
                        if (kVar.r != null && kVar.r.f() != null && !com.ucpro.feature.video.b.e.b(kVar.r.f().o)) {
                            kVar.c.setVisibility(8);
                        }
                    }
                }
            }
        }
    }

    @DebugLog
    public final void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public final int c() {
        if (this.c != null) {
            return this.c.c();
        }
        return -1;
    }

    public final int d() {
        if (this.c != null) {
            return this.c.d();
        }
        return 0;
    }

    private void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    public final void a(String str, Map<String, String> map) {
        if (this.c != null) {
            this.c.a(str, (Map) map);
            a(str);
        }
    }

    private f l() {
        return (f) this.h.a(f.class);
    }

    public final VideoView e() {
        return this.c == null ? null : (VideoView) this.c.m();
    }

    public final boolean b(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        if (this.e.r) {
            return false;
        }
        switch (i) {
            case 1:
                a();
                return true;
            case 2:
                b();
                return true;
            case 3:
                if (bVar != null) {
                    c.a(bVar.a(10));
                    int intValue = ((Integer) bVar.a(10)).intValue();
                    this.e.a(intValue);
                    a(intValue);
                    a();
                    return true;
                }
                break;
            case 4:
                a(UCAsyncTask.inThread, null, null);
                if (this.c != null) {
                    this.c.h();
                }
                a(UCAsyncTask.getPercent, null, null);
                return true;
            case 5:
                if (this.c != null) {
                    this.c.i();
                }
                a(UCAsyncTask.isPaused, null, null);
                return true;
            case 6:
                a(UCMPackageInfo.getKernelResFiles, null, null);
                return true;
            case 7:
                a(UCMPackageInfo.sortByLastModified, null, null);
                return true;
            case 8:
                a(UCMPackageInfo.expectCreateDirFile2P, bVar, bVar2);
                return true;
            case 10:
            case 12:
                this.d.b(i, bVar, bVar2);
                return true;
            case 11:
                a(UCMPackageInfo.getKernalShareJarCpyRoot, bVar, bVar2);
                return true;
            case 13:
                a(10053, null, null);
                return true;
            case 14:
                a(10054, null, null);
                return true;
            case 15:
                a(10075, bVar, bVar2);
                return true;
            case 16:
                a(10076, bVar, bVar2);
                return true;
            case 17:
                if (l() == f.FullScreen) {
                    a(10096, bVar, bVar2);
                    o();
                    return true;
                }
                break;
            case 18:
                if (l() == f.FullScreen) {
                    a(10097, bVar, bVar2);
                    o();
                    return true;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        boolean z = true;
        if (this.e.r) {
            return false;
        }
        boolean z2;
        switch (i) {
            case 10000:
            case 10006:
            case UCAsyncTask.isPaused /*10018*/:
            case 10019:
            case 10021:
            case 10062:
            case 10063:
            case 10064:
            case 10099:
                this.e.y = false;
                h();
                break;
            case 10001:
            case 10004:
            case 10005:
            case 10007:
            case 10009:
            case 10010:
            case UCAsyncTask.getPercent /*10017*/:
            case SDKFactory.getCoreType /*10020*/:
            case UCMPackageInfo.getKernelFileIfMultiCoreFromDir /*10028*/:
            case 10029:
            case 10069:
                h();
                break;
        }
        switch (i) {
            case 10001:
            case 10006:
            case 10021:
                Object a = com.ucpro.feature.video.player.a.b.a();
                a(10093, bVar, a);
                c.a(a);
                c.b(a.a(26) instanceof Boolean);
                if (((Boolean) a.a(26)).booleanValue()) {
                    z = false;
                }
                z2 = z;
                break;
            case 10003:
                boolean booleanValue = ((Boolean) com.ucpro.feature.video.player.a.b.a(bVar, 7, Boolean.valueOf(true))).booleanValue();
                float floatValue = ((Float) com.ucpro.feature.video.player.a.b.a(bVar, 8, Integer.valueOf(0))).floatValue();
                this.e.j = booleanValue;
                e eVar = this.e;
                if (eVar.i && eVar.g > 0) {
                    eVar.h = (int) (floatValue * ((float) eVar.g));
                    eVar.c(true);
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
                break;
            case 10004:
                this.e.b(true);
                z2 = true;
                break;
            case 10005:
                this.e.b(false);
                a(this.e.h);
                z2 = true;
                break;
            case 10009:
                i();
                this.e.a(false);
                break;
            case 10010:
                n();
                break;
            case 10011:
                n();
                break;
            case 10012:
                a(10095, bVar, bVar2);
                this.e.g = c();
                e eVar2 = this.e;
                if (this.c == null || !this.c.f()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                eVar2.l = z2;
                eVar2 = this.e;
                if (this.c == null || !this.c.g()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                eVar2.k = z2;
                e eVar3 = this.e;
                eVar3.b = true;
                eVar3.f = false;
                eVar3.c = false;
                eVar3.r = false;
                eVar3.b();
                eVar3.a();
                int i2 = this.e.z;
                if (i2 > 0) {
                    a(i2);
                    this.e.z = 0;
                }
                a(10075, bVar, bVar2);
                z2 = true;
                break;
            case UCMPackageInfo.getKernelFileIfMultiCoreFromDir /*10028*/:
            case 10029:
                if (this.e.y) {
                    this.e.y = false;
                } else {
                    this.e.y = true;
                }
                z2 = false;
                break;
            case UCMPackageInfo.expectDirFile1F /*10032*/:
                a(10094, bVar, bVar2);
                break;
            case 10064:
                this.e.v = true;
                break;
            case 10069:
                this.e.v = false;
                break;
            case 10073:
            case 10081:
                this.e.y = false;
                break;
            case 10098:
            case 10100:
                this.e.y = true;
                break;
        }
        z2 = false;
        if (!z2) {
            z2 = this.h.a(i, bVar, bVar2);
        }
        if (this.m.contains(Integer.valueOf(i))) {
            this.b.a(i, bVar, bVar2);
        }
        switch (i) {
            case 10012:
                com.ucpro.feature.video.g.a.a(this.e);
                break;
            case UCAsyncTask.getPriority /*10013*/:
                com.ucpro.feature.video.g.a.b(this.e);
                break;
        }
        return z2;
    }

    public final e f() {
        return this.e;
    }

    public final d g() {
        return this.h;
    }

    private e m() {
        if (this.i == null) {
            this.i = new e("MediaPlayer", Looper.getMainLooper());
        }
        return this.i;
    }

    final void h() {
        m().removeCallbacks(this.j);
        m().postDelayed(this.j, 5000);
    }

    final void i() {
        m().removeCallbacks(this.k);
        m().postDelayed(this.k, 250);
    }

    private void n() {
        m().removeCallbacks(this.k);
    }

    final void a(String str) {
        com.ucpro.feature.video.player.a.b a = com.ucpro.feature.video.player.a.b.a();
        a.a(18, str);
        a(10082, a, null);
    }

    public final boolean k() {
        return this.h.a(f.class) == f.FullScreen;
    }

    private void o() {
        boolean z;
        if (!k() || this.h.a(s.class) == s.HoverOn) {
            z = true;
        } else {
            z = false;
        }
        Activity activity;
        if (z) {
            if (!this.o) {
                activity = (Activity) this.a;
                if (!com.ucweb.common.util.d.d.a()) {
                    com.ucweb.common.util.d.e.b(activity);
                }
                this.o = true;
            }
        } else if (this.o) {
            activity = (Activity) this.a;
            if (!com.ucweb.common.util.d.d.a()) {
                com.ucweb.common.util.d.e.a(activity);
            }
            this.o = false;
        }
    }

    public final void j() {
        m().removeCallbacks(this.j);
        m().removeCallbacks(this.k);
        this.i = null;
        e eVar = this.e;
        eVar.s.clear();
        eVar.t.clear();
        eVar.t.clear();
        k kVar = (k) this.h;
        if (kVar.a != null) {
            for (Entry value : kVar.a.entrySet()) {
                ((List) value.getValue()).clear();
            }
            kVar.a.clear();
        }
        this.e.r = true;
    }
}
