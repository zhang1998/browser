package com.ucpro.feature.setting.view.item;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class f extends e implements OnCheckedChangeListener {
    public SwitchCompat a;
    private TextView b;

    public f(Context context, int i, String str, String str2, boolean z, String str3) {
        super(context, i, str, str2, z, str3);
    }

    public final byte getSettingItemViewType() {
        return (byte) 0;
    }

    public final void a(String str) {
        setValue(str);
    }

    public final void a() {
        d();
    }

    public final void b() {
        super.b();
        this.b = new TextView(getContext());
        this.b.setTag(R.id.ui_auto, getUiAutoTag());
        TextView textView = this.b;
        if (textView != null) {
            textView.setSingleLine();
            textView.setEllipsize(TruncateAt.END);
        }
        this.a = new SwitchCompat(getContext());
        this.a.setChecked(Boolean.valueOf(getValue()).booleanValue());
        this.a.setThumbDrawable(a.a("setting_item_switch_off.svg"));
        this.a.setTrackDrawable(a.a("switch_compat_track.xml"));
        this.a.setOnCheckedChangeListener(this);
        d();
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        layoutParams.gravity = 16;
        this.b.setPadding(getItemLeftPadding(), 0, 0, 0);
        addView(this.b, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.a.setPadding(0, 0, getItemRightPadding(), 0);
        addView(this.a, layoutParams);
    }

    private void d() {
        this.b.setText(getTitle());
        this.b.setTextColor(getTitleTextColor());
        this.b.setTextSize(0, getTitleTextSize());
    }

    public final void setValue(String str) {
        super.setValue(str);
        if (str != null) {
            super.onClick(this);
        }
    }

    final void a(boolean z) {
        if (this.b != null) {
            if (z) {
                this.b.setTextColor(getTitleTextColor());
                setOnClickListener(this);
            } else {
                this.b.setTextColor(a.c("default_commentstext_gray"));
                setOnClickListener(null);
            }
            this.a.setEnabled(z);
        }
    }

    public final void onClick(View view) {
        if (c() && this.a != null) {
            this.a.toggle();
        }
    }

    public final long getClickCoolingTime() {
        return 300;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        setValue(String.valueOf(z));
    }
}
