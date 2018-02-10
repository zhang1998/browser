package com.ucpro.feature.webwindow;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class af {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private VelocityTracker E;
    bp a;
    aq b;
    boolean c;
    private final Context d;
    private final int e;
    private final int f;
    private bi g;
    private w h;
    private Rect i = new Rect();
    private Rect j = new Rect();
    private int k;
    private final int l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public af(Context context) {
        this.d = context;
        this.m = a.b((int) R.dimen.webpage_gesture_max_horizontal_drag_dist);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.d);
        this.p = (float) viewConfiguration.getScaledTouchSlop();
        this.l = a.c((int) R.dimen.quit_gesture_max_drag_dist);
        this.E = VelocityTracker.obtain();
        this.e = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f = viewConfiguration.getScaledMinimumFlingVelocity();
        this.C = true;
        this.D = true;
    }

    public final void a(MotionEvent motionEvent) {
        float f = 0.0f;
        boolean z = true;
        this.E.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.k = 0;
                this.a.a().getHitRect(this.i);
                this.a.b().getHitRect(this.j);
                this.t = 0.0f;
                if (this.i.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.v = true;
                } else if (this.j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.w = true;
                }
                this.n = motionEvent.getX();
                this.o = motionEvent.getY();
                return;
            case 1:
            case 3:
            case 4:
                this.u = false;
                b();
                return;
            case 2:
                if (!this.u) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f2 = x - this.n;
                    float f3 = y - this.o;
                    if (this.C && this.v && !this.x && !this.a.c() && !this.a.d() && Math.abs(f2) > this.p && Math.abs(f2) > Math.abs(f3) * 2.0f) {
                        this.x = true;
                        this.q = x;
                        this.r = y;
                        if (x >= this.n) {
                            z = false;
                        }
                        this.B = z;
                        this.z = this.a.e();
                        this.A = this.a.f();
                        if (this.g == null) {
                            this.g = new bi(this.d);
                            this.a.a(this.g);
                        }
                        this.g.setLeftIndicatorVisible(this.z);
                        this.g.setRightIndicatorVisible(this.A);
                    } else if (this.D && this.w && !this.y && Math.abs(f3) > this.p && Math.abs(f3) > Math.abs(f2) * 2.0f) {
                        this.q = x;
                        this.r = y;
                        this.y = true;
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        this.a.a(obtain);
                        if (this.c) {
                            if (this.h == null) {
                                this.h = new w(this.d);
                                this.a.a(this.h);
                            }
                            w wVar = this.h;
                            wVar.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                            wVar.a.setTranslationY(0.0f);
                            wVar.setBottomClipY(wVar.getHeight());
                            this.h.setBottomClipY(this.a.b().getTop());
                        }
                    }
                    if (this.x) {
                        this.s = Math.abs(x - this.q);
                        if (this.B) {
                            this.s = x > this.q ? 0.0f : this.s;
                        } else {
                            if (x >= this.q) {
                                f = this.s;
                            }
                            this.s = f;
                        }
                        float f4 = this.s;
                        if (this.B) {
                            f4 = (-f4) / this.m;
                        } else {
                            f4 /= this.m;
                        }
                        f4 = Math.max(-1.0f, Math.min(IPictureView.DEFAULT_MIN_SCALE, f4));
                        this.t = f4;
                        this.g.setDragProgress(f4);
                        return;
                    } else if (this.y) {
                        int round = Math.round(y - this.r);
                        if (this.h != null) {
                            this.h.setDragDist(round);
                        }
                        this.k = round;
                        if (this.b != null) {
                            this.b.a(round);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 5:
                if (!this.u) {
                    this.u = true;
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void b() {
        this.E.computeCurrentVelocity(1000, (float) this.e);
        float xVelocity = this.E.getXVelocity();
        this.E.clear();
        this.v = false;
        this.w = false;
        if (this.x && this.C) {
            a(xVelocity);
        } else if (this.y && this.D) {
            a(xVelocity);
            if (this.b != null) {
                this.b.e();
            }
        }
        this.k = 0;
        this.x = false;
        this.y = false;
    }

    private void a(float f) {
        if ((this.t == IPictureView.DEFAULT_MIN_SCALE || (this.t > 0.0f && f > ((float) this.f))) && this.z) {
            if (this.b != null) {
                this.b.a();
            }
            if (this.g != null) {
                this.g.b();
            }
        } else if ((this.t == -1.0f || (this.t < 0.0f && f < ((float) (-this.f)))) && this.A) {
            if (this.b != null) {
                this.b.b();
            }
            if (this.g != null) {
                this.g.b();
            }
        } else if (this.g != null) {
            bi biVar = this.g;
            if (biVar.a.getTranslationX() != ((float) biVar.c)) {
                bi.a(biVar.a, biVar.a.getTranslationX(), (float) biVar.c);
            }
            if (biVar.b.getTranslationX() != ((float) biVar.d)) {
                bi.a(biVar.b, biVar.b.getTranslationX(), (float) biVar.d);
            }
        }
        if (this.h != null) {
            if (this.h.b() && this.b != null) {
                this.b.c();
            }
            w wVar = this.h;
            if (wVar.a.getAlpha() != 0.0f) {
                if (wVar.b()) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(wVar.a, "alpha", new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
                    ofFloat.setDuration(250);
                    ofFloat.addListener(new z(wVar));
                    ofFloat.start();
                } else if (wVar.a.getTranslationY() != 0.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(wVar.a, "translationY", new float[]{wVar.a.getTranslationY(), 0.0f});
                    ofFloat2.setDuration(250);
                    ofFloat2.start();
                }
            }
        } else if (Math.abs(this.k) > this.l && this.b != null) {
            this.b.d();
        }
        this.t = 0.0f;
    }

    public final void a() {
        if (this.h != null) {
            this.h.a();
        }
        if (this.g != null) {
            this.g.a();
        }
    }
}
