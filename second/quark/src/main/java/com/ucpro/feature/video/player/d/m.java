package com.ucpro.feature.video.player.d;

import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.v;
import com.ucpro.feature.video.player.view.k;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class m implements v<g> {
    final /* synthetic */ o a;

    m(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void a(int i, Object obj) {
        g gVar = (g) obj;
        if (this.a.a.findViewById(i) != null && gVar != null) {
            if (i == 10) {
                k kVar;
                if (gVar.a) {
                    kVar = this.a.c;
                    kVar.a.animate().cancel();
                    if (kVar.d == null) {
                        kVar.d = new d(kVar.a);
                    }
                    kVar.a.animate().translationY(0.0f).setDuration(300).setListener(kVar.d).start();
                    this.a.p.a(10007, null, null);
                    return;
                }
                kVar = this.a.c;
                kVar.a.animate().cancel();
                if (kVar.e == null) {
                    kVar.e = new j(kVar.a);
                }
                kVar.a.animate().translationY((float) kVar.a.getMeasuredHeight()).setDuration(300).setListener(kVar.e).start();
            } else if (i == 5) {
                this.a.b.setImageDrawable(a.a(gVar.b));
                this.a.b.animate().cancel();
                if (gVar.a) {
                    if (this.a.e == null) {
                        this.a.e = new d(this.a.b);
                    }
                    this.a.b.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).setListener(this.a.e).start();
                    return;
                }
                if (this.a.f == null) {
                    this.a.f = new j(this.a.b);
                }
                this.a.b.animate().alpha(0.0f).setDuration(300).setListener(this.a.f).start();
            } else if (i != 47) {
            } else {
                if (gVar.a) {
                    this.a.d.b();
                    this.a.d.d();
                    return;
                }
                this.a.d.e();
            }
        }
    }
}
