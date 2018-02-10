package com.ucpro.feature.video.player.b;

import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;

/* compiled from: ProGuard */
final class u extends c {
    public u(i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    private void a(b bVar) {
        if (this.a != bVar) {
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(f.class, bVar2, bVar);
            i iVar = this.b;
            int i = 0;
            switch (d.a[((f) bVar).ordinal()]) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 14;
                    break;
            }
            iVar.b(i, null, null);
        }
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        boolean z = true;
        switch (d.a[((f) this.a).ordinal()]) {
            case 1:
                switch (i) {
                    case UCMPackageInfo.getLibFilter /*10023*/:
                    case UCMPackageInfo.getKernelResFiles /*10024*/:
                    case UCMPackageInfo.expectDirFile1F /*10032*/:
                        this.b.b(5, null, null);
                        a(f.MiniScreen);
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (i) {
                    case 10002:
                        a(f.FullScreen);
                        break;
                    default:
                        z = false;
                        break;
                }
                return z;
            default:
                return false;
        }
    }

    public final boolean b(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        return false;
    }
}
