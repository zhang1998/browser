package com.ucpro.feature.video.player;

import android.content.Context;
import android.view.KeyEvent;
import com.uc.apollo.widget.VideoView;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.video.ai;

/* compiled from: ProGuard */
public final class c extends VideoView {
    private ai a;

    public c(Context context, int i, boolean z) {
        super(context, i, z);
        setBackgroundColor(-16777216);
    }

    public c(Context context, int i) {
        super(context, i);
        setBackgroundColor(-16777216);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        g.a().b(e.bo, -1, 0, new boolean[]{null});
        return true;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.d();
        }
    }

    public final void setSizeChangedListener(ai aiVar) {
        this.a = aiVar;
    }
}
