package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

/* compiled from: ProGuard */
final class M implements OnSeekCompleteListener {
    final /* synthetic */ G a;

    M(G g) {
        this.a = g;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        if (O.a(this.a.k) && this.a.v != null) {
            this.a.v.i = System.currentTimeMillis();
        }
        this.a.r.a(this.a.j);
    }
}
