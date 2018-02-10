package com.uc.webview.browser.interfaces;

import com.uc.webview.browser.internal.interfaces.IBrowserGlobalSettings;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.extension.UCSettings;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.util.List;

@Interface
/* compiled from: ProGuard */
public abstract class BrowserSettings extends UCSettings {
    public static int FORCE_USER_SCALABLE_DEFAULT = 0;
    public static int FORCE_USER_SCALABLE_DISABLE = 2;
    public static int FORCE_USER_SCALABLE_ENABLE = 1;
    public static final int SETTINGS_TYPE_BOOL = 2;
    public static final int SETTINGS_TYPE_FLOAT = 3;
    public static final int SETTINGS_TYPE_INT = 1;
    public static final int SETTINGS_TYPE_STRING = 4;
    private static IBrowserGlobalSettings a = null;

    public abstract boolean getAutoFontSizeEnabled();

    @Deprecated
    public abstract boolean getBoolValue(String str);

    @Deprecated
    public abstract float getFloatValue(String str);

    @Deprecated
    public abstract int getIntValue(String str);

    @Deprecated
    public abstract String getStringValue(String str);

    public abstract void setAutoFontSizeEnabled(boolean z);

    @Deprecated
    public abstract void setBoolValue(String str, boolean z);

    @Deprecated
    public abstract void setFloatValue(String str, float f);

    @Deprecated
    public abstract void setIntValue(String str, int i);

    public abstract void setReportVerboseTraceEnabled(boolean z);

    @Deprecated
    public abstract void setStringValue(String str, String str2);

    private static IBrowserGlobalSettings a() {
        if (a == null) {
            try {
                a = (IBrowserGlobalSettings) ReflectionUtil.invoke("com.uc.webview.browser.internal.BrowserSDKFactory", "getGlobalSettings");
            } catch (Exception e) {
                throw new Error(e.getMessage());
            }
        }
        return a;
    }

    public static void setGlobalBoolValue(String str, boolean z) {
        a().setBoolValue(str, z);
    }

    public static void setGlobalIntValue(String str, int i) {
        a().setIntValue(str, i);
    }

    public static void setGlobalFloatValue(String str, float f) {
        a().setFloatValue(str, f);
    }

    public static void setGlobalStringValue(String str, String str2) {
        a().setStringValue(str, str2);
    }

    public static String getGlobalStringValue(String str) {
        return a().getStringValue(str);
    }

    public static int getGlobalIntValue(String str) {
        return a().getIntValue(str);
    }

    public static float getGlobalFloatValue(String str) {
        return a().getFloatValue(str);
    }

    public static List<String> getCoreCareSettingKeys(int i) {
        return a().getCoreCareSettingKeys(i);
    }

    public static void setRenderPriority(String str) {
        a().setRenderPriority(str);
    }
}
