package com.ucpro.feature.downloadpage.c.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.a.c;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.bookmarkhis.bookmark.w;
import com.ucpro.feature.downloadpage.d.l;
import com.ucpro.feature.downloadpage.e.o;
import com.ucpro.feature.downloadpage.e.x;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.tablayout.ProTabLayout;
import com.ucpro.ui.widget.viewpager.ProViewPager;
import com.ucpro.ui.widget.viewpager.n;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class a extends j implements c, x, n {
    public ProViewPager g;
    private Context h;
    private ProTabLayout i = new ProTabLayout(this.h);
    private b j;
    private ArrayList<c> k;
    private Drawable l;
    private Drawable m;

    public a(Context context, ArrayList<c> arrayList) {
        super(context);
        this.h = context;
        this.k = arrayList;
        this.f.b.setVisibility(8);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f.e.addView(this.i, layoutParams);
        this.g = new ProViewPager(this.h);
        this.e.addView(this.g, new LinearLayout.LayoutParams(-1, -1));
        this.g.setOffscreenPageLimit(1);
        this.g.a((n) this);
        this.j = new b(this.k);
        this.g.setAdapter(this.j);
        this.i.setupWithViewPager(this.g);
        this.j.b();
        this.l = com.ucpro.ui.c.a.a("history_title_view_delete.svg");
        this.m = new ColorDrawable(Color.parseColor("#00000000"));
        l();
        a();
    }

    private void a() {
        if (this.k != null && this.k.size() == 2) {
            f fVar;
            View view = ((c) this.k.get(0)).b;
            if (view instanceof o) {
                o oVar = (o) view;
                fVar = this.f;
                if (fVar != null) {
                    oVar.f = fVar;
                }
                oVar.setOnEditModel(this);
                if (getCurPage() == 0) {
                    this.f.a(com.ucpro.ui.c.a.a("back.svg"), w.DEFAULT);
                    this.f.a(this.l, true);
                }
            }
            if (getCurPage() == 1) {
                view = ((c) this.k.get(1)).b;
                if (view instanceof l) {
                    l lVar = (l) view;
                    fVar = this.f;
                    if (fVar != null) {
                        lVar.f = fVar;
                    }
                    this.f.a(com.ucpro.ui.c.a.a("back.svg"), w.DEFAULT);
                    this.f.a(this.m, false);
                }
            }
        }
    }

    public final int getCurPage() {
        return this.g.getCurrentItem();
    }

    public final void a(f fVar, View view, ad adVar) {
        if (this.k == null || this.k.size() == 0) {
            g.a().a(e.av);
        } else if (this.k.size() == 2) {
            ((j) ((c) this.k.get(getCurPage() == 0 ? 0 : 1)).b).a(fVar, view, adVar);
        }
    }

    public final void a(f fVar, View view, com.ucpro.ui.widget.w wVar) {
        if (this.k != null && this.k.size() == 2) {
            ((j) ((c) this.k.get(getCurPage() == 0 ? 0 : 1)).b).a(fVar, view, wVar);
        }
    }

    public final void a(int i, float f) {
    }

    public final void a(int i) {
        a();
        setEnableSwipeGesture(i == 0);
    }

    public final void b(int i) {
    }

    public final void a(boolean z) {
        boolean z2;
        boolean z3 = true;
        ProTabLayout proTabLayout = this.i;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        proTabLayout.setTabClickable(z2);
        ProViewPager proViewPager = this.g;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        proViewPager.setPagingEnabled(z2);
        if (z) {
            z3 = false;
        }
        setEnableSwipeGesture(z3);
    }

    public final void l() {
        super.l();
        this.f.b();
        if (this.g != null) {
            this.g.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_white"));
        }
        if (this.i != null) {
            this.i.setSelectedTabIndicatorColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
            this.i.a(com.ucpro.ui.c.a.c("title_bar_tab_normal_color"), com.ucpro.ui.c.a.c("default_maintext_gray"));
        }
    }

    public final ProViewPager getViewPager() {
        return this.g;
    }

    public final d getCurUtPage() {
        if (this.k != null && getCurPage() < this.k.size()) {
            View view = ((c) this.k.get(getCurPage())).b;
            if (view instanceof d) {
                return (d) view;
            }
        }
        return null;
    }
}
