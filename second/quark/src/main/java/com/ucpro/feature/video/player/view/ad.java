package com.ucpro.feature.video.player.view;

import android.view.View;
import com.ucpro.feature.video.player.b.v;

/* compiled from: ProGuard */
final class ad implements v<Boolean> {
    final /* synthetic */ af a;

    ad(af afVar) {
        this.a = afVar;
    }

    public final /* synthetic */ void a(int i, Object obj) {
        Boolean bool = (Boolean) obj;
        View findViewById = this.a.a.findViewById(i);
        if (findViewById != null) {
            if (i != 44) {
                findViewById.setVisibility(bool.booleanValue() ? 0 : 4);
                switch (i) {
                    case 28:
                        af.a(this.a, this.a.b, true);
                        return;
                    case 33:
                        af.a(this.a, this.a.c, false);
                        return;
                    default:
                        return;
                }
            } else if (bool.booleanValue()) {
                this.a.d.b();
                this.a.d.d();
            } else {
                this.a.d.e();
            }
        }
    }
}
