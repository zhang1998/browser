package com.ucpro.feature.video.player.b;

import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;

/* compiled from: ProGuard */
public final class g extends c {
    public g(i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    private void a(b bVar) {
        if (this.a != bVar) {
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(y.class, bVar2, bVar);
        }
    }

    public final boolean b(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        return false;
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        switch (a.a[((y) this.a).ordinal()]) {
            case 1:
            case 2:
                boolean z;
                switch (i) {
                    case UCAsyncTask.getPercent /*10017*/:
                        this.b.b(15, null, null);
                        z = true;
                        break;
                    case 10074:
                        a(y.RequestSuccess);
                        z = true;
                        break;
                    case 10075:
                        a(y.Requesting);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                return z;
            case 3:
                switch (i) {
                    case 10071:
                        a(y.RequestFail);
                        return true;
                    case 10072:
                        a(y.RequestSuccess);
                        return true;
                    case 10074:
                        a(y.RequestSuccess);
                        return true;
                    default:
                        return false;
                }
            case 4:
                switch (i) {
                    case 10074:
                        a(y.RequestSuccess);
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
