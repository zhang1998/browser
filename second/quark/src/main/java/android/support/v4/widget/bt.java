package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ao;
import android.support.v4.view.cx;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.imagecodec.export.IPictureView;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class bt {
    private static final Interpolator v = new ah();
    int a;
    int b;
    float[] c;
    float[] d;
    float[] e;
    float[] f;
    float g;
    int h;
    int i;
    View j;
    private int k = -1;
    private int[] l;
    private int[] m;
    private int[] n;
    private int o;
    private VelocityTracker p;
    private float q;
    private l r;
    private final at s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new aq(this);

    private bt(Context context, ViewGroup viewGroup, at atVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (atVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.u = viewGroup;
            this.s = atVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.h = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.q = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.g = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = l.a(context, v);
        }
    }

    public final void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.j = view;
        this.k = i;
        this.s.b(view);
        b(1);
    }

    public final void a() {
        this.k = -1;
        if (this.c != null) {
            Arrays.fill(this.c, 0.0f);
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.l, 0);
            Arrays.fill(this.m, 0);
            Arrays.fill(this.n, 0);
            this.o = 0;
        }
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
    }

    public final void b() {
        a();
        if (this.a == 2) {
            this.r.b();
            this.r.c();
            this.r.h();
            int b = this.r.b();
            this.r.c();
            this.s.a(this.j, b);
        }
        b(0);
    }

    public final boolean a(View view, int i, int i2) {
        this.j = view;
        this.k = -1;
        boolean a = a(i, i2, 0, 0);
        if (!(a || this.a != 0 || this.j == null)) {
            this.j = null;
        }
        return a;
    }

    public final boolean a(int i, int i2) {
        if (this.t) {
            return a(i, i2, (int) ao.a(this.p, this.k), (int) ao.b(this.p, this.k));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.j.getLeft();
        int top = this.j.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.r.h();
            b(0);
            return false;
        }
        View view = this.j;
        int b = b(i3, (int) this.g, (int) this.q);
        int b2 = b(i4, (int) this.g, (int) this.q);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.r.a(left, top, i5, i6, (int) (((b2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) a(i6, b2, 0))) + ((b != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) a(i5, b, this.s.c(view))))));
        b(2);
        return true;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(IPictureView.DEFAULT_MIN_SCALE, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + IPictureView.DEFAULT_MIN_SCALE) * 256.0f);
        }
        return Math.min(width, SecExceptionCode.SEC_ERROR_SIGNATRUE);
    }

    private static int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final boolean c() {
        if (this.a == 2) {
            boolean g = this.r.g();
            int b = this.r.b();
            int c = this.r.c();
            int left = b - this.j.getLeft();
            int top = c - this.j.getTop();
            if (left != 0) {
                ViewCompat.e(this.j, left);
            }
            if (top != 0) {
                ViewCompat.d(this.j, top);
            }
            if (!(left == 0 && top == 0)) {
                this.s.a(this.j, b);
            }
            if (g && b == this.r.d() && c == this.r.e()) {
                this.r.h();
                g = false;
            }
            if (!g) {
                this.u.post(this.w);
            }
        }
        if (this.a == 2) {
            return true;
        }
        return false;
    }

    private void a(float f) {
        this.t = true;
        this.s.a(this.j, f);
        this.t = false;
        if (this.a == 1) {
            b(0);
        }
    }

    private void c(int i) {
        if (this.c != null) {
            this.c[i] = 0.0f;
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.l[i] = 0;
            this.m[i] = 0;
            this.n[i] = 0;
            this.o &= (1 << i) ^ -1;
        }
    }

    private void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.c == null || this.c.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.c != null) {
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                System.arraycopy(this.e, 0, obj3, 0, this.e.length);
                System.arraycopy(this.f, 0, obj4, 0, this.f.length);
                System.arraycopy(this.l, 0, obj5, 0, this.l.length);
                System.arraycopy(this.m, 0, obj6, 0, this.m.length);
                System.arraycopy(this.n, 0, obj7, 0, this.n.length);
            }
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
            this.l = obj5;
            this.m = obj6;
            this.n = obj7;
        }
        float[] fArr = this.c;
        this.e[i] = f;
        fArr[i] = f;
        fArr = this.d;
        this.f[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.l;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.u.getLeft() + this.h) {
            i2 = 1;
        }
        if (i4 < this.u.getTop() + this.h) {
            i2 |= 4;
        }
        if (i3 > this.u.getRight() - this.h) {
            i2 |= 2;
        }
        if (i4 > this.u.getBottom() - this.h) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.o |= 1 << i;
    }

    private void c(MotionEvent motionEvent) {
        int c = cx.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = cx.b(motionEvent, i);
            float c2 = cx.c(motionEvent, i);
            float d = cx.d(motionEvent, i);
            this.e[b] = c2;
            this.f[b] = d;
        }
    }

    public final boolean a(int i) {
        return (this.o & (1 << i)) != 0;
    }

    final void b(int i) {
        this.u.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.s.a(i);
            if (this.a == 0) {
                this.j = null;
            }
        }
    }

    private boolean b(View view, int i) {
        if (view == this.j && this.k == i) {
            return true;
        }
        if (view == null || !this.s.a(view)) {
            return false;
        }
        this.k = i;
        a(view, i);
        return true;
    }

    public final boolean a(MotionEvent motionEvent) {
        int a = cx.a(motionEvent);
        int b = cx.b(motionEvent);
        if (a == 0) {
            a();
        }
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
        float x;
        float y;
        int b2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = cx.b(motionEvent, 0);
                a(x, y, b2);
                View b3 = b((int) x, (int) y);
                if (b3 == this.j && this.a == 2) {
                    b(b3, b2);
                }
                if ((this.l[b2] & this.i) != 0) {
                    this.s.c();
                    break;
                }
                break;
            case 1:
            case 3:
                a();
                break;
            case 2:
                if (!(this.c == null || this.d == null)) {
                    b2 = cx.c(motionEvent);
                    for (b = 0; b < b2; b++) {
                        int b4 = cx.b(motionEvent, b);
                        if (d(b4)) {
                            x = cx.c(motionEvent, b);
                            float d = cx.d(motionEvent, b);
                            float f = x - this.c[b4];
                            float f2 = d - this.d[b4];
                            View b5 = b((int) x, (int) d);
                            boolean z = b5 != null && a(b5, f);
                            if (z) {
                                int left = b5.getLeft();
                                int b6 = this.s.b(b5, ((int) f) + left);
                                b5.getTop();
                                this.s.d(b5);
                                int c = this.s.c(b5);
                                if (c != 0) {
                                    if (c > 0 && b6 == left) {
                                    }
                                }
                                c(motionEvent);
                                break;
                            }
                            b(f, f2, b4);
                            if (this.a != 1) {
                                if (z && b(b5, b4)) {
                                }
                            }
                            c(motionEvent);
                        }
                    }
                    c(motionEvent);
                }
                break;
            case 5:
                a = cx.b(motionEvent, b);
                float c2 = cx.c(motionEvent, b);
                y = cx.d(motionEvent, b);
                a(c2, y, a);
                if (this.a != 0) {
                    if (this.a == 2) {
                        View b7 = b((int) c2, (int) y);
                        if (b7 == this.j) {
                            b(b7, a);
                            break;
                        }
                    }
                } else if ((this.l[a] & this.i) != 0) {
                    this.s.c();
                    break;
                }
                break;
            case 6:
                c(cx.b(motionEvent, b));
                break;
        }
        if (this.a == 1) {
            return true;
        }
        return false;
    }

    public final void b(MotionEvent motionEvent) {
        int i = 0;
        int a = cx.a(motionEvent);
        int b = cx.b(motionEvent);
        if (a == 0) {
            a();
        }
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
        float x;
        float y;
        View b2;
        int top;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = cx.b(motionEvent, 0);
                b2 = b((int) x, (int) y);
                a(x, y, i);
                b(b2, i);
                if ((this.l[i] & this.i) != 0) {
                    this.s.c();
                    return;
                }
                return;
            case 1:
                if (this.a == 1) {
                    d();
                }
                a();
                return;
            case 2:
                int c;
                if (this.a != 1) {
                    c = cx.c(motionEvent);
                    while (i < c) {
                        a = cx.b(motionEvent, i);
                        if (d(a)) {
                            float c2 = cx.c(motionEvent, i);
                            float d = cx.d(motionEvent, i);
                            float f = c2 - this.c[a];
                            b(f, d - this.d[a], a);
                            if (this.a != 1) {
                                b2 = b((int) c2, (int) d);
                                if (a(b2, f) && b(b2, a)) {
                                }
                            }
                            c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    c(motionEvent);
                    return;
                } else if (d(this.k)) {
                    i = cx.a(motionEvent, this.k);
                    x = cx.c(motionEvent, i);
                    c = (int) (x - this.e[this.k]);
                    a = (int) (cx.d(motionEvent, i) - this.f[this.k]);
                    i = this.j.getLeft() + c;
                    this.j.getTop();
                    b = this.j.getLeft();
                    top = this.j.getTop();
                    if (c != 0) {
                        i = this.s.b(this.j, i);
                        ViewCompat.e(this.j, i - b);
                    }
                    if (a != 0) {
                        ViewCompat.d(this.j, this.s.d(this.j) - top);
                    }
                    if (!(c == 0 && a == 0)) {
                        this.s.a(this.j, i);
                    }
                    c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.a == 1) {
                    a(0.0f);
                }
                a();
                return;
            case 5:
                i = cx.b(motionEvent, b);
                x = cx.c(motionEvent, b);
                y = cx.d(motionEvent, b);
                a(x, y, i);
                if (this.a == 0) {
                    b(b((int) x, (int) y), i);
                    if ((this.l[i] & this.i) != 0) {
                        this.s.c();
                        return;
                    }
                    return;
                }
                if (b(this.j, (int) x, (int) y)) {
                    b(this.j, i);
                    return;
                }
                return;
            case 6:
                a = cx.b(motionEvent, b);
                if (this.a == 1 && a == this.k) {
                    b = cx.c(motionEvent);
                    while (i < b) {
                        top = cx.b(motionEvent, i);
                        if (top != this.k) {
                            if (b((int) cx.c(motionEvent, i), (int) cx.d(motionEvent, i)) == this.j && b(this.j, top)) {
                                i = this.k;
                                if (i == -1) {
                                    d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        d();
                    }
                }
                c(a);
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.m;
            iArr[i] = iArr[i] | i2;
            this.s.a(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.l[i] & i2) != i2 || (this.i & i2) == 0 || (this.n[i] & i2) == i2 || (this.m[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.b) || abs2 > ((float) this.b)) && (this.m[i] & i2) == 0 && abs > ((float) this.b)) {
            return true;
        }
        return false;
    }

    private boolean a(View view, float f) {
        if (view == null) {
            return false;
        }
        if (!(this.s.c(view) > 0) || Math.abs(f) <= ((float) this.b)) {
            return false;
        }
        return true;
    }

    private void d() {
        this.p.computeCurrentVelocity(1000, this.q);
        float a = a(ao.a(this.p, this.k), this.g, this.q);
        a(ao.b(this.p, this.k), this.g, this.q);
        a(a);
    }

    public static boolean b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View b(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean d(int i) {
        if (a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public static bt a(ViewGroup viewGroup, float f, at atVar) {
        bt btVar = new bt(viewGroup.getContext(), viewGroup, atVar);
        btVar.b = (int) (((float) btVar.b) * (IPictureView.DEFAULT_MIN_SCALE / f));
        return btVar;
    }
}
