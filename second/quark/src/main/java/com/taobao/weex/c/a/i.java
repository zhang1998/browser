package com.taobao.weex.c.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.m;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.alibaba.fastjson.a;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;
import com.taobao.weex.ui.animation.WXAnimationBean;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.animation.b;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;
import java.util.List;

/* compiled from: ProGuard */
public final class i implements d, p {
    @NonNull
    private final String a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private WXAnimationBean d;

    public i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public i(@NonNull String str, @NonNull WXAnimationBean wXAnimationBean) {
        this(str, wXAnimationBean, null);
    }

    public i(@NonNull String str, @NonNull WXAnimationBean wXAnimationBean, @Nullable String str2) {
        this.a = str;
        this.d = wXAnimationBean;
        this.c = str2;
        this.b = null;
    }

    public final void a(e eVar) {
        try {
            if (!TextUtils.isEmpty(this.b)) {
                ae c = eVar.c(this.a);
                if (c != null) {
                    WXAnimationBean wXAnimationBean = (WXAnimationBean) a.a(this.b, WXAnimationBean.class);
                    if (wXAnimationBean != null && wXAnimationBean.styles != null) {
                        wXAnimationBean.styles.init(wXAnimationBean.styles.transformOrigin, wXAnimationBean.styles.transform, (int) c.o(), (int) c.p(), eVar.d().o);
                        this.d = wXAnimationBean;
                        eVar.a((p) this);
                    }
                }
            }
        } catch (Throwable e) {
            WXLogUtils.e("AnimationAction", WXLogUtils.getStackTrace(e));
        }
    }

    public final void a(q qVar) {
        if (this.d != null) {
            ac a = qVar.a();
            if (a != null) {
                ab a2 = qVar.a(this.a);
                if (a2 != null) {
                    if (this.d != null) {
                        a2.setNeedLayoutOnAnimation(this.d.needLayout);
                    }
                    if (a2.getHostView() == null) {
                        a2.postAnimation(new com.taobao.weex.ui.animation.d(this.d, this.c));
                        return;
                    }
                    try {
                        Animator animator;
                        Object obj;
                        AnimatorListener gVar;
                        TimeInterpolator a3;
                        View hostView = a2.getHostView();
                        int i = a.o;
                        if (hostView != null) {
                            Style style = this.d.styles;
                            if (style != null) {
                                List holders = style.getHolders();
                                if (!TextUtils.isEmpty(style.backgroundColor)) {
                                    if (WXViewUtils.b(hostView) != null) {
                                        holders.add(PropertyValuesHolder.ofObject(new com.taobao.weex.ui.animation.a(), new ArgbEvaluator(), new Integer[]{Integer.valueOf(r0.c), Integer.valueOf(af.a(style.backgroundColor))}));
                                    } else if (hostView.getBackground() instanceof ColorDrawable) {
                                        holders.add(PropertyValuesHolder.ofObject(new com.taobao.weex.ui.animation.a(), new ArgbEvaluator(), new Integer[]{Integer.valueOf(((ColorDrawable) hostView.getBackground()).getColor()), Integer.valueOf(af.a(style.backgroundColor))}));
                                    }
                                }
                                if (style.getPivot() != null) {
                                    Pair pivot = style.getPivot();
                                    hostView.setPivotX(((Float) pivot.first).floatValue());
                                    hostView.setPivotY(((Float) pivot.second).floatValue());
                                }
                                Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(hostView, (PropertyValuesHolder[]) holders.toArray(new PropertyValuesHolder[holders.size()]));
                                ofPropertyValuesHolder.setStartDelay(this.d.delay);
                                if (!(hostView.getLayoutParams() == null || (TextUtils.isEmpty(style.width) && TextUtils.isEmpty(style.height)))) {
                                    AnimatorUpdateListener bVar = new b(hostView);
                                    LayoutParams layoutParams = hostView.getLayoutParams();
                                    if (!TextUtils.isEmpty(style.width)) {
                                        bVar.a = new m(Integer.valueOf(layoutParams.width), Integer.valueOf((int) WXViewUtils.a(ah.a(style.width), i)));
                                    }
                                    if (!TextUtils.isEmpty(style.height)) {
                                        bVar.b = new m(Integer.valueOf(layoutParams.height), Integer.valueOf((int) WXViewUtils.a(ah.a(style.height), i)));
                                    }
                                    ofPropertyValuesHolder.addUpdateListener(bVar);
                                }
                                animator = ofPropertyValuesHolder;
                                if (animator != null) {
                                    obj = this.c;
                                    if (TextUtils.isEmpty(obj)) {
                                        gVar = new g(this, a, obj);
                                    } else {
                                        gVar = null;
                                    }
                                    if (VERSION.SDK_INT < 18 && a2.isLayerTypeEnabled()) {
                                        a2.getHostView().setLayerType(2, null);
                                    }
                                    a3 = a();
                                    if (gVar != null) {
                                        animator.addListener(gVar);
                                    }
                                    if (a3 != null) {
                                        animator.setInterpolator(a3);
                                    }
                                    animator.setDuration(this.d.duration);
                                    animator.start();
                                }
                            }
                        }
                        animator = null;
                        if (animator != null) {
                            obj = this.c;
                            if (TextUtils.isEmpty(obj)) {
                                gVar = null;
                            } else {
                                gVar = new g(this, a, obj);
                            }
                            a2.getHostView().setLayerType(2, null);
                            a3 = a();
                            if (gVar != null) {
                                animator.addListener(gVar);
                            }
                            if (a3 != null) {
                                animator.setInterpolator(a3);
                            }
                            animator.setDuration(this.d.duration);
                            animator.start();
                        }
                    } catch (Throwable e) {
                        WXLogUtils.e("AnimationAction", WXLogUtils.getStackTrace(e));
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.mini.support.annotation.Nullable
    private android.view.animation.Interpolator a() {
        /*
        r8 = this;
        r5 = 3;
        r4 = 2;
        r3 = 1;
        r0 = 0;
        r1 = 0;
        r2 = r8.d;
        r6 = r2.timingFunction;
        r2 = android.text.TextUtils.isEmpty(r6);
        if (r2 != 0) goto L_0x00ad;
    L_0x000f:
        r2 = -1;
        r7 = r6.hashCode();
        switch(r7) {
            case -1965120668: goto L_0x0069;
            case -1102672091: goto L_0x0086;
            case -789192465: goto L_0x0072;
            case -361990811: goto L_0x007c;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r2;
    L_0x0018:
        switch(r0) {
            case 0: goto L_0x0090;
            case 1: goto L_0x0096;
            case 2: goto L_0x009c;
            case 3: goto L_0x00a2;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = new com.taobao.weex.utils.p;	 Catch:{ RuntimeException -> 0x00aa }
        r2 = r8.d;	 Catch:{ RuntimeException -> 0x00aa }
        r2 = r2.timingFunction;	 Catch:{ RuntimeException -> 0x00aa }
        r3 = new com.taobao.weex.c.a.h;	 Catch:{ RuntimeException -> 0x00aa }
        r3.<init>(r8);	 Catch:{ RuntimeException -> 0x00aa }
        r0.<init>(r2, r3);	 Catch:{ RuntimeException -> 0x00aa }
        r2 = "cubic-bezier";
        r2 = r0.a(r2);	 Catch:{ RuntimeException -> 0x00aa }
        if (r2 == 0) goto L_0x00a8;
    L_0x0031:
        r0 = r2.size();	 Catch:{ RuntimeException -> 0x00aa }
        r3 = 4;
        if (r0 != r3) goto L_0x00a8;
    L_0x0038:
        r0 = 0;
        r0 = r2.get(r0);	 Catch:{ RuntimeException -> 0x00aa }
        r0 = (java.lang.Float) r0;	 Catch:{ RuntimeException -> 0x00aa }
        r3 = r0.floatValue();	 Catch:{ RuntimeException -> 0x00aa }
        r0 = 1;
        r0 = r2.get(r0);	 Catch:{ RuntimeException -> 0x00aa }
        r0 = (java.lang.Float) r0;	 Catch:{ RuntimeException -> 0x00aa }
        r4 = r0.floatValue();	 Catch:{ RuntimeException -> 0x00aa }
        r0 = 2;
        r0 = r2.get(r0);	 Catch:{ RuntimeException -> 0x00aa }
        r0 = (java.lang.Float) r0;	 Catch:{ RuntimeException -> 0x00aa }
        r5 = r0.floatValue();	 Catch:{ RuntimeException -> 0x00aa }
        r0 = 3;
        r0 = r2.get(r0);	 Catch:{ RuntimeException -> 0x00aa }
        r0 = (java.lang.Float) r0;	 Catch:{ RuntimeException -> 0x00aa }
        r0 = r0.floatValue();	 Catch:{ RuntimeException -> 0x00aa }
        r0 = android.mini.support.v4.view.b.c.a(r3, r4, r5, r0);	 Catch:{ RuntimeException -> 0x00aa }
    L_0x0068:
        return r0;
    L_0x0069:
        r3 = "ease-in";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x0071:
        goto L_0x0018;
    L_0x0072:
        r0 = "ease-out";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x0017;
    L_0x007a:
        r0 = r3;
        goto L_0x0018;
    L_0x007c:
        r0 = "ease-in-out";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x0017;
    L_0x0084:
        r0 = r4;
        goto L_0x0018;
    L_0x0086:
        r0 = "linear";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x0017;
    L_0x008e:
        r0 = r5;
        goto L_0x0018;
    L_0x0090:
        r0 = new android.view.animation.AccelerateInterpolator;
        r0.<init>();
        goto L_0x0068;
    L_0x0096:
        r0 = new android.view.animation.DecelerateInterpolator;
        r0.<init>();
        goto L_0x0068;
    L_0x009c:
        r0 = new android.view.animation.AccelerateDecelerateInterpolator;
        r0.<init>();
        goto L_0x0068;
    L_0x00a2:
        r0 = new android.view.animation.LinearInterpolator;
        r0.<init>();
        goto L_0x0068;
    L_0x00a8:
        r0 = r1;
        goto L_0x0068;
    L_0x00aa:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0068;
    L_0x00ad:
        r0 = r1;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.c.a.i.a():android.view.animation.Interpolator");
    }
}
