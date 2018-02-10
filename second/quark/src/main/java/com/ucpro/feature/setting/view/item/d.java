package com.ucpro.feature.setting.view.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.framework.resources.q;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public final class d extends e {
    private ImageView a;
    private TextView b;
    private boolean c;
    private q d;

    public d(Context context, int i, String str, String str2, boolean z) {
        super(context, i, str, str2, z);
    }

    public final byte getSettingItemViewType() {
        return (byte) 2;
    }

    public final void a(String str) {
        setValue(str);
    }

    public final void a() {
        d();
    }

    public final void b() {
        super.b();
        this.a = new ImageView(getContext());
        this.a.setSelected(getSelected());
        this.b = new TextView(getContext());
        TextView textView = this.b;
        if (textView != null) {
            textView.setSingleLine();
            textView.setEllipsize(TruncateAt.END);
        }
        this.b.setText(getTitle());
        this.b.setTextSize(0, getTitleTextSize());
        setPadding(a.c((int) R.dimen.wipe_cache_setting_view_item_left_padding), 0, 0, 0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a.c((int) R.dimen.wipe_cache_setting_view_item_check_box_size), a.c((int) R.dimen.wipe_cache_setting_view_item_check_box_size));
        layoutParams.gravity = 16;
        addView(this.a, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        layoutParams.gravity = 16;
        this.b.setPadding(a.c((int) R.dimen.wipe_cache_setting_view_item_title_left_padding), 0, 0, 0);
        addView(this.b, layoutParams);
        d();
    }

    private void d() {
        if (this.b != null) {
            this.b.setTextColor(getTitleTextColor());
        }
        if (this.a != null) {
            Drawable a = a.a("setting_item_checkbox_on.svg");
            Drawable a2 = a.a("setting_item_checkbox_off.svg");
            this.d = new q();
            this.d.a(new int[]{16842913}, a);
            this.d.a(new int[0], a2);
            this.a.setImageDrawable(this.d);
            a.a(this.a);
        }
    }

    public final void onClick(View view) {
        if (c()) {
            setValue(String.valueOf(!Boolean.valueOf(getValue()).booleanValue()));
            if (getStatus() && this.b != null) {
                this.b.performClick();
            }
            if (getStatus() && this.a != null) {
                this.a.setSelected(getSelected());
            }
            super.onClick(view);
        }
    }

    public final void setValue(String str) {
        super.setValue(str);
        this.c = Boolean.valueOf(str).booleanValue();
    }

    final void a(boolean z) {
    }

    public final boolean getSelected() {
        return this.c;
    }

    public final long getClickCoolingTime() {
        return 100;
    }
}
