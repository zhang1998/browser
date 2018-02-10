package com.taobao.weex.utils;

import android.graphics.Color;
import java.util.List;

/* compiled from: ProGuard */
final class ac implements z {
    ac() {
    }

    public final aa a(String str) {
        try {
            List a = new p(str, af.c).a("rgb");
            if (a.size() == 3) {
                return new aa(Color.rgb(((Integer) a.get(0)).intValue(), ((Integer) a.get(1)).intValue(), ((Integer) a.get(2)).intValue()));
            }
            return new aa();
        } catch (RuntimeException e) {
            return new aa();
        }
    }
}
