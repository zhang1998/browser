package facerecognition.register;

import android.hardware.Camera.Size;
import com.ucweb.common.util.h.m;
import com.yunos.faceunlock.FaceFeature;
import com.yunos.faceunlock.FaceLockUtil;
import com.yunos.faceunlock.utils.Util;
import facerecognition.register.model.a;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ g a;

    e(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (this.a.n == null) {
            FaceLockUtil.initialize(this.a.c, 480, 640, this.a.l, this.a.m);
            this.a.n = new a(this.a.c);
            this.a.h = this.a.n.b;
            this.a.g = this.a.n.a;
        }
        Size size = this.a.p;
        if (this.a.q == 3) {
            this.a.f = Util.rotateYUV420Degree180(this.a.f, size.width, size.height);
        }
        int i = size.height * size.width;
        if (this.a.k == null || this.a.k.length < i) {
            this.a.k = new byte[i];
        }
        System.arraycopy(this.a.f, 0, this.a.k, 0, i);
        if (!this.a.o) {
            FaceFeature faceFeature = FaceLockUtil.setupEnroll(this.a.k);
            if (faceFeature.isValid()) {
                if (this.a.d == null || this.a.d.getQuality() < faceFeature.getQuality()) {
                    this.a.d = faceFeature;
                }
                Runnable fVar = new f(this.a);
                fVar.a = d.a;
                fVar.b = Integer.valueOf(com.yunos.a.a.a.shared_holdon);
                m.a(2, fVar);
                fVar = new f(this.a);
                fVar.a = d.b;
                m.a(2, fVar);
            } else {
                Runnable fVar2 = new f(this.a);
                fVar2.a = d.c;
                fVar2.b = Integer.valueOf(faceFeature.getErrorFlag());
                m.a(2, fVar2);
            }
            this.a.a = false;
        }
    }
}
