package com.uc.apollo.media;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public interface MediaPlayerController {

    /* compiled from: ProGuard */
    public final class a implements MediaPlayerController {
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
        private Method u;

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
                this.b = ReflectUtil.getMethod2(cls, "prepareAsync", new Class[0]);
                this.c = ReflectUtil.getMethod2(cls, "start", new Class[0]);
                this.d = ReflectUtil.getMethod2(cls, "pause", new Class[0]);
                this.e = ReflectUtil.getMethod2(cls, "isPlaying", new Class[0]);
                this.f = ReflectUtil.getMethod2(cls, "isFullScreen", new Class[0]);
                this.g = ReflectUtil.getMethod2(cls, "seekTo", Integer.TYPE);
                this.h = ReflectUtil.getMethod2(cls, "enterFullScreen", Boolean.TYPE);
                this.i = ReflectUtil.getMethod2(cls, "getCurrentVideoFrame", Rect.class, Integer.TYPE);
                this.j = ReflectUtil.getMethod2(cls, "getDuration", new Class[0]);
                this.k = ReflectUtil.getMethod2(cls, "getCurrentPosition", new Class[0]);
                this.l = ReflectUtil.getMethod2(cls, "getVideoWidth", new Class[0]);
                this.m = ReflectUtil.getMethod2(cls, "getVideoHeight", new Class[0]);
                this.n = ReflectUtil.getMethod2(cls, "stop", new Class[0]);
                this.o = ReflectUtil.getMethod2(cls, "destroy", new Class[0]);
                this.p = ReflectUtil.getMethod2(cls, "setVideoURI", Uri.class, Map.class);
                this.q = ReflectUtil.getMethod2(cls, "setTitleAndPageURI", String.class, String.class);
                this.r = ReflectUtil.getMethod2(cls, "enterLittleWin", new Class[0]);
                this.s = ReflectUtil.getMethod2(cls, "enterLittleWin", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                this.t = ReflectUtil.getMethod2(cls, "execCommand", Integer.TYPE, Integer.TYPE, Integer.TYPE, Object.class);
                this.u = ReflectUtil.getMethod(cls, "setSibling", Object.class);
                return true;
            } catch (NoSuchMethodException e) {
                return false;
            }
        }

        public static void a(Object obj, MediaPlayerController mediaPlayerController) {
            ReflectUtil.call(Void.TYPE, obj, "setSibling", new Class[]{Object.class}, new Object[]{mediaPlayerController});
        }

        public final Object getSibling() {
            return this.a;
        }

        public final void setSibling(Object obj) {
        }

        public final void setVideoURI(Uri uri, Map<String, String> map) {
            ReflectUtil.call(Void.TYPE, this.a, this.p, uri, map);
        }

        public final void setTitleAndPageURI(String str, String str2) {
            ReflectUtil.call(Void.TYPE, this.a, this.q, str, str2);
        }

        public final void prepareAsync() {
            ReflectUtil.call(Void.TYPE, this.a, this.b, new Object[0]);
        }

        public final void start() {
            ReflectUtil.call(Void.TYPE, this.a, this.c, new Object[0]);
        }

        public final void pause() {
            ReflectUtil.call(Void.TYPE, this.a, this.d, new Object[0]);
        }

        public final void stop() {
            ReflectUtil.call(Void.TYPE, this.a, this.n, new Object[0]);
        }

        public final void seekTo(int i) {
            ReflectUtil.call(Void.TYPE, this.a, this.g, Integer.valueOf(i));
        }

        public final void enterFullScreen(boolean z) {
            ReflectUtil.call(Void.TYPE, this.a, this.h, Boolean.valueOf(z));
        }

        public final void enterLittleWin() {
            ReflectUtil.call(Void.TYPE, this.a, this.r, new Object[0]);
        }

        public final void enterLittleWin(int i, int i2, int i3, int i4) {
            ReflectUtil.call(Void.TYPE, this.a, this.s, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0));
        }

        public final void enterLittleWin(int i, int i2, int i3, int i4, int i5) {
            ReflectUtil.call(Void.TYPE, this.a, this.s, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }

        public final void exitLittleWin(int i) {
        }

        public final void destroy() {
            ReflectUtil.call(Void.TYPE, this.a, this.o, new Object[0]);
        }

        public final boolean isPlaying() {
            return ((Boolean) ReflectUtil.call(Boolean.TYPE, this.a, this.e, new Object[0])).booleanValue();
        }

        public final boolean isFullScreen() {
            return ((Boolean) ReflectUtil.call(Boolean.TYPE, this.a, this.f, new Object[0])).booleanValue();
        }

        public final int getDuration() {
            return ((Integer) ReflectUtil.call(Integer.TYPE, this.a, this.j, new Object[0])).intValue();
        }

        public final int getCurrentPosition() {
            return ((Integer) ReflectUtil.call(Integer.TYPE, this.a, this.k, new Object[0])).intValue();
        }

        public final int getVideoWidth() {
            return ((Integer) ReflectUtil.call(Integer.TYPE, this.a, this.l, new Object[0])).intValue();
        }

        public final int getVideoHeight() {
            return ((Integer) ReflectUtil.call(Integer.TYPE, this.a, this.m, new Object[0])).intValue();
        }

        public final void getCurrentVideoFrame(Rect rect, int i) {
            ReflectUtil.call(Integer.TYPE, this.a, this.i, rect, Integer.valueOf(i));
        }

        public final Bitmap getCurrentVideoFrame() {
            return (Bitmap) ReflectUtil.call(Bitmap.class, this.a, this.i, new Object[0]);
        }

        public final boolean execCommand(int i, int i2, int i3, Object obj) {
            return ((Boolean) ReflectUtil.call(Boolean.TYPE, this.a, this.t, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj)).booleanValue();
        }
    }

    void destroy();

    void enterFullScreen(boolean z);

    void enterLittleWin();

    void enterLittleWin(int i, int i2, int i3, int i4);

    void enterLittleWin(int i, int i2, int i3, int i4, int i5);

    boolean execCommand(int i, int i2, int i3, Object obj);

    void exitLittleWin(int i);

    int getCurrentPosition();

    Bitmap getCurrentVideoFrame();

    void getCurrentVideoFrame(Rect rect, int i);

    int getDuration();

    Object getSibling();

    int getVideoHeight();

    int getVideoWidth();

    boolean isFullScreen();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void seekTo(int i);

    void setSibling(Object obj);

    void setTitleAndPageURI(String str, String str2);

    void setVideoURI(Uri uri, Map<String, String> map);

    void start();

    void stop();
}
