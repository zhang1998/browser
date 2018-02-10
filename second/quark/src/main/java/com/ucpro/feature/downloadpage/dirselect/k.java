package com.ucpro.feature.downloadpage.dirselect;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.bd;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.base.d.b;
import com.ucpro.feature.downloadpage.dirselect.a.d;
import com.ucpro.feature.downloadpage.dirselect.a.f;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import java.util.List;

/* compiled from: ProGuard */
public final class k extends j implements OnClickListener, c, c, p {
    private RecyclerView g = new RecyclerView(getContext());
    private n h = new n(getContext());
    private j i;
    private m j;
    private o k;
    private f l;

    public k(Context context, m mVar) {
        super(context);
        this.j = mVar;
        setBackgroundColor(a.c("default_background_white"));
        this.f.a(a.d((int) R.string.download_dir_select));
        this.f.a(a.a("back.svg"), null);
        this.f.a(a.a("bookmark_confirm.svg"), null);
        setWindowCallBacks(this);
        this.g.setAdapter(this.h);
        this.g.setLayoutParams(new LayoutParams(-1, -1));
        this.g.setLayoutManager(new LinearLayoutManager(getContext()));
        LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
        int c = a.c((int) R.dimen.common_bottom_titlebar_height);
        layoutParams.bottomMargin = c;
        this.g.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.gravity = 1;
        layoutParams2.bottomMargin = a.c((int) R.dimen.dir_manager_indicator_bottom_margin);
        layoutParams2.leftMargin = a.c((int) R.dimen.dir_manager_indicator_left_margin);
        layoutParams2.rightMargin = a.c((int) R.dimen.dir_manager_indicator_right_margin);
        this.l = new f(getContext());
        this.l.setBackgroundDrawable(getResources().getDrawable(R.drawable.indicator_shape));
        this.l.setPadding(a.c((int) R.dimen.dir_manager_indicator_left_margin), a.c((int) R.dimen.dialog_common_margin), a.c((int) R.dimen.dir_manager_indicator_left_margin), a.c((int) R.dimen.dialog_common_margin));
        this.e.setGravity(17);
        this.e.addView(this.l, layoutParams2);
        this.e.addView(this.g);
        layoutParams2 = new FrameLayout.LayoutParams(-1, c);
        layoutParams2.gravity = 81;
        this.k = new o(getContext());
        this.k.setOnClickListener(this);
        a(this.k, layoutParams2);
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, ad adVar) {
        this.i.b();
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, w wVar) {
        this.i.c();
    }

    public final void setPresenter(b bVar) {
        this.i = (j) bVar;
        this.i.a();
    }

    public final void a(boolean z) {
        this.i.a(false);
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof k) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.i.b();
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.j.b((g) view);
        }
        return null;
    }

    public final void a(List<String> list) {
        bd bdVar = this.h;
        if (list != null) {
            bdVar.c = list;
            bdVar.a.a();
        }
    }

    public final void a(int i) {
        this.i.a(i);
    }

    public final void onClick(View view) {
        this.i.d();
    }

    public final void b(List<d> list) {
        this.l.setData(list);
    }
}
