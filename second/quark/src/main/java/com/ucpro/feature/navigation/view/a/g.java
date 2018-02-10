package com.ucpro.feature.navigation.view.a;

import android.graphics.Point;
import android.support.v4.view.a.b;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.ucpro.business.stat.m;
import com.ucpro.feature.navigation.view.ac;
import com.ucpro.feature.navigation.view.aq;
import com.ucpro.feature.navigation.view.as;
import com.ucpro.feature.navigation.view.ax;
import com.ucpro.feature.navigation.view.j;
import com.ucpro.feature.navigation.view.s;
import com.ucpro.feature.navigation.view.u;
import com.ucpro.feature.navigation.view.v;
import com.ucpro.feature.y.o;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class g extends f {
    private Point a;
    private boolean d;

    private g() {
        this.a = new Point();
    }

    public static g a() {
        return d.a;
    }

    public final boolean a(aq aqVar, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 4:
                if (keyEvent.getAction() == 1) {
                    d(aqVar);
                    return true;
                }
                break;
        }
        return false;
    }

    public final boolean a(aq aqVar, MotionEvent motionEvent) {
        if (aqVar.a.b()) {
            return true;
        }
        if (f.b(aqVar, motionEvent)) {
            return false;
        }
        boolean z;
        this.a.x = (int) motionEvent.getX();
        this.a.y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (aqVar.getDragObject() != null) {
                if (aqVar.getDragObject().p.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    z = true;
                    this.d = z;
                }
            }
            z = false;
            this.d = z;
        }
        if (this.d || aqVar.a.b()) {
            z = true;
        } else {
            z = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.d = false;
        }
        if (z) {
            return true;
        }
        return aqVar.a(motionEvent);
    }

    public final void b(aq aqVar) {
        super.b(aqVar);
        aqVar.i();
        this.d = false;
    }

    public final boolean a(aq aqVar, j jVar, int i, Object obj) {
        if (jVar == null) {
            return false;
        }
        ax widgetInfo = jVar.getWidgetInfo();
        if (i == 5) {
            if (this.d || aqVar.a.b() || jVar.getWidgetInfo() == null || jVar.getWidgetInfo().b != 0) {
                return false;
            }
            boolean a = aqVar.a(jVar, this.a);
            aqVar.setCurrentState(b.a);
            return a;
        } else if (i != 1) {
            return false;
        } else {
            if (widgetInfo.b == 0) {
                s launcherGridView = aqVar.getLauncherGridView();
                Runnable acVar = new ac(aqVar, jVar);
                v vVar = launcherGridView.a;
                if (jVar instanceof u) {
                    vVar.b.clear();
                    if (jVar instanceof u) {
                        u uVar = (u) jVar;
                        uVar.o.animate().cancel();
                        uVar.o.animate().translationY((float) uVar.o.getHeight()).setDuration(300).setInterpolator(new b()).start();
                        uVar.n.setVisibility(4);
                        if (uVar.p != null) {
                            uVar.p.setVisibility(4);
                        }
                        jVar.h();
                    }
                    as asVar = (as) vVar.a.getAdapter();
                    ax axVar = null;
                    int i2 = 0;
                    while (i2 < asVar.a.size()) {
                        axVar = (ax) asVar.a.get(i2);
                        if (axVar.b == 1 || i2 == asVar.g - 1) {
                            break;
                        }
                        i2++;
                    }
                    int i3 = 0;
                    int i4 = 0;
                    i2 = 0;
                    while (i2 < vVar.a.getChildCount()) {
                        int i5;
                        View childAt = vVar.a.getChildAt(i2);
                        if (childAt == jVar) {
                            i5 = i2 + 1;
                            i3 = i4;
                        } else if ((childAt instanceof j) && ((j) childAt).getWidgetInfo() == r2) {
                            i5 = i3;
                            i3 = i2;
                        } else {
                            i5 = i3;
                            i3 = i4;
                        }
                        i2++;
                        i4 = i3;
                        i3 = i5;
                    }
                    if (i3 > i4) {
                        vVar.a.postDelayed(acVar, 100);
                    } else {
                        int i6 = i3;
                        long j = 100;
                        while (i6 <= i4) {
                            vVar.a(vVar.a.getChildAt(i6), vVar.a.getChildAt(i6 - 1), j, i6 == i4 ? acVar : null);
                            j += 20;
                            i6++;
                        }
                    }
                }
            }
            String str = widgetInfo.d;
            Map hashMap = new HashMap();
            hashMap.put("url", str);
            m.a("navigation", "del_widget", (HashMap) hashMap);
            m.b("navigation_ut", "del_widget", (HashMap) hashMap);
            m.a(o.t, hashMap);
            return true;
        }
    }

    public final boolean c(aq aqVar) {
        if (!aqVar.a.b()) {
            d(aqVar);
        }
        return true;
    }

    public final void d(aq aqVar) {
        aqVar.setCurrentState(e.a);
        aqVar.j();
    }
}
