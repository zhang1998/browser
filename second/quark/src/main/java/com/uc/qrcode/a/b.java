package com.uc.qrcode.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.util.Log;
import com.google.zxing.client.android.camera.CameraConfigurationUtils;

/* compiled from: ProGuard */
public final class b {
    public final Context a;
    public int b;
    public int c;
    public Point d;
    public Point e;
    public Point f;
    public Point g;

    b(Context context) {
        this.a = context;
    }

    public final void a(com.uc.qrcode.a.a.b bVar) {
        Camera camera = bVar.a;
        Parameters parameters = camera.getParameters();
        new StringBuilder("Setting preview size: ").append(this.e);
        parameters.setPreviewSize(this.e.x, this.e.y);
        if (Build.MODEL.contains("Behold II") && c.q == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
        CameraConfigurationUtils.setZoom(parameters);
        camera.setDisplayOrientation(this.b);
        camera.setParameters(parameters);
        Size previewSize = parameters.getPreviewSize();
        if (previewSize == null) {
            return;
        }
        if (this.f.x != previewSize.width || this.f.y != previewSize.height) {
            Log.w("CameraConfiguration", "Camera said it supported preview size " + this.f.x + 'x' + this.f.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.f.x = previewSize.width;
            this.f.y = previewSize.height;
        }
    }
}
