package com.ucpro.feature.setting.b.f;

import android.text.TextUtils;
import android.util.Log;
import com.uc.sync.d.a;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.i.c;
import java.io.File;

/* compiled from: ProGuard */
public final class bp implements i {
    public final void a() {
        try {
            if (c.g()) {
                File file = new File(a.a());
                if (file.exists()) {
                    Object g = com.ucweb.common.util.k.a.g(file);
                    if (TextUtils.isEmpty(g)) {
                        e.a().a("Cloudsync log file is empty", 0);
                        return;
                    }
                    com.ucpro.business.b.a.a(new StringBuffer(g));
                    e.a().a("Cloudsync logs uploaded", 0);
                    return;
                }
                e.a().a("Cloudsync file not exist", 0);
                return;
            }
            e.a().a("Network unvailable，fail to upload", 0);
        } catch (Throwable e) {
            Log.e("hjw-log", "上报失败", e);
        }
    }
}
