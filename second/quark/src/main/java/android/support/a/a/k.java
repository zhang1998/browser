package android.support.a.a;

import android.graphics.Path;
import com.alibaba.wireless.security.SecExceptionCode;

/* compiled from: ProGuard */
class k {
    protected h[] m = null;
    String n;
    int o;

    public k(k kVar) {
        this.n = kVar.n;
        this.o = kVar.o;
        this.m = a.a(kVar.m);
    }

    public final void a(Path path) {
        path.reset();
        if (this.m != null) {
            h[] hVarArr = this.m;
            float[] fArr = new float[6];
            int i = 0;
            char c = 'm';
            while (i < hVarArr.length) {
                int i2;
                char c2 = hVarArr[i].a;
                float[] fArr2 = hVarArr[i].b;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                float f4 = fArr[3];
                float f5 = fArr[4];
                float f6 = fArr[5];
                switch (c2) {
                    case 'A':
                    case 'a':
                        i2 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i2 = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i2 = 1;
                        break;
                    case 'L':
                    case 'M':
                    case 'T':
                    case 'l':
                    case 'm':
                    case 't':
                        i2 = 2;
                        break;
                    case 'Q':
                    case 'S':
                    case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
                    case 's':
                        i2 = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f5, f6);
                        f4 = f6;
                        f3 = f5;
                        f2 = f6;
                        f = f5;
                        i2 = 2;
                        break;
                    default:
                        i2 = 2;
                        break;
                }
                int i3 = 0;
                float f7 = f6;
                float f8 = f5;
                float f9 = f2;
                float f10 = f;
                while (i3 < fArr2.length) {
                    float f11;
                    boolean z;
                    boolean z2;
                    switch (c2) {
                        case 'A':
                            f3 = fArr2[i3 + 5];
                            f5 = fArr2[i3 + 6];
                            f2 = fArr2[i3 + 0];
                            f = fArr2[i3 + 1];
                            f11 = fArr2[i3 + 2];
                            z = fArr2[i3 + 3] != 0.0f;
                            if (fArr2[i3 + 4] != 0.0f) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            h.a(path, f10, f9, f3, f5, f2, f, f11, z, z2);
                            f3 = fArr2[i3 + 5];
                            f4 = fArr2[i3 + 6];
                            f6 = f7;
                            f5 = f8;
                            f2 = f4;
                            f = f3;
                            break;
                        case 'C':
                            path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                            f5 = fArr2[i3 + 4];
                            f6 = fArr2[i3 + 5];
                            f3 = fArr2[i3 + 2];
                            f4 = fArr2[i3 + 3];
                            f2 = f6;
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'H':
                            path.lineTo(fArr2[i3 + 0], f9);
                            f6 = f7;
                            f2 = f9;
                            f = fArr2[i3 + 0];
                            f5 = f8;
                            break;
                        case 'L':
                            path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f5 = fArr2[i3 + 0];
                            f2 = fArr2[i3 + 1];
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'M':
                            f5 = fArr2[i3 + 0];
                            f6 = fArr2[i3 + 1];
                            if (i3 <= 0) {
                                path.moveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                break;
                            }
                            path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f6;
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'Q':
                            path.quadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                            f3 = fArr2[i3 + 0];
                            f4 = fArr2[i3 + 1];
                            f5 = fArr2[i3 + 2];
                            f2 = fArr2[i3 + 3];
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'S':
                            if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                f6 = (2.0f * f9) - f4;
                                f4 = (2.0f * f10) - f3;
                            } else {
                                f6 = f9;
                                f4 = f10;
                            }
                            path.cubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                            f3 = fArr2[i3 + 0];
                            f4 = fArr2[i3 + 1];
                            f5 = fArr2[i3 + 2];
                            f2 = fArr2[i3 + 3];
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'T':
                            if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                f10 = (2.0f * f10) - f3;
                                f9 = (2.0f * f9) - f4;
                            }
                            path.quadTo(f10, f9, fArr2[i3 + 0], fArr2[i3 + 1]);
                            f5 = fArr2[i3 + 0];
                            f4 = f9;
                            f3 = f10;
                            f2 = fArr2[i3 + 1];
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'V':
                            path.lineTo(f10, fArr2[i3 + 0]);
                            f5 = f8;
                            f2 = fArr2[i3 + 0];
                            f = f10;
                            f6 = f7;
                            break;
                        case 'a':
                            f3 = fArr2[i3 + 5] + f10;
                            f5 = fArr2[i3 + 6] + f9;
                            f2 = fArr2[i3 + 0];
                            f = fArr2[i3 + 1];
                            f11 = fArr2[i3 + 2];
                            z = fArr2[i3 + 3] != 0.0f;
                            if (fArr2[i3 + 4] != 0.0f) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            h.a(path, f10, f9, f3, f5, f2, f, f11, z, z2);
                            f3 = f10 + fArr2[i3 + 5];
                            f4 = f9 + fArr2[i3 + 6];
                            f6 = f7;
                            f5 = f8;
                            f2 = f4;
                            f = f3;
                            break;
                        case 'c':
                            path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                            f3 = f10 + fArr2[i3 + 2];
                            f4 = f9 + fArr2[i3 + 3];
                            f2 = f9 + fArr2[i3 + 5];
                            f = f10 + fArr2[i3 + 4];
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'h':
                            path.rLineTo(fArr2[i3 + 0], 0.0f);
                            f6 = f7;
                            f2 = f9;
                            f = f10 + fArr2[i3 + 0];
                            f5 = f8;
                            break;
                        case 'l':
                            path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f9 + fArr2[i3 + 1];
                            f = f10 + fArr2[i3 + 0];
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'm':
                            f5 = f10 + fArr2[i3 + 0];
                            f6 = f9 + fArr2[i3 + 1];
                            if (i3 <= 0) {
                                path.rMoveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                break;
                            }
                            path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f6;
                            f = f5;
                            f6 = f7;
                            f5 = f8;
                            break;
                        case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
                            path.rQuadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                            f3 = f10 + fArr2[i3 + 0];
                            f4 = f9 + fArr2[i3 + 1];
                            f2 = f9 + fArr2[i3 + 3];
                            f = f10 + fArr2[i3 + 2];
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 's':
                            f6 = 0.0f;
                            if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                f6 = f9 - f4;
                                f4 = f10 - f3;
                            } else {
                                f4 = 0.0f;
                            }
                            path.rCubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                            f3 = f10 + fArr2[i3 + 0];
                            f4 = f9 + fArr2[i3 + 1];
                            f2 = f9 + fArr2[i3 + 3];
                            f = f10 + fArr2[i3 + 2];
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 't':
                            float f12;
                            if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                f12 = f9 - f4;
                                f4 = f10 - f3;
                            } else {
                                f12 = 0.0f;
                                f4 = 0.0f;
                            }
                            path.rQuadTo(f4, f12, fArr2[i3 + 0], fArr2[i3 + 1]);
                            f3 = f10 + f4;
                            f4 = f9 + f12;
                            f2 = f9 + fArr2[i3 + 1];
                            f = f10 + fArr2[i3 + 0];
                            f6 = f7;
                            f5 = f8;
                            break;
                        case 'v':
                            path.rLineTo(0.0f, fArr2[i3 + 0]);
                            f5 = f8;
                            f2 = f9 + fArr2[i3 + 0];
                            f = f10;
                            f6 = f7;
                            break;
                        default:
                            f6 = f7;
                            f5 = f8;
                            f2 = f9;
                            f = f10;
                            break;
                    }
                    i3 += i2;
                    f7 = f6;
                    f8 = f5;
                    f9 = f2;
                    f10 = f;
                    c = c2;
                }
                fArr[0] = f10;
                fArr[1] = f9;
                fArr[2] = f3;
                fArr[3] = f4;
                fArr[4] = f8;
                fArr[5] = f7;
                char c3 = hVarArr[i].a;
                i++;
                c = c3;
            }
        }
    }

    public boolean a() {
        return false;
    }
}
