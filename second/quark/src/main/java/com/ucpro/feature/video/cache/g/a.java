package com.ucpro.feature.video.cache.g;

import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public final class a {
    public static String a = "m3u8";
    public static String b = "normal";
    private static String c = "video_cache";

    public static void a(String str) {
        m.a(c, "cache_start", "type", str);
    }

    public static void a(String str, String str2) {
        m.a(c, "msg", str, "m3u8_fail", "url", str2);
    }

    public static void b(String str, String str2) {
        m.a(c, "m3u8_re_request", "url", str2, "code", str);
    }

    public static void b(String str) {
        m.a(c, "m3u8_second_req", "url", str);
    }

    public static void a(int i) {
        m.a(c, "m3u8_ts_count", "ts_count", String.valueOf(i));
    }

    public static void c(String str) {
        m.a(c, "cached_video_play", "type", str);
    }

    public static void d(String str) {
        m.a(c, "play_http_server", "error", str);
    }
}
