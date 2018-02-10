package android.mini.support.v4.d;

/* compiled from: ProGuard */
public final class f<E> implements Cloneable {
    public static final Object a = new Object();
    public boolean b;
    public long[] c;
    public Object[] d;
    public int e;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public f() {
        this((byte) 0);
    }

    private f(byte b) {
        this.b = false;
        int b2 = c.b(10);
        this.c = new long[b2];
        this.d = new Object[b2];
        this.e = 0;
    }

    private f<E> c() {
        try {
            f<E> fVar = (f) super.clone();
            try {
                fVar.c = (long[]) this.c.clone();
                fVar.d = (Object[]) this.d.clone();
                return fVar;
            } catch (CloneNotSupportedException e) {
                return fVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void a() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public final int b() {
        if (this.b) {
            a();
        }
        return this.e;
    }

    private long b(int i) {
        if (this.b) {
            a();
        }
        return this.c[i];
    }

    public final E a(int i) {
        if (this.b) {
            a();
        }
        return this.d[i];
    }

    public final String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(b(i));
            stringBuilder.append('=');
            f a = a(i);
            if (a != this) {
                stringBuilder.append(a);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
