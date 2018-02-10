package com.uc.media.interfaces;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public enum PlayerType {
    UNKNOWN,
    SYSTEM,
    VITAMIO,
    SYSTEM_UC,
    APOLLO,
    SYSTEM_MULTI_THREAD;

    public static boolean isSystem(PlayerType playerType) {
        return playerType == SYSTEM || playerType == SYSTEM_UC || playerType == SYSTEM_MULTI_THREAD;
    }

    public static PlayerType fromInteger(int i) {
        if (i == 1) {
            return SYSTEM;
        }
        if (i == 2) {
            return VITAMIO;
        }
        if (i == 3) {
            return SYSTEM_UC;
        }
        if (i == 4) {
            return APOLLO;
        }
        if (i == 5) {
            return SYSTEM_MULTI_THREAD;
        }
        return UNKNOWN;
    }

    public static int toInteger(PlayerType playerType) {
        if (playerType == SYSTEM) {
            return 1;
        }
        if (playerType == VITAMIO) {
            return 2;
        }
        if (playerType == SYSTEM_UC) {
            return 3;
        }
        if (playerType == APOLLO) {
            return 4;
        }
        if (playerType == SYSTEM_MULTI_THREAD) {
            return 5;
        }
        return 0;
    }
}
