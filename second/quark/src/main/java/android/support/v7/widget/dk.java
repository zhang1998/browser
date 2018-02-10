package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.bo;
import android.support.v4.widget.bw;
import android.support.v7.c.k;

/* compiled from: ProGuard */
final class dk extends ListViewCompat {
    private boolean h;
    private boolean i;
    private boolean j;
    private bo k;
    private bw l;

    public dk(Context context, boolean z) {
        super(context, null, k.dropDownListViewStyle);
        this.i = z;
        setCacheColorHint(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.MotionEvent r15, int r16) {
        /*
        r14 = this;
        r0 = 1;
        r1 = 0;
        r3 = android.support.v4.view.cx.a(r15);
        switch(r3) {
            case 1: goto L_0x0055;
            case 2: goto L_0x0056;
            case 3: goto L_0x0050;
            default: goto L_0x0009;
        };
    L_0x0009:
        r13 = r1;
        r1 = r0;
        r0 = r13;
    L_0x000c:
        if (r1 == 0) goto L_0x0010;
    L_0x000e:
        if (r0 == 0) goto L_0x0037;
    L_0x0010:
        r0 = 0;
        r14.j = r0;
        r0 = 0;
        r14.setPressed(r0);
        r14.drawableStateChanged();
        r0 = r14.f;
        r2 = r14.getFirstVisiblePosition();
        r0 = r0 - r2;
        r0 = r14.getChildAt(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0027:
        r2 = 0;
        r0.setPressed(r2);
    L_0x002b:
        r0 = r14.k;
        if (r0 == 0) goto L_0x0037;
    L_0x002f:
        r0 = r14.k;
        r0.a();
        r0 = 0;
        r14.k = r0;
    L_0x0037:
        if (r1 == 0) goto L_0x0180;
    L_0x0039:
        r0 = r14.l;
        if (r0 != 0) goto L_0x0044;
    L_0x003d:
        r0 = new android.support.v4.widget.bw;
        r0.<init>(r14);
        r14.l = r0;
    L_0x0044:
        r0 = r14.l;
        r2 = 1;
        r0.a(r2);
        r0 = r14.l;
        r0.onTouch(r14, r15);
    L_0x004f:
        return r1;
    L_0x0050:
        r0 = 0;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x000c;
    L_0x0055:
        r0 = 0;
    L_0x0056:
        r2 = r15.findPointerIndex(r16);
        if (r2 >= 0) goto L_0x0061;
    L_0x005c:
        r0 = 0;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x000c;
    L_0x0061:
        r4 = r15.getX(r2);
        r4 = (int) r4;
        r2 = r15.getY(r2);
        r2 = (int) r2;
        r5 = r14.pointToPosition(r4, r2);
        r6 = -1;
        if (r5 != r6) goto L_0x0077;
    L_0x0072:
        r1 = 1;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x000c;
    L_0x0077:
        r0 = r14.getFirstVisiblePosition();
        r0 = r5 - r0;
        r6 = r14.getChildAt(r0);
        r4 = (float) r4;
        r7 = (float) r2;
        r0 = 1;
        r14.j = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        if (r0 < r2) goto L_0x008f;
    L_0x008c:
        r14.drawableHotspotChanged(r4, r7);
    L_0x008f:
        r0 = r14.isPressed();
        if (r0 != 0) goto L_0x0099;
    L_0x0095:
        r0 = 1;
        r14.setPressed(r0);
    L_0x0099:
        r14.layoutChildren();
        r0 = r14.f;
        r2 = -1;
        if (r0 == r2) goto L_0x00ba;
    L_0x00a1:
        r0 = r14.f;
        r2 = r14.getFirstVisiblePosition();
        r0 = r0 - r2;
        r0 = r14.getChildAt(r0);
        if (r0 == 0) goto L_0x00ba;
    L_0x00ae:
        if (r0 == r6) goto L_0x00ba;
    L_0x00b0:
        r2 = r0.isPressed();
        if (r2 == 0) goto L_0x00ba;
    L_0x00b6:
        r2 = 0;
        r0.setPressed(r2);
    L_0x00ba:
        r14.f = r5;
        r0 = r6.getLeft();
        r0 = (float) r0;
        r0 = r4 - r0;
        r2 = r6.getTop();
        r2 = (float) r2;
        r2 = r7 - r2;
        r8 = android.os.Build.VERSION.SDK_INT;
        r9 = 21;
        if (r8 < r9) goto L_0x00d3;
    L_0x00d0:
        r6.drawableHotspotChanged(r0, r2);
    L_0x00d3:
        r0 = r6.isPressed();
        if (r0 != 0) goto L_0x00dd;
    L_0x00d9:
        r0 = 1;
        r6.setPressed(r0);
    L_0x00dd:
        r8 = r14.getSelector();
        if (r8 == 0) goto L_0x0178;
    L_0x00e3:
        r0 = -1;
        if (r5 == r0) goto L_0x0178;
    L_0x00e6:
        r0 = 1;
        r2 = r0;
    L_0x00e8:
        if (r2 == 0) goto L_0x00ef;
    L_0x00ea:
        r0 = 0;
        r9 = 0;
        r8.setVisible(r0, r9);
    L_0x00ef:
        r0 = r14.a;
        r9 = r6.getLeft();
        r10 = r6.getTop();
        r11 = r6.getRight();
        r12 = r6.getBottom();
        r0.set(r9, r10, r11, r12);
        r9 = r0.left;
        r10 = r14.b;
        r9 = r9 - r10;
        r0.left = r9;
        r9 = r0.top;
        r10 = r14.c;
        r9 = r9 - r10;
        r0.top = r9;
        r9 = r0.right;
        r10 = r14.d;
        r9 = r9 + r10;
        r0.right = r9;
        r9 = r0.bottom;
        r10 = r14.e;
        r9 = r9 + r10;
        r0.bottom = r9;
        r0 = r14.g;	 Catch:{ IllegalAccessException -> 0x018c }
        r0 = r0.getBoolean(r14);	 Catch:{ IllegalAccessException -> 0x018c }
        r9 = r6.isEnabled();	 Catch:{ IllegalAccessException -> 0x018c }
        if (r9 == r0) goto L_0x013e;
    L_0x012c:
        r9 = r14.g;	 Catch:{ IllegalAccessException -> 0x018c }
        if (r0 != 0) goto L_0x017c;
    L_0x0130:
        r0 = 1;
    L_0x0131:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IllegalAccessException -> 0x018c }
        r9.set(r14, r0);	 Catch:{ IllegalAccessException -> 0x018c }
        r0 = -1;
        if (r5 == r0) goto L_0x013e;
    L_0x013b:
        r14.refreshDrawableState();	 Catch:{ IllegalAccessException -> 0x018c }
    L_0x013e:
        if (r2 == 0) goto L_0x0158;
    L_0x0140:
        r0 = r14.a;
        r2 = r0.exactCenterX();
        r9 = r0.exactCenterY();
        r0 = r14.getVisibility();
        if (r0 != 0) goto L_0x017e;
    L_0x0150:
        r0 = 1;
    L_0x0151:
        r10 = 0;
        r8.setVisible(r0, r10);
        android.support.v4.b.a.q.a(r8, r2, r9);
    L_0x0158:
        r0 = r14.getSelector();
        if (r0 == 0) goto L_0x0164;
    L_0x015e:
        r2 = -1;
        if (r5 == r2) goto L_0x0164;
    L_0x0161:
        android.support.v4.b.a.q.a(r0, r4, r7);
    L_0x0164:
        r0 = 0;
        r14.setSelectorEnabled(r0);
        r14.refreshDrawableState();
        r0 = 1;
        r2 = 1;
        if (r3 != r2) goto L_0x0009;
    L_0x016f:
        r2 = r14.getItemIdAtPosition(r5);
        r14.performItemClick(r6, r5, r2);
        goto L_0x0009;
    L_0x0178:
        r0 = 0;
        r2 = r0;
        goto L_0x00e8;
    L_0x017c:
        r0 = 0;
        goto L_0x0131;
    L_0x017e:
        r0 = 0;
        goto L_0x0151;
    L_0x0180:
        r0 = r14.l;
        if (r0 == 0) goto L_0x004f;
    L_0x0184:
        r0 = r14.l;
        r2 = 0;
        r0.a(r2);
        goto L_0x004f;
    L_0x018c:
        r0 = move-exception;
        goto L_0x013e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.dk.a(android.view.MotionEvent, int):boolean");
    }

    protected final boolean a() {
        return this.j || super.a();
    }

    public final boolean isInTouchMode() {
        return (this.i && this.h) || super.isInTouchMode();
    }

    public final boolean hasWindowFocus() {
        return this.i || super.hasWindowFocus();
    }

    public final boolean isFocused() {
        return this.i || super.isFocused();
    }

    public final boolean hasFocus() {
        return this.i || super.hasFocus();
    }
}
