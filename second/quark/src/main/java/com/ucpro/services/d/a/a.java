package com.ucpro.services.d.a;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.uc.a.d.c;
import com.uc.a.d.g;
import com.ucweb.common.util.e;
import com.ucweb.common.util.h.m;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: ProGuard */
final class a extends e {
    private WeakReference<c> a;

    public a(String str, Looper looper, c cVar) {
        super(str, looper);
        this.a = new WeakReference(cVar);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                List list = (List) message.obj;
                if (h.a) {
                    new StringBuilder("==doRequestFromServer, resCodeList: ").append(list.toString());
                }
                String str = null;
                c.a();
                g b = c.b();
                if (b != null) {
                    str = b.c;
                    boolean z = h.a;
                }
                if (com.ucweb.common.util.n.a.a(str)) {
                    boolean z2 = h.a;
                    return;
                }
                return;
            case 2:
                a(message);
                return;
            default:
                return;
        }
    }

    private void a(Message message) {
        List<String> list = (List) message.obj;
        if (h.a) {
            new StringBuilder("==doRequestFromLocal, resCodeList: ").append(list.toString());
        }
        for (String str : list) {
            e eVar = new e();
            eVar.a = str;
            Runnable oVar = new o(this);
            oVar.f = eVar;
            Runnable bVar = new b(this);
            bVar.f = eVar;
            m.a(0, oVar, bVar);
        }
    }

    static /* synthetic */ void a(a aVar, e eVar) {
        if (h.a) {
            new StringBuilder("==handleDataFromLocal, resCode: ").append(eVar.a);
        }
        c cVar = (c) aVar.a.get();
        if (cVar != null) {
            String a = c.b(eVar.b);
            if (a != null) {
                cVar.b.a(3, eVar.a, a);
            }
        } else if (h.a) {
            Log.w("CmsDataSourceAdapter", "mHost in CmsDataSourceAdapterHandler is NULL!");
        }
    }
}
