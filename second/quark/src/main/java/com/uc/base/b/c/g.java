package com.uc.base.b.c;

import android.util.Log;
import com.uc.base.b.c.c.a;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.util.Stack;

/* compiled from: ProGuard */
final class g {
    private final String a = "BoParser";
    private int b = 0;
    private int c = 0;
    private m d = null;

    g() {
    }

    public final m a(byte[] bArr) {
        Closeable byteArrayInputStream = new ByteArrayInputStream(bArr);
        Closeable dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            a(dataInputStream, this.d, false);
            return this.d;
        } catch (Throwable e) {
            Log.e("BoParser", "parseFrom exception", e);
            return null;
        } finally {
            a.a(byteArrayInputStream);
            a.a(dataInputStream);
        }
    }

    private void a(DataInputStream dataInputStream, m mVar, boolean z) throws Exception {
        Stack stack = null;
        boolean z2 = false;
        while (!z2) {
            int readInt = dataInputStream.readInt();
            e a;
            switch (readInt) {
                case -2048:
                    this.b--;
                    this.d = (m) stack.peek();
                    z2 = true;
                    break;
                case -1024:
                    this.c--;
                    this.d = mVar;
                    z2 = true;
                    break;
                case 1024:
                    if (!z) {
                        boolean z3;
                        a = a(dataInputStream);
                        if (mVar != null) {
                            mVar.a(a);
                        }
                        this.c++;
                        a(dataInputStream, a, false);
                        if (this.c == 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        z2 = z3;
                        break;
                    }
                    Stack stack2;
                    if (stack == null) {
                        stack2 = new Stack();
                    } else {
                        stack2 = stack;
                    }
                    m a2 = a(dataInputStream);
                    this.c++;
                    a(dataInputStream, a2, false);
                    if (!stack2.empty()) {
                        a2.g = (m) stack2.peek();
                    }
                    stack2.push(a2);
                    stack = stack2;
                    break;
                case 2048:
                    this.b++;
                    a(dataInputStream, mVar, true);
                    if (mVar != null) {
                        mVar.a(this.d);
                    }
                    if (this.b != 0) {
                        break;
                    }
                    z2 = true;
                    break;
                default:
                    short readShort = dataInputStream.readShort();
                    Object b;
                    byte[] bArr;
                    byte[] bArr2;
                    switch (readInt) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            a = new e(readShort, b(dataInputStream), 1, readInt, Integer.valueOf(dataInputStream.readInt()));
                            break;
                        case 9:
                        case 10:
                            a = new e(readShort, b(dataInputStream), 1, readInt, Long.valueOf(dataInputStream.readLong()));
                            break;
                        case 11:
                            a = new e(readShort, b(dataInputStream), 1, readInt, Boolean.valueOf(dataInputStream.readBoolean()));
                            break;
                        case 12:
                            b = b(dataInputStream);
                            short readShort2 = dataInputStream.readShort();
                            if (readShort2 == (short) 0) {
                                short readShort3 = dataInputStream.readShort();
                                if (readShort3 == (short) 0 || readShort3 != (short) 1) {
                                    bArr = null;
                                } else {
                                    bArr = new byte[0];
                                }
                                bArr2 = bArr;
                            } else {
                                bArr = new byte[readShort2];
                                dataInputStream.readFully(bArr, 0, readShort2);
                                bArr2 = bArr;
                            }
                            a = new e(readShort, b, 1, readInt, bArr2 == null ? null : c.a(bArr2));
                            break;
                        case 13:
                            b = b(dataInputStream);
                            int readInt2 = dataInputStream.readInt();
                            if (readInt2 == 0) {
                                readInt2 = dataInputStream.readInt();
                                if (readInt2 == 0 || readInt2 != 1) {
                                    bArr = null;
                                } else {
                                    bArr = new byte[0];
                                }
                                bArr2 = bArr;
                            } else {
                                bArr = new byte[readInt2];
                                dataInputStream.readFully(bArr);
                                bArr2 = bArr;
                            }
                            a = new e(readShort, b, 1, readInt, c.a(bArr2));
                            break;
                        case 14:
                            a = new e(readShort, b(dataInputStream), 1, readInt, Double.valueOf(dataInputStream.readDouble()));
                            break;
                        case 15:
                            a = new e(readShort, b(dataInputStream), 1, readInt, Float.valueOf(dataInputStream.readFloat()));
                            break;
                        case 16:
                            a = new e(readShort, b(dataInputStream), 1, readInt, Short.valueOf(dataInputStream.readShort()));
                            break;
                        case 17:
                            a = new e(readShort, b(dataInputStream), 1, readInt, new Byte(dataInputStream.readByte()));
                            break;
                        default:
                            a = null;
                            break;
                    }
                    mVar.a(a);
                    break;
            }
        }
    }

    private static m a(DataInputStream dataInputStream) throws Exception {
        return new m(dataInputStream.readShort(), b(dataInputStream), 1, dataInputStream.readInt());
    }

    private static byte[] b(DataInputStream dataInputStream) throws Exception {
        short readShort = dataInputStream.readShort();
        if (readShort == (short) 0) {
            return null;
        }
        byte[] bArr = new byte[readShort];
        dataInputStream.readFully(bArr, 0, readShort);
        return bArr;
    }
}
