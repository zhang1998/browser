package com.ucpro.ui.e.a;

import android.view.View;
import com.quark.browser.R;
import com.ucpro.feature.setting.view.item.BooleanSettingItemViewCheckBox;
import com.ucpro.ui.c.a;
import com.ucpro.ui.e.b;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class f extends b {
    public ATTextView l;
    public ATTextView m;
    public BooleanSettingItemViewCheckBox n;

    public f(View view) {
        super(view);
        this.l = (ATTextView) view.findViewById(R.id.setting_tv_content);
        this.m = (ATTextView) view.findViewById(R.id.setting_tv_desc);
        this.l.setCompoundDrawablePadding(a.c((int) R.dimen.clound_sync_content_icon_padding));
        this.l.setTextColor(a.c("default_maintext_gray"));
        this.m.setTextColor(a.c("cloud_sync_item_desc_text_color"));
        this.n = (BooleanSettingItemViewCheckBox) view.findViewById(R.id.setting_checkbox);
        view.setBackgroundDrawable(a.c());
    }
}
