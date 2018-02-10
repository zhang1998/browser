package facerecognition.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ f a;

    c(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        if (this.a.d != null) {
            new StringBuilder("onPause start ").append(this.a);
            try {
                this.a.d.setPreviewCallback(null);
                this.a.d.setPreviewTexture(null);
                this.a.d.stopPreview();
            } catch (Throwable th) {
            }
            this.a.d.release();
            this.a.d = null;
            new StringBuilder("onPause end ").append(this.a);
        }
    }
}
