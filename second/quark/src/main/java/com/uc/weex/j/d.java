package com.uc.weex.j;

import android.content.Context;
import android.mini.support.annotation.Nullable;
import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
public final class d {
    private static boolean b;
    public Object a;

    public d(@Nullable Context context) {
        if (b && context != null) {
            try {
                this.a = Class.forName("com.taobao.weex.analyzer.WeexDevOptions").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            } catch (Exception e) {
            }
        }
    }

    public final View a(ac acVar, View view) {
        if (this.a == null || acVar == null || view == null) {
            return null;
        }
        try {
            return (View) this.a.getClass().getDeclaredMethod("onWeexViewCreated", new Class[]{ac.class, View.class}).invoke(this.a, new Object[]{acVar, view});
        } catch (Exception e) {
            return view;
        }
    }
}
