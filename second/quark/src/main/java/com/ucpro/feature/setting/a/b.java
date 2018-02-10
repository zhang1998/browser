package com.ucpro.feature.setting.a;

import android.content.Context;
import com.ucpro.feature.setting.view.item.a;
import com.ucpro.feature.setting.view.item.d;
import com.ucpro.feature.setting.view.item.f;
import com.ucpro.feature.setting.view.item.g;
import com.ucpro.feature.setting.view.item.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    public List<h> a = new ArrayList();
    private Context b;
    private g c;

    public b(Context context, g gVar) {
        this.b = context;
        this.c = gVar;
    }

    public final void a(List<d> list) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        for (d dVar : list) {
            Context context = this.b;
            g gVar = this.c;
            h hVar = null;
            int i;
            String str;
            String a;
            boolean b;
            switch (dVar.a) {
                case (byte) 0:
                    i = dVar.c;
                    str = dVar.b;
                    if (gVar != null) {
                        a = gVar.a(dVar.c);
                    } else {
                        a = dVar.d;
                    }
                    if (gVar != null) {
                        b = gVar.b(dVar.c);
                    } else {
                        b = dVar.e;
                    }
                    hVar = new f(context, i, str, a, b, dVar.g);
                    break;
                case (byte) 1:
                    boolean b2;
                    i = dVar.c;
                    str = dVar.b;
                    if (gVar != null) {
                        b2 = gVar.b(dVar.c);
                    } else {
                        b2 = dVar.e;
                    }
                    hVar = new com.ucpro.feature.setting.view.item.b(context, i, str, b2, dVar.g);
                    break;
                case (byte) 2:
                    i = dVar.c;
                    str = dVar.b;
                    if (gVar != null) {
                        a = gVar.a(dVar.c);
                    } else {
                        a = dVar.d;
                    }
                    if (gVar != null) {
                        b = gVar.b(dVar.c);
                    } else {
                        b = dVar.e;
                    }
                    hVar = new d(context, i, str, a, b);
                    break;
                case (byte) 6:
                    i = dVar.c;
                    str = dVar.b;
                    a = dVar.d;
                    if (gVar != null) {
                        b = gVar.b(dVar.c);
                    } else {
                        b = dVar.e;
                    }
                    hVar = new g(context, i, str, a, b);
                    break;
                case (byte) 7:
                    i = dVar.c;
                    str = dVar.b;
                    a = dVar.d;
                    if (gVar != null) {
                        b = gVar.b(dVar.c);
                    } else {
                        b = dVar.e;
                    }
                    hVar = new a(context, i, str, a, b, dVar.g);
                    break;
            }
            if (hVar != null) {
                hVar.setSettingItemData(dVar);
                if (hVar != null) {
                    this.a.add(hVar);
                }
            }
        }
    }

    public final void a() {
        if (this.a != null) {
            for (h hVar : this.a) {
                d settingItemData = hVar.getSettingItemData();
                if (!(settingItemData == null || settingItemData.f == null)) {
                    hVar.setViewVisibility(settingItemData.f.a());
                }
            }
        }
    }

    public final void b() {
        if (this.a != null) {
            for (h hVar : this.a) {
                hVar.a(this.c.a(hVar.getKey()));
            }
        }
    }

    public final void c() {
        if (this.a != null) {
            for (h a : this.a) {
                a.a();
            }
        }
    }

    public final void d() {
        if (this.a != null) {
            for (h key : this.a) {
                this.c.b(key.getKey());
            }
        }
    }
}
