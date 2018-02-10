package com.ucpro.feature.video.player.b;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;

/* compiled from: ProGuard */
public final class i extends c {
    public i(com.ucpro.feature.video.player.a.i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        switch (o.a[((n) this.a).ordinal()]) {
            case 1:
                boolean z;
                switch (i) {
                    case SDKFactory.getCoreType /*10020*/:
                    case 10038:
                        a(n.PlayList);
                        z = true;
                        break;
                    case UCMPackageInfo.getKernelFileIfMultiCoreFromDir /*10028*/:
                        a(n.ResolutionList);
                        z = true;
                        break;
                    case 10029:
                        a(n.CacheResolutionList);
                        z = true;
                        break;
                    case 10098:
                    case 10100:
                        a(n.MoreList);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                return z;
            case 2:
                switch (i) {
                    case UCMPackageInfo.getLibFilter /*10023*/:
                    case UCMPackageInfo.expectDirFile1F /*10032*/:
                    case UCMPackageInfo.expectDirFile1S /*10033*/:
                    case UCMPackageInfo.getVersion /*10040*/:
                        a(n.None);
                        return true;
                    case 10034:
                        a(n.None);
                        this.b.b(8, bVar, bVar2);
                        return true;
                    default:
                        return false;
                }
            case 3:
                switch (i) {
                    case 10000:
                    case 10006:
                    case UCAsyncTask.isPaused /*10018*/:
                    case 10019:
                    case 10021:
                    case 10062:
                    case 10063:
                    case 10064:
                        a(n.None);
                        return true;
                    case UCMPackageInfo.getKernelFileIfMultiCoreFromDir /*10028*/:
                        a(n.None);
                        return true;
                    case 10029:
                        a(n.CacheResolutionList);
                        return true;
                    case 10073:
                        this.b.b(16, bVar, bVar2);
                        a(n.None);
                        return true;
                    case 10098:
                        a(n.MoreList);
                        return true;
                    default:
                        return false;
                }
            case 4:
                switch (i) {
                    case 10000:
                    case 10006:
                    case UCAsyncTask.isPaused /*10018*/:
                    case 10019:
                    case 10021:
                    case 10062:
                    case 10063:
                    case 10064:
                        a(n.None);
                        return true;
                    case UCMPackageInfo.getKernelFileIfMultiCoreFromDir /*10028*/:
                        a(n.ResolutionList);
                        return true;
                    case 10029:
                        a(n.None);
                        return true;
                    case 10081:
                        a(n.None);
                        return true;
                    case 10098:
                        a(n.MoreList);
                        return true;
                    default:
                        return false;
                }
            case 5:
                switch (i) {
                    case UCAsyncTask.getPercent /*10017*/:
                    case UCAsyncTask.isPaused /*10018*/:
                    case 10019:
                    case 10062:
                    case 10063:
                    case 10064:
                    case 10091:
                        a(n.None);
                        return true;
                    case 10081:
                        a(n.None);
                        return true;
                    case 10098:
                    case 10099:
                    case 10100:
                        a(n.None);
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

    private void a(b bVar) {
        if (this.a != bVar) {
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(n.class, bVar2, bVar);
        }
    }
}
