package com.ucpro.feature.downloadpage.e;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.base.c.b.c;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.downloadpage.e.a.b;
import com.ucpro.feature.downloadpage.e.c.h;
import com.ucpro.feature.downloadpage.e.c.l;
import com.ucpro.feature.downloadpage.e.c.n;
import com.ucpro.feature.downloadpage.e.c.t;
import com.ucpro.ui.a.a;
import com.ucpro.ui.g.g;
import com.ucpro.ui.g.i;
import com.ucpro.ui.g.m;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import hugo.weaving.DebugLog;
import java.util.List;

/* compiled from: ProGuard */
public final class o extends j implements d, com.ucpro.feature.bookmarkhis.bookmark.b.d, h, l, m {
    private c A = new ab(this);
    private x B;
    String g;
    public boolean h = false;
    private Context i;
    private j j;
    private com.ucpro.feature.downloadpage.a.d k;
    private RecyclerView l;
    private n m;
    private com.ucpro.feature.downloadpage.e.c.d n;
    private m o;
    private b p;
    private a q;
    private boolean r = false;
    private long s = 0;
    private long t = 0;
    private List<s> u;
    private boolean v;
    private com.ucpro.feature.bookmarkhis.bookmark.b.j w;
    private int x;
    private int y;
    private Drawable z;

    public o(Context context) {
        boolean z = false;
        super(context);
        this.i = context;
        this.f.a(com.ucpro.ui.c.a.d((int) R.string.download));
        this.f.a(null, null);
        x a = x.a();
        if (a.f != null) {
            z = a.f.b;
        }
        this.v = z;
        this.z = com.ucpro.ui.c.a.a("history_title_view_delete.svg");
        setWindowCallBacks(this.A);
        this.q = new a(this.i);
        this.q.setVisibility(8);
        this.l = new RecyclerView(this.i);
        this.l.setLayoutParams(new LayoutParams(-1, -1));
        this.l.setLayoutManager(new LinearLayoutManager(this.i));
        this.m = new n(getContext());
        this.m.d = this;
        this.l.setAdapter(this.m);
        this.e.addView(this.q, new LayoutParams(-1, -1));
        this.e.addView(this.l, new LayoutParams(-1, -1));
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        this.x = com.ucpro.ui.c.a.c((int) R.dimen.common_bottom_titlebar_height);
        this.y = com.ucpro.ui.c.a.c((int) R.dimen.common_bottom_titlebar_height);
        layoutParams.bottomMargin = this.y;
        this.l.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.n = new com.ucpro.feature.downloadpage.e.c.d(this.i);
        this.n.setOnBarClickListener(this);
        a(this.n, layoutParams2);
        layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.w = new com.ucpro.feature.bookmarkhis.bookmark.b.j(this.i);
        this.w.setOnClick(this);
        this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.b).setText(com.ucpro.ui.c.a.d((int) R.string.download_rename));
        this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.c).setText(com.ucpro.ui.c.a.d((int) R.string.download_share_url));
        a(this.w, layoutParams2);
        l();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.k = (com.ucpro.feature.downloadpage.a.d) bVar;
        this.j = (j) bVar;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @DebugLog
    public final void a() {
        this.j.a(new p(this));
    }

    @DebugLog
    public final void a(long j, long j2) {
        this.s = j;
        this.t = j2;
        if (this.r) {
            com.ucweb.common.util.h.m.a(0, new t(this), new v(this));
        }
    }

    public final Activity getActivity() {
        return (Activity) this.i;
    }

    public final void f() {
        super.f();
    }

    public final void l() {
        super.l();
        this.q.a();
        this.f.a(com.ucpro.ui.c.a.a("back.svg"));
    }

    public final void a(f fVar, View view, ad adVar) {
        this.j.b();
    }

    public final void a(int i, boolean z) {
        this.j.a(i, z);
    }

    @DebugLog
    public final void a(String str, String str2) {
        this.j.a(str, str2);
    }

    public final void b(int i) {
        this.o = null;
        this.o = new m(getContext());
        this.o.a(1);
        this.o.a(com.ucpro.ui.c.a.d((int) R.string.download_redownload_item), com.ucpro.ui.c.a.d((int) R.string.dialog_no_text));
        this.o.a(com.ucpro.ui.c.a.d((int) R.string.download_file_delete_redownload_item));
        this.o.a(new ae(this, i));
        this.o.show();
    }

    public final void c(int i) {
        if (i == 0) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }

    public final void a(s sVar) {
        m mVar = new m(getContext());
        mVar.a(1);
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.confirm), com.ucpro.ui.c.a.d((int) R.string.cancel));
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.download_is_not_continue));
        mVar.a(new s(this, sVar));
        mVar.show();
    }

    public final void b(s sVar) {
        long c = sVar.c() - sVar.d();
        this.o = null;
        this.o = new m(getContext());
        this.o.a(1);
        this.o.a(com.ucpro.ui.c.a.d((int) R.string.download_continue_item), com.ucpro.ui.c.a.d((int) R.string.download_wait_wifi));
        this.o.a(String.format(com.ucpro.ui.c.a.d((int) R.string.download_item_click_tips), new Object[]{com.ucpro.base.system.b.a.a(c)}));
        this.o.a(new ag(this, sVar));
        this.o.setOnCancelListener(new c(this, sVar));
        this.o.show();
    }

    public final void a(int i, String str) {
        this.p = null;
        this.p = new b(getContext());
        this.p.a(1);
        b bVar = this.p;
        if (!TextUtils.isEmpty(str)) {
            bVar.v.setText(str);
            bVar.v.postDelayed(new com.ucpro.feature.downloadpage.e.a.a(bVar), 80);
        }
        bVar = this.p;
        CharSequence d = com.ucpro.ui.c.a.d((int) R.string.download_rename_title);
        if (!TextUtils.isEmpty(d)) {
            bVar.a.setText(d);
        }
        bVar = this.p;
        d = com.ucpro.ui.c.a.d((int) R.string.confirm);
        CharSequence d2 = com.ucpro.ui.c.a.d((int) R.string.dialog_no_text);
        i i2 = bVar.i();
        if (i2 != null) {
            i2.setText(d);
        }
        i j = bVar.j();
        if (j != null) {
            j.setText(d2);
        }
        this.p.a(new l(this, i, str));
        this.p.show();
    }

    public final void b(String str, String str2) {
        this.j.b(str, str2);
    }

    public final void b() {
        if (this.m != null) {
            x.b(this.m);
        }
    }

    public final void c() {
        q();
        this.h = true;
        this.f.a(null, true);
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        layoutParams.bottomMargin = this.x;
        this.l.setLayoutParams(layoutParams);
        this.w.b();
        this.m.f = true;
        int childCount = this.l.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.l.getChildAt(i);
            if (childAt instanceof t) {
                ((t) childAt).a();
            }
        }
        this.m.a.a();
        if (this.B != null) {
            this.B.a(true);
        }
    }

    public final void m() {
        this.h = false;
        this.f.a(this.z, false);
        n nVar = this.m;
        if (nVar.c != null) {
            for (s sVar : nVar.c) {
                sVar.c = null;
            }
        }
        this.m.f = false;
        this.m.a.a();
        int childCount = this.l.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.l.getChildAt(i);
            if (childAt instanceof t) {
                ((t) childAt).b();
            }
        }
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        layoutParams.bottomMargin = this.y;
        this.l.setLayoutParams(layoutParams);
        this.m.a.a();
        this.w.c();
        if (this.B != null) {
            this.B.a(false);
        }
    }

    public final void a(int i) {
        if (i == com.ucpro.feature.bookmarkhis.bookmark.b.o.d) {
            m();
        } else if (i == com.ucpro.feature.bookmarkhis.bookmark.b.o.b) {
            r0 = this.m.b();
            if (r0.size() == 1) {
                r0 = (s) r0.get(0);
                a(r0.a(), r0.b());
            }
        } else if (i == com.ucpro.feature.bookmarkhis.bookmark.b.o.c) {
            r0 = this.m.b();
            if (r0.size() == 1) {
                r0 = (s) r0.get(0);
                this.j.b(r0.g(), r0.b());
            }
        } else if (i == com.ucpro.feature.bookmarkhis.bookmark.b.o.a) {
            a(false);
        }
    }

    public final void n() {
        q();
    }

    private void q() {
        boolean z;
        CharSequence charSequence;
        boolean z2 = true;
        String d = com.ucpro.ui.c.a.d((int) R.string.download_delete);
        n nVar = this.m;
        if (nVar.c != null) {
            for (s sVar : nVar.c) {
                if ((sVar.c instanceof Boolean) && ((Boolean) sVar.c).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            boolean z3;
            com.ucpro.feature.bookmarkhis.bookmark.b.j jVar;
            int i;
            this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.a, true);
            nVar = this.m;
            if (nVar.c != null) {
                int i2 = 0;
                for (s sVar2 : nVar.c) {
                    int i3;
                    if ((sVar2.c instanceof Boolean) && ((Boolean) sVar2.c).booleanValue()) {
                        i3 = i2 + 1;
                    } else {
                        i3 = i2;
                    }
                    i2 = i3;
                }
                if (i2 == 1) {
                    z3 = true;
                    jVar = this.w;
                    i = com.ucpro.feature.bookmarkhis.bookmark.b.o.b;
                    if (!(z3 && ((s) this.m.b().get(0)).e() == -3)) {
                        z2 = false;
                    }
                    jVar.a(i, z2);
                    this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.c, z3);
                    charSequence = d + "(" + this.m.b().size() + ")";
                }
            }
            z3 = false;
            jVar = this.w;
            i = com.ucpro.feature.bookmarkhis.bookmark.b.o.b;
            z2 = false;
            jVar.a(i, z2);
            this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.c, z3);
            charSequence = d + "(" + this.m.b().size() + ")";
        } else {
            this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.a, false);
            this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.b, false);
            this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.c, false);
            Object obj = d;
        }
        this.w.a(com.ucpro.feature.bookmarkhis.bookmark.b.o.a).setText(charSequence);
    }

    private void a(boolean z) {
        List list;
        CharSequence d;
        g gVar = new g(this.i);
        if (z) {
            list = this.u;
        } else {
            Object b = this.m.b();
        }
        if (z) {
            d = com.ucpro.ui.c.a.d((int) R.string.download_clear_all_task);
        } else {
            d = String.format(com.ucpro.ui.c.a.d((int) R.string.download_delete_tips), new Object[]{Integer.valueOf(list.size())});
        }
        gVar.a(d);
        gVar.b(com.ucpro.ui.c.a.d((int) R.string.download_delete_file));
        gVar.a(com.ucpro.ui.c.a.d((int) R.string.confirm), com.ucpro.ui.c.a.d((int) R.string.cancel));
        gVar.b(com.ucpro.ui.c.a.c("default_maintext_gray"));
        gVar.a(new e(this, list, gVar));
        gVar.show();
    }

    public final void setOnEditModel(x xVar) {
        this.B = xVar;
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9101821");
    }

    public final String getPageName() {
        return "Page_download_manage";
    }

    public final void o() {
        this.j.k();
    }

    public final void p() {
        this.j.j();
    }

    public final void a(f fVar, View view, w wVar) {
        if (!this.h) {
            a(true);
        }
    }

    static /* synthetic */ void h(o oVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.setDuration(200);
        ofFloat.addUpdateListener(new a(oVar));
        ofFloat.start();
    }
}
