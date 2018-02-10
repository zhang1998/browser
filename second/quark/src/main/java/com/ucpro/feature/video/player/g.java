package com.ucpro.feature.video.player;

import android.view.View;
import com.ucpro.feature.video.player.b.v;

/* compiled from: ProGuard */
final class g implements v<d> {
    final /* synthetic */ r a;

    g(r rVar) {
        this.a = rVar;
    }

    public final /* synthetic */ void a(int i, Object obj) {
        d dVar = (d) obj;
        View findViewById = this.a.a.findViewById(i);
        if (findViewById != null && dVar != null) {
            findViewById.setVisibility(dVar.a ? 0 : 8);
            if (findViewById.getId() == 4) {
                com.ucpro.feature.video.player.view.v vVar = this.a.b;
                vVar.b = dVar.b;
                vVar.b();
            }
        }
    }
}
