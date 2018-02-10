package com.e.b.b.a;

import android.app.Activity;
import android.os.Build.VERSION;
import com.e.b.b.c.d;
import com.e.b.b.c.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ProGuard */
public final class a implements d {
    private static a a = new a();
    private List<Object> b = new LinkedList();

    private a() {
        if (VERSION.SDK_INT >= 14) {
            e.a(this);
        }
    }

    public static a a() {
        return a;
    }

    public final void b() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void a(Activity activity) {
    }

    public final void b(Activity activity) {
    }

    public final void c(Activity activity) {
    }

    public final void d(Activity activity) {
    }
}
