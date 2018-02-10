package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: ProGuard */
final class z implements OnErrorListener {
    final /* synthetic */ a a;

    z(a aVar) {
        this.a = aVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        v vVar = (v) this.a.a.get();
        if (vVar != null) {
            vVar.x.obtainMessage(4, i, i2).sendToTarget();
        }
        mediaPlayer.release();
        return true;
    }
}
