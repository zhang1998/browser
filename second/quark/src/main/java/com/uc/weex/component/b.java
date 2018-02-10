package com.uc.weex.component;

import android.widget.ImageView;
import com.uc.weex.component.e.l;

/* compiled from: ProGuard */
public class b {
    private static volatile b a;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static void a(b bVar) {
        a = bVar;
    }

    public f a(String str) {
        return null;
    }

    public void b(String str) {
    }

    public l c(String str) {
        return null;
    }

    public void a(String str, l lVar) {
    }

    public d b() {
        return new a(this);
    }

    public void a(boolean z) {
    }

    public void a(String str, ImageView imageView) {
    }
}
