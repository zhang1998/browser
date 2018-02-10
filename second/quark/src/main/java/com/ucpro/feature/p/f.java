package com.ucpro.feature.p;

import com.quark.browser.R;
import com.ucweb.common.util.p.b;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class f {
    private static b a;
    private static b b;
    private static g c;
    private static g d;

    public static g a(int i) {
        if (i == 4) {
            if (d == null) {
                g gVar = new g();
                gVar.c = new ArrayList();
                gVar.c.add(new b[]{new b(24, "menu_smart_reader.svg", "menu_icon_bg_1080p.png", R.string.browser_setting_item_smart_reader, b.H), new b(25, "menu_adapte_screen.svg", "menu_icon_bg_1080p.png", R.string.common_adapt_screen, b.I), new b(32, "menu_cloud_acceleration.svg", "menu_icon_bg_1080p.png", R.string.common_cloud_acceleration, b.J), new b(33, "menu_nopic.svg", "menu_icon_bg_1080p.png", R.string.browse_setting_item_no_image, b.K)});
                gVar.c.add(new b[]{new b(35, "menu_ua.svg", "menu_icon_bg_1080p.png", R.string.common_ua_setting, b.M), new b(36, "menu_search_in_page.svg", "menu_icon_bg_1080p.png", R.string.context_menu_search_in_page, b.N), null, new b(37, "menu_toolbox_back.svg", "menu_icon_bg_1080p.png", -1, b.O)});
                gVar.a = new b(38, "menu_toolbox_setting.svg", "menu_icon_bg_1080p.png", R.string.toolbox_panel_title, b.P);
                gVar.a.d = R.string.toolbox_panel_subtitle;
                d = gVar;
            }
            return d;
        }
        if (c == null) {
            gVar = new g();
            gVar.c = new ArrayList();
            Object obj = new b[4];
            obj[0] = new b(16, "menu_bookmark_history.svg", "menu_icon_bg_1080p.png", R.string.bookmark_history, b.j);
            obj[1] = new b(3, "menu_download.svg", "menu_icon_bg_1080p.png", R.string.download, b.k);
            obj[2] = new b(2, "menu_setting.svg", "menu_icon_bg_1080p.png", R.string.setting, b.t);
            obj[3] = new b(9, "menu_refresh.svg", "menu_icon_bg_1080p.png", R.string.refresh, b.s);
            gVar.c.add(obj);
            obj = new b[4];
            obj[0] = new b(18, "menu_incognito.svg", "menu_icon_bg_1080p.png", R.string.incognito, b.o);
            obj[1] = new b(7, "menu_collected.svg", "menu_icon_bg_1080p.png", R.string.collect, b.i);
            obj[2] = new b(19, "menu_night_mode.svg", "menu_icon_bg_1080p.png", R.string.night_mode, b.r);
            a = new b(22, "menu_toolbox.svg", "menu_icon_bg_1080p.png", R.string.toolbox, b.F);
            obj[3] = a;
            gVar.c.add(obj);
            b = new b(21, "menu_goto_origin.svg", "menu_icon_bg_1080p.png", R.string.goto_origin, b.x);
            c = gVar;
        }
        b[] bVarArr = (b[]) c.c.get(1);
        if (i == 0 || i == 1) {
            bVarArr[3] = a;
        } else if (i == 2 || i == 3) {
            bVarArr[3] = b;
        }
        c.a = new b(23, "menu_personal_default_icon.png", "menu_icon_bg_1080p.png", R.string.personal_login_menu_title, b.G);
        c.a.d = R.string.bookmark_cloudbar_title;
        c.b = new b(6, "menu_share.svg", "menu_icon_bg_1080p.png", R.string.share, b.u);
        return c;
    }
}
