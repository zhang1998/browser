package com.ucpro.feature.lightapp.channelpage;

import android.webkit.ValueCallback;
import com.ucpro.feature.lightapp.d.b;

/* compiled from: ProGuard */
final class h implements ValueCallback<Boolean> {
    final /* synthetic */ b a;
    final /* synthetic */ ChannelPagePresenter b;

    h(ChannelPagePresenter channelPagePresenter, b bVar) {
        this.b = channelPagePresenter;
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ChannelPagePresenter.a(this.b, this.a, ((Boolean) obj).booleanValue());
    }
}
