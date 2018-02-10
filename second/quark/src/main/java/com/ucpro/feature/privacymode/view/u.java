package com.ucpro.feature.privacymode.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class u extends FrameLayout {
    private a a = new a(getContext());
    private CircleProgressBar b = new CircleProgressBar(getContext(), null);
    private ATTextView c;
    private ATTextView d;
    private ATTextView e;
    private ATTextView f;
    private FrameLayout g;
    private ImageView h;
    private q i;
    private LinearLayout j;

    public final void setOnPrivacyClick(q qVar) {
        this.i = qVar;
    }

    public u(Context context) {
        super(context);
        this.b.setBackgroundColor(a.c("privacymode_progress_bg_color"));
        this.b.setBackgroundProgressBarWidth(getResources().getDimension(R.dimen.default_background_stroke_width));
        this.b.setProgressBarWidth(getResources().getDimension(R.dimen.default_stroke_width));
        this.b.setColor(a.c("privacymode_progress_stroke_color"));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(this.a.getRadius() * 2, this.a.getRadius() * 2);
        layoutParams.topMargin = this.a.getCircleY() - this.a.getRadius();
        layoutParams.leftMargin = this.a.getCircleX() - this.a.getRadius();
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.c = new ATTextView(getContext());
        this.c.setText(a.d((int) R.string.privacymode_title));
        this.c.setTextSize(0, a.a((int) R.dimen.privacymode_title_text_size));
        this.c.setTextColor(a.c("privacymode_title_color"));
        this.c.setTypeface(null, 1);
        this.c.setGravity(16);
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(a.a("privacy_mode_beta.svg"));
        linearLayout.addView(this.c);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, a.c((int) R.dimen.privacymode_title_text_size));
        layoutParams2.leftMargin = a.c((int) R.dimen.privacymode_drawable_padding);
        linearLayout.addView(imageView, layoutParams2);
        LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.topMargin = a.c((int) R.dimen.privacymode_title_text_margintop);
        this.g = new FrameLayout(getContext());
        this.h = new ImageView(getContext());
        this.h.setImageDrawable(a.a("privacy_mode_camera_close.svg"));
        int c = a.c((int) R.dimen.privacymode_close_icon_real_size);
        LayoutParams layoutParams4 = new FrameLayout.LayoutParams(c, c);
        layoutParams4.gravity = 17;
        this.g.addView(this.h, layoutParams4);
        this.g.setOnClickListener(new l(this));
        c = a.c((int) R.dimen.privacymode_close_icon_size);
        layoutParams4 = new FrameLayout.LayoutParams(c, c);
        layoutParams4.topMargin = a.c((int) R.dimen.privacymode_close_icon_margintop);
        this.d = new ATTextView(getContext());
        this.d.setText(a.d((int) R.string.privacymode_register_tips));
        this.d.setTextSize(0, a.a((int) R.dimen.privacymode_tips_text_size));
        this.d.setTextColor(a.c("privacymode_title_color"));
        this.d.setTypeface(null, 1);
        layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (this.a.getCircleY() + this.a.getRadius()) + a.c((int) R.dimen.privacymode_tips_margintop);
        this.e = new ATTextView(getContext());
        this.e.setText(a.d((int) R.string.privacymode_brand_tips));
        this.e.setTextSize(0, a.a((int) R.dimen.privacymode_brand_textsize));
        this.e.setTextColor(a.c("privacymode_brand_color"));
        this.e.setTypeface(null, 1);
        LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 1;
        layoutParams5.topMargin = ((this.a.getCircleY() + this.a.getRadius()) + a.c((int) R.dimen.privacymode_tips_margintop)) + a.c((int) R.dimen.privacymode_brand_text_margintop);
        this.j = new LinearLayout(getContext());
        this.j.setOrientation(0);
        this.j.setGravity(16);
        this.f = new ATTextView(getContext());
        this.f.setText(a.d((int) R.string.privacymode_password_title));
        this.f.setTextSize(0, a.a((int) R.dimen.privacymode_other_text_size));
        this.f.setTextColor(a.c("privacymode_title_color"));
        this.f.setTypeface(null, 1);
        this.f.setGravity(16);
        View imageView2 = new ImageView(getContext());
        imageView2.setImageDrawable(a.a("privacy_mode_keyboard.svg"));
        this.j.addView(imageView2, new LayoutParams(-2, a.c((int) R.dimen.privacymode_other_text_size)));
        LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = a.c((int) R.dimen.privacymode_other_drawable_padding);
        this.j.addView(this.f, layoutParams6);
        this.f.setOnClickListener(new j(this));
        layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 81;
        layoutParams6.bottomMargin = a.c((int) R.dimen.privacymode_other_marginbottom);
        addView(this.a, new LayoutParams(-1, -1));
        addView(this.b, layoutParams);
        addView(linearLayout, layoutParams3);
        addView(this.g, layoutParams4);
        addView(this.d, layoutParams2);
        addView(this.e, layoutParams5);
        addView(this.j, layoutParams6);
    }

    public final void a(boolean z) {
        this.j.setVisibility(z ? 0 : 8);
    }

    public final void setProgressWithAnimation(int i) {
        this.b.a((float) i, 0);
    }

    public final Rect getRect() {
        return new Rect(this.a.getCircleX() - this.a.getRadius(), this.a.getCircleY() - this.a.getRadius(), this.a.getCircleX() + this.a.getRadius(), this.a.getCircleY() + this.a.getRadius());
    }

    public final void setBitmap(Bitmap bitmap) {
        this.h.setImageBitmap(bitmap);
    }

    public final void setTextViewTips(String str) {
        if (!com.ucweb.common.util.n.a.a(str)) {
            this.d.setText(str);
        }
    }
}
