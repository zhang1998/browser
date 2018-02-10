package com.ucpro.feature.setting.view.item;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class BooleanSettingItemViewCheckBox extends FrameLayout {
    private ImageView a;
    private ImageView b;
    private boolean c;
    private boolean d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private ObjectAnimator i;
    private OnCheckedChangeListener j;
    private int k;
    private int l;

    public BooleanSettingItemViewCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = null;
        this.k = 0;
        this.l = 0;
        b();
    }

    public BooleanSettingItemViewCheckBox(Context context) {
        this(context, true, false);
    }

    public BooleanSettingItemViewCheckBox(Context context, boolean z, boolean z2) {
        super(context);
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.d = z;
        this.c = z2;
        b();
    }

    private void b() {
        this.k = a.c((int) R.dimen.boolean_setting_item_view_checkbox_switcher_selectd_left_margin_init);
        this.l = a.c((int) R.dimen.boolean_setting_item_view_checkbox_switcher_selectd_left_margin);
        setLayoutParams(new LayoutParams(-2, -2));
        this.a = new ImageView(getContext());
        this.b = new ImageView(getContext());
        if (!(this.a == null || this.b == null)) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(a.c((int) R.dimen.boolean_setting_item_view_checkbox_background_width), a.c((int) R.dimen.boolean_setting_item_view_checkbox_background_height));
            layoutParams.gravity = 16;
            addView(this.a, layoutParams);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(a.c((int) R.dimen.boolean_setting_item_view_checkbox_switcher_width), a.c((int) R.dimen.boolean_setting_item_view_checkbox_switcher_height));
            layoutParams2.gravity = 16;
            this.b.setTranslationX(getSelectStatus() ? (float) this.l : (float) this.k);
            addView(this.b, layoutParams2);
        }
        this.e = a.a("setting_item_switch_on_bg.svg");
        this.f = a.a("setting_item_switch_off_bg.svg");
        this.h = a.a("setting_item_switch_off.svg");
        this.g = this.h;
        c();
        ObjectAnimator objectAnimator = new ObjectAnimator();
        this.i = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{(float) this.k});
        this.i.setInterpolator(new DecelerateInterpolator());
    }

    private void c() {
        if (this.c) {
            this.a.setImageDrawable(this.e);
            this.b.setImageDrawable(this.g);
        } else {
            this.a.setImageDrawable(this.f);
            this.b.setImageDrawable(this.h);
        }
        a.a(this.a);
        a.a(this.b);
    }

    public void setSelectedStatus(boolean z) {
        if (this.c != z) {
            this.c = z;
            c();
            if (z) {
                this.i.setFloatValues(new float[]{(float) this.k, (float) this.l});
                this.i.setDuration(100);
                this.i.start();
            } else {
                this.i.setFloatValues(new float[]{(float) this.l, (float) this.k});
                this.i.setDuration(100);
                this.i.start();
            }
            if (this.j != null) {
                this.j.onCheckedChanged(null, z);
            }
        }
    }

    public boolean getSelectStatus() {
        return this.c;
    }

    public void setEnabledStatus(boolean z) {
        this.d = z;
    }

    public boolean getEnableStatus() {
        return this.d;
    }

    public void setChecked(boolean z) {
        setSelectedStatus(z);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.j = onCheckedChangeListener;
    }

    public final void a() {
        setSelectedStatus(!this.c);
    }
}
