package com.ucpro.ui.e.a;

import android.view.View;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.e.b;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class g extends b {
    public ATTextView l;
    public ImageView m;
    public ATTextView n;

    public g(View view) {
        super(view);
        this.l = (ATTextView) view.findViewById(R.id.cloud_sync_tv_content);
        this.n = (ATTextView) view.findViewById(R.id.cloud_sync_tv_desc);
        this.m = (ImageView) view.findViewById(R.id.cloud_sync_iv_arrow);
        this.l.setCompoundDrawablePadding(a.c((int) R.dimen.clound_sync_content_icon_padding));
        this.l.setTextColor(a.c("default_maintext_gray"));
        this.n.setTextColor(a.c("cloud_sync_item_desc_text_color"));
        this.m.setImageDrawable(a.a("open_sub_setting.svg"));
        view.setBackgroundDrawable(a.c());
    }
}
