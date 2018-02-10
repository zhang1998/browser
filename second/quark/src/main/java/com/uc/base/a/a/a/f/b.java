package com.uc.base.a.a.a.f;

import android.content.Context;
import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import com.uc.apollo.impl.SettingsConst;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
public final class b implements a {
    public static String a;
    public static String b;
    private final Context c;

    public b(Context context) {
        this.c = context;
    }

    private static String e(String str) {
        byte[] array = ByteBuffer.allocate(2).putShort(Short.valueOf(str).shortValue()).array();
        if (array == null || array.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(array.length * 2);
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 255) < 16) {
                stringBuilder.append(SettingsConst.FALSE);
            }
            stringBuilder.append(Long.toString((long) (array[i] & 255), 16));
        }
        return stringBuilder.toString().toLowerCase(Locale.ENGLISH);
    }

    public final String a(String str) {
        try {
            String str2 = str + "3dsa33@213!!!22";
            ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(new ContextWrapper(this.c)).getSecureSignatureComp();
            Map hashMap = new HashMap();
            hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str2);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.appKey = b;
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            return e(b) + secureSignatureComp.signRequest(securityGuardParamContext, a);
        } catch (Throwable th) {
            return null;
        }
    }

    public final void a(String str, int i) {
        try {
            SecurityGuardManager.getInstance(new ContextWrapper(this.c)).getDynamicDataStoreComp().putInt(str, i);
        } catch (Throwable th) {
        }
    }

    public final int c(String str) {
        try {
            return SecurityGuardManager.getInstance(new ContextWrapper(this.c)).getDynamicDataStoreComp().getInt(str);
        } catch (SecException e) {
            e.getErrorCode();
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public final boolean a(String str, String str2) {
        boolean z = false;
        try {
            z = SecurityGuardManager.getInstance(new ContextWrapper(this.c)).getDynamicDataStoreComp().putStringDDpEx(str, str2, 0);
        } catch (Throwable th) {
        }
        return z;
    }

    public final String b(String str) {
        try {
            return SecurityGuardManager.getInstance(new ContextWrapper(this.c)).getDynamicDataStoreComp().getStringDDpEx(str, 0);
        } catch (SecException e) {
            e.getErrorCode();
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public final void d(String str) {
        try {
            SecurityGuardManager.getInstance(new ContextWrapper(this.c)).getDynamicDataStoreComp().removeStringDDpEx(str, 0);
        } catch (Throwable th) {
        }
    }
}
