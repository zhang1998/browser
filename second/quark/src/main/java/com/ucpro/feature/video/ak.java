package com.ucpro.feature.video;

import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.MediaPlayer.OnCompletionListener;

/* compiled from: ProGuard */
final class ak implements OnCompletionListener {
    final /* synthetic */ VideoViewImpl a;

    ak(VideoViewImpl videoViewImpl) {
        this.a = videoViewImpl;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.a.e != null) {
            this.a.e.c();
        }
    }
}
