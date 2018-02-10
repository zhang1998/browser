package com.tencent.tinker.c.b.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.c.a.v;
import com.tencent.tinker.c.b.b.a;
import com.tencent.tinker.c.c.b;
import com.uc.apollo.media.MediaDefines;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public final class c extends e {
    private final b a = new b();
    private int b = 0;

    public c() {
        super(null);
    }

    private void b(int i) {
        if (i != this.b) {
            b bVar = this.a;
            int i2 = this.b;
            if (bVar.c == 0 || i > bVar.a[bVar.c - 1]) {
                bVar.a = b.a(bVar.a, bVar.c, i);
                bVar.b = b.a(bVar.b, bVar.c, i2);
                bVar.c++;
                return;
            }
            bVar.a(i, i2);
        }
    }

    public final int a(int i) {
        int a = this.a.a(i);
        if (a < 0) {
            return i;
        }
        return this.a.b[a];
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        b(i);
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.b++;
                return;
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.b += 3;
                return;
            case 40:
                byte b = i5 - this.b;
                if (b == ((byte) b)) {
                    this.b++;
                    return;
                } else if (b != ((short) b)) {
                    this.b += 3;
                    return;
                } else {
                    this.b += 2;
                    return;
                }
            case 41:
                short s = i5 - this.b;
                if (s != ((short) s)) {
                    this.b += 3;
                    return;
                } else {
                    this.b += 2;
                    return;
                }
            case 42:
                this.b += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        b(i);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 29:
            case 30:
            case 39:
                this.b++;
                return;
            case 19:
            case 21:
            case 22:
            case 25:
            case 28:
            case 31:
            case 34:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
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
                this.b += 2;
                return;
            case 20:
            case 23:
            case 36:
            case 38:
            case 43:
            case 44:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.b += 3;
                return;
            case 24:
                this.b += 5;
                return;
            case 26:
                if (i3 > 65535) {
                    this.b += 3;
                    return;
                } else {
                    this.b += 2;
                    return;
                }
            case 27:
                this.b += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        b(i);
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
                this.b++;
                return;
            case 2:
            case 5:
            case 8:
                this.b += 2;
                return;
            case 3:
            case 6:
            case 9:
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.b += 3;
                return;
            case 32:
            case 35:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
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
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY /*208*/:
            case 209:
            case 210:
            case 211:
            case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /*212*/:
            case 213:
            case 214:
            case 215:
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
                this.b += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        b(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.b += 3;
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
                this.b += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        b(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.b += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        b(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
            case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
            case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                this.b += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        b(i);
        switch (i2) {
            case 37:
            case 116:
            case 117:
            case 118:
            case 119:
            case MediaDefines.MSG_ENABLE_VR_MODE /*120*/:
                this.b += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.c(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        b(i);
        this.b += 2;
        this.b += iArr.length * 2;
        this.b += iArr2.length * 2;
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        b(i);
        this.b += 4;
        this.b += iArr.length * 2;
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        b(i);
        this.b += 4;
        switch (i4) {
            case 1:
                int length = ((byte[]) obj).length;
                this.b = ((length & 1) + (length >> 1)) + this.b;
                return;
            case 2:
                this.b += ((short[]) obj).length * 1;
                return;
            case 4:
                this.b += ((int[]) obj).length * 2;
                return;
            case 8:
                this.b += ((long[]) obj).length * 4;
                return;
            default:
                throw new v("bogus element_width: " + a.b(i4));
        }
    }
}
