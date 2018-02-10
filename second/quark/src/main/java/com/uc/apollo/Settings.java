package com.uc.apollo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.base.Config;
import com.uc.apollo.base.ConfigFile;
import com.uc.apollo.impl.SettingsConst;

@KeepForRuntime
/* compiled from: ProGuard */
public class Settings implements SettingsConst {

    @KeepForRuntime
    /* compiled from: ProGuard */
    public interface Provider {
        boolean getBoolValue(String str);

        String getCookie(Uri uri);

        float getFloatValue(String str);

        int getIntValue(String str);

        String getStringValue(String str);

        String getUserAgent(Uri uri);
    }

    /* compiled from: ProGuard */
    public final class a {
        public String a;
        public String b;
        public String c;
    }

    public static boolean setOption(int i, String str) {
        return a.a(i, str);
    }

    public static boolean setOption(int i, boolean z) {
        return setOption(i, z ? SettingsConst.TRUE : SettingsConst.FALSE);
    }

    public static void setApolloSoPath(String str) {
        a.b(str);
    }

    public static String getVersion() {
        return a.p();
    }

    public static String getStringInfo(int i) {
        return a.b(i);
    }

    public static SparseArray<String> getInstanceSettings() {
        return a.l();
    }

    public static boolean isUseDefaultController() {
        return a.m();
    }

    public static void setGlobalOption(int i, Object obj) {
        a.a(i, obj);
    }

    public static void setGlobalOption(String str, String str2) {
        a.b(str, str2);
    }

    public static boolean getGlobalOption(int i, boolean z) {
        return a.a(i, z);
    }

    public static int getGlobalOption(int i, int i2) {
        String a = a.a(Integer.valueOf(i).toString(), null);
        if (a != null && a.length() > 0) {
            try {
                i2 = Integer.valueOf(a).intValue();
            } catch (Throwable th) {
            }
        }
        return i2;
    }

    public static String getGlobalOption(int i, String str) {
        String a = a.a(Integer.valueOf(i).toString(), null);
        return a == null ? str : a;
    }

    public static String getGlobalOption(String str, String str2) {
        return a.a(str, str2);
    }

    @Deprecated
    public static boolean setApolloOption(String str, String str2) {
        setGlobalOption(str, str2);
        return true;
    }

    public static String getSoVersion() {
        return a.n();
    }

    public static void setSoVersion(String str) {
        a.c(str);
    }

    public static String getApolloSoVersion() {
        return a.o();
    }

    public static String getSoChildVer() {
        return a.q();
    }

    public static String getApolloSeries() {
        return a.r();
    }

    public static int getSurfaceFormat() {
        return a.s();
    }

    public static void setUseHWAccelerated(boolean z) {
        a.a(z);
    }

    public static boolean getUseHWAccelerated() {
        return a.t();
    }

    public static void setEnableLittleWin(boolean z) {
        a.b(z);
    }

    public static boolean getEnableLittleWin() {
        return a.u();
    }

    public static void setEnableMediaService(boolean z) {
        a.c(z);
    }

    public static boolean getEnableMediaService() {
        return a.v();
    }

    public static void setEnableFullScreen(boolean z) {
        a.d(z);
    }

    public static boolean getEnableFullScreen() {
        return a.w();
    }

    public static void setPausePlayAfterExitFullScreen(boolean z) {
        a.e(z);
    }

    public static boolean getPausePlayAfterExitFullScreen() {
        return a.x();
    }

    public static void setShowGestureGuide(boolean z) {
        a.f(z);
    }

    public static boolean getEnableShowGestureGuide() {
        return a.y();
    }

    public static void setShowMobileNetworkPlayToast(boolean z) {
        a.g(z);
    }

    public static boolean getShowMobileNetworkPlayToast() {
        return a.z();
    }

    public static String getStringValue(String str) {
        return a.d(str);
    }

    public static int getIntValue(String str) {
        return a.e(str);
    }

    public static float getFloatValue(String str) {
        return a.f(str);
    }

    public static boolean getBoolValue(String str) {
        return a.g(str);
    }

    public static String getCookie(Uri uri) {
        return a.a(uri);
    }

    public static String getUserAgent(Uri uri) {
        return a.b(uri);
    }

    public static void setProvider(Provider provider) {
        a.a(provider);
    }

    public static Provider getProvider() {
        return a.A();
    }

    public static void setProvider(Object obj) {
        a.a(obj);
    }

    public static void setContext(Context context) {
        Config.setContext(context);
    }

    public static Context getContext() {
        return Config.getContext();
    }

    public static Activity getActivity() {
        return Config.getActivity();
    }

    public static void setShouldUseDefaultAudioFocusChangeListener(boolean z) {
        a.h(z);
    }

    public static boolean shouldUseDefaultAudioFocusChangeListener() {
        return a.B();
    }

    public static void setShouldPausePlayWhenAudioFocusLossTransient(boolean z) {
        a.i(z);
    }

    public static boolean shouldPausePlayWhenAudioFocusLossTransient() {
        return a.C();
    }

    public static void setShouldContinuePlayWhenAudioFocusGainAfterLossTransient(boolean z) {
        a.j(z);
    }

    public static boolean shouldContinuePlayWhenAudioFocusGainAfterLossTransient() {
        return a.D();
    }

    public static void init(Context context) {
        a.a(context);
    }

    public static void init(Context context, boolean z) {
        a.a(context, z);
    }

    public static void mediaPlayerServiceInit() {
        a.a();
    }

    public static void uninit() {
        a.b();
    }

    public static boolean valid() {
        return a.c();
    }

    public static void setUserType(int i) {
        a.a(i);
    }

    public static int getUserType() {
        return a.d();
    }

    public static String getMediaPlayerServiceClassName() {
        return a.e();
    }

    public static boolean shouldAutoCloseMediaPlayerSerivce() {
        return a.f();
    }

    public static boolean supportLittleWindow() {
        return a.g();
    }

    public static boolean supportLittleWindow(String str) {
        return a.a(str);
    }

    public static boolean mediaPlayerServiceEnable() {
        return a.h();
    }

    public static void setDexParams(String str, String str2, String str3) {
        a.a(str, str2, str3);
    }

    public static a getDexInfo() {
        return a.i();
    }

    public static void setIsSvcProcess() {
        a.j();
    }

    public static boolean isSvcProcess() {
        return a.k();
    }

    public static void setResetSystemMediaPlayerBeforeChangeSurface(boolean z) {
        setGlobalOption(1, Boolean.valueOf(!z));
    }

    public static boolean getResetSystemMediaPlayerBeforeChangeSurface() {
        return !getGlobalOption(1, true);
    }

    public static void setCompatibleWithSystemMediaPlayer(boolean z) {
        setGlobalOption(2, Boolean.valueOf(z));
    }

    public static boolean getCompatibleWithSystemMediaPlayer() {
        return getGlobalOption(2, false);
    }

    public static void setDisableApollo(boolean z) {
        setGlobalOption(3, Boolean.valueOf(z));
    }

    public static boolean getDisableApollo() {
        return getGlobalOption(3, false);
    }

    public static boolean shouldResetSystemMediaPlayerBeforeChangeSurface() {
        return ConfigFile.resetMediaPlayerIfChangeSurface() || getResetSystemMediaPlayerBeforeChangeSurface();
    }

    public static boolean shouldCompatibleWithSystemMediaPlayer() {
        return getCompatibleWithSystemMediaPlayer();
    }

    public static void setProxyInfoGenerator(ProxyInfoGenerator proxyInfoGenerator) {
        a.a(proxyInfoGenerator);
    }
}
