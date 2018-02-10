package com.ucpro.services.download;

import com.ucpro.business.e.d.g;
import com.ucpro.c.c;
import com.ucpro.model.a.a;

/* compiled from: ProGuard */
public final class b {
    public static int e() {
        return g.a().a("cd_max_thread_num", 32);
    }

    public static int f() {
        return g.a().a("cd_min_thread_num", 5);
    }

    public static boolean a() {
        return a.a.a("download_wifi_switch", false);
    }

    public static int b() {
        return a.a.a("download_cur_thread_num", 0);
    }

    public static boolean c() {
        return a.a.a("download_open_thread_switch", false);
    }

    public static String d() {
        return a.a.a("download_cur_download_path", c.e());
    }
}
