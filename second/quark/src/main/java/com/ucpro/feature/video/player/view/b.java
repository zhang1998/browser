package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class b extends FrameLayout {
    private RelativeLayout a;
    private ImageView b;
    private ImageView c;
    private int d;
    private int e;
    private int f;
    private int g;
    private ImageView h;
    private int i;
    private float j;
    private int k;
    private int l;
    private float m;
    private boolean n;
    private n o;
    private boolean p;

    public b(Context context) {
        this(context, true);
    }

    public b(Context context, boolean z) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = 0;
        this.j = 0.0f;
        this.k = 0;
        this.l = 0;
        this.m = 0.0f;
        this.n = true;
        this.o = null;
        this.p = true;
        this.f = a.c((int) R.dimen.player_seek_bar_indicator_width);
        this.e = a.c((int) R.dimen.player_seek_bar_indicator_height);
        this.g = -a.c((int) R.dimen.player_seek_bar_indicator_translatex);
        int c = a.c((int) R.dimen.player_seek_bar_height);
        this.a = new RelativeLayout(getContext());
        this.b = new ImageView(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c);
        layoutParams.addRule(15);
        this.a.addView(this.b, layoutParams);
        this.c = new ImageView(getContext());
        layoutParams = new RelativeLayout.LayoutParams(-1, c);
        layoutParams.addRule(15);
        this.a.addView(this.c, layoutParams);
        this.h = new ImageView(getContext());
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f, this.e);
        layoutParams2.addRule(15);
        this.h.setX((float) this.g);
        this.a.addView(this.h, layoutParams2);
        layoutParams2 = new FrameLayout.LayoutParams(-1, this.e);
        layoutParams2.gravity = 81;
        addView(this.a, layoutParams2);
        this.b.setImageDrawable(a.a("new_video_seekbar_duration_bg.xml"));
        this.c.setBackgroundColor(-2215374);
        this.h.setImageDrawable(a.a("new_video_exit_seekbar_indicator.svg"));
        this.p = z;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.j = ((float) ((this.d - this.f) - this.g)) / ((float) this.i);
        this.c.setX(-(((float) this.d) - this.h.getX()));
    }

    public final void setMax(int i) {
        this.i = i;
        this.j = ((float) ((this.d - this.f) - this.g)) / ((float) i);
        this.c.setX(-(((float) this.d) - this.h.getX()));
    }

    public final void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > this.i) {
            i = this.i;
        }
        a(i, false);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.n) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (this.p) {
            switch (action) {
                case 0:
                    this.m = x;
                    this.l = this.k;
                    if (this.o == null) {
                        return true;
                    }
                    this.o.a();
                    return true;
                case 1:
                case 3:
                    if (Math.abs(x - this.m) <= 10.0f) {
                        float x2 = this.h.getX();
                        a(((int) ((this.m - x2) / this.j)) + this.l, true);
                    }
                    if (this.o == null) {
                        return true;
                    }
                    this.o.b();
                    return true;
                case 2:
                    a(((int) ((x - this.m) / this.j)) + this.l, true);
                    return true;
                default:
                    return true;
            }
        }
        switch (action) {
            case 0:
                this.m = x;
                this.l = this.k;
                return true;
            case 1:
            case 3:
                if (this.o != null) {
                    this.o.a();
                }
                if (Math.abs(x - this.m) <= 10.0f) {
                    x2 = this.h.getX();
                    a(((int) ((this.m - x2) / this.j)) + this.l, true);
                }
                if (this.o == null) {
                    return true;
                }
                this.o.b();
                return true;
            case 2:
                return true;
            default:
                return true;
        }
    }

    private void a(int i, boolean z) {
        this.k = i;
        if (this.k < 0) {
            this.k = 0;
        } else if (this.k > this.i) {
            this.k = this.i;
            if (z) {
                this.k = this.i - 1;
            }
        }
        this.h.setX((float) (((int) (this.j * ((float) this.k))) + this.g));
        this.c.setX(-(((float) this.d) - this.h.getX()));
        if (this.o != null) {
            this.o.a(this.k, z);
        }
    }

    public final void setBarChangeListener(n nVar) {
        this.o = nVar;
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.n = z;
    }

    public final int getProgress() {
        return this.k;
    }
}
