package com.uc.apollo.widget;

import com.uc.apollo.Settings;
import com.uc.apollo.media.widget.a;

/* compiled from: ProGuard */
final class d implements a {
    final /* synthetic */ VideoView a;

    d(VideoView videoView) {
        this.a = videoView;
    }

    public final void a(int i) {
        if (Settings.getEnableFullScreen()) {
            String str = this.a.mLogTag;
            this.a.mFullScreenVideoView = this.a.createFullscreenVideoView();
            this.a.mFullScreenVideoView.a(i);
        }
    }

    public final void a() {
        if (Settings.getEnableFullScreen()) {
            String str = this.a.mLogTag;
            if (this.a.mFullScreenVideoView != null) {
                this.a.mFullScreenVideoView.a();
                this.a.mFullScreenVideoView.destroy();
                this.a.mFullScreenVideoView = null;
            }
        }
    }
}
