package com.ucpro.feature.z.h;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.a.c;
import com.ucpro.business.stat.m;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.feature.y.v;
import com.ucpro.feature.z.b.b;
import com.ucpro.feature.z.c.a;
import com.ucpro.feature.z.d.l;
import com.ucpro.feature.z.e.n;
import com.ucpro.feature.z.h.a.j;
import com.ucpro.feature.z.h.a.k;
import com.ucweb.common.util.f;
import java.util.HashMap;

/* compiled from: ProGuard */
public class i extends e implements OnClickListener {
    private j c = null;
    private d d = null;
    private boolean e = false;
    private com.ucpro.feature.z.a.i f = null;
    private b g = null;
    private l h = null;
    private n i = null;
    private a j = null;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private com.ucweb.common.util.e q = new com.ucweb.common.util.e("SearchPageController", Looper.getMainLooper());
    private TextWatcher r = new b(this);
    private BroadcastReceiver s = new j(this);
    private Runnable t = new l(this);

    public final void a(int i, Message message) {
        boolean z = true;
        if (i == com.ucpro.base.a.e.aj) {
            if (message.obj instanceof h) {
                Object obj = message.obj;
            }
        } else if (i == com.ucpro.base.a.e.ak) {
            this.k = 1;
            e();
            m();
            d();
            this.c.setHomePage((v) message.obj);
            if (s_().a() instanceof bb) {
                this.c.setHomeToolBar(((bb) s_().a()).getHomeToolbar());
            }
            if (!this.n && !this.l) {
                g.a().b(com.ucpro.base.a.e.Q);
                this.c.setVisibility(0);
                j jVar = this.c;
                k fVar = new f(this);
                r0 = jVar.a;
                r0.b();
                r0.j = true;
                r0.setState(r0.m);
                r0.l.a(fVar);
                this.j.c();
                this.n = true;
                m.a("searchpage", "ent_fro_h", "type", "enter");
                if (s_().a() instanceof c) {
                    ((c) s_().a()).getCurUtPage();
                }
                m.a(this.c);
            }
        } else if (i == com.ucpro.base.a.e.al) {
            k();
        } else if (i == com.ucpro.base.a.e.am) {
            if (this.h.e()) {
                this.h.f();
            } else {
                k();
            }
        } else if (i == com.ucpro.base.a.e.an) {
            if (message.obj instanceof String) {
                r0 = (String) message.obj;
                if (TextUtils.isEmpty(r0.trim())) {
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_no_empty_warnning), 0);
                    return;
                }
                i();
                l();
                r2 = new aj();
                r2.s = aj.e;
                r2.p = r0;
                g.a().b(com.ucpro.base.a.e.k, r2);
                j();
                a(r0);
                a(r0, "", com.ucpro.feature.z.g.b.n.b.c(), 1);
            }
        } else if (i == com.ucpro.base.a.e.ao) {
            if (message.obj instanceof String) {
                i();
                l();
                r0 = (String) message.obj;
                Object ajVar = new aj();
                ajVar.o = r0;
                g.a().b(com.ucpro.base.a.e.k, ajVar);
                j();
                a(r0);
                a(r0, r0, com.ucpro.feature.z.g.b.n.b.c(), 2);
            }
        } else if (i == com.ucpro.base.a.e.ap) {
            if (message.obj instanceof String) {
                this.f.b((String) message.obj);
            }
        } else if (i == com.ucpro.base.a.e.aq) {
            this.k = 2;
            e();
            m();
            d();
            r0 = "";
            if (message.obj != null) {
                r0 = (String) message.obj;
            }
            if (!this.m && !this.o) {
                this.c.setVisibility(0);
                this.c.setAlpha(0.0f);
                j jVar2 = this.c;
                k mVar = new m(this, r0);
                r0 = jVar2.a;
                r0.b();
                r0.k = true;
                r0.setState(r0.n);
                r0.l.a(mVar);
                this.j.c();
                this.o = true;
                this.q.postDelayed(this.t, 3000);
                m.a("searchpage", "ent_fro_w", "type", "enter");
                if (s_().a() instanceof c) {
                    ((c) s_().a()).getCurUtPage();
                }
                m.a(this.c);
            }
        } else if (i == com.ucpro.base.a.e.ar) {
            if (((float) this.c.getSearchBarLocationBottom()) < ((float) this.c.getMeasuredHeight()) * 0.9f) {
                z = false;
            }
            if (!z) {
                f.a(this.b, this.c);
            } else if (this.h.e()) {
                this.h.f();
            } else {
                k();
            }
        } else if (i == com.ucpro.base.a.e.as) {
            this.c.setNeedInterceptPreIme(false);
            if (TextUtils.isEmpty(this.c.getSearchBar().getUrlEditText().getText().toString().trim())) {
                this.h.f();
                this.c.setNeedInterceptPreIme(!k());
            }
        } else if (i == com.ucpro.base.a.e.at && (message.obj instanceof String[])) {
            String[] strArr = (String[]) message.obj;
            Object obj2 = strArr[0];
            String str = strArr[1];
            r0 = strArr[2];
            if (!TextUtils.isEmpty(obj2) && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str.trim())) {
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_no_empty_warnning), 0);
                    return;
                }
                i();
                l();
                r2 = new aj();
                r2.s = aj.g;
                r2.o = obj2;
                r2.p = str;
                g.a().b(com.ucpro.base.a.e.k, r2);
                j();
                a(str, "", r0, 3);
            }
        }
    }

    public final void b(int i, Message message) {
        if (i == com.ucpro.base.a.j.f && this.c != null) {
            this.c.a();
        }
    }

    protected final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
        this.c = new j(this.b);
        this.d = new d(this);
        this.f = new com.ucpro.feature.z.a.i(this.c.getSearchBar());
        com.ucpro.feature.z.a.i iVar = this.f;
        iVar.a.getUrlEditText().a(this.r);
        this.g = new b(this.c.getInputEnhanceView());
        b bVar2 = this.g;
        Object urlEditText = this.c.getSearchBar().getUrlEditText();
        com.ucweb.common.util.c.a(urlEditText, "SearchInputEnhancePresenter parameter 'bindEditText' can not be null");
        bVar2.d = urlEditText;
        bVar2.d.a(new com.ucpro.feature.z.b.n(bVar2));
        this.h = new l(this.b, this.c.getInputHistoryView());
        this.i = new n(this.b, this.c.getAssociateView());
        this.i.d = this.d.b;
        this.j = new a(this.c.getCopyTipView());
        this.c.setOnClickListener(this);
    }

    private void d() {
        if (this.c != null && this.c.getParent() == null) {
            this.a.b().a(this.c);
        }
    }

    private void e() {
        if (!this.e) {
            this.e = true;
            this.b.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.d);
        }
    }

    private void i() {
        this.e = false;
        this.b.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.d);
    }

    private void j() {
        if (!this.m && !this.o) {
            this.c.a.c();
            com.ucweb.common.util.h.m.a(2, new g(this), 300);
            this.m = true;
            if (s_().a() instanceof c) {
                m.a(((c) s_().a()).getCurUtPage());
            }
        }
    }

    private boolean k() {
        if (this.k == 1) {
            if (this.l || this.n) {
                return false;
            }
            this.h.f();
            i();
            l();
            if (!(this.l || this.n)) {
                j jVar = this.c;
                k eVar = new e(this);
                com.ucpro.feature.z.h.a.e eVar2 = jVar.a;
                eVar2.setState(eVar2.m);
                eVar2.l.b(eVar);
                f.a(this.b, this.c);
                this.l = true;
                if (s_().a() instanceof c) {
                    m.a(((c) s_().a()).getCurUtPage());
                }
            }
        } else if (this.k == 2) {
            if (this.m || this.o) {
                return false;
            }
            this.h.f();
            i();
            l();
            j();
        }
        return true;
    }

    public void onClick(View view) {
        boolean z = true;
        if (view != this.c) {
            return;
        }
        if (this.h.e()) {
            this.h.f();
            return;
        }
        boolean z2;
        com.ucpro.feature.z.h.a.e eVar = this.c.a;
        if (eVar.c == null || !eVar.c.a.a) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            z = false;
        } else if (eVar.c != null) {
            eVar.c.a.setExpanded(false);
        }
        if (!z) {
            k();
        }
    }

    private static void a(String str, String str2, String str3, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("item_content", str);
        hashMap.put("item_host_name", com.ucweb.common.util.i.f.c(str2));
        hashMap.put("is_incognito", String.valueOf(com.ucpro.feature.e.b.a.a));
        hashMap.put("search_engine", str3);
        hashMap.put("type", String.valueOf(i));
        m.a("searchpage", "search_content", hashMap);
    }

    private void l() {
        if (this.p) {
            this.b.unregisterReceiver(this.s);
            this.p = false;
        }
    }

    private void m() {
        if (!this.p) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.b.registerReceiver(this.s, intentFilter);
            this.p = true;
        }
    }

    public final void g() {
        if (this.h != null) {
            l lVar = this.h;
            if (lVar.d != null) {
                com.ucpro.feature.z.f.a.c a = com.ucpro.feature.z.f.a.c.a();
                Object obj = lVar.d;
                com.ucweb.common.util.c.a(obj);
                if (a.a.contains(obj)) {
                    a.a.remove(obj);
                }
            }
            this.h = null;
        }
    }

    private static void a(String str) {
        if (!com.ucpro.feature.e.b.a.a) {
            com.ucpro.feature.z.f.a.c.a().a(str);
        }
    }
}
