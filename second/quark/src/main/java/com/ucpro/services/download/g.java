package com.ucpro.services.download;

import com.quark.browser.R;
import com.uc.quark.s;
import com.ucpro.base.a.e;
import com.ucpro.base.system.b;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.n.a;
import java.io.File;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ s a;

    g(s sVar) {
        this.a = sVar;
    }

    public final void run() {
        if (this.a.o()) {
            String p = this.a.p();
            if (a.b(p)) {
                String[] split = p.split("\\|");
                if (split.length >= 2) {
                    File file = new File(this.a.h());
                    if (b.a.e(split[0]) && Long.parseLong(split[0]) == file.length() && a.d(com.ucpro.b.b.b.a(file), split[1])) {
                        b.a.a(this.a.h(), this.a.i());
                        return;
                    }
                    m.a("upgrade", "upgrade_interception", "package_name", b.a.b(this.a.h()), "file_size", file.length(), "upgrade_size", split[0], "file_md5", com.ucpro.b.b.b.a(file), "upgrade_md5", split[1]);
                    com.ucpro.base.a.g.a().a(e.w, Integer.valueOf(this.a.a()));
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.download_check_info_fail), 1);
                }
            }
        } else if (com.ucpro.model.a.a.a.a("setting_download_apk_auto_install", true) && b.a.K()) {
            b.a.a(this.a.h(), this.a.i());
        }
    }
}
