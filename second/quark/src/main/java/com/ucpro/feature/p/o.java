package com.ucpro.feature.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.animation.a.a;
import com.ucpro.ui.animation.a.b;

/* compiled from: ProGuard */
public final class o extends RelativeLayout implements s {
    View a = new View(getContext());
    m b;
    r c;
    AnimatorSet d;
    boolean e;
    boolean f = false;
    private AnimatorSet g;

    static /* synthetic */ void d(o oVar) {
        if (oVar.d == null) {
            oVar.d = new AnimatorSet();
        }
        ObjectAnimator.ofFloat(oVar.a, "alpha", new float[]{oVar.a.getAlpha(), IPictureView.DEFAULT_MIN_SCALE}).setDuration(300);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(oVar.c, "translationY", new float[]{oVar.c.getTranslationY(), 0.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new a());
        oVar.d.playTogether(new Animator[]{r0, ofFloat});
        oVar.d.start();
    }

    public o(Context context) {
        super(context);
        this.a.setAlpha(0.0f);
        addView(this.a);
        this.c = new r(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(com.ucpro.ui.c.a.c((int) R.dimen.mainmenu_margin_x), 0, com.ucpro.ui.c.a.c((int) R.dimen.mainmenu_margin_x), com.ucpro.ui.c.a.c((int) R.dimen.mainmenu_margin_bottom));
        addView(this.c, layoutParams);
        setOnClickListener(new a(this));
        this.a.setBackgroundColor(com.ucpro.ui.c.a.c("main_menu_bg_color"));
        this.c.a();
    }

    public final void a(String str, boolean z) {
        int i;
        if (this.g == null || !this.g.isRunning()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            if (this.d != null && this.d.isRunning()) {
                this.d.cancel();
            }
            if (this.b != null) {
                this.b.a(str);
            }
            if (z) {
                if (this.g == null) {
                    this.g = new AnimatorSet();
                    this.g.addListener(new p(this));
                }
                ObjectAnimator.ofFloat(this.a, "alpha", new float[]{this.a.getAlpha(), 0.0f}).setDuration(300);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationY", new float[]{this.c.getTranslationY(), (float) this.c.getContentHeight()});
                ofFloat.setInterpolator(new b());
                ofFloat.setDuration(300);
                this.g.playTogether(new Animator[]{r0, ofFloat});
                this.g.start();
                return;
            }
            setVisibility(8);
        }
    }

    public final void a(g gVar) {
        r rVar = this.c;
        if (rVar.b == null) {
            rVar.b = rVar.a(gVar);
        }
        rVar.b();
        rVar.a();
        if (rVar.a != null && rVar.b != null) {
            rVar.a.setVisibility(8);
            rVar.a.a(false, rVar.c);
            rVar.b.setVisibility(0);
            rVar.b.getFirstRow().setTranslationY((float) (-rVar.d));
            rVar.b.getFirstRow().animate().translationY(0.0f).setDuration((long) rVar.c).setInterpolator(rVar.e).start();
            rVar.b.getSecondRow().setTranslationY((float) (-rVar.d));
            rVar.b.getSecondRow().animate().translationY(0.0f).setDuration((long) rVar.c).setInterpolator(rVar.e).start();
            rVar.b.getLeftImage().setTranslationY((float) rVar.d);
            rVar.b.getLeftImage().animate().translationY(0.0f).setDuration((long) rVar.c).setInterpolator(rVar.e).start();
        }
    }

    public final void a() {
        r rVar = this.c;
        if (rVar.a != null && rVar.b != null) {
            rVar.b.setVisibility(8);
            rVar.a.setVisibility(0);
            rVar.a.getFirstRow().setTranslationY((float) rVar.d);
            rVar.a.getFirstRow().animate().translationY(0.0f).setDuration((long) rVar.c).setInterpolator(rVar.e).start();
            rVar.a.getSecondRow().setTranslationY((float) rVar.d);
            rVar.a.getSecondRow().animate().translationY(0.0f).setDuration((long) rVar.c).setInterpolator(rVar.e).start();
            rVar.a.getLeftImage().setTranslationY((float) (-rVar.d));
            rVar.a.getLeftImage().animate().translationY(0.0f).setDuration((long) rVar.c).setInterpolator(rVar.e).start();
            rVar.a.a(true, rVar.c);
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        a("back_key", true);
        return true;
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.b = (m) bVar;
        this.c.setOnItemClickListener(new d(this));
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    static /* synthetic */ void c(o oVar) {
        if (oVar.g != null && oVar.g.isRunning()) {
            oVar.g.cancel();
        }
    }
}
