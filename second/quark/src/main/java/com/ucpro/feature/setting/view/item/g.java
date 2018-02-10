package com.ucpro.feature.setting.view.item;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.setting.view.a.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class g extends e {
    private b a;
    private TextView b;
    private FrameLayout c;
    private ImageView d;

    public g(Context context, int i, String str, String str2, boolean z) {
        super(context, i, str, str2, z);
    }

    public final byte getSettingItemViewType() {
        return (byte) 6;
    }

    public final void a(String str) {
        setValue(str);
        if (this.b != null) {
            this.b.setText(getValue());
        }
    }

    public final void a() {
        d();
    }

    public final void b() {
        super.b();
        this.a = new b(getContext());
        this.a.setText(getTitle());
        this.a.setTextSize(getTitleTextSize());
        this.b = new TextView(getContext());
        this.b.setSingleLine();
        this.b.setEllipsize(TruncateAt.END);
        this.b.setText(getValue());
        this.b.setTextSize(0, getSubTitleTextSize());
        this.c = new FrameLayout(getContext());
        this.d = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        layoutParams.gravity = 16;
        this.a.setPadding(getItemLeftPadding(), 0, 0, 0);
        addView(this.a, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.b.setPadding(0, 0, a.c((int) R.dimen.setting_item_view_sub_title_right_padding), 0);
        addView(this.b, layoutParams);
        this.c.addView(this.d, new FrameLayout.LayoutParams(a.c((int) R.dimen.arrow_setting_item_ico_size), a.c((int) R.dimen.arrow_setting_item_ico_size)));
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.c.setPadding(0, 0, getItemRightPadding(), 0);
        addView(this.c, layoutParams);
        d();
    }

    final void a(boolean z) {
        if (this.a == null) {
            return;
        }
        if (z) {
            this.a.setTextColor(getTitleTextColor());
            setOnClickListener(this);
            return;
        }
        this.a.setTextColor(a.c("default_commentstext_gray"));
        setOnClickListener(null);
    }

    private float getSubTitleTextSize() {
        return a.a((int) R.dimen.setting_item_view_default_sub_title_text_size);
    }

    private void d() {
        if (this.d != null) {
            this.d.setImageDrawable(a.a("open_sub_setting.svg"));
        }
        if (this.a != null) {
            this.a.setTextColor(getTitleTextColor());
        }
        if (this.b != null) {
            this.b.setTextColor(getSubTitleTextColor());
        }
    }

    private int getSubTitleTextColor() {
        return a.c("setting_item_view_default_sub_title_text_color");
    }

    public final void onClick(View view) {
        if (c()) {
            super.onClick(view);
        }
    }
}
