package com.ucpro.feature.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.feature.video.b.e;
import com.ucpro.feature.video.c.d;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.c.i;
import com.ucpro.services.networkstate.a;
import com.ucpro.services.networkstate.b;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class f implements ah, a {
    static boolean l = false;
    private static final List<String> m;
    t a = null;
    Context b = null;
    float c = 0.0f;
    d d = null;
    com.ucpro.feature.video.c.a e = null;
    com.ucpro.feature.video.c.a f = null;
    Map<String, ArrayList<String>> g = null;
    Map<String, String> h = null;
    int i = 0;
    int j = 1;
    List<Integer> k = new ArrayList();

    static {
        List arrayList = new ArrayList();
        m = arrayList;
        arrayList.add(".iqiyi.com");
    }

    public f(Context context) {
        this.b = context;
        this.j = ((Activity) this.b).getRequestedOrientation();
        this.k.add(Integer.valueOf(27));
        this.k.add(Integer.valueOf(32));
        this.k.add(Integer.valueOf(45));
        this.d = new i(this);
        this.e = new j(this);
        this.f = new s(this);
        this.g = new HashMap();
        this.h = new HashMap();
        b.a.a(this);
    }

    public void a(t tVar) {
        c.a((Object) tVar);
        this.a = tVar;
        this.a.setPresenter(this);
    }

    public boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        boolean z = true;
        for (g gVar : ac.a().a) {
            if (gVar != null) {
                gVar.a(i, bVar, bVar2);
            }
        }
        String b;
        String str;
        Object a;
        switch (i) {
            case 10012:
                if (this.a == null) {
                    return false;
                }
                f();
                a(2);
                if (e.c(this.a.b())) {
                    this.a.l();
                }
                com.ucpro.feature.video.g.a.a(this.a.c(), this.a.b(), this.a.p(), hashCode());
                return false;
            case UCAsyncTask.getPriority /*10013*/:
                if (this.a == null) {
                    return false;
                }
                c.a((Object) bVar);
                c.a(bVar.a(12));
                com.ucpro.feature.video.g.a.b(this.a.c(), this.a.b(), ((Integer) bVar.a(12)).intValue(), hashCode());
                return false;
            case UCAsyncTask.getTaskCount /*10014*/:
                if (this.a == null) {
                    return false;
                }
                b(this.a.k());
                com.ucpro.feature.video.g.a.b(this.a.c(), this.a.b(), hashCode());
                return false;
            case UCAsyncTask.inThread /*10016*/:
                this.j = ((Activity) this.b).getRequestedOrientation();
                return false;
            case UCAsyncTask.getPercent /*10017*/:
                this.c = ((Activity) this.b).getWindow().getAttributes().screenBrightness;
                Activity activity = (Activity) this.b;
                float a2 = com.ucpro.model.a.a.a.a("video_full_screen_brightness_key");
                if (0.0f <= a2) {
                    p.a(activity, a2);
                }
                f();
                com.ucpro.feature.video.g.a.a(this instanceof ax);
                return true;
            case UCAsyncTask.isPaused /*10018*/:
                if (0.0f != this.c) {
                    p.a((Activity) this.b, this.c);
                    this.c = 0.0f;
                }
                m.a(2, new ap(this));
                return false;
            case 10075:
                a(bVar);
                return false;
            case 10076:
                if (this.a == null) {
                    return false;
                }
                b = this.a.b();
                if (m == null || TextUtils.isEmpty(b)) {
                    z = false;
                } else {
                    for (String str2 : m) {
                        if (b.contains(str2)) {
                        }
                    }
                    z = false;
                }
                if (z) {
                    com.ucpro.feature.video.g.a.c(b);
                    com.ucpro.ui.b.e.a().a((int) R.string.video_forbiden_resolution_tip, 0);
                    return false;
                }
                a = bVar.a(6);
                c.b(a instanceof String);
                str2 = (String) a;
                if (str2.equals(this.a.d()) || TextUtils.isEmpty(b) || TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (this.h.containsKey(str2)) {
                    a(str2, (String) this.h.get(str2));
                    return false;
                }
                com.ucpro.feature.video.c.c.a();
                com.ucpro.feature.video.c.c.a(b, str2, this.e);
                com.ucpro.feature.video.g.a.a(b, str2);
                return false;
            case 10081:
                if (this.a == null) {
                    return false;
                }
                b = this.a.b();
                String c = this.a.c();
                String e = this.a.e();
                a = bVar.a(6);
                c.b(a instanceof String);
                str2 = (String) a;
                if (this.i != 2) {
                    a(c, e, b, str2);
                    return false;
                } else if (this.h.containsKey(str2)) {
                    a((String) this.h.get(str2), e, b, str2);
                    return false;
                } else {
                    com.ucpro.feature.video.c.c.a();
                    com.ucpro.feature.video.c.c.a(b, str2, this.f);
                    return false;
                }
            case 10082:
                if (this.a == null) {
                    return false;
                }
                com.ucpro.feature.video.g.a.a(this.a.c(), this.a.b(), hashCode());
                return false;
            case 10091:
                a(true);
                return false;
            case 10092:
                a(false);
                return false;
            case 10093:
                boolean a3 = a(1);
                c.a((Object) bVar2);
                bVar2.a(26, Boolean.valueOf(a3));
                return false;
            case 10095:
                if (this.a != null) {
                    int i2;
                    com.ucpro.feature.video.a.b bVar3 = new com.ucpro.feature.video.a.b();
                    if ((this instanceof ao) && ((ao) this).n == 2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    bVar3.b = i2;
                    bVar3.c = this.a.b();
                    bVar3.d = this.a.c();
                    bVar3.e = this.a.e();
                    bVar3.g = (long) this.a.p();
                    com.ucpro.feature.video.a.b a4 = com.ucpro.feature.video.a.a.a().a(bVar3);
                    if (a4 != null) {
                        this.a.a(a4.f);
                    }
                }
                m.a(0, i.c);
                return false;
            default:
                return false;
        }
    }

    public final void a(com.ucpro.feature.video.player.a.b bVar) {
        if (this.a != null) {
            String b = this.a.b();
            if (!TextUtils.isEmpty(b)) {
                if (this.g.containsKey(b)) {
                    if (bVar == null) {
                        bVar = com.ucpro.feature.video.player.a.b.a();
                    }
                    bVar.a(16, this.g.get(b));
                    this.a.a(10072, bVar, null);
                    return;
                }
                com.ucpro.feature.video.c.c.a();
                com.ucpro.feature.video.c.c.a(b, this.d);
                com.ucpro.feature.video.g.a.a(b);
            }
        }
    }

    private void a(String str, String str2) {
        if (this.a != null) {
            this.a.m();
            com.ucpro.feature.video.player.a.b a = com.ucpro.feature.video.player.a.b.a();
            a.a(18, str2);
            a.a(19, this.a.e());
            a.a(20, this.a.b());
            a.a(22, str);
            a.a(21, this.g.get(this.a.b()));
            this.a.a(10074, a, null);
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        if (this.a == null || this.a.p() >= 50000 || this.i == 2 || !str4.equals("normal")) {
            b(str, str2, str3, str4);
            return;
        }
        com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(this.b);
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.video_cache_ad_warning));
        mVar.a(1);
        mVar.a(new x(this, str, str2, str3, str4));
        mVar.show();
    }

    private void f() {
        if (this.a != null) {
            int g = this.a.g();
            int h = this.a.h();
            if (this.a.f() && h > g) {
                b();
            }
        }
    }

    public final void a() {
        int i = 6;
        switch (((Activity) this.b).getRequestedOrientation()) {
            case 0:
                i = 1;
                break;
            case 1:
            case 7:
            case 9:
                break;
            case 6:
                i = 7;
                break;
            case 8:
                i = 9;
                break;
            default:
                i = 1;
                break;
        }
        ((Activity) this.b).setRequestedOrientation(i);
        d();
    }

    public final void b() {
        ((Activity) this.b).setRequestedOrientation(7);
        d();
    }

    final void d() {
        if (this.a != null) {
            this.a.i();
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.o();
            b.a.b(this);
        }
    }

    public final void p_() {
        a(0);
    }

    boolean a(int i) {
        if (this.a == null || com.ucweb.common.util.i.c.b() || ((i != 0 || !this.a.n()) && ((i != 1 || this.a.n()) && i != 2))) {
            return true;
        }
        this.a.m();
        if (l) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_mobile_network_playing_tip), 0);
            m.a(2, new q(this));
            return false;
        }
        com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(this.b);
        mVar.a(1);
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.video_mobile_network_playing_warn));
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.video_mobile_network_playing_yes), com.ucpro.ui.c.a.d((int) R.string.video_mobile_network_playing_no));
        mVar.a(new o(this));
        mVar.show();
        return false;
    }

    private void a(boolean z) {
        if (this.a == null) {
            return;
        }
        if (!com.ucpro.feature.video.b.b.a(this.b)) {
            com.ucpro.feature.video.b.b.b(this.b);
        } else if (this.a.j()) {
            if (this.a.f()) {
                this.a.a(UCMPackageInfo.getLibFilter, null, null);
            }
            com.ucpro.feature.video.player.a.b a = com.ucpro.feature.video.player.a.b.a();
            a.a(18, this.a.c());
            a.a(19, this.a.e());
            a.a(20, this.a.b());
            a.a(22, this.a.d());
            a.a(21, this.g.get(this.a.b()));
            a.a(24, Integer.valueOf(this.a.q()));
            h.a(this.a.b(), a);
            if (z) {
                com.ucpro.feature.video.g.a.b(z);
            }
        }
    }

    final void b(int i) {
        if (this.a.p() > 180000 && i > 10000) {
            int i2;
            com.ucpro.feature.video.a.b bVar = new com.ucpro.feature.video.a.b();
            if ((this instanceof ao) && ((ao) this).n == 2) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            bVar.b = i2;
            bVar.c = this.a.b();
            bVar.d = this.a.c();
            bVar.e = this.a.e();
            bVar.f = i;
            bVar.g = (long) this.a.p();
            bVar.i = this.a.d();
            bVar.h = System.currentTimeMillis();
            m.a(0, new com.ucpro.feature.video.a.e(com.ucpro.feature.video.a.a.a(), bVar));
        }
    }

    private void b(String str, String str2, String str3, String str4) {
        String a = p.a(str4, false);
        if (TextUtils.isEmpty(str4)) {
            String str5 = str2;
        } else {
            Object obj = str2 + "[" + a + "]";
        }
        if (!com.ucweb.common.util.i.c.b()) {
            com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(this.b);
            mVar.a(com.ucpro.ui.c.a.d((int) R.string.video_mobile_network_cache_warn));
            mVar.a(1);
            mVar.a(new m(this, str, obj, str3, a));
            mVar.show();
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(obj)) {
            com.ucpro.feature.video.cache.a.a(str, obj, str3, a);
        }
    }
}
