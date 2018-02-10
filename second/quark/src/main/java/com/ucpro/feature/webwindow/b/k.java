package com.ucpro.feature.webwindow.b;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.webview.browser.interfaces.PictureViewer;
import com.uc.webview.browser.interfaces.PictureViewer.OnClickListener;
import com.uc.webview.browser.interfaces.PictureViewer.OnTabChangeListener;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.m;
import java.io.File;

/* compiled from: ProGuard */
public final class k implements c {
    f a;
    PictureViewer b;
    q c;
    int d;
    int e;
    private aa f = new aa(this.h);
    private a g;
    private Context h;
    private int i = a.c((int) R.dimen.pic_viewer_titlebar_height);
    private int j = a.c((int) R.dimen.pic_viewer_toolbar_height);

    public k(Context context, PictureViewer pictureViewer) {
        this.h = context;
        this.b = pictureViewer;
        this.b.setTopBarView(this.f, new LayoutParams(-1, this.i));
        this.g = new a(this.h);
        this.b.setBottomBarView(this.g, new LayoutParams(-1, this.j));
        d();
    }

    public final void setPresenter(b bVar) {
        this.a = (f) bVar;
        this.b.setPictureViewerOnClickListener((OnClickListener) bVar);
        this.b.setPictureViewerOnTabChangeListener((OnTabChangeListener) bVar);
        this.g.setPicViewerToolbarCallback((z) bVar);
    }

    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        if (this.f != null) {
            new StringBuilder("PicViewer updateTitlebarStr\ncurrentIndex: ").append(i).append("\ntotalCount").append(i2).append("\nmPictureViewer.getPictureCount(): ").append(this.b.getPictureCount());
            aa aaVar = this.f;
            if (i2 <= this.b.getPictureCount()) {
                i2 = this.b.getPictureCount() == 0 ? i : this.b.getPictureCount();
            }
            aaVar.a(i, i2);
        }
    }

    public final void d() {
        if (this.f != null) {
            this.f.a();
        }
        if (this.g != null) {
            this.g.a();
        }
    }

    public final String a() {
        return this.b.getCurrentPictureUrl();
    }

    public final void a(String str, String str2) {
        this.b.saveCurrentPicture(str, str2, true, new o(this, new File(str, str2).getAbsolutePath(), this.b.getCurrentPictureUrl()));
    }

    public final void a(String str) {
        this.b.saveAllPicture(str, new d(this, str));
    }

    public final q b() {
        return this.c;
    }

    public final void c() {
        m mVar = new m(this.h);
        mVar.a(a.d((int) R.string.pic_viewer_download_all_dialog_tips));
        mVar.a(a.d((int) R.string.pic_viewer_download_all_dialog_yes), a.d((int) R.string.pic_Viewer_download_all_dialog_no));
        mVar.a(new l(this));
        mVar.show();
    }
}
