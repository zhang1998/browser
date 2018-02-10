package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;

/* compiled from: ProGuard */
public final class p extends c {
    public p(i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    private void a(b bVar) {
        if (this.a != bVar) {
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(l.class, bVar2, bVar);
        }
    }

    public final boolean b(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        return false;
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        switch (b.a[((l) this.a).ordinal()]) {
            case 1:
                boolean z;
                switch (i) {
                    case 10062:
                        a(l.LightChange);
                        z = true;
                        break;
                    case 10063:
                        a(l.VolumeChange);
                        z = true;
                        break;
                    case 10064:
                        a(l.SeekChange);
                        z = true;
                        break;
                    case 10069:
                        a(l.Idle);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                return z;
            case 2:
            case 3:
                switch (i) {
                    case 10069:
                        a(l.Idle);
                        return true;
                    default:
                        return false;
                }
            case 4:
                switch (i) {
                    case 10069:
                        this.b.b(3, bVar, bVar2);
                        a(l.Idle);
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
