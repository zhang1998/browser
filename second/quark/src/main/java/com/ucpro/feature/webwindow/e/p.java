package com.ucpro.feature.webwindow.e;

import com.uc.webview.browser.interfaces.PictureViewer;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.webwindow.b.q;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.feature.webwindow.bo;

/* compiled from: ProGuard */
public final class p extends m {
    private bo a;
    private m b;

    public p(bo boVar, m mVar) {
        this.a = boVar;
        this.b = mVar;
    }

    public final void onPictureViewerOpened(PictureViewer pictureViewer) {
        bo boVar;
        g a = this.b.a();
        while (!(a instanceof bb)) {
            if (a == null) {
                boVar = null;
                break;
            }
            a = this.b.b(a);
        }
        boVar = (bb) a;
        if (boVar != this.a) {
            this.a.v();
        } else if (!this.a.x()) {
            this.a.setPictureViewerOpened(true);
            q qVar = new q();
            qVar.b = this.a.getUrl();
            qVar.a = this.a.getTitle();
            if (!(this.a.getHitTestResult() == null || this.a.getHitTestResult().getExtension() == null)) {
                qVar.c = this.a.getHitTestResult().getExtension().getImageUrl();
            }
            com.ucpro.base.a.g.a().b(e.cn, new Object[]{pictureViewer, qVar});
        }
    }

    public final void onPictureViewerClosed(PictureViewer pictureViewer) {
        if (this.a.x()) {
            com.ucpro.base.a.g.a().b(e.co);
        }
        this.a.setPictureViewerOpened(false);
    }
}
