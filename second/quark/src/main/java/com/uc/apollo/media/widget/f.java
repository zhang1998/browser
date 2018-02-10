package com.uc.apollo.media.widget;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ MediaViewImpl a;

    f(MediaViewImpl mediaViewImpl) {
        this.a = mediaViewImpl;
    }

    public final void run() {
        if (this.a.mMediaPlayer != null && !this.a.mOnPreparedFired && this.a.mMediaPlayer.getHolder().w()) {
            this.a.mOuterListeners.onPrepared(this.a.mDuration, this.a.mVideoWidth, this.a.mVideoHeight);
            this.a.mOnPreparedFired = true;
        }
    }
}
