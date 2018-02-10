package com.ucpro.feature.lightapp.channelpage;

import android.webkit.ValueCallback;
import com.ucpro.feature.lightapp.d.b;

/* compiled from: ProGuard */
final class k implements ValueCallback<String> {
    final /* synthetic */ b a;
    final /* synthetic */ ChannelPagePresenter b;

    k(ChannelPagePresenter channelPagePresenter, b bVar) {
        this.b = channelPagePresenter;
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ChannelPagePresenter.a(this.b, this.a, (String) obj);
    }
}
