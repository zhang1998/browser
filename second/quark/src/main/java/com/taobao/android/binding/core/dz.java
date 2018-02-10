package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.uc.webview.export.cd.CDController;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class dz {
    @Nullable
    static String a(@NonNull Map<String, Object> map, @NonNull String str) {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    @Nullable
    static List<Map<String, Object>> a(@NonNull Map<String, Object> map) {
        Object obj = map.get("props");
        if (obj == null) {
            return null;
        }
        try {
            return (List) obj;
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    static av b(@NonNull Map<String, Object> map, @NonNull String str) {
        String a = a(map, str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            Map b = a.b(a);
            Object a2 = a(b, CDController.ORIGIN_DATA_FILE_NAME);
            Object a3 = a(b, "transformed");
            if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(a3)) {
                return av.a(null, a);
            }
            return av.a(a2, a3);
        } catch (Exception e) {
            return av.a(null, a);
        }
    }

    @SafeVarargs
    static <E> HashSet<E> a(E... eArr) {
        Object hashSet = new HashSet(eArr.length);
        Collections.addAll(hashSet, eArr);
        return hashSet;
    }
}
