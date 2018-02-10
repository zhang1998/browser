package com.ucpro.feature.webwindow.l.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.quark.browser.R;

/* compiled from: ProGuard */
public final class d extends FrameLayout {
    private TextView a = new TextView(getContext());

    public d(@NonNull Context context) {
        super(context);
        setForegroundGravity(16);
        this.a.setSingleLine();
        this.a.setPadding(getResources().getDimensionPixelOffset(R.dimen.freemenu_item_padding_left), getResources().getDimensionPixelOffset(R.dimen.freemenu_item_padding_top), getResources().getDimensionPixelOffset(R.dimen.freemenu_item_padding_right), getResources().getDimensionPixelOffset(R.dimen.freemenu_item_padding_bottom));
        this.a.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.freemenu_text_size));
        this.a.setGravity(17);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.a, layoutParams);
    }

    public final void setText(String str) {
        this.a.setText(str);
    }

    public final void setTextColor(int i) {
        this.a.setTextColor(i);
    }
}
