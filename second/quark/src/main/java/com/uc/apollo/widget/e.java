package com.uc.apollo.widget;

import android.view.Surface;
import com.uc.apollo.media.widget.SurfaceListener;

/* compiled from: ProGuard */
final class e implements SurfaceListener {
    final /* synthetic */ VideoView a;
    private Object b;

    e(VideoView videoView) {
        this.a = videoView;
    }

    public final void surfaceCreated(Surface surface) {
    }

    public final void surfaceChanged(Surface surface, int i, int i2, int i3) {
    }

    public final Object getSibling() {
        return this.b;
    }

    public final void setSibling(Object obj) {
        this.b = obj;
    }

    public final void surfaceDestroyed(Surface surface) {
        if (this.a.mMediaController != null) {
            this.a.mMediaController.hide();
        }
    }
}
