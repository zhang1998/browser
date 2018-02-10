package android.mini.support.v4.app;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b = 1;
    final /* synthetic */ ab c;

    w(ab abVar, int i) {
        this.c = abVar;
        this.a = i;
    }

    public final void run() {
        ab abVar = this.c;
        t tVar = this.c.o;
        abVar.a(this.a, this.b);
    }
}
