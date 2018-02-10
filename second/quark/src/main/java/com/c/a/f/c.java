package com.c.a.f;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.c.a.e.d;

/* compiled from: ProGuard */
public final class c {
    int a;
    private int b;
    private int c;
    private Rect d = new Rect();
    private int[] e = new int[1];

    public final void a(int i, int i2) {
        if (!(this.d.width() == i && this.d.height() == i2)) {
            if (this.a != 0) {
                GLES20.glDeleteTextures(1, new int[]{this.a}, 0);
            }
            if (this.c != 0) {
                GLES20.glDeleteRenderbuffers(1, new int[]{this.c}, 0);
            }
            if (this.b != 0) {
                GLES20.glDeleteFramebuffers(1, new int[]{this.b}, 0);
            }
            GLES20.glGetIntegerv(36006, this.e, 0);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            this.b = iArr[0];
            d.a("Multi Fish Eye frame buffer");
            int[] iArr2 = new int[]{0};
            GLES20.glGenRenderbuffers(1, iArr2, 0);
            GLES20.glBindRenderbuffer(36161, iArr2[0]);
            GLES20.glRenderbufferStorage(36161, 33189, i, i2);
            this.c = iArr2[0];
            d.a("Multi Fish Eye renderer buffer");
            int[] iArr3 = new int[]{0};
            GLES20.glGenTextures(1, iArr3, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, iArr3[0]);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            this.a = iArr3[0];
            d.a("Multi Fish Eye texture");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.a, 0);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr2[0]);
            d.a("Multi Fish Eye attach");
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus != 36053) {
                String valueOf = String.valueOf(Integer.toHexString(glCheckFramebufferStatus));
                throw new RuntimeException(valueOf.length() != 0 ? "Framebuffer is not complete: ".concat(valueOf) : "Framebuffer is not complete: ");
            }
            GLES20.glBindFramebuffer(36160, this.e[0]);
            d.a("Multi Fish Eye attach");
            this.d.set(0, 0, i, i2);
        }
        GLES20.glGetIntegerv(36006, this.e, 0);
        GLES20.glBindFramebuffer(36160, this.b);
    }

    public final void a() {
        GLES20.glBindFramebuffer(36160, this.e[0]);
    }
}
