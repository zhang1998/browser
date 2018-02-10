package com.ucpro.feature.lightapp;

import com.ucpro.feature.lightapp.channelpage.ChannelPagePresenter;
import com.ucpro.feature.lightapp.channelpage.j;
import com.ucpro.feature.lightapp.d.a;

/* compiled from: ProGuard */
final class h implements j {
    final /* synthetic */ int a;
    final /* synthetic */ a b;
    final /* synthetic */ d c;

    h(d dVar, int i, a aVar) {
        this.c = dVar;
        this.a = i;
        this.b = aVar;
    }

    public final void a() {
        if (this.c.c.containsKey(Integer.valueOf(this.a))) {
            ((ChannelPagePresenter) this.c.c.get(Integer.valueOf(this.a))).a(this.b.a, this.b.e);
        }
    }
}
