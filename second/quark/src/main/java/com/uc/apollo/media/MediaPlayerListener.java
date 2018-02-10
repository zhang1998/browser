package com.uc.apollo.media;

import android.net.Uri;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.ReflectUtil;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public interface MediaPlayerListener {

    /* compiled from: ProGuard */
    public final class a implements MediaPlayerListener {
        private Object a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;
        private Method f;
        private Method g;
        private Method h;
        private Method i;
        private Method j;
        private Method k;
        private Method l;
        private Method m;
        private Method n;
        private Method o;
        private Method p;
        private Method q;
        private Method r;
        private Method s;
        private Method t;

        public static a a(Object obj) {
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
                this.b = ReflectUtil.getMethod2(cls, "onEnterFullScreen", Boolean.TYPE);
                this.c = ReflectUtil.getMethod2(cls, "onRelease", new Class[0]);
                this.d = ReflectUtil.getMethod2(cls, "onStart", new Class[0]);
                this.e = ReflectUtil.getMethod2(cls, "onPause", new Class[0]);
                this.f = ReflectUtil.getMethod2(cls, "onSetDataSource", String.class, String.class, Uri.class, Map.class);
                this.g = ReflectUtil.getMethod2(cls, "onSetDataSource", FileDescriptor.class, Long.TYPE, Long.TYPE);
                this.h = ReflectUtil.getMethod2(cls, "onMessage", Integer.TYPE, Integer.TYPE, Object.class);
                this.i = ReflectUtil.getMethod2(cls, "onPrepared", Integer.TYPE, Integer.TYPE, Integer.TYPE);
                this.j = ReflectUtil.getMethod2(cls, "onCompletion", new Class[0]);
                this.k = ReflectUtil.getMethod2(cls, "onSeekComplete", new Class[0]);
                this.l = ReflectUtil.getMethod2(cls, "onError", Integer.TYPE, Integer.TYPE);
                this.m = ReflectUtil.getMethod2(cls, "onInfo", Integer.TYPE, Integer.TYPE);
                this.n = ReflectUtil.getMethod2(cls, "onVideoSizeChanged", Integer.TYPE, Integer.TYPE);
                this.o = ReflectUtil.getMethod2(cls, "onDurationChanged", Integer.TYPE);
                this.p = ReflectUtil.getMethod2(cls, "onPrepareBegin", new Class[0]);
                this.q = ReflectUtil.getMethod2(cls, "onStop", new Class[0]);
                this.r = ReflectUtil.getMethod2(cls, "onReset", new Class[0]);
                this.s = ReflectUtil.getMethod2(cls, "onSeekTo", Integer.TYPE);
                this.t = ReflectUtil.getMethod(cls, "setSibling", Object.class);
                return true;
            } catch (NoSuchMethodException e) {
                return false;
            }
        }

        public static void a(Object obj, MediaPlayerListener mediaPlayerListener) {
            ReflectUtil.call(Void.TYPE, obj, "setSibling", new Class[]{Object.class}, new Object[]{mediaPlayerListener});
        }

        public final Object getSibling() {
            return this.a;
        }

        public final void setSibling(Object obj) {
            this.a = obj;
        }

        public final void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map) {
            ReflectUtil.call(Void.TYPE, this.a, this.f, str, str2, uri, map);
        }

        public final void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2) {
            ReflectUtil.call(Void.TYPE, this.a, this.g, fileDescriptor, Long.valueOf(j), Long.valueOf(j2));
        }

        public final void onStart() {
            ReflectUtil.call(Void.TYPE, this.a, this.d, new Object[0]);
        }

        public final void onPause() {
            ReflectUtil.call(Void.TYPE, this.a, this.e, new Object[0]);
        }

        public final void onEnterFullScreen(boolean z) {
            ReflectUtil.call(Void.TYPE, this.a, this.b, Boolean.valueOf(z));
        }

        public final void onVideoSizeChanged(int i, int i2) {
            ReflectUtil.call(Void.TYPE, this.a, this.n, Integer.valueOf(i), Integer.valueOf(i2));
        }

        public final void onPrepared(int i, int i2, int i3) {
            ReflectUtil.call(Void.TYPE, this.a, this.i, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }

        public final void onDurationChanged(int i) {
            ReflectUtil.call(Void.TYPE, this.a, this.o, Integer.valueOf(i));
        }

        public final void onSeekComplete() {
            ReflectUtil.call(Void.TYPE, this.a, this.k, new Object[0]);
        }

        public final void onCompletion() {
            ReflectUtil.call(Void.TYPE, this.a, this.j, new Object[0]);
        }

        public final void onError(int i, int i2) {
            ReflectUtil.call(Void.TYPE, this.a, this.l, Integer.valueOf(i), Integer.valueOf(i2));
        }

        public final void onInfo(int i, int i2) {
            ReflectUtil.call(Void.TYPE, this.a, this.m, Integer.valueOf(i), Integer.valueOf(i2));
        }

        public final void onPrepareBegin() {
            ReflectUtil.call(Void.TYPE, this.a, this.p, new Object[0]);
        }

        public final void onStop() {
            ReflectUtil.call(Void.TYPE, this.a, this.q, new Object[0]);
        }

        public final void onRelease() {
            ReflectUtil.call(Void.TYPE, this.a, this.c, new Object[0]);
        }

        public final void onReset() {
            ReflectUtil.call(Void.TYPE, this.a, this.r, new Object[0]);
        }

        public final void onSeekTo(int i) {
            ReflectUtil.call(Void.TYPE, this.a, this.s, Integer.valueOf(i));
        }

        public final void onMessage(int i, int i2, Object obj) {
            ReflectUtil.call(Void.TYPE, this.a, this.h, Integer.valueOf(i), Integer.valueOf(i2), obj);
        }
    }

    Object getSibling();

    void onCompletion();

    void onDurationChanged(int i);

    void onEnterFullScreen(boolean z);

    void onError(int i, int i2);

    void onInfo(int i, int i2);

    void onMessage(int i, int i2, Object obj);

    void onPause();

    void onPrepareBegin();

    void onPrepared(int i, int i2, int i3);

    void onRelease();

    void onReset();

    void onSeekComplete();

    void onSeekTo(int i);

    void onSetDataSource(FileDescriptor fileDescriptor, long j, long j2);

    void onSetDataSource(String str, String str2, Uri uri, Map<String, String> map);

    void onStart();

    void onStop();

    void onVideoSizeChanged(int i, int i2);

    void setSibling(Object obj);
}
