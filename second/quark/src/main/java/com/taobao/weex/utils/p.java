package com.taobao.weex.utils;

import android.mini.support.annotation.NonNull;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class p<V> extends f<String, List<V>> {
    public p(@NonNull String str, @NonNull n<V> nVar) {
        super(str, new l(nVar));
    }

    public p(@NonNull String str, @NonNull o<V> oVar) {
        super(str, new m(oVar));
    }

    public final List<V> a(String str) {
        Map a = a();
        if (a.containsKey(str)) {
            return (List) a.get(str);
        }
        return null;
    }
}
