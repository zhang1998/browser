package com.uc.media.interfaces;

import android.content.Context;
import com.uc.webview.export.internal.setup.UCSetupTask;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@com.uc.webview.export.annotations.Reflection
/* compiled from: ProGuard */
public interface IApolloHelper {

    @com.uc.webview.export.annotations.Reflection
    /* compiled from: ProGuard */
    public class Apollo {

        /* compiled from: ProGuard */
        class Lazy {
            static Class<?> CLASS;
            static Field DOWNLOADED_LIB;
            static Method compareVersion;
            static Method extractLibs;
            static Method getChildVer;
            static Method getVersion;
            static Method isInitSoLoaded;
            static Method isInitialized;

            Lazy() {
            }

            static {
                try {
                    Class cls = Class.forName("com.UCMobile.Apollo.Apollo");
                    CLASS = cls;
                    isInitialized = cls.getMethod("isInitialized", new Class[]{Context.class});
                    isInitSoLoaded = CLASS.getMethod("isInitSoLoaded", new Class[0]);
                    DOWNLOADED_LIB = CLASS.getDeclaredField("DOWNLOADED_LIB");
                    extractLibs = CLASS.getMethod("extractLibs", new Class[]{String.class, String.class, String.class});
                    getVersion = CLASS.getMethod("getVersion", new Class[0]);
                    getChildVer = CLASS.getMethod("getChildVer", new Class[0]);
                    compareVersion = CLASS.getMethod("compareVersion", new Class[]{String.class, String.class});
                } catch (Exception e) {
                }
            }
        }

        public static boolean isInitialized(Context context) {
            try {
                return ((Boolean) Lazy.isInitialized.invoke(null, new Object[]{context})).booleanValue();
            } catch (IllegalArgumentException e) {
                return false;
            } catch (IllegalAccessException e2) {
                return false;
            } catch (InvocationTargetException e3) {
                return false;
            }
        }

        public static boolean isInitSoLoaded() {
            try {
                return ((Boolean) Lazy.isInitSoLoaded.invoke(null, new Object[0])).booleanValue();
            } catch (IllegalArgumentException e) {
                return false;
            } catch (IllegalAccessException e2) {
                return false;
            } catch (InvocationTargetException e3) {
                return false;
            }
        }

        public static String Get_DOWNLOADED_LIB() {
            try {
                return (String) Lazy.DOWNLOADED_LIB.get(null);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            }
            return "";
        }

        public static boolean extractLibs(String str, String str2, String str3) {
            try {
                return ((Boolean) Lazy.extractLibs.invoke(null, new Object[]{str, str2, str3})).booleanValue();
            } catch (IllegalArgumentException e) {
                return false;
            } catch (IllegalAccessException e2) {
                return false;
            } catch (InvocationTargetException e3) {
                return false;
            }
        }

        public static String getVersion() {
            try {
                return (String) Lazy.getVersion.invoke(null, new Object[0]);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
            return "";
        }

        public static String getChildVer() {
            try {
                return (String) Lazy.getChildVer.invoke(null, new Object[0]);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
            return "";
        }

        public static boolean compareVersion(String str, String str2) {
            try {
                return ((Boolean) Lazy.compareVersion.invoke(null, new Object[]{str, str2})).booleanValue();
            } catch (IllegalArgumentException e) {
                return false;
            } catch (IllegalAccessException e2) {
                return false;
            } catch (InvocationTargetException e3) {
                return false;
            }
        }
    }

    @com.uc.webview.export.annotations.Reflection
    /* compiled from: ProGuard */
    public class CPU {

        /* compiled from: ProGuard */
        class Lazy {
            static Class<?> CLASS;
            static Method getFeature;

            Lazy() {
            }

            static {
                try {
                    Class cls = Class.forName("com.UCMobile.Apollo.util.CPU");
                    CLASS = cls;
                    getFeature = cls.getMethod("getFeature", new Class[0]);
                } catch (Exception e) {
                }
            }
        }

        public static int getFeature() {
            try {
                return ((Integer) Lazy.getFeature.invoke(null, new Object[0])).intValue();
            } catch (IllegalArgumentException e) {
                return 0;
            } catch (IllegalAccessException e2) {
                return 0;
            } catch (InvocationTargetException e3) {
                return 0;
            }
        }

        public static int getInt(String str) {
            try {
                return Lazy.CLASS.getDeclaredField(str).getInt(null);
            } catch (SecurityException e) {
                return 0;
            } catch (NoSuchFieldException e2) {
                return 0;
            } catch (IllegalArgumentException e3) {
                return 0;
            } catch (IllegalAccessException e4) {
                return 0;
            }
        }
    }

    @com.uc.webview.export.annotations.Reflection
    /* compiled from: ProGuard */
    public class ContextUtils {

        /* compiled from: ProGuard */
        class Lazy {
            static Class<?> CLASS;
            static Method fixLastSlash;
            static Method getDataDir;

            Lazy() {
            }

            static {
                try {
                    Class cls = Class.forName("com.UCMobile.Apollo.util.ContextUtils");
                    CLASS = cls;
                    getDataDir = cls.getMethod("getDataDir", new Class[]{Context.class});
                    fixLastSlash = CLASS.getMethod("fixLastSlash", new Class[]{String.class});
                } catch (Exception e) {
                }
            }
        }

        public static String getDataDir(Context context) {
            try {
                return (String) Lazy.getDataDir.invoke(null, new Object[]{context});
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
            return "";
        }

        public static String fixLastSlash(Context context) {
            try {
                return (String) Lazy.fixLastSlash.invoke(null, new Object[]{context});
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
            return "";
        }
    }

    @com.uc.webview.export.annotations.Reflection
    /* compiled from: ProGuard */
    public class Global {

        /* compiled from: ProGuard */
        class Lazy {
            static Class<?> CLASS;
            static Field getApolloSeries;
            static Field getLibsPath;
            static Field setApolloSoPath;

            Lazy() {
            }

            static {
                try {
                    Class cls = Class.forName("com.UCMobile.Apollo.Global");
                    CLASS = cls;
                    setApolloSoPath = cls.getDeclaredField("gApolloSoPath");
                    getApolloSeries = CLASS.getDeclaredField("APOLLO_SERIES");
                    getLibsPath = CLASS.getDeclaredField("LIBS_PATHS");
                } catch (Exception e) {
                }
            }
        }

        public static void setApolloSoPath(String str) {
            try {
                Lazy.setApolloSoPath.set(null, str);
                saveApolloSoPathForSDK(str);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            }
        }

        private static void saveApolloSoPathForSDK(String str) {
            try {
                UCSetupTask.classForName("com.uc.webkit.sdk.utils.ApolloUtil").getMethod("saveApolloSoPath", new Class[]{String.class}).invoke(null, new Object[]{str});
            } catch (Exception e) {
            }
        }

        public static String getApolloSeries() {
            try {
                return (String) Lazy.getApolloSeries.get(null);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            }
            return "";
        }

        public static String getLibsPath(int i) {
            try {
                return ((Object[]) Lazy.getLibsPath.get(null))[i].toString();
            } catch (IllegalArgumentException e) {
                return "";
            } catch (IllegalAccessException e2) {
                return "";
            }
        }

        public static int getLibsPathLength() {
            try {
                return ((Object[]) Lazy.getLibsPath.get(null)).length;
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            }
            return 0;
        }
    }

    @com.uc.webview.export.annotations.Reflection
    /* compiled from: ProGuard */
    public class Reflection {

        /* compiled from: ProGuard */
        class Lazy {
            static Class<?> CLASS;
            static Method getApiVersion;

            Lazy() {
            }

            static {
                try {
                    Class cls = Class.forName("com.UCMobile.Apollo.VideoView");
                    CLASS = cls;
                    getApiVersion = cls.getMethod("getApiVersion", new Class[0]);
                } catch (Exception e) {
                }
            }
        }

        public static int getApiVersion() {
            try {
                return ((Integer) Lazy.getApiVersion.invoke(null, new Object[0])).intValue();
            } catch (IllegalArgumentException e) {
                return 0;
            } catch (IllegalAccessException e2) {
                return 0;
            } catch (InvocationTargetException e3) {
                return 0;
            }
        }
    }
}
