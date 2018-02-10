package com.taobao.weex.utils;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class y implements o<Number> {
    y() {
    }

    public final List<Number> a(List<String> list) {
        List<Number> arrayList = new ArrayList(4);
        int i = 0;
        while (i < 3) {
            int b = ah.b((String) list.get(i));
            if (b < 0) {
                b = 0;
            } else if (b > 255) {
                b = 255;
            }
            arrayList.add(Integer.valueOf(b));
            i++;
        }
        arrayList.add(Float.valueOf((String) list.get(i)));
        return arrayList;
    }
}
