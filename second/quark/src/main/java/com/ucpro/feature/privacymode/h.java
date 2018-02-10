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
import com.ucpro.feature.privacymode.view.q;
import com.ucpro.feature.privacymode.view.u;
import facerecognition.a;
import facerecognition.a.f;
import facerecognition.unlock.b;

/* compiled from: ProGuard */
public final class h extends g implements c, q, a {
    f e = new f(getContext(), this.f);
    private b f = new b(getContext(), com.ucpro.feature.privacymode.a.a.c(), com.ucpro.feature.privacymode.a.a.d());
    private m g;
    private u h;

    public h(Context context, m mVar) {
        super(context);
        this.g = mVar;
        f();
        setWindowCallBacks(this);
        this.e.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_dark"));
        this.h = new u(getContext());
        this.h.setOnPrivacyClick(this);
        this.h.a(true);
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
        com.ucpro.base.a.g.a().a(e.cv, Boolean.valueOf(false));
        m();
    }

    public final void a(g gVar, byte b) {
        if (b == (byte) 1) {
            return;
        }
        if (b == (byte) 13) {
            if (com.ucpro.c.b.b()) {
                Log.e("vanda", "STATE_ON_DETACH  onDestroy mFaceRecognitionView = " + this.e);
            }
            m();
        } else if (b == (byte) 4) {
            if (com.ucpro.c.b.b()) {
                Log.e("vanda", "STATE_AFTER_POP_OUT  onDestroy mFaceRecognitionView = " + this.e);
            }
            m();
            this.g.a((g) this);
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof h) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cv, Boolean.valueOf(true));
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
        this.h.setProgressWithAnimation(0);
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
        m();
        this.h.setProgressWithAnimation(100);
        this.h.setTextViewTips(com.ucpro.ui.c.a.d((int) R.string.privacymode_unlock_sucess));
        com.ucpro.base.a.g.a().a(e.cz, Boolean.valueOf(true), 0);
        com.ucpro.business.stat.m.a("privacy_mode", "privacy_box_page", "privacy_box_page_enter_ways", "privacy_box_page_face");
    }

    public final Rect getSize() {
        return this.h.getRect();
    }

    public final void c() {
    }

    public final void n() {
        com.ucpro.base.a.g.a().a(e.cv, Boolean.valueOf(true));
    }

    public final void o() {
        com.ucpro.base.a.g.a().a(e.cH, Boolean.valueOf(true));
        com.ucpro.business.stat.m.a("privacy_mode", "privacy_unlock_page_pw", new String[0]);
    }
}
