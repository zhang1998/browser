package com.uc.quark.filedownloader.message;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class j {
    final List<f> a = new ArrayList();
    final c b;

    j(c cVar) {
        this.b = cVar;
        for (int i = 0; i < 5; i++) {
            this.a.add(new f(this, i));
        }
    }
}
