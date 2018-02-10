package com.tencent.tinker.c.b.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.c.a.v;
import com.tencent.tinker.c.b.b.a;
import com.uc.apollo.media.MediaDefines;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public final class f extends e {
    private final h a;
    private final c b;
    private final boolean c = true;

    public f(h hVar, c cVar) {
        super(null);
        this.a = hVar;
        this.b = cVar;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.c) {
            i5 = this.b.a(i5);
        }
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.a.a((short) i2);
                return;
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.a.a(b.a(i2, b.b(0, 0)), (short) i3, b.a(0, 0, 0, 0));
                return;
            case 40:
                byte b;
                if (this.c) {
                    b = i5 - this.a.b;
                    if (b == ((byte) b)) {
                        this.a.a(b.a(i2, b & 255));
                        return;
                    } else if (b != ((short) b)) {
                        this.a.a((short) 42, (short) b, (short) (b >> 16));
                        return;
                    } else {
                        this.a.a((short) 41, (short) b);
                        return;
                    }
                }
                b = i5 - this.a.b;
                if (b != ((byte) b)) {
                    throw new v("Target out of range: " + a.d(b) + ", perhaps you need to enable force jumbo mode.");
                }
                this.a.a(b.a(i2, b & 255));
                return;
            case 41:
                short s;
                if (this.c) {
                    short s2 = i5 - this.a.b;
                    if (s2 != ((short) s2)) {
                        this.a.a((short) 42, (short) s2, (short) (s2 >> 16));
                        return;
                    }
                    s = (short) i2;
                    this.a.a(s, (short) s2);
                    return;
                }
                s = (short) i2;
                this.a.a(s, b.c(i5, this.a.b));
                return;
            case 42:
                int i6 = i5 - this.a.b;
                this.a.a((short) i2, (short) i6, (short) (i6 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.c) {
            i5 = this.b.a(i5);
        }
        int i7;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 29:
            case 30:
            case 39:
                this.a.a(b.a(i2, i6));
                return;
            case 18:
                short s = (short) i2;
                h hVar = this.a;
                if (j < -8 || j > 7) {
                    throw new v("Literal out of range: " + a.a(j));
                }
                hVar.a(b.a(s, b.b(i6, ((int) j) & 15)));
                return;
            case 19:
            case 22:
                this.a.a(b.a(i2, i6), b.a(j));
                return;
            case 20:
            case 23:
                if (j != ((long) ((int) j))) {
                    throw new v("Literal out of range: " + a.a(j));
                }
                i7 = (int) j;
                this.a.a(b.a(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 21:
            case 25:
                this.a.a(b.a(i2, i6), (short) ((int) (j >> (i2 == 21 ? 16 : 48))));
                return;
            case 24:
                h hVar2 = this.a;
                short s2 = (short) ((int) j);
                short s3 = (short) ((int) (j >> 16));
                short s4 = (short) ((int) (j >> 32));
                short s5 = (short) ((int) (j >> 48));
                hVar2.a(b.a(i2, i6));
                hVar2.a(s2);
                hVar2.a(s3);
                hVar2.a(s4);
                hVar2.a(s5);
                return;
            case 26:
                if (this.c) {
                    if (i3 > 65535) {
                        this.a.a(b.a(27, i6), (short) i3, (short) (i3 >> 16));
                        return;
                    } else {
                        this.a.a(b.a(i2, i6), (short) i3);
                        return;
                    }
                } else if (i3 > 65535) {
                    throw new v("string index out of bound: " + a.a(i3) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.a.a(b.a(i2, i6), (short) i3);
                    return;
                }
            case 27:
                this.a.a(b.a(i2, i6), (short) i3, (short) (i3 >> 16));
                return;
            case 28:
            case 31:
            case 34:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                this.a.a(b.a(i2, i6), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.a.a(b.a(i2, b.b(0, 1)), (short) i3, b.a(i6, 0, 0, 0));
                return;
            case 38:
            case 43:
            case 44:
                switch (i2) {
                    case 43:
                    case 44:
                        this.a.a(i5, this.a.b);
                        break;
                }
                i7 = i5 - this.a.b;
                this.a.a(b.a(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                this.a.a(b.a(i2, i6), b.c(i5, this.a.b));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.c) {
            i5 = this.b.a(i5);
        }
        switch (i2) {
            case 1:
            case 4:
            case 7:
            case 33:
            case 123:
            case 124:
            case 125:
            case 126:
            case UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK /*127*/:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR /*199*/:
            case 200:
            case 201:
            case 202:
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE /*203*/:
            case SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE /*204*/:
            case SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE_DATA /*205*/:
            case SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED /*206*/:
            case SecExceptionCode.SEC_ERROR_STA_STORE_ILLEGEL_KEY /*207*/:
                this.a.a(b.a((short) i2, b.b(i6, i7)));
                return;
            case 2:
            case 5:
            case 8:
                this.a.a(b.a(i2, i6), b.d(i7));
                return;
            case 3:
            case 6:
            case 9:
                this.a.a((short) i2, b.c(i6), b.d(i7));
                return;
            case 32:
            case 35:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                this.a.a(b.a(i2, b.b(i6, i7)), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.a.a(b.a(i2, b.b(0, 2)), (short) i3, b.a(i6, i7, 0, 0));
                return;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                this.a.a(b.a(i2, b.b(i6, i7)), b.c(i5, this.a.b));
                return;
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY /*208*/:
            case 209:
            case 210:
            case 211:
            case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /*212*/:
            case 213:
            case 214:
            case 215:
                this.a.a(b.a(i2, b.b(i6, i7)), b.a(j));
                return;
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
                h hVar = this.a;
                short a = b.a(i2, i6);
                if (j != ((long) ((byte) ((int) j)))) {
                    throw new v("Literal out of range: " + a.a(j));
                }
                hVar.a(a, b.a(i7, ((int) j) & 255));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.a.a(b.a(i2, b.b(0, 3)), (short) i3, b.a(i6, i7, i8, 0));
                return;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
                this.a.a(b.a(i2, i6), b.a(i7, i8));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.a.a(b.a(i2, b.b(0, 4)), (short) i3, b.a(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.a.a(b.a(i2, b.b(i10, 5)), (short) i3, b.a(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        switch (i2) {
            case 37:
            case 116:
            case 117:
            case 118:
            case 119:
            case MediaDefines.MSG_ENABLE_VR_MODE /*120*/:
                this.a.a(b.a(i2, i7), (short) i3, b.c(i6));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        int length;
        int i3 = 0;
        int a = this.a.a();
        this.a.a((short) i2);
        this.a.a(b.a(iArr2.length));
        for (int a2 : iArr) {
            this.a.a(a2);
        }
        if (this.c) {
            length = iArr2.length;
            while (i3 < length) {
                this.a.a(this.b.a(iArr2[i3]) - a);
                i3++;
            }
            return;
        }
        length = iArr2.length;
        while (i3 < length) {
            this.a.a(iArr2[i3] - a);
            i3++;
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int a = this.a.a();
        this.a.a((short) i2);
        this.a.a(b.a(iArr.length));
        this.a.a(i3);
        int length;
        if (this.c) {
            length = iArr.length;
            while (i4 < length) {
                this.a.a(this.b.a(iArr[i4]) - a);
                i4++;
            }
            return;
        }
        length = iArr.length;
        while (i4 < length) {
            this.a.a(iArr[i4] - a);
            i4++;
        }
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        int i5 = 0;
        this.a.a((short) i2);
        this.a.a((short) i4);
        this.a.a(i3);
        h hVar;
        int length;
        switch (i4) {
            case 1:
                h hVar2 = this.a;
                int i6 = 1;
                int i7 = 0;
                for (byte b : (byte[]) obj) {
                    if (i6 != 0) {
                        i7 = b & 255;
                        i6 = 0;
                    } else {
                        i6 = (b << 8) | i7;
                        hVar2.a((short) i6);
                        i7 = i6;
                        i6 = 1;
                    }
                }
                if (i6 == 0) {
                    hVar2.a((short) i7);
                    return;
                }
                return;
            case 2:
                hVar = this.a;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i5 < length) {
                    hVar.a(sArr[i5]);
                    i5++;
                }
                return;
            case 4:
                hVar = this.a;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i5 < length) {
                    hVar.a(iArr[i5]);
                    i5++;
                }
                return;
            case 8:
                hVar = this.a;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i5 < length) {
                    long j = jArr[i5];
                    hVar.a((short) ((int) j));
                    hVar.a((short) ((int) (j >> 16)));
                    hVar.a((short) ((int) (j >> 32)));
                    hVar.a((short) ((int) (j >> 48)));
                    i5++;
                }
                return;
            default:
                throw new v("bogus element_width: " + a.b(i4));
        }
    }
}
