package com.ucpro.feature.lightapp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.quark.browser.R;
import com.ucpro.base.c.b.ab;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public abstract class f extends ab implements n {
    private final ColorDrawable e;
    private View f;
    private c g;
    private CircularProgressView h;
    private View i;
    private FrameLayout j = new FrameLayout(getContext());

    public f(Context context) {
        super(context);
        b(this.j);
        this.e = new ColorDrawable(a.c("default_background_white"));
        this.j.setBackgroundDrawable(this.e);
    }

    public final void b() {
        if (this.h == null) {
            this.i = LayoutInflater.from(getContext()).inflate(R.layout.material_progress_view, null);
            this.h = (CircularProgressView) this.i.findViewById(R.id.material_progress_view);
            this.h.a();
            b(this.i);
        }
    }

    public final void c() {
        if (this.h != null) {
            this.h.b();
            c(this.i);
            this.h = null;
        }
    }

    public void setPresenter(b bVar) {
        this.g = (c) bVar;
    }

    public void setContentView(View view) {
        if (!(this.f == null || this.f.getParent() == null)) {
            c(this.f);
        }
        this.f = view;
        this.j.addView(this.f);
        postDelayed(new i(this), 500);
    }

    public final void l() {
        super.l();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1 || this.g == null) {
            return true;
        }
        this.g.f();
        return true;
    }

    public c getPresenter() {
        return this.g;
    }

    public String getTitle() {
        if (this.g != null) {
            return this.g.b();
        }
        return super.getTitle();
    }

    public String getUrl() {
        if (this.g != null) {
            return this.g.c();
        }
        return "";
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.ucweb.common.util.f.a(100);
    }
}
