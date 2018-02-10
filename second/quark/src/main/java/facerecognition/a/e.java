package facerecognition.a;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        try {
            synchronized (this.a.g) {
                if (this.a.d != null) {
                    this.a.d.setPreviewTexture(this.a.a.getSurfaceTexture());
                    f.d(this.a);
                }
            }
        } catch (Throwable th) {
        }
    }
}
