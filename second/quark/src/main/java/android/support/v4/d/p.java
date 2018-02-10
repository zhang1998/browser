package android.support.v4.d;

/* compiled from: ProGuard */
public final class p<T> extends m<T> {
    private final Object a = new Object();

    public p(int i) {
        super(i);
    }

    public final T a() {
        T a;
        synchronized (this.a) {
            a = super.a();
        }
        return a;
    }

    public final boolean a(T t) {
        boolean a;
        synchronized (this.a) {
            a = super.a(t);
        }
        return a;
    }
}
