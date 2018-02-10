package com.ucpro.feature.lightapp.channelpage;

import com.ucpro.feature.lightapp.e.h;

/* compiled from: ProGuard */
final class f implements h {
    final /* synthetic */ ChannelPagePresenter a;

    f(ChannelPagePresenter channelPagePresenter) {
        this.a = channelPagePresenter;
    }

    public final void a() {
        this.a.p = this.a.p + (System.currentTimeMillis() - this.a.r);
        this.a.q = System.currentTimeMillis();
    }
}
