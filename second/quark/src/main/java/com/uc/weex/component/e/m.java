package com.uc.weex.component.e;

import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.bridge.h;
import com.taobao.weex.common.o;
import com.taobao.weex.ui.component.ab;
import com.uc.weex.component.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public class m extends o {
    @JSMethod
    public void push(String str) {
        pushAndCallback(str, null);
    }

    @JSMethod
    public void pushAndCallback(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            l a = a(this.b);
            if (a != null && str != null) {
                Iterator it = a.g.iterator();
                while (it.hasNext()) {
                    n nVar = (n) ((ab) it.next());
                    if (str.equalsIgnoreCase(nVar.b)) {
                        if (nVar.getHostView() == null) {
                            a.a(nVar);
                        }
                        ((q) nVar.getHostView()).setCallback(cVar);
                        c cVar2 = (c) a.getHostView();
                        q qVar = (q) nVar.getHostView();
                        if (qVar != null) {
                            cVar2.a(qVar, null, null);
                        }
                        a.a(false);
                        return;
                    }
                }
            }
        }
    }

    @JSMethod
    public void pop() {
        l a = a(this.b);
        if (a != null) {
            ((c) a.getHostView()).a(true);
            a.b();
        }
    }

    @JSMethod
    public void popTo(String str) {
        if (!TextUtils.isEmpty(str)) {
            l a = a(this.b);
            if (a != null && str != null) {
                Iterator it = a.g.iterator();
                while (it.hasNext()) {
                    n nVar = (n) ((ab) it.next());
                    if (str.equalsIgnoreCase(nVar.b)) {
                        ((c) a.getHostView()).b((q) nVar.getHostView());
                        a.b();
                        return;
                    }
                }
            }
        }
    }

    @JSMethod
    public void replace(String str, String str2) {
        q qVar = null;
        l a = a(this.b);
        if (a != null && str != null && str2 != null) {
            Iterator it = a.g.iterator();
            q qVar2 = null;
            while (it.hasNext()) {
                n nVar = (n) ((ab) it.next());
                if (str.equalsIgnoreCase(nVar.b)) {
                    if (nVar.getHostView() == null) {
                        a.a(nVar);
                    }
                    qVar2 = (q) nVar.getHostView();
                } else {
                    q qVar3;
                    if (str2.equalsIgnoreCase(nVar.b)) {
                        qVar3 = (q) nVar.getHostView();
                    } else {
                        qVar3 = qVar;
                    }
                    qVar = qVar3;
                }
            }
            c cVar = (c) a.getHostView();
            a kVar = new k(a);
            if (qVar2 != null) {
                cVar.a(qVar2, qVar, kVar);
            }
        }
    }

    @JSMethod
    public void getStackInfo(String str) {
        Map hashMap = new HashMap();
        l a = a(this.b);
        if (a != null && a.getHostView() != null) {
            hashMap.put("info", ((c) a.getHostView()).getStackInfo());
            new h(this.b.e, str).a(hashMap);
        }
    }

    private static l a(ac acVar) {
        return b.a().c(acVar.e);
    }

    @JSMethod
    public void reset() {
        l a = a(this.b);
        if (a != null) {
            a.a = false;
            ((c) a.getHostView()).c();
            a.a(true);
        }
    }
}
