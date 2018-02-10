package com.ucpro.feature.f;

import android.os.Message;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.base.a.a.a.b;
import com.uc.base.a.a.a.e.l;
import com.uc.base.a.a.a.g;
import com.ucpro.base.e.e;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class m extends e {
    public final void a(int i, Message message) {
        String str;
        if (com.ucpro.base.a.e.bV == i) {
            Object[] objArr = (Object[]) message.obj;
            str = (String) objArr[0];
            e.b().a(str, new r(n.a, str, this.b, (ValueCallback) objArr[1]));
        } else if (com.ucpro.base.a.e.bW == i) {
            str = String.valueOf(((List) message.obj).get(0));
            r0 = String.valueOf(((List) message.obj).get(1));
            e a = n.a;
            new StringBuilder("loginWithSmsCode\nphoneNumber is: ").append(str).append("\nsmsCode is: ").append(r0);
            e.a().a(str, r0, new p(a));
        } else if (com.ucpro.base.a.e.bY == i) {
            e a2 = n.a;
            b bVar = g.a;
            Object c = b.c();
            if (TextUtils.isEmpty(c)) {
                c.a("service ticket is empty");
            }
            e.a().a(c, new h(a2));
        } else if (com.ucpro.base.a.e.bZ == i) {
            r0 = (ArrayList) message.obj;
            if (r0 != null) {
                r0.get(0);
                r0.get(1);
                str = (String) r0.get(2);
                r0.get(3);
                n.a.a(l.QQ, str);
            }
        } else if (com.ucpro.base.a.e.ca == i) {
            r0 = (ArrayList) message.obj;
            if (r0 != null) {
                str = (String) r0.get(0);
                String str2 = (String) r0.get(1);
                r0 = (String) r0.get(2);
                e a3 = n.a;
                new StringBuilder("loginWithWechat\ncode: ").append(r0).append("\nappSecret: ").append(str2).append("\nappId: ").append(str);
                e.a().a(r0, str2, str, new j(a3));
            }
        } else if (com.ucpro.base.a.e.cb == i) {
            r0 = (ArrayList) message.obj;
            if (r0 != null) {
                r0.get(0);
                r0.get(1);
                n.a.a(l.WEIBO, (String) r0.get(2));
            }
        }
    }

    public final void b(int i, Message message) {
    }
}
