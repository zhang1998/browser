package com.ucpro.services.d.a;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.uc.a.b.e;
import com.uc.a.d.j;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* compiled from: ProGuard */
final class c extends h implements j {
    private a c = new a("CmsDataSourceAdapter", Looper.getMainLooper(), this);

    public c(j jVar) {
        super(jVar);
    }

    public final void a(List<String> list) {
        if (a) {
            new StringBuilder("==getResFromLocal, resCodeList: ").append(list.toString());
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = list;
        this.c.sendMessage(obtain);
    }

    public final void a(String str, e eVar) {
        if (eVar != null) {
            String b = eVar.b();
            byte[] a = com.uc.a.d.e.a(eVar);
            boolean equals = "00000000".equals(eVar.c());
            int i = a.d(str, SettingsConst.FALSE) ? 1 : 2;
            if (a) {
                new StringBuilder("reqType: ").append(str).append(" updateType: ").append(i);
            }
            if (equals) {
                m.a(0, new d(this, b));
                this.b.a(i, b, null);
                return;
            }
            String b2 = b(a);
            if (b2 != null) {
                m.a(0, new p(this, b, a));
                this.b.a(i, b, b2);
            }
        }
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException e) {
            if (a) {
                Log.e("CmsDataSourceAdapter", "fail to convert byte array into String");
            }
            str = null;
        }
        if (a && str != null) {
            str.split("\r\n");
        }
        return str;
    }
}
