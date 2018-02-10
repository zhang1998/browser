package com.uc.weex;

import android.content.Context;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXViewUtils;
import com.uc.weex.a.ah;
import com.uc.weex.a.z;

/* compiled from: ProGuard */
public final class o {
    private static p a = new p();

    static {
        WXViewUtils.a = g.e;
        i.e = g.a;
        i.g = new n();
        Context context = g.a;
        z.a = "weex/hard-code-resource";
        z.b = "weex/";
        String str = context.getFilesDir() + "/weex/";
        z.c = str + "/bundle-info";
        z.d = str + "/manifest";
        z.e = str + "/";
        ah.a();
    }
}
