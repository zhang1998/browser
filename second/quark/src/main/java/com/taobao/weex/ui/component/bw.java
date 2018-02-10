package com.taobao.weex.ui.component;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.taobao.weex.i;
import com.taobao.weex.ui.view.WXVideoView.Wrapper;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class bw implements OnErrorListener {
    final /* synthetic */ Wrapper a;
    final /* synthetic */ ca b;

    bw(ca caVar, Wrapper wrapper) {
        this.b = caVar;
        this.a = wrapper;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i.c()) {
            WXLogUtils.d("Video", "onError:" + i);
        }
        this.a.getProgressBar().setVisibility(8);
        this.b.a = false;
        this.b.d = true;
        if (this.b.getDomObject().c_().contains("fail")) {
            ca.a(this.b, "fail", "stop");
        }
        return true;
    }
}
