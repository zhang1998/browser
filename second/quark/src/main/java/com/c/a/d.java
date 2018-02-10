package com.c.a;

import android.opengl.GLES20;
import com.c.a.d.f;

/* compiled from: ProGuard */
public final class d {
    private static boolean h = true;
    int a;
    public int b;
    public int c;
    public int d;
    public int e;
    private int f;
    private int g;

    public d(int i) {
        this.g = i;
    }

    private static void a(String str) {
        if (h && GLES20.glGetError() != 0) {
            throw new RuntimeException(str + String.format("; GLError: %x", new Object[]{Integer.valueOf(r0)}));
        }
    }

    public final void a() {
        int i;
        switch (this.g) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 3;
                break;
            default:
                throw new RuntimeException("undefined content type");
        }
        String a = f.a(i);
        switch (this.g) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            default:
                throw new RuntimeException("undefined content type");
        }
        String a2 = f.a(i);
        a("before program build");
        int a3 = com.c.a.e.d.a(35633, a);
        a("after compile vertex shader");
        i = com.c.a.e.d.a(35632, a2);
        a("after compile fragment shader");
        this.f = com.c.a.e.d.a(a3, i, new String[]{"a_Position", "a_TexCoordinate"});
        a("after link program");
        this.a = GLES20.glGetUniformLocation(this.f, "u_MVPMatrix");
        a("after get MVPMatrix");
        this.c = GLES20.glGetUniformLocation(this.f, "mainTextureTransform");
        a("after get mainTextureTransform");
        this.b = GLES20.glGetUniformLocation(this.f, "u_Texture");
        a("after get TextureUniformHandle");
        this.d = GLES20.glGetAttribLocation(this.f, "a_Position");
        a("after get mPositionHandle");
        this.e = GLES20.glGetAttribLocation(this.f, "a_TexCoordinate");
        a("after get mTextureCoordinateHandle");
    }

    public final void b() {
        GLES20.glUseProgram(this.f);
        a("use program");
    }
}
