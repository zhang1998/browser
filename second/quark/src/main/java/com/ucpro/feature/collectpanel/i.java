package com.ucpro.feature.collectpanel;

import android.text.TextUtils;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.o;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.category.e;
import com.ucpro.feature.bookmarkhis.bookmark.category.f;
import com.ucpro.ui.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class i implements e, a {
    public l a;
    public final m b;
    long c = -1;
    public List<com.ucpro.feature.bookmarkhis.bookmark.a.m> d;
    List<com.ucpro.feature.bookmarkhis.bookmark.a.m> e;
    public long f = 0;
    f g;
    int h = -1;
    boolean i = false;
    boolean j = false;
    public boolean k = false;
    private j l = null;

    public i(m mVar) {
        this.b = mVar;
        a();
    }

    public final void c() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void d() {
        if (this.a != null) {
            this.a.a();
            com.ucpro.business.stat.m.a("collectpanel", "cp_ck_navi_ccl", new String[0]);
        }
    }

    public final void e() {
        int i = 1;
        if (this.a != null) {
            if (this.c >= 0) {
                String title = this.a.getTitle();
                if (TextUtils.isEmpty(title)) {
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.title_empty_tip), 0);
                    return;
                }
                boolean a;
                String url = this.a.getUrl();
                if (this.h < 0 || this.h >= this.e.size()) {
                    a = a(-1, url, title, this.c);
                } else {
                    a = a(((com.ucpro.feature.bookmarkhis.bookmark.a.m) this.e.get(this.h)).b, url, title, this.c);
                }
                if (this.a.b()) {
                    g.a().b(com.ucpro.base.a.e.b, new Object[]{title, url, null, null});
                }
                HashMap hashMap = new HashMap();
                hashMap.put("name", String.valueOf(title));
                com.ucpro.business.stat.m.a("collectpanel", "cp_ck_navi_cok", hashMap);
                i = a;
            } else if (this.d != null) {
                long j;
                List arrayList = new ArrayList();
                if (this.h < 0 || this.h >= this.e.size()) {
                    j = 0;
                } else {
                    j = ((com.ucpro.feature.bookmarkhis.bookmark.a.m) this.e.get(this.h)).b;
                }
                int i2 = 1;
                int i3 = 1;
                for (int i4 = 0; i4 < this.d.size(); i4++) {
                    com.ucpro.feature.bookmarkhis.bookmark.a.m mVar = (com.ucpro.feature.bookmarkhis.bookmark.a.m) this.d.get(i4);
                    if (mVar != null) {
                        if (mVar.h()) {
                            i2 = 0;
                        }
                        if (mVar.g()) {
                            arrayList.add(Long.valueOf(mVar.b));
                            i3 = 0;
                        }
                    }
                }
                if (i3 != 0) {
                    g.a().a(com.ucpro.base.a.e.aK, (int) j, (int) j, this.d);
                } else if (i2 != 0) {
                    s a2 = s.a();
                    a2.a(new o(a2, j, arrayList), new h(this));
                    i = 0;
                }
            }
            this.a.a();
            if (!(this.b == null || this.a == null)) {
                com.ucweb.common.util.f.a(this.b.h(), this.a.getContent());
            }
            if (i != 0) {
                com.ucpro.ui.b.e.a().a(a.d((int) R.string.edit_success), 0);
                g.a().a(com.ucpro.base.a.e.aR);
            }
            if (this.h >= 0 && this.h < this.e.size()) {
                com.ucpro.business.stat.m.a("bookmark", "bookmark_change_category", new String[0]);
            }
        }
    }

    private static boolean a(long j, String str, String str2, long j2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j2 < 0) {
            return false;
        }
        s.a();
        com.ucpro.feature.bookmarkhis.bookmark.a.m a = s.a(j2);
        if (a == null) {
            return false;
        }
        if (j != -1) {
            a.d = j;
        }
        a.e = str2;
        a.f = str;
        return s.a().b(a);
    }

    public final void f() {
        CharSequence editCategory = this.a.getEditCategory();
        if (editCategory == null || TextUtils.isEmpty(editCategory.toString().trim())) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.bookmark_folder_not_null), 0);
        } else {
            s.a().a(com.ucpro.feature.bookmarkhis.bookmark.a.m.a(editCategory.toString()), new e(this));
        }
        this.a.d();
        com.ucweb.common.util.f.a(this.b.h(), this.a.getContent());
    }

    public final void g() {
        this.a.d();
        com.ucweb.common.util.f.a(this.b.h(), this.a.getContent());
    }

    final void a() {
        s.a().a(new g(this));
    }

    public final void h() {
        if (this.a != null) {
            this.b.b((View) this.a);
            this.a = null;
        }
    }

    public final void i() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void j() {
        this.l = new j(this);
        this.b.a().getViewTreeObserver().addOnGlobalLayoutListener(this.l);
    }

    public final void k() {
        this.b.a().getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
    }

    public final void a(l lVar) {
        this.a = lVar;
        this.a.setHandleDirectory(this.k);
    }

    public final void a(int i) {
        if (this.h != i) {
            this.h = i;
        } else {
            this.h = -1;
        }
        this.g.c = this.h;
        this.g.b();
    }

    public final void b() {
        if (this.j) {
            this.a.c();
            this.a.e();
            return;
        }
        com.ucweb.common.util.f.c(this.b.h());
        this.i = true;
    }
}
