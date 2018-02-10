package com.ucpro.feature.video.player.b;

import com.quark.browser.R;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
public final class z extends c {
    public z(i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        boolean z = true;
        switch (q.a[((m) this.a).ordinal()]) {
            case 1:
                switch (i) {
                    case 10019:
                        a(m.UnLock);
                        return true;
                    case UCMPackageInfo.expectDirFile1F /*10032*/:
                        if (bVar2 != null) {
                            bVar2.a(26, Boolean.valueOf(false));
                        }
                        e.a().a((int) R.string.video_enter_locking, 0);
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (i) {
                    case 10019:
                        a(m.Locked);
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

    private void a(b bVar) {
        if (this.a != bVar) {
            int i;
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(m.class, bVar2, bVar);
            switch (q.a[((m) bVar).ordinal()]) {
                case 1:
                    i = R.string.video_enter_locking;
                    break;
                default:
                    i = R.string.video_exit_locking;
                    break;
            }
            e.a().a(i, 0);
        }
    }
}
