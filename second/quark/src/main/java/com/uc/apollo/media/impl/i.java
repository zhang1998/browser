package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.OnPreparedListener;
import com.uc.apollo.util.f;

/* compiled from: ProGuard */
final class i implements OnPreparedListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        int duration = mediaPlayer.getDuration();
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        String str = this.a.b;
        new StringBuilder("onPrepared, currentPos/duration/width/height ").append(f.b(this.a.q)).append("/").append(f.b(duration)).append("/").append(videoWidth).append("/").append(videoHeight);
        this.a.r.a(this.a.j, videoWidth, videoHeight);
        this.a.r.a(this.a.j, duration, videoWidth, videoHeight);
    }
}
