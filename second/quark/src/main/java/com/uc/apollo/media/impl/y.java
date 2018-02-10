package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.uc.apollo.util.f;

/* compiled from: ProGuard */
final class y implements OnPreparedListener {
    final /* synthetic */ a a;

    y(a aVar) {
        this.a = aVar;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        v vVar = (v) this.a.a.get();
        if (vVar != null) {
            int duration = mediaPlayer.getDuration();
            if (O.b(vVar.k)) {
                if (duration > 0) {
                    String str = vVar.b;
                    duration = 0;
                }
            } else if (!u.j(duration) && vVar.n >= 0) {
                String str2 = vVar.b;
                new StringBuilder("duration from MediaPlayer is invalid, use duration from parser. mediaPlayer/parser ").append(f.b(duration)).append("/").append(f.b(vVar.n));
                duration = vVar.n;
            }
            vVar.x.obtainMessage(1, new int[]{duration, mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight()}).sendToTarget();
        }
        mediaPlayer.release();
    }
}
