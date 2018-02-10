package com.ucpro.feature.video;

import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayer.OnBufferingUpdateListener;

/* compiled from: ProGuard */
final class n implements OnBufferingUpdateListener {
    final /* synthetic */ VideoViewImpl a;

    n(VideoViewImpl videoViewImpl) {
        this.a = videoViewImpl;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (this.a.b != null) {
            this.a.b.b(i);
        }
    }
}
