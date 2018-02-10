package com.ucpro.feature.defaultbrowser.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;

/* compiled from: ProGuard */
public final class a extends FrameLayout {
    private ImageView a;
    private b b;

    public a(Context context) {
        super(context);
        View linearLayout = new LinearLayout(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        this.a = new ImageView(getContext());
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.b = new b(getContext());
        layoutParams = new LinearLayout.LayoutParams(-2, com.ucpro.ui.c.a.c((int) R.dimen.default_browser_button_height));
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.default_browser_button_margin_top);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setBackgroundColor(com.ucpro.ui.c.a.c("default_browser_setting_button_bg_color"));
        linearLayout.addView(this.a);
        linearLayout.addView(this.b, layoutParams);
        addView(linearLayout);
    }

    public final void setButtonOnClickListener(OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public final void setTipDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public final void setButtonText(String str) {
        this.b.setText(str);
    }
}
