package com.uc.apollo.media.base;

import com.uc.apollo.Settings;
import com.uc.apollo.base.ConfigFile;
import com.uc.apollo.util.b;

/* compiled from: ProGuard */
public final class e extends ConfigFile {

    /* compiled from: ProGuard */
    final class a {
        static final boolean a = b.a("/data/local/tmp/.apollo_sdk.disable_apollo_media_player");
    }

    public static int a() {
        int mediaPlayerType = ConfigFile.getMediaPlayerType();
        if (mediaPlayerType == 5 && a.a) {
            return 2;
        }
        return mediaPlayerType;
    }

    public static boolean b() {
        int surfaceType = ConfigFile.getSurfaceType();
        if (surfaceType == 0) {
            return Settings.getUseHWAccelerated();
        }
        return surfaceType == 2;
    }
}
