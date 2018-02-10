package com.ucpro.feature.video.g;

import com.uc.apollo.impl.SettingsConst;
import com.uc.media.interfaces.IApolloHelper.Apollo;
import com.ucpro.business.stat.m;
import com.ucpro.feature.video.player.e;
import com.ucweb.common.util.d;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class a {
    static long a = 0;
    static long b = 0;
    static int c = 0;

    public static final void a(e eVar) {
        if (eVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("v_title", eVar.q);
            hashMap.put("v_pu", eVar.o);
            hashMap.put("v_vu", eVar.p);
            hashMap.put("v_dur", String.valueOf(eVar.g / 1000));
            m.a("video", "v_play", hashMap);
        }
    }

    public static final void b(e eVar) {
        if (eVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("v_title", eVar.q);
            hashMap.put("v_pu", eVar.o);
            hashMap.put("v_vu", eVar.p);
            hashMap.put("v_dur", SettingsConst.FALSE);
            m.a("video", "v_error", hashMap);
        }
    }

    public static void a(String str, String str2, int i) {
        boolean isInitialized = Apollo.isInitialized(d.a());
        HashMap hashMap = new HashMap();
        hashMap.put("v_vu", str);
        hashMap.put("v_pu", str2);
        hashMap.put("h_apo", String.valueOf(isInitialized));
        m.a("video", "vid_sta_l", hashMap);
        a = System.currentTimeMillis();
        c = i;
    }

    public static void a(String str, String str2, int i, int i2) {
        if (c == i2) {
            HashMap hashMap = new HashMap();
            hashMap.put("v_pu", str);
            hashMap.put("v_vu", str2);
            hashMap.put("v_dur", String.valueOf(i));
            if (a != 0) {
                b = System.currentTimeMillis();
                hashMap.put("l_dur", String.valueOf(b - a));
                a = 0;
            }
            m.a("video", "vid_loa_s", hashMap);
        }
    }

    public static void b(String str, String str2, int i, int i2) {
        if (c == i2) {
            HashMap hashMap = new HashMap();
            hashMap.put("v_pu", str);
            hashMap.put("v_vu", str2);
            hashMap.put("w_cod", String.valueOf(i));
            if (a != 0) {
                hashMap.put("l_dur", String.valueOf(System.currentTimeMillis() - a));
                a = 0;
            }
            m.a("video", "vid_loa_w", hashMap);
        }
    }

    public static void b(String str, String str2, int i) {
        if (c != i) {
            return;
        }
        if (a != 0 || b != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("v_pu", str);
            hashMap.put("v_vu", str2);
            if (a != 0) {
                hashMap.put("l_dur", String.valueOf(System.currentTimeMillis() - a));
                a = 0;
            } else if (b != 0) {
                hashMap.put("p_dur", String.valueOf(System.currentTimeMillis() - b));
                b = 0;
            }
            m.a("video", "vid_des", hashMap);
        }
    }

    public static void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_pu", str);
        m.a("video", "vid_req_r_l", hashMap);
    }

    public static void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_pu", str);
        m.a("video", "vid_req_r_l_suc", hashMap);
    }

    public static void a(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_pu", str);
        hashMap.put("w_cod", String.valueOf(i));
        m.a("video", "vid_req_r_l_fai", hashMap);
    }

    public static void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_pu", str);
        hashMap.put("v_res", str2);
        m.a("video", "vid_req_r_u", hashMap);
    }

    public static void a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_pu", str);
        hashMap.put("v_res", str2);
        hashMap.put("v_vu", str3);
        m.a("video", "vid_req_r_u_suc", hashMap);
    }

    public static void c(String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_pu", str);
        hashMap.put("v_res", str2);
        hashMap.put("w_cod", String.valueOf(i));
        m.a("video", "vid_req_r_u_fai", hashMap);
    }

    public static void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_is_cor_p", String.valueOf(z));
        m.a("video", "vid_ent_ful", hashMap);
    }

    public static void a() {
        m.a("video", "vid_get_cor_v", new String[0]);
    }

    public static void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_is_ind", String.valueOf(i));
        m.a("video", "vid_get_she_v", hashMap);
    }

    public static void b(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", String.valueOf(z));
        m.a("video", "vid_cli_lit_w", hashMap);
    }

    public static void b() {
        m.a("video", "vid_ent_fro_l_w", new String[0]);
    }

    public static void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_vu", String.valueOf(str));
        m.a("video", "vid_res_for", hashMap);
    }

    public static void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("v_vu", String.valueOf(str));
        m.a("video", "vid_cac_for", hashMap);
    }
}
