package com.ucpro.feature.navigation.view.a;

import android.view.MotionEvent;
import android.view.View;
import com.ucpro.business.stat.m;
import com.ucpro.feature.navigation.view.aq;
import com.ucpro.feature.navigation.view.as;
import com.ucpro.feature.navigation.view.j;
import com.ucpro.feature.navigation.view.l;
import com.ucpro.feature.navigation.view.s;
import com.ucpro.feature.navigation.view.w;
import com.ucpro.feature.y.o;

/* compiled from: ProGuard */
public final class a extends f {
    w a = null;
    private int d;
    private int e;

    a() {
    }

    public static a a() {
        return b.a;
    }

    public final boolean a(aq aqVar, MotionEvent motionEvent) {
        if (f.b(aqVar, motionEvent)) {
            return false;
        }
        if (motionEvent.getPointerCount() > 1) {
            aqVar.setCurrentState(d.a);
            aqVar.h();
            return false;
        }
        l dragObject = aqVar.getDragObject();
        if (dragObject != null) {
            this.d = (int) motionEvent.getX();
            this.e = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            switch (action) {
                case 1:
                case 3:
                    dragObject.a(this.d, this.e);
                    w a = aqVar.a(dragObject);
                    if (action != 3 && a != null && a.b()) {
                        a.a(dragObject, new h(this, aqVar));
                        a.a();
                        m.a("navigation", "drag_widget", new String[0]);
                        m.b("navigation_ut", "drag_widget", new String[0]);
                        m.a(o.s);
                        break;
                    }
                    aqVar.h();
                    aqVar.setCurrentState(d.a);
                    break;
                    break;
                case 2:
                    dragObject.a(this.d, this.e);
                    w a2 = aqVar.a(dragObject);
                    if (a2 != null) {
                        if (a2 != this.a) {
                            if (this.a != null) {
                                this.a.a();
                            }
                            a2.a(dragObject);
                            this.a = a2;
                        }
                        a2.b(dragObject);
                        break;
                    }
                    break;
            }
            return true;
        } else if (motionEvent.getAction() != 1) {
            return false;
        } else {
            aqVar.setCurrentState(d.a);
            return false;
        }
    }

    public final void a(aq aqVar) {
        super.a(aqVar);
        s launcherGridView = aqVar.getLauncherGridView();
        for (int i = 0; i < launcherGridView.getChildCount(); i++) {
            View childAt = launcherGridView.getChildAt(i);
            childAt.setVisibility(0);
            childAt.invalidate();
        }
        ((as) launcherGridView.getAdapter()).a(null);
        launcherGridView.a();
        launcherGridView.c();
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }

    public final void b(aq aqVar) {
        super.b(aqVar);
        aqVar.i();
    }

    public final boolean a(aq aqVar, j jVar, int i, Object obj) {
        return super.a(aqVar, jVar, i, obj);
    }
}
