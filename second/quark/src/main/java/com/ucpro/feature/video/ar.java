package com.ucpro.feature.video;

import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.widget.VideoView.OnInfoListener;

/* compiled from: ProGuard */
final class ar implements OnInfoListener {
    final /* synthetic */ VideoViewImpl a;

    ar(VideoViewImpl videoViewImpl) {
        this.a = videoViewImpl;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.a.d != null) {
            return this.a.d.a(i, i2);
        }
        return false;
    }
}
