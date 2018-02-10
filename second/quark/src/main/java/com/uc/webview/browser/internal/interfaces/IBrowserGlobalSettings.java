package com.uc.webview.browser.internal.interfaces;

import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import java.util.List;

@Interface
/* compiled from: ProGuard */
public interface IBrowserGlobalSettings extends IGlobalSettings {
    public static final int FORCE_USER_SCALABLE_DEFAULT = 0;
    public static final int FORCE_USER_SCALABLE_DISABLE = 2;
    public static final int FORCE_USER_SCALABLE_ENABLE = 1;

    List<String> getCoreCareSettingKeys(int i);

    void setRenderPriority(String str);
}
