package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.cx;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

/* compiled from: ProGuard */
public abstract class fm implements OnTouchListener {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private boolean h;
    private int i;
    private final int[] j = new int[2];

    public abstract ListPopupWindow a();

    static /* synthetic */ void b(fm fmVar) {
        fmVar.d();
        View view = fmVar.d;
        if (view.isEnabled() && !view.isLongClickable() && fmVar.b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            fmVar.g = true;
            fmVar.h = true;
        }
    }

    public fm(View view) {
        this.d = view;
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        r11 = this;
        r5 = 0;
        r8 = 1;
        r7 = 0;
        r10 = r11.g;
        if (r10 == 0) goto L_0x0027;
    L_0x0007:
        r0 = r11.h;
        if (r0 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r11.a(r13);
    L_0x000f:
        r11.g = r0;
        if (r0 != 0) goto L_0x0015;
    L_0x0013:
        if (r10 == 0) goto L_0x0016;
    L_0x0015:
        r7 = r8;
    L_0x0016:
        return r7;
    L_0x0017:
        r0 = r11.a(r13);
        if (r0 != 0) goto L_0x0023;
    L_0x001d:
        r0 = r11.c();
        if (r0 != 0) goto L_0x0025;
    L_0x0023:
        r0 = r8;
        goto L_0x000f;
    L_0x0025:
        r0 = r7;
        goto L_0x000f;
    L_0x0027:
        r1 = r11.d;
        r0 = r1.isEnabled();
        if (r0 == 0) goto L_0x0036;
    L_0x002f:
        r0 = android.support.v4.view.cx.a(r13);
        switch(r0) {
            case 0: goto L_0x0057;
            case 1: goto L_0x00d2;
            case 2: goto L_0x0086;
            case 3: goto L_0x00d2;
            default: goto L_0x0036;
        };
    L_0x0036:
        r0 = r7;
    L_0x0037:
        if (r0 == 0) goto L_0x00d7;
    L_0x0039:
        r0 = r11.b();
        if (r0 == 0) goto L_0x00d7;
    L_0x003f:
        r9 = r8;
    L_0x0040:
        if (r9 == 0) goto L_0x0055;
    L_0x0042:
        r0 = android.os.SystemClock.uptimeMillis();
        r4 = 3;
        r2 = r0;
        r6 = r5;
        r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);
        r1 = r11.d;
        r1.onTouchEvent(r0);
        r0.recycle();
    L_0x0055:
        r0 = r9;
        goto L_0x000f;
    L_0x0057:
        r0 = r13.getPointerId(r7);
        r11.i = r0;
        r11.h = r7;
        r0 = r11.e;
        if (r0 != 0) goto L_0x006a;
    L_0x0063:
        r0 = new android.support.v7.widget.cp;
        r0.<init>(r11, r7);
        r11.e = r0;
    L_0x006a:
        r0 = r11.e;
        r2 = r11.b;
        r2 = (long) r2;
        r1.postDelayed(r0, r2);
        r0 = r11.f;
        if (r0 != 0) goto L_0x007d;
    L_0x0076:
        r0 = new android.support.v7.widget.cd;
        r0.<init>(r11, r7);
        r11.f = r0;
    L_0x007d:
        r0 = r11.f;
        r2 = r11.c;
        r2 = (long) r2;
        r1.postDelayed(r0, r2);
        goto L_0x0036;
    L_0x0086:
        r0 = r11.i;
        r0 = r13.findPointerIndex(r0);
        if (r0 < 0) goto L_0x0036;
    L_0x008e:
        r2 = r13.getX(r0);
        r0 = r13.getY(r0);
        r3 = r11.a;
        r4 = -r3;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x00d0;
    L_0x009d:
        r4 = -r3;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x00d0;
    L_0x00a2:
        r4 = r1.getRight();
        r6 = r1.getLeft();
        r4 = r4 - r6;
        r4 = (float) r4;
        r4 = r4 + r3;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x00d0;
    L_0x00b1:
        r2 = r1.getBottom();
        r4 = r1.getTop();
        r2 = r2 - r4;
        r2 = (float) r2;
        r2 = r2 + r3;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x00d0;
    L_0x00c0:
        r0 = r8;
    L_0x00c1:
        if (r0 != 0) goto L_0x0036;
    L_0x00c3:
        r11.d();
        r0 = r1.getParent();
        r0.requestDisallowInterceptTouchEvent(r8);
        r0 = r8;
        goto L_0x0037;
    L_0x00d0:
        r0 = r7;
        goto L_0x00c1;
    L_0x00d2:
        r11.d();
        goto L_0x0036;
    L_0x00d7:
        r9 = r7;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.fm.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean b() {
        ListPopupWindow a = a();
        if (!(a == null || a.a.isShowing())) {
            a.b();
        }
        return true;
    }

    protected boolean c() {
        ListPopupWindow a = a();
        if (a != null && a.a.isShowing()) {
            a.c();
        }
        return true;
    }

    private void d() {
        if (this.f != null) {
            this.d.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        }
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.d;
        ListPopupWindow a = a();
        if (a == null || !a.a.isShowing()) {
            return false;
        }
        View a2 = a.b;
        if (a2 == null || !a2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        int[] iArr = this.j;
        view.getLocationOnScreen(iArr);
        obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
        int[] iArr2 = this.j;
        a2.getLocationOnScreen(iArr2);
        obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
        boolean a3 = a2.a(obtainNoHistory, this.i);
        obtainNoHistory.recycle();
        int a4 = cx.a(motionEvent);
        boolean z;
        if (a4 == 1 || a4 == 3) {
            z = false;
        } else {
            z = true;
        }
        if (a3 && r2) {
            return true;
        }
        return false;
    }
}
