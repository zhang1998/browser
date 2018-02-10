package com.c.a.f;

import android.graphics.PointF;
import com.c.a.d.c;
import com.c.a.e.f;
import com.uc.apollo.media.MediaDefines;
import com.uc.imagecodec.export.IPictureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
final class i extends c {
    int c;
    final /* synthetic */ e d;
    private FloatBuffer e;

    public i(e eVar) {
        this.d = eVar;
    }

    public final FloatBuffer b(int i) {
        if (this.c == 1) {
            return this.e;
        }
        if (this.c == 2) {
            return super.b(i);
        }
        return null;
    }

    protected final void a() {
        short s;
        float[] fArr = new float[363];
        float[] fArr2 = new float[242];
        float[] fArr3 = new float[242];
        float[] fArr4 = new float[242];
        short[] sArr = new short[726];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 11; s = (short) (i3 + 1)) {
            int i4 = 0;
            while (i4 < 11) {
                int i5 = i + 1;
                int i6 = i5 + 1;
                fArr2[i] = ((float) i4) * 0.1f;
                fArr2[i5] = ((float) i3) * 0.1f;
                fArr3[i] = (((float) i4) * 0.1f) * 0.5f;
                fArr3[i5] = ((float) i3) * 0.1f;
                fArr4[i] = ((((float) i4) * 0.1f) * 0.5f) + 0.5f;
                fArr4[i5] = ((float) i3) * 0.1f;
                i = i2 + 1;
                fArr[i2] = ((((float) i4) * 0.1f) * 2.0f) - IPictureView.DEFAULT_MIN_SCALE;
                i5 = i + 1;
                fArr[i] = ((((float) i3) * 0.1f) * 2.0f) - IPictureView.DEFAULT_MIN_SCALE;
                i2 = i5 + 1;
                fArr[i5] = -8.0f;
                short s2 = (short) (i4 + 1);
                i = i6;
            }
        }
        PointF pointF = new PointF();
        for (int i7 = 0; i7 < MediaDefines.MSG_DISABLE_VR_SENSOR; i7++) {
            int i8 = i7 * 3;
            int i9 = (i7 * 3) + 1;
            pointF.set(fArr[i8], fArr[i9]);
            f.a(this.d.a.a, this.d.a.b, this.d.a.c, pointF);
            fArr[i8] = pointF.x * this.d.a.d;
            fArr[i9] = pointF.y * this.d.a.d;
        }
        i2 = 0;
        for (i = 0; i < 10; i = (short) (i + 1)) {
            for (i6 = 0; i6 < 10; i6 = (short) (i6 + 1)) {
                s = (short) (((i + 1) * 11) + i6);
                short s3 = (short) ((i * 11) + i6);
                short s4 = (short) ((i * 11) + (i6 + 1));
                short s5 = (short) (((i + 1) * 11) + (i6 + 1));
                short s6 = (short) (((i + 1) * 11) + i6);
                i9 = i2 + 1;
                sArr[i2] = (short) ((i * 11) + (i6 + 1));
                i2 = i9 + 1;
                sArr[i9] = s;
                i4 = i2 + 1;
                sArr[i2] = s3;
                i2 = i4 + 1;
                sArr[i4] = s4;
                i4 = i2 + 1;
                sArr[i2] = s5;
                i2 = i4 + 1;
                sArr[i4] = s6;
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1452);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(968);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(968);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
        asFloatBuffer3.put(fArr3);
        asFloatBuffer3.position(0);
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(968);
        allocateDirect4.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer4 = allocateDirect4.asFloatBuffer();
        asFloatBuffer4.put(fArr4);
        asFloatBuffer4.position(0);
        ByteBuffer allocateDirect5 = ByteBuffer.allocateDirect(1452);
        allocateDirect5.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect5.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.a = asShortBuffer;
        b(0, asFloatBuffer3);
        b(1, asFloatBuffer4);
        a(0, asFloatBuffer);
        a(1, asFloatBuffer);
        this.b = 726;
        this.e = asFloatBuffer2;
    }
}
