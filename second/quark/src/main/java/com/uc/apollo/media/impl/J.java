package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

/* compiled from: ProGuard */
final class J implements OnVideoSizeChangedListener {
    final /* synthetic */ G a;

    J(G g) {
        this.a = g;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.a.r.a(this.a.j, i, i2);
    }
}
