package facerecognition.register;

import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ g a;

    c(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        this.a.e = this.a.i + this.a.h + "_" + System.currentTimeMillis() + ".jpg";
        float[] landmark = this.a.d.getLandmark();
        StringBuffer stringBuffer = new StringBuffer();
        for (float f : landmark) {
            stringBuffer.append(f + " ");
        }
        landmark = this.a.d.getFeature();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (float f2 : landmark) {
            stringBuffer2.append(f2 + " ");
        }
        this.a.g.insert(this.a.h, this.a.e, stringBuffer.toString(), stringBuffer2.toString(), 0);
        this.a.g.setNeedSync(true);
        m.a(2, new b(this));
    }
}
