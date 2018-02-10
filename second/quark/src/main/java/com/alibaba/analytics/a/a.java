package com.alibaba.analytics.a;

import android.text.TextUtils;
import java.util.Comparator;

/* compiled from: ProGuard */
final class a implements Comparator<String> {
    final /* synthetic */ n a;

    private a(n nVar) {
        this.a = nVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        return str.compareTo(str2) * -1;
    }
}
