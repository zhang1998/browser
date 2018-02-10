package com.ucpro.feature.video.player.d;

import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.v;
import com.ucpro.feature.video.player.view.s;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class k implements v<i> {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void a(int i, Object obj) {
        i iVar = (i) obj;
        if (this.a.a.findViewById(i) != null && iVar != null) {
            if (i == 10) {
                s sVar;
                if (iVar.a) {
                    sVar = this.a.c;
                    sVar.a.animate().cancel();
                    if (sVar.c == null) {
                        sVar.c = new d(sVar.a);
                    }
                    sVar.a.animate().translationY(0.0f).setDuration(300).setListener(sVar.c).start();
                    this.a.p.a(10007, null, null);
                    return;
                }
                sVar = this.a.c;
                sVar.a.animate().cancel();
                if (sVar.d == null) {
                    sVar.d = new j(sVar.a);
                }
                sVar.a.animate().translationY((float) sVar.a.getMeasuredHeight()).setDuration(300).setListener(sVar.d).start();
            } else if (i == 5) {
                this.a.b.setImageDrawable(a.a(iVar.b));
                this.a.b.animate().cancel();
                if (iVar.a) {
                    if (this.a.d == null) {
                        this.a.d = new d(this.a.b);
                    }
                    this.a.b.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).setListener(this.a.d).start();
                    return;
                }
                if (this.a.e == null) {
                    this.a.e = new j(this.a.b);
                }
                this.a.b.animate().alpha(0.0f).setDuration(300).setListener(this.a.e).start();
            }
        }
    }
}
