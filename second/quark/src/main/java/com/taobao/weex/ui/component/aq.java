package com.taobao.weex.ui.component;

import com.taobao.weex.c.ae;
import com.taobao.weex.c.ao;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class aq extends ae {
    protected final Map<String, String> w() {
        ao g = g();
        Map<String, String> hashMap = new HashMap();
        if (!g.containsKey(Style.RIGHT)) {
            hashMap.put(Style.LEFT, SettingsConst.FALSE);
        }
        if (!g.containsKey(Style.BOTTOM)) {
            hashMap.put(Style.TOP, SettingsConst.FALSE);
        }
        return hashMap;
    }
}
