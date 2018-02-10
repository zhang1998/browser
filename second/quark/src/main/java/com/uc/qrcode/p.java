package com.uc.qrcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.zxing.client.android.camera.CameraConfigurationUtils;
import com.uc.qrcode.a.a.a;
import com.uc.qrcode.a.a.b;
import com.uc.qrcode.a.c;
import java.io.IOException;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ SurfaceHolder a;
    final /* synthetic */ t b;

    p(t tVar, SurfaceHolder surfaceHolder) {
        this.b = tVar;
        this.a = surfaceHolder;
    }

    public final void run() {
        try {
            c a = this.b.g;
            SurfaceHolder surfaceHolder = this.a;
            synchronized (a.b) {
                b bVar = a.d;
                if (bVar == null) {
                    bVar = com.uc.qrcode.a.a.c.a(a.i);
                    if (bVar == null) {
                        throw new IOException("Camera.open() failed to return object from driver");
                    }
                    a.d = bVar;
                }
                b bVar2 = bVar;
                if (!a.g) {
                    int i;
                    Object obj;
                    a.g = true;
                    com.uc.qrcode.a.b bVar3 = a.c;
                    Parameters parameters = bVar2.a.getParameters();
                    Display defaultDisplay = ((WindowManager) bVar3.a.getSystemService("window")).getDefaultDisplay();
                    int rotation = defaultDisplay.getRotation();
                    switch (rotation) {
                        case 0:
                            i = 0;
                            break;
                        case 1:
                            i = 90;
                            break;
                        case 2:
                            i = 180;
                            break;
                        case 3:
                            i = 270;
                            break;
                        default:
                            if (rotation % 90 == 0) {
                                i = (rotation + 360) % 360;
                                break;
                            }
                            throw new IllegalArgumentException("Bad rotation: " + rotation);
                    }
                    rotation = bVar2.c;
                    if (bVar2.b == a.FRONT) {
                        rotation = (360 - rotation) % 360;
                    }
                    bVar3.c = ((rotation + 360) - i) % 360;
                    new StringBuilder("Final display orientation: ").append(bVar3.c);
                    if (bVar2.b == a.FRONT) {
                        bVar3.b = (360 - bVar3.c) % 360;
                    } else {
                        bVar3.b = bVar3.c;
                    }
                    new StringBuilder("Clockwise rotation from display to camera: ").append(bVar3.b);
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    bVar3.d = point;
                    new StringBuilder("Screen resolution in current orientation: ").append(bVar3.d);
                    bVar3.e = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, bVar3.d);
                    new StringBuilder("Camera resolution: ").append(bVar3.e);
                    bVar3.f = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, bVar3.d);
                    new StringBuilder("Best available preview size: ").append(bVar3.f);
                    Object obj2 = bVar3.d.x < bVar3.d.y ? 1 : null;
                    if (bVar3.f.x < bVar3.f.y) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj2 == obj) {
                        bVar3.g = bVar3.f;
                    } else {
                        bVar3.g = new Point(bVar3.f.y, bVar3.f.x);
                    }
                    new StringBuilder("Preview size on screen: ").append(bVar3.g);
                    if (a.j > 0 && a.k > 0) {
                        int i2 = a.j;
                        rotation = a.k;
                        synchronized (a.b) {
                            if (a.g) {
                                Point point2 = a.c.d;
                                if (i2 > point2.x) {
                                    i2 = point2.x;
                                }
                                if (rotation > point2.y) {
                                    rotation = point2.y;
                                }
                                int i3 = (point2.x - i2) / 2;
                                i = (point2.y - rotation) / 2;
                                a.e = new Rect(i3, i, i2 + i3, rotation + i);
                                new StringBuilder("Calculated manual framing rect: ").append(a.e);
                                a.f = null;
                            } else {
                                a.j = i2;
                                a.k = rotation;
                            }
                        }
                        a.j = 0;
                        a.k = 0;
                    }
                }
                Camera camera = bVar2.a;
                Parameters parameters2 = camera.getParameters();
                String flatten = parameters2 == null ? null : parameters2.flatten();
                try {
                    a.c.a(bVar2);
                } catch (RuntimeException e) {
                    Log.w(c.a, "Camera rejected parameters. Setting only minimal safe-mode parameters");
                    if (flatten != null) {
                        Parameters parameters3 = camera.getParameters();
                        parameters3.unflatten(flatten);
                        try {
                            camera.setParameters(parameters3);
                            a.c.a(bVar2);
                        } catch (RuntimeException e2) {
                            Log.w(c.a, "Camera rejected even safe-mode parameters! No configuration");
                        }
                    }
                }
                camera.setPreviewDisplay(surfaceHolder);
            }
        } catch (Throwable e3) {
            Log.w(t.f, e3);
            t.e();
        } catch (Throwable e32) {
            Log.w(t.f, "Unexpected error initializing camera", e32);
            t.e();
        }
    }
}
