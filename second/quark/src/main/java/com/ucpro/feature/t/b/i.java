package com.ucpro.feature.t.b;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.ucpro.base.a.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.t.d;
import com.ucpro.feature.t.g;
import com.ucpro.feature.t.n;
import com.ucpro.feature.t.p;
import com.ucpro.feature.t.q;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class i implements j, g {
    private s a = null;
    private p b = null;
    private n c = null;
    private Map<View, q> d = null;
    private List<Integer> e = new ArrayList();

    public i(s sVar) {
        this.a = sVar;
        this.a.setPresenter(this);
    }

    public final void a(p pVar) {
        this.b = pVar;
    }

    public final void a(n nVar) {
        this.c = nVar;
    }

    public final void a(View view, boolean z) {
        c.b(view instanceof k);
        if (this.c != null && this.d != null && this.d.containsKey(view)) {
            q qVar = (q) this.d.get(view);
            if (z) {
                ((k) view).setWebShotImage(this.c.a(qVar.c, false));
            } else {
                ((k) view).getWebShotBitmap();
            }
        }
    }

    public final void a(View view) {
        c.b(view instanceof k);
        com.ucpro.base.a.g.a().b(e.D, ((k) view).getIndex());
    }

    public final int a(int i) {
        if (i >= 0 && i < this.a.getChildCount()) {
            q qVar = (q) this.d.get((k) this.a.a(i));
            if (qVar != null) {
                return qVar.c;
            }
        }
        return -1;
    }

    public final int a() {
        return this.a.getChildCount();
    }

    public final void a(View view, int i) {
        if (this.d != null && this.d.containsKey(view)) {
            q qVar = (q) this.d.get(view);
            if (this.e != null) {
                this.e.add(Integer.valueOf(qVar.c));
            }
            this.d.remove(view);
        }
        if (this.a.getChildCount() == 0) {
            com.ucpro.base.a.g.a().b(e.E);
        }
        if (i == 2) {
            m.a("multiwindow", "del_cli_b", "type", "delete");
            m.a(d.d);
        } else if (i == 1) {
            m.a("multiwindow", "del_sli", "type", "delete");
            m.b("multiwindow_ut", "del_sli", "type", "delete");
            m.a(d.c);
        }
    }

    @NonNull
    public final List<Integer> b() {
        return this.e;
    }

    public final void c() {
        if (this.d != null) {
            Iterator it = this.d.keySet().iterator();
            while (it != null && it.hasNext()) {
                q qVar = (q) this.d.get(it.next());
                if (!(qVar == null || this.e == null)) {
                    this.e.add(Integer.valueOf(qVar.c));
                }
            }
        }
        this.d.clear();
    }

    public final void d() {
        if (this.b != null) {
            this.b.a(this);
            if (this.b != null && this.c != null) {
                this.d = new HashMap();
                List a = this.b.a();
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                for (int size = a.size() - 1; size >= 0; size--) {
                    q qVar = (q) a.get(size);
                    View kVar = new k(this.a.getContext(), size);
                    kVar.setTitleText(qVar.b);
                    kVar.setIconDrawable(qVar.a);
                    kVar.setLayoutParams(layoutParams);
                    this.a.addView(kVar);
                    this.d.put(kVar, qVar);
                }
            }
        }
    }

    public final void e() {
        if (this.b != null) {
            this.b.b(this);
        }
    }

    public final void a(int i, Drawable drawable) {
        for (View view : this.d.keySet()) {
            if (((q) this.d.get(view)).c == i) {
                ((k) view).setIconDrawable(drawable);
                return;
            }
        }
    }

    public final void a(int i, String str) {
        for (View view : this.d.keySet()) {
            if (((q) this.d.get(view)).c == i) {
                ((k) view).setTitleText(str);
                return;
            }
        }
    }

    public final void a(ArrayList<Integer> arrayList) {
        if (this.c != null) {
            for (View view : this.d.keySet()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (((q) this.d.get(view)).c == ((Integer) arrayList.get(i)).intValue()) {
                        ((k) view).setWebShotImage(this.c.a(((Integer) arrayList.get(i)).intValue(), true));
                        break;
                    }
                }
            }
        }
    }
}
