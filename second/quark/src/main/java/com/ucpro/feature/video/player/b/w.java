package com.ucpro.feature.video.player.b;

import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;

/* compiled from: ProGuard */
public final class w extends c {
    public w(i iVar, d dVar, b bVar) {
        super(iVar, dVar, bVar);
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        boolean z = true;
        switch (e.a[((s) this.a).ordinal()]) {
            case 1:
                switch (i) {
                    case 10000:
                    case 10008:
                        a(s.HoverOff);
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (i) {
                    case 10000:
                    case 10037:
                        a(s.HoverOn);
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
            b bVar2 = this.a;
            this.a = bVar;
            this.c.a(s.class, bVar2, bVar);
            if (bVar == s.HoverOn) {
                this.b.b(17, null, null);
            } else if (bVar == s.HoverOff) {
                this.b.b(18, null, null);
            }
        }
    }
}
