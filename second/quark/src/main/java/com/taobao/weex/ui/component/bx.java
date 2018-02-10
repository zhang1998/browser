package com.taobao.weex.ui.component;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.taobao.weex.i;
import com.taobao.weex.ui.view.WXVideoView.Wrapper;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class bx implements OnPreparedListener {
    final /* synthetic */ Wrapper a;
    final /* synthetic */ ca b;

    bx(ca caVar, Wrapper wrapper) {
        this.b = caVar;
        this.a = wrapper;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (i.c()) {
            WXLogUtils.d("Video", "onPrepared");
        }
        this.a.getProgressBar().setVisibility(8);
        this.b.a = true;
        if (this.b.b) {
            this.a.a();
        }
        this.a.getVideoView().seekTo(5);
        if (this.a.getMediaController() != null) {
            if (this.b.e) {
                this.a.getMediaController().hide();
            } else {
                this.a.getMediaController().show(3);
            }
        }
        this.b.e = false;
    }
}
