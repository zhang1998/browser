package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.structure.database.transaction.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class h implements j<m> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ s b;

    public h(s sVar, ValueCallback valueCallback) {
        this.b = sVar;
        this.a = valueCallback;
    }

    public final void a(List<m> list) {
        if (this.a != null) {
            if (list == null) {
                list = new ArrayList();
            }
            this.a.onReceiveValue(list);
        }
    }
}
