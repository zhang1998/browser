package com.uc.apollo.media.widget;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ MediaViewImpl a;

    e(MediaViewImpl mediaViewImpl) {
        this.a = mediaViewImpl;
    }

    public final void run() {
        if (this.a.mSurfaceProvider != null) {
            this.a.mSurfaceProvider.asView().requestLayout();
        }
    }
}
