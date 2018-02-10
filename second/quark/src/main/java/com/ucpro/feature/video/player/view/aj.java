package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class aj extends ImageView {
    public aj(Context context) {
        super(context);
        setNetworkType$2ea18d7c(al.a);
    }

    public final void setNetworkType$2ea18d7c(int i) {
        Drawable drawable = null;
        switch (o.a[i - 1]) {
            case 1:
                drawable = a.a("new_video_top_bar_wifi.svg");
                break;
            case 2:
                drawable = a.a("video_net_type_mobile.svg");
                break;
            case 3:
                drawable = a.a("video_net_type_local.svg");
                break;
        }
        setImageDrawable(drawable);
    }
}
