package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.app.Activity;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.category.e;
import com.ucpro.feature.bookmarkhis.bookmark.category.f;
import com.ucpro.feature.collectpanel.a;
import com.ucpro.feature.collectpanel.l;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
public final class j implements e, a {
    l a;
    long b;
    List<m> c;
    f d;
    int e = -1;
    Activity f = null;

    public j(l lVar, Activity activity) {
        this.a = lVar;
        this.f = activity;
        a();
    }

    final void a() {
        s.a().a(new h(this));
    }

    public final void b() {
        com.ucweb.common.util.f.c(this.f);
        this.a.c();
        this.a.e();
    }

    public final void a(int i) {
        if (this.e != i) {
            this.e = i;
        } else {
            this.e = -1;
        }
        this.d.c = this.e;
        this.d.b();
    }

    public final void c() {
        this.a.a();
    }

    public final void d() {
        this.a.a();
    }

    public final void e() {
        String title = this.a.getTitle();
        if (TextUtils.isEmpty(title)) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.title_empty_tip), 0);
            return;
        }
        this.a.a();
        String url = this.a.getUrl();
        if (this.e < 0 || this.e >= this.c.size()) {
            a(0, title, null, this.b);
        } else {
            a((long) ((int) ((m) this.c.get(this.e)).b), title, url, this.b);
        }
        com.ucweb.common.util.f.a(this.f, this.a.getContent());
    }

    private void a(long j, String str, String str2, long j2) {
        if (!TextUtils.isEmpty(str) && j2 != -1) {
            s.a();
            m a = s.a(j2);
            c.a((Object) a);
            if (a != null) {
                a.e = str;
                if (!TextUtils.isEmpty(str2)) {
                    a.f = str2;
                }
                a.d = j;
                s.a().b(a, new f(this));
            }
        }
    }

    public final void f() {
        CharSequence editCategory = this.a.getEditCategory();
        if (editCategory == null || TextUtils.isEmpty(editCategory.toString().trim())) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.bookmark_folder_not_null), 0);
        } else {
            s.a().a(m.a(editCategory.toString()), new g(this));
        }
        this.a.d();
        com.ucweb.common.util.f.a(this.f, this.a.getContent());
    }

    public final void g() {
        this.a.d();
        com.ucweb.common.util.f.a(this.f, this.a.getContent());
    }

    public final void h() {
        ((AddFavoriteActivity) this.f).a();
    }

    public final void i() {
        this.a.a();
    }

    public final void j() {
    }

    public final void k() {
    }
}
