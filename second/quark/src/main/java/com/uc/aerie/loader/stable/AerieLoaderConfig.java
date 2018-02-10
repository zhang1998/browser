package com.uc.aerie.loader.stable;

/* compiled from: ProGuard */
public class AerieLoaderConfig {
    public static final String UPDATER_TYPE_SOLO = "solo";
    public static final String UPDATER_TYPE_STANDARD = "standard";

    public static String getBaseDeploymentId() {
        return "07dc7a3fb4824e2a9ef1f1645e78fc40";
    }

    public static String getUpdaterType() {
        return UPDATER_TYPE_SOLO;
    }

    public static boolean isEnableBackup() {
        return false;
    }

    public static boolean isClassesNEnable() {
        return false;
    }

    public static int getMultidexIndex() {
        return 3;
    }
}
