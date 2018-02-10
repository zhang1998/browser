package com.uc.weex.component.c.a;

import android.view.MotionEvent;
import android.view.View;
import com.uc.weex.component.c.a.a.a;

/* compiled from: ProGuard */
public final class t extends q {
    public t(a aVar) {
        this(aVar, (byte) 0);
    }

    private t(a aVar, byte b) {
        super(aVar);
        this.k = aVar.a().getTranslationY();
    }

    protected final n a() {
        return new s();
    }

    protected final j b() {
        return new r();
    }

    protected final void a(View view, float f) {
        view.setTranslationY(f);
    }

    protected final void a(View view, float f, MotionEvent motionEvent) {
        view.setTranslationY(f);
        motionEvent.offsetLocation(f - motionEvent.getY(0), 0.0f);
    }

    protected final float c() {
        return d().getTranslationY();
    }
}
