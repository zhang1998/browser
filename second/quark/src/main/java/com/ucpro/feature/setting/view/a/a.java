package com.ucpro.feature.setting.view.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class a extends FrameLayout {
    private RelativeLayout a;
    private ImageView b;
    private int c;
    private int d;
    private int e;
    private ImageView f;
    private ATTextView g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private c m;

    public a(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0.0f;
        this.m = null;
        this.c = com.ucpro.ui.c.a.c((int) R.dimen.setting_seekbar_width);
        this.d = com.ucpro.ui.c.a.c((int) R.dimen.setting_seekbar_indicator_width);
        this.e = this.c + this.d;
        this.a = new RelativeLayout(getContext());
        this.b = new ImageView(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, -2);
        layoutParams.addRule(13);
        this.a.addView(this.b, layoutParams);
        this.f = new ImageView(getContext());
        layoutParams = new RelativeLayout.LayoutParams(this.d, this.d);
        layoutParams.addRule(15);
        this.a.addView(this.f, layoutParams);
        layoutParams = new FrameLayout.LayoutParams(this.e, this.d);
        layoutParams.gravity = 81;
        addView(this.a, layoutParams);
        this.g = new ATTextView(getContext());
        this.g.setTextSize(0, (float) com.ucpro.ui.c.a.c((int) R.dimen.font_size_setting_default_size));
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.setting_seekbar_tip_text_margin_bottom) + this.d;
        addView(this.g, layoutParams);
        a();
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final void setMax(int i) {
        this.h = i;
        this.i = this.c / i;
    }

    public final void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > this.h) {
            i = this.h;
        }
        a(i, false);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case 0:
                this.l = x;
                this.k = this.j;
                if (this.m != null) {
                    this.m.a();
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.m != null) {
                    this.m.b();
                    break;
                }
                break;
            case 2:
                a(((int) ((x - this.l) / ((float) this.i))) + this.k, true);
                break;
        }
        return true;
    }

    private void a(int i, boolean z) {
        this.j = i;
        if (this.j < 0) {
            this.j = 0;
        } else if (this.j > this.h) {
            this.j = this.h;
        }
        int i2 = this.i * this.j;
        this.f.setTranslationX((float) i2);
        this.g.setTranslationX((float) ((i2 + (this.d / 2)) - (((int) this.g.getPaint().measureText(this.g.getText().toString())) / 2)));
        if (this.m != null) {
            this.m.a(this.j, z);
        }
    }

    public final void setBarChangeListener(c cVar) {
        this.m = cVar;
    }

    public final void a() {
        this.b.setImageDrawable(com.ucpro.ui.c.a.a("setting_fontsize_bar_bg.svg"));
        this.f.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_switch_on.svg"));
        this.g.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
    }

    public final void setText(String str) {
        this.g.setText(str);
    }
}
