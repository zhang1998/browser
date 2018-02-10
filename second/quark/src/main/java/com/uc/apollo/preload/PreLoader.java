package com.uc.apollo.preload;

import com.UCMobile.Apollo.Global;
import com.UCMobile.Apollo.MediaPreload;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.util.f;
import java.util.Map;

/* compiled from: ProGuard */
public class PreLoader {
    private static boolean a;
    private static boolean b;

    static {
        a = false;
        b = false;
        a = MediaPreload.supportPreloadBySo(Settings.getContext());
        b = Settings.mediaPlayerServiceEnable();
        setStatisticUploadListener(new h());
        String str = Global.EXT_KEY_APOLLO_STR;
        String stringValue = Settings.getStringValue(str);
        if (!f.a(stringValue)) {
            a(str, stringValue);
        }
    }

    @KeepForSdk
    public static void add(String str, String str2, Map<String, String> map, PreloadListener preloadListener) {
        if (!a) {
            return;
        }
        if (b) {
            i.a(str, str2, map, preloadListener);
        } else {
            MediaPreload.Add(str, str2, map, new d(preloadListener));
        }
    }

    @KeepForSdk
    public static void remove(String str) {
        if (!a) {
            return;
        }
        if (b) {
            i.a(str);
        } else {
            MediaPreload.Remove(str);
        }
    }

    public static void a(String str, String str2) {
        if (!a) {
            return;
        }
        if (b) {
            i.a(str, str2);
        } else {
            MediaPreload.SetOption(str, str2);
        }
    }

    @KeepForSdk
    public static void setPriority(String str, int i) {
        if (!a) {
            return;
        }
        if (b) {
            i.a(str, i);
        } else {
            MediaPreload.SetPriority(str, i);
        }
    }

    @KeepForSdk
    public static void setStatisticUploadListener(StatisticUploadListener statisticUploadListener) {
        if (!a) {
            return;
        }
        if (b) {
            i.a(statisticUploadListener);
        } else {
            MediaPreload.SetStatisticUploadListener(new f(statisticUploadListener));
        }
    }
}
