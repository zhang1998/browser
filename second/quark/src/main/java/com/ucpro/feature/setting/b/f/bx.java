package com.ucpro.feature.setting.b.f;

import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.video.cache.f.a;
import com.ucpro.ui.b.e;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
final class bx implements i {
    bx() {
    }

    public final void a() {
        String str = a.a;
        try {
            com.ucweb.common.util.k.a.i(new File(str));
        } catch (IOException e) {
            e.toString();
        }
        e.a().a("路径:" + str + "已删除", 1);
    }
}
