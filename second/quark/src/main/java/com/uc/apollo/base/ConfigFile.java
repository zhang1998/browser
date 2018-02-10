package com.uc.apollo.base;

import com.uc.apollo.android.SystemProperties;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.d;

@KeepForRuntime
/* compiled from: ProGuard */
public class ConfigFile {
    protected static final String ID_MEDIA_PLAYER_TYPE = "debug.uc.apollo.media.mt";
    protected static final String ID_MEDIA_RESET_MEDIA_PLAYER_IF_CHANGED_SURFACE = "debug.uc.apollo.media.rm";
    protected static final String ID_MEDIA_SERVICE_DISABLE = "debug.uc.apollo.media.svc";
    protected static final String ID_MEDIA_SHELL_CONTROLLER_DISABLE = "debug.uc.apollo.media.sc";
    protected static final String ID_MEDIA_SURFACE_TYPE = "debug.uc.apollo.media.st";
    protected static final String ID_MEDIA_VR_TYPE = "debug.uc.apollo.media.vr";
    private static int sDefaultMediaPlayerType = 5;
    private static int sDefaultVRType = 0;

    /* compiled from: ProGuard */
    public interface a {
    }

    public static void setDefaultMediaPlayer(int i) {
        int a = d.a(i);
        if (a != 1 && a != 4) {
            sDefaultMediaPlayerType = a;
        }
    }

    public static void disableApolloMediaPlayer() {
        setDefaultMediaPlayer(2);
    }

    public static void enableApolloMediaPlayer() {
        setDefaultMediaPlayer(5);
    }

    public static int getVRType() {
        int i = SystemProperties.get(ID_MEDIA_VR_TYPE, 0);
        if (i < 0 || i >= 3) {
            return 0;
        }
        return i;
    }

    public static int getSurfaceType() {
        return SystemProperties.get(ID_MEDIA_SURFACE_TYPE, 0);
    }

    public static boolean shellMediaPlayerControlDisable() {
        return SystemProperties.get(ID_MEDIA_SHELL_CONTROLLER_DISABLE, 0) == 1;
    }

    public static int getMediaPlayerType() {
        int a = d.a(SystemProperties.get(ID_MEDIA_PLAYER_TYPE, 1));
        if (a == 1) {
            return sDefaultMediaPlayerType;
        }
        return a;
    }

    public static boolean mediaPlayerServiceEnable() {
        return SystemProperties.get(ID_MEDIA_SERVICE_DISABLE, 0) != 1;
    }

    public static boolean resetMediaPlayerIfChangeSurface() {
        return SystemProperties.get(ID_MEDIA_RESET_MEDIA_PLAYER_IF_CHANGED_SURFACE, 0) == 1;
    }

    public static void reset(a aVar) {
    }
}
