package com.uc.base.b.c.b;

import android.util.Log;
import com.uc.base.b.b.a;
import com.uc.base.b.c.c;
import com.uc.base.b.c.e;
import com.uc.base.b.c.l;
import com.uc.base.b.c.m;
import com.uc.webview.export.extension.UCCore;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class d {
    public static boolean a(byte[] bArr, m mVar) {
        try {
            b(new DataInputStream(new ByteArrayInputStream(bArr)), mVar);
            return true;
        } catch (Throwable e) {
            Log.e("ProtoParser", "message parseFrom exception", e);
            String str = "javamodel parseFrom exception " + e.toString();
            if (a.a == null) {
                return false;
            }
            a.a.a(str, bArr);
            return false;
        }
    }

    private static void a(DataInputStream dataInputStream, m mVar) throws IOException {
        if (mVar.b()) {
            b(dataInputStream, mVar);
            return;
        }
        InputStream aVar = new com.uc.base.c.a(dataInputStream, a(dataInputStream) + 0);
        b(new DataInputStream(aVar), mVar);
        if (aVar.a > 0) {
            dataInputStream.skip((long) aVar.a);
        }
    }

    private static void b(DataInputStream dataInputStream, m mVar) throws IOException {
        while (true) {
            int d = d(dataInputStream);
            if (d != 0) {
                e eVar;
                e i = mVar.i(d >> 3);
                if (i != null) {
                    try {
                        if (i.b()) {
                            i = ((l) i).p();
                        }
                    } catch (Exception e) {
                        eVar = i;
                    }
                }
                eVar = i;
                if (eVar != null) {
                    int i2;
                    int i3 = d & 7;
                    switch (eVar.b) {
                        case 1:
                        case 2:
                        case 3:
                        case 6:
                        case 7:
                        case 8:
                        case 11:
                            i2 = 0;
                            break;
                        case 4:
                        case 5:
                        case 15:
                            i2 = 5;
                            break;
                        case 9:
                        case 10:
                        case 14:
                            i2 = 1;
                            break;
                        case 12:
                        case 13:
                        case 50:
                            i2 = 2;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                    if (i3 == i2) {
                        switch (eVar.b) {
                            case 1:
                            case 2:
                                eVar.d = Integer.valueOf(a(dataInputStream));
                                break;
                            case 3:
                                i2 = a(dataInputStream);
                                eVar.d = Integer.valueOf((-(i2 & 1)) ^ (i2 >>> 1));
                                break;
                            case 4:
                            case 5:
                                eVar.d = Integer.valueOf(e(dataInputStream));
                                break;
                            case 6:
                            case 7:
                                eVar.d = Long.valueOf(b(dataInputStream));
                                break;
                            case 8:
                                long b = b(dataInputStream);
                                eVar.d = Long.valueOf((-(b & 1)) ^ (b >>> 1));
                                break;
                            case 9:
                            case 10:
                                eVar.d = Long.valueOf(c(dataInputStream));
                                break;
                            case 11:
                                boolean z;
                                if (a(dataInputStream) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                eVar.d = Boolean.valueOf(z);
                                break;
                            case 12:
                            case 13:
                                byte[] bArr = new byte[a(dataInputStream)];
                                dataInputStream.readFully(bArr, 0, bArr.length);
                                eVar.d = c.a(bArr);
                                break;
                            case 14:
                                eVar.d = Double.valueOf(Double.longBitsToDouble(c(dataInputStream)));
                                break;
                            case 15:
                                eVar.d = Float.valueOf(Float.intBitsToFloat(e(dataInputStream)));
                                break;
                            case 50:
                                a(dataInputStream, (m) eVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                switch (d & 7) {
                    case 0:
                        a(dataInputStream);
                        break;
                    case 1:
                        c(dataInputStream);
                        break;
                    case 2:
                        dataInputStream.skip((long) a(dataInputStream));
                        break;
                    case 5:
                        e(dataInputStream);
                        break;
                    default:
                        throw new IOException();
                }
            }
            return;
        }
    }

    private static int a(DataInputStream dataInputStream) throws IOException {
        byte readByte = dataInputStream.readByte();
        if (readByte >= (byte) 0) {
            return readByte;
        }
        int i = readByte & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK;
        byte readByte2 = dataInputStream.readByte();
        if (readByte2 >= (byte) 0) {
            return i | (readByte2 << 7);
        }
        i |= (readByte2 & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << 7;
        readByte2 = dataInputStream.readByte();
        if (readByte2 >= (byte) 0) {
            return i | (readByte2 << 14);
        }
        i |= (readByte2 & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << 14;
        readByte2 = dataInputStream.readByte();
        if (readByte2 >= (byte) 0) {
            return i | (readByte2 << 21);
        }
        i |= (readByte2 & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << 21;
        readByte2 = dataInputStream.readByte();
        i |= readByte2 << 28;
        if (readByte2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5 && dataInputStream.readByte() < (byte) 0; i2++) {
        }
        return i;
    }

    private static long b(DataInputStream dataInputStream) throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readByte = dataInputStream.readByte();
            j |= ((long) (readByte & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK)) << i;
            if ((readByte & 128) == 0) {
                return j;
            }
        }
        throw new IOException("invalid parsing of Pb Vint64");
    }

    private static long c(DataInputStream dataInputStream) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        return ((((((((((long) readByte2) & 255) << 8) | (((long) readByte) & 255)) | ((((long) dataInputStream.readByte()) & 255) << 16)) | ((((long) dataInputStream.readByte()) & 255) << 24)) | ((((long) dataInputStream.readByte()) & 255) << 32)) | ((((long) dataInputStream.readByte()) & 255) << 40)) | ((((long) dataInputStream.readByte()) & 255) << 48)) | ((((long) dataInputStream.readByte()) & 255) << 56);
    }

    private static int d(DataInputStream dataInputStream) {
        try {
            return a(dataInputStream);
        } catch (IOException e) {
            return 0;
        }
    }

    private static int e(DataInputStream dataInputStream) throws IOException {
        return (((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8)) | ((dataInputStream.readByte() & 255) << 16)) | ((dataInputStream.readByte() & 255) << 24);
    }
}
