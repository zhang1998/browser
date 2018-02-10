package com.ucpro.base.c.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.feature.i.h;
import com.ui.edittext.c;
import com.ui.edittext.d;

/* compiled from: ProGuard */
public abstract class g extends ViewGroup implements d {
    private static v e;
    private static int i = 1;
    public View a;
    public c b;
    protected Rect c = new Rect();
    protected f d = new f();
    private final FrameLayout f;
    private q g;
    private int h;

    public static void setStatusBarFactory(v vVar) {
        e = vVar;
    }

    public g(Context context) {
        super(context);
        int i = i;
        i = i + 1;
        setID(i);
        this.f = new FrameLayout(context);
        addView(this.f);
        if (e != null) {
            this.a = e.a(getContext());
            if (this.a != null) {
                addView(this.a, this.a.getLayoutParams().width, this.a.getLayoutParams().height);
            }
        }
    }

    public final void b(boolean z) {
        if (this.a != null && this.a.getVisibility() == 0) {
            if (z) {
                this.a.animate().cancel();
                this.a.animate().alpha(0.0f).setDuration(300).start();
                return;
            }
            this.a.setAlpha(0.0f);
        }
    }

    public void f() {
        if (this.a != null && this.a.getVisibility() != 8) {
            this.a.setVisibility(8);
        }
    }

    public void setID(int i) {
        this.h = i;
    }

    public int getID() {
        return this.h;
    }

    public void setWindowCallBacks(c cVar) {
        this.b = cVar;
        getWindowSwipeHelper().b = this.b;
    }

    private q getWindowSwipeHelper() {
        if (this.g == null) {
            this.g = new q(this);
        }
        return this.g;
    }

    public void setTransparent(boolean z) {
        this.d.a = z;
    }

    public final boolean g() {
        return this.d.a;
    }

    public void setWindowTransparent(boolean z) {
        this.d.b = z;
    }

    public Bitmap getIcon() {
        return null;
    }

    public void setIcon(Bitmap bitmap) {
    }

    public void setSingleTop(boolean z) {
        this.d.c = z;
    }

    public final boolean h() {
        return this.d.c;
    }

    public int getWindowType() {
        return this.d.i;
    }

    public void setWindowType(int i) {
        this.d.i = i;
    }

    public int getWindowClassId() {
        return this.d.j;
    }

    public void setWindowClassId(int i) {
        this.d.j = i;
    }

    public boolean getUseContextMenu() {
        return this.d.f;
    }

    public void setUseContextMenu(boolean z) {
        this.d.f = z;
    }

    public void setEnableBackground(boolean z) {
        this.d.d = z;
    }

    public void setEnableSwipeGesture(boolean z) {
        this.d.g = z;
    }

    public final boolean i() {
        return this.d.h;
    }

    public void setActAsAndroidWindow(boolean z) {
        this.d.e = z;
    }

    public void setAndroidWindowAnimation(int i) {
        this.d.k = i;
    }

    public void setOpenInBackground(boolean z) {
        this.d.q = z;
    }

    public final boolean j() {
        return this.d.q;
    }

    public Animation getPushAnimation() {
        return this.d.l;
    }

    public Animation getPopAnimation() {
        return this.d.n;
    }

    public Animation getUnderPushAnimation() {
        return this.d.m;
    }

    public Animation getUnderPopAnimation() {
        return this.d.o;
    }

    public void setPushAnimation(int i) {
        this.d.l = AnimationUtils.loadAnimation(getContext(), i);
    }

    public void setPopAnimation(int i) {
        this.d.n = AnimationUtils.loadAnimation(getContext(), i);
    }

    public void setUnderPushAnimation(int i) {
        this.d.m = AnimationUtils.loadAnimation(getContext(), i);
    }

    public void setUnderPopAnimation(int i) {
        this.d.o = AnimationUtils.loadAnimation(getContext(), i);
    }

    public String getTitle() {
        return null;
    }

    public void setPopAnimation(Animation animation) {
        this.d.n = animation;
    }

    public String getWindowNickName() {
        return this.d.p;
    }

    public void setWindowNickName(String str) {
        this.d.p = str;
    }

    protected String getWindowTag() {
        return getClass().getName();
    }

    public c getUICallbacks() {
        return this.b;
    }

    public void a(byte b) {
        if (b == (byte) 0 || b == (byte) 3) {
            this.d.h = true;
            this.d.d = true;
            invalidate();
        }
        if (b == (byte) 0 || b == (byte) 2) {
            scrollTo(0, 0);
        }
        if (b == (byte) 1 || b == (byte) 4) {
            this.d.h = false;
        }
        this.b.a(this, b);
    }

    public final void b(View view) {
        this.f.addView(view, -1, -1);
    }

    public final void c(View view) {
        this.f.removeView(view);
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            getDrawingRect(this.c);
            q qVar = this.g;
            if (qVar.p == p.a) {
                int scrollX = qVar.a.getScrollX();
                if (scrollX < 0) {
                    int i = (int) ((IPictureView.DEFAULT_MIN_SCALE - qVar.q) * 255.0f);
                    int measuredHeight = qVar.a.getMeasuredHeight();
                    if (qVar.c != null) {
                        canvas.save();
                        canvas.translate((float) scrollX, 0.0f);
                        canvas.clipRect(0, 0, -scrollX, measuredHeight);
                        if (qVar.c.getDrawingCache() != null) {
                            canvas.drawBitmap(qVar.c.getDrawingCache(), 0.0f, 0.0f, null);
                        } else {
                            qVar.c.draw(canvas);
                        }
                        qVar.t.setAlpha(i);
                        qVar.t.setBounds(0, 0, -scrollX, measuredHeight);
                        qVar.t.draw(canvas);
                        canvas.restore();
                    }
                    qVar.s.setAlpha(i);
                    qVar.s.setBounds(-qVar.r, 0, 0, measuredHeight);
                    qVar.s.draw(canvas);
                }
            }
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("Crash by " + getClass().getName(), th);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            return this.b.a(this, keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("Crash by " + getClass().getName(), th);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        if (this.d.h || !this.d.g) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        q qVar = this.g;
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            qVar.n = false;
            qVar.o = false;
            if (qVar.f == null) {
                return false;
            }
            qVar.f.recycle();
            qVar.f = null;
            return false;
        }
        if (action != 0) {
            if (qVar.n) {
                return true;
            }
            if (qVar.o) {
                return false;
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                qVar.k = x;
                qVar.l = y;
                qVar.m = x;
                if (qVar.g == 2) {
                    qVar.e.computeScrollOffset();
                    if (Math.abs(qVar.e.getFinalX() - qVar.e.getCurrX()) > qVar.j) {
                        if (!qVar.e.isFinished()) {
                            qVar.e.abortAnimation();
                        }
                        qVar.n = true;
                        qVar.g = 1;
                    } else {
                        qVar.b();
                        return false;
                    }
                }
                qVar.n = false;
                qVar.o = false;
                break;
            case 2:
                qVar.m = x;
                float f = x - qVar.k;
                float abs = Math.abs(f);
                float abs2 = Math.abs(y - qVar.l);
                if (f <= 0.0f) {
                    if (f < 0.0f) {
                        qVar.o = true;
                        break;
                    }
                } else if (qVar.a(qVar.a, false, (int) x, (int) y)) {
                    if (abs <= ((float) qVar.h) || 0.75f * abs <= abs2) {
                        if (abs2 > ((float) qVar.h)) {
                            qVar.o = true;
                            break;
                        }
                    }
                    qVar.a();
                    qVar.n = true;
                    qVar.g = 1;
                    break;
                } else {
                    qVar.o = true;
                    break;
                }
                break;
        }
        if (qVar.n && qVar.d != null) {
            qVar.d.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
        }
        if (qVar.f == null) {
            qVar.f = VelocityTracker.obtain();
        }
        qVar.f.addMovement(motionEvent);
        return qVar.n;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d.h || !this.d.g) {
            return super.onTouchEvent(motionEvent);
        }
        q qVar = this.g;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (qVar.f == null) {
            qVar.f = VelocityTracker.obtain();
        }
        qVar.f.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f;
        switch (action) {
            case 0:
                if (!qVar.e.isFinished()) {
                    qVar.e.abortAnimation();
                }
                qVar.k = x;
                qVar.l = y;
                qVar.m = x;
                break;
            case 1:
                if (qVar.n) {
                    f = x - qVar.k;
                    qVar.f.computeCurrentVelocity(1000, (float) qVar.i);
                    qVar.a(f, (int) qVar.f.getXVelocity(), false);
                    break;
                }
                break;
            case 2:
                float abs;
                if (!qVar.n) {
                    f = x - qVar.k;
                    abs = Math.abs(f);
                    y = Math.abs(y - qVar.l);
                    if (f > 0.0f && abs > ((float) qVar.h) && 0.75f * abs > y) {
                        qVar.m = x;
                        qVar.n = true;
                        qVar.g = 1;
                        qVar.a();
                    }
                }
                if (qVar.n) {
                    f = qVar.m - x;
                    qVar.m = x;
                    x = (float) qVar.a.getScrollX();
                    y = x + f;
                    abs = (float) (-qVar.a.getMeasuredWidth());
                    if (y > 0.0f) {
                        f = 0.0f - x;
                    } else if (y < abs) {
                        f = abs - x;
                    }
                    action = (int) f;
                    if (qVar.p != p.a) {
                        qVar.u = Math.abs(qVar.m - qVar.k) / ((float) qVar.a.getMeasuredWidth());
                    } else if (action != 0) {
                        qVar.a.scrollBy(action, 0);
                    }
                    qVar.a.invalidate();
                    break;
                }
                break;
            case 3:
                if (qVar.n) {
                    f = x - qVar.k;
                    qVar.f.computeCurrentVelocity(1000, (float) qVar.i);
                    qVar.a(f, (int) qVar.f.getXVelocity(), true);
                    break;
                }
                break;
        }
        return true;
    }

    public void bringChildToFront(View view) {
        throw new UnsupportedOperationException("Cannot adjust layer index.");
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
            if (this.a != null && this.a.getVisibility() == 0) {
                this.a.measure(i, MeasureSpec.makeMeasureSpec(this.a.getLayoutParams().height, UCCore.VERIFY_POLICY_QUICK));
            }
            int measuredHeight = getMeasuredHeight();
            if (this.a != null && this.a.getVisibility() == 0) {
                measuredHeight -= this.a.getMeasuredHeight();
            }
            this.f.measure(i, MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK));
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("Crash by " + getClass().getName(), th);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        try {
            if (this.a != null && this.a.getVisibility() == 0) {
                this.a.layout(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
            }
            if (this.a != null && this.a.getVisibility() == 0) {
                i5 = this.a.getHeight() + 0;
            }
            this.f.layout(0, i5, this.f.getMeasuredWidth() + 0, this.f.getMeasuredHeight() + i5);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("Crash by " + getClass().getName(), th);
        }
    }

    public void requestLayout() {
        super.requestLayout();
    }

    public void d() {
    }

    public void e() {
    }

    public final void a(c cVar, Object obj) {
    }

    public void k() {
    }

    public void l() {
        if (this.a != null) {
            com.ucweb.common.util.c.b(this.a instanceof h);
            ((h) this.a).a();
        }
    }

    public void c(boolean z) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.d.d) {
            this.d.d = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.d.h || !this.d.g) {
            super.computeScroll();
            return;
        }
        q qVar = this.g;
        if (qVar.p != p.a) {
            return;
        }
        if (qVar.e.computeScrollOffset()) {
            qVar.a.scrollTo(qVar.e.getCurrX(), qVar.e.getCurrY());
            qVar.a.postInvalidate();
        } else if (qVar.g == 2) {
            qVar.b();
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.d.h || !this.d.g) {
            super.onScrollChanged(i, i2, i3, i4);
            return;
        }
        q qVar = this.g;
        if (qVar.p == p.a) {
            qVar.q = ((float) Math.abs(i)) / ((float) qVar.a.getMeasuredWidth());
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.d.h || !this.d.g) {
            super.onSizeChanged(i, i2, i3, i4);
            return;
        }
        q qVar = this.g;
        if (qVar.p == p.a) {
            qVar.a(i, i2);
        }
    }
}
