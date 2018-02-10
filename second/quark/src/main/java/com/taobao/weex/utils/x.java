package com.taobao.weex.utils;

/* compiled from: ProGuard */
final class x implements n<Integer> {
    x() {
    }

    public final /* synthetic */ Object a(String str) {
        int i = 255;
        int b = ah.b(str);
        if (b < 0) {
            i = 0;
        } else if (b <= 255) {
            i = b;
        }
        return Integer.valueOf(i);
    }
}
