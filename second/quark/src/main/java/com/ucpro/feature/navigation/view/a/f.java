package com.ucpro.feature.navigation.view.a;

import android.graphics.Point;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.ucpro.feature.navigation.view.aq;
import com.ucpro.feature.navigation.view.j;

/* compiled from: ProGuard */
public abstract class f {
    private static int a = 0;
    public boolean b = false;
    protected Point c = new Point();

    public boolean a(aq aqVar, KeyEvent keyEvent) {
        return false;
    }

    public boolean c(aq aqVar) {
        return false;
    }

    public boolean a(aq aqVar, MotionEvent motionEvent) {
        return false;
    }

    public void a(aq aqVar) {
        this.b = false;
        new StringBuilder("onStateExited : ").append(this);
    }

    public void b(aq aqVar) {
        this.b = true;
        new StringBuilder("onStateEntered : ").append(this);
    }

    public boolean a(aq aqVar, j jVar, int i, Object obj) {
        return false;
    }

    public void d(aq aqVar) {
    }

    public static boolean b(aq aqVar, MotionEvent motionEvent) {
        return aqVar.a.b() && motionEvent.getAction() == 0;
    }
}
