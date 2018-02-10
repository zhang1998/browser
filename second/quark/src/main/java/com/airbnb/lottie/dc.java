package com.airbnb.lottie;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class dc {
    final List<bl<?, Path>> a;
    final List<j> b;

    dc(List<j> list) {
        this.b = list;
        this.a = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(((j) list.get(i)).b.a());
        }
    }
}
