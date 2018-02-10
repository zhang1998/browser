package facerecognition.a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        new StringBuilder("initCamera start ").append(this.a);
        if (f.p == ShareConstants.ERROR_LOAD_UNDEFINE) {
            f.p = this.a.getCameraId();
        }
        this.a.k = f.p;
        if (this.a.d == null) {
            this.a.d = Camera.open(this.a.k);
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.a.k, cameraInfo);
        this.a.setCameraInfo(cameraInfo);
        this.a.setCamera(this.a.d);
        this.a.d.setPreviewCallback(this.a);
        new StringBuilder("initCamera end ").append(this.a);
    }
}
