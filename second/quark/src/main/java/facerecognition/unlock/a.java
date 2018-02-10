package facerecognition.unlock;

import com.yunos.faceunlock.FaceCompareResult;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ FaceCompareResult a;
    final /* synthetic */ b b;

    a(b bVar, FaceCompareResult faceCompareResult) {
        this.b = bVar;
        this.a = faceCompareResult;
    }

    public final void run() {
        if (this.b.h != null) {
            this.b.h.b(this.a.getError_flag());
        }
    }
}
