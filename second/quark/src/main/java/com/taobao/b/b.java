package com.taobao.b;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b {
    private static HashMap<String, Object> a = new HashMap();
    private static Object b = new Object();

    public static /* synthetic */ String a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= 0; i++) {
            if (!TextUtils.isEmpty(strArr[0])) {
                stringBuffer.append(strArr[0]);
            }
        }
        return stringBuffer.toString();
    }
}
