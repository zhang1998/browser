package com.c.a.d;

import android.opengl.GLES20;
import android.util.SparseArray;
import com.c.a.d;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: ProGuard */
public abstract class c {
    public ShortBuffer a;
    public int b;
    private SparseArray<FloatBuffer> c = new SparseArray(2);
    private SparseArray<FloatBuffer> d = new SparseArray(2);

    public abstract void a();

    public void a(d dVar, int i) {
        Buffer a = a(i);
        if (a != null) {
            a.position(0);
            int i2 = dVar.d;
            GLES20.glVertexAttribPointer(i2, 3, 5126, false, 0, a);
            GLES20.glEnableVertexAttribArray(i2);
        }
    }

    public void b(d dVar, int i) {
        Buffer b = b(i);
        if (b != null) {
            b.position(0);
            int i2 = dVar.e;
            GLES20.glVertexAttribPointer(i2, 2, 5126, false, 0, b);
            GLES20.glEnableVertexAttribArray(i2);
        }
    }

    public final FloatBuffer a(int i) {
        return (FloatBuffer) this.d.get(i);
    }

    public final void a(int i, FloatBuffer floatBuffer) {
        this.d.put(i, floatBuffer);
    }

    public FloatBuffer b(int i) {
        return (FloatBuffer) this.c.get(i);
    }

    public final void b(int i, FloatBuffer floatBuffer) {
        this.c.put(i, floatBuffer);
    }

    public final void b() {
        if (this.a != null) {
            this.a.position(0);
            GLES20.glDrawElements(4, this.b, 5123, this.a);
            return;
        }
        GLES20.glDrawArrays(4, 0, this.b);
    }
}
