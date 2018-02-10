package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: ProGuard */
final class L implements OnErrorListener {
    final /* synthetic */ G a;

    L(G g) {
        this.a = g;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this.a.r.b(this.a.j, i, i2);
    }
}
