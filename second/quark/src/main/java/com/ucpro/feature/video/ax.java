package com.ucpro.feature.video;

import android.content.Context;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.ucpro.feature.video.player.a.b;

/* compiled from: ProGuard */
public final class ax extends f {
    public u m = null;

    public ax(Context context) {
        super(context);
    }

    public final boolean a(int i, b bVar, b bVar2) {
        if (!super.a(i, bVar, bVar2)) {
            switch (i) {
                case UCAsyncTask.getPercent /*10017*/:
                    if (this.m != null) {
                        break;
                    }
                    break;
                case UCAsyncTask.isPaused /*10018*/:
                    if (this.m != null) {
                        this.m.d();
                        break;
                    }
                    break;
                case 10074:
                    if (this.m != null) {
                        this.m.a(bVar, 0);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
