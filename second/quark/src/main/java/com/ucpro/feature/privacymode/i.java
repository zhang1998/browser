package com.ucpro.feature.privacymode;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.c.b;
import com.ucpro.feature.privacymode.view.q;
import com.ucpro.feature.privacymode.view.u;
import facerecognition.a;
import facerecognition.a.f;

/* compiled from: ProGuard */
public final class i extends g implements c, q, a {
    f e = new f(getContext(), this.f);
    private facerecognition.register.g f;
    private m g;
    private u h;

    public i(Context context, m mVar) {
        super(context);
        this.g = mVar;
        f();
        setWindowCallBacks(this);
        Context context2 = getContext();
        com.ucpro.feature.privacymode.a.a.b();
        this.f = new facerecognition.register.g(context2, com.ucpro.feature.privacymode.a.a.c(), com.ucpro.feature.privacymode.a.a.d());
        this.e.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_dark"));
        this.h = new u(getContext());
        this.h.setOnPrivacyClick(this);
        this.h.a(false);
        b(this.e);
        b(this.h);
    }

    public final void m() {
        if (this.e != null) {
            this.e.a();
            this.e.c();
            this.e = null;
        }
    }

    public final void a(boolean z) {
        com.ucpro.base.a.g.a().a(e.cw, Boolean.valueOf(false));
        m();
    }

    public final void a(g gVar, byte b) {
        if (b == (byte) 1) {
            return;
        }
        if (b == (byte) 13) {
            m();
        } else if (b == (byte) 4) {
            if (b.b()) {
                Log.e("vanda", "STATE_AFTER_POP_OUT  onDestroy mFaceRecognitionView = " + this.e);
            }
            m();
            this.g.a((g) this);
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof i) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cw, Boolean.valueOf(true));
        m();
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.g.b((g) view);
        }
        return null;
    }

    public final void a() {
    }

    public final void a(int i) {
        this.h.setProgressWithAnimation(i);
    }

    public final void b(int i) {
        String string = getResources().getString(g.a[i]);
        if (i == 12) {
            string = String.format(string, new Object[]{Integer.valueOf(facerecognition.b.a.a)});
        }
        this.h.setTextViewTips(string);
    }

    public final void b() {
        this.h.setTextViewTips(com.ucpro.ui.c.a.d((int) R.string.privacymode_register_sucess));
        com.ucpro.base.a.g.a().a(e.cF, Boolean.valueOf(false), 0);
        m();
    }

    public final void c() {
    }

    public final Rect getSize() {
        return this.h.getRect();
    }

    public final void n() {
        com.ucpro.base.a.g.a().a(e.cw, Boolean.valueOf(true));
        m();
    }

    public final void o() {
    }
}
