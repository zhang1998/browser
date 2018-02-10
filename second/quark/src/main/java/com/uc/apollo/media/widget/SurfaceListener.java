package com.uc.apollo.media.widget;

import android.view.Surface;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

@KeepForRuntime
/* compiled from: ProGuard */
public interface SurfaceListener {

    /* compiled from: ProGuard */
    public final class a implements SurfaceListener {
        private Object a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;

        public static SurfaceListener a(Object obj) {
            if (obj == null) {
                return null;
            }
            a aVar = new a(obj);
            if (aVar.a()) {
                return aVar;
            }
            return null;
        }

        private a(Object obj) {
            this.a = obj;
        }

        private boolean a() {
            try {
                Class cls = this.a.getClass();
                this.b = ReflectUtil.getMethod2(cls, "surfaceCreated", Surface.class);
                this.c = ReflectUtil.getMethod2(cls, "surfaceDestroyed", Surface.class);
                this.d = ReflectUtil.getMethod2(cls, "surfaceChanged", Surface.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                this.e = ReflectUtil.getMethod(cls, "setSibling", Object.class);
                return true;
            } catch (NoSuchMethodException e) {
                return false;
            }
        }

        public static SurfaceListener b(Object obj) {
            return (SurfaceListener) ReflectUtil.call(SurfaceListener.class, obj, "getSibling", new Object[0]);
        }

        public static void a(Object obj, SurfaceListener surfaceListener) {
            ReflectUtil.call(Void.TYPE, obj, "setSibling", new Class[]{Object.class}, new Object[]{surfaceListener});
        }

        public final Object getSibling() {
            return this.a;
        }

        public final void setSibling(Object obj) {
            this.a = obj;
        }

        public final void surfaceCreated(Surface surface) {
            ReflectUtil.call(Void.TYPE, this.a, this.b, surface);
        }

        public final void surfaceDestroyed(Surface surface) {
            ReflectUtil.call(Void.TYPE, this.a, this.c, surface);
        }

        public final void surfaceChanged(Surface surface, int i, int i2, int i3) {
            ReflectUtil.call(Void.TYPE, this.a, this.d, surface, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    Object getSibling();

    void setSibling(Object obj);

    void surfaceChanged(Surface surface, int i, int i2, int i3);

    void surfaceCreated(Surface surface);

    void surfaceDestroyed(Surface surface);
}
