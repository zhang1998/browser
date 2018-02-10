package com.uc.weex;

import com.uc.weex.e.c;
import com.uc.weex.h.o;

/* compiled from: ProGuard */
final class j implements c {
    long a = 0;
    long b = 0;
    final /* synthetic */ p c;

    j(p pVar) {
        this.c = pVar;
    }

    public final void a(String str, Object... objArr) {
        int i = -1;
        switch (str.hashCode()) {
            case -1855524919:
                if (str.equals("NOTIFY_LOAD_BUNDLE_TASK_BEGIN")) {
                    i = 0;
                    break;
                }
                break;
            case -732355548:
                if (str.equals("NOTIFY_CRATE_PAGE_AND_RENDER_TASK_END")) {
                    i = 2;
                    break;
                }
                break;
            case 1316506619:
                if (str.equals("NOTIFY_LOAD_BUNDLE_TASK_END")) {
                    i = 1;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                this.a = System.currentTimeMillis();
                return;
            case 1:
                this.b = System.currentTimeMillis();
                return;
            case 2:
                if (objArr != null && (objArr[0] instanceof o)) {
                    ((o) objArr[0]).h().s.u = this.b - this.a;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
