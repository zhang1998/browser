package facerecognition.register;

import android.content.Context;
import android.hardware.Camera.Size;
import com.ucweb.common.util.h.m;
import com.yunos.faceunlock.FaceFeature;
import com.yunos.faceunlock.facemanager.RegisteredFaceManager;
import facerecognition.a;
import facerecognition.a.d;

/* compiled from: ProGuard */
public final class g implements d {
    boolean a = false;
    boolean b = false;
    Context c;
    FaceFeature d;
    String e;
    volatile byte[] f;
    RegisteredFaceManager g;
    String h;
    String i;
    public a j = this;
    byte[] k;
    String l;
    String m;
    facerecognition.register.model.a n;
    boolean o = false;
    Size p;
    int q;
    boolean r = false;
    int s = 0;
    private Runnable t = new e(this);

    public g(Context context, String str, String str2) {
        this.c = context;
        this.l = str;
        this.m = str2;
        this.i = str2;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return false;
    }

    public final void c() {
        this.o = true;
        m.c(this.t);
    }

    public final void a(byte[] bArr, Size size, int i) {
        this.a = true;
        if (!this.b) {
            this.f = bArr;
            this.q = i;
            this.p = size;
            m.a(0, this.t);
        }
    }
}
