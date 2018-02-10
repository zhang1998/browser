package com.ucpro.feature.lightapp.channelpage;

/* compiled from: ProGuard */
public final class m implements Runnable {
    final /* synthetic */ ChannelPagePresenter a;

    public m(ChannelPagePresenter channelPagePresenter) {
        this.a = channelPagePresenter;
    }

    public final void run() {
        if (this.a.f != null) {
            this.a.f.c();
        }
    }
}
