package com.uc.qrcode.a.a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;

/* compiled from: ProGuard */
public final class c {
    private static final String a = c.class.getName();

    private c() {
    }

    public static b a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(a, "No cameras!");
            return null;
        }
        CameraInfo cameraInfo;
        int i2;
        Camera open;
        int i3 = i >= 0 ? 1 : 0;
        if (i3 != 0) {
            cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            i2 = i;
        } else {
            int i4 = 0;
            while (i4 < numberOfCameras) {
                cameraInfo = new CameraInfo();
                Camera.getCameraInfo(i4, cameraInfo);
                if (a.values()[cameraInfo.facing] == a.BACK) {
                    i2 = i4;
                    break;
                }
                i4++;
            }
            i2 = i4;
            cameraInfo = null;
        }
        if (i2 < numberOfCameras) {
            open = Camera.open(i2);
        } else if (i3 != 0) {
            Log.w(a, "Requested camera does not exist: " + i);
            open = null;
        } else {
            new StringBuilder("No camera facing ").append(a.BACK).append("; returning camera #0");
            open = Camera.open(0);
            cameraInfo = new CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
        }
        if (open != null) {
            return new b(i2, open, a.values()[cameraInfo.facing], cameraInfo.orientation);
        }
        return null;
    }
}
