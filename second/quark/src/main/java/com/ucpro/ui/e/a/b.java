package com.ucpro.ui.e.a;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class b extends com.ucpro.ui.e.b {
    public ATTextView l;

    public b(View view) {
        super(view);
        view.setBackgroundColor(a.c("common_desc_item_bg"));
        view.setLayoutParams(new LayoutParams(-1, a.c((int) R.dimen.common_desc_item_height)));
        this.l = (ATTextView) view.findViewById(R.id.setting_common_tv_desc);
        this.l.setTextColor(a.c("common_desc_item_text_color"));
    }
}
