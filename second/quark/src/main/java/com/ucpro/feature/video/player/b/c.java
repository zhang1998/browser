package com.ucpro.feature.video.player.b;

import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.d;

/* compiled from: ProGuard */
public final class c extends com.ucpro.feature.video.player.e.c {
    public c(i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    private void a(b bVar) {
        if (this.a != bVar) {
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(r.class, bVar2, bVar);
        }
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        switch (t.a[((r) this.a).ordinal()]) {
            case 1:
                boolean z;
                switch (i) {
                    case 10001:
                    case 10006:
                    case 10021:
                        this.b.b(1, null, null);
                        a(r.Playing);
                        z = true;
                        break;
                    case 10009:
                        a(r.Playing);
                        z = true;
                        break;
                    case 10010:
                        a(r.Paused);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                return z;
            case 2:
                switch (i) {
                    case 10001:
                    case 10021:
                    case UCMPackageInfo.getKernelResFiles /*10024*/:
                        this.b.b(2, null, null);
                        a(r.Paused);
                        return true;
                    case 10010:
                    case UCAsyncTask.getPriority /*10013*/:
                        a(r.Paused);
                        return true;
                    case 10011:
                        a(r.Completed);
                        return true;
                    default:
                        return false;
                }
            case 3:
                switch (i) {
                    case 10001:
                    case 10006:
                    case 10021:
                        this.b.b(1, null, null);
                        a(r.Playing);
                        return true;
                    case 10009:
                        a(r.Playing);
                        return true;
                    default:
                        return false;
                }
            case 4:
                switch (i) {
                    case 10001:
                    case 10006:
                    case 10021:
                        this.b.b(1, null, null);
                        a(r.Playing);
                        return true;
                    case 10009:
                        a(r.Playing);
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    public final boolean b(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        return false;
    }
}
