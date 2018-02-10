package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

/* compiled from: ProGuard */
final class N implements OnBufferingUpdateListener {
    final /* synthetic */ G a;

    N(G g) {
        this.a = g;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.a.r.a(this.a.j, 54, i, null);
    }
}
