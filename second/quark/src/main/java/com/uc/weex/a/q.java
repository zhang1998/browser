package com.uc.weex.a;

import com.taobao.weex.utils.WXLogUtils;
import com.uc.weex.j.b;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ y c;

    q(y yVar, n nVar, byte[] bArr) {
        this.c = yVar;
        this.a = nVar;
        this.b = bArr;
    }

    public final void run() {
        if (this.c.b(this.a)) {
            String str = z.e + this.a.a + b.c;
            if (b.a(str, this.b)) {
                this.a.h = str;
                this.c.d.put(this.a.a, this.a);
                b.a(z.c, ad.a(this.c.d).getBytes());
                return;
            }
            WXLogUtils.d("JsBundleManager", "saveBundleInfo: bundle保存失败");
            return;
        }
        WXLogUtils.d("JsBundleManager", "saveBundleInfo: bundle比本地的旧");
    }
}
