package com.uc.apollo.media.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.uc.apollo.util.f;

/* compiled from: ProGuard */
final class I implements OnPreparedListener {
    final /* synthetic */ G a;

    I(G g) {
        this.a = g;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        int i = -1;
        int i2 = 1;
        this.a.x = true;
        this.a.m = mediaPlayer.getDuration();
        int i3 = this.a.m;
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        String str = this.a.b;
        new StringBuilder("onPrepared, currentPos/duration/width/height ").append(f.b(this.a.q)).append("/").append(f.b(i3)).append("/").append(videoWidth).append("/").append(videoHeight);
        if (O.b(this.a.k)) {
            if (i3 != -1) {
                String str2 = this.a.b;
                new StringBuilder("current video is live, duration(").append(this.a.m).append(") from MediaPlayer is invalid, modify to -1 by standard");
                this.a.m = -1;
            }
            i = i3;
        } else {
            if (!u.j(i3) && this.a.n >= 0) {
                String str3 = this.a.b;
                i = this.a.n;
            }
            i = i3;
        }
        if (this.a.w) {
            if (this.a.o == 1 && videoWidth > 0 && videoHeight > 0) {
                this.a.r.a(this.a.j, videoWidth, videoHeight);
            }
            if (i != this.a.l) {
                this.a.r.a(this.a.j, i, videoWidth, videoHeight);
            }
            if (this.a.q > 1000 && this.a.q < this.a.m) {
                mediaPlayer.seekTo(this.a.q);
            }
            if (this.a.a() == F.STARTED) {
                mediaPlayer.start();
                return;
            }
            return;
        }
        this.a.w = true;
        if (videoWidth == 0 || videoHeight == 0) {
            this.a.r.a(this.a.j, 1, 1);
            i3 = 1;
        } else {
            i3 = videoHeight;
            i2 = videoWidth;
        }
        this.a.r.a(this.a.j, i, i2, i3);
    }
}
