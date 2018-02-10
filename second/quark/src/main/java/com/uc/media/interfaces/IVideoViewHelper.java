package com.uc.media.interfaces;

import android.content.Context;
import android.util.Log;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.internal.setup.UCSetupTask;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Reflection
/* compiled from: ProGuard */
public interface IVideoViewHelper {

    @Reflection
    /* compiled from: ProGuard */
    public class MediaView {
        private static final String TAG = "VideoView.Media";
        private static Constructor<?> constructor;
        private static Constructor<?> constructor2;

        static {
            String str;
            Class cls = null;
            String str2 = "";
            try {
                cls = UCSetupTask.classForName("com.uc.media.VideoViewAdapter");
            } catch (Exception e) {
                str2 = str2 + e.getMessage();
            }
            if (cls == null) {
                try {
                    cls = UCSetupTask.classForName("com.uc.media.MediaView");
                } catch (Exception e2) {
                    str2 = str2 + e2.getMessage();
                }
            }
            if (cls != null) {
                Constructor declaredConstructor;
                try {
                    declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, VideoViewParams.class});
                    constructor2 = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                } catch (Exception e22) {
                    str2 = str2 + e22.getMessage();
                }
                try {
                    declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class});
                    constructor = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    str = str2;
                } catch (Exception e222) {
                    str = str2 + e222.getMessage();
                }
            } else {
                str = str2;
            }
            if (cls == null || constructor == null || constructor2 == null) {
                Log.e(TAG, "init failure: " + str);
            }
        }

        public static IVideoView create(Context context) {
            return create(context, null);
        }

        public static IVideoView create(Context context, VideoViewParams videoViewParams) {
            Object obj = null;
            try {
                if (constructor2 != null) {
                    obj = constructor2.newInstance(new Object[]{context, videoViewParams});
                } else {
                    obj = constructor.newInstance(new Object[]{context});
                }
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    new StringBuilder("InvocationTargetException: ").append(cause.getMessage());
                }
            } catch (Exception e2) {
            }
            return (IVideoView) obj;
        }
    }
}
