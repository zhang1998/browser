package com.uc.base.b.c;

import com.uc.base.b.c.c.a;
import java.io.Closeable;
import java.util.Stack;

/* compiled from: ProGuard */
final class f {
    f() {
    }

    public static byte[] a(m mVar) {
        Closeable kVar = new k();
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
            if (stack != null) {
                kVar.writeInt(2048);
                while (!stack.empty()) {
                    m mVar3 = (m) stack.pop();
                    a(mVar3.a, mVar3.a(), mVar3, kVar);
                }
                kVar.writeInt(-2048);
            } else {
                a(mVar.a, mVar.a(), mVar, kVar);
            }
            a = kVar.a();
            return a;
        } catch (Exception e) {
            a = e;
            return null;
        } finally {
            a.a(kVar);
        }
    }

    private static void a(String str, k kVar) throws Exception {
        if (a.w) {
            if (str == null) {
                str = "";
            }
            byte[] bytes = str.getBytes("UTF-8");
            kVar.writeShort(bytes.length);
            kVar.write(bytes, 0, bytes.length);
            return;
        }
        kVar.writeShort(0);
    }

    private static void a(int i, String str, m mVar, k kVar) throws Exception {
        Stack stack;
        m mVar2;
        kVar.writeInt(1024);
        a(i, mVar.b, kVar);
        a(str, kVar);
        if (mVar.g == null || mVar.h) {
            stack = null;
        } else {
            stack = new Stack();
            mVar2 = mVar;
            do {
                mVar2.h = true;
                stack.push(mVar2);
                mVar2 = mVar2.g;
            } while (mVar2 != null);
        }
        if (stack != null) {
            kVar.writeInt(2048);
            while (!stack.empty()) {
                mVar2 = (m) stack.pop();
                a(mVar2.a, mVar2.a(), mVar2, kVar);
            }
            kVar.writeInt(-2048);
        } else {
            int q = mVar.q();
            for (int i2 = 0; i2 < q; i2++) {
                e h = mVar.h(i2);
                if (h != null) {
                    int i3 = h.a;
                    String a;
                    byte[] m;
                    switch (h.b) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            a = h.a();
                            int d = h.d();
                            a(i3, 1, kVar);
                            a(a, kVar);
                            kVar.writeInt(d);
                            break;
                        case 6:
                        case 9:
                        case 10:
                            a = h.a();
                            long e = h.e();
                            a(i3, 10, kVar);
                            a(a, kVar);
                            kVar.writeLong(e);
                            break;
                        case 11:
                            a = h.a();
                            boolean j = h.j();
                            a(i3, 11, kVar);
                            a(a, kVar);
                            kVar.writeBoolean(j);
                            break;
                        case 12:
                            a = h.a();
                            m = h.m();
                            a(i3, 12, kVar);
                            a(a, kVar);
                            if (m != null) {
                                if (m.length != 0) {
                                    kVar.writeShort(m.length);
                                    kVar.write(m, 0, m.length);
                                    break;
                                }
                                kVar.writeShort(0);
                                kVar.writeShort(1);
                                break;
                            }
                            kVar.writeShort(0);
                            kVar.writeShort(0);
                            break;
                        case 13:
                            a = h.a();
                            m = h.m();
                            a(i3, 13, kVar);
                            a(a, kVar);
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
                            a = h.a();
                            double f = h.f();
                            a(i3, 14, kVar);
                            a(a, kVar);
                            kVar.writeDouble(f);
                            break;
                        case 15:
                            a = h.a();
                            float h2 = h.h();
                            a(i3, 15, kVar);
                            a(a, kVar);
                            kVar.writeFloat(h2);
                            break;
                        case 16:
                            a = h.a();
                            short g = h.g();
                            a(i3, 16, kVar);
                            a(a, kVar);
                            kVar.writeShort(g);
                            break;
                        case 17:
                            a = h.a();
                            byte i4 = h.i();
                            a(i3, 17, kVar);
                            a(a, kVar);
                            kVar.writeByte(i4);
                            break;
                        default:
                            a(i3, h.a(), (m) h, kVar);
                            break;
                    }
                }
            }
        }
        kVar.writeInt(-1024);
    }

    private static void a(int i, int i2, k kVar) throws Exception {
        kVar.writeInt(i2);
        kVar.writeShort(i);
    }
}
