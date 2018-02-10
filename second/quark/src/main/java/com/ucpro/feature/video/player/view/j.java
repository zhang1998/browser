package com.ucpro.feature.video.player.view;

import com.ucpro.feature.video.player.b.v;

/* compiled from: ProGuard */
final class j implements v<ab> {
    final /* synthetic */ f a;

    j(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void a(int i, Object obj) {
        ab abVar = (ab) obj;
        switch (i) {
            case 41:
                a aVar;
                switch (abVar.a) {
                    case 0:
                        aVar = this.a.a;
                        aVar.b.setVisibility(8);
                        aVar.c.setVisibility(8);
                        return;
                    case 1:
                        aVar = this.a.a;
                        aVar.b.setVisibility(0);
                        aVar.b.setImage(aVar.d);
                        return;
                    case 2:
                        aVar = this.a.a;
                        aVar.b.setVisibility(0);
                        aVar.b.setImage(aVar.e);
                        return;
                    case 3:
                        this.a.a.c.setVisibility(0);
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }
}
