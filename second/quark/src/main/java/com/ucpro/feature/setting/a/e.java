package com.ucpro.feature.setting.a;

import com.quark.browser.R;
import com.ucpro.business.e.d.g;
import com.ucpro.feature.defaultbrowser.m;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.p.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class e {
    private List<d> a;
    private List<d> b;
    private List<d> c;
    private List<d> d;
    private boolean e;

    private e() {
        this.e = false;
    }

    private static d a(byte b, int i, String str, String str2, boolean z) {
        d dVar = new d();
        dVar.a = b;
        dVar.b = str;
        dVar.d = str2;
        dVar.e = z;
        dVar.c = i;
        return dVar;
    }

    public final List<d> a(byte b) {
        switch (b) {
            case (byte) 0:
                if (this.a != null) {
                    this.a.isEmpty();
                }
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.clear();
                if (!m.i()) {
                    this.a.add(a((byte) 0, h.b, a.d((int) R.string.main_setting_item_default_browser_title), "true", true));
                }
                d a = a((byte) 1, h.y, a.d((int) R.string.main_setting_item_clear_common), "", true);
                a.g = b.m;
                this.a.add(a);
                a = a((byte) 1, h.g, a.d((int) R.string.feedback), "", true);
                a.g = b.l;
                this.a.add(a);
                this.a.add(a((byte) 1, h.d, a.d((int) R.string.main_setting_item_about_browser_title), "", true));
                this.a.add(a((byte) 1, h.e, a.d((int) R.string.main_setting_item_quark_lab_title), "", true));
                if (g.a().c("tips_dot_prizes_switch") && com.ucpro.feature.w.b.a()) {
                    this.a.add(a((byte) 7, h.f, a.d((int) R.string.main_setting_item_prizes), "", com.ucpro.services.a.a.a.b("56DB53DAD2D33272456868E88138FD31")));
                }
                if (com.ucpro.c.b.b()) {
                    a = a((byte) 1, h.B, a.d((int) R.string.developer_option_window_title_debug), "", true);
                } else {
                    a = a((byte) 1, h.B, a.d((int) R.string.developer_option_window_title_release), "", true);
                }
                a.f = new a(this);
                this.a.add(a);
                return this.a;
            case (byte) 2:
                if (this.b == null || this.b.isEmpty()) {
                    if (this.b == null) {
                        this.b = new ArrayList();
                    }
                    this.b.clear();
                    this.b.add(a((byte) 2, h.h, a.d((int) R.string.wipe_cache_setting_item_wipe_inpue_and_search_record), "false", false));
                    this.b.add(a((byte) 2, h.i, a.d((int) R.string.wipe_cache_setting_item_wipe_username_and_password_record), "false", false));
                    this.b.add(a((byte) 2, h.j, a.d((int) R.string.wipe_cache_setting_item_wipe_cookies), "false", false));
                    this.b.add(a((byte) 2, h.k, a.d((int) R.string.wipe_cache_setting_item_wipe_history_record), "false", false));
                    this.b.add(a((byte) 2, h.l, a.d((int) R.string.wipe_cache_setting_item_wipe_cached_file), "false", false));
                }
                return this.b;
            case (byte) 3:
                if (this.c == null || this.c.isEmpty()) {
                    if (this.c == null) {
                        this.c = new ArrayList();
                    }
                    this.c.clear();
                    this.c.add(a((byte) -1, h.a, a.d((int) R.string.common_normal_text), "true", true));
                    this.c.add(a((byte) 1, h.c, a.d((int) R.string.common_clear_cache), "true", true));
                    this.c.add(a((byte) 6, h.z, a.d((int) R.string.common_search_engine), "true", true));
                    this.c.add(a((byte) 6, h.A, a.d((int) R.string.common_ua_setting), "true", true));
                    this.c.add(a((byte) 1, h.M, a.d((int) R.string.common_adblock), "true", true));
                    this.c.add(a((byte) -1, h.a, a.d((int) R.string.common_browse_text), "true", true));
                    this.c.add(a((byte) 0, h.w, a.d((int) R.string.common_show_statusbar), "true", true));
                    this.c.add(a((byte) 0, h.G, a.d((int) R.string.common_smart_no_map), "true", true));
                    this.c.add(a((byte) 0, h.I, a.d((int) R.string.common_smart_page), "true", true));
                    this.c.add(a((byte) 0, h.J, a.d((int) R.string.common_adapt_screen), "true", true));
                    this.c.add(a((byte) 1, h.H, a.d((int) R.string.common_font_size), "true", true));
                    this.c.add(a((byte) -1, h.a, a.d((int) R.string.common_toolbar_text), "true", true));
                    this.c.add(a((byte) 6, h.Q, a.d((int) R.string.common_toolbar_style), "true", true));
                    this.c.add(a((byte) -1, h.a, a.d((int) R.string.common_advance_text), "true", true));
                    this.c.add(a((byte) 6, h.x, a.d((int) R.string.common_crash_recovery), "true", true));
                    this.c.add(a((byte) 0, h.E, a.d((int) R.string.common_cloud_acceleration), "true", true));
                }
                return this.c;
            case (byte) 6:
                if (this.d == null || this.d.isEmpty()) {
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    this.d.clear();
                    this.d.add(a((byte) 0, h.S, a.d((int) R.string.quark_lab_wallper_setting_enable_wallpaper), "true", true));
                    this.d.add(a((byte) 0, h.T, a.d((int) R.string.quark_lab_wallper_setting_enable_logo), "true", true));
                    this.d.add(a((byte) 1, h.U, a.d((int) R.string.quark_lab_wallper_setting_select_from_album), "", true));
                    this.d.add(a((byte) 6, h.V, a.d((int) R.string.quark_lab_wallper_setting_official_wallpaper), "true", true));
                    this.d.add(a((byte) 1, h.W, a.d((int) R.string.quark_lab_wallper_setting_share_wallpaper), "", true));
                }
                return this.d;
            default:
                return null;
        }
    }
}
