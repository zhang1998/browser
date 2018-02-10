package com.ucpro.feature.l.a.a;

import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class b extends bh implements OnClickListener {
    public FrameLayout l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public TextView p;
    public m q;
    Object r;
    e s;

    public b(View view) {
        super(view);
        view.setBackgroundDrawable(a.c());
        view.setOnClickListener(this);
        this.l = (FrameLayout) view.findViewById(R.id.fl_arrow_content);
        this.l.setOnClickListener(this);
        this.m = (ImageView) view.findViewById(R.id.iv_discover_arrow);
        this.n = (ImageView) view.findViewById(R.id.iv_discover_icon_default);
        this.o = (ImageView) view.findViewById(R.id.iv_discover_icon_web);
        this.p = (TextView) view.findViewById(R.id.tv_discover_title);
    }

    public final void onClick(View view) {
        if (this.s != null) {
            e eVar = this.s;
            m mVar = this.q;
            d();
            if (view.getId() == R.id.fl_arrow_content) {
                view = this.m;
            }
            eVar.a(mVar, view);
        }
    }
}
