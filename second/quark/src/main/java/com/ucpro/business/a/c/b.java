package com.ucpro.business.a.c;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.webwindow.e.f;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class b extends g {
    private f e;
    private TextView f;
    private a g;
    private f h;
    private String i;
    private FrameLayout j;

    public b(Context context, String str) {
        super(context);
        this.i = str;
        l();
    }

    public final String getUrl() {
        return this.e.getUrl();
    }

    public final f getWebView() {
        return this.e;
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        c.a((Object) bVar);
        c.b(bVar instanceof a);
        this.g = (a) bVar;
    }

    private FrameLayout getBaseLayer() {
        if (this.j == null) {
            this.j = new FrameLayout(getContext());
            b(this.j);
            this.f = new TextView(getContext());
            this.f.setText(a.d((int) R.string.doodle_promtion_page_loading_tip));
            this.f.setTextSize(0, (float) a.c((int) R.dimen.doodle_promtion_page_loading_tip_textsize));
            this.f.setGravity(17);
            this.j.addView(this.f);
        }
        return this.j;
    }

    protected final void a(byte b) {
        super.a(b);
        new StringBuilder("stateFlag:   ").append(String.valueOf(b));
        if ((byte) 1 == b) {
            if (this.e == null) {
                this.e = com.ucpro.feature.webwindow.e.c.a(getContext(), false);
                this.h = new f(this, this.g);
                this.e.setWebViewCallback(this.h);
                this.e.setLongClickListener(new d(this));
                if (this.e.getWebViewSetting() != null) {
                    this.e.getWebViewSetting().a();
                }
                getBaseLayer().addView(this.e, new LayoutParams(-1, -1));
                this.e.setAlpha(0.0f);
            }
            this.e.a(this.i);
        } else if ((byte) 13 == b && this.e != null) {
            this.e.setAlpha(0.0f);
        }
    }

    public final void a() {
        if (this.e != null) {
            this.e.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(500).start();
        }
    }

    public final void l() {
        super.l();
        getBaseLayer().setBackgroundColor(a.c("default_background_white"));
        if (this.f != null) {
            this.f.setTextColor(a.c("default_maintext_gray"));
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || this.e == null || !this.e.c()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.e.d();
        return true;
    }
}
