package com.c.a.b.a;

import android.app.Activity;
import android.content.Context;
import com.c.a.b.b;
import com.c.a.b.c;
import com.c.a.e.e;

/* compiled from: ProGuard */
public final class j extends c<l> implements f {
    private static int[] b = new int[]{1, 2, 3, 4};
    public boolean a;
    private a c;
    private e h = new e();

    public j(int i, e eVar, a aVar) {
        super(i, eVar);
        this.c = aVar;
        this.c.d = this.g;
    }

    public final boolean a(int i, int i2) {
        e.a(this.h, i, i2);
        this.g.a(this.h);
        return false;
    }

    public final void a(Context context) {
        this.a = true;
        if (((l) this.e).c((Activity) context)) {
            ((l) this.e).a(context);
        }
    }

    public final void a(Activity activity) {
        super.a(activity);
        if (this.a) {
            a((Context) activity);
        }
    }

    protected final /* synthetic */ b a(int i) {
        switch (i) {
            case 1:
                return new d(this.c);
            case 3:
                return new k(this.c);
            case 4:
                return new c(this.c);
            default:
                return new i(this.c);
        }
    }
}
