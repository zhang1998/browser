package facerecognition.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.imagecodec.export.IPictureView;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class f extends FrameLayout implements PreviewCallback, SurfaceTextureListener {
    private static List<Size> c = null;
    private static int p = ShareConstants.ERROR_LOAD_UNDEFINE;
    private TextureView a;
    private SurfaceTexture b;
    private Camera d;
    private CameraInfo e;
    private Parameters f = null;
    private final Object g = new Object();
    private List<Area> h;
    private Size i;
    private int j;
    private int k;
    private WindowManager l;
    private d m;
    private Point n = new Point();
    private boolean o = true;
    private Runnable q = new g(this);

    public f(Context context, d dVar) {
        super(context);
        this.m = dVar;
        this.l = (WindowManager) getContext().getSystemService("window");
        this.a = new TextureView(getContext());
        this.a.setSurfaceTextureListener(this);
        this.h = new ArrayList();
        this.h.add(new Area(new Rect(-200, -200, 200, 200), 1));
        addView(this.a);
        b();
    }

    public final void a() {
        this.o = false;
        new StringBuilder("onPause UI ").append(this);
        m.c(this.q);
        m.a(1, new c(this));
    }

    public final void b() {
        this.o = true;
        m.a(1, this.q, new a(this));
    }

    private Parameters getCameraParameters() {
        if (this.d != null && this.f == null) {
            this.f = this.d.getParameters();
        }
        return this.f;
    }

    private Size getOptimalPreviewSize$27c31c97() {
        e();
        for (Size size : c) {
            if (size.width == 480 && size.height == 640) {
                return size;
            }
            if (size.width == 640 && size.height == 480) {
                return size;
            }
        }
        return null;
    }

    private boolean e() {
        int i = getResources().getConfiguration().orientation;
        if (i != 1 && i == 2) {
            return false;
        }
        return true;
    }

    public final int getPreviewRotation() {
        return this.j;
    }

    private void f() {
        m.a(0, new e(this));
    }

    private int getCameraId() {
        int i = 0;
        CameraInfo cameraInfo = new CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                i = i2;
            }
        }
        return i;
    }

    private void setCamera(Camera camera) {
        new StringBuilder("setCamera inner ").append(this);
        synchronized (this.g) {
            if (camera != null) {
                this.d = camera;
                if (c == null) {
                    c = getCameraParameters().getSupportedPreviewSizes();
                }
                if (this.b != null) {
                    f();
                }
            }
        }
    }

    public final void c() {
        this.o = false;
        if (this.m != null) {
            this.m.c();
        }
        m.a(0, new b(this));
    }

    private void setCameraInfo(CameraInfo cameraInfo) {
        this.e = cameraInfo;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.b = surfaceTexture;
        if (this.d != null) {
            f();
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a();
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.o && this.m != null && !this.m.b() && this.m != null && !this.m.a() && !this.m.b()) {
            this.m.a(bArr, this.i, this.j);
        }
    }

    public final Size getPreviewSize() {
        return this.i;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.d != null) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            new StringBuilder("onLayout width=").append(i5).append("    height=").append(i6);
            if (this.i == null) {
                this.i = getOptimalPreviewSize$27c31c97();
            }
            int i7 = this.i.width;
            int i8 = this.i.height;
            if (!e()) {
                int i9 = i8;
                i8 = i7;
                i7 = i9;
            }
            float f = ((float) i5) / ((float) i8);
            float f2 = ((float) i6) / ((float) i7);
            Matrix matrix = new Matrix();
            if (f2 > f) {
                matrix.setScale((((float) i8) * ((float) i6)) / ((float) (i7 * i5)), IPictureView.DEFAULT_MIN_SCALE);
            } else {
                matrix.setScale(IPictureView.DEFAULT_MIN_SCALE, (((float) i7) * ((float) i5)) / ((float) (i8 * i6)));
            }
            this.a.layout(0, 0, i5, i6);
            this.a.setTransform(matrix);
        }
    }

    static /* synthetic */ void d(f fVar) {
        int i;
        switch (fVar.l.getDefaultDisplay().getRotation()) {
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
                i = 0;
                break;
        }
        i = (i + fVar.e.orientation) % 360;
        if (fVar.e.facing == 1) {
            i = (360 - i) % 360;
        }
        fVar.d.setDisplayOrientation(i);
        fVar.j = i / 90;
        Parameters cameraParameters = fVar.getCameraParameters();
        fVar.i = cameraParameters.getPictureSize();
        try {
            fVar.n.x = 640;
            fVar.n.y = 480;
            fVar.i.width = fVar.n.x;
            fVar.i.height = fVar.n.y;
            new StringBuilder("Setting preview size: ").append(fVar.n);
            cameraParameters.setPreviewSize(fVar.n.x, fVar.n.y);
        } catch (Exception e) {
        }
        if (cameraParameters.getMaxNumMeteringAreas() > 0) {
            cameraParameters.setMeteringAreas(fVar.h);
        }
        fVar.d.setParameters(cameraParameters);
        fVar.d.startPreview();
    }
}
