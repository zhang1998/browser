package com.ucpro.feature.video;

import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.widget.VideoView.OnExtraInfoListener;
import com.ucpro.feature.video.f.a;

/* compiled from: ProGuard */
final class aw implements OnExtraInfoListener {
    final /* synthetic */ VideoViewImpl a;

    aw(VideoViewImpl videoViewImpl) {
        this.a = videoViewImpl;
    }

    public final void onExtraInfo(MediaPlayer mediaPlayer, int i, int i2, Object obj) {
        new StringBuilder("VideoView.onExtraInfo onInfo [what: ").append(i).append(", extra: ").append(i2).append(", obj: ").append(obj).append("]");
        this.a.c.a(i, i2, obj);
        if (i == 1010) {
            if (obj instanceof String) {
                VideoViewImpl videoViewImpl = this.a;
                String str = (String) obj;
                videoViewImpl.i = a.UNKNOWN;
                if ("APOLLO".equals(str)) {
                    videoViewImpl.i = a.APOLLO;
                } else if ("SYSTEM".equals(str)) {
                    videoViewImpl.i = a.SYSTEM;
                }
            }
        } else if (i == 1011) {
        } else {
            if (i == 1003) {
                if (this.a.g != null) {
                    this.a.g.a();
                }
            } else if (i == 1004 && this.a.g != null) {
                this.a.g.b();
            }
        }
    }
}
