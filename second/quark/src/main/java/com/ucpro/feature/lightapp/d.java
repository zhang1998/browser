package com.ucpro.feature.lightapp;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.base.jssdk.u;
import com.ucpro.base.c.a.a;
import com.ucpro.base.c.b.w;
import com.ucpro.base.e.e;
import com.ucpro.business.e.d.g;
import com.ucpro.feature.lightapp.b.f;
import com.ucpro.feature.lightapp.channelpage.ChannelPagePresenter;
import com.ucpro.feature.lightapp.channelpage.i;
import com.ucpro.feature.lightapp.channelpage.j;
import com.ucpro.feature.lightapp.d.a.c;
import com.ucpro.feature.lightapp.d.b.b;
import com.ucweb.common.util.h.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class d extends e implements a, com.ucpro.business.e.d.e, l {
    private Map<Integer, ChannelPagePresenter> c;
    private Map<Integer, com.ucpro.base.c.b.a> d;
    private Map<Integer, com.ucpro.feature.lightapp.c.a> e;
    private b f;
    private c g;
    private j h;
    private com.ucpro.base.weex.c i;

    protected final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
        this.f = new b(this.b);
        m.a(0, new k(this));
        this.g = new c(this.b);
        this.h = new j();
        g.a().a("lightapp_fetch_timeout", (com.ucpro.business.e.d.e) this);
        g.a().a("light_app_image_params_small", (com.ucpro.business.e.d.e) this);
        g.a().a("light_app_image_params_big ", (com.ucpro.business.e.d.e) this);
        t_().a((a) this);
        this.i = new com.ucpro.base.weex.c();
        com.ucpro.base.c.b.m s_ = s_();
        c cVar = this.g;
        f.a.a = s_;
        f.a.b = cVar;
        u.a.a(new String[]{"lightapp.getCachedCategoryInfo", "lightapp.updateCachedCategoryInfo", "lightapp.updateCachedArticleList", "lightapp.getCachedArticleList"}, new com.ucpro.feature.lightapp.b.b());
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.bH) {
            if (com.ucpro.feature.lightapp.d.a.b((String) message.obj)) {
                com.ucpro.feature.lightapp.d.b a = com.ucpro.feature.lightapp.d.a.a((String) message.obj);
                a(a, new h(this, s_().b().getID(), a));
                return;
            }
            a(com.ucpro.feature.lightapp.d.b.c((String) message.obj), null);
        } else if (i == com.ucpro.base.a.e.bI) {
            r0 = s_().b().getID();
            if (this.c.containsKey(Integer.valueOf(r0)) && this.c.get(Integer.valueOf(r0)) != null) {
                r0 = (ChannelPagePresenter) this.c.get(Integer.valueOf(r0));
                if (r0.a != null && r0.a.h()) {
                    r0.a.i();
                }
            }
        } else if (i == com.ucpro.base.a.e.bJ) {
            r0 = s_().b().getID();
            if (this.c.containsKey(Integer.valueOf(r0)) && this.c.get(Integer.valueOf(r0)) != null) {
                r0 = (ChannelPagePresenter) this.c.get(Integer.valueOf(r0));
                if (r0.a != null && r0.a.h()) {
                    r1 = r0.a;
                    if (!TextUtils.isEmpty(r1.d)) {
                        String a2 = com.ucpro.feature.d.a.b.a(com.ucpro.services.c.f.a.a.a(com.ucweb.common.util.d.a(), r1.d));
                        com.ucweb.c.b.a aVar = new com.ucweb.c.b.a();
                        aVar.a = r1.d;
                        if (TextUtils.isEmpty(r1.h)) {
                            r0 = r1.j;
                        } else {
                            r0 = r1.h;
                        }
                        aVar.b = r0;
                        if (r1.i != null) {
                            r0 = r1.i;
                        } else {
                            r0 = "";
                        }
                        aVar.c = r0;
                        aVar.e = a2;
                        aVar.f = a2;
                        aVar.d = com.ucweb.c.a.c.c;
                        com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bC, aVar.a());
                    }
                }
            }
        } else if (i == com.ucpro.base.a.e.bK) {
            r0 = s_().b().getID();
            if (this.c.containsKey(Integer.valueOf(r0)) && this.c.get(Integer.valueOf(r0)) != null) {
                r0 = (ChannelPagePresenter) this.c.get(Integer.valueOf(r0));
                if (r0.a != null && r0.a.h()) {
                    r1 = r0.a;
                    Object bundle = new Bundle();
                    String str = "TITLE";
                    r0 = (TextUtils.isEmpty(r1.h) || r1.h.equals(r1.j)) ? r1.i : r1.h;
                    bundle.putString(str, r0);
                    bundle.putString("URL", r1.k);
                    com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.aG, bundle);
                }
            }
        } else if (i == com.ucpro.base.a.e.bL) {
            r0 = s_().b().getID();
            if (this.c.containsKey(Integer.valueOf(r0)) && this.c.get(Integer.valueOf(r0)) != null) {
                if (!TextUtils.isEmpty(((ChannelPagePresenter) this.c.get(Integer.valueOf(r0))).c())) {
                    com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.b, new Object[]{com.ucpro.feature.lightapp.d.b.c(((ChannelPagePresenter) this.c.get(Integer.valueOf(r0))).c()).b, ((ChannelPagePresenter) this.c.get(Integer.valueOf(r0))).c(), null, new i((ChannelPagePresenter) this.c.get(Integer.valueOf(r0)))});
                }
            }
        }
    }

    private void a(com.ucpro.feature.lightapp.d.b bVar, j jVar) {
        boolean z = true;
        int id = s_().b().getID();
        ChannelPagePresenter channelPagePresenter = (ChannelPagePresenter) this.c.get(Integer.valueOf(id));
        if (channelPagePresenter == null || !channelPagePresenter.h()) {
            com.ucpro.base.c.b.m aVar;
            boolean z2;
            com.ucpro.base.c.b.m mVar = (com.ucpro.base.c.b.a) this.d.get(Integer.valueOf(id));
            if (mVar == null) {
                aVar = new com.ucpro.base.c.b.a(this.b);
                aVar.a(com.ucpro.business.stat.b.a);
                com.ucpro.feature.lightapp.c.c bVar2 = new com.ucpro.feature.lightapp.c.b(this.b);
                com.ucpro.feature.lightapp.c.d dVar = new com.ucpro.feature.lightapp.c.d(bVar2, aVar);
                View view = (View) bVar2;
                w wVar = aVar.a;
                wVar.e.addView(view, new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.bottom_bar_height)));
                aVar.a.setPresenter(new g(s_(), aVar, this.i, this));
                this.d.put(Integer.valueOf(id), aVar);
                this.e.put(Integer.valueOf(id), dVar);
                d();
            } else {
                aVar = mVar;
            }
            ChannelPagePresenter channelPagePresenter2 = new ChannelPagePresenter(this.b, aVar, this.f, this.i);
            n eVar = new com.ucpro.feature.lightapp.channelpage.e(this.b);
            eVar.setPresenter(channelPagePresenter2);
            channelPagePresenter2.a(eVar);
            if (this.e.containsKey(Integer.valueOf(id))) {
                channelPagePresenter2.d = (com.ucpro.feature.lightapp.c.a) this.e.get(Integer.valueOf(id));
            }
            this.c.put(Integer.valueOf(id), channelPagePresenter2);
            j jVar2 = this.h;
            CharSequence charSequence = bVar.c;
            ValueCallback bVar3 = new b(this, aVar, id, bVar, jVar);
            if (TextUtils.isEmpty(charSequence)) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.ucweb.common.util.c.b(z2);
            if (jVar2.a().contains(charSequence)) {
                z = false;
            }
            bVar3.onReceiveValue(Boolean.valueOf(z));
        }
    }

    public final void b(int i, Message message) {
        com.ucpro.feature.lightapp.c.a aVar;
        if (com.ucpro.base.a.j.f == i) {
            for (Integer num : this.c.keySet()) {
                if (this.c.get(num) != null) {
                    ChannelPagePresenter channelPagePresenter = (ChannelPagePresenter) this.c.get(num);
                    if (channelPagePresenter.f != null) {
                        channelPagePresenter.f.l();
                    }
                }
            }
            for (Object obj : this.e.keySet()) {
                aVar = (com.ucpro.feature.lightapp.c.a) this.e.get(obj);
                if (aVar != null) {
                    aVar.a();
                }
            }
        } else if (com.ucpro.base.a.j.i == i) {
            boolean z = com.ucpro.feature.e.b.a.a;
            for (Object obj2 : this.e.keySet()) {
                aVar = (com.ucpro.feature.lightapp.c.a) this.e.get(obj2);
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }
    }

    public final void g() {
        g.a().d("usertoken");
        g.a().d("lightapp_fetch_timeout");
        g.a().d("light_app_image_params_small");
        g.a().d("light_app_image_params_big ");
        if (this.g != null) {
            c cVar = this.g;
            com.ucpro.feature.lightapp.d.a.i a = cVar.a();
            try {
                if (a.a != null) {
                    a.a.close();
                }
            } catch (Throwable th) {
                String[] strArr = new String[]{"error_msg", th.getMessage()};
                com.ucpro.business.stat.m.a("lightapp", "cache_db_operate_error", strArr);
            }
            cVar.a = null;
            this.g = null;
        }
    }

    public final void a(com.ucpro.business.e.d.j jVar, String str, String str2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1720715032:
                if (str.equals("lightapp_fetch_timeout")) {
                    obj = null;
                    break;
                }
                break;
            case 117686681:
                if (str.equals("light_app_image_params_small")) {
                    obj = 1;
                    break;
                }
                break;
            case 2081496142:
                if (str.equals("light_app_image_params_big ")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                com.ucweb.common.util.j.a.a(com.ucweb.common.util.d.a(), "E90E9F38934E1448", "E8741860F76EC2A2", Integer.valueOf(str2).intValue());
                return;
            case 1:
                com.ucweb.common.util.j.a.a(com.ucweb.common.util.d.a(), "E90E9F38934E1448", "8CEDE4C0E847CFEF", str2);
                return;
            case 2:
                com.ucweb.common.util.j.a.a(com.ucweb.common.util.d.a(), "E90E9F38934E1448", "D9C439262A4E1828", str2);
                return;
            default:
                return;
        }
    }

    public final void a() {
        d();
    }

    public final void a(com.ucpro.base.c.b.g gVar) {
        d();
        if (gVar != null) {
            int id = gVar.getID();
            if (this.c.containsKey(Integer.valueOf(id))) {
                ((ChannelPagePresenter) this.c.get(Integer.valueOf(id))).a();
                this.c.remove(Integer.valueOf(id));
            }
            if (this.d.containsKey(Integer.valueOf(id))) {
                ((com.ucpro.base.c.b.a) this.d.get(Integer.valueOf(id))).g();
                this.d.remove(Integer.valueOf(id));
            }
        }
    }

    private void d() {
        int a = t_().a();
        for (Object obj : this.e.keySet()) {
            com.ucpro.feature.lightapp.c.a aVar = (com.ucpro.feature.lightapp.c.a) this.e.get(obj);
            if (aVar != null) {
                aVar.a(a);
            }
        }
    }

    public final void b(com.ucpro.base.c.b.g gVar) {
        if (gVar != null) {
            int id = gVar.getID();
            if (this.c.containsKey(Integer.valueOf(id))) {
                ((ChannelPagePresenter) this.c.get(Integer.valueOf(id))).a();
                this.c.remove(Integer.valueOf(id));
            }
            if (this.d.containsKey(Integer.valueOf(id))) {
                ((com.ucpro.base.c.b.a) this.d.get(Integer.valueOf(id))).g();
                this.d.remove(Integer.valueOf(id));
            }
        }
    }

    static /* synthetic */ void a(d dVar, com.ucpro.base.c.b.a aVar) {
        if (dVar.s_().a() != aVar.a) {
            dVar.s_().a(aVar.a, true);
        }
    }
}
