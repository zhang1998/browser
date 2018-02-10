package com.taobao.weex.ui.component.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class b implements d {
    private WeakReference<Activity> a;
    private WeakReference<OnGlobalLayoutListener> b;

    public b(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.a = new WeakReference(activity);
        this.b = new WeakReference(onGlobalLayoutListener);
    }

    public final void a() {
        Activity activity = (Activity) this.a.get();
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.b.get();
        if (!(activity == null || onGlobalLayoutListener == null)) {
            View a = e.a(activity);
            if (a != null) {
                if (VERSION.SDK_INT >= 16) {
                    a.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                } else {
                    a.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
                }
            }
        }
        this.a.clear();
        this.b.clear();
    }
}
