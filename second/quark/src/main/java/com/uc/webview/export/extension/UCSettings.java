package com.uc.webview.export.extension;

import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.Log;
import java.util.HashSet;
import java.util.Set;

@Api
/* compiled from: ProGuard */
public abstract class UCSettings {
    public static final String CDKEY_MAX_REQ_PER_CLIENT = "max_req_per_client";
    public static final String CDKEY_MAX_REQ_PER_HOST = "max_req_per_host";
    public static final String CD_RESOURCE_STAT_FILTER_LIST = "stat_filter_list";
    public static int FORCE_USER_SCALABLE_DEFAULT = 0;
    public static int FORCE_USER_SCALABLE_DISABLE = 2;
    public static int FORCE_USER_SCALABLE_ENABLE = 1;
    public static final int FORM_SAVE_TYPE_AUTO = 1;
    public static final int FORM_SAVE_TYPE_NO = 2;
    public static final int FORM_SAVE_TYPE_PROMPT = 0;
    public static final int IMAGE_QUALITY_FULL_COLOR = 3;
    public static final int IMAGE_QUALITY_LOW_COLOR = 1;
    public static final int IMAGE_QUALITY_NO_IMAGE = 0;
    public static final int IMAGE_QUALITY_STANDARD = 2;
    public static final String KEY_ADBLOCK_WHITE_LIST = "resadwhitelist";
    public static final String KEY_DISABLE_ACCELERATE_CANVAS = "DisableAccelerateCanvas";
    public static final String KEY_DISABLE_FLOAT_VIDEO_VIEW = "video_fixed_sw_hostlist";
    public static final String KEY_DISABLE_VIDEO_RESUME = "disable_video_resume";
    public static final String KEY_DONOT_PAUSE_AFTER_EXIT_VIDEO_FULLSCREEN = "crsp_npef";
    public static final String KEY_DONOT_PAUSE_AFTER_SHOW_MODE_CHANGED = "crsp_npsmc";
    public static final String KEY_ENABLE_VIDEO_AUTO_PLAY_LIST = "video_play_gesture_whitelist";
    public static final String KEY_NIGHT_MODE_COLOR = "NightModeColor";
    public static final String KEY_USE_RAW_VIDEO_CONTROLS = "u4xr_video_st_list";
    public static final String KEY_VIDEO_ENTER_VIEW_FULLSCREEN_ONLY = "crsp_fsa_bl";
    public static final String KEY_VIDEO_SUPPORT_RAW_CONTROLS_ATTR = "crsp_sp_rc";
    public static final int LAYOUT_MODE_ADAPT = 2;
    public static final int LAYOUT_MODE_ZOOM = 1;
    public static final int PREREAD_TYPE_NON = 0;
    public static final int PREREAD_TYPE_WAP = 1;
    public static final int PREREAD_TYPE_WAP_AND_WEB = 3;
    public static final int PREREAD_TYPE_WEB = 2;
    public static final String SDKUUID = "SDKUUID";
    public static final int THEME_BLUE = 3;
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_GREEN = 1;
    public static final int THEME_GREY = 4;
    public static final int THEME_PINK = 2;
    public static final int THEME_TRANSPARENT = -1;
    private static Set<String> a;

    public abstract boolean getEnableUCProxy();

    public abstract boolean getForceUCProxy();

    public abstract int getUCCookieType();

    public abstract void setEnableUCProxy(boolean z);

    public abstract void setForceUCProxy(boolean z);

    public abstract void setUCCookieType(int i);

    static {
        Set hashSet = new HashSet();
        a = hashSet;
        hashSet.add(KEY_USE_RAW_VIDEO_CONTROLS);
        a.add(KEY_VIDEO_SUPPORT_RAW_CONTROLS_ATTR);
        a.add(KEY_VIDEO_ENTER_VIEW_FULLSCREEN_ONLY);
        a.add(KEY_DISABLE_FLOAT_VIDEO_VIEW);
        a.add(KEY_ENABLE_VIDEO_AUTO_PLAY_LIST);
        a.add("resadwhitelist");
        a.add(CD_RESOURCE_STAT_FILTER_LIST);
        a.add(KEY_NIGHT_MODE_COLOR);
    }

    public static void donotPauseAfterExitVideoFullScreen() {
        SDKFactory.d.updateBussinessInfo(2, 1, KEY_DONOT_PAUSE_AFTER_EXIT_VIDEO_FULLSCREEN, SettingsConst.TRUE);
    }

    public static void updateBussinessInfo(int i, int i2, String str, Object obj) {
        if (SDKFactory.d != null && a.contains(str)) {
            UCMobileWebKit uCMobileWebKit = SDKFactory.d;
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                StringBuilder stringBuilder = new StringBuilder();
                for (String trim : strArr) {
                    String trim2 = trim2.trim();
                    if (trim2.length() != 0) {
                        stringBuilder.append(trim2).append("^^");
                    }
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.setLength(stringBuilder.length() - 2);
                    obj = stringBuilder.toString();
                    uCMobileWebKit.updateBussinessInfo(i, i2, str, obj);
                }
            }
            if (obj instanceof String) {
                String str2 = (String) obj;
            } else {
                obj = "";
            }
            uCMobileWebKit.updateBussinessInfo(i, i2, str, obj);
        }
    }

    public static void setLayoutMode(int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null && iGlobalSettings.getIntValue(SettingKeys.PageLayoutStyle) != i) {
            iGlobalSettings.setIntValue(SettingKeys.PageLayoutStyle, i);
        }
    }

    public static int getLayoutMode() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getIntValue(SettingKeys.PageLayoutStyle);
        }
        return -1;
    }

    public static void setNightMode(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null && iGlobalSettings.getBoolValue(SettingKeys.UIIsNightMode) != z) {
            iGlobalSettings.setBoolValue(SettingKeys.UIIsNightMode, z);
        }
    }

    public static boolean isNightMode() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.UIIsNightMode);
        }
        return false;
    }

    public static void setEnableCustomErrorPage(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null && iGlobalSettings.getBoolValue(SettingKeys.EnableCustomErrorPage) != z) {
            iGlobalSettings.setBoolValue(SettingKeys.EnableCustomErrorPage, z);
        }
    }

    public static void setEnableMediaCache(boolean z) {
        SDKFactory.a(z);
    }

    public static boolean isEnableCustomErrorPage() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.EnableCustomErrorPage);
        }
        return false;
    }

    public static void setGlobalEnableUCProxy(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.SetGlobalEnableUCProxy, z);
        }
    }

    public static void setEnableAdblock(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.PageEnableAdBlock, z);
        }
    }

    public static void setEnableDispatcher(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.PageEnableDispatcher, z);
        }
    }

    public static void setEnableMultiThreadParser(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.EnableMultithreadParser, z);
        }
    }

    public static void setEnableAllResourceCallBack(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.EnableAllResponseCallback, z);
        }
    }

    public static void setEnableRequestIntercept(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.EnableRequestIntercept, z);
        }
    }

    public static boolean getEnableRequestIntercept() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.EnableRequestIntercept);
        }
        return false;
    }

    public static boolean getEnableAllResourceCallBack() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.EnableAllResponseCallback);
        }
        return false;
    }

    public static void setPageCacheCapacity(int i) {
        if (i < 0 || i > 20) {
            throw new IllegalArgumentException("capacity : " + i + ", should be a non-negative integer between 0 (no cache) and 20 (max).");
        }
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setIntValue(SettingKeys.AdvancedPageCacheSize, i);
        }
    }

    public static int getPageCacheCapacity() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getIntValue(SettingKeys.AdvancedPageCacheSize);
        }
        return -1;
    }

    public void setEnableFastScroller(boolean z) {
        Log.w("UCSettings", "setEnableFastScroller not override");
    }

    public boolean enableFastScroller() {
        Log.w("UCSettings", "enableFastScroller not override");
        return false;
    }

    public static void setForceUserScalable(int i) {
        if (i == FORCE_USER_SCALABLE_DEFAULT || i == FORCE_USER_SCALABLE_ENABLE || i == FORCE_USER_SCALABLE_DISABLE) {
            IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
            if (iGlobalSettings != null) {
                iGlobalSettings.setIntValue(SettingKeys.PageForceUserScalable, i);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("enable : " + i + ", should be one of FORCE_USER_SCALABLE_DEFAULT/FORCE_USER_SCALABLE_ENABLE/FORCE_USER_SCALABLE_DISABLE");
    }

    public static void setPageColorTheme(int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings == null) {
            return;
        }
        if (i == -1) {
            iGlobalSettings.setBoolValue(SettingKeys.UIWebPageIsTransparentTheme, true);
            return;
        }
        if (iGlobalSettings.getBoolValue(SettingKeys.UIWebPageIsTransparentTheme)) {
            iGlobalSettings.setBoolValue(SettingKeys.UIWebPageIsTransparentTheme, false);
        }
        iGlobalSettings.setIntValue(SettingKeys.PageColorTheme, i);
    }

    public static int getPageColorTheme() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings == null) {
            return 0;
        }
        if (iGlobalSettings.getBoolValue(SettingKeys.UIWebPageIsTransparentTheme)) {
            return -1;
        }
        return iGlobalSettings.getIntValue(SettingKeys.PageColorTheme);
    }

    public static void setImageQuality(int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setIntValue(SettingKeys.PageImageQuality, i);
        }
    }

    public static int getImageQuality() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getIntValue(SettingKeys.PageImageQuality);
        }
        return 2;
    }

    public static void setSmartReader(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.PageEnableSmartReader, z);
        }
    }

    public static boolean getSmartReader() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.PageEnableSmartReader);
        }
        return false;
    }

    public static void setPrereadType(int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setIntValue(SettingKeys.AdvancedPrereadOptions, i);
        }
    }

    public static int getPrereadType() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getIntValue(SettingKeys.AdvancedPrereadOptions);
        }
        return 0;
    }

    public static void setFormSaveType(int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setIntValue(SettingKeys.PageFormSave, i);
        }
    }

    public static int getFormSaveType() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getIntValue(SettingKeys.PageFormSave);
        }
        return 0;
    }

    public static void setEnableUCVideoViewFullscreen(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.EANBLE_UC_VIDEOVIEW_FULLSCREEN, z);
        }
    }

    public static boolean enableUCVideoViewFullscreen() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.EANBLE_UC_VIDEOVIEW_FULLSCREEN);
        }
        return false;
    }

    public static void disableNetwork(Boolean bool) {
        Log.w("UCSettings", "background netoff current value=" + bool);
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(SettingKeys.OFFNET_ON, bool.booleanValue());
        }
    }

    public static boolean isNetworkDisabled() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(SettingKeys.OFFNET_ON);
        }
        return false;
    }

    public static void setEnableUCParam(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue("SDKUCParam", z);
        }
    }

    public static boolean enableUCParam() {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue("SDKUCParam");
        }
        return false;
    }

    public static void setGlobalPrivateBrowsing(boolean z) {
        setGlobalBoolValue(SettingKeys.RecordIsNoFootmark, z);
    }

    public static boolean isGlobalPrivateBrowsingEnabled() {
        return getGlobalBoolValue(SettingKeys.RecordIsNoFootmark);
    }

    public static void setGlobalIntValue(String str, int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setIntValue(str, i);
        }
    }

    public static void setGlobalStringValue(String str, String str2) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setStringValue(str, str2);
        }
    }

    public static void setRIPort(int i) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setStringValue("SDKRIPort", String.valueOf(i));
        }
    }

    public static void setGlobalBoolValue(String str, boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setBoolValue(str, z);
        }
    }

    public static boolean getGlobalBoolValue(String str) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) SDKFactory.invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            return iGlobalSettings.getBoolValue(str);
        }
        return false;
    }
}
