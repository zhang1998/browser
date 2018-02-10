package com.ucpro.feature.webwindow.b;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.browser.interfaces.PictureViewer;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.d.b;

/* compiled from: ProGuard */
public final class i extends g implements u {
    private FrameLayout e;
    private k f;
    private f g;
    private b h;
    private Animation i = null;
    private Animation j = null;
    private q k;

    public i(Context context) {
        super(context);
        setEnableSwipeGesture(false);
        setTransparent(true);
        setSingleTop(false);
    }

    private FrameLayout getBaseLayer() {
        if (this.e == null) {
            this.e = new FrameLayout(getContext());
            b(this.e);
        }
        return this.e;
    }

    public final void l() {
        super.l();
        getBaseLayer().setBackgroundColor(-16777216);
        if (this.f != null) {
            this.f.d();
        }
    }

    public final void setPresenter(b bVar) {
        this.h = (b) bVar;
        setWindowCallBacks((c) bVar);
    }

    public final void a(PictureViewer pictureViewer) {
        this.f = new k(getContext(), pictureViewer);
        this.g = new f(this.f);
        this.f.setPresenter(this.g);
        if (this.k != null) {
            this.f.c = this.k;
        }
        getBaseLayer().addView(this.f.b.asView(), new LayoutParams(-1, -1));
    }

    public final void a() {
        getBaseLayer().removeAllViews();
        if (this.f != null) {
            this.f.setPresenter(null);
            this.f = null;
        }
        this.g = null;
    }

    public final void b() {
        if (this.i == null) {
            this.i = new AlphaAnimation(0.0f, IPictureView.DEFAULT_MIN_SCALE);
            this.i.setDuration(200);
            this.i.setInterpolator(new DecelerateInterpolator());
            startAnimation(this.i);
        }
    }

    public final void c() {
        if (this.i != null) {
            clearAnimation();
            this.i = null;
        }
        if (this.j == null) {
            this.j = new AlphaAnimation(IPictureView.DEFAULT_MIN_SCALE, 0.0f);
            this.j.setInterpolator(new AccelerateInterpolator());
            this.j.setDuration(200);
            setPopAnimation(this.j);
        }
    }

    public final int getCurrentIndex() {
        if (this.f != null) {
            return this.f.d;
        }
        return 0;
    }

    public final int getTotalCount() {
        if (this.f != null) {
            return this.f.e;
        }
        return 0;
    }

    public final String getPageUrl() {
        if (this.k != null) {
            return this.k.b;
        }
        return "";
    }

    public final void setExtensionInfo(q qVar) {
        this.k = qVar;
    }
}
