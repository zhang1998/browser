package com.uc.apollo.media;

import com.uc.apollo.annotation.KeepForSdk;
import java.lang.reflect.Method;

@KeepForSdk
/* compiled from: ProGuard */
public class CodecLibUpgrader {
    private static String sApolloSoPath;
    private static boolean sApolloUpgradeDynamic = true;
    private static Upgrader sUpgrader;

    @KeepForSdk
    /* compiled from: ProGuard */
    public interface Upgrader {
        void upgrade();
    }

    /* compiled from: ProGuard */
    final class a implements Upgrader {
        private static Method a;

        private a() {
        }

        static {
            try {
                Method method = Class.forName("com.uc.browser.media.mediaplayer.CodecLibUpgrader").getMethod("upgrade", new Class[0]);
                method.setAccessible(true);
                a = method;
            } catch (Exception e) {
            }
        }

        public final void upgrade() {
            if (a != null) {
                try {
                    a.invoke(null, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

    public static boolean getApolloUpgradeDynamic() {
        return sApolloUpgradeDynamic;
    }

    public static void setApolloUpgradeDynamic(boolean z) {
        sApolloUpgradeDynamic = z;
    }

    public static void setApolloSoPath(String str) {
        sApolloSoPath = str;
    }

    public static String getApolloSoPath() {
        return sApolloSoPath;
    }

    public static void setUpgrader(Upgrader upgrader) {
        sUpgrader = upgrader;
    }

    public static void upgrade() {
        if (sApolloUpgradeDynamic) {
            if (sUpgrader == null) {
                sUpgrader = new a();
            }
            sUpgrader.upgrade();
        }
    }
}
