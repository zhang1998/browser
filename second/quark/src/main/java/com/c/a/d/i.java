package com.c.a.d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
public final class i extends c {
    protected final void a() {
        int i;
        float[] fArr = new float[34428];
        float[] fArr2 = new float[22952];
        float[] fArr3 = new float[22952];
        short[] sArr = new short[68856];
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < 76; short s = (short) (i + 1)) {
            int i4;
            for (i4 = 0; i4 < 151; i4 = (short) (i4 + 1)) {
                float cos = (float) (Math.cos((double) ((6.2831855f * ((float) i4)) * 0.006666667f)) * Math.sin((double) ((3.1415927f * ((float) i)) * 0.013333334f)));
                float f = -((float) Math.sin((double) (-1.5707964f + ((3.1415927f * ((float) i)) * 0.013333334f))));
                float sin = (float) (Math.sin((double) ((6.2831855f * ((float) i4)) * 0.006666667f)) * Math.sin((double) ((3.1415927f * ((float) i)) * 0.013333334f)));
                fArr2[i2] = ((float) i4) * 0.006666667f;
                i2++;
                fArr2[i2] = ((float) i) * 0.013333334f;
                fArr3[i2] = ((((float) i) * 0.013333334f) / 2.0f) + 0.5f;
                i2++;
                int i5 = i3 + 1;
                fArr[i3] = cos * 18.0f;
                int i6 = i5 + 1;
                fArr[i5] = 18.0f * f;
                i3 = i6 + 1;
                fArr[i6] = 18.0f * sin;
            }
        }
        i3 = 0;
        for (i4 = 0; i4 < 75; short s2 = (short) (i4 + 1)) {
            for (i2 = 0; i2 < 150; i2 = (short) (i2 + 1)) {
                i = i3 + 1;
                sArr[i3] = (short) ((i4 * 151) + i2);
                i3 = i + 1;
                sArr[i] = (short) (((i4 + 1) * 151) + i2);
                i = i3 + 1;
                sArr[i3] = (short) ((i4 * 151) + (i2 + 1));
                i3 = i + 1;
                sArr[i] = (short) ((i4 * 151) + (i2 + 1));
                i = i3 + 1;
                sArr[i3] = (short) (((i4 + 1) * 151) + i2);
                i3 = i + 1;
                sArr[i] = (short) (((i4 + 1) * 151) + (i2 + 1));
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
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(137712);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.a = asShortBuffer;
        b(0, asFloatBuffer2);
        b(1, asFloatBuffer2);
        a(0, asFloatBuffer);
        a(1, asFloatBuffer);
        this.b = 68856;
    }
}
