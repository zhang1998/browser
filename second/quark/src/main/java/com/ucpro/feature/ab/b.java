package com.ucpro.feature.ab;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.zxing.Result;
import com.quark.browser.R;
import com.uc.qrcode.s;
import com.uc.qrcode.t;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.c.a;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class b extends g implements s, c, d, d, h {
    t e;
    private Activity f;
    private m g;
    private FrameLayout h = new FrameLayout(getContext());
    private f i;
    private n j;
    private long k;

    public b(Activity activity, m mVar) {
        super(activity);
        this.f = activity;
        this.g = mVar;
        f();
        this.h.setLayoutParams(new LayoutParams(-1, -1));
        setWindowCallBacks(this);
        this.h.setBackgroundColor(a.c("qrcode_close_bg"));
        this.i = new f(getContext());
        this.i.setBackgroundColor(a.c("qrcode_close_bg"));
        this.i.setIOnQrCodeBarClick(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, a.c((int) R.dimen.qrcode_close_height));
        layoutParams.gravity = 80;
        this.h.addView(this.i, layoutParams);
        b(this.h);
    }

    @DebugLog
    public final void a(boolean z) {
        m();
        com.ucpro.base.a.g.a().a(e.bE, Boolean.valueOf(false));
        a();
    }

    @DebugLog
    public final void a(g gVar, byte b) {
        if (b == (byte) 1) {
            this.e = new t(this.f);
            this.e.e = this;
            this.e.setText(a.d((int) R.string.qrcode_desc));
            t tVar = this.e;
            int c = a.c((int) R.dimen.qrcode_close_height);
            com.uc.qrcode.a.c cVar = tVar.c.b;
            synchronized (cVar.b) {
                cVar.l = c;
                cVar.m = 0;
            }
            this.h.removeView(this.i);
            this.h.addView(this.e);
            this.h.addView(this.i);
            this.k = System.currentTimeMillis();
        } else if (b == (byte) 4) {
            a();
        }
    }

    @DebugLog
    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof b) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        m();
        com.ucpro.base.a.g.a().a(e.bE, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.g.b((g) view);
        }
        return null;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.e == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return this.e.onKeyDown(i, keyEvent);
    }

    @DebugLog
    public final void a() {
        if (this.e != null) {
            this.e.c();
            this.e = null;
        }
    }

    public final void a(Result result) {
        com.ucpro.business.stat.m.a("qrcode", "qrcode_time_ac", "qrcode_time_time", (System.currentTimeMillis() - this.k));
        com.ucpro.business.stat.m.a("qrcode", "qrcode_succ", new String[0]);
        this.g.a(false);
        this.g.b(false);
        if (result != null) {
            this.j.a(result.getText());
        }
        a();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.j = (n) bVar;
    }

    public final void b() {
        this.j.a();
        com.ucpro.base.a.g.a().a(e.bE, Boolean.valueOf(true));
    }

    public final void c() {
        Intent intent = new Intent();
        intent.setType("image/*");
        if (VERSION.SDK_INT < 19) {
            intent.setAction("android.intent.action.GET_CONTENT");
        } else {
            intent.setAction("android.intent.action.PICK");
        }
        try {
            this.f.startActivityForResult(intent, 2);
        } catch (Exception e) {
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    private void m() {
        if (System.currentTimeMillis() - this.k > 5000) {
            com.ucpro.business.stat.m.a("qrcode", "qrcode_fail", new String[0]);
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9101942");
    }

    public final String getPageName() {
        return "Page_QR_code";
    }
}
