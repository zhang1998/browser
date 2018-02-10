package com.ucpro.feature.lightapp;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.base.c.b.a;
import com.ucpro.feature.lightapp.channelpage.ChannelPagePresenter;
import com.ucpro.feature.lightapp.channelpage.j;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class b implements ValueCallback<Boolean> {
    final /* synthetic */ a a;
    final /* synthetic */ int b;
    final /* synthetic */ com.ucpro.feature.lightapp.d.b c;
    final /* synthetic */ j d;
    final /* synthetic */ d e;

    b(d dVar, a aVar, int i, com.ucpro.feature.lightapp.d.b bVar, j jVar) {
        this.e = dVar;
        this.a = aVar;
        this.b = i;
        this.c = bVar;
        this.d = jVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            d.a(this.e, this.a);
            ChannelPagePresenter channelPagePresenter = (ChannelPagePresenter) this.e.c.get(Integer.valueOf(this.b));
            com.ucpro.feature.lightapp.d.b bVar = this.c;
            j jVar = this.d;
            if (!channelPagePresenter.h()) {
                if (com.ucpro.b.d.a.c() && !ChannelPagePresenter.b) {
                    ChannelPagePresenter.b = true;
                    if (channelPagePresenter.f != null) {
                        channelPagePresenter.f.b();
                    }
                    m.a(2, new com.ucpro.feature.lightapp.channelpage.m(channelPagePresenter), 2000);
                }
                channelPagePresenter.g();
                channelPagePresenter.c = jVar;
                channelPagePresenter.a(bVar);
                return;
            }
            return;
        }
        e.a().a((int) R.string.light_app_category_no_permission_toast, 1);
    }
}
