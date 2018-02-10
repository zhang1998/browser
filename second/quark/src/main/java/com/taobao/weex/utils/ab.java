package com.taobao.weex.utils;

import android.graphics.Color;
import java.util.List;

/* compiled from: ProGuard */
final class ab implements z {
    ab() {
    }

    public final aa a(String str) {
        try {
            List a = new p(str, af.d).a("rgba");
            if (a.size() == 4) {
                return new aa(Color.argb((int) (((Number) a.get(3)).floatValue() * 255.0f), ((Number) a.get(0)).intValue(), ((Number) a.get(1)).intValue(), ((Number) a.get(2)).intValue()));
            }
            return new aa();
        } catch (Exception e) {
            return new aa();
        }
    }
}
