package com.uc.weex.h;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.bridge.h;
import com.taobao.weex.bridge.q;
import com.taobao.weex.bridge.s;
import com.taobao.weex.e;
import com.taobao.weex.g;
import com.uc.weex.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class o implements e, g {
    private List<e> a = new ArrayList();
    protected ac b;
    protected d c;
    protected k d;
    protected Context e;
    protected s f;
    protected f g;
    protected boolean h;
    private List<Runnable> i = new ArrayList();
    private boolean j;

    public abstract void a(String str);

    public abstract void c();

    public o(Context context) {
        this.e = context;
        this.b = a(context);
        this.f = new s(context, this);
        this.c = new d(context);
        d dVar = this.c;
        if (dVar.a != null) {
            try {
                dVar.a.getClass().getDeclaredMethod("onCreate", new Class[0]).invoke(dVar.a, new Object[0]);
            } catch (Exception e) {
            }
        }
        dVar = this.c;
        if (dVar.a != null) {
            try {
                dVar.a.getClass().getDeclaredMethod("onStart", new Class[0]).invoke(dVar.a, new Object[0]);
            } catch (Exception e2) {
            }
        }
    }

    final void a(k kVar) {
        this.d = kVar;
        if (this.d.h != null) {
            this.a.add(kVar.h);
        }
    }

    final void a(e eVar) {
        this.a.add(eVar);
    }

    protected final void e() {
        this.b.m();
        this.b = a(this.e);
    }

    private ac a(Context context) {
        ac acVar = new ac(context);
        acVar.b = this;
        acVar.c = this;
        return acVar;
    }

    public final void a(f fVar) {
        this.g = fVar;
    }

    public void d() {
        if (!this.j) {
            this.j = true;
            this.g = null;
            if (!this.b.i) {
                this.b.g();
            }
            if (this.c != null) {
                d dVar = this.c;
                if (dVar.a != null) {
                    try {
                        dVar.a.getClass().getDeclaredMethod("onDestroy", new Class[0]).invoke(dVar.a, new Object[0]);
                    } catch (Exception e) {
                    }
                }
            }
            for (e a : this.a) {
                a.a(this);
            }
            this.a.clear();
            s sVar = ad.a().b;
            sVar.a(new q(sVar));
        }
    }

    public final void a(String str, Map<String, Object> map) {
        if (!this.b.i) {
            if (this.b.g == null) {
                this.i.add(new m(this, str, map));
            } else {
                this.b.a(str, (Map) map);
            }
        }
    }

    @Deprecated
    public final void b(String str, String str2) {
        if (!this.b.i) {
            if (this.b.g == null) {
                this.i.add(new n(this, str, str2));
                return;
            }
            ac acVar = this.b;
            List<String> list = (List) acVar.z.get(str);
            if (list != null) {
                for (String a : list) {
                    s.a().a(acVar.e, a, (Object) str2, true);
                }
            }
        }
    }

    public final String f() {
        return this.b.e;
    }

    public final void a(ac acVar, View view) {
        View view2 = null;
        if (this.c != null) {
            view2 = this.c.a(acVar, view);
        }
        if (view2 != null) {
            view = view2;
        }
        if (!(this.i == null || this.i.isEmpty())) {
            for (Runnable run : this.i) {
                run.run();
            }
        }
        this.f.removeAllViews();
        this.f.addView(view);
        this.h = true;
    }

    public void a(String str, String str2) {
    }

    public void a(ac acVar, String str, String str2) {
        if (this.c != null) {
            d dVar = this.c;
            if (dVar.a == null) {
                return;
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                try {
                    dVar.a.getClass().getDeclaredMethod("onException", new Class[]{ac.class, String.class, String.class}).invoke(dVar.a, new Object[]{acVar, str, str2});
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.c != null) {
            d dVar = this.c;
            if (dVar.a == null) {
                return;
            }
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                try {
                    dVar.a.getClass().getDeclaredMethod("onException", new Class[]{ac.class, String.class, String.class}).invoke(dVar.a, new Object[]{ad.a().b(str), str2, str3});
                } catch (Exception e) {
                }
            }
        }
    }

    public final void a(ac acVar) {
        if (this.c != null) {
            d dVar = this.c;
            if (dVar.a != null && acVar != null) {
                try {
                    dVar.a.getClass().getDeclaredMethod("onWeexRenderSuccess", new Class[]{ac.class}).invoke(dVar.a, new Object[]{acVar});
                } catch (Exception e) {
                }
            }
        }
    }

    public final View g() {
        return this.f;
    }

    public final ac h() {
        return this.b;
    }

    public final boolean b(String str, String str2, String str3) {
        if (this.b.i || this.g == null) {
            return false;
        }
        return this.g.a(str, str2, new h(this.b.e, str3));
    }

    public final void i() {
        if (!this.b.i && this.g != null) {
            this.g.a();
        }
    }

    public void i_() {
    }

    public void b() {
    }
}
