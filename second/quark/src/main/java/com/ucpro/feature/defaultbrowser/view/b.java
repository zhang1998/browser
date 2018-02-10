package com.ucpro.feature.defaultbrowser.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;
import com.ucpro.ui.widget.o;

/* compiled from: ProGuard */
public final class b extends FrameLayout {
    private o a;
    private o b;
    private LinearLayout c = new LinearLayout(getContext());
    private TextView d;
    private String e;
    private int f = -1;
    private float g = -1.0f;
    private int h = -1;

    public b(Context context) {
        super(context);
        addView(this.c, new LayoutParams(-2, -1));
        this.a = new o(getContext());
        this.c.addView(this.a, new LinearLayout.LayoutParams(a.c((int) R.dimen.default_browser_button_height) / 2, -1));
        this.d = new TextView(getContext());
        this.d.setText(this.e);
        this.d.setGravity(17);
        this.d.setTextSize(0, a.a((int) R.dimen.default_browser_button_text_size));
        this.d.setPadding(a.c((int) R.dimen.default_browser_button_padding_left) - (a.c((int) R.dimen.default_browser_button_height) / 2), 0, a.c((int) R.dimen.default_browser_button_padding_right) - (a.c((int) R.dimen.default_browser_button_height) / 2), 0);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.c.addView(this.d, layoutParams);
        this.b = new o(getContext());
        this.b.setType(1);
        this.c.addView(this.b, new LinearLayout.LayoutParams(a.c((int) R.dimen.default_browser_button_height) / 2, -1));
        if (-1 == this.h) {
            setBackgroundColor(a.c("default_browser_setting_button_bg_color"));
        }
        if (-1 == this.f && this.d != null) {
            this.d.setTextColor(a.c("default_browser_setting_btn_text_color"));
        }
        if (this.a != null) {
            this.a.setColor(this.h);
        }
        if (this.b != null) {
            this.b.setColor(this.h);
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(this.d.getMeasuredWidth(), i2);
    }

    public final void setText(String str) {
        this.e = str;
        if (this.d != null) {
            this.d.setText(this.e);
        }
    }

    public final void setBackgroundColor(int i) {
        this.h = i;
        if (this.d != null) {
            this.d.setBackgroundColor(i);
        }
    }
}
