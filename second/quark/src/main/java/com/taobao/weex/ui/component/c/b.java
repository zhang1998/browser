package com.taobao.weex.ui.component.c;

import android.mini.support.annotation.Nullable;

/* compiled from: ProGuard */
public final class b {
    private int[] a = new int[4];

    public b() {
        for (int i = 0; i < this.a.length; i++) {
            this.a[i] = 0;
        }
    }

    public final void a(int i, boolean z) {
        this.a[i] = z ? 1 : 0;
    }

    private boolean a(int i) {
        return this.a[i] == 1;
    }

    @Nullable
    public final String a() {
        StringBuilder stringBuilder = new StringBuilder();
        if (a(0)) {
            stringBuilder.append(":active");
        }
        if (a(3)) {
            stringBuilder.append(":disabled");
        }
        if (a(1) && !a(3)) {
            stringBuilder.append(":focus");
        }
        return stringBuilder.length() == 0 ? null : stringBuilder.toString();
    }
}
