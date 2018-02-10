package com.uc.apollo.media.widget;

import com.uc.apollo.Settings;
import com.uc.apollo.base.ConfigFile;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public final class n {
    public static boolean a() {
        boolean z;
        if (1 == ConfigFile.getVRType()) {
            z = true;
        } else if (2 == ConfigFile.getVRType()) {
            z = false;
        } else {
            z = Settings.getBoolValue(SettingsConst.KEY_EnableVR);
        }
        if (!z || Settings.getActivity() == null) {
            return false;
        }
        return true;
    }
}
