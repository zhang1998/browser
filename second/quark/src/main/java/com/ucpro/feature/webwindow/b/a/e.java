package com.ucpro.feature.webwindow.b.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.pictureviewer.interfaces.PictureViewer.LoaderDelegate;
import com.uc.pictureviewer.interfaces.PictureViewerConfig;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.webwindow.b.a.a.b;
import com.ucpro.feature.webwindow.b.a.a.d;
import com.ucpro.ui.c.a;
import com.ui.edittext.c;

/* compiled from: ProGuard */
public final class e implements a {
    public Context a;
    public d b;
    public l c;
    public h d;
    public f e;
    public PictureViewerConfig f;
    public LoaderDelegate g;
    public m h;
    public boolean i = false;
    private b j;

    public e(Context context, d dVar, m mVar) {
        this.a = context;
        this.b = dVar;
        this.h = mVar;
        this.j = new b(this.b);
        this.g = new d(this.j);
        this.e = new f(this);
        this.f = new PictureViewerConfig();
        this.d = new h();
    }

    public final void a(boolean z) {
        this.h.a(z);
        this.i = false;
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final View a(View view) {
        return this.h.b(this.c);
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
    }

    public final void b(boolean z) {
        if (z && this.c != null) {
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.pic_viewer_download_all_toast_text), 0);
            l lVar = this.c;
            if (lVar.e != null) {
                lVar.e.saveAllPicture("", new i(lVar));
            }
        }
    }

    public final void a() {
        a(true);
    }

    public final void c() {
        if (this.c != null) {
            l lVar = this.c;
            com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(lVar.getContext());
            mVar.a(a.d((int) R.string.pic_viewer_download_all_dialog_tips));
            mVar.a(a.d((int) R.string.pic_viewer_download_all_dialog_yes), a.d((int) R.string.pic_Viewer_download_all_dialog_no));
            mVar.a(new g(lVar));
            mVar.show();
        }
    }

    public final void b() {
        if (this.c != null) {
            l lVar = this.c;
            ValueCallback jVar = new j(this);
            if (lVar.e != null) {
                lVar.e.saveCurrentPicture("", "", true, jVar);
            }
        }
    }
}
