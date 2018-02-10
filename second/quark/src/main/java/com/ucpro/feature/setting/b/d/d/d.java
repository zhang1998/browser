package com.ucpro.feature.setting.b.d.d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.quark.browser.R;
import com.ucpro.feature.setting.b.d.b.h;
import com.ucpro.feature.setting.b.d.c.a;
import com.ucpro.feature.setting.view.item.c;

/* compiled from: ProGuard */
public final class d extends ScrollView {
    private LinearLayout a = new LinearLayout(getContext());
    private a b;
    private com.ucpro.feature.setting.view.c.a c;

    public d(Context context) {
        super(context);
        this.a.setOrientation(1);
        this.a.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.a);
    }

    public final a getAdapter() {
        return this.b;
    }

    public final void setAdapter(a aVar) {
        if (aVar != null) {
            this.b = aVar;
            this.a.removeAllViews();
            for (h addView : aVar.b) {
                this.a.addView(addView, new LayoutParams(-1, getItemHeight()));
            }
        }
    }

    public final int getItemHeight() {
        return com.ucpro.ui.c.a.c((int) R.dimen.main_setting_view_item_height);
    }

    public final void setSettingViewCallback(com.ucpro.feature.setting.view.c.a aVar) {
        this.c = aVar;
    }

    public final View getSettingView() {
        return this;
    }

    private c getSettingItemViewCallbakc() {
        if (this.c instanceof c) {
            return this.c;
        }
        return null;
    }
}
