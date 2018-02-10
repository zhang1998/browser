package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c;
import android.support.v4.content.i;
import android.support.v4.content.k;
import android.support.v4.d.f;
import java.io.PrintWriter;

/* compiled from: ProGuard */
final class cd implements c<Object>, i<Object> {
    final int a;
    final Bundle b;
    cn<Object> c;
    k<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    cd n;
    final /* synthetic */ cs o;

    final void a() {
        if (cs.a) {
            new StringBuilder("  Stopping: ").append(this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a((i) this);
            this.d.a((c) this);
            this.d.d = false;
        }
    }

    final void b() {
        while (true) {
            c cVar;
            if (cs.a) {
                new StringBuilder("  Destroying: ").append(cVar);
            }
            cVar.l = true;
            boolean z = cVar.f;
            cVar.f = false;
            if (cVar.c != null && cVar.d != null && cVar.e && z) {
                String str;
                if (cs.a) {
                    new StringBuilder("  Reseting: ").append(cVar);
                }
                if (cVar.o.g != null) {
                    str = cVar.o.g.e.v;
                    cVar.o.g.e.v = "onLoaderReset";
                } else {
                    str = null;
                }
                if (cVar.o.g != null) {
                    cVar.o.g.e.v = str;
                }
            }
            cVar.c = null;
            cVar.g = null;
            cVar.e = false;
            if (cVar.d != null) {
                if (cVar.m) {
                    cVar.m = false;
                    cVar.d.a((i) cVar);
                    cVar.d.a(cVar);
                }
                k kVar = cVar.d;
                kVar.f = true;
                kVar.d = false;
                kVar.e = false;
                kVar.g = false;
                kVar.h = false;
            }
            if (cVar.n != null) {
                cVar = cVar.n;
            } else {
                return;
            }
        }
    }

    final void a(k<Object> kVar, Object obj) {
        if (this.c != null) {
            String str;
            if (this.o.g != null) {
                String str2 = this.o.g.e.v;
                this.o.g.e.v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (cs.a) {
                    StringBuilder append = new StringBuilder("  onLoadFinished in ").append(kVar).append(": ");
                    StringBuilder stringBuilder = new StringBuilder(64);
                    f.a(obj, stringBuilder);
                    stringBuilder.append("}");
                    append.append(stringBuilder.toString());
                }
                if (this.o.g != null) {
                    this.o.g.e.v = str;
                }
                this.f = true;
            } catch (Throwable th) {
                if (this.o.g != null) {
                    this.o.g.e.v = str;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.a);
        stringBuilder.append(" : ");
        f.a(this.d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        while (true) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                k kVar = this.d;
                String str2 = str + "  ";
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(kVar.a);
                printWriter.print(" mListener=");
                printWriter.println(kVar.b);
                if (kVar.d || kVar.g || kVar.h) {
                    printWriter.print(str2);
                    printWriter.print("mStarted=");
                    printWriter.print(kVar.d);
                    printWriter.print(" mContentChanged=");
                    printWriter.print(kVar.g);
                    printWriter.print(" mProcessingChange=");
                    printWriter.println(kVar.h);
                }
                if (kVar.e || kVar.f) {
                    printWriter.print(str2);
                    printWriter.print("mAbandoned=");
                    printWriter.print(kVar.e);
                    printWriter.print(" mReset=");
                    printWriter.println(kVar.f);
                }
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this = this.n;
                str = str + "  ";
            } else {
                return;
            }
        }
    }
}
