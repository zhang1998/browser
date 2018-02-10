package com.ucpro.feature.video.cache;

import com.ucpro.c.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class a {
    public static void a(String str, String str2, String str3, String str4) {
        if (b.b()) {
            new StringBuilder("请求下载视频, Url is: ").append(str).append(", page url is:").append(str3);
        }
        if (com.ucpro.feature.video.cache.c.a.a(str3)) {
            com.ucpro.feature.video.g.a.d(str3);
            e.a().a("由于版权原因，该网站视频不支持缓存", 0);
            return;
        }
        m.a(3, new b(str3, str4, str, str2));
    }

    public static void a(String str, String str2, String str3) {
        a(str, str3, str2, "");
    }
}
