package com.c.a.d;

import android.graphics.RectF;
import com.c.a.b.c.c;
import com.c.a.d;
import com.uc.imagecodec.export.IPictureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
public final class g extends c {
    private float c;
    private RectF d;
    private c e;

    private g(c cVar, RectF rectF) {
        this.e = cVar;
        this.d = rectF;
    }

    public g(c cVar) {
        this(cVar, new RectF(0.0f, 0.0f, IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE));
    }

    protected final void a() {
        float[] c = c();
        float[] fArr = new float[8];
        int i = 0;
        for (int i2 = 0; i2 < 2; short s = (short) (i2 + 1)) {
            for (int i3 = 0; i3 < 2; i3 = (short) (i3 + 1)) {
                int i4 = i + 1;
                fArr[i] = ((float) i3) * IPictureView.DEFAULT_MIN_SCALE;
                i = i4 + 1;
                fArr[i4] = IPictureView.DEFAULT_MIN_SCALE - (((float) i2) * IPictureView.DEFAULT_MIN_SCALE);
            }
        }
        short[] sArr = new short[24];
        for (short s2 = (short) 0; s2 <= (short) 0; s2 = (short) 1) {
            for (s2 = (short) 0; s2 <= (short) 0; s2 = (short) 1) {
                sArr[0] = (short) 1;
                sArr[1] = (short) 2;
                sArr[2] = (short) 0;
                sArr[3] = (short) 1;
                sArr[4] = (short) 3;
                sArr[5] = (short) 2;
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(48);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(c);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(48);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.a = asShortBuffer;
        b(0, asFloatBuffer2);
        b(1, asFloatBuffer2);
        a(0, asFloatBuffer);
        a(1, asFloatBuffer);
        this.b = 24;
    }

    public final void a(d dVar, int i) {
        if (super.a(i) != null) {
            if (i == 0) {
                float a = this.e.a();
                if (a != this.c) {
                    float[] c = c();
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(48);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                    asFloatBuffer.put(c);
                    asFloatBuffer.position(0);
                    a(0, asFloatBuffer);
                    a(1, asFloatBuffer);
                    this.c = a;
                }
            }
            super.a(dVar, i);
        }
    }

    private float[] c() {
        this.e.b();
        this.c = this.e.a();
        float width = this.e.d * this.d.width();
        float height = this.e.e * this.d.height();
        float[] fArr = new float[12];
        int i = 0;
        for (int i2 = 0; i2 < 2; short s = (short) (i2 + 1)) {
            for (int i3 = 0; i3 < 2; i3 = (short) (i3 + 1)) {
                int i4 = i + 1;
                fArr[i] = ((((float) i3) * IPictureView.DEFAULT_MIN_SCALE) - 0.5f) * width;
                int i5 = i4 + 1;
                fArr[i4] = ((((float) i2) * IPictureView.DEFAULT_MIN_SCALE) - 0.5f) * height;
                i = i5 + 1;
                fArr[i5] = 0.0f;
            }
        }
        return fArr;
    }
}
