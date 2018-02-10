package com.uc.weex.component.e;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.taobao.weex.bridge.c;
import com.taobao.weex.ui.view.l;
import com.uc.imagecodec.export.IPictureView;
import com.uc.weex.component.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class q extends l {
    boolean b = true;
    boolean c = false;
    n d;
    protected Rect e;
    private boolean f;
    private boolean g = true;
    private int h = 2;
    private int i = -1;
    private w j;
    private boolean k = true;
    private c l;

    public q(Context context, n nVar, r rVar) {
        super(context);
        this.d = nVar;
        this.e = new Rect();
        this.j = new w(this, rVar);
        setWillNotDraw(false);
    }

    public final String getName() {
        return this.d.b;
    }

    protected final void a(byte b, boolean z) {
        if (b == (byte) 0 || b == (byte) 3) {
            this.f = true;
            this.g = true;
            invalidate();
        }
        if (b == (byte) 0 || b == (byte) 2) {
            scrollTo(0, 0);
        }
        if (b == (byte) 1 || b == (byte) 4) {
            this.f = false;
        }
        if (this.l != null) {
            if (b == (byte) 1 || b == (byte) 2) {
                this.l.b(Integer.valueOf(0));
            } else if (b == (byte) 4 || b == (byte) 5) {
                this.l.a(Integer.valueOf(1));
            }
        }
        if (z) {
            Map hashMap = new HashMap();
            hashMap.put("name", this.d.b);
            if (b == (byte) 1 || b == (byte) 12) {
                hashMap.put("action", "push");
                this.d.getInstance().a("sceneAction", hashMap);
            } else if (b == (byte) 4 || b == (byte) 13) {
                hashMap.put("action", "pop");
                this.d.getInstance().a("sceneAction", hashMap);
            }
        }
    }

    public final void setAnimating(boolean z) {
        this.f = z;
    }

    public final void setEnableBackground(boolean z) {
        this.g = z;
    }

    public final void setTransparent(boolean z) {
        this.c = z;
    }

    public final int getPushAndPopLayerType() {
        return this.h;
    }

    public final void setPushAndPopLayerType(int i) {
        this.h = i;
    }

    public final void setEnableSwipeGesture(boolean z) {
        this.k = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (a()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        w wVar = this.j;
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            wVar.m = false;
            wVar.n = false;
            if (wVar.e == null) {
                return false;
            }
            wVar.e.recycle();
            wVar.e = null;
            return false;
        }
        if (action != 0) {
            if (wVar.m) {
                return true;
            }
            if (wVar.n) {
                return false;
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                wVar.j = x;
                wVar.k = y;
                wVar.l = x;
                if (wVar.f == 2) {
                    wVar.d.computeScrollOffset();
                    if (Math.abs(wVar.d.getFinalX() - wVar.d.getCurrX()) > wVar.i) {
                        if (!wVar.d.isFinished()) {
                            wVar.d.abortAnimation();
                        }
                        wVar.m = true;
                        wVar.f = 1;
                    } else {
                        wVar.b();
                        return false;
                    }
                }
                wVar.m = false;
                wVar.n = false;
                break;
            case 2:
                wVar.l = x;
                float f = x - wVar.j;
                float abs = Math.abs(f);
                float abs2 = Math.abs(y - wVar.k);
                if (f <= 0.0f) {
                    if (f < 0.0f) {
                        wVar.n = true;
                        break;
                    }
                } else if (wVar.a(wVar.a, false, (int) x, (int) y)) {
                    if (abs <= ((float) wVar.g) || 0.75f * abs <= abs2) {
                        if (abs2 > ((float) wVar.g)) {
                            wVar.n = true;
                            break;
                        }
                    }
                    wVar.a();
                    wVar.m = true;
                    wVar.f = 1;
                    break;
                } else {
                    wVar.n = true;
                    break;
                }
                break;
        }
        if (wVar.m && wVar.c != null) {
            wVar.c.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
        }
        if (wVar.e == null) {
            wVar.e = VelocityTracker.obtain();
        }
        wVar.e.addMovement(motionEvent);
        return wVar.m;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (a()) {
            return super.onTouchEvent(motionEvent);
        }
        w wVar = this.j;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (wVar.e == null) {
            wVar.e = VelocityTracker.obtain();
        }
        wVar.e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f;
        switch (action) {
            case 0:
                if (!wVar.d.isFinished()) {
                    wVar.d.abortAnimation();
                }
                wVar.j = x;
                wVar.k = y;
                wVar.l = x;
                break;
            case 1:
                if (wVar.m) {
                    f = x - wVar.j;
                    wVar.e.computeCurrentVelocity(1000, (float) wVar.h);
                    wVar.a(f, (int) wVar.e.getXVelocity(), false);
                    break;
                }
                break;
            case 2:
                float abs;
                if (!wVar.m) {
                    f = x - wVar.j;
                    abs = Math.abs(f);
                    y = Math.abs(y - wVar.k);
                    if (f > 0.0f && abs > ((float) wVar.g) && 0.75f * abs > y) {
                        wVar.l = x;
                        wVar.m = true;
                        wVar.f = 1;
                        wVar.a();
                    }
                }
                if (wVar.m) {
                    f = wVar.l - x;
                    wVar.l = x;
                    x = (float) wVar.a.getScrollX();
                    y = x + f;
                    abs = (float) (-wVar.a.getMeasuredWidth());
                    if (y > 0.0f) {
                        f = 0.0f - x;
                    } else if (y < abs) {
                        f = abs - x;
                    }
                    action = (int) f;
                    if (wVar.o != v.a) {
                        wVar.t = Math.abs(wVar.l - wVar.j) / ((float) wVar.a.getMeasuredWidth());
                    } else if (action != 0) {
                        wVar.a.scrollBy(action, 0);
                    }
                    wVar.a.invalidate();
                    break;
                }
                break;
            case 3:
                if (wVar.m) {
                    f = x - wVar.j;
                    wVar.e.computeCurrentVelocity(1000, (float) wVar.h);
                    wVar.a(f, (int) wVar.e.getXVelocity(), true);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean a() {
        if (this.f || !this.k) {
            return true;
        }
        if (this.b) {
            return false;
        }
        l lVar = (l) this.d.getParent();
        if (lVar == null || ((c) lVar.getHostView()).a() <= 1) {
            return true;
        }
        return false;
    }

    public final void computeScroll() {
        if (a()) {
            super.computeScroll();
            return;
        }
        w wVar = this.j;
        if (wVar.o != v.a) {
            return;
        }
        if (wVar.d.computeScrollOffset()) {
            wVar.a.scrollTo(wVar.d.getCurrX(), wVar.d.getCurrY());
            wVar.a.postInvalidate();
        } else if (wVar.f == 2) {
            wVar.b();
        }
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        if (a()) {
            super.onScrollChanged(i, i2, i3, i4);
            return;
        }
        w wVar = this.j;
        if (wVar.o == v.a) {
            wVar.p = ((float) Math.abs(i)) / ((float) wVar.a.getMeasuredWidth());
        }
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (a()) {
            super.onSizeChanged(i, i2, i3, i4);
            return;
        }
        w wVar = this.j;
        if (wVar.o == v.a) {
            wVar.a(i, i2);
        }
    }

    public final void draw(Canvas canvas) {
        int i = 0;
        try {
            super.draw(canvas);
            getDrawingRect(this.e);
            w wVar = this.j;
            int i2;
            int measuredHeight;
            if (wVar.o == v.a) {
                i = wVar.a.getScrollX();
                if (i < 0) {
                    i2 = (int) ((IPictureView.DEFAULT_MIN_SCALE - wVar.p) * 255.0f);
                    measuredHeight = wVar.a.getMeasuredHeight();
                    if (wVar.b != null) {
                        canvas.save();
                        canvas.translate((float) i, 0.0f);
                        canvas.clipRect(0, 0, -i, measuredHeight);
                        wVar.b.draw(canvas);
                        wVar.s.setAlpha(i2);
                        wVar.s.setBounds(0, 0, -i, measuredHeight);
                        wVar.s.draw(canvas);
                        canvas.restore();
                    }
                    wVar.r.setAlpha(i2);
                    wVar.r.setBounds(-wVar.q, 0, 0, measuredHeight);
                    wVar.r.draw(canvas);
                }
            } else if (wVar.f == 1) {
                measuredHeight = wVar.u.getIntrinsicWidth();
                r4 = wVar.u.getIntrinsicHeight();
                i2 = (int) ((-(IPictureView.DEFAULT_MIN_SCALE - (wVar.t * 2.0f))) * ((float) measuredHeight));
                if (i2 <= 0) {
                    i = i2;
                }
                i2 = (wVar.a.getMeasuredHeight() - r4) / 2;
                wVar.u.setBounds(i, i2, measuredHeight + i, r4 + i2);
                wVar.u.draw(canvas);
            } else if (wVar.f != 2) {
            } else {
                if (wVar.d.computeScrollOffset()) {
                    measuredHeight = wVar.u.getIntrinsicWidth();
                    r4 = wVar.u.getIntrinsicHeight();
                    i2 = wVar.d.getCurrX();
                    if (i2 <= 0) {
                        i = i2;
                    }
                    i2 = (wVar.a.getMeasuredHeight() - r4) / 2;
                    wVar.u.setBounds(i, i2, measuredHeight + i, r4 + i2);
                    wVar.u.draw(canvas);
                    wVar.a.postInvalidate();
                    return;
                }
                wVar.b();
            }
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("Crash by " + getClass().getName(), th);
        }
    }

    protected final void dispatchDraw(Canvas canvas) {
        try {
            if (this.g && !this.c) {
                getDrawingRect(this.e);
                b.a();
            }
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("Crash by " + getClass().getName(), th);
        }
    }

    public final int getAndroidWindowAnimation() {
        if (this.i == -1) {
            b.a();
            this.i = 0;
        }
        return this.i;
    }

    public final void setAndroidWindowAnimation(int i) {
        this.i = i;
    }

    public final void setActAsAndroidWindow(boolean z) {
        this.b = z;
    }

    public final void setLayoutParams(LayoutParams layoutParams) {
        LayoutParams layoutParams2 = getLayoutParams();
        if (!this.b || layoutParams == null || (layoutParams instanceof WindowManager.LayoutParams) || layoutParams2 == null || !(layoutParams2 instanceof WindowManager.LayoutParams)) {
            super.setLayoutParams(layoutParams);
        } else if (getParent() != null) {
            WindowManager.LayoutParams layoutParams3 = (WindowManager.LayoutParams) layoutParams2;
            layoutParams3.width = layoutParams.width;
            layoutParams3.height = layoutParams.height;
            x.a(getContext(), this, layoutParams3);
            super.setLayoutParams(layoutParams3);
        }
    }

    public final void setCallback(c cVar) {
        this.l = cVar;
    }
}
