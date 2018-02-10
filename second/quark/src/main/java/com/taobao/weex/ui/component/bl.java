package com.taobao.weex.ui.component;

/* compiled from: ProGuard */
final class bl implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ bp b;

    bl(bp bpVar, int i) {
        this.b = bpVar;
        this.a = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r1 = 2;
        r9 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r10.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r0.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r0.getRealCount();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r0 <= 0) goto L_0x00ed;
    L_0x000d:
        r0 = r10.a;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r0 <= r1) goto L_0x00ed;
    L_0x0011:
        r0 = r10.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8 = r0.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r8.g;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r0 != 0) goto L_0x0046;
    L_0x0019:
        r0 = 1;
        r8.k = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = 1;
        r8.setScrollState(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = 0;
        r8.h = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8.i = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r8.j;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r0 != 0) goto L_0x005f;
    L_0x0029:
        r0 = android.view.VelocityTracker.obtain();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8.j = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
    L_0x002f:
        r0 = android.os.SystemClock.uptimeMillis();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = r0;
        r2 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r3 = r8.j;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r3.addMovement(r2);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2.recycle();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8.l = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
    L_0x0046:
        r0 = r10.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8 = r0.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r8.k;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r0 != 0) goto L_0x006e;
    L_0x004e:
        r0 = new java.lang.IllegalStateException;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = "No fake drag in progress. Call beginFakeDrag first.";
        r0.<init>(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        throw r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
    L_0x0056:
        r0 = move-exception;
        r0 = r10.b;	 Catch:{ Exception -> 0x0102 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0102 }
        r0.c();	 Catch:{ Exception -> 0x0102 }
    L_0x005e:
        return;
    L_0x005f:
        r0 = r8.j;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0.clear();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        goto L_0x002f;
    L_0x0065:
        r0 = move-exception;
        r1 = r10.b;	 Catch:{ Exception -> 0x00ff }
        r1 = r1.b;	 Catch:{ Exception -> 0x00ff }
        r1.c();	 Catch:{ Exception -> 0x00ff }
    L_0x006d:
        throw r0;
    L_0x006e:
        r0 = r8.c;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0072:
        r0 = r8.h;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r0 + r9;
        r8.h = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r8.getScrollX();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = (float) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2 = r0 - r9;
        r5 = r8.getClientWidth();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = (float) r5;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = r8.e;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r4 = r0 * r1;
        r0 = (float) r5;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = r8.f;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r3 = r0 * r1;
        r0 = r8.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = (android.mini.support.v4.view.bv) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = r8.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r8.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r6.size();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r6 + -1;
        r1 = r1.get(r6);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = (android.mini.support.v4.view.bv) r1;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r0.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        if (r6 == 0) goto L_0x0109;
    L_0x00a9:
        r0 = r0.e;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r4 = (float) r5;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r0 * r4;
    L_0x00ad:
        r4 = r1.b;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r8.c;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r6.a();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = r6 + -1;
        if (r4 == r6) goto L_0x0107;
    L_0x00b9:
        r1 = r1.e;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r3 = (float) r5;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = r1 * r3;
    L_0x00bd:
        r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r3 >= 0) goto L_0x00f9;
    L_0x00c1:
        r1 = r8.h;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2 = (int) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2 = (float) r2;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2 = r0 - r2;
        r1 = r1 + r2;
        r8.h = r1;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = (int) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2 = r8.getScrollY();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8.scrollTo(r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = (int) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r8.a(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r2 = android.os.SystemClock.uptimeMillis();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0 = r8.l;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r4 = 2;
        r5 = r8.h;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r6 = 0;
        r7 = 0;
        r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1 = r8.j;	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r1.addMovement(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
        r0.recycle();	 Catch:{ IndexOutOfBoundsException -> 0x0056, all -> 0x0065 }
    L_0x00ed:
        r0 = r10.b;	 Catch:{ Exception -> 0x00f6 }
        r0 = r0.b;	 Catch:{ Exception -> 0x00f6 }
        r0.c();	 Catch:{ Exception -> 0x00f6 }
        goto L_0x005e;
    L_0x00f6:
        r0 = move-exception;
        goto L_0x005e;
    L_0x00f9:
        r0 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0105;
    L_0x00fd:
        r0 = r1;
        goto L_0x00c1;
    L_0x00ff:
        r1 = move-exception;
        goto L_0x006d;
    L_0x0102:
        r0 = move-exception;
        goto L_0x005e;
    L_0x0105:
        r0 = r2;
        goto L_0x00c1;
    L_0x0107:
        r1 = r3;
        goto L_0x00bd;
    L_0x0109:
        r0 = r4;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.bl.run():void");
    }
}
