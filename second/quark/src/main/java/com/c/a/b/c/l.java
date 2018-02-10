package com.c.a.b.c;

import android.app.Activity;
import android.graphics.RectF;
import com.alibaba.wireless.security.SecExceptionCode;
import com.c.a.ac;
import com.c.a.b.b;
import com.c.a.b.c;
import com.c.a.e.e;
import com.c.a.f.a;
import com.c.a.o;
import com.uc.imagecodec.export.IPictureView;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ProGuard */
public final class l extends c<h> implements n {
    public static int[] a = new int[]{201, 202, SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE};
    public List<ac> b = new LinkedList();
    private RectF c;
    private o h;
    private a i;
    private com.c.a.a.a j;
    private k k;

    protected final /* synthetic */ b a(int i) {
        if (this.k != null) {
            b createStrategy = this.k.createStrategy(i);
            if (createStrategy != null) {
                return createStrategy;
            }
        }
        switch (i) {
            case 202:
                return new e(this.c, 180.0f, false);
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE /*203*/:
                return new e(this.c, 230.0f, false);
            case SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE /*204*/:
                return new e(this.c, 180.0f, true);
            case SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE_DATA /*205*/:
                return new e(this.c, 230.0f, true);
            case SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED /*206*/:
            case 213:
                return new a(com.c.a.e.a.b);
            case SecExceptionCode.SEC_ERROR_STA_STORE_ILLEGEL_KEY /*207*/:
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY /*208*/:
            case 209:
                return f.a(i, this.c);
            case 210:
                return new d(IPictureView.DEFAULT_MIN_SCALE, com.c.a.e.a.a);
            case 211:
                return new d(IPictureView.DEFAULT_MIN_SCALE, com.c.a.e.a.b);
            case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /*212*/:
                return new a(com.c.a.e.a.a);
            default:
                return new i();
        }
    }

    public l(int i, e eVar, b bVar) {
        super(i, eVar);
        this.c = bVar.a;
        this.h = bVar.b;
        this.k = bVar.d;
        this.j = bVar.c;
        this.j.c = this;
    }

    public final a c() {
        if (this.i == null) {
            this.i = ((h) this.e).a(this.j);
        }
        return this.i;
    }

    public final void b(Activity activity, int i) {
        super.b(activity, i);
    }

    public final void a(Activity activity) {
        super.a(activity);
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        this.b.clear();
        o c = ((h) this.e).c();
        if (c == null) {
            c = this.h;
        }
        for (int i = 0; i < 2; i++) {
            this.b.add(c.a());
        }
    }

    public final com.c.a.a.c b() {
        return ((h) this.e).b();
    }

    public final com.c.a.d.c a() {
        return ((h) this.e).a();
    }
}
