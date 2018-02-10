package facerecognition.unlock;

import android.content.Context;
import android.hardware.Camera.Size;
import com.ucweb.common.util.h.m;
import facerecognition.a;
import facerecognition.a.d;
import facerecognition.unlock.model.FaceUnlockParams;

/* compiled from: ProGuard */
public final class b implements d {
    boolean a = false;
    boolean b = false;
    Context c;
    volatile byte[] d;
    FaceUnlockParams e;
    boolean f;
    byte[] g;
    public a h = this;
    String i;
    String j;
    boolean k = false;
    facerecognition.unlock.model.a l;
    Size m;
    int n;
    float o = 0.0f;
    long p = 0;
    private int q = 0;
    private Runnable r = new c(this);

    public b(Context context, String str, String str2) {
        this.c = context;
        this.i = str;
        this.j = str2;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c() {
        this.k = true;
        m.c(this.r);
    }

    public final void a(byte[] bArr, Size size, int i) {
        if (bArr != null && size != null) {
            if (this.q == 0 && i == 3) {
                this.q++;
                return;
            }
            this.a = true;
            this.m = size;
            this.d = bArr;
            this.n = i;
            m.a(0, this.r);
        }
    }
}
