package com.taobao.weex.utils;

import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class s {
    public static <K, V> HashMap<K, V> a(int i) {
        int i2;
        if (i < 3) {
            String str = "expectedSize";
            if (i < 0) {
                throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
            }
            i2 = i + 1;
        } else if (i < UCCore.VERIFY_POLICY_QUICK) {
            i2 = (int) ((((float) i) / 0.75f) + IPictureView.DEFAULT_MIN_SCALE);
        } else {
            i2 = Integer.MAX_VALUE;
        }
        return new HashMap(i2);
    }
}
