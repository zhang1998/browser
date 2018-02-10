package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
abstract class f {
    abstract void a();

    abstract void a(@NonNull c cVar);

    abstract void b();

    f() {
    }

    static f c() {
        if (VERSION.SDK_INT >= 16) {
            return new d();
        }
        return new e();
    }
}
