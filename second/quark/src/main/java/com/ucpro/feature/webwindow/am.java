package com.ucpro.feature.webwindow;

import android.content.Context;
import com.ucweb.common.util.h.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class am {
    int a;
    bd b;
    private List<WeakReference<Object>> c;

    private am() {
        this.a = v.a;
    }

    public final synchronized void a(Context context) {
        switch (bl.a[this.a - 1]) {
            case 1:
                this.a = v.b;
                this.b = new bd(this, context);
                m.a(2, new p(this));
                break;
            case 3:
                for (WeakReference weakReference : a()) {
                    if (!(weakReference == null || weakReference.get() == null)) {
                        weakReference.get();
                    }
                }
                break;
        }
    }

    final List<WeakReference<Object>> a() {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        return this.c;
    }
}
