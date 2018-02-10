package com.ucpro.feature.lightapp.channelpage;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class i implements ValueCallback<Boolean> {
    final /* synthetic */ ChannelPagePresenter a;

    public i(ChannelPagePresenter channelPagePresenter) {
        this.a = channelPagePresenter;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            if (this.a.d != null) {
                this.a.t = false;
                this.a.d.b(false);
            }
            e.a().a(a.d((int) R.string.discover_bookmark_nav_add_success), 0);
            return;
        }
        e.a().a(a.d((int) R.string.navigation_max_num_tip), 0);
    }
}
