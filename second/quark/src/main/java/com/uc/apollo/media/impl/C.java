package com.uc.apollo.media.impl;

import android.util.SparseArray;
import com.UCMobile.Apollo.Apollo;
import com.UCMobile.Apollo.MediaPlayer;
import com.uc.apollo.impl.SettingsConst;
import com.uc.apollo.media.MediaPlayerController;
import com.uc.apollo.media.base.Statistic;
import com.uc.apollo.media.base.a;
import com.uc.apollo.media.d;
import com.uc.apollo.media.service.g;
import java.util.HashMap;

/* compiled from: ProGuard */
final class C implements E {
    final /* synthetic */ B a;

    C(B b) {
        this.a = b;
    }

    public final void a(int i, int i2, int i3) {
        int size = this.a.q.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((MediaPlayerClient) this.a.q.valueAt(i4)).onVideoSizeChanged(i2, i3);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a.c.b(i2);
        if (this.a.g.d() != 4) {
            if (this.a.g.e() == 5) {
                this.a.c.b(MediaPlayer.getVersionString());
            }
            this.a.I();
        }
        B.e(this.a);
        int size = this.a.q.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((MediaPlayerClient) this.a.q.valueAt(i5)).onPrepared(i2, i3, i4);
        }
        if (this.a.h == a.b) {
            this.a.n();
        }
    }

    public final void a(int i, int i2) {
        int size = this.a.q.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((MediaPlayerClient) this.a.q.valueAt(i3)).onDurationChanged(i2);
        }
    }

    public final void a(int i) {
        int size = this.a.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((MediaPlayerClient) this.a.q.valueAt(i2)).onSeekComplete();
        }
        this.a.L();
    }

    public final void b(int i) {
        this.a.c.g();
        if (this.a.g != null) {
            this.a.j = this.a.g.p();
        }
        SparseArray clone = this.a.q.clone();
        int size = this.a.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            MediaPlayerClient mediaPlayerClient = (MediaPlayerClient) clone.valueAt(i2);
            if (this.a.q.indexOfValue(mediaPlayerClient) >= 0) {
                mediaPlayerClient.onCompletion();
            }
        }
        clone.clear();
        this.a.L();
    }

    public final void a(int i, int i2, int i3, Object obj) {
        int i4;
        int i5 = 0;
        MediaPlayerController e = this.a.e();
        switch (i2) {
            case 1:
                if (e == null) {
                    this.a.n();
                    break;
                } else {
                    e.start();
                    break;
                }
            case 2:
                if (e != null) {
                    e.pause();
                }
                this.a.r();
                break;
            case 3:
                if (e == null) {
                    this.a.a(null, i3);
                    break;
                } else {
                    e.seekTo(i3);
                    break;
                }
            case 8:
                MediaPlayerClient.exitLittleWinAnyway();
                break;
            case 71:
                if (i3 == 5) {
                    String str = (String) ((HashMap) obj).get("version");
                    this.a.c.b(str);
                    g.a().d(str);
                    g.a().c(Apollo.getBuildSeq());
                }
                g.a().a(d.b(this.a.g.e()));
                this.a.I();
                break;
            default:
                i4 = 0;
                break;
        }
        i4 = 1;
        if (i4 == 0) {
            switch (i2) {
                case 54:
                    this.a.k = i3;
                    this.a.l = System.currentTimeMillis() + 1000;
                    break;
                case 75:
                    if (!this.a.m && this.a.o) {
                        a.a(this.a);
                        break;
                    }
            }
            int size = this.a.q.size();
            while (i5 < size) {
                ((MediaPlayerClient) this.a.q.valueAt(i5)).onMessage(i2, i3, obj);
                i5++;
            }
        }
    }

    public final boolean b(int i, int i2, int i3) {
        this.a.c.f();
        int size = this.a.q.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((MediaPlayerClient) this.a.q.valueAt(i4)).onError(i2, i3);
        }
        this.a.e(null);
        MediaPlayerController e = this.a.e();
        if (e != null) {
            e.pause();
        }
        return true;
    }

    public final void a(int i, F f, F f2) {
        if (f != f2) {
            int size;
            int i2;
            if (f2.l < F.IDLE.l) {
                size = this.a.q.size();
                for (i2 = 0; i2 < size; i2++) {
                    ((MediaPlayerClient) this.a.q.valueAt(i2)).onStop();
                }
            } else if (f2.l == F.IDLE.l) {
                size = this.a.q.size();
                for (i2 = 0; i2 < size; i2++) {
                    ((MediaPlayerClient) this.a.q.valueAt(i2)).onPause();
                }
            }
            this.a.b;
            new StringBuilder("on state changed old/new ").append(f).append("/").append(f2);
            if (this.a.d != null) {
                int i3 = (f2 == F.PREPARING || f2 == F.PREPARED || f2 == F.STARTED) ? 1 : 0;
                if (this.a.d.hasMessages(1)) {
                    if (i3 == 0) {
                        this.a.d.removeMessages(1);
                    }
                } else if (i3 != 0) {
                    this.a.d.sendEmptyMessage(1);
                }
            }
        }
    }

    public final void a(int i, int i2, HashMap<String, String> hashMap) {
        if (this.a.p) {
            hashMap.put("as_sss", SettingsConst.TRUE);
            this.a.p = false;
        }
        Statistic.onStatisticUpdate(i2, hashMap);
    }

    public final void c(int i, int i2, int i3) {
        int size = this.a.q.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((MediaPlayerClient) this.a.q.valueAt(i4)).onInfo(i2, i3);
        }
    }
}
