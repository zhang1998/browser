package com.uc.encrypt.a.a;

import android.content.Context;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityVerification;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import com.uc.encrypt.a.f;
import com.uc.encrypt.j;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class a implements f {
    private ISecureSignatureComponent a;

    public final String a(String str, String str2) throws SecException {
        Map hashMap = new HashMap();
        hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str2);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        Object a = d.a();
        c.a(a);
        if (this.a == null) {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(a);
            if (instance != null) {
                this.a = instance.getSecureSignatureComp();
            }
        }
        return this.a.signRequest(securityGuardParamContext, j.b);
    }

    public final String a(Context context) throws JAQException {
        return new SecurityVerification(context).doJAQVerfificationSync(null, 20);
    }
}
