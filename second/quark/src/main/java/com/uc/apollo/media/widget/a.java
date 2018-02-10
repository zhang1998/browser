package com.uc.apollo.media.widget;

import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public interface a {

    /* compiled from: ProGuard */
    public final class a implements a {
        private Object a;
        private Method b;
        private Method c;

        public static a a(Object obj) {
            if (obj == null) {
                return null;
            }
            a aVar = new a(obj);
            if (aVar.b()) {
                return aVar;
            }
            return null;
        }

        private a(Object obj) {
            this.a = obj;
        }

        private boolean b() {
            try {
                Class cls = this.a.getClass();
                this.b = ReflectUtil.getMethod2(cls, "enterFullScreen", Integer.TYPE);
                this.c = ReflectUtil.getMethod2(cls, "exitFullScreen", new Class[0]);
                return true;
            } catch (NoSuchMethodException e) {
                return false;
            }
        }

        public final void a(int i) {
            ReflectUtil.call(Void.TYPE, this.a, this.b, Integer.valueOf(i));
        }

        public final void a() {
            ReflectUtil.call(Void.TYPE, this.a, this.c, new Object[0]);
        }
    }

    void a();

    void a(int i);
}
