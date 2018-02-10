package facerecognition.a;

import com.yunos.faceunlock.FaceLockUtil;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ f a;

    b(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        FaceLockUtil.finalizeFaceLock();
    }
}
