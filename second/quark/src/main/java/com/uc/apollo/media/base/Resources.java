package com.uc.apollo.media.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.c.a;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

@KeepForRuntime
/* compiled from: ProGuard */
public class Resources {
    public static Drawable BACKWARD;
    public static Drawable CLOSE;
    public static Drawable FORWARD;
    public static Drawable LOADING;
    public static Drawable MAXIMIZE;
    public static Drawable PAUSE;
    public static Drawable PLAY;
    public static Drawable RESIZE;

    static {
        Method method = ReflectUtil.getMethod(Settings.getMediaPlayerServiceClassName(), "getDrawable", String.class);
        if (method != null) {
            CLOSE = (Drawable) ReflectUtil.call(Drawable.class, method, "CLOSE");
            MAXIMIZE = (Drawable) ReflectUtil.call(Drawable.class, method, "MAXIMIZE");
            RESIZE = (Drawable) ReflectUtil.call(Drawable.class, method, "RESIZE");
            PLAY = (Drawable) ReflectUtil.call(Drawable.class, method, "PLAY");
            PAUSE = (Drawable) ReflectUtil.call(Drawable.class, method, "PAUSE");
            BACKWARD = (Drawable) ReflectUtil.call(Drawable.class, method, "BACKWARD");
            FORWARD = (Drawable) ReflectUtil.call(Drawable.class, method, "FORWARD");
            LOADING = (Drawable) ReflectUtil.call(Drawable.class, method, "LOADING");
        }
        android.content.res.Resources resources = Settings.getContext().getResources();
        if (CLOSE == null) {
            CLOSE = new BitmapDrawable(resources, createBitmap(a.a));
        }
        if (MAXIMIZE == null) {
            MAXIMIZE = new BitmapDrawable(resources, createBitmap(a.b));
        }
        if (RESIZE == null) {
            RESIZE = new BitmapDrawable(resources, createBitmap(a.c));
        }
        if (PLAY == null) {
            PLAY = new BitmapDrawable(resources, createBitmap(a.d));
        }
        if (PAUSE == null) {
            PAUSE = new BitmapDrawable(resources, createBitmap(a.e));
        }
        if (BACKWARD == null) {
            BACKWARD = new BitmapDrawable(resources, createBitmap(a.f));
        }
        if (FORWARD == null) {
            FORWARD = new BitmapDrawable(resources, createBitmap(a.g));
        }
        if (LOADING == null) {
            LOADING = new BitmapDrawable(resources, createBitmap(a.h));
        }
    }

    private static Bitmap createBitmap(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}
