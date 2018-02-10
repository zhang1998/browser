package com.ucpro.feature.video.cache;

import android.os.Looper;
import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.quark.n;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.dao.VideoCacheTaskDao.Properties;
import com.ucpro.feature.video.cache.e.d;
import com.ucpro.feature.webwindow.e.e;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.a;
import de.greenrobot.dao.query.WhereCondition;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
final class b extends a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    b(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void run() {
        e a = e.a();
        String str = this.a;
        String str2 = this.a;
        String str3 = (String) a.a.get(str);
        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("about:blank")) {
            str3 = str2;
        }
        List list = com.ucpro.feature.video.cache.db.b.b().a.queryBuilder().where(Properties.f.notEq("ts_successed"), new WhereCondition[0]).build().list();
        if (list == null || list.size() <= 5) {
            com.ucpro.ui.b.e.a().a(String.format(com.ucpro.ui.c.a.d((int) R.string.video_cache_start_tip), new Object[]{this.b}), 0);
            InputStream a2 = com.ucpro.feature.video.cache.a.a.a(this.c);
            if (a2 == null) {
                return;
            }
            if (com.ucpro.feature.video.cache.a.a.a(a2) != null) {
                CharSequence charSequence = this.c;
                CharSequence charSequence2 = this.d;
                c.b(Looper.getMainLooper() != Looper.myLooper());
                c.a(charSequence);
                c.a(charSequence2);
                com.ucpro.feature.video.cache.a.a.b(com.ucpro.feature.video.cache.f.a.a);
                com.ucpro.feature.video.cache.a.a.b(com.ucpro.feature.video.cache.f.a.a + "/video");
                new d().a(charSequence, charSequence2, str3);
                com.ucpro.feature.video.cache.g.a.a(com.ucpro.feature.video.cache.g.a.a);
                return;
            }
            str = this.c;
            String str4 = this.d;
            c.b(Looper.getMainLooper() != Looper.myLooper());
            com.ucpro.feature.video.cache.a.a.b(com.ucpro.feature.video.cache.f.a.a);
            com.ucpro.feature.video.cache.a.a.b(com.ucpro.feature.video.cache.f.a.a + "/video");
            str2 = com.ucweb.common.util.l.d.c(str);
            new StringBuilder("启动下载普通的视频:url=").append(str).append(", title=").append(str4).append(",mimeType=").append(str2);
            com.ucpro.feature.video.d.a.b();
            if (TextUtils.isEmpty(str2)) {
                str2 = "mp4";
            }
            n nVar = new n();
            nVar.a = str;
            nVar.f = true;
            nVar.g = true;
            nVar.b = str3;
            nVar.h = true;
            nVar.c = str2;
            nVar.d = str4;
            s a3 = x.a().a(nVar.a());
            com.ucpro.feature.video.cache.db.bean.b a4 = com.ucpro.feature.video.cache.db.b.b().a((long) a3.a());
            if (a4 != null) {
                com.ucpro.feature.video.d.a.b();
                com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_download_task_already_exists) + a4.c, 1);
            } else {
                a4 = new com.ucpro.feature.video.cache.db.bean.b();
                a4.e = 0;
                a4.a = Long.valueOf((long) a3.a());
                a4.b = a3.g();
                a4.c = a3.b();
                a4.h = a3.h();
                a4.d = a3.j();
                a4.s = new Date();
                a4.f = "init";
                com.ucpro.feature.video.d.a.b();
                com.ucpro.feature.video.cache.db.b.b().a(a4);
                com.ucpro.feature.video.d.a.b();
                a3.k();
            }
            com.ucpro.feature.video.cache.g.a.a(com.ucpro.feature.video.cache.g.a.b);
            return;
        }
        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_download_task_amount_too_much), 1);
        com.ucpro.feature.video.d.a.b();
    }
}
