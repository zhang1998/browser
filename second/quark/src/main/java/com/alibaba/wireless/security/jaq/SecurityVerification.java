package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.jaq.securitybody.IJAQVerificationComponent;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import java.util.HashMap;

/* compiled from: ProGuard */
public class SecurityVerification {
    private Context context;

    public SecurityVerification(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public String doJAQVerfificationSync(HashMap<String, String> hashMap, int i) throws JAQException {
        try {
            return ((IJAQVerificationComponent) SecurityGuardManager.getInstance(this.context).getInterface(IJAQVerificationComponent.class)).doJAQVerfificationSync(hashMap, i);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }
}
