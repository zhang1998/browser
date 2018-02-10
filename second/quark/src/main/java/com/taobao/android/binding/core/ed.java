package com.taobao.android.binding.core;

import android.mini.support.annotation.Nullable;
import android.view.View;
import com.taobao.weex.ad;
import com.taobao.weex.ui.component.ab;

/* compiled from: ProGuard */
final class ed {
    @Nullable
    static View a(@Nullable String str, @Nullable String str2) {
        ab b = b(str, str2);
        if (b == null) {
            return null;
        }
        return b.getHostView();
    }

    @Nullable
    static ab b(@Nullable String str, @Nullable String str2) {
        return ad.a().c.a(str, str2);
    }
}
