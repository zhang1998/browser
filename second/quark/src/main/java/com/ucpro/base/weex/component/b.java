package com.ucpro.base.weex.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.video.ae;

/* compiled from: ProGuard */
final class b implements OnClickListener {
    final /* synthetic */ WXQuarkVideo a;

    b(WXQuarkVideo wXQuarkVideo) {
        this.a = wXQuarkVideo;
    }

    public final void onClick(View view) {
        com.ucpro.feature.video.player.a.b a = com.ucpro.feature.video.player.a.b.a();
        a.a(19, this.a.mVideoTitle);
        a.a(20, "");
        a.a(18, this.a.mVideoUrl);
        a.a(25, Integer.valueOf(this.a.mControllType));
        Object obj = new Object[3];
        obj[0] = a;
        obj[1] = this.a.mConatiner;
        g.a().b(e.bu, obj);
        if (obj[2] instanceof ae) {
            this.a.mVideoViewWrapper = (ae) obj[2];
            this.a.mVideoViewWrapper.a(this.a);
        }
    }
}
