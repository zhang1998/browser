package com.ucpro.visible;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.ucpro.e.o;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class PlayReferrerReceiver extends BroadcastReceiver {
    private static final String[] a = new String[]{"utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign"};

    public final void onReceive(Context context, Intent intent) {
        if (!o.a(intent) && intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
            Object stringExtra = intent.getStringExtra("referrer");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String decode = URLDecoder.decode(stringExtra, "UTF-8");
                    Map hashMap = new HashMap();
                    for (String split : decode.split("&")) {
                        String[] split2 = split.split("=");
                        hashMap.put(split2[0], split2[1]);
                        new StringBuilder("[referrer] ").append(split2[0]).append("=").append(split2[1]);
                    }
                    a(context, hashMap);
                } catch (UnsupportedEncodingException e) {
                    Log.w("referrer", "unsupported encoding");
                }
            }
        }
    }

    private static void a(Context context, Map<String, String> map) {
        Editor edit = context.getSharedPreferences("__referrer", 0).edit();
        for (String str : a) {
            String str2 = (String) map.get(str);
            if (str2 != null) {
                edit.putString(str, str2);
            }
        }
        edit.commit();
    }

    public static String a(String str) {
        c.a((CharSequence) str);
        return d.a().getSharedPreferences("__referrer", 0).getString(str, "");
    }
}
