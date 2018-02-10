package com.uc.apollo.media;

import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.base.SystemUtil;
import com.uc.apollo.util.f;

@KeepForRuntime
/* compiled from: ProGuard */
public class LittleWindowConfig {
    private static final int BTN_SIZE = f.c(24);
    private static final int LARGE_BTN_SIZE;
    private static LittleWindowToolbarFactory sLittleWindowToolbarFactory;
    private static int sMinLittleWindowHeight = (LARGE_BTN_SIZE + BTN_SIZE);
    private static int sMinLittleWindowWidth;

    public static void setLittleWindowToolbarFactory(LittleWindowToolbarFactory littleWindowToolbarFactory) {
        sLittleWindowToolbarFactory = littleWindowToolbarFactory;
    }

    public static boolean supportFullScreen() {
        return SystemUtil.supportOpenVideoInFullscreen();
    }

    public static void setMinLittleWindowWidth(int i) {
        sMinLittleWindowWidth = i;
    }

    public static void setMinLittleWindowHeight(int i) {
        sMinLittleWindowHeight = i;
    }

    public static LittleWindowToolbarFactory getLittleWindowToolbarFactory() {
        return sLittleWindowToolbarFactory;
    }

    public static int getMinLittleWindowWidth() {
        return sMinLittleWindowWidth;
    }

    public static int getMinLittleWindowHeight() {
        return sMinLittleWindowHeight;
    }

    static {
        int c = f.c(26);
        LARGE_BTN_SIZE = c;
        sMinLittleWindowWidth = c + BTN_SIZE;
    }
}
