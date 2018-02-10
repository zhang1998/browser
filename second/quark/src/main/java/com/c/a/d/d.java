package com.c.a.d;

import android.graphics.RectF;
import com.uc.imagecodec.export.IPictureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
public final class d extends c {
    float c;
    boolean d;
    RectF e;
    float f = IPictureView.DEFAULT_MIN_SCALE;
    float[] g;

    public d(RectF rectF, float f, boolean z) {
        this.e = rectF;
        this.c = f;
        this.d = z;
    }

    public final void b(com.c.a.d dVar, int i) {
        if (super.b(i) != null) {
            if (i == 0) {
                float width = this.e.width() / this.e.height();
                if (width != this.f) {
                    int length = this.g.length;
                    float[] fArr = new float[length];
                    for (int i2 = 0; i2 < length; i2 += 2) {
                        fArr[i2] = ((this.g[i2] - 0.5f) / width) + 0.5f;
                        fArr[i2 + 1] = this.g[i2 + 1];
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length * 4);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                    asFloatBuffer.put(fArr);
                    asFloatBuffer.position(0);
                    b(0, asFloatBuffer);
                    b(1, asFloatBuffer);
                    this.f = width;
                }
            }
            super.b(dVar, i);
        }
    }

    protected final void a() {
        float f = this.c / 360.0f;
        int i = ((int) (75.0f * f)) + 1;
        int i2 = i * 151;
        float[] fArr = new float[(i2 * 3)];
        float[] fArr2 = new float[(i2 * 2)];
        short[] sArr = new short[(i2 * 6)];
        i2 = this.d ? 1 : -1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; short s = (short) (i5 + 1)) {
            int i6;
            for (i6 = 0; i6 < 151; i6 = (short) (i6 + 1)) {
                float cos = ((float) (Math.cos((double) ((6.2831855f * ((float) i6)) * 0.006666667f)) * Math.sin((double) ((3.1415927f * ((float) i5)) * 0.013333334f)))) * ((float) i2);
                float sin = ((float) Math.sin((double) (-1.5707964f + ((3.1415927f * ((float) i5)) * 0.013333334f)))) * ((float) (-i2));
                float sin2 = (float) (Math.sin((double) ((6.2831855f * ((float) i6)) * 0.006666667f)) * Math.sin((double) ((3.1415927f * ((float) i5)) * 0.013333334f)));
                float cos2 = (((float) (((Math.cos((double) ((6.2831855f * ((float) i6)) * 0.006666667f)) * ((double) i5)) * 0.013333333656191826d) / ((double) f))) / 2.0f) + 0.5f;
                int i7 = i3 + 1;
                fArr2[i3] = (((float) (((Math.sin((double) ((6.2831855f * ((float) i6)) * 0.006666667f)) * ((double) i5)) * 0.013333333656191826d) / ((double) f))) / 2.0f) + 0.5f;
                i3 = i7 + 1;
                fArr2[i7] = cos2;
                int i8 = i4 + 1;
                fArr[i4] = cos * 18.0f;
                int i9 = i8 + 1;
                fArr[i8] = 18.0f * sin;
                i4 = i9 + 1;
                fArr[i9] = 18.0f * sin2;
            }
        }
        i2 = 0;
        for (i3 = 0; i3 < i - 1; short s2 = (short) (i3 + 1)) {
            for (i4 = 0; i4 < 150; i4 = (short) (i4 + 1)) {
                i6 = i2 + 1;
                sArr[i2] = (short) ((i3 * 151) + i4);
                i2 = i6 + 1;
                sArr[i6] = (short) (((i3 + 1) * 151) + i4);
                i6 = i2 + 1;
                sArr[i2] = (short) ((i3 * 151) + (i4 + 1));
                i2 = i6 + 1;
                sArr[i6] = (short) ((i3 * 151) + (i4 + 1));
                i6 = i2 + 1;
                sArr[i2] = (short) (((i3 + 1) * 151) + i4);
                i2 = i6 + 1;
                sArr[i6] = (short) (((i3 + 1) * 151) + (i4 + 1));
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr2.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.a = asShortBuffer;
        b(0, asFloatBuffer2);
        b(1, asFloatBuffer2);
        a(0, asFloatBuffer);
        a(1, asFloatBuffer);
        this.b = sArr.length;
        this.g = fArr2;
    }
}
