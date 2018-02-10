package com.c.a.d;

import com.c.a.e.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
public final class h extends c {
    private int c = a.a;

    public h(int i) {
        this.c = i;
    }

    protected final void a() {
        int i;
        int i2 = this.c;
        float[] fArr = new float[34428];
        float[] fArr2 = new float[22952];
        float[] fArr3 = new float[22952];
        short[] sArr = new short[68856];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < 76) {
            int i6 = i4;
            i4 = i3;
            i3 = i6;
            for (i = 0; i < 151; i = (short) (i + 1)) {
                float cos = (float) (Math.cos((double) ((6.2831855f * ((float) i)) * 0.006666667f)) * Math.sin((double) ((3.1415927f * ((float) i5)) * 0.013333334f)));
                float f = -((float) Math.sin((double) (-1.5707964f + ((3.1415927f * ((float) i5)) * 0.013333334f))));
                float sin = (float) (Math.sin((double) ((6.2831855f * ((float) i)) * 0.006666667f)) * Math.sin((double) ((3.1415927f * ((float) i5)) * 0.013333334f)));
                if (a.b == i2) {
                    fArr2[i4] = ((float) i) * 0.006666667f;
                    fArr3[i4] = ((float) i) * 0.006666667f;
                    i4++;
                    fArr2[i4] = (((float) i5) * 0.013333334f) / 2.0f;
                    fArr3[i4] = ((((float) i5) * 0.013333334f) / 2.0f) + 0.5f;
                    i4++;
                } else {
                    fArr2[i4] = (((float) i) * 0.006666667f) / 2.0f;
                    fArr3[i4] = ((((float) i) * 0.006666667f) / 2.0f) + 0.5f;
                    i4++;
                    fArr2[i4] = ((float) i5) * 0.013333334f;
                    fArr3[i4] = ((float) i5) * 0.013333334f;
                    i4++;
                }
                int i7 = i3 + 1;
                fArr[i3] = cos * 18.0f;
                int i8 = i7 + 1;
                fArr[i7] = 18.0f * f;
                i3 = i8 + 1;
                fArr[i8] = 18.0f * sin;
            }
            short s = (short) (i5 + 1);
            i6 = i4;
            i4 = i3;
            i3 = i6;
        }
        i3 = 0;
        for (i = 0; i < 75; short s2 = (short) (i + 1)) {
            for (i4 = 0; i4 < 150; i4 = (short) (i4 + 1)) {
                i5 = i3 + 1;
                sArr[i3] = (short) ((i * 151) + i4);
                i3 = i5 + 1;
                sArr[i5] = (short) (((i + 1) * 151) + i4);
                i5 = i3 + 1;
                sArr[i3] = (short) ((i * 151) + (i4 + 1));
                i3 = i5 + 1;
                sArr[i5] = (short) ((i * 151) + (i4 + 1));
                i5 = i3 + 1;
                sArr[i3] = (short) (((i + 1) * 151) + i4);
                i3 = i5 + 1;
                sArr[i5] = (short) (((i + 1) * 151) + (i4 + 1));
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(137712);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(91808);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(91808);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
        asFloatBuffer3.put(fArr3);
        asFloatBuffer3.position(0);
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(137712);
        allocateDirect4.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect4.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.a = asShortBuffer;
        b(0, asFloatBuffer2);
        b(1, asFloatBuffer3);
        a(0, asFloatBuffer);
        a(1, asFloatBuffer);
        this.b = 68856;
    }
}
