package com.ucpro.feature.webwindow.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.d.d;

/* compiled from: ProGuard */
public final class c extends RelativeLayout {
    AnimatorSet a;
    private ImageView b;
    private ImageView c;
    private RelativeLayout d;
    private b e;
    private TextView f;
    private final int g;
    private boolean h = true;
    private boolean i;
    private long j;

    public c(Context context, int i) {
        super(context);
        this.g = i;
        this.d = new RelativeLayout(getContext());
        this.d.setAlpha(0.0f);
        this.d.setBackgroundColor(a.c("slide_up_guide_view_bg_color"));
        Drawable a = a.a("spread_tips.svg");
        this.c = new ImageView(getContext());
        this.c.setImageDrawable(a);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = a.c((int) R.dimen.slide_up_arrow_margin_bottom);
        this.d.addView(this.c, layoutParams);
        a = a.a("spread_tips.svg");
        this.b = new ImageView(getContext());
        this.b.setImageDrawable(a);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = a.c((int) R.dimen.slide_up_arrow_margin_bottom);
        this.d.addView(this.b, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = this.g;
        addView(this.d, layoutParams);
        this.f = new TextView(getContext());
        this.f.setGravity(17);
        if (d.c()) {
            this.f.setText(a.d((int) R.string.slide_up_to_home_for_flyme));
        } else {
            this.f.setText(a.d((int) R.string.slide_up_to_home));
        }
        this.f.setTextColor(a.c("slide_up_home_tip_color"));
        this.f.setTextSize(0, a.a((int) R.dimen.slide_up_tip_textsize));
        layoutParams = new RelativeLayout.LayoutParams(-1, this.g);
        layoutParams.addRule(12);
        addView(this.f, layoutParams);
    }

    public final void setListener(b bVar) {
        this.e = bVar;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h) {
            this.h = false;
            this.d.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(600).start();
            int i5 = -a.c((int) R.dimen.main_menu_guide_tip_arrow_margin_top);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationY", new float[]{0.0f, (float) i5});
            ofFloat.setDuration(800);
            ofFloat.setRepeatCount(20);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
            ofFloat2.setDuration(800);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(20);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
            this.a = animatorSet;
            this.f.setTranslationY((float) this.f.getHeight());
            this.f.animate().translationY(0.0f).setDuration(500).start();
            this.j = System.currentTimeMillis();
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.j == 0 || Math.abs(System.currentTimeMillis() - this.j) < 2000) {
            return true;
        }
        if (motionEvent.getAction() == 0 && !this.i && this.d.getAlpha() == IPictureView.DEFAULT_MIN_SCALE) {
            if (this.e != null) {
                this.e.a();
            }
            this.f.setVisibility(8);
            this.i = true;
            this.d.animate().cancel();
            this.d.animate().alpha(0.0f).setDuration(350).setListener(new e(this)).start();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
