package com.tencent.tinker.c.b.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.c.a.v;
import com.tencent.tinker.c.b.b.a;
import com.uc.apollo.media.MediaDefines;
import com.uc.crashsdk.export.LogType;
import com.uc.webview.export.extension.UCCore;
import java.io.EOFException;

/* compiled from: ProGuard */
public final class d {
    private final g a;

    public d(g gVar) {
        this.a = gVar;
    }

    public final void a(e eVar) throws EOFException {
        a aVar = this.a;
        aVar.a.c = 0;
        aVar.b = 0;
        while (true) {
            Object obj;
            aVar = this.a;
            if (aVar.b < aVar.c.length) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                int i = this.a.b;
                int c = this.a.c();
                int i2 = c & 255;
                if (i2 == 0 || i2 == 255) {
                    i2 = c;
                }
                int i3;
                int i4;
                int c2;
                int i5;
                int i6;
                int e;
                int d;
                int[] iArr;
                switch (i2) {
                    case -1:
                        eVar.a(i, c, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        eVar.a(i, c & 255, 0, 1, 0, (long) b.b(c));
                        break;
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
                        eVar.a(i, c & 255, 0, 1, 0, 0, (c >> 8) & 15, (c >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i, c & 255, 0, 1, 0, 0, b.b(c), this.a.c());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i, c & 255, 0, 1, 0, (long) b.b(c), this.a.c(), this.a.c());
                        break;
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
                        eVar.a(i, c & 255, 0, 1, 0, 0, b.b(c));
                        break;
                    case 18:
                        eVar.a(i, c & 255, 0, 1, 0, (long) ((((c >> 12) & 15) << 28) >> 28), (c >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        eVar.a(i, c & 255, 0, 1, 0, (long) ((short) this.a.c()), b.b(c));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i, c & 255, 0, 1, 0, (long) this.a.d(), b.b(c));
                        break;
                    case 21:
                    case 25:
                        i3 = c & 255;
                        eVar.a(i, i3, 0, 1, 0, ((long) ((short) this.a.c())) << (i3 == 21 ? 16 : 48), b.b(c));
                        break;
                    case 24:
                        eVar.a(i, c & 255, 0, 1, 0, this.a.e(), b.b(c));
                        break;
                    case 26:
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
                        i3 = c & 255;
                        eVar.a(i, i3, this.a.c(), b.e(i3), 0, 0, b.b(c));
                        break;
                    case 27:
                        i3 = c & 255;
                        eVar.a(i, i3, this.a.d(), b.e(i3), 0, 0, b.b(c));
                        break;
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
                        i4 = c & 255;
                        eVar.a(i, i4, this.a.c(), b.e(i4), 0, 0, (c >> 8) & 15, (c >> 12) & 15);
                        break;
                    case 36:
                    case 110:
                    case 111:
                    case SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED /*112*/:
                    case SecExceptionCode.SEC_ERROR_PLUGIN_REQUIREMENT_NOT_MEET /*113*/:
                    case SecExceptionCode.SEC_ERROR_INIT_EXTRACT_DIR_NOT_EXISTED /*114*/:
                        int i7 = c & 255;
                        int i8 = (c >> 8) & 15;
                        i2 = (c >> 12) & 15;
                        c2 = this.a.c();
                        c = this.a.c();
                        i5 = c & 15;
                        i3 = (c >> 4) & 15;
                        i4 = (c >> 8) & 15;
                        i6 = (c >> 12) & 15;
                        e = b.e(i7);
                        switch (i2) {
                            case 0:
                                eVar.a(i, i7, c2, e, 0, 0);
                                break;
                            case 1:
                                eVar.a(i, i7, c2, e, 0, 0, i5);
                                break;
                            case 2:
                                eVar.a(i, i7, c2, e, 0, 0, i5, i3);
                                break;
                            case 3:
                                eVar.a(i, i7, c2, e, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                eVar.a(i, i7, c2, e, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                eVar.a(i, i7, c2, e, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new v("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case 37:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case MediaDefines.MSG_ENABLE_VR_MODE /*120*/:
                        i4 = c & 255;
                        eVar.b(i, i4, this.a.c(), b.e(i4), 0, 0, this.a.c(), b.b(c));
                        break;
                    case 38:
                    case 43:
                    case 44:
                        i3 = c & 255;
                        i5 = b.b(c);
                        d = i + this.a.d();
                        switch (i3) {
                            case 43:
                            case 44:
                                this.a.a(d + 1, i);
                                break;
                        }
                        eVar.a(i, i3, 0, 1, d, 0, i5);
                        break;
                    case 40:
                        eVar.a(i, c & 255, 0, 1, i + ((byte) b.b(c)), 0);
                        break;
                    case 41:
                        eVar.a(i, c & 255, 0, 1, i + ((short) this.a.c()), (long) b.b(c));
                        break;
                    case 42:
                        eVar.a(i, c & 255, 0, 1, i + this.a.d(), (long) b.b(c));
                        break;
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
                        i6 = c & 255;
                        i5 = b.b(c);
                        i2 = this.a.c();
                        eVar.a(i, i6, 0, 1, 0, 0, i5, i2 & 255, b.b(i2));
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                        eVar.a(i, c & 255, 0, 1, i + ((short) this.a.c()), 0, (c >> 8) & 15, (c >> 12) & 15);
                        break;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                        eVar.a(i, c & 255, 0, 1, i + ((short) this.a.c()), 0, b.b(c));
                        break;
                    case SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY /*208*/:
                    case 209:
                    case 210:
                    case 211:
                    case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /*212*/:
                    case 213:
                    case 214:
                    case 215:
                        eVar.a(i, c & 255, 0, 1, 0, (long) ((short) this.a.c()), (c >> 8) & 15, (c >> 12) & 15);
                        break;
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
                        i4 = c & 255;
                        i5 = b.b(c);
                        i2 = this.a.c();
                        eVar.a(i, i4, 0, 1, 0, (long) ((byte) b.b(i2)), i5, i2 & 255);
                        break;
                    case LogType.UNEXP /*256*/:
                        c2 = this.a.a();
                        e = this.a.c();
                        d = this.a.d();
                        iArr = new int[e];
                        for (i2 = 0; i2 < e; i2++) {
                            iArr[i2] = this.a.d() + c2;
                        }
                        eVar.a(i, c, d, iArr);
                        break;
                    case 512:
                        c2 = this.a.a();
                        e = this.a.c();
                        int[] iArr2 = new int[e];
                        iArr = new int[e];
                        for (i2 = 0; i2 < e; i2++) {
                            iArr2[i2] = this.a.d();
                        }
                        for (i2 = 0; i2 < e; i2++) {
                            iArr[i2] = this.a.d() + c2;
                        }
                        eVar.a(i, c, iArr2, iArr);
                        break;
                    case 768:
                        i2 = this.a.c();
                        int d2 = this.a.d();
                        Object obj2;
                        switch (i2) {
                            case 1:
                                obj2 = new byte[d2];
                                i2 = 0;
                                int i9 = 0;
                                Object obj3 = 1;
                                while (i9 < d2) {
                                    if (obj3 != null) {
                                        i2 = this.a.c();
                                    }
                                    obj2[i9] = (byte) (i2 & 255);
                                    i9++;
                                    obj3 = obj3 == null ? 1 : null;
                                    i2 >>= 8;
                                }
                                eVar.a(i, c, obj2, obj2.length, 1);
                                break;
                            case 2:
                                obj2 = new short[d2];
                                for (i2 = 0; i2 < d2; i2++) {
                                    obj2[i2] = (short) this.a.c();
                                }
                                eVar.a(i, c, obj2, obj2.length, 2);
                                break;
                            case 4:
                                obj2 = new int[d2];
                                for (i2 = 0; i2 < d2; i2++) {
                                    obj2[i2] = this.a.d();
                                }
                                eVar.a(i, c, obj2, obj2.length, 4);
                                break;
                            case 8:
                                obj2 = new long[d2];
                                for (i2 = 0; i2 < d2; i2++) {
                                    obj2[i2] = this.a.e();
                                }
                                eVar.a(i, c, obj2, obj2.length, 8);
                                break;
                            default:
                                throw new v("bogus element_width: " + a.b(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + a.a(i2));
                }
            }
            return;
        }
    }
}
