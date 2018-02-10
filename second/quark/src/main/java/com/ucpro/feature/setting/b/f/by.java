package com.ucpro.feature.setting.b.f;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import com.ucpro.feature.setting.b.b.a.g;

/* compiled from: ProGuard */
public final class by implements g {
    public final /* synthetic */ void a(Object obj) {
        Boolean bool = (Boolean) obj;
        k.a;
        p.a(SettingKeys.PageEnableAdBlock, bool.booleanValue());
    }

    public final /* synthetic */ Object a() {
        k.a;
        return Boolean.valueOf(p.b(SettingKeys.PageEnableAdBlock));
    }
}
