package com.taobao.weex.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.o;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public class a extends o {
    @JSMethod(uiThread = false)
    public void setViewport(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                e b = com.alibaba.fastjson.a.b(URLDecoder.decode(str, "utf-8"));
                Context b2 = this.b.b();
                int b3;
                if ("device-width".endsWith(b.h(Style.WIDTH))) {
                    b3 = (int) (((float) WXViewUtils.b(b2)) / WXViewUtils.a(b2));
                    ac.a(b3);
                    this.b.o = b3;
                    return;
                }
                b3 = b.f(Style.WIDTH).intValue();
                if (b3 > 0) {
                    ac.a(b3);
                    this.b.o = b3;
                }
            } catch (Throwable e) {
                WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
            }
        }
    }
}
