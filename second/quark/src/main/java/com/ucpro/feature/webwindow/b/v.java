package com.ucpro.feature.webwindow.b;

import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.a;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class v extends a {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ f e;

    v(f fVar, String str, int i, int i2, String str2) {
        this.e = fVar;
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
    }

    public final void run() {
        int i = 0;
        while (i < 5) {
            List<File> c = com.ucweb.common.util.k.a.c(new File(this.a));
            if (c == null || c.size() < this.b) {
                i++;
            } else {
                new StringBuilder("i is ").append(i).append(" img list size is ").append(c.size());
                for (File file : c) {
                    b.a.b(d.a(), file.getAbsolutePath());
                    new StringBuilder("start scan, image path is ").append(file.getAbsolutePath());
                    e.a().a(String.format(com.ucpro.ui.c.a.d((int) R.string.pic_viewer_download_all_success_toast), new Object[]{Integer.valueOf(this.c), this.d}), 1);
                }
                return;
            }
        }
    }
}
