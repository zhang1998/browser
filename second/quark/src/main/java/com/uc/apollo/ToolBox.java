package com.uc.apollo;

import com.UCMobile.Apollo.Apollo;
import com.UCMobile.Apollo.util.CPU;
import com.uc.apollo.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: ProGuard */
public class ToolBox {
    public static boolean extractApolloSo(String str, String str2, String str3) {
        if (Apollo.loadUCInflator()) {
            return Apollo.extractLibs(str, str2, str3);
        }
        return false;
    }

    public static boolean checkCPUArmV7A() {
        if ((CPU.getFeature() & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkCPUArmV6() {
        if ((CPU.getFeature() & 2) > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkCPUX86() {
        if ((CPU.getFeature() & 64) > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkCPUFeatureVFP() {
        if ((CPU.getFeature() & 4) > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkCPUFeatureVFP3() {
        if ((CPU.getFeature() & 16) > 0) {
            return true;
        }
        return false;
    }
}
