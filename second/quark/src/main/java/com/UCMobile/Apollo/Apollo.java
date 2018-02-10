package com.UCMobile.Apollo;

import android.content.Context;
import android.text.TextUtils;
import com.UCMobile.Apollo.util.CPU;
import com.UCMobile.Apollo.util.a;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import io.vov.vitamio.Vitamio;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
public class Apollo {
    public static final String DOWNLOADED_LIB = "u3player.so";
    public static String TAG = "APOLLO";
    private static final String[] a = new String[]{"libvvo.7.so", "libvvo.8.so", "libffmpeg.so", "libOMX.9.so", "libOMX.11.so", "libOMX.14.so", "libOMX.18.so"};
    private static final String[] b = new String[]{"libffmpeg.so", "libOMX.9.so", "libOMX.14.so", "libOMX.18.so"};
    private static final String[] c = new String[]{"libffmpeg.so", "libOMX.14.so"};
    private static final String[] d = new String[]{"libvplayer.so"};
    private static final String[] e = new String[]{"libvscanner.so"};
    private static final String[] f = new String[]{"libvao.0.so", "libvvo.0.so", "libvvo.9.so", "libvvo.j.so"};
    private static final int g;
    private static boolean h = false;
    private static String i = "";
    private static String j;

    static {
        int feature = CPU.getFeature();
        if ((feature & 32) > 0) {
            g = 71;
        } else if ((feature & 16) > 0 && (feature & 8) > 0) {
            g = 70;
        } else if ((feature & 4) > 0 && (feature & 2) > 0) {
            g = 61;
        } else if ((feature & 2) > 0) {
            g = 60;
        } else if ((feature & 64) > 0) {
            g = 50;
        } else if ((feature & 128) > 0) {
            g = 40;
        } else {
            g = -1;
        }
    }

    public static boolean initialize(Context context) {
        if (isInitialized(context)) {
            return true;
        }
        context.getResources().getIdentifier("libarm", ShareConstants.DEXMODE_RAW, context.getPackageName());
        return false;
    }

    public static boolean initialize(Context context, int i) {
        return isInitialized(context);
    }

    public static boolean loadUCInflator() {
        String str = Global.gApolloSoPath + "libucinflator.so";
        if (new File(str).exists() && !Global.gLoadFromAppLibPath) {
            try {
                if (!h) {
                    System.load(str);
                    h = true;
                }
            } catch (UnsatisfiedLinkError e) {
                new StringBuilder("System.load() failed: ").append(e.getMessage());
                new StringBuilder("System.load() failed: ").append(e.getCause());
            }
        }
        try {
            if (!h) {
                System.loadLibrary("ucinflator");
                h = true;
            }
            return false;
        } catch (Throwable th) {
            return true;
        }
    }

    public static boolean isInitialized(Context context) {
        if (loadUCInflator()) {
            return true;
        }
        j = context.getPackageName();
        File file = new File(getLibraryPath());
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                Arrays.sort(list);
                List<String> arrayList = new ArrayList();
                arrayList.add("libffmpeg.so");
                arrayList.add("libu3player.so");
                arrayList.add(".lock");
                for (String binarySearch : arrayList) {
                    if (Arrays.binarySearch(list, binarySearch) < 0) {
                        return false;
                    }
                }
                return compareVersion(Global.APOLLO_SERIES, getVersion());
            }
            MediaPlayer.initWithContext(context);
        }
        new StringBuilder().append(getLibraryPath()).append(" directory not exists");
        return false;
    }

    public static boolean isInitSoLoaded() {
        return h;
    }

    public static boolean isPlaySoInMemory() {
        return MediaPlayer.isInitSuccess();
    }

    public static String getVitamioPackage() {
        return j;
    }

    public static int getApolloType() {
        return g;
    }

    public static final String getLibraryPath() {
        if (Global.gLoadFromAppLibPath) {
            return i;
        }
        return Global.gApolloSoPath;
    }

    public static boolean isLoadLibraryFromAppLibPath() {
        return Global.gLoadFromAppLibPath;
    }

    public static void setLoadLibraryFromAppLibPath(boolean z) {
        Global.gLoadFromAppLibPath = z;
    }

    public static boolean extractLibs(String str, String str2, String str3) {
        return Vitamio.a(str, str2, str3);
    }

    public static String getVersion() {
        String str = getLibraryPath() + ".lock";
        if (Global.gLoadFromAppLibPath) {
            str = getLibraryPath() + "libversion.so";
        }
        File file = new File(str);
        if (file.exists()) {
            return a.a(file);
        }
        return null;
    }

    public static String getChildVer() {
        String str = getLibraryPath() + "childVer";
        if (Global.gLoadFromAppLibPath) {
            str = getLibraryPath() + "libchildVer.so";
        }
        File file = new File(str);
        if (file.exists()) {
            return a.a(file);
        }
        return null;
    }

    public static String getBuildSeq() {
        String str = getLibraryPath() + "buildSeq";
        if (Global.gLoadFromAppLibPath) {
            str = getLibraryPath() + "libbuildSeq.so";
        }
        File file = new File(str);
        if (file.exists()) {
            return a.a(file);
        }
        return null;
    }

    public static boolean compareVersion(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            new StringBuilder("error in series[").append(str).append("] version[").append(str2).append("]");
            return false;
        }
        String substring = str2.substring(0, 1);
        if (str.equals(substring)) {
            return true;
        }
        new StringBuilder("series not matech: [").append(substring).append("]");
        return false;
    }

    public static void updateAppLibPath(Context context) {
        if (i.length() == 0) {
            i = context.getApplicationInfo().dataDir + "/lib/";
        }
        if (Global.gLoadFromAppLibPath) {
            Global.gApolloSoPath = i;
        }
    }
}
