package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.UCMobile.Apollo.MediaPlayer.OnErrorListener;

/* compiled from: ProGuard */
final class o implements OnErrorListener {
    final /* synthetic */ h a;

    o(h hVar) {
        this.a = hVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this.a.r.b(this.a.j, i, i2);
    }
}
