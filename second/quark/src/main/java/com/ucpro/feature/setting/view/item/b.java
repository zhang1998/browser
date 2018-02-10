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
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class b extends e {
    private TextView a;
    private FrameLayout b;
    private ImageView c;

    public b(Context context, int i, String str, boolean z, String str2) {
        super(context, i, str, "", z, str2);
    }

    public final byte getSettingItemViewType() {
        return (byte) 1;
    }

    public final void a(String str) {
        setValue(str);
    }

    public final void a() {
        d();
    }

    public final void b() {
        super.b();
        this.a = new TextView(getContext());
        this.a.setTag(R.id.ui_auto, getUiAutoTag());
        this.c = new ImageView(getContext());
        this.b = new FrameLayout(getContext());
        TextView textView = this.a;
        if (textView != null) {
            textView.setSingleLine();
            textView.setEllipsize(TruncateAt.END);
        }
        d();
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        layoutParams.gravity = 16;
        this.a.setPadding(getItemLeftPadding(), 0, 0, 0);
        addView(this.a, layoutParams);
        this.b.addView(this.c, new FrameLayout.LayoutParams(a.c((int) R.dimen.arrow_setting_item_ico_size), a.c((int) R.dimen.arrow_setting_item_ico_size)));
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.b.setPadding(0, 0, getItemRightPadding(), 0);
        addView(this.b, layoutParams);
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

    private void d() {
        if (this.c != null) {
            this.c.setImageDrawable(a.a("open_sub_setting.svg"));
        }
        if (this.a != null) {
            this.a.setText(getTitle());
            this.a.setTextColor(getTitleTextColor());
            this.a.setTextSize(0, getTitleTextSize());
        }
    }

    public final void onClick(View view) {
        if (c()) {
            super.onClick(view);
        }
    }
}
