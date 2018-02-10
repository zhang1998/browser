package android.support.v4.app;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class ap {
    private static final av a;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new cw();
        } else if (VERSION.SDK_INT >= 20) {
            a = new ak();
        } else if (VERSION.SDK_INT >= 19) {
            a = new ci();
        } else if (VERSION.SDK_INT >= 16) {
            a = new bq();
        } else if (VERSION.SDK_INT >= 14) {
            a = new at();
        } else if (VERSION.SDK_INT >= 11) {
            a = new br();
        } else if (VERSION.SDK_INT >= 9) {
            a = new ao();
        } else {
            a = new bl();
        }
    }

    static /* synthetic */ void a(n nVar, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            nVar.a((bf) it.next());
        }
    }

    static /* synthetic */ void a(j jVar, cl clVar) {
        if (clVar == null) {
            return;
        }
        if (clVar instanceof bx) {
            bx bxVar = (bx) clVar;
            m.a(jVar, bxVar.d, bxVar.f, bxVar.e, bxVar.a);
        } else if (clVar instanceof az) {
            az azVar = (az) clVar;
            m.a(jVar, azVar.d, azVar.f, azVar.e, azVar.a);
        } else if (clVar instanceof aj) {
            aj ajVar = (aj) clVar;
            m.a(jVar, ajVar.d, ajVar.f, ajVar.e, ajVar.a, ajVar.b, ajVar.c);
        }
    }
}
