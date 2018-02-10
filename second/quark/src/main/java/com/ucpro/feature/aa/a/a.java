package com.ucpro.feature.aa.a;

import android.os.Message;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public class a extends e implements e {
    d c;
    boolean d;
    private f e;
    private boolean f;

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.S) {
            String[] strArr = null;
            if (message.obj != null && (message.obj instanceof String[])) {
                strArr = (String[]) message.obj;
            }
            if (!this.f) {
                this.f = true;
                this.c = new d(this.b);
                if (!(strArr == null || TextUtils.isEmpty(strArr[1]))) {
                    this.c.setTitle(strArr[1]);
                }
                if (!(strArr == null || TextUtils.isEmpty(strArr[2]))) {
                    this.c.setContentTip(strArr[2]);
                }
                this.e = new f(this.c, this, s_());
                if (!(strArr == null || TextUtils.isEmpty(strArr[0]))) {
                    this.e.b = strArr[0];
                }
                this.c.setPresenter(this.e);
                s_().a(this.c, true);
                m.a("app", "open_fd_win", new String[0]);
            }
        }
    }

    public final void b(int i, Message message) {
    }

    public final void a(boolean z) {
        if (s_().a() == this.c) {
            s_().a(z);
            f.a(this.c.getContext(), this.c);
        }
        i();
    }

    public final void d() {
        this.d = false;
        if (this.e != null) {
            this.e.a.a();
            this.e.a.c();
        }
        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.user_feedback_summit_success_tip), 0);
    }

    public final void e() {
        this.d = false;
        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.user_feedback_summit_failed_tip), 0);
    }

    private void i() {
        this.c = null;
        this.e = null;
        this.f = false;
    }
}
