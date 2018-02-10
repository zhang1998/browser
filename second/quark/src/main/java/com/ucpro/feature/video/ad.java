package com.ucpro.feature.video;

import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayer.OnPreparedListener;

/* compiled from: ProGuard */
final class ad implements OnPreparedListener {
    final /* synthetic */ VideoViewImpl a;

    ad(VideoViewImpl videoViewImpl) {
        this.a = videoViewImpl;
    }

    public final void onPrepared(MediaPlayer mediaPlayer, int i, int i2, int i3) {
        int i4 = 0;
        if (this.a.f != null) {
            int videoWidth;
            if (mediaPlayer != null) {
                videoWidth = mediaPlayer.getVideoWidth();
                i4 = mediaPlayer.getVideoHeight();
            } else {
                videoWidth = 0;
            }
            this.a.f.b(videoWidth, i4);
        }
    }
}
