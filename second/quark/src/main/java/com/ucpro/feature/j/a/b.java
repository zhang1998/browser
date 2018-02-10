package com.ucpro.feature.j.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.model.a.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    private static b a;
    private List<a> b;

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private b() {
    }

    @NonNull
    public static List<Integer> b() {
        List<Integer> arrayList = new ArrayList();
        for (Object obj : a.a.a("setting_selected_shortcut_menu", "").split(",")) {
            if (!TextUtils.isEmpty(obj)) {
                arrayList.add(Integer.valueOf(obj));
            }
        }
        return arrayList;
    }

    public final List<a> c() {
        if (this.b == null) {
            this.b = new ArrayList();
            this.b.add(a(1, 0, R.string.browse_setting_item_no_image, "menu_nopic_enable.svg", "menu_nopic.svg"));
            this.b.add(a(2, 1, R.string.browser_setting_item_smart_reader, "menu_smart_reader_enable.svg", "menu_smart_reader.svg"));
            this.b.add(a(3, 2, R.string.common_cloud_acceleration, "menu_cloud_acceleration_enable.svg", "menu_cloud_acceleration.svg"));
            this.b.add(a(4, 3, R.string.common_adapt_screen, "menu_adapte_screen_enable.svg", "menu_adapte_screen.svg"));
            this.b.add(a(5, 4, R.string.common_ua_setting, "menu_ua.svg", "menu_ua.svg"));
            this.b.add(a(6, 5, R.string.context_menu_search_in_page, "menu_search_in_page.svg", "menu_search_in_page.svg"));
        }
        a(this.b);
        return this.b;
    }

    private static void a(List<a> list) {
        List b = b();
        for (a aVar : list) {
            boolean a;
            if (aVar == null || !b.contains(Integer.valueOf(aVar.a))) {
                aVar.e = false;
            } else {
                aVar.e = true;
            }
            switch (aVar.a) {
                case 1:
                    a = a.a.a("setting_enable_smart_no_image", false);
                    break;
                case 2:
                    a = a.a.a("setting_smart_reader", false);
                    break;
                case 3:
                    a = a.a.a("setting_webcore_network_proxy", false);
                    break;
                case 4:
                    a = a.a.a("setting_enable_adapt_screen", false);
                    break;
                default:
                    a = false;
                    break;
            }
            if (a) {
                aVar.f = aVar.g;
            } else {
                aVar.f = aVar.h;
            }
        }
    }

    private static a a(int i, int i2, int i3, String str, String str2) {
        a aVar = new a();
        aVar.a = i;
        aVar.b = i2;
        aVar.d = i3;
        aVar.c = com.ucpro.ui.c.a.d(i3);
        aVar.e = false;
        aVar.f = str2;
        aVar.g = str;
        aVar.h = str2;
        return aVar;
    }

    public static boolean d() {
        return a.a.a("setting_shortcut_menu_enable", false);
    }
}
