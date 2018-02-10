package com.ucpro.feature.z.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.s;

/* compiled from: ProGuard */
public final class j extends ViewGroup implements OnClickListener {
    public boolean a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private TextView f;
    private View g = new View(getContext());
    private s h;
    private a i;
    private AnimatorSet j;
    private AnimatorSet k;
    private int l;
    private int m;
    private int n;

    public j(Context context, String str, String str2, String str3, String str4) {
        super(context);
        this.e = str;
        this.d = str2;
        this.c = str3;
        this.b = str4;
        this.g.setOnClickListener(this);
        addView(this.g);
        this.f = new TextView(getContext());
        this.f.setTextSize(12.0f);
        this.f.setGravity(16);
        this.f.setSingleLine();
        int c = a.c((int) R.dimen.expandable_button_text_padding_right);
        this.n = a.c((int) R.dimen.expandable_button_text_and_icon_interset_width);
        this.f.setPadding(0, 0, c, 0);
        this.f.setText(this.b);
        this.f.setOnClickListener(this);
        addView(this.f);
        this.h = new s();
        a();
    }

    public final void setListener(a aVar) {
        this.i = aVar;
    }

    public final void setTextSize(int i) {
        this.f.setTextSize(0, (float) i);
    }

    public final void setExpanded(boolean z) {
        int i;
        if ((this.k == null || !this.k.isRunning()) && (this.j == null || !this.j.isRunning())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0 && this.a != z) {
            this.a = z;
            ValueAnimator ofFloat;
            ValueAnimator ofFloat2;
            if (this.a) {
                this.k = new AnimatorSet();
                float translationX = this.g.getTranslationX();
                float left = (float) (0 - this.g.getLeft());
                ofFloat = ValueAnimator.ofFloat(new float[]{translationX, left});
                ofFloat.setDuration(350);
                ofFloat.setInterpolator(new b());
                ofFloat.addUpdateListener(new d(this));
                left = this.f.getTranslationX();
                float left2 = (float) ((0 - this.g.getLeft()) - this.n);
                ofFloat2 = ValueAnimator.ofFloat(new float[]{left, left2});
                ofFloat2.setDuration(350);
                ofFloat2.setInterpolator(new b());
                ofFloat2.addUpdateListener(new c(this));
                this.k.playTogether(new Animator[]{ofFloat, ofFloat2});
                this.k.start();
                return;
            }
            this.j = new AnimatorSet();
            ofFloat = ValueAnimator.ofFloat(new float[]{this.g.getTranslationX(), 0.0f});
            ofFloat.setDuration(350);
            ofFloat.setInterpolator(new b());
            ofFloat.addUpdateListener(new p(this));
            ofFloat2 = ValueAnimator.ofFloat(new float[]{this.f.getTranslationX(), 0.0f});
            ofFloat2.setDuration(350);
            ofFloat2.setInterpolator(new b());
            ofFloat2.addUpdateListener(new k(this));
            this.j.playTogether(new Animator[]{ofFloat, ofFloat2});
            this.j.start();
        }
    }

    public final void a() {
        Drawable a = a.a(this.e);
        if (a != null) {
            this.l = a.getIntrinsicWidth();
            this.m = a.getIntrinsicHeight();
        }
        this.g.setBackgroundDrawable(a);
        this.f.setTextColor(a.c(this.c));
        s sVar = this.h;
        sVar.a.setColor(a.c(this.d));
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.g.measure(MeasureSpec.makeMeasureSpec(this.l, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.m, UCCore.VERIFY_POLICY_QUICK));
        this.f.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(this.g.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        setMeasuredDimension(this.g.getMeasuredWidth() + this.f.getMeasuredWidth(), this.g.getMeasuredHeight());
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        this.g.layout(width - this.g.getMeasuredWidth(), 0, width, this.g.getMeasuredHeight() + 0);
        width = this.g.getRight();
        this.f.layout(width, 0, this.f.getMeasuredWidth() + width, getHeight() + 0);
    }

    public final void onClick(View view) {
        if (view == this.g) {
            if (this.a) {
                b();
            } else {
                setExpanded(true);
            }
        } else if (view == this.f) {
            b();
        }
    }

    private void b() {
        if (this.i != null) {
            this.i.a();
        }
    }

    protected final void dispatchDraw(Canvas canvas) {
        this.h.setBounds(Math.round(((float) this.g.getLeft()) + this.g.getTranslationX()), 0, getWidth(), getHeight());
        this.h.draw(canvas);
        super.dispatchDraw(canvas);
    }
}
