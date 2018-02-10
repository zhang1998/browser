package com.c.a.f;

import com.c.a.d.c;
import com.c.a.e.a;
import com.uc.imagecodec.export.IPictureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
final class f extends c {
    final /* synthetic */ j c;
    private final int d;
    private final float e;

    public f(j jVar, float f, int i) {
        this.c = jVar;
        this.e = f;
        this.d = i;
    }

    protected final void a() {
        int i;
        float[] fArr = new float[867];
        float[] fArr2 = new float[578];
        float[] fArr3 = new float[578];
        short[] sArr = new short[1734];
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < 17; short s = (short) (i + 1)) {
            int i4;
            for (i4 = 0; i4 < 17; i4 = (short) (i4 + 1)) {
                int i5 = i3 + 1;
                fArr[i3] = ((((float) i4) * 0.0625f) * 2.0f) - IPictureView.DEFAULT_MIN_SCALE;
                int i6 = i5 + 1;
                fArr[i5] = ((((float) i) * 0.0625f) * 2.0f) - IPictureView.DEFAULT_MIN_SCALE;
                i3 = i6 + 1;
                fArr[i6] = -8.0f;
                float f = 3.1415927f * ((((float) i4) * 0.0625f) - 0.5f);
                float f2 = 3.1415927f * ((((float) i) * 0.0625f) - 0.5f);
                float cos = (float) (Math.cos((double) f2) * Math.sin((double) f));
                f = (float) (Math.cos((double) f2) * Math.cos((double) f));
                f2 = (float) Math.sin((double) f2);
                float atan2 = (float) Math.atan2((double) f2, (double) cos);
                f = (((float) Math.atan2(Math.sqrt((double) ((f2 * f2) + (cos * cos))), (double) f)) * this.e) / 3.1415927f;
                f2 = (float) (0.5d + (((double) f) * Math.cos((double) atan2)));
                f = (float) ((Math.sin((double) atan2) * ((double) f)) + 0.5d);
                if (this.d == a.a) {
                    fArr2[i2 * 2] = 0.5f * f2;
                    fArr2[(i2 * 2) + 1] = f;
                    fArr3[i2 * 2] = (f2 * 0.5f) + 0.5f;
                    fArr3[(i2 * 2) + 1] = f;
                } else {
                    fArr2[i2 * 2] = f2;
                    fArr2[(i2 * 2) + 1] = 0.5f * f;
                    fArr3[i2 * 2] = f2;
                    fArr3[(i2 * 2) + 1] = (f * 0.5f) + 0.5f;
                }
                i2++;
            }
        }
        i2 = 0;
        for (i4 = 0; i4 < 16; short s2 = (short) (i4 + 1)) {
            for (i3 = 0; i3 < 16; i3 = (short) (i3 + 1)) {
                short s3 = (short) (((i4 + 1) * 17) + i3);
                short s4 = (short) ((i4 * 17) + i3);
                short s5 = (short) ((i4 * 17) + (i3 + 1));
                short s6 = (short) (((i4 + 1) * 17) + (i3 + 1));
                short s7 = (short) (((i4 + 1) * 17) + i3);
                int i7 = i2 + 1;
                sArr[i2] = (short) ((i4 * 17) + (i3 + 1));
                i2 = i7 + 1;
                sArr[i7] = s3;
                i = i2 + 1;
                sArr[i2] = s4;
                i2 = i + 1;
                sArr[i] = s5;
                i = i2 + 1;
                sArr[i2] = s6;
                i2 = i + 1;
                sArr[i] = s7;
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3468);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(2312);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(2312);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
        asFloatBuffer3.put(fArr3);
        asFloatBuffer3.position(0);
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(3468);
        allocateDirect4.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect4.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.a = asShortBuffer;
        b(0, asFloatBuffer2);
        b(1, asFloatBuffer3);
        a(0, asFloatBuffer);
        a(1, asFloatBuffer);
        this.b = 1734;
    }
}
