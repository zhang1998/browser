package com.ucpro.feature.privacymode.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.quark.browser.R;
import com.ucpro.feature.g.a.c;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public abstract class n extends ViewGroup {
    private LinearLayout a = new LinearLayout(getContext());
    public ATTextView b;
    public View c;
    Drawable d;
    public GradientDrawable e;
    private ATTextView f;
    private LinearLayout g;
    private ImageView h;
    private ATTextView i;
    private FrameLayout j;
    private ProgressBar k;
    private int l = a.c((int) R.dimen.privacymode_guide_margin_title);
    private int m = this.l;
    private DecelerateInterpolator n;

    protected abstract void a(boolean z);

    public n(Context context) {
        super(context);
        this.a.setOrientation(0);
        this.a.setGravity(16);
        this.f = new ATTextView(getContext());
        this.f.setText(a.d((int) R.string.privacymode_title));
        this.f.setTextSize(0, a.a((int) R.dimen.privacymode_title_text_size));
        this.f.setTextColor(a.c("privacymode_title_color"));
        this.f.setTypeface(null, 1);
        this.f.setGravity(16);
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(a.a("privacy_mode_beta.svg"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a.c((int) R.dimen.privacymode_title_text_size));
        layoutParams.leftMargin = a.c((int) R.dimen.privacymode_drawable_padding);
        this.a.addView(this.f);
        this.a.addView(imageView, layoutParams);
        addView(this.a);
        this.g = new LinearLayout(getContext());
        this.g.setOrientation(1);
        this.g.setGravity(17);
        this.h = new ImageView(getContext());
        this.h.setImageDrawable(a.a("privacy_mode_logo.svg"));
        this.i = new ATTextView(getContext());
        this.i.setTextColor(a.c("privacymode_title_color"));
        this.i.setTextSize(0, a.a((int) R.dimen.privacymode_guide_desc_text_size));
        this.i.setText(a.d((int) R.string.privacymode_guide_desc));
        this.g.addView(this.h);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = a.c((int) R.dimen.privacymode_guide_desc_margintop);
        this.g.addView(this.i, layoutParams2);
        imageView = new ATTextView(getContext());
        imageView.setTextColor(a.c("privacymode_title_color"));
        imageView.setTextSize(0, a.a((int) R.dimen.privacymode_guide_desc_text_size));
        imageView.setText(a.d((int) R.string.privacymode_guide_desc2));
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = a.c((int) R.dimen.privacymode_guide_desc2_margintop);
        this.g.addView(imageView, layoutParams);
        addView(this.g);
        this.j = new FrameLayout(getContext());
        this.b = new ATTextView(getContext());
        this.b.setTextSize(0, a.a((int) R.dimen.privacymode_guide_enter_text_size));
        this.b.setTextColor(a.c("privacymode_guide_btn_text_color"));
        this.b.setText(a.d((int) R.string.privacymode_guide_btn_text));
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-2, a.c((int) R.dimen.privacymode_guide_enter_btn_height)));
        this.b.setGravity(17);
        this.b.setClickable(true);
        int c = a.c((int) R.dimen.privacymode_guide_enter_btn_radius);
        this.b.setPadding(c, 0, c, 0);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) c);
        gradientDrawable.setColor(a.c("privacymode_guide_btn_bg"));
        Drawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius((float) c);
        gradientDrawable2.setColor(a.c("privacymode_guide_btn_press_bg"));
        this.d = c.a(gradientDrawable, gradientDrawable2);
        this.e = new GradientDrawable();
        this.e.setCornerRadius((float) c);
        this.e.setColor(a.c("privacymode_guide_btn_error_bg"));
        this.b.setBackgroundDrawable(this.d);
        this.b.setVisibility(4);
        this.j.addView(this.b);
        this.c = LayoutInflater.from(getContext()).inflate(R.layout.privacy_mode_progress, null);
        this.k = (ProgressBar) this.c.findViewById(R.id.progress);
        ATTextView aTTextView = (ATTextView) this.c.findViewById(R.id.pm_tv_title);
        aTTextView.setTextSize(0, a.a((int) R.dimen.privacymode_guide_enter_text_size));
        aTTextView.setTextColor(a.c("privacymode_guide_btn_text_color"));
        aTTextView.setText(a.d((int) R.string.privacymode_guide_btn_loading));
        this.i = (ATTextView) this.c.findViewById(R.id.pm_tv_desc);
        this.i.setTextSize(0, a.a((int) R.dimen.privacymode_guide_progress_desc_text_size));
        this.i.setTextColor(a.c("privacymode_guide_desc_text_color"));
        this.j.addView(this.c, new FrameLayout.LayoutParams(-2, -2));
        this.b.setOnClickListener(new f(this));
        addView(this.j);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        this.a.measure(makeMeasureSpec, makeMeasureSpec2);
        this.g.measure(makeMeasureSpec, makeMeasureSpec2);
        this.j.measure(makeMeasureSpec, makeMeasureSpec2);
        setMeasuredDimension(Math.max(Math.max(this.a.getMeasuredWidth(), this.g.getMeasuredWidth()), this.j.getMeasuredWidth()), (((this.a.getMeasuredHeight() + this.g.getMeasuredHeight()) + this.j.getMeasuredHeight()) + this.m) + this.l);
    }

    public void setProgress(int i) {
        this.k.setProgress(i);
    }

    public void setProgressWithAnimation(int i) {
        if (this.n == null) {
            this.n = new DecelerateInterpolator();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.k, "progress", new int[]{this.k.getProgress(), i});
        ofInt.setDuration(1900);
        ofInt.setInterpolator(this.n);
        ofInt.start();
    }

    public void setProgressDesc(String str) {
        this.i.setText(str);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = (getWidth() / 2) - (this.a.getMeasuredWidth() / 2);
        int measuredWidth = this.a.getMeasuredWidth() + width;
        int measuredHeight = this.a.getMeasuredHeight();
        this.a.layout(width, 0, measuredWidth, measuredHeight);
        width = (getWidth() / 2) - (this.g.getMeasuredWidth() / 2);
        measuredWidth = this.l + measuredHeight;
        int measuredHeight2 = this.g.getMeasuredHeight() + measuredWidth;
        this.g.layout(width, measuredWidth, this.g.getMeasuredWidth() + width, measuredHeight2);
        width = (getWidth() / 2) - (this.j.getMeasuredWidth() / 2);
        measuredWidth = this.l + measuredHeight2;
        this.j.layout(width, measuredWidth, this.j.getMeasuredWidth() + width, this.j.getMeasuredHeight() + measuredWidth);
    }
}
