package com.alibaba.appmonitor.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.b.a;
import com.alibaba.analytics.core.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class g {
    private static final Map<String, String> a;

    public static Map<String, String> a() {
        Context context = b.a().b;
        if (context != null) {
            CharSequence a;
            if (!a.containsKey("pt")) {
                a = a(context, "package_type");
                if (TextUtils.isEmpty(a)) {
                    a.put("pt", "");
                } else {
                    a.put("pt", a);
                }
            }
            if (!a.containsKey("pid")) {
                a = a(context, "project_id");
                if (TextUtils.isEmpty(a)) {
                    a.put("pid", "");
                } else {
                    a.put("pid", a);
                }
            }
            if (!a.containsKey("bid")) {
                a = a(context, "build_id");
                if (TextUtils.isEmpty(a)) {
                    a.put("bid", "");
                } else {
                    a.put("bid", a);
                }
            }
            if (!a.containsKey("bv")) {
                CharSequence a2 = a(context, "base_version");
                if (TextUtils.isEmpty(a2)) {
                    a.put("bv", "");
                } else {
                    a.put("bv", a2);
                }
            }
        }
        a.put("hv", b());
        if (!a.containsKey("sdk-version")) {
            a.a();
            a.put("sdk-version", a.b());
        }
        return a;
    }

    private static String b() {
        String str = null;
        try {
            Object a = u.a("com.taobao.updatecenter.hotpatch.HotPatchManager", "getInstance");
            if (a != null) {
                a = u.a(a, "getPatchSuccessedVersion");
                if (a != null) {
                    str = String.valueOf(a);
                }
            }
        } catch (Throwable th) {
        }
        return str;
    }

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        a.a();
        hashMap.put("sdk-version", a.b());
    }

    private static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        int identifier;
        try {
            identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Throwable th) {
            af.c("SdkMeta", "getString Id error", th);
            identifier = 0;
        }
        if (identifier != 0) {
            return context.getString(identifier);
        }
        return null;
    }
}
