package com.ucpro.feature.setting.d;

import com.quark.browser.R;
import com.uc.apollo.media.MediaDefines;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import com.ucpro.feature.setting.e.b;
import com.ucpro.feature.setting.e.f;
import com.ucpro.feature.setting.view.a.c;
import com.ucpro.ui.c.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class m implements x, c {
    q a;
    int[] b;
    String[] c;

    public m() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.b = new int[]{80, 90, 100, MediaDefines.MSG_ENABLE_VR_MODE, 140};
        this.c = new String[]{a.d((int) R.string.broswse_setting_item_tip_text_small), a.d((int) R.string.broswse_setting_item_tip_text_smaller), a.d((int) R.string.broswse_setting_item_tip_text_normal), a.d((int) R.string.broswse_setting_item_tip_text_bigger), a.d((int) R.string.broswse_setting_item_tip_text_big)};
    }

    public final void a(int i, boolean z) {
        if (z) {
            k.a;
            p.a(SettingKeys.PageUcCustomFontSize, this.b[i]);
            this.a.a();
        }
    }

    public final void a() {
        this.a.setEnableSwipeGesture(false);
    }

    public final void b() {
        this.a.setEnableSwipeGesture(true);
    }

    public final void c() {
        k.a;
        int a = p.a(SettingKeys.PageUcCustomFontSize);
        com.ucpro.model.a.a.a.b("setting_font_size", a);
        Map hashMap = new HashMap();
        hashMap.put("size", String.valueOf(a));
        com.ucpro.business.stat.m.a(f.a, hashMap);
        b.a;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("count", String.valueOf(a));
        com.ucpro.business.stat.m.a("setting", "setting_font_size", hashMap2);
    }
}
