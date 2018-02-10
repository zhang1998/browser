package com.uc.base.b.c;

import com.uc.base.b.c.c.a;

/* compiled from: ProGuard */
public class e {
    public int a;
    public int b;
    int c;
    public Object d;
    Object e;

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return n();
    }

    public e(int i, Object obj, int i2, int i3) {
        this(i, obj, i2, i3, null);
    }

    public e(int i, Object obj, int i2, int i3, Object obj2) {
        this.a = i;
        this.e = obj;
        this.b = i3;
        this.d = obj2;
        this.c = i2;
    }

    public final String a() {
        if (!i.w) {
            return "hide";
        }
        if (this.e == null) {
            return "null";
        }
        if (this.e instanceof byte[]) {
            Object obj;
            byte[] bArr = (byte[]) this.e;
            if (bArr == null) {
                obj = "";
            } else {
                int length = bArr.length;
                if (bArr == null || length <= 0) {
                    obj = "";
                } else {
                    StringBuffer stringBuffer = new StringBuffer(length >> 1);
                    a.a(bArr, length, stringBuffer);
                    obj = new String(stringBuffer);
                }
            }
            this.e = obj;
        } else if (this.e instanceof String) {
            return (String) this.e;
        }
        return this.e.toString();
    }

    public final boolean b() {
        return this.c == 3;
    }

    public final Object c() {
        if (this.d != null) {
            switch (this.b) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return Integer.valueOf(d());
                case 6:
                case 9:
                case 10:
                    return Long.valueOf(e());
                case 11:
                    return Boolean.valueOf(j());
                case 12:
                    return k();
                case 13:
                    return m();
                case 14:
                    return Double.valueOf(f());
                case 15:
                    return Float.valueOf(h());
                case 16:
                    return Short.valueOf(g());
                case 17:
                    return Byte.valueOf(i());
            }
        }
        return this.d;
    }

    public final int d() {
        if (o()) {
            return ((Integer) this.d).intValue();
        }
        return -1;
    }

    public final long e() {
        if (o()) {
            return ((Long) this.d).longValue();
        }
        return -1;
    }

    public final double f() {
        if (o()) {
            return ((Double) this.d).doubleValue();
        }
        return -1.0d;
    }

    public final short g() {
        if (o()) {
            return ((Short) this.d).shortValue();
        }
        return (short) -1;
    }

    public final float h() {
        if (o()) {
            return ((Float) this.d).floatValue();
        }
        return -1.0f;
    }

    public final byte i() {
        if (o()) {
            return (byte) ((Byte) this.d).intValue();
        }
        return (byte) -1;
    }

    public final boolean j() {
        if (o()) {
            return ((Boolean) this.d).booleanValue();
        }
        return false;
    }

    public final Object k() {
        if (this.d == null) {
            return null;
        }
        if (this.d instanceof c) {
            return this.d;
        }
        if (this.d instanceof String) {
            return this.d;
        }
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return null;
        }
    }

    public final Object l() {
        if (this.d == null) {
            return null;
        }
        if (this.d instanceof String) {
            return this.d;
        }
        if (this.d instanceof c) {
            return ((c) this.d).toString();
        }
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return null;
        }
    }

    public final byte[] m() {
        if (this.d == null) {
            return null;
        }
        try {
            return ((c) this.d).a;
        } catch (Exception e) {
            return null;
        }
    }

    public String toString() {
        String str = "NULL";
        if (this.d != null) {
            Object c = c();
            if (c != null) {
                str = c.toString();
                switch (this.b) {
                    case 13:
                        byte[] m = m();
                        String str2 = "bytes length= " + m.length + " content=";
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 0; i < m.length; i++) {
                            stringBuffer.append(m[i]);
                            if (i == 32) {
                                str = str2 + stringBuffer.toString();
                                break;
                            }
                        }
                        str = str2 + stringBuffer.toString();
                }
                str = str.substring(0, Math.min(100, str.length()));
            }
        }
        return a() + " : " + str;
    }

    protected e n() {
        return new e(this.a, a(), this.c, this.b, this.d);
    }

    public boolean o() {
        return this.d != null;
    }
}
