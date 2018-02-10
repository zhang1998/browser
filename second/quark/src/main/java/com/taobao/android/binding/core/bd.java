package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class bd extends b implements OnGestureListener, OnTouchListener {
    private float h;
    private float i;
    private float j;
    private float k;
    private GestureDetector l;
    private boolean m;
    private boolean n;

    bd(@NonNull ac acVar) {
        super(acVar);
        this.l = new GestureDetector(acVar.b(), this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r6.getActionMasked();	 Catch:{ Exception -> 0x0023 }
        switch(r0) {
            case 0: goto L_0x000f;
            case 1: goto L_0x0070;
            case 2: goto L_0x003d;
            case 3: goto L_0x0089;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = r4.l;
        r0 = r0.onTouchEvent(r6);
        return r0;
    L_0x000f:
        r0 = r6.getRawX();	 Catch:{ Exception -> 0x0023 }
        r4.h = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = r6.getRawY();	 Catch:{ Exception -> 0x0023 }
        r4.i = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = "start";
        r1 = 0;
        r2 = 0;
        r4.a(r0, r1, r2);	 Catch:{ Exception -> 0x0023 }
        goto L_0x0008;
    L_0x0023:
        r0 = move-exception;
        r1 = "ExpressionBinding";
        r2 = new java.lang.StringBuilder;
        r3 = "runtime error\n";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.taobao.weex.utils.WXLogUtils.e(r1, r0);
        goto L_0x0008;
    L_0x003d:
        r0 = r4.h;	 Catch:{ Exception -> 0x0023 }
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 != 0) goto L_0x005d;
    L_0x0043:
        r0 = r4.i;	 Catch:{ Exception -> 0x0023 }
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 != 0) goto L_0x005d;
    L_0x0049:
        r0 = r6.getRawX();	 Catch:{ Exception -> 0x0023 }
        r4.h = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = r6.getRawY();	 Catch:{ Exception -> 0x0023 }
        r4.i = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = "start";
        r1 = 0;
        r2 = 0;
        r4.a(r0, r1, r2);	 Catch:{ Exception -> 0x0023 }
        goto L_0x0008;
    L_0x005d:
        r0 = r6.getRawX();	 Catch:{ Exception -> 0x0023 }
        r1 = r4.h;	 Catch:{ Exception -> 0x0023 }
        r0 = r0 - r1;
        r4.j = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = r6.getRawY();	 Catch:{ Exception -> 0x0023 }
        r1 = r4.i;	 Catch:{ Exception -> 0x0023 }
        r0 = r0 - r1;
        r4.k = r0;	 Catch:{ Exception -> 0x0023 }
        goto L_0x0008;
    L_0x0070:
        r0 = 0;
        r4.h = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = 0;
        r4.i = r0;	 Catch:{ Exception -> 0x0023 }
        r4.a();	 Catch:{ Exception -> 0x0023 }
        r0 = "end";
        r1 = r4.j;	 Catch:{ Exception -> 0x0023 }
        r2 = r4.k;	 Catch:{ Exception -> 0x0023 }
        r4.a(r0, r1, r2);	 Catch:{ Exception -> 0x0023 }
        r0 = 0;
        r4.j = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = 0;
        r4.k = r0;	 Catch:{ Exception -> 0x0023 }
        goto L_0x0008;
    L_0x0089:
        r0 = 0;
        r4.h = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = 0;
        r4.i = r0;	 Catch:{ Exception -> 0x0023 }
        r4.a();	 Catch:{ Exception -> 0x0023 }
        r0 = "cancel";
        r1 = r4.j;	 Catch:{ Exception -> 0x0023 }
        r2 = r4.k;	 Catch:{ Exception -> 0x0023 }
        r4.a(r0, r1, r2);	 Catch:{ Exception -> 0x0023 }
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.binding.core.bd.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.m) {
            float f3;
            float f4;
            if (motionEvent == null) {
                f3 = this.h;
                f4 = this.i;
            } else {
                f3 = motionEvent.getRawX();
                f4 = motionEvent.getRawY();
            }
            if (motionEvent2 != null) {
                try {
                    ci.a(this.c, (double) (motionEvent2.getRawX() - f3), (double) (motionEvent2.getRawY() - f4), this.e);
                    if (!a(this.f, this.c)) {
                        a(this.a, this.c, "pan");
                    }
                } catch (Exception e) {
                    WXLogUtils.e("ExpressionBinding", "runtime error\n" + e.getMessage());
                }
            }
        } else {
            WXLogUtils.d("ExpressionBinding", "pan gesture is not enabled");
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return !this.n ? false : false;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean a(@NonNull String str, @NonNull String str2) {
        View a = ed.a(this.d, str);
        if (a == null) {
            WXLogUtils.e("ExpressionBinding", "[ExpressionTouchHandler] onCreate failed. sourceView not found:" + str);
            return false;
        }
        a.setOnTouchListener(this);
        if (i.c()) {
            WXLogUtils.d("ExpressionBinding", "[ExpressionTouchHandler] onCreate success. {source:" + str + ",type:" + str2 + "}");
        }
        return true;
    }

    public final void a(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case 110749:
                if (str.equals("pan")) {
                    z = false;
                    break;
                }
                break;
            case 97520651:
                if (str.equals("flick")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.m = true;
                return;
            case true:
                this.n = true;
                return;
            default:
                return;
        }
    }

    public final void a(@NonNull String str, @Nullable Map<String, Object> map, @Nullable av avVar, @NonNull List<Map<String, Object>> list, @Nullable c cVar) {
        super.a(str, map, avVar, list, cVar);
    }

    public final boolean b(@NonNull String str, @NonNull String str2) {
        boolean z = true;
        switch (str2.hashCode()) {
            case 110749:
                if (str2.equals("pan")) {
                    z = false;
                    break;
                }
                break;
            case 97520651:
                if (str2.equals("flick")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.m = false;
                break;
            case true:
                this.n = false;
                break;
        }
        if (this.m || this.n) {
            return false;
        }
        View a = ed.a(this.d, str);
        if (a != null) {
            a.setOnTouchListener(null);
        }
        WXLogUtils.d("ExpressionBinding", "remove touch listener success.[" + str + "," + str2 + "]");
        return true;
    }

    public final void b() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        this.f = null;
        this.b = null;
        this.n = false;
        this.m = false;
        this.g.clear();
    }

    protected final void a(@NonNull Map<String, Object> map) {
        a("exit", ((Float) map.get("internal_x")).floatValue(), ((Float) map.get("internal_y")).floatValue());
    }

    private void a(String str, float f, float f2) {
        if (this.b != null) {
            Map hashMap = new HashMap();
            hashMap.put("state", str);
            double b = WXViewUtils.b((double) f, this.e);
            double b2 = WXViewUtils.b((double) f2, this.e);
            hashMap.put("deltaX", Double.valueOf(b));
            hashMap.put("deltaY", Double.valueOf(b2));
            this.b.b(hashMap);
            if (i.c()) {
                WXLogUtils.d("ExpressionBinding", ">>>>>>>>>>>fire event:(" + str + "," + b + "," + b2 + ")");
            }
        }
    }

    public final void c() {
    }

    public final void d() {
    }
}
