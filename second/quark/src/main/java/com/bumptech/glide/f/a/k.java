package com.bumptech.glide.f.a;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bumptech.glide.f.b;
import com.bumptech.glide.util.j;
import com.quark.browser.R;

/* compiled from: ProGuard */
public abstract class k<T extends View, Z> extends a<Z> {
    private static boolean b = false;
    @Nullable
    private static Integer c = null;
    protected final T a;
    private final j d;

    public k(T t) {
        this.a = (View) j.a((Object) t, "Argument must not be null");
        this.d = new j(t);
    }

    public final void a(g gVar) {
        j jVar = this.d;
        int c = jVar.c();
        int b = jVar.b();
        if (jVar.b(c, b)) {
            gVar.a(c, b);
            return;
        }
        if (!jVar.b.contains(gVar)) {
            jVar.b.add(gVar);
        }
        if (jVar.c == null) {
            ViewTreeObserver viewTreeObserver = jVar.a.getViewTreeObserver();
            jVar.c = new i(jVar);
            viewTreeObserver.addOnPreDrawListener(jVar.c);
        }
    }

    public final void b(g gVar) {
        this.d.b.remove(gVar);
    }

    public void a(Drawable drawable) {
        super.a(drawable);
        this.d.a();
    }

    public String toString() {
        return "Target for: " + this.a;
    }

    public static void e() {
        if (c != null || b) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        c = Integer.valueOf(R.id.glide_tag);
    }

    public final void a(@Nullable b bVar) {
        if (c == null) {
            b = true;
            this.a.setTag(bVar);
            return;
        }
        this.a.setTag(c.intValue(), bVar);
    }

    @Nullable
    public final b d() {
        Object tag;
        if (c == null) {
            tag = this.a.getTag();
        } else {
            tag = this.a.getTag(c.intValue());
        }
        if (tag == null) {
            return null;
        }
        if (tag instanceof b) {
            return (b) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
}
