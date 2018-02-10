package com.ucpro.business.a.b;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.business.a.b.a.f;
import com.ucpro.business.a.b.a.i;
import com.ucpro.business.a.b.b.c;
import com.ucpro.business.a.b.b.g;
import com.ucpro.business.a.b.b.h;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.j.a;
import java.util.List;

/* compiled from: ProGuard */
public class d extends e implements com.ucpro.business.e.d.e {
    private g c;
    private c d;
    private boolean e = false;
    private boolean f = false;

    protected final void a(b bVar) {
        super.a(bVar);
        this.e = com.ucpro.business.a.a.c.a();
        this.f = false;
    }

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.ck != i && com.ucpro.base.a.e.cl == i) {
            m.a(0, new e(this, message));
        }
    }

    public final void b(int i, Message message) {
        if (j.q == i) {
            m.a(0, new a(this), 10000);
        } else if (j.f == i) {
            if (this.c != null) {
                g.a();
            }
            if (this.d != null) {
                this.d.a();
            }
        }
    }

    public final void a(com.ucpro.business.e.d.j jVar, String str, String str2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 311105099:
                if (str.equals("enable_anim_doodle")) {
                    obj = 1;
                    break;
                }
                break;
            case 530678201:
                if (str.equals("enable_image_doodle")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                a.a(com.ucweb.common.util.d.a(), "EF56CBD4C21765A2", "7C720197557B1F90", Boolean.valueOf(str2).booleanValue());
                return;
            case 1:
                a.a(com.ucweb.common.util.d.a(), "CCB980D06D447B10", "C6044F3BF55BFA78", Boolean.valueOf(str2).booleanValue());
                return;
            default:
                return;
        }
    }

    public final void g() {
        super.g();
        com.ucpro.business.a.a.c.d();
        com.ucpro.business.e.d.g.a().d("enable_image_doodle");
        com.ucpro.business.e.d.g.a().d("enable_anim_doodle");
    }

    static /* synthetic */ void a(d dVar) {
        List d;
        if (com.ucpro.business.a.a.c.b() == 1) {
            dVar.d = new com.ucpro.business.a.b.b.b(dVar.b);
            d = new i().d();
            if (d != null && !d.isEmpty() && d.get(0) != null) {
                com.ucpro.business.a.b.a.d dVar2 = (com.ucpro.business.a.b.a.d) d.get(0);
                dVar.d.setImagePath(dVar2.e);
                dVar.d.setImageNightPath(dVar2.f);
                dVar.d.a(dVar2.g, dVar2.h);
                dVar.d.setInsetBottom(dVar2.i);
                dVar.d.a();
                if (dVar2 != null && !TextUtils.isEmpty(dVar2.c)) {
                    ((View) dVar.d).setOnClickListener(new b(dVar, dVar2));
                }
            }
        } else if (com.ucpro.business.a.a.c.b() == 2) {
            dVar.d = new h(dVar.b);
            d = new com.ucpro.business.a.b.a.c().d();
            if (d != null && !d.isEmpty() && d.get(0) != null) {
                f fVar = (f) d.get(0);
                dVar.d.setImagePath(fVar.d);
                dVar.d.setImageNightPath(fVar.e);
                dVar.d.a(fVar.m, fVar.n);
                dVar.d.setInsetBottom(fVar.o);
                ((h) dVar.d).setLoopTimes(fVar.k);
                ((h) dVar.d).setTriggrType(fVar.l);
                ((h) dVar.d).setPlayTimes(fVar.j);
                ((h) dVar.d).a(fVar.f, fVar.h);
                if (!fVar.g) {
                    ((h) dVar.d).a.setLayerType(1, null);
                }
                if (fVar != null && !TextUtils.isEmpty(fVar.b)) {
                    ((View) dVar.d).setOnClickListener(new c(dVar, fVar));
                }
            }
        }
    }
}
