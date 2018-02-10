package com.taobao.weex.c;

import android.os.Handler.Callback;
import android.os.Message;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.c.a.x;
import com.taobao.weex.c.b.h;
import com.taobao.weex.common.p;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class z implements Callback {
    private ab a;
    private boolean b = false;

    public z(ab abVar) {
        this.a = abVar;
    }

    public final boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        ah ahVar;
        ab abVar;
        int i = message.what;
        Object obj = message.obj;
        if (obj instanceof ah) {
            ahVar = (ah) obj;
        } else {
            ahVar = null;
        }
        if (!this.b) {
            this.b = true;
            abVar = this.a;
            if (!(abVar.b == null || abVar.a == null || !abVar.a.a() || abVar.a.getLooper() == null)) {
                abVar.b.sendEmptyMessageDelayed(255, 16);
            }
        }
        ab abVar2;
        String str;
        switch (i) {
            case 2:
                boolean z;
                abVar2 = this.a;
                str = ahVar.a;
                String str2 = (String) ahVar.b.get(0);
                e eVar = (e) ahVar.b.get(1);
                if (ahVar.b.size() <= 2 || !((Boolean) ahVar.b.get(2)).booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                abVar2.a(str, new x(str2, eVar, z));
                break;
            case 250:
                abVar = this.a;
                String str3 = ahVar.a;
                abVar.a();
                m mVar = (m) abVar.c.get(str3);
                if (mVar != null) {
                    mVar.f();
                    break;
                }
                break;
            case 254:
                abVar2 = this.a;
                str = ahVar.a;
                d dVar = (d) ahVar.b.get(0);
                ((Boolean) ahVar.b.get(1)).booleanValue();
                abVar2.a(str, dVar);
                break;
            case 255:
                abVar = this.a;
                abVar.a();
                for (Entry value : abVar.c.entrySet()) {
                    m mVar2 = (m) value.getValue();
                    if (mVar2.h && !mVar2.i) {
                        ae aeVar = (ae) mVar2.a.get("_root");
                        if (aeVar != null) {
                            p pVar;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (!(aeVar == null || aeVar.w == null)) {
                                int size = aeVar.w.size();
                                for (i = 0; i < size; i++) {
                                    ae aeVar2 = (ae) mVar2.a.get((String) aeVar.w.get(i));
                                    if (!(aeVar2 == null || aeVar2.v == null)) {
                                        aeVar2.v.b(aeVar2);
                                        aeVar.a(aeVar2, -1);
                                    }
                                }
                            }
                            aeVar.a(new f(mVar2));
                            long currentTimeMillis2 = System.currentTimeMillis();
                            h hVar = mVar2.g;
                            aeVar.b.a();
                            com.taobao.weex.c.b.p.a(hVar, aeVar, Float.NaN, null);
                            ac b = ad.a().b(mVar2.c);
                            if (b != null) {
                                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                                p pVar2 = b.s;
                                pVar2.s = currentTimeMillis2 + pVar2.s;
                            }
                            aeVar.a(new g(mVar2));
                            currentTimeMillis2 = System.currentTimeMillis();
                            aeVar.a(new k(mVar2));
                            if (b != null) {
                                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                                pVar = b.s;
                                pVar.r = currentTimeMillis2 + pVar.r;
                            }
                            currentTimeMillis2 = System.currentTimeMillis();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            for (Entry value2 : mVar2.j.entrySet()) {
                                mVar2.a(((i) value2.getValue()).a);
                            }
                            if (i.c()) {
                                WXLogUtils.d("updateDomObj", "time:" + (System.currentTimeMillis() - currentTimeMillis3));
                            }
                            if (b != null) {
                                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                                pVar = b.s;
                                pVar.q = currentTimeMillis2 + pVar.q;
                            }
                            mVar2.g();
                            obj = (b == null || !b.v) ? null : 1;
                            if (obj == null) {
                                mVar2.f();
                            }
                            mVar2.j.clear();
                            mVar2.f.clear();
                            mVar2.h = false;
                            if (b != null) {
                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                p pVar3 = b.s;
                                pVar3.o = currentTimeMillis4 + pVar3.o;
                            }
                        }
                    }
                }
                this.b = false;
                break;
        }
        return true;
    }
}
