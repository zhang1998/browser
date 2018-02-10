package com.ucpro.feature.lightapp.channelpage;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class n implements ValueCallback<Boolean> {
    final /* synthetic */ ChannelPagePresenter a;

    n(ChannelPagePresenter channelPagePresenter) {
        this.a = channelPagePresenter;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        this.a.s = true;
        this.a.t = !bool.booleanValue();
        this.a.d.b(this.a.t);
    }
}
