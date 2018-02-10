package com.taobao.weex.ui.animation;

import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.weex.ad;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.c.a.i;
import com.taobao.weex.common.o;

/* compiled from: ProGuard */
public class e extends o {
    @JSMethod
    public void transition(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.b != null) {
            ad.a().a.a(this.b.e, new i(str, str2, str3), false, 16);
        }
    }
}
