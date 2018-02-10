package com.taobao.weex.utils;

import android.graphics.Color;

/* compiled from: ProGuard */
final class ae implements z {
    ae() {
    }

    public final aa a(String str) {
        try {
            if (str.length() == 4) {
                int parseInt = Integer.parseInt(str.substring(1, 2), 16);
                int parseInt2 = Integer.parseInt(str.substring(2, 3), 16);
                int parseInt3 = Integer.parseInt(str.substring(3, 4), 16);
                return new aa(Color.rgb(parseInt + (parseInt << 4), parseInt2 + (parseInt2 << 4), parseInt3 + (parseInt3 << 4)));
            } else if (str.length() == 7 || str.length() == 9) {
                return new aa(Color.parseColor(str));
            } else {
                return new aa();
            }
        } catch (Exception e) {
            return new aa();
        }
    }
}
