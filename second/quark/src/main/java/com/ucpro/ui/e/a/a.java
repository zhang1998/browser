package com.ucpro.ui.e.a;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.e.b;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class a extends b {
    public ATTextView l;

    public a(View view) {
        super(view);
        this.l = (ATTextView) view;
        int c = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_login_shape_radius);
        this.l.setLayoutParams(new LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_login_btn_width), com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_login_btn_height)));
        this.l.setGravity(17);
        this.l.setClickable(true);
        this.l.setTextColor(com.ucpro.ui.c.a.c("cloud_login_btn_text_color"));
        this.l.setTextSize(0, com.ucpro.ui.c.a.b((int) R.dimen.clound_sync_login_btn_text_size));
        this.l.setPadding(c, 0, c, 0);
        this.l.setBackgroundDrawable(null);
    }
}
