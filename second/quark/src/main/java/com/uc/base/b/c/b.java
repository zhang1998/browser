package com.uc.base.b.c;

import com.uc.base.b.c.c.a;
import com.uc.crashsdk.export.LogType;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/* compiled from: ProGuard */
final class b {
    private HashMap<Integer, Integer> a = new HashMap();
    private int b = 0;

    b() {
    }

    public final byte[] a(m mVar) {
        k kVar = new k();
        byte[] a;
        try {
            Stack stack;
            if (mVar.g == null || mVar.h) {
                stack = null;
            } else {
                Stack stack2 = new Stack();
                m mVar2 = mVar;
                while (true) {
                    mVar2.h = true;
                    stack2.push(mVar2);
                    mVar2 = mVar2.g;
                    if (mVar2 == null) {
                        break;
                    }
                }
                stack = stack2;
            }
            if (stack == null) {
                int i = mVar.a;
                mVar.a();
                a(i, mVar, kVar, false);
            } else if (stack.size() == 1) {
                kVar.writeByte(5);
                r2 = (m) stack.pop();
                r1 = r2.a;
                r2.a();
                a(r1, r2, kVar, (byte) 3, mVar.b());
                kVar.writeByte(10);
            } else if (stack.size() > 1) {
                kVar.writeByte(5);
                r2 = (m) stack.pop();
                r1 = r2.a;
                r2.a();
                a(r1, r2, kVar, (byte) 1, mVar.b());
                while (stack.size() > 1) {
                    m mVar3 = (m) stack.pop();
                    r1 = mVar3.a;
                    mVar3.a();
                    a(r1, mVar3, kVar, false);
                }
                r2 = (m) stack.pop();
                r1 = r2.a;
                r2.a();
                a(r1, r2, kVar, (byte) 2, mVar.b());
                kVar.writeByte(10);
            }
            a = kVar.a(a());
            return a;
        } catch (Exception e) {
            a = e;
            return null;
        } finally {
            a.a((Closeable) kVar);
        }
    }

    private byte[] a() {
        int i;
        int i2;
        int i3 = 4;
        int size = this.a.size();
        if (size <= LogType.UNEXP) {
            i = (size * 5) + 4;
            i2 = 1;
        } else if (size <= 65535) {
            i = (size * 6) + 4;
            i2 = 2;
        } else if (size <= 16777216) {
            i = (size * 7) + 4;
            i2 = 3;
        } else {
            i = (size * 8) + 4;
            i2 = 4;
        }
        byte[] bArr = new byte[i];
        bArr[0] = (byte) ((size >>> 24) & 255);
        bArr[1] = (byte) ((size >>> 16) & 255);
        bArr[2] = (byte) ((size >>> 8) & 255);
        bArr[3] = (byte) ((size >>> 0) & 255);
        Set<Entry> entrySet = this.a.entrySet();
        int intValue;
        switch (i2) {
            case 2:
                for (Entry entry : entrySet) {
                    intValue = ((Integer) entry.getKey()).intValue();
                    i2 = ((Integer) entry.getValue()).intValue();
                    bArr[i3 + 0] = (byte) ((intValue >>> 24) & 255);
                    bArr[i3 + 1] = (byte) ((intValue >>> 16) & 255);
                    bArr[i3 + 2] = (byte) ((intValue >>> 8) & 255);
                    bArr[i3 + 3] = (byte) ((intValue >>> 0) & 255);
                    bArr[i3 + 4] = (byte) ((i2 >>> 8) & 255);
                    bArr[i3 + 5] = (byte) ((i2 >>> 0) & 255);
                    i3 += 6;
                }
                break;
            case 3:
                for (Entry entry2 : entrySet) {
                    intValue = ((Integer) entry2.getKey()).intValue();
                    i2 = ((Integer) entry2.getValue()).intValue();
                    bArr[i3 + 0] = (byte) ((intValue >>> 24) & 255);
                    bArr[i3 + 1] = (byte) ((intValue >>> 16) & 255);
                    bArr[i3 + 2] = (byte) ((intValue >>> 8) & 255);
                    bArr[i3 + 3] = (byte) ((intValue >>> 0) & 255);
                    bArr[i3 + 4] = (byte) ((i2 >>> 16) & 255);
                    bArr[i3 + 5] = (byte) ((i2 >>> 8) & 255);
                    bArr[i3 + 6] = (byte) ((i2 >>> 0) & 255);
                    i3 += 7;
                }
                break;
            case 4:
                for (Entry entry22 : entrySet) {
                    intValue = ((Integer) entry22.getKey()).intValue();
                    i2 = ((Integer) entry22.getValue()).intValue();
                    bArr[i3 + 0] = (byte) ((intValue >>> 24) & 255);
                    bArr[i3 + 1] = (byte) ((intValue >>> 16) & 255);
                    bArr[i3 + 2] = (byte) ((intValue >>> 8) & 255);
                    bArr[i3 + 3] = (byte) ((intValue >>> 0) & 255);
                    bArr[i3 + 4] = (byte) ((i2 >>> 24) & 255);
                    bArr[i3 + 5] = (byte) ((i2 >>> 16) & 255);
                    bArr[i3 + 6] = (byte) ((i2 >>> 8) & 255);
                    bArr[i3 + 7] = (byte) ((i2 >>> 0) & 255);
                    i3 += 8;
                }
                break;
            default:
                for (Entry entry222 : entrySet) {
                    intValue = ((Integer) entry222.getKey()).intValue();
                    i2 = ((Integer) entry222.getValue()).intValue();
                    bArr[i3 + 0] = (byte) ((intValue >>> 24) & 255);
                    bArr[i3 + 1] = (byte) ((intValue >>> 16) & 255);
                    bArr[i3 + 2] = (byte) ((intValue >>> 8) & 255);
                    bArr[i3 + 3] = (byte) ((intValue >>> 0) & 255);
                    bArr[i3 + 4] = (byte) ((i2 >>> 0) & 255);
                    i3 += 5;
                }
                break;
        }
        return bArr;
    }

    private void a(k kVar, m mVar) throws Exception {
        Stack stack;
        m mVar2;
        if (mVar.g == null || mVar.h) {
            stack = null;
        } else {
            Stack stack2 = new Stack();
            mVar2 = mVar;
            do {
                mVar2.h = true;
                stack2.push(mVar2);
                mVar2 = mVar2.g;
            } while (mVar2 != null);
            stack = stack2;
        }
        if (stack == null) {
            int q = mVar.q();
            boolean b = mVar.b();
            for (int i = 0; i < q; i++) {
                e h = mVar.h(i);
                if (h != null) {
                    int i2 = h.a;
                    switch (h.b) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            h.a();
                            int d = h.d();
                            a(i2, 1, kVar, b);
                            kVar.writeInt(d);
                            break;
                        case 6:
                        case 9:
                        case 10:
                            h.a();
                            long e = h.e();
                            a(i2, 10, kVar, b);
                            kVar.writeLong(e);
                            break;
                        case 11:
                            h.a();
                            boolean j = h.j();
                            a(i2, 11, kVar, b);
                            kVar.writeBoolean(j);
                            break;
                        case 12:
                            h.a();
                            Object k = h.k();
                            a(i2, 12, kVar, b);
                            if (k != null) {
                                if ((k instanceof String) && ((String) k).length() != 0) {
                                    String str = (String) k;
                                    kVar.writeShort(str.length());
                                    kVar.writeChars(str);
                                    break;
                                }
                                kVar.writeShort(0);
                                kVar.writeShort(1);
                                break;
                            }
                            kVar.writeShort(0);
                            kVar.writeShort(0);
                            break;
                            break;
                        case 13:
                            h.a();
                            byte[] m = h.m();
                            a(i2, 13, kVar, b);
                            if (m != null) {
                                if (m.length != 0) {
                                    kVar.writeInt(m.length);
                                    kVar.write(m, 0, m.length);
                                    break;
                                }
                                kVar.writeInt(0);
                                kVar.writeInt(1);
                                break;
                            }
                            kVar.writeInt(0);
                            kVar.writeInt(0);
                            break;
                        case 14:
                            h.a();
                            double f = h.f();
                            a(i2, 14, kVar, b);
                            kVar.writeDouble(f);
                            break;
                        case 15:
                            h.a();
                            float h2 = h.h();
                            a(i2, 15, kVar, b);
                            kVar.writeFloat(h2);
                            break;
                        case 16:
                            h.a();
                            short g = h.g();
                            a(i2, 16, kVar, b);
                            kVar.writeShort(g);
                            break;
                        case 17:
                            h.a();
                            byte i3 = h.i();
                            a(i2, 17, kVar, b);
                            kVar.writeByte(i3);
                            break;
                        default:
                            h.a();
                            a(i2, (m) h, kVar, b);
                            break;
                    }
                }
            }
        } else if (stack.size() == 1) {
            kVar.writeByte(5);
            r2 = (m) stack.pop();
            r1 = r2.a;
            r2.a();
            a(r1, r2, kVar, (byte) 3, mVar.b());
            kVar.writeByte(10);
        } else if (stack.size() > 1) {
            kVar.writeByte(5);
            r2 = (m) stack.pop();
            r1 = r2.a;
            r2.a();
            a(r1, r2, kVar, (byte) 1, mVar.b());
            while (stack.size() > 1) {
                mVar2 = (m) stack.pop();
                r1 = mVar2.a;
                mVar2.a();
                a(r1, mVar2, kVar, false);
            }
            r2 = (m) stack.pop();
            r1 = r2.a;
            r2.a();
            a(r1, r2, kVar, (byte) 2, mVar.b());
            kVar.writeByte(10);
        }
    }

    private void a(int i, m mVar, k kVar, byte b, boolean z) throws Exception {
        int i2 = mVar.b;
        if (b == (byte) 1) {
            b(i, i2, kVar, z);
            if (i2 == 51) {
                kVar.writeInt(mVar.q());
            }
            a(kVar, mVar);
            kVar.writeByte(2);
        } else if (b == (byte) 2) {
            kVar.writeByte(1);
            b(i, i2, kVar, z);
            if (i2 == 51) {
                kVar.writeInt(mVar.q());
            }
            a(kVar, mVar);
        } else if (b == (byte) 3) {
            b(i, i2, kVar, z);
            if (i2 == 51) {
                kVar.writeInt(mVar.q());
            }
            a(kVar, mVar);
        } else {
            kVar.writeByte(1);
            b(i, i2, kVar, z);
            if (i2 == 51) {
                kVar.writeInt(mVar.q());
            }
            a(kVar, mVar);
            kVar.writeByte(2);
        }
    }

    private void a(int i, m mVar, k kVar, boolean z) throws Exception {
        a(i, mVar, kVar, (byte) 0, z);
    }

    private static void a(int i, int i2, k kVar, boolean z) throws Exception {
        kVar.writeByte(0);
        kVar.writeByte(i2);
        if (!z) {
            kVar.writeShort(i);
        }
    }

    private void b(int i, int i2, k kVar, boolean z) throws Exception {
        Integer num = (Integer) this.a.get(Integer.valueOf(i2));
        if (num == null) {
            this.a.put(Integer.valueOf(i2), Integer.valueOf(this.b));
            num = Integer.valueOf(this.b);
            this.b++;
        }
        kVar.writeByte(num.intValue());
        if (!z) {
            kVar.writeShort(i);
        }
    }
}
