package com.uc.apollo.media.widget;

import com.uc.apollo.media.widget.SurfaceListener.a;
import java.util.Vector;

/* compiled from: ProGuard */
public final class i extends Vector<SurfaceListener> {
    public final void a(Object obj) {
        if (obj instanceof SurfaceListener) {
            obj = (SurfaceListener) obj;
        } else {
            SurfaceListener a = a.a(obj);
            a.a(obj, a);
            SurfaceListener surfaceListener = a;
        }
        add(obj);
    }

    public final void b(Object obj) {
        if (obj instanceof SurfaceListener) {
            obj = (SurfaceListener) obj;
        } else {
            SurfaceListener b = a.b(obj);
            a.a(obj, null);
            SurfaceListener surfaceListener = b;
        }
        remove(obj);
    }
}
