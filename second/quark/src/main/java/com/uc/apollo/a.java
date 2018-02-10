package com.uc.apollo;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.util.SparseArray;
import com.UCMobile.Apollo.Apollo;
import com.UCMobile.Apollo.Global;
import com.UCMobile.Apollo.MediaPlayer;
import com.uc.apollo.ProxyInfoGenerator.ProxyInfo;
import com.uc.apollo.Settings.Provider;
import com.uc.apollo.android.SystemAlertWindowPermission;
import com.uc.apollo.android.SystemPropertyMatcher;
import com.uc.apollo.base.Config;
import com.uc.apollo.base.ConfigFile;
import com.uc.apollo.impl.SettingsConst;
import com.uc.apollo.media.CodecLibUpgrader;
import com.uc.apollo.media.base.SystemUtil;
import com.uc.apollo.media.impl.B;
import com.uc.apollo.media.service.d;
import com.uc.apollo.media.service.h;
import com.uc.apollo.preload.PreLoader;
import com.uc.apollo.util.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a extends Config implements SettingsConst {
    private static String a = "ucmedia.Settings";
    private static boolean b = false;
    private static int c = 0;
    private static String d = null;
    private static boolean e = false;
    private static boolean f = false;
    private static com.uc.apollo.Settings.a g = new com.uc.apollo.Settings.a();
    private static String h = null;
    private static String i = null;
    private static boolean j = false;
    private static boolean k = true;
    private static boolean l = true;
    private static boolean m = true;
    private static boolean n = true;
    private static boolean o = false;
    private static boolean p = true;
    private static boolean q = true;
    private static boolean r = true;
    private static boolean s = true;
    private static boolean t = true;
    private static SparseArray<String> u = new SparseArray();
    private static HashMap<String, String> v = new HashMap();
    private static int w = -1;
    private static ProxyInfoGenerator x;
    private static Provider y;

    /* compiled from: ProGuard */
    final class a {
        static final boolean a = SystemUtil.findPermisionInAndroidManifest("android.permission.SYSTEM_ALERT_WINDOW");
    }

    static {
        a(1001, "as");
        SystemAlertWindowPermission.a(new b());
    }

    static void a(Context context) {
        a(context, false);
    }

    static void a(Context context, boolean z) {
        if (Config.getContext() != null) {
            Config.setContext(context);
            return;
        }
        f = z;
        Config.setContext(context);
        d = SystemUtil.getMediaPlayerServiceClassName(":MediaPlayerService");
        if (!z) {
            a();
        }
    }

    static void a() {
        if (!e) {
            e = true;
            if (!b) {
                try {
                    if (f.b(d) && Class.forName(d) != null) {
                        d.a();
                    }
                } catch (Throwable th) {
                    d = null;
                }
            }
        }
    }

    static void b() {
        if (e) {
            e = false;
            if (f.b(d)) {
                d.b();
            }
            if (r) {
                com.uc.apollo.media.base.a.a();
            }
        }
    }

    static boolean c() {
        return Config.getContext() != null;
    }

    static void a(int i) {
        c = i;
    }

    static int d() {
        return c;
    }

    static String e() {
        return d;
    }

    static boolean f() {
        return f;
    }

    static boolean g() {
        if (w == 1) {
            return true;
        }
        if (w == 0) {
            return false;
        }
        return a(d(SettingsConst.LITTLE_WINDOW_DISABLE_CD_KEY));
    }

    static boolean a(String str) {
        if (w == 1) {
            return true;
        }
        if (w == 0) {
            return false;
        }
        if (h() && a.a && l) {
            w = 1;
            if (f.b(str)) {
                w = SystemPropertyMatcher.findPropertiesMatchDevice(str.split("\\^\\^")) == null ? 1 : 0;
            }
        } else {
            w = 0;
        }
        if (w != 1) {
            return false;
        }
        return true;
    }

    static boolean h() {
        if (!f.a(d) && ConfigFile.mediaPlayerServiceEnable() && m) {
            return true;
        }
        return false;
    }

    static void a(String str, String str2, String str3) {
        g.a = str;
        g.b = str2;
        g.c = str3;
    }

    static com.uc.apollo.Settings.a i() {
        return g;
    }

    static void j() {
        a = "[MPSvc]ucmedia.Settings";
        b = true;
    }

    static boolean k() {
        return b;
    }

    static void b(String str) {
        CodecLibUpgrader.setApolloSoPath(str);
    }

    static boolean a(int i, String str) {
        if (str == null) {
            return false;
        }
        switch (i) {
            case 1001:
            case 1002:
            case 1003:
            case 1007:
            case 1008:
            case 1009:
            case 1011:
            case 2001:
            case 2002:
                u.put(i, str);
                return true;
            case SettingsConst.GLOBAL_SETTINGS /*2000*/:
                return true;
            case SettingsConst.HARDWARE_ACCELERATE /*3001*/:
                k = h(str);
                return true;
            case SettingsConst.USE_DEFAULT_CONTROLLER /*3002*/:
                j = h(str);
                return true;
            case SettingsConst.RESTORE_HISTORY_PLAY_POSITION /*3003*/:
                B.a(h(str));
                return true;
            case SettingsConst.ENABLE_FULL_SCREEN /*3004*/:
                n = h(str);
                return true;
            case SettingsConst.ENABLE_LITTLE_WIN /*3005*/:
                l = h(str);
                return true;
            case SettingsConst.ENABLE_MEDIA_SERVICE /*3006*/:
                m = h(str);
                return true;
            case SettingsConst.PRELOAD_CD_PARAMS /*3007*/:
                if (!f.a(str)) {
                    PreLoader.a(Global.EXT_KEY_APOLLO_STR, str);
                }
                return true;
            case SettingsConst.PAUSE_PLAY_AFTER_EXIT_FULLSCREEN /*3008*/:
                o = h(str);
                return true;
            case SettingsConst.SHOW_DEFAULT_CONTROLLER_GESTURE_GUIDE /*3009*/:
                p = h(str);
                return true;
            case SettingsConst.SHOW_DEFAULT_CONTROLLER_MOBILE_NETWORK_PLAY_TOAST /*3010*/:
                q = h(str);
                return true;
            case SettingsConst.USE_DEFAULT_AUDIO_FOCUS_CHANGE_LISTENER /*3011*/:
                Settings.setShouldUseDefaultAudioFocusChangeListener(h(str));
                return true;
            case SettingsConst.PAUSE_PLAY_WHEN_AUDIOFOCUS_LOSS_TRANSIENT /*3012*/:
                Settings.setShouldPausePlayWhenAudioFocusLossTransient(h(str));
                return true;
            case SettingsConst.CONTINUE_PLAY_WHEN_AUDIOFOCUS_GAIN_AFTER_LOSS_TRANSIENT /*3013*/:
                Settings.setShouldContinuePlayWhenAudioFocusGainAfterLossTransient(h(str));
                return true;
            default:
                return false;
        }
    }

    static SparseArray<String> l() {
        return u;
    }

    static boolean m() {
        return j;
    }

    static void c(String str) {
        if (str != null && str.length() > 0) {
            h = str;
        }
    }

    static String n() {
        if (h != null && h.length() > 0) {
            return h;
        }
        String version = Apollo.getVersion();
        h = version;
        return version;
    }

    static String o() {
        if (i != null && i.length() > 0) {
            return i;
        }
        if (com.uc.apollo.media.impl.a.c()) {
            i = MediaPlayer.getVersionString();
        }
        return i;
    }

    static String b(int i) {
        switch (i) {
            case SettingsConst.SINFO_VERSION /*4001*/:
                return "1.2.214.249";
            case SettingsConst.SINFO_SO_VERSION /*4002*/:
                return n();
            case SettingsConst.SINFO_SO_CHILD_VERSION /*4003*/:
                return Apollo.getChildVer();
            case SettingsConst.SINFO_SERIES_CODE /*4004*/:
                return Global.APOLLO_SERIES;
            case SettingsConst.SINFO_APOLLO_SO_VERSION /*4005*/:
                return o();
            default:
                return null;
        }
    }

    static boolean a(int i, boolean z) {
        String str = (String) v.get(Integer.valueOf(i).toString());
        return (str == null || str.length() == 0) ? z : h(str);
    }

    static void a(int i, Object obj) {
        String valueOf = obj instanceof Boolean ? ((Boolean) obj).booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE : String.valueOf(obj);
        b(Integer.valueOf(i).toString(), valueOf);
    }

    static String a(String str, String str2) {
        String str3 = (String) v.get(str);
        return str3 == null ? str2 : str3;
    }

    static boolean b(String str, String str2) {
        new StringBuilder("setGlobalOption - ").append(str).append(" = ").append(str2);
        v.put(str, str2);
        try {
            if (str.startsWith("rw.global.")) {
                MediaPlayer.setGlobalOption(str, str2);
            }
        } catch (Exception e) {
        }
        if (!b) {
            try {
                d.a(str, str2);
            } catch (Exception e2) {
            }
        }
        return true;
    }

    static void a(ProxyInfoGenerator proxyInfoGenerator) {
        x = proxyInfoGenerator;
    }

    static String p() {
        return "1.2.214.249";
    }

    static String q() {
        return Apollo.getChildVer();
    }

    static String r() {
        return Global.APOLLO_SERIES;
    }

    static int s() {
        return 1;
    }

    static void a(boolean z) {
        k = z;
    }

    static boolean t() {
        if (y == null) {
            return k;
        }
        return k && y.getBoolValue(SettingsConst.KEY_UseHWAccelerated);
    }

    static void b(boolean z) {
        l = z;
    }

    static boolean u() {
        return l;
    }

    static void c(boolean z) {
        m = z;
    }

    static boolean v() {
        return m;
    }

    static void d(boolean z) {
        n = z;
    }

    static boolean w() {
        if (y == null) {
            return n;
        }
        return n && y.getBoolValue(SettingsConst.KEY_EnableFullscreen);
    }

    static void e(boolean z) {
        o = z;
    }

    static boolean x() {
        return o;
    }

    static void f(boolean z) {
        p = z;
    }

    static boolean y() {
        return p;
    }

    static void g(boolean z) {
        q = z;
    }

    static boolean z() {
        return q;
    }

    static String d(String str) {
        String str2 = null;
        if (y != null) {
            str2 = y.getStringValue(str);
        } else if (x != null) {
            ProxyInfoGenerator proxyInfoGenerator = x;
            if (str.startsWith("ctcc_free_params:")) {
                ProxyInfo generateProxyInfo = proxyInfoGenerator.generateProxyInfo(str.substring(17).trim());
                if (generateProxyInfo == null) {
                    str2 = "";
                } else {
                    String str3 = generateProxyInfo.proxyServer;
                    Map map = generateProxyInfo.httpHeaders;
                    if (str3 == null) {
                        str2 = "";
                    } else {
                        StringBuilder stringBuilder = new StringBuilder(64);
                        stringBuilder.append("proxy-server=");
                        stringBuilder.append(str3);
                        stringBuilder.append('\n');
                        if (!(map == null || map.size() == 0)) {
                            stringBuilder.append("proxy-headers=");
                            for (String str22 : map.keySet()) {
                                stringBuilder.append(str22).append(": ").append((String) map.get(str22));
                                stringBuilder.append('\n');
                            }
                            stringBuilder.setLength(stringBuilder.length() - 1);
                        }
                        str22 = stringBuilder.toString();
                    }
                }
            }
        }
        if (f.a(str22) && str.equals(Global.EXT_KEY_APOLLO_STR)) {
            return "ap_next_buf=7000&ap_max_buf=15000";
        }
        return str22;
    }

    static int e(String str) {
        if (y != null) {
            return y.getIntValue(str);
        }
        return 0;
    }

    static float f(String str) {
        if (y != null) {
            return y.getFloatValue(str);
        }
        return 0.0f;
    }

    static boolean g(String str) {
        if (y != null) {
            return y.getBoolValue(str);
        }
        return false;
    }

    static String a(Uri uri) {
        if (y != null) {
            return y.getCookie(uri);
        }
        return "";
    }

    static String b(Uri uri) {
        if (y != null) {
            return y.getUserAgent(uri);
        }
        return "";
    }

    static void a(Provider provider) {
        y = provider;
    }

    static Provider A() {
        return y;
    }

    static void a(Object obj) {
        if (obj instanceof Provider) {
            y = (Provider) obj;
        } else {
            y = com.uc.apollo.impl.a.a(obj);
        }
    }

    static void h(boolean z) {
        r = z;
    }

    static boolean B() {
        return r;
    }

    static void i(boolean z) {
        s = z;
    }

    static boolean C() {
        return s;
    }

    static void j(boolean z) {
        t = z;
    }

    static boolean D() {
        return t;
    }

    public static void a(h hVar) throws RemoteException {
        for (Entry entry : v.entrySet()) {
            hVar.a((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void E() {
        for (Entry entry : v.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str.startsWith("rw.global.")) {
                MediaPlayer.setGlobalOption(str, str2);
            }
        }
    }

    private static boolean h(String str) {
        return str != null && (SettingsConst.TRUE.equals(str) || "true".equals(str));
    }
}
