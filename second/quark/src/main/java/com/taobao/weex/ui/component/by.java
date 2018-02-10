package com.taobao.weex.ui.component;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class by implements OnCompletionListener {
    final /* synthetic */ ca a;

    by(ca caVar) {
        this.a = caVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (i.c()) {
            WXLogUtils.d("Video", "onCompletion");
        }
        if (this.a.getDomObject().c_().contains("finish")) {
            ca.a(this.a, "finish", "stop");
        }
    }
}
