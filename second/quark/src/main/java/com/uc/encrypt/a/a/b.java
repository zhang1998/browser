package com.uc.encrypt.a.a;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.uc.encrypt.a.a;
import com.uc.encrypt.j;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class b implements a {
    private IStaticDataEncryptComponent a;

    public final void a(Context context) throws SecException {
        SecurityGuardManager.getInitializer().initialize(context);
    }

    public final byte[] a(String str, byte[] bArr) throws SecException {
        return a().staticBinarySafeEncryptNoB64(16, str, bArr, j.b);
    }

    public final byte[] b(String str, byte[] bArr) throws SecException {
        return a().staticBinarySafeDecryptNoB64(16, str, bArr, j.b);
    }

    private IStaticDataEncryptComponent a() throws SecException {
        Object a = d.a();
        c.a(a);
        if (this.a == null) {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(a);
            if (instance != null) {
                this.a = instance.getStaticDataEncryptComp();
            }
        }
        return this.a;
    }
}
