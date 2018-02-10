package com.ucpro.feature.video;

import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayer.OnErrorListener;

/* compiled from: ProGuard */
final class g implements OnErrorListener {
    final /* synthetic */ VideoViewImpl a;

    g(VideoViewImpl videoViewImpl) {
        this.a = videoViewImpl;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.a.a != null) {
            return this.a.a.a(i2);
        }
        return false;
    }
}
