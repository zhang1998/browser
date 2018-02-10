package com.ucpro.feature.video.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.uc.apollo.widget.MediaController;
import com.uc.apollo.widget.MediaController.MediaPlayerControl;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.e.a;

/* compiled from: ProGuard */
public final class l implements MediaController {
    protected Context a;
    protected MediaPlayerControl b;
    r c;
    private ViewGroup d;

    public l(Context context, g gVar, a aVar, int i) {
        this.a = context;
        this.c = new r(context, gVar, aVar, i);
    }

    public final void hide() {
    }

    public final boolean isShowing() {
        return true;
    }

    public final void setAnchorView(ViewGroup viewGroup) {
        new StringBuilder("setAnchorView: ").append(viewGroup);
        this.d = viewGroup;
        if (this.d != null) {
            View view = this.c.a;
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.d.addView(view, new LayoutParams(-1, -1));
        }
    }

    public final void setEnabled(boolean z) {
        new StringBuilder("setEnabled: ").append(z).append("  ").append(this.b);
    }

    public final void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        new StringBuilder("setMediaPlayer: ").append(mediaPlayerControl);
        this.b = mediaPlayerControl;
    }

    public final void show(int i) {
        new StringBuilder("show: ").append(i).append("  ").append(this.b);
    }

    public final void show() {
        new StringBuilder("show  ").append(this.b);
    }

    public final boolean playInMobileNetwork() {
        return true;
    }
}
