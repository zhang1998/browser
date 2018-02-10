package android.support.v4.d;

/* compiled from: ProGuard */
public final class e<E> implements Cloneable {
    public static final Object a = new Object();
    public boolean b;
    public long[] c;
    public Object[] d;
    public int e;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public e() {
        this(10);
    }

    public e(int i) {
        this.b = false;
        if (i == 0) {
            this.c = j.b;
            this.d = j.c;
        } else {
            int b = j.b(i);
            this.c = new long[b];
            this.d = new Object[b];
        }
        this.e = 0;
    }

    private e<E> b() {
        try {
            e<E> eVar = (e) super.clone();
            try {
                eVar.c = (long[]) this.c.clone();
                eVar.d = (Object[]) this.d.clone();
                return eVar;
            } catch (CloneNotSupportedException e) {
                return eVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    private void c() {
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

    public final void a(long j, E e) {
        int a = j.a(this.c, this.e, j);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.e || this.d[a] != a) {
            if (this.b && this.e >= this.c.length) {
                c();
                a = j.a(this.c, this.e, j) ^ -1;
            }
            if (this.e >= this.c.length) {
                int b = j.b(this.e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            if (this.e - a != 0) {
                System.arraycopy(this.c, a, this.c, a + 1, this.e - a);
                System.arraycopy(this.d, a, this.d, a + 1, this.e - a);
            }
            this.c[a] = j;
            this.d[a] = e;
            this.e++;
            return;
        }
        this.c[a] = j;
        this.d[a] = e;
    }

    public final int a() {
        if (this.b) {
            c();
        }
        return this.e;
    }

    public final long a(int i) {
        if (this.b) {
            c();
        }
        return this.c[i];
    }

    public final E b(int i) {
        if (this.b) {
            c();
        }
        return this.d[i];
    }

    public final String toString() {
        if (a() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(a(i));
            stringBuilder.append('=');
            e b = b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final E a(long j) {
        int a = j.a(this.c, this.e, j);
        if (a < 0 || this.d[a] == a) {
            return null;
        }
        return this.d[a];
    }
}
