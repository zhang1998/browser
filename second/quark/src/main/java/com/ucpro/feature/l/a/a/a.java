package com.ucpro.feature.l.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.navigation.b.b;
import com.ucpro.feature.navigation.b.i;
import com.ucpro.services.c.d;
import com.ucweb.common.util.i.f;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class a extends bd<b> implements e {
    public ArrayList<m> c;
    Drawable d;
    public d e;
    private Context f;
    private Drawable g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private int k;

    public final /* synthetic */ void a(bh bhVar, int i) {
        b bVar = (b) bhVar;
        m mVar = (m) this.c.get(i);
        bVar.q = mVar;
        bVar.p.setText(mVar.e);
        bVar.p.setTextColor(this.k);
        if (mVar.g()) {
            bVar.n.setVisibility(0);
            bVar.o.setVisibility(4);
            bVar.n.setImageDrawable(this.g);
            bVar.m.setImageDrawable(this.j);
            if ((bVar.m.getTag() instanceof Boolean) && ((Boolean) bVar.m.getTag()).booleanValue()) {
                bVar.m.setTag(Boolean.valueOf(false));
                bVar.m.animate().rotation(0.0f);
            }
        } else {
            bVar.n.setVisibility(0);
            bVar.o.setVisibility(4);
            bVar.n.setImageDrawable(this.d);
            if (TextUtils.isEmpty(mVar.f) || !mVar.f.startsWith("ext:navifunc:")) {
                Drawable a = i.a.a(this.f, null, null, f.c(mVar.f));
                if (a != null) {
                    bVar.o.setVisibility(0);
                    bVar.o.setImageDrawable(a);
                } else {
                    if (bVar.r == null) {
                        bVar.r = new c(this);
                    }
                    com.ucpro.services.c.f.a.a.a(this.f, mVar.f, (d) bVar.r, bVar);
                }
            } else {
                bVar.o.setVisibility(0);
                ImageView imageView = bVar.o;
                i.a;
                imageView.setImageDrawable(b.c(mVar.f));
            }
            if (this.e != null) {
                this.e.a(mVar.f, bVar.m, this.h);
            }
        }
        bVar.s = this;
    }

    public a(Context context) {
        this.f = context;
        b();
    }

    public final void b() {
        this.g = com.ucpro.ui.c.a.a("bookmark_category.svg");
        this.h = com.ucpro.ui.c.a.a("discover_bk_item_add.svg");
        this.i = com.ucpro.ui.c.a.a("discover_bk_item_close.svg");
        this.j = com.ucpro.ui.c.a.a("discover_bk_item_arrow.svg");
        this.d = com.ucpro.ui.c.a.a("discover_bk_item_web_icon.svg");
        this.k = com.ucpro.ui.c.a.c("default_maintext_gray");
    }

    public final int a() {
        return this.c != null ? this.c.size() : 0;
    }

    public final void a(m mVar, View view) {
        if (mVar != null) {
            if (mVar.g()) {
                if (this.e != null) {
                    this.e.a(mVar);
                }
            } else if (mVar.h() && this.e != null) {
                if (view instanceof ImageView) {
                    Object tag = ((ImageView) view).getTag();
                    d dVar = this.e;
                    Drawable drawable = this.h;
                    boolean z = ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) ? false : true;
                    dVar.a(mVar, view, drawable, z);
                } else if (view instanceof RelativeLayout) {
                    this.e.b(mVar);
                }
            }
        }
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.discover_bk_item, viewGroup, false);
        inflate.setLayoutParams(new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.dicover_page_bookmark_item_height)));
        return new b(inflate);
    }
}
