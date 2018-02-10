package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.ui.b.e;
import java.io.File;

/* compiled from: ProGuard */
public final class g implements i {
    public final void a() {
        File file = new File(a.a());
        if (file.exists()) {
            file.delete();
            e.a().a("文件已删除", 0);
        }
    }
}
