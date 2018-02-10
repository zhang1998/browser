package com.taobao.weex.d;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.Map;

/* compiled from: ProGuard */
public final class e {
    private static String a = null;

    public static String a(Context context, Map<String, String> map) {
        if (TextUtils.isEmpty(a)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) map.get("sysModel")).append("(Android/").append((String) map.get("sysVersion")).append(") ").append(TextUtils.isEmpty((CharSequence) map.get("appGroup")) ? "" : (String) map.get("appGroup")).append("(").append(TextUtils.isEmpty((CharSequence) map.get("appName")) ? "" : (String) map.get("appName")).append("/").append((String) map.get("appVersion")).append(") Weex/").append((String) map.get("weexVersion")).append(" ").append(TextUtils.isEmpty((CharSequence) map.get("externalUserAgent")) ? "" : (String) map.get("externalUserAgent")).append(TextUtils.isEmpty((CharSequence) map.get("externalUserAgent")) ? "" : " ").append(WXViewUtils.b(context) + "x" + WXViewUtils.c(context));
            a = stringBuilder.toString();
        }
        return a;
    }
}
