package com.ucpro.feature.v;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class b extends g implements c {
    WebView e;
    WebView f;
    private Activity g;
    private m h;
    private FrameLayout i = new FrameLayout(getContext());

    public b(Activity activity, m mVar) {
        super(activity);
        this.g = activity;
        this.h = mVar;
        f();
        this.i.setLayoutParams(new LayoutParams(-1, -1));
        setWindowCallBacks(this);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.translate_dialog_webview, null);
        this.e = (WebView) inflate.findViewById(R.id.webview);
        this.f = (WebView) inflate.findViewById(R.id.webview2);
        this.i.addView(inflate, new LayoutParams(-1, -1));
        b(this.i);
    }

    @DebugLog
    public final void a(boolean z) {
        com.ucpro.base.a.g.a().a(e.db, Boolean.valueOf(false));
    }

    @DebugLog
    public final void a(g gVar, byte b) {
    }

    @DebugLog
    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof b) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.db, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.h.b((g) view);
        }
        return null;
    }
}
