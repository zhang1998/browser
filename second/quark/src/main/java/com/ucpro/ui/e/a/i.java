package com.ucpro.ui.e.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.e.b;

/* compiled from: ProGuard */
public final class i extends b {
    public FrameLayout l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public ImageView q;

    public i(View view) {
        super(view);
        LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, a.c((int) R.dimen.privacymode_content_type_item_height));
        layoutParams.leftMargin = a.c((int) R.dimen.privacymode_content_type_item_marginleft);
        layoutParams.rightMargin = a.c((int) R.dimen.privacymode_content_type_item_marginright);
        view.setLayoutParams(layoutParams);
        this.l = (FrameLayout) view.findViewById(R.id.fl_item);
        this.m = (ImageView) view.findViewById(R.id.iv_privacymode_icon);
        this.n = (ImageView) view.findViewById(R.id.iv_privacymode_arrow);
        this.o = (TextView) view.findViewById(R.id.tv_privacymode_title);
        this.p = (TextView) view.findViewById(R.id.tv_privacymode_content);
        this.q = (ImageView) view.findViewById(R.id.iv_privacy_mode_right_desc_icon);
    }
}
