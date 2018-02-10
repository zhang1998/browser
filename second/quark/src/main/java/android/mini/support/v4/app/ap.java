package android.mini.support.v4.app;

import android.mini.support.v4.b.c;
import android.mini.support.v4.d.d;
import android.mini.support.v4.d.r;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: ProGuard */
final class ap extends an {
    static boolean a = false;
    final r<ao> b;
    final r<ao> c;
    final String d;
    boolean e;
    boolean f;
    t g;

    final void b() {
        if (a) {
            new StringBuilder("Starting in ").append(this);
        }
        if (this.e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.e = true;
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ao aoVar = (ao) this.b.d(b);
            if (aoVar.i && aoVar.j) {
                aoVar.h = true;
            } else if (aoVar.h) {
                continue;
            } else {
                aoVar.h = true;
                if (a) {
                    new StringBuilder("  Starting: ").append(aoVar);
                }
                if (aoVar.d == null && aoVar.c != null) {
                    aoVar.d = aoVar.c.a();
                }
                if (aoVar.d == null) {
                    continue;
                } else if (!aoVar.d.getClass().isMemberClass() || Modifier.isStatic(aoVar.d.getClass().getModifiers())) {
                    if (!aoVar.m) {
                        c cVar = aoVar.d;
                        int i = aoVar.a;
                        if (cVar.b != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.b = aoVar;
                        cVar.a = i;
                        cVar = aoVar.d;
                        if (cVar.c != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.c = aoVar;
                        aoVar.m = true;
                    }
                    c cVar2 = aoVar.d;
                    cVar2.d = true;
                    cVar2.f = false;
                    cVar2.e = false;
                } else {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + aoVar.d);
                }
            }
        }
    }

    final void c() {
        if (a) {
            new StringBuilder("Stopping in ").append(this);
        }
        if (this.e) {
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((ao) this.b.d(b)).a();
            }
            this.e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    final void d() {
        if (a) {
            new StringBuilder("Retaining in ").append(this);
        }
        if (this.e) {
            this.f = true;
            this.e = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ao aoVar = (ao) this.b.d(b);
                if (a) {
                    new StringBuilder("  Retaining: ").append(aoVar);
                }
                aoVar.i = true;
                aoVar.j = aoVar.h;
                aoVar.h = false;
                aoVar.c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    final void e() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((ao) this.b.d(b)).k = true;
        }
    }

    final void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ao aoVar = (ao) this.b.d(b);
            if (aoVar.h && aoVar.k) {
                aoVar.k = false;
                if (aoVar.e && !aoVar.i) {
                    aoVar.a(aoVar.d, aoVar.g);
                }
            }
        }
    }

    final void g() {
        int b;
        if (!this.f) {
            if (a) {
                new StringBuilder("Destroying Active in ").append(this);
            }
            for (b = this.b.b() - 1; b >= 0; b--) {
                ((ao) this.b.d(b)).b();
            }
            this.b.c();
        }
        if (a) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (b = this.c.b() - 1; b >= 0; b--) {
            ((ao) this.c.d(b)).b();
        }
        this.c.c();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter) {
        int i = 0;
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.b.b(); i2++) {
                ao aoVar = (ao) this.b.d(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.c(i2));
                printWriter.print(": ");
                printWriter.println(aoVar.toString());
                aoVar.a(str2, printWriter);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.c.b()) {
                aoVar = (ao) this.c.d(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.c(i));
                printWriter.print(": ");
                printWriter.println(aoVar.toString());
                aoVar.a(str3, printWriter);
                i++;
            }
        }
    }

    public final boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            ao aoVar = (ao) this.b.d(i);
            if (!aoVar.h || aoVar.f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
