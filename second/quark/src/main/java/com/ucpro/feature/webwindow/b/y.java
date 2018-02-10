package com.ucpro.feature.webwindow.b;

import android.os.Message;
import android.webkit.ValueCallback;
import com.uc.media.interfaces.IProxyHandler;
import com.uc.pictureviewer.interfaces.PictureViewerBuilder;
import com.uc.webview.browser.interfaces.PictureViewer;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.webwindow.b.a.d;
import com.ucpro.feature.webwindow.b.a.l;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public class y extends e {
    private i c;
    private b d;
    private com.ucpro.feature.webwindow.b.a.e e;
    private int f = -1;
    private int g = 1;

    public final void a(int i, Message message) {
        boolean z = true;
        if (com.ucpro.base.a.e.cn == i) {
            if (message.obj instanceof Object[]) {
                this.c = new i(this.b);
                this.d = new b(this.c, s_());
                this.c.setPresenter(this.d);
                this.c.setExtensionInfo((q) ((Object[]) message.obj)[1]);
                b bVar = this.d;
                bVar.a.a((PictureViewer) ((Object[]) message.obj)[0]);
                bVar.b.a((g) bVar.a, false);
                bVar.a.b();
                String pageUrl = bVar.a.getPageUrl();
                String str = "pic_viewer";
                String str2 = "enter";
                String[] strArr = new String[2];
                strArr[0] = IProxyHandler.KEY_PAGE_URL;
                if (a.a(pageUrl)) {
                    pageUrl = "";
                }
                strArr[1] = pageUrl;
                m.a(str, str2, strArr);
            }
        } else if (com.ucpro.base.a.e.co == i) {
            if (this.d != null) {
                b bVar2 = this.d;
                if (bVar2.a != null) {
                    r3 = bVar2.a.getCurrentIndex();
                    int totalCount = bVar2.a.getTotalCount();
                    m.a("pic_viewer", "exit", "cur_index", String.valueOf(r3), "count", String.valueOf(totalCount));
                    bVar2.a.a();
                    bVar2.a(true);
                }
            }
        } else if (com.ucpro.base.a.e.cp == i) {
            if (message.obj instanceof ValueCallback) {
                ValueCallback valueCallback = (ValueCallback) message.obj;
                if (-1 == this.f) {
                    this.f = com.ucpro.business.e.d.g.a().a("enable_picture_mode", this.g);
                }
                if (1 != this.f) {
                    z = false;
                }
                valueCallback.onReceiveValue(Boolean.valueOf(z));
            }
        } else if (com.ucpro.base.a.e.cq != i || !(message.obj instanceof d)) {
        } else {
            if (this.e == null || !this.e.i) {
                this.e = new com.ucpro.feature.webwindow.b.a.e(this.b, (d) message.obj, s_());
                com.ucpro.feature.webwindow.b.a.e eVar = this.e;
                eVar.i = true;
                eVar.c = new l(eVar.a);
                eVar.c.setPresenter(eVar);
                eVar.e.a = eVar.c;
                com.uc.pictureviewer.interfaces.PictureViewer build = PictureViewerBuilder.build(eVar.a, eVar.d, eVar.e, eVar.f);
                build.setLoaderDelegate(eVar.g);
                eVar.c.setPictureViewer(build);
                l lVar = eVar.c;
                r3 = eVar.b.b;
                if (lVar.e != null) {
                    lVar.e.updateCurrentFocusTapIndex(r3);
                }
                eVar.h.a(eVar.c, true);
            }
        }
    }

    public final void b(int i, Message message) {
    }
}
