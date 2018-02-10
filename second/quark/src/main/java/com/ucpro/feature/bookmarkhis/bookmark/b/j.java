package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class j extends LinearLayout implements OnClickListener {
    private ValueAnimator a;
    private ValueAnimator b;
    private Context c;
    private View d = new View(this.c);
    private View e;
    private ATTextView f;
    private ATTextView g;
    private ATTextView h;
    private ATTextView i;
    private FrameLayout j;
    private ATTextView k;
    private d l;

    public j(Context context) {
        super(context);
        this.c = context;
        setOrientation(1);
        this.d.setLayoutParams(new LayoutParams(-1, 1));
        this.d.setBackgroundColor(a.c("default_cutting_line"));
        addView(this.d);
        this.e = LayoutInflater.from(this.c).inflate(R.layout.bookmark_toolbar, null, false);
        this.f = (ATTextView) this.e.findViewById(R.id.bm_tv_1);
        this.g = (ATTextView) this.e.findViewById(R.id.bm_tv_2);
        this.h = (ATTextView) this.e.findViewById(R.id.bm_tv_3);
        this.i = (ATTextView) this.e.findViewById(R.id.bm_tv_4);
        this.j = (FrameLayout) this.e.findViewById(R.id.bm_fl);
        this.k = (ATTextView) this.e.findViewById(R.id.bm_tv_5);
        this.f.setBackgroundDrawable(a.c());
        this.g.setBackgroundDrawable(a.c());
        this.h.setBackgroundDrawable(a.c());
        this.i.setBackgroundDrawable(a.c());
        this.j.setBackgroundDrawable(a.c());
        addView(this.e);
        a(o.a, false);
        a(o.b, false);
        a(o.c, false);
        a(o.d, true);
        a(o.e, true);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        a();
        setVisibility(8);
    }

    public final void a() {
        this.e.setBackgroundColor(a.c("default_background_white"));
        this.f.setTextColor(a.c("default_maintext_gray"));
        this.g.setTextColor(a.c("default_maintext_gray"));
        this.h.setTextColor(a.c("default_maintext_gray"));
        this.i.setTextColor(a.c("default_maintext_gray"));
        this.k.setTextColor(a.c("default_maintext_gray"));
    }

    public final void setToolbarBackgroundColor(int i) {
        this.e.setBackgroundColor(i);
    }

    public final void setTextViewColor(int i) {
        this.f.setTextColor(i);
        this.g.setTextColor(i);
        this.h.setTextColor(i);
        this.i.setTextColor(i);
        this.k.setTextColor(i);
    }

    public final void a(int i, boolean z) {
        float f = z ? IPictureView.DEFAULT_MIN_SCALE : 0.3f;
        if (i == o.a) {
            this.f.setClickable(z);
            this.f.setAlpha(f);
        } else if (i == o.b) {
            this.g.setClickable(z);
            this.g.setAlpha(f);
        } else if (i == o.c) {
            this.h.setClickable(z);
            this.h.setAlpha(f);
        } else if (i == o.d) {
            this.i.setClickable(z);
            this.i.setAlpha(f);
        } else if (i == o.e) {
            this.j.setClickable(z);
            this.j.setAlpha(f);
        }
    }

    public final ATTextView a(int i) {
        if (i == o.a) {
            return this.f;
        }
        if (i == o.b) {
            return this.g;
        }
        if (i == o.c) {
            return this.h;
        }
        if (i == o.d) {
            return this.i;
        }
        if (i == o.e) {
            return this.k;
        }
        return null;
    }

    private void setVisibility(boolean z) {
        int i = 8;
        int i2 = z ? 8 : 0;
        this.f.setVisibility(i2);
        this.g.setVisibility(i2);
        this.h.setVisibility(i2);
        this.i.setVisibility(i2);
        FrameLayout frameLayout = this.j;
        if (i2 != 0) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    public final void b() {
        setVisibility(0);
        d();
        float a = a.a((int) R.dimen.common_bottom_titlebar_height);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.setDuration(200);
        ofFloat.addUpdateListener(new g(this, a));
        this.a = ofFloat;
        ofFloat.start();
    }

    private void d() {
        if (this.a != null && this.a.isRunning()) {
            this.a.cancel();
        }
        if (this.b != null && this.b.isRunning()) {
            this.b.cancel();
        }
    }

    protected static void a(View view, float f) {
        if (view != null && view.getVisibility() == 0) {
            view.setTranslationY(f);
        }
    }

    public final void c() {
        d();
        float a = a.a((int) R.dimen.common_bottom_titlebar_height);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.setDuration(200);
        ofFloat.addUpdateListener(new e(this, a));
        ofFloat.addListener(new i(this));
        this.b = ofFloat;
        ofFloat.start();
    }

    public final void onClick(View view) {
        if (this.l != null) {
            int i = o.e;
            switch (view.getId()) {
                case R.id.bm_tv_1:
                    i = o.a;
                    break;
                case R.id.bm_tv_2:
                    i = o.b;
                    break;
                case R.id.bm_tv_3:
                    i = o.c;
                    break;
                case R.id.bm_tv_4:
                    i = o.d;
                    break;
                case R.id.bm_fl:
                    i = o.e;
                    break;
            }
            this.l.a(i);
        }
    }

    public final void setOnClick(d dVar) {
        this.l = dVar;
    }
}
