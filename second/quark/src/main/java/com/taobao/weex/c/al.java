package com.taobao.weex.c;

import android.mini.support.v4.d.b;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.apollo.impl.SettingsConst;
import java.util.Map;

/* compiled from: ProGuard */
public class al extends ae {
    protected final Map<String, String> w() {
        Map<String, String> bVar = new b();
        Object obj = 1;
        if (!(this.v == null || this.v.r == null || !this.v.r.equals("hlist"))) {
            obj = null;
        }
        if (g().get(obj != null ? Style.HEIGHT : Style.WIDTH) == null && g().get("flex") == null) {
            bVar.put("flex", SettingsConst.TRUE);
        }
        return bVar;
    }
}
