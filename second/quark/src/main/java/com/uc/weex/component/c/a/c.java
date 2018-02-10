package com.uc.weex.component.c.a;

import android.view.MotionEvent;
import android.view.View;
import com.uc.weex.component.c.a.a.a;

/* compiled from: ProGuard */
public final class c extends q {
    public c(a aVar) {
        this(aVar, (byte) 0);
    }

    private c(a aVar, byte b) {
        super(aVar);
        this.k = aVar.a().getTranslationX();
    }

    protected final n a() {
        return new b();
    }

    protected final j b() {
        return new a();
    }

    protected final void a(View view, float f) {
        view.setTranslationX(f);
    }

    protected final void a(View view, float f, MotionEvent motionEvent) {
        view.setTranslationX(f);
        motionEvent.offsetLocation(f - motionEvent.getX(0), 0.0f);
    }

    protected final float c() {
        return d().getTranslationX();
    }
}
