package com.taobao.weex.ui;

import android.text.TextUtils;
import com.taobao.weex.ad;
import com.taobao.weex.bridge.s;
import com.taobao.weex.common.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class i {
    private static Map<String, b> a = new HashMap();
    private static ArrayList<Map<String, Object>> b = new ArrayList();

    public static boolean a(String str, b bVar, Map<String, Object> map) throws h {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        s.a().a(new g(map, str, bVar));
        return true;
    }

    private static boolean b(String str, b bVar) throws h {
        try {
            bVar.b();
            a.put(str, bVar);
        } catch (ArrayStoreException e) {
        }
        return true;
    }

    public static b a(String str) {
        return (b) a.get(str);
    }

    public static void a() {
        s.a().a(new h());
    }

    static /* synthetic */ boolean a(Map map) throws h {
        List arrayList = new ArrayList();
        arrayList.add(map);
        ad.a().b.a(arrayList);
        return true;
    }
}
