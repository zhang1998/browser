package com.ucpro.feature.navigation.view.a;

import android.view.MotionEvent;
import android.view.View;
import com.ucpro.business.stat.m;
import com.ucpro.feature.navigation.view.aq;
import com.ucpro.feature.navigation.view.ax;
import com.ucpro.feature.navigation.view.e;
import com.ucpro.feature.navigation.view.j;
import com.ucpro.feature.navigation.view.t;
import com.ucpro.feature.y.o;

/* compiled from: ProGuard */
public final class c extends f {
    private boolean a;

    private c() {
    }

    public static c a() {
        return e.a;
    }

    public final boolean a(aq aqVar, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.a = false;
                this.c.x = x;
                this.c.y = y;
                break;
            case 1:
                if (!(this.a || aqVar.f || !aqVar.g())) {
                    for (x = 0; x < aqVar.a.getChildCount(); x++) {
                        View childAt = aqVar.a.getChildAt(x);
                        if (childAt instanceof e) {
                            ((e) childAt).b();
                            aqVar.postDelayed(aqVar.g, 3000);
                            break;
                        }
                    }
                    aqVar.postDelayed(aqVar.g, 3000);
                }
            case 2:
                int a = t.a(aqVar.getContext());
                if (Math.abs(x - this.c.x) > a || Math.abs(y - this.c.y) > a) {
                    this.a = true;
                    break;
                }
        }
        return aqVar.a(motionEvent);
    }

    public final void b(aq aqVar) {
        boolean z;
        super.b(aqVar);
        if (aqVar.c != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            aqVar.getDragLayer().b = false;
        }
    }

    public final boolean a(aq aqVar, j jVar, int i, Object obj) {
        boolean z = true;
        if (jVar == null) {
            return false;
        }
        ax widgetInfo = jVar.getWidgetInfo();
        if (i == 3) {
            if (widgetInfo.b == 0) {
                aqVar.d.b(widgetInfo);
            } else if (widgetInfo.b == 1 && (jVar instanceof e)) {
                ((e) jVar).c();
            }
        } else if (i == 4) {
            m.a("navigation", "ns_long_ck", new String[0]);
            m.b("navigation_ut", "ns_long_ck", new String[0]);
            m.a(o.r);
            if (widgetInfo.b == 0 || widgetInfo.b == 1) {
                aqVar.d.a((View) jVar);
            }
        } else {
            z = false;
        }
        return z;
    }
}
