package com.loc;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: ProGuard */
public final class bi {
    private static bi a;

    public static bi a() {
        if (a == null) {
            a = new bi();
        }
        return a;
    }

    public static byte[] a(bp bpVar) throws dw {
        dw e;
        try {
            bq a = a(bpVar, true);
            return a != null ? a.a : null;
        } catch (dw e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new dw("未知的错误");
        }
    }

    public static byte[] b(bp bpVar) throws dw {
        dw e;
        try {
            bq a = a(bpVar, false);
            return a != null ? a.a : null;
        } catch (dw e2) {
            throw e2;
        } catch (Throwable th) {
            es.a(th, "BaseNetManager", "makeSyncPostRequest");
            e2 = new dw("未知的错误");
        }
    }

    public static bq c(bp bpVar) throws dw {
        dw e;
        try {
            bq a = a(bpVar, false);
            return a != null ? a : null;
        } catch (dw e2) {
            throw e2;
        } catch (Throwable th) {
            es.a(th, "BaseNetManager", "makeSyncPostRequest");
            e2 = new dw("未知的错误");
        }
    }

    private static bq a(bp bpVar, boolean z) throws dw {
        dw e;
        if (bpVar == null) {
            try {
                throw new dw("requeust is null");
            } catch (dw e2) {
                throw e2;
            } catch (Throwable th) {
                e2 = new dw("未知的错误");
            }
        } else if (bpVar.c() == null || "".equals(bpVar.c())) {
            throw new dw("request url is empty");
        } else {
            String c;
            bn bnVar = new bn(bpVar.c, bpVar.d, bpVar.e == null ? null : bpVar.e, z);
            byte[] e3 = bpVar.e();
            if (e3 == null || e3.length == 0) {
                c = bpVar.c();
            } else {
                Map a = bpVar.a();
                if (a == null) {
                    c = bpVar.c();
                } else {
                    String a2 = bn.a(a);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(bpVar.c()).append("?").append(a2);
                    c = stringBuffer.toString();
                }
            }
            Map b = bpVar.b();
            e3 = bpVar.e();
            if (e3 == null || e3.length == 0) {
                String a3 = bn.a(bpVar.a());
                if (!TextUtils.isEmpty(a3)) {
                    e3 = eq.a(a3);
                }
            }
            return bnVar.a(c, b, e3);
        }
    }
}
