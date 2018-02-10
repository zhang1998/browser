package com.ucpro.feature.video.player;

import android.app.Activity;
import android.net.Uri;
import com.quark.browser.R;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.widget.VideoView;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.ucpro.feature.video.b;
import com.ucpro.feature.video.player.d.o;
import com.ucpro.feature.video.player.d.p;
import com.ucpro.feature.video.player.view.af;
import com.ucpro.ui.c.a;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
final class j implements b {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void a(int i, int i2, Object obj) {
        if (1008 == i) {
            a(i2 > 0);
        } else if (1011 == i) {
            if (obj != null && (obj instanceof Uri)) {
                this.a.a(((Uri) obj).toString());
            }
        } else if (VideoView.VIDEO_INFO_ON_DESTROY == i) {
            this.a.a(UCAsyncTask.getTaskCount, null, null);
        }
    }

    public final boolean a(int i) {
        Object d;
        com.ucpro.feature.video.player.a.b a = com.ucpro.feature.video.player.a.b.a().a(12, Integer.valueOf(i));
        if (i < -5999 || i > -5000) {
            switch (i) {
                case -1481985528:
                case -1414549496:
                case -1414092869:
                case -1397118274:
                case -1330794744:
                case -1313558101:
                case -1296385272:
                case -1279870712:
                case -1179861752:
                case -1163346256:
                case -1129203192:
                case -1128613112:
                case -733130664:
                case -558323010:
                case -542398533:
                case -541545794:
                case -12:
                case -11:
                case -1:
                    d = a.d((int) R.string.video_error_tips_play);
                    break;
                case -1094995529:
                case -541478725:
                case -5:
                    d = a.d((int) R.string.video_error_tips_read);
                    break;
                case MediaPlayer.MEDIA_ERROR_IO /*-1004*/:
                    d = a.d((int) R.string.video_error_tips_net);
                    break;
                case -104:
                case -2:
                case 0:
                    d = a.d((int) R.string.video_error_tips_unknown);
                    break;
                case -16:
                case -15:
                case -14:
                case -13:
                    d = a.d((int) R.string.video_error_tips_format);
                    break;
                default:
                    d = a.d((int) R.string.video_error_tips_play);
                    break;
            }
        }
        d = a.d((int) R.string.video_error_tips_net_check);
        com.ucpro.feature.video.player.a.b a2 = a.a(13, d);
        this.a.a(UCAsyncTask.getPriority, a2, null);
        a2.b();
        return false;
    }

    public final void a() {
        this.a.a(10009, null, null);
    }

    public final void b() {
        this.a.a(10010, null, null);
    }

    public final void b(int i) {
        e eVar = this.a.e;
        if (eVar.d != i) {
            eVar.d = i;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - eVar.a > 200 || i > 90) {
                eVar.a();
                eVar.a = currentTimeMillis;
            }
        }
    }

    public final void b(int i, int i2) {
        this.a.e.m = i;
        this.a.e.n = i2;
        this.a.a(10012, null, null);
    }

    @DebugLog
    public final boolean a(int i, int i2) {
        switch (i) {
            case 701:
                this.a.e.a(true);
                break;
            case 702:
                this.a.e.a(false);
                break;
            case 901:
                e eVar = this.a.e;
                if (eVar.e != i2) {
                    eVar.e = i2;
                    eVar.a();
                    break;
                }
                break;
        }
        return true;
    }

    public final void c() {
        this.a.a(10011, null, null);
    }

    public final void a(boolean z) {
        if (this.a.d != null) {
            r rVar = this.a.d;
            if (rVar.c != null) {
                p pVar = rVar.c;
                if (pVar.b != null) {
                    pVar.b.setSupportLittleWindow(z);
                }
                if (pVar.k != null) {
                    af afVar = pVar.k;
                    if (afVar.d != null) {
                        afVar.d.b(z);
                    }
                }
            }
            if (rVar.d != null) {
                o oVar = rVar.d;
                if (oVar.d != null) {
                    oVar.d.b(z);
                }
            }
        }
    }

    public final void d() {
        if (!this.a.f) {
            Object obj = null;
            switch (((Activity) this.a.a).getRequestedOrientation()) {
                case 0:
                case 6:
                case 8:
                    obj = 1;
                    break;
            }
            if (obj != null && !this.a.k()) {
                this.a.a(10002, null, null);
            }
        }
    }
}
