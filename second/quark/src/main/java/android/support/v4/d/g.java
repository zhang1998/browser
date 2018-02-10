package android.support.v4.d;

/* compiled from: ProGuard */
public final class g<E> implements Cloneable {
    public static final Object a = new Object();
    public boolean b;
    public int[] c;
    public Object[] d;
    public int e;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return d();
    }

    public g() {
        this(10);
    }

    public g(int i) {
        this.b = false;
        if (i == 0) {
            this.c = j.a;
            this.d = j.c;
        } else {
            int a = j.a(i);
            this.c = new int[a];
            this.d = new Object[a];
        }
        this.e = 0;
    }

    private g<E> d() {
        try {
            g<E> gVar = (g) super.clone();
            try {
                gVar.c = (int[]) this.c.clone();
                gVar.d = (Object[]) this.d.clone();
                return gVar;
            } catch (CloneNotSupportedException e) {
                return gVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void a() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
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

    public final int c(int i) {
        if (this.b) {
            a();
        }
        return this.c[i];
    }

    public final E d(int i) {
        if (this.b) {
            a();
        }
        return this.d[i];
    }

    public final void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
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
            stringBuilder.append(c(i));
            stringBuilder.append('=');
            g d = d(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final E a(int i) {
        int a = j.a(this.c, this.e, i);
        if (a < 0 || this.d[a] == a) {
            return null;
        }
        return this.d[a];
    }

    public final void b(int i) {
        int a = j.a(this.c, this.e, i);
        if (a >= 0 && this.d[a] != a) {
            this.d[a] = a;
            this.b = true;
        }
    }
}
