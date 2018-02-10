package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.navigation.b.b;
import com.ucpro.feature.navigation.b.i;
import com.ucpro.services.c.d;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.a.ab;
import com.ucpro.ui.widget.a.n;
import com.ucpro.ui.widget.a.v;
import com.ucweb.common.util.i.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class q extends v implements n, n {
    public ArrayList<m> b;
    public h c;
    public boolean d;
    public boolean e = true;
    boolean f = false;
    public int g;
    public boolean h = false;
    private Context i;
    private ArrayList<ab> j = new ArrayList();
    private m k;
    private View l;
    private boolean m;
    private boolean n;
    private boolean o;
    private Drawable p;

    public q(Context context) {
        this.i = context;
    }

    public final int getCount() {
        return this.b != null ? this.b.size() : 0;
    }

    public final Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void a(View view, View view2) {
        if ((view instanceof ab) && (view2 instanceof ab)) {
            ab abVar = (ab) view;
            ab abVar2 = (ab) view2;
            if (abVar != null && abVar2 != null) {
                ab swapView = abVar2.getSwapView();
                if (abVar.getSwapView() != null) {
                    abVar2.setSwapView(abVar.getSwapView());
                } else {
                    abVar2.setSwapView(abVar);
                }
                if (swapView != null) {
                    abVar.setSwapView(swapView);
                } else {
                    abVar.setSwapView(abVar2);
                }
                a(abVar);
                a(abVar2);
            }
        }
    }

    private void a(ab abVar) {
        this.j.add(abVar);
    }

    public final void a(View view) {
        this.l = view;
        if (view instanceof s) {
            this.k = ((s) view).getData();
        }
    }

    public final void a(int i) {
        getItem(i);
        if (this.l instanceof s) {
            ((s) this.l).setData(this.k);
        }
        this.l = null;
        this.m = true;
    }

    protected final View a(int i, View view, Object obj) {
        if (this.m) {
            this.m = false;
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                ab abVar = (ab) it.next();
                if (abVar != null) {
                    abVar.setSwapView(null);
                }
            }
            this.j.clear();
        }
        if (view instanceof s) {
            view = (s) view;
            view.setSwapView(null);
        } else {
            view = new s(this.i);
            if (this.h) {
                view.setTextViewTitleColor(this.g);
            }
            view.setLayoutParams(new LayoutParams(-1, a.c((int) R.dimen.common_titlebar_height)));
            view.setListener(this);
        }
        if (obj instanceof m) {
            view.setData((m) obj);
            if (((m) obj).h()) {
                if (TextUtils.isEmpty(view.getData().f) && view.getData().h()) {
                    view.h();
                    view.setFavIcon(j());
                } else if (TextUtils.isEmpty(view.getData().f) || !view.getData().f.startsWith("ext:navifunc:")) {
                    Drawable a = i.a.a(this.i, null, null, f.c(view.getData().f));
                    if (a != null) {
                        view.g();
                        view.setFavIcon(a);
                    } else {
                        if (view.getTag() == null) {
                            view.setTag(new l(this));
                        }
                        com.ucpro.services.c.f.a.a.a(this.i, view.getData().f, (d) view.getTag(), view);
                    }
                } else {
                    view.g();
                    i.a;
                    view.setFavIcon(b.c(view.getData().f));
                }
            }
        }
        view.setPosition(i);
        if (this.d) {
            if (!view.c()) {
                view.e = 1;
                view.setOnLongClickListener(null);
                view.a(false);
                view.b();
                view.i();
            }
            if (a()) {
                view.setCheckBoxelected(true);
            } else if (b()) {
                view.setCheckBoxelected(false);
            } else {
                view.setCheckBoxelected(((m) getItem(i)).w);
            }
        } else {
            if (view.getAlpha() != IPictureView.DEFAULT_MIN_SCALE) {
                view.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            }
            if (!view.f()) {
                view.e = 0;
                view.setOnLongClickListener(view);
                if (!view.d()) {
                    view.e();
                    view.j();
                }
            }
        }
        return view;
    }

    public final boolean a() {
        if (this.b == null) {
            return false;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (!((m) it.next()).w) {
                return false;
            }
        }
        return true;
    }

    public final boolean b() {
        if (this.b == null) {
            return true;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((m) it.next()).w) {
                return false;
            }
        }
        return true;
    }

    private Drawable j() {
        if (this.p == null) {
            this.p = a.a("discover_bk_item_web_icon.svg");
        }
        return this.p;
    }

    public final void a(boolean z, int i) {
        ((m) getItem(i)).w = z;
        if (this.c != null) {
            this.c.e(z);
        }
    }

    public final void a(m mVar) {
        if (this.c != null) {
            this.c.a(mVar);
        }
    }

    public final void c() {
        this.n = true;
        this.o = false;
        notifyDataSetChanged();
        a(true);
    }

    private void a(boolean z) {
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((m) it.next()).w = z;
            }
        }
    }

    public final void d() {
        this.o = true;
        this.n = false;
        notifyDataSetChanged();
        a(false);
    }

    public final boolean e() {
        if (this.b == null) {
            return false;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((m) it.next()).w) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        if (this.b == null) {
            return false;
        }
        Iterator it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (((m) it.next()).w) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final m g() {
        if (this.b == null) {
            return null;
        }
        int i = 0;
        Iterator it = this.b.iterator();
        m mVar = null;
        while (it.hasNext()) {
            int i2;
            m mVar2 = (m) it.next();
            if (mVar2.w) {
                i2 = i + 1;
            } else {
                mVar2 = mVar;
                i2 = i;
            }
            i = i2;
            mVar = mVar2;
        }
        if (i == 1) {
            return mVar;
        }
        return null;
    }

    public final ArrayList<m> h() {
        ArrayList<m> arrayList = new ArrayList();
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar.w) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<Long> i() {
        ArrayList<Long> arrayList = new ArrayList();
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar.w) {
                    arrayList.add(Long.valueOf(mVar.b));
                }
            }
        }
        return arrayList;
    }

    public final void b(m mVar) {
        if (!this.d && this.c != null) {
            this.c.b(mVar);
        }
    }
}
