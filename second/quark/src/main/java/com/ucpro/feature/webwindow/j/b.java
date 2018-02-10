package com.ucpro.feature.webwindow.j;

import android.content.Context;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public abstract class b extends FrameLayout {
    public abstract float getTitleTextSize();

    public b(Context context) {
        super(context);
    }

    public FrameLayout getContentLayer() {
        return this;
    }

    public int getItemLeftPadding() {
        return a.c((int) R.dimen.setting_item_view_default_padding_left);
    }

    public int getItemRightPadding() {
        return a.c((int) R.dimen.setting_item_view_default_padding_right);
    }

    public long getClickCoolingTime() {
        return 300;
    }
}
