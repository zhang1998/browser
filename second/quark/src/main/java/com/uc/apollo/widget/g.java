package com.uc.apollo.widget;

import com.UCMobile.Apollo.text.PlayerPositionProvider;

/* compiled from: ProGuard */
final class g implements PlayerPositionProvider {
    final /* synthetic */ VideoView a;

    g(VideoView videoView) {
        this.a = videoView;
    }

    public final int getCurrentPosition() {
        return this.a.getCurrentPosition();
    }
}
