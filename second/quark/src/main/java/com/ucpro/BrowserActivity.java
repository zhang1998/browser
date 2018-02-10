package com.ucpro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.x;
import com.ucpro.a.am;
import com.ucpro.b.d.a.b;
import com.ucpro.base.a.j;
import com.ucpro.business.a.b.d;
import com.ucpro.business.a.c;
import com.ucpro.business.b.a;
import com.ucpro.business.stat.o;
import com.ucpro.business.stat.p;
import com.ucpro.business.stat.r;
import com.ucpro.d.e;
import com.ucpro.e.k;
import com.ucpro.e.l;
import com.ucpro.feature.g.b.m;
import com.ucpro.feature.i.f;
import com.ucpro.feature.p.i;
import com.ucpro.feature.privacymode.n;
import com.ucpro.feature.webwindow.ax;
import com.ucpro.feature.webwindow.b.y;
import com.ucpro.feature.x.h;
import com.ucpro.feature.y.g;
import com.ucpro.feature.y.t;
import com.ucpro.feature.y.u;
import com.ucpro.ui.edittext.CustomEditText;
import hugo.weaving.DebugLog;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class BrowserActivity extends BaseActivity {
    private k a;

    @DebugLog
    protected void onCreate(Bundle bundle) {
        e.a("bac0");
        super.onCreate(bundle);
        e.a("bac1");
        a.c();
        e.a("bac2");
        b.a = true;
        this.a = new k(this);
        e.a("cmc");
        k kVar = this.a;
        b a = b.a();
        String string = a.a.getString("ver", "");
        String string2 = a.a.getString("sver", "");
        String string3 = a.a.getString("bseq", "");
        a.e = a.a.getString("orin_ver", "");
        a.f = a.a.getString("orin_sver", "");
        a.g = a.a.getString("orin_bseq", "");
        a.h = a.a.getString("last_ver", "");
        a.i = a.a.getString("last_sver", "");
        a.j = a.a.getString("last_bseq", "");
        if (string.equals("")) {
            a.k = 1;
            a.e = a.b;
            a.f = a.c;
            a.g = a.d;
        } else {
            int i;
            String str = a.b;
            if ((str == null && string == null) || (com.ucweb.common.util.n.a.a(str) && com.ucweb.common.util.n.a.a(string))) {
                i = 0;
            } else if (string == null || com.ucweb.common.util.n.a.a(string)) {
                i = 1;
            } else if (str == null || com.ucweb.common.util.n.a.a(str)) {
                i = -1;
            } else {
                String[] a2 = com.ucweb.common.util.n.a.a(str, ".");
                String[] a3 = com.ucweb.common.util.n.a.a(string, ".");
                int min = Math.min(a2.length, a3.length);
                for (i = 0; i < min; i++) {
                    int a4 = com.ucweb.common.util.n.a.a(a2[i], 0);
                    int a5 = com.ucweb.common.util.n.a.a(a3[i], 0);
                    if (a4 != a5) {
                        i = a4 - a5;
                        break;
                    }
                }
                i = a2.length - a3.length;
            }
            if (i != 0) {
                a.k = i > 0 ? 2 : 3;
                a.h = string;
                a.i = string2;
                a.j = string3;
            } else if (a.d.equalsIgnoreCase(string3)) {
                a.k = 0;
            } else {
                a.h = string;
                a.i = string2;
                a.j = string3;
                a.k = 4;
            }
        }
        e.a("ivm");
        Activity activity = kVar.a;
        f.a.a(activity);
        activity.setRequestedOrientation(1);
        e.a("ca");
        kVar.f = new com.ucpro.base.c.a(kVar.a);
        kVar.f.b().a(com.ucpro.business.stat.b.a);
        kVar.f.b().a(f.a.e);
        kVar.d = new com.ucpro.base.e.b(kVar.f);
        kVar.e = new com.ucpro.base.e.f(kVar.d);
        com.ucpro.base.e.f fVar = kVar.e;
        fVar.a.a(new int[]{com.ucpro.base.a.e.g, com.ucpro.base.a.e.h, com.ucpro.base.a.e.i, com.ucpro.base.a.e.j}, null, i.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.I, com.ucpro.base.a.e.K, com.ucpro.base.a.e.L}, new int[]{j.f}, g.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.a, com.ucpro.base.a.e.b, com.ucpro.base.a.e.c, com.ucpro.base.a.e.d, com.ucpro.base.a.e.e}, new int[]{j.f, j.q}, com.ucpro.feature.navigation.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.k, com.ucpro.base.a.e.n, com.ucpro.base.a.e.o, com.ucpro.base.a.e.p, com.ucpro.base.a.e.s, com.ucpro.base.a.e.t, com.ucpro.base.a.e.G, com.ucpro.base.a.e.H, com.ucpro.base.a.e.P, com.ucpro.base.a.e.af, com.ucpro.base.a.e.Q, com.ucpro.base.a.e.R, com.ucpro.base.a.e.bB, com.ucpro.base.a.e.ch, com.ucpro.base.a.e.l, com.ucpro.base.a.e.cr, com.ucpro.base.a.e.q, com.ucpro.base.a.e.r, com.ucpro.base.a.e.f, com.ucpro.base.a.e.dd}, new int[]{j.f, j.h, j.i, j.q, j.y}, ax.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.J, com.ucpro.base.a.e.B, com.ucpro.base.a.e.C, com.ucpro.base.a.e.D, com.ucpro.base.a.e.E, com.ucpro.base.a.e.F}, new int[]{j.e, j.d, j.c, j.f}, com.ucpro.feature.t.k.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.T, com.ucpro.base.a.e.V, com.ucpro.base.a.e.U, com.ucpro.base.a.e.W, com.ucpro.base.a.e.X}, new int[]{j.g, j.f}, com.ucpro.feature.n.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.bz, com.ucpro.base.a.e.bA}, new int[]{j.r}, com.ucpro.feature.r.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.aj, com.ucpro.base.a.e.ak, com.ucpro.base.a.e.al, com.ucpro.base.a.e.am, com.ucpro.base.a.e.an, com.ucpro.base.a.e.ao, com.ucpro.base.a.e.ap, com.ucpro.base.a.e.aq, com.ucpro.base.a.e.ar, com.ucpro.base.a.e.as, com.ucpro.base.a.e.at}, new int[]{j.f}, com.ucpro.feature.z.h.i.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.au, com.ucpro.base.a.e.av, com.ucpro.base.a.e.aH, com.ucpro.base.a.e.aJ, com.ucpro.base.a.e.aI, com.ucpro.base.a.e.aK, com.ucpro.base.a.e.aL, com.ucpro.base.a.e.aM, com.ucpro.base.a.e.aN, com.ucpro.base.a.e.aO, com.ucpro.base.a.e.aP, com.ucpro.base.a.e.aQ, com.ucpro.base.a.e.aR, com.ucpro.base.a.e.aS, com.ucpro.base.a.e.aT, com.ucpro.base.a.e.aU, com.ucpro.base.a.e.aV, com.ucpro.base.a.e.ay, com.ucpro.base.a.e.az, com.ucpro.base.a.e.aA, com.ucpro.base.a.e.aB, com.ucpro.base.a.e.aC, com.ucpro.base.a.e.aD, com.ucpro.base.a.e.aE, com.ucpro.base.a.e.aF}, new int[]{j.f}, com.ucpro.feature.bookmarkhis.c.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.bn, com.ucpro.base.a.e.bo, com.ucpro.base.a.e.bp, com.ucpro.base.a.e.bq, com.ucpro.base.a.e.br, com.ucpro.base.a.e.bs, com.ucpro.base.a.e.bt, com.ucpro.base.a.e.bu, com.ucpro.base.a.e.bv}, new int[]{j.p, j.o}, com.ucpro.feature.video.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.aW, com.ucpro.base.a.e.aX, com.ucpro.base.a.e.aY, com.ucpro.base.a.e.aZ, com.ucpro.base.a.e.ba, com.ucpro.base.a.e.bb, com.ucpro.base.a.e.be, com.ucpro.base.a.e.bf, com.ucpro.base.a.e.bg, com.ucpro.base.a.e.bh, com.ucpro.base.a.e.bi, com.ucpro.base.a.e.bj, com.ucpro.base.a.e.bk}, new int[]{j.f, j.r}, com.ucpro.feature.setting.d.k.class);
        fVar.a.a(null, new int[]{j.g, j.i, j.k, j.l, j.m, j.b, j.p, j.o, j.n, j.s, j.r, j.t, j.u}, am.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.bD, com.ucpro.base.a.e.bE, com.ucpro.base.a.e.bF, com.ucpro.base.a.e.bG}, null, com.ucpro.feature.ab.e.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.bR, com.ucpro.base.a.e.bS}, new int[]{j.v, j.w}, m.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.bT, com.ucpro.base.a.e.bU}, null, com.ucpro.feature.g.c.j.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.bV, com.ucpro.base.a.e.bW, com.ucpro.base.a.e.bX, com.ucpro.base.a.e.bY, com.ucpro.base.a.e.bZ, com.ucpro.base.a.e.ca, com.ucpro.base.a.e.cb}, new int[]{j.v}, com.ucpro.feature.f.m.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.ci, com.ucpro.base.a.e.cj}, new int[]{j.r, j.f}, c.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.ck, com.ucpro.base.a.e.cl}, new int[]{j.q, j.f}, d.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.cn, com.ucpro.base.a.e.co, com.ucpro.base.a.e.cp, com.ucpro.base.a.e.cq}, null, y.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.cs}, new int[]{j.q}, com.ucpro.feature.w.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.M, com.ucpro.base.a.e.N, com.ucpro.base.a.e.O, com.ucpro.base.a.e.Y, com.ucpro.base.a.e.Z, com.ucpro.base.a.e.aa}, new int[]{j.f}, h.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.ct, com.ucpro.base.a.e.cw, com.ucpro.base.a.e.cu, com.ucpro.base.a.e.cv, com.ucpro.base.a.e.cx, com.ucpro.base.a.e.cy, com.ucpro.base.a.e.cz, com.ucpro.base.a.e.cA, com.ucpro.base.a.e.cB, com.ucpro.base.a.e.cF, com.ucpro.base.a.e.cG, com.ucpro.base.a.e.cH, com.ucpro.base.a.e.cI, com.ucpro.base.a.e.cJ, com.ucpro.base.a.e.cK, com.ucpro.base.a.e.cL, com.ucpro.base.a.e.cM, com.ucpro.base.a.e.cN, com.ucpro.base.a.e.cO}, null, n.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.cC, com.ucpro.base.a.e.cD, com.ucpro.base.a.e.cE}, null, com.ucpro.feature.bookmarkhis.b.e.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.cP, com.ucpro.base.a.e.cQ, com.ucpro.base.a.e.cR, com.ucpro.base.a.e.cS, com.ucpro.base.a.e.cT}, new int[]{j.f}, com.ucpro.feature.l.c.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.cU, com.ucpro.base.a.e.cV, com.ucpro.base.a.e.bv, com.ucpro.base.a.e.bw}, new int[]{j.r, j.f}, com.ucpro.feature.q.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.cY, com.ucpro.base.a.e.cZ, com.ucpro.base.a.e.db, com.ucpro.base.a.e.da}, new int[]{j.f}, com.ucpro.feature.v.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.dc}, new int[]{j.f}, com.ucpro.feature.j.f.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.de}, new int[]{j.f, j.v, j.w}, com.ucpro.feature.o.a.class);
        fVar.a.a(new int[]{com.ucpro.base.a.e.df, com.ucpro.base.a.e.dg}, null, com.ucpro.feature.downloadpage.dirselect.f.class);
        com.ucpro.base.a.d.a.a = new WeakReference(kVar.d);
        com.ucpro.base.a.h.a.a = new WeakReference(kVar.d);
        e.a("icc");
        com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.T);
        if (com.ucpro.ui.c.a.a()) {
            com.ucpro.business.stat.m.a("quark_lab", com.ucpro.feature.k.a.e, new String[0]);
        }
        e.a("at");
        com.ucpro.services.e.f a6 = com.ucpro.services.e.e.a;
        Context context = kVar.a;
        a6.b = new WeakReference(context);
        if (com.ucpro.services.e.f.a()) {
            a6.c = new com.ucpro.services.e.a(a6, context);
        }
        CustomEditText.setClipBoardCallback(new com.ucpro.e.i(kVar));
        com.ucpro.ui.b.e.b();
        com.ucpro.ui.b.e.a(kVar.a);
        kVar.f.b().a(kVar.a);
        kVar.c = new com.ucpro.e.h(kVar.a, kVar.f);
        Object obj = kVar.c;
        com.ucweb.common.util.c.a(obj);
        kVar.b.add(new WeakReference(obj));
        e.a("swe");
        f.a;
        com.ucpro.base.c.b.g.setStatusBarFactory(new com.ucpro.feature.i.b());
        e.a("csb");
        com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.I);
        e.a("ch");
        com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.G);
        e.a("cmw");
        if (b.a().b()) {
            try {
                View uVar = new u(kVar.a);
                kVar.f.b().a(uVar);
                uVar.a.a(new t(uVar, new l(kVar, uVar)));
                uVar.a.b();
            } catch (Exception e) {
            }
        }
        e.a("hup");
        if (kVar.a.getIntent() != null) {
            kVar.a(kVar.a.getIntent(), false);
            e.a("hni");
        }
        com.ucweb.common.util.h.m.a(0, new com.ucpro.business.stat.c());
        com.ucpro.business.stat.b.a.a = true;
        e.a("csa");
        com.ucweb.common.util.h.m.a(2, new com.ucpro.d.c(kVar.a));
        kVar.f.b().a().getViewTreeObserver().addOnPreDrawListener(kVar.k);
        e.a("hif");
        com.ucpro.d.f.a.a = new WeakReference(this);
        com.e.b.b.a();
        com.e.b.b.c();
    }

    @DebugLog
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.a.a(intent, true);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        k kVar = this.a;
        if (keyEvent.getAction() == 0) {
            kVar.i = true;
        }
        if (keyEvent.getAction() == 1 && !kVar.i) {
            return true;
        }
        boolean dispatchKeyEvent;
        if (kVar.f != null) {
            View e = kVar.f.b().e();
            if (e != null) {
                dispatchKeyEvent = e.dispatchKeyEvent(keyEvent);
            } else {
                dispatchKeyEvent = false;
            }
            if (!dispatchKeyEvent) {
                com.ucpro.base.c.b.g a = kVar.f.b().a();
                if (a != null) {
                    dispatchKeyEvent = a.dispatchKeyEvent(keyEvent);
                }
            }
            if (!dispatchKeyEvent) {
                com.ucpro.e.f a2 = com.ucpro.e.c.a;
                Activity activity = kVar.a;
                if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                    if (a2.a) {
                        if (System.currentTimeMillis() - a2.c <= 2500) {
                            com.ucpro.ui.b.e.a().d();
                            com.ucpro.business.stat.m.a("app", "exit_browser", "type", SettingsConst.FALSE);
                            com.ucpro.feature.m.h.a.a(1, a2);
                            activity.finish();
                            com.ucpro.c.f.c = true;
                            a2.a = false;
                        } else {
                            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.press_again_back_key_for_exit), 0);
                            a2.c = System.currentTimeMillis();
                            a2.a = true;
                        }
                        dispatchKeyEvent = true;
                    } else {
                        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.press_again_back_key_for_exit), 0);
                        a2.c = System.currentTimeMillis();
                        a2.a = true;
                        dispatchKeyEvent = true;
                    }
                }
            }
            if (keyEvent.getAction() == 1) {
                kVar.i = false;
            }
            return dispatchKeyEvent;
        }
        dispatchKeyEvent = false;
        if (keyEvent.getAction() == 1) {
            kVar.i = false;
        }
        return dispatchKeyEvent;
    }

    @DebugLog
    protected void onPause() {
        super.onPause();
        k kVar = this.a;
        com.ucpro.base.system.b.a.a(false);
        a.a(false);
        kVar.a(3);
        kVar.d.a(com.ucpro.base.e.g.PAUSE);
        com.ucpro.business.stat.j a = com.ucpro.business.stat.b.a;
        if (!(o.b == null || o.b.get() == null)) {
            o.a((com.ucpro.business.stat.a.d) o.b.get(), ((com.ucpro.business.stat.a.d) o.b.get()).getPageName());
        }
        a.a = false;
        x.a(2);
        com.ucweb.common.util.h.m.a(0, new p());
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        com.ucpro.base.a.f.a().a(j.b, i, null);
        ((com.ucpro.base.b.b) com.bumptech.glide.c.a((Activity) this)).a(i);
    }

    public void onLowMemory() {
        super.onLowMemory();
        ((com.ucpro.base.b.b) com.bumptech.glide.c.a((Activity) this)).d();
    }

    @DebugLog
    protected void onStart() {
        super.onStart();
        k kVar = this.a;
        com.ucpro.base.system.b.a.a(true);
        a.a(true);
        com.ucpro.base.a.f.a().a(j.a, 0, null);
        kVar.a(1);
        com.ucpro.services.e.f a = com.ucpro.services.e.e.a;
        if (a.c != null) {
            com.ucpro.services.e.a aVar = a.c;
            aVar.h = aVar.e.c();
        }
    }

    @DebugLog
    protected void onStop() {
        super.onStop();
        k kVar = this.a;
        com.ucpro.base.system.b.a.a(false);
        a.a(false);
        kVar.a(4);
        kVar.d.a(com.ucpro.base.e.g.STOP);
        com.ucpro.services.e.f a = com.ucpro.services.e.e.a;
        if (a.c != null) {
            com.ucpro.services.e.a aVar = a.c;
            aVar.a().postDelayed(aVar.j, 700);
            aVar.c = true;
        }
        com.ucweb.common.util.h.m.a(0, new com.ucpro.business.stat.l());
        com.ucpro.business.stat.m.b("app", "session");
        x.a(3);
        com.ucpro.business.e.a.a.a().a(false);
    }

    @DebugLog
    protected void onResume() {
        super.onResume();
        k kVar = this.a;
        com.ucpro.base.system.b.a.a(true);
        a.a(true);
        kVar.a(2);
        kVar.d.a(com.ucpro.base.e.g.RESUME);
        if (!(com.ucpro.business.stat.b.a.a || o.b == null || o.b.get() == null)) {
            o.a((com.ucpro.business.stat.a.d) o.b.get(), true);
        }
        com.ucpro.business.stat.m.a("app", "session");
        com.ucweb.common.util.h.m.a(0, new com.ucpro.business.stat.e());
    }

    @DebugLog
    protected void onDestroy() {
        com.ucpro.e.a aVar;
        super.onDestroy();
        k kVar = this.a;
        kVar.a(5);
        com.ucpro.ui.contextmenu.f a = com.ucpro.ui.contextmenu.f.a();
        a.a = null;
        a.b = null;
        com.ucpro.services.e.f a2 = com.ucpro.services.e.e.a;
        if (a2.c != null) {
            com.ucpro.services.e.a aVar2 = a2.c;
            if (aVar2.c) {
                aVar2.a().removeCallbacks(aVar2.j);
                aVar2.b();
            }
        }
        CustomEditText.setClipBoardCallback(null);
        com.ucpro.ui.b.e.b();
        com.ucpro.feature.i.k a3 = f.a;
        a3.a.clear();
        a3.d = -1;
        com.ucpro.feature.y.p.a.b = null;
        kVar.d.a(com.ucpro.base.e.g.EXIT);
        com.ucweb.common.util.h.m.c(kVar.l);
        if (kVar.h != null) {
            try {
                kVar.a.getApplicationContext().unregisterReceiver(kVar.h);
            } catch (Exception e) {
            }
            kVar.h = null;
        }
        com.ucpro.business.stat.b.a;
        o.b = null;
        x.a(4);
        x.a(1);
        com.ucweb.common.util.h.m.a(0, new r());
        a.a();
        com.ucpro.e.a aVar3 = com.ucpro.e.a.COMPLETE;
        com.ucpro.e.c.a;
        if (SettingsConst.TRUE.equals(com.ucpro.business.e.d.g.a().a("exit_mode", SettingsConst.FALSE))) {
            new StringBuilder("exit mode is: ").append(com.ucpro.e.a.COMPLETE.toString());
            aVar = com.ucpro.e.a.COMPLETE;
        } else {
            new StringBuilder("exit mode is: ").append(com.ucpro.e.a.NORMAL.toString());
            aVar = com.ucpro.e.a.NORMAL;
        }
        if (aVar3 == aVar) {
            com.ucweb.common.util.h.m.a(2, new com.ucpro.e.d(kVar), 100);
        }
    }

    @DebugLog
    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj = null;
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1 && intent != null) {
                try {
                    obj = new Uri[]{intent.getData()};
                } catch (Throwable e) {
                    Log.w("MainController", "warning:", e);
                    return;
                }
            }
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.bB, obj);
        } else if (i == 2) {
            if (intent != null) {
                obj = intent.getData();
            }
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.bG, obj);
        } else if (i == 3 && intent != null) {
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.N, intent.getData());
        }
    }

    @DebugLog
    public void onAttachedToWindow() {
        k kVar = this.a;
        if (kVar.g != null) {
            kVar.g.a();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.ucpro.ui.contextmenu.f.a().a((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
