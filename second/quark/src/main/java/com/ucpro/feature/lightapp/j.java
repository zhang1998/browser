package com.ucpro.feature.lightapp;

import android.text.TextUtils;
import com.uc.a.d.l;
import com.ucpro.business.d.c;
import com.ucpro.business.d.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class j {
    private List<String> a;

    final synchronized List<String> a() {
        if (this.a == null) {
            this.a = new ArrayList();
            byte[] a = l.a("light_app_category_black_list");
            if (a != null) {
                d dVar = new d();
                if (dVar.a(a)) {
                    int size = dVar.a.size();
                    for (int i = 0; i < size; i++) {
                        CharSequence c = ((c) dVar.a.get(i)).c();
                        if (!TextUtils.isEmpty(c)) {
                            this.a.add(c);
                        }
                    }
                }
            }
        }
        return this.a;
    }
}
