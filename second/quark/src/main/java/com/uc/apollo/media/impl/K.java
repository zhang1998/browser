package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: ProGuard */
final class K implements OnCompletionListener {
    final /* synthetic */ G a;

    K(G g) {
        this.a = g;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.a.r.b(this.a.j);
    }
}
