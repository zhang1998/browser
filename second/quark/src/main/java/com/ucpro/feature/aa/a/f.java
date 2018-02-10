package com.ucpro.feature.aa.a;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.base.e.e;
import com.ucpro.ui.c.a;
import com.ui.edittext.c;

/* compiled from: ProGuard */
public final class f implements c {
    final p a;
    String b;
    private final m c;
    private final a d;
    private final String[] e;
    private final String[] f;
    private final String[] g;
    private boolean h;
    private boolean i;
    private boolean j;

    public f(p pVar, a aVar, m mVar) {
        this.a = pVar;
        this.d = aVar;
        this.c = mVar;
        Resources resources = this.c.h().getResources();
        this.e = resources.getStringArray(R.array.home_button_keywords);
        this.f = resources.getStringArray(R.array.quit_button_keywords);
        this.g = resources.getStringArray(R.array.night_mode_keywords);
    }

    public final void a(boolean z) {
        this.d.a(z);
    }

    public final void a(g gVar, byte b) {
        if (b == (byte) 1) {
            this.a.b();
            this.h = false;
            this.j = false;
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        this.d.a(true);
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.c.b((g) view);
        }
        return null;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
    }

    public final void a() {
        this.d.a(true);
    }

    public final void b() {
        e eVar = this.d;
        if (eVar.c != null) {
            com.ucweb.common.util.f.a(eVar.b, eVar.c);
            com.ucweb.common.util.h.m.a(2, new b(eVar), 300);
            com.ucpro.business.stat.m.a("app", "open_bbs_in_fd_win", new String[0]);
        }
    }

    public final void c() {
        String content = this.a.getContent();
        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(content.trim())) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.user_feedback_content_empty_tip), 0);
            return;
        }
        String contact = this.a.getContact();
        if (TextUtils.isEmpty(contact) || TextUtils.isEmpty(contact.trim())) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.user_feedback_contact_empty_tip), 0);
            return;
        }
        e eVar = this.d;
        String str = this.b;
        if (!eVar.d) {
            eVar.d = true;
            com.ucweb.common.util.h.m.a(1, new j(new h(), content, contact, str, eVar));
        }
    }

    public final void a(CharSequence charSequence) {
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (charSequence2 != null) {
                boolean z;
                int b;
                if (a(this.e, charSequence2)) {
                    if (!this.j) {
                        this.j = true;
                        b = com.ucweb.common.util.j.a.b(this.c.h(), "C9CE986CEF1A2D58", "614160D0A416FB38", 0);
                        if (b < 2) {
                            com.ucweb.common.util.j.a.a(this.c.h(), "C9CE986CEF1A2D58", "614160D0A416FB38", b + 1);
                            com.ucpro.ui.b.e.a().a(a.d((int) R.string.home_button_smart_tip), 1);
                            z = true;
                        }
                    }
                    z = false;
                } else if (a(this.f, charSequence2)) {
                    if (!this.h) {
                        this.h = true;
                        b = com.ucweb.common.util.j.a.b(this.c.h(), "C9CE986CEF1A2D58", "0BC76ECE203E11E5", 0);
                        if (b < 2) {
                            com.ucweb.common.util.j.a.a(this.c.h(), "C9CE986CEF1A2D58", "0BC76ECE203E11E5", b + 1);
                            com.ucpro.ui.b.e.a().a(a.d((int) R.string.quit_button_smart_tip), 1);
                            z = true;
                        }
                    }
                    z = false;
                } else if (a(this.g, charSequence2)) {
                    if (!this.i) {
                        this.i = true;
                        b = com.ucweb.common.util.j.a.b(this.c.h(), "C9CE986CEF1A2D58", "B3DC4EC70E4DF994", 0);
                        if (b < 2) {
                            com.ucweb.common.util.j.a.a(this.c.h(), "C9CE986CEF1A2D58", "B3DC4EC70E4DF994", b + 1);
                            com.ucpro.ui.b.e.a().a(a.d((int) R.string.night_mode_smart_tip), 1);
                            z = true;
                        }
                    }
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    com.ucpro.business.stat.m.a("app", "feedback_mst", "content", charSequence2);
                }
            }
        }
    }

    private static boolean a(String[] strArr, String str) {
        if (strArr == null || strArr.length <= 0 || str == null) {
            return false;
        }
        for (CharSequence charSequence : strArr) {
            if (charSequence != null && str.contains(charSequence)) {
                return true;
            }
        }
        return false;
    }
}
