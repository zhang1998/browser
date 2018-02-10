package android.support.v4.app;

import android.support.v4.content.k;
import android.support.v4.d.f;
import android.support.v4.d.g;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: ProGuard */
final class cs extends cr {
    static boolean a = false;
    final g<cd> b;
    final g<cd> c;
    final String d;
    boolean e;
    boolean f;
    bm g;

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
            cd cdVar = (cd) this.b.d(b);
            if (cdVar.i && cdVar.j) {
                cdVar.h = true;
            } else if (cdVar.h) {
                continue;
            } else {
                cdVar.h = true;
                if (a) {
                    new StringBuilder("  Starting: ").append(cdVar);
                }
                if (cdVar.d == null && cdVar.c != null) {
                    cdVar.d = cdVar.c.a();
                }
                if (cdVar.d == null) {
                    continue;
                } else if (!cdVar.d.getClass().isMemberClass() || Modifier.isStatic(cdVar.d.getClass().getModifiers())) {
                    if (!cdVar.m) {
                        k kVar = cdVar.d;
                        int i = cdVar.a;
                        if (kVar.b != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        kVar.b = cdVar;
                        kVar.a = i;
                        kVar = cdVar.d;
                        if (kVar.c != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        kVar.c = cdVar;
                        cdVar.m = true;
                    }
                    k kVar2 = cdVar.d;
                    kVar2.d = true;
                    kVar2.f = false;
                    kVar2.e = false;
                } else {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + cdVar.d);
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
                ((cd) this.b.d(b)).a();
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
                cd cdVar = (cd) this.b.d(b);
                if (a) {
                    new StringBuilder("  Retaining: ").append(cdVar);
                }
                cdVar.i = true;
                cdVar.j = cdVar.h;
                cdVar.h = false;
                cdVar.c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    final void e() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((cd) this.b.d(b)).k = true;
        }
    }

    final void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            cd cdVar = (cd) this.b.d(b);
            if (cdVar.h && cdVar.k) {
                cdVar.k = false;
                if (cdVar.e) {
                    cdVar.a(cdVar.d, cdVar.g);
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
                ((cd) this.b.d(b)).b();
            }
            this.b.c();
        }
        if (a) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (b = this.c.b() - 1; b >= 0; b--) {
            ((cd) this.c.d(b)).b();
        }
        this.c.c();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        f.a(this.g, stringBuilder);
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
                cd cdVar = (cd) this.b.d(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.c(i2));
                printWriter.print(": ");
                printWriter.println(cdVar.toString());
                cdVar.a(str2, printWriter);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.c.b()) {
                cdVar = (cd) this.c.d(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.c(i));
                printWriter.print(": ");
                printWriter.println(cdVar.toString());
                cdVar.a(str3, printWriter);
                i++;
            }
        }
    }

    public final boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            cd cdVar = (cd) this.b.d(i);
            if (!cdVar.h || cdVar.f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
