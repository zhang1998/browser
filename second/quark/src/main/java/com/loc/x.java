package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: ProGuard */
public final class x {
    private n a = a(this.b);
    private Context b;

    public x(Context context) {
        this.b = context;
    }

    private static n a(Context context) {
        try {
            return new n(context, n.a(t.class));
        } catch (Throwable th) {
            es.a(th, "UpdateLogDB", "getDB");
            return null;
        }
    }

    public final y a() {
        try {
            if (this.a == null) {
                this.a = a(this.b);
            }
            List a = this.a.a("1=1", y.class, false);
            if (a.size() > 0) {
                return (y) a.get(0);
            }
        } catch (Throwable th) {
            es.a(th, "UpdateLogDB", "getUpdateLog");
        }
        return null;
    }

    public final void a(y yVar) {
        if (yVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b);
                }
                String str = "1=1";
                if (this.a.a(str, y.class, false).size() == 0) {
                    this.a.a((Object) yVar);
                } else {
                    this.a.a(str, (Object) yVar, false);
                }
            } catch (Throwable th) {
                es.a(th, "UpdateLogDB", "updateLog");
            }
        }
    }
}
