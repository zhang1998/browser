package android.support.v4.d;

/* compiled from: ProGuard */
public class m<T> implements q<T> {
    private final Object[] a;
    private int b;

    public m(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    public T a() {
        if (this.b <= 0) {
            return null;
        }
        int i = this.b - 1;
        T t = this.a[i];
        this.a[i] = null;
        this.b--;
        return t;
    }

    public boolean a(T t) {
        boolean z;
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == t) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.b >= this.a.length) {
            return false;
        } else {
            this.a[this.b] = t;
            this.b++;
            return true;
        }
    }
}
