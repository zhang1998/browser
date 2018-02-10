package com.uc.apollo.media.widget;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.uc.apollo.media.MediaDefines;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.media.widget.MediaView.a;

/* compiled from: ProGuard */
final class h extends a implements SurfaceProvider.a {
    private j b;

    h(Context context, int i, boolean z) {
        super(c.a + "MediaViewVR", context, i);
        this.b = j.a(context, z);
        this.b.setOnInfoListener(this);
        addView(this.b.asView(), new LayoutParams(-2, -2, 17));
    }

    protected final SurfaceProvider b() {
        return this.b;
    }

    public final void onSurfaceInfo(int i, int i2) {
        MediaPlayer mediaPlayer = getMediaPlayer();
        if (i == MediaDefines.MSG_ENABLE_VR_MODE && mediaPlayer != null) {
            mediaPlayer.setOption("ro.instance.vr_mode", String.valueOf(i2));
        }
        a().onMessage(i, i2, null);
    }
}
