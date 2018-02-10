package com.ucpro.ui.e.a;

import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.e.b;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class h extends b {
    public ATTextView l;

    public h(View view) {
        super(view);
        this.l = (ATTextView) view.findViewById(R.id.cloud_sync_tv_import);
        this.l.setCompoundDrawablePadding(a.c((int) R.dimen.clound_sync_content_icon_padding));
        this.l.setTextColor(a.c("cloud_sync_other_browser_text_color"));
    }
}
