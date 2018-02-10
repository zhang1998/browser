package com.ucpro.feature.j;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.j.a.a;

/* compiled from: ProGuard */
final class h extends LinearLayout {
    SwitchCompat a;
    final /* synthetic */ l b;
    private TextView c = new TextView(getContext());

    public h(l lVar, Context context, a aVar) {
        this.b = lVar;
        super(context);
        setId(aVar.a);
        setOrientation(0);
        setGravity(16);
        this.c.setText(aVar.c);
        this.c.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.common_titlebar_title_size));
        this.c.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.c.setGravity(16);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, com.ucpro.ui.c.a.c((int) R.dimen.main_setting_view_item_height));
        layoutParams.leftMargin = com.ucpro.ui.c.a.c((int) R.dimen.common_desc_text_margin_left);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        addView(this.c, layoutParams);
        this.a = new SwitchCompat(getContext());
        this.a.setChecked(aVar.e);
        this.a.setThumbDrawable(com.ucpro.ui.c.a.a("setting_item_switch_off.svg"));
        this.a.setTrackDrawable(com.ucpro.ui.c.a.a("switch_compat_track.xml"));
        this.a.setId(aVar.a);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = com.ucpro.ui.c.a.c((int) R.dimen.common_titlebar_margin_left);
        addView(this.a, layoutParams);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setOnClickListener(this.b);
            this.c.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        } else {
            setOnClickListener(null);
            this.c.setTextColor(com.ucpro.ui.c.a.c("default_commentstext_gray"));
        }
        this.a.setEnabled(z);
    }
}
