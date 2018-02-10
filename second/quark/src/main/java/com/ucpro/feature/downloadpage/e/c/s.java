package com.ucpro.feature.downloadpage.e.c;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.bh;
import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.feature.downloadpage.e.c.a.d;
import com.ucpro.feature.downloadpage.e.c.a.f;
import com.ucpro.feature.downloadpage.e.c.a.g;
import com.ucpro.feature.downloadpage.e.c.a.j;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class s extends bh {
    t l;
    int m;
    int n;
    private n o;
    private j p;
    private String q;

    public s(t tVar, n nVar, j jVar) {
        super(tVar);
        this.l = tVar;
        this.o = nVar;
        this.p = jVar;
    }

    @DebugLog
    public final void a(int i, long j, long j2, long j3, boolean z, int i2) {
        this.l.setTextProgress(b.a.a(j) + "/" + b.a.a(j2));
        float f;
        if (i == 1) {
            this.l.c();
            this.l.setTextSpeed(a.d((int) R.string.tasks_manager_demo_status_pending));
            f = (j2 <= 0 ? 0.0f : ((float) j) / ((float) j2)) * 1000.0f;
            if (z) {
                this.l.setProgressWithAnimation(f);
            } else {
                this.l.setProgress(f);
            }
        } else if (i == 2 || i == 6 || i == 5) {
            this.l.setTextSpeed(i == 5 ? a.d((int) R.string.download_status_retry) : a.d((int) R.string.tasks_manager_demo_status_connected));
        } else if (i == -3) {
            a((float) j, (float) j2);
            n nVar = this.o;
            t tVar = this.l;
            if (tVar.getIconImageView().getTag() == null) {
                tVar.getIconImageView().setTag(new g(nVar));
            }
            com.ucpro.feature.downloadpage.e.c.a.b bVar = (com.ucpro.feature.downloadpage.e.c.a.b) tVar.getIconImageView().getTag();
            if (nVar.c.size() > tVar.getPosition()) {
                com.uc.quark.s sVar = (com.uc.quark.s) nVar.c.get(tVar.getPosition());
                g a = j.a;
                String h = sVar.h();
                Drawable a2 = a.a(h);
                if (a2 != null) {
                    bVar.a(h, a2, tVar);
                } else {
                    m.b(0, new f(a, h), new d(a, bVar, h, tVar));
                }
            }
        } else if (i == 7) {
            if (!com.ucweb.common.util.n.a.b(this.q)) {
                this.q = a.d((int) R.string.download_pre_create_progress);
            }
            this.l.setTextSpeed(i2 != 100 ? this.q + "(" + i2 + "%)" : a.d((int) R.string.download_pre_create_complete));
        } else if (i == 3) {
            this.l.c();
            f = j2 <= 0 ? 0.0f : ((float) j) / ((float) j2);
            if (z) {
                this.l.setProgressWithAnimation(f * 1000.0f);
            } else {
                this.l.setProgress(f * 1000.0f);
            }
            this.l.setTextSpeed(b.a.a(1024 * j3) + "/s");
            switch (i) {
                case 1:
                    this.l.setTextSpeed(a.d((int) R.string.tasks_manager_demo_status_pending));
                    return;
                case 2:
                    this.l.setTextSpeed(a.d((int) R.string.tasks_manager_demo_status_connected));
                    return;
                case 6:
                    this.l.setTextSpeed(a.d((int) R.string.tasks_manager_demo_status_connected));
                    return;
                default:
                    return;
            }
        } else {
            if (j <= 0 || j2 <= 0) {
                this.l.setProgress(0.0f);
            } else {
                this.l.setProgress((((float) j) / ((float) j2)) * 1000.0f);
            }
            a((float) j, (float) j2);
            switch (i) {
                case -5:
                case -2:
                    this.l.d();
                    this.l.setTextSpeed(a.d((int) R.string.download_pause));
                    return;
                case -1:
                    t tVar2 = this.l;
                    int progress = tVar2.a.getProgress();
                    tVar2.setProgressDrawable$4dfd987c(p.b);
                    tVar2.setProgress((float) (progress - 1));
                    tVar2.setProgress((float) progress);
                    tVar2.b.setTextColor(tVar2.f);
                    tVar2.b.setText(a.d((int) R.string.download_fail));
                    tVar2.setStatus$3a0cd121(e.a);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(float f, float f2) {
        float f3 = 0.0f;
        if (f2 > 0.0f) {
            f3 = f / f2;
        }
        this.l.setProgress(f3 * 1000.0f);
    }

    public final void c(int i) {
        switch (i) {
            case -5:
            case -2:
                this.l.d();
                this.l.setTextSpeed(a.d((int) R.string.download_pause));
                return;
            case 1:
                this.l.c();
                return;
            case 3:
                this.l.c();
                return;
            default:
                return;
        }
    }
}
