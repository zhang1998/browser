package com.taobao.weex.c;

import android.mini.support.v4.d.b;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.apollo.impl.SettingsConst;
import java.util.Map;

/* compiled from: ProGuard */
public class an extends ae {
    protected final Map<String, String> w() {
        Map<String, String> bVar = new b();
        if (this.v != null) {
            String str = (String) this.v.i().get("scrollDirection");
            if (str != null && str.equals("horizontal")) {
                Object obj = null;
                if (g().get(obj == null ? Style.HEIGHT : Style.WIDTH) == null && g().get("flex") == null) {
                    bVar.put("flex", SettingsConst.TRUE);
                }
                return bVar;
            }
        }
        int i = 1;
        if (obj == null) {
        }
        bVar.put("flex", SettingsConst.TRUE);
        return bVar;
    }
}
