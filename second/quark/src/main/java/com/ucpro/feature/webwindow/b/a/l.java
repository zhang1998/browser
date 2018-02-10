package com.ucpro.feature.webwindow.b.a;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.pictureviewer.interfaces.PictureViewer;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.d.b;
import com.ucpro.feature.webwindow.b.a;
import com.ucpro.feature.webwindow.b.aa;
import com.ucpro.feature.webwindow.b.z;

/* compiled from: ProGuard */
public final class l extends g implements k {
    public PictureViewer e;
    private FrameLayout f;
    private e g;
    private aa h = new aa(getContext());
    private a i = new a(getContext());

    public l(Context context) {
        super(context);
    }

    public final void setPictureViewer(PictureViewer pictureViewer) {
        this.e = pictureViewer;
        this.e.setTopBarView(this.h, new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.pic_viewer_titlebar_height)));
        this.e.setBottomBarView(this.i, new LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.pic_viewer_toolbar_height)));
        getBaseLayer().addView(this.e, new LayoutParams(-1, -1));
    }

    private FrameLayout getBaseLayer() {
        if (this.f == null) {
            this.f = new FrameLayout(getContext());
            b(this.f);
        }
        return this.f;
    }

    public final void setPresenter(b bVar) {
        setWindowCallBacks((c) bVar);
        this.g = (e) bVar;
        this.i.setPicViewerToolbarCallback((z) bVar);
    }

    public final void a(int i, int i2) {
        this.h.a(i, i2);
    }

    public final String getCurrentPictureUrl() {
        return this.e.getCurrentPictureUrl();
    }
}
