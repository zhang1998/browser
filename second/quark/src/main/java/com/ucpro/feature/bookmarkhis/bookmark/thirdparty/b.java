package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.business.stat.m;
import com.ucpro.services.e.e;
import com.ucweb.common.util.d;
import com.ucweb.common.util.i.f;
import com.ucweb.common.util.j.a;
import java.util.List;

/* compiled from: ProGuard */
public final class b implements Runnable {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        String b = e.a.b();
        if (!TextUtils.isEmpty(b)) {
            int b2 = a.b(d.a(), "D514292C05AB961A", "AB24E8415E027A7A", 0);
            int hashCode = b.hashCode();
            if (b2 != hashCode) {
                List l = f.l(b);
                if (l.size() > 0) {
                    this.a.a = true;
                    this.a.b = (String) l.get(0);
                    a.a(d.a(), "D514292C05AB961A", "AB24E8415E027A7A", hashCode);
                    m.a("bookmark", "bookmark_copy_toast_show", new String[0]);
                    com.ucpro.ui.b.e.a().a((byte) 4, "bookmark_save_toast_icon.svg", com.ucpro.ui.c.a.d((int) R.string.bookmark_save_bookmark_toast_text), this.a.b, com.ucpro.ui.c.a.d((int) R.string.bookmark_save), 1, new i(this));
                }
            }
        }
    }
}
