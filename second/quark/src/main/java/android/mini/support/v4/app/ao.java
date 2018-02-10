package android.mini.support.v4.app;

import android.mini.support.v4.b.a;
import android.mini.support.v4.b.b;
import android.mini.support.v4.b.c;
import android.mini.support.v4.d.d;
import android.os.Bundle;
import java.io.PrintWriter;

/* compiled from: ProGuard */
final class ao implements a<Object>, b<Object> {
    final int a;
    final Bundle b;
    am<Object> c;
    c<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    ao n;
    final /* synthetic */ ap o;

    final void a() {
        if (ap.a) {
            new StringBuilder("  Stopping: ").append(this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a((b) this);
            this.d.a((a) this);
            this.d.d = false;
        }
    }

    final void b() {
        while (true) {
            a aVar;
            if (ap.a) {
                new StringBuilder("  Destroying: ").append(aVar);
            }
            aVar.l = true;
            boolean z = aVar.f;
            aVar.f = false;
            if (aVar.c != null && aVar.d != null && aVar.e && z) {
                String str;
                if (ap.a) {
                    new StringBuilder("  Reseting: ").append(aVar);
                }
                if (aVar.o.g != null) {
                    str = aVar.o.g.f.v;
                    aVar.o.g.f.v = "onLoaderReset";
                } else {
                    str = null;
                }
                if (aVar.o.g != null) {
                    aVar.o.g.f.v = str;
                }
            }
            aVar.c = null;
            aVar.g = null;
            aVar.e = false;
            if (aVar.d != null) {
                if (aVar.m) {
                    aVar.m = false;
                    aVar.d.a((b) aVar);
                    aVar.d.a(aVar);
                }
                c cVar = aVar.d;
                cVar.f = true;
                cVar.d = false;
                cVar.e = false;
                cVar.g = false;
                cVar.h = false;
            }
            if (aVar.n != null) {
                aVar = aVar.n;
            } else {
                return;
            }
        }
    }

    final void a(c<Object> cVar, Object obj) {
        if (this.c != null) {
            String str;
            if (this.o.g != null) {
                String str2 = this.o.g.f.v;
                this.o.g.f.v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (ap.a) {
                    StringBuilder append = new StringBuilder("  onLoadFinished in ").append(cVar).append(": ");
                    StringBuilder stringBuilder = new StringBuilder(64);
                    d.a(obj, stringBuilder);
                    stringBuilder.append("}");
                    append.append(stringBuilder.toString());
                }
                if (this.o.g != null) {
                    this.o.g.f.v = str;
                }
                this.f = true;
            } catch (Throwable th) {
                if (this.o.g != null) {
                    this.o.g.f.v = str;
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
        d.a(this.d, stringBuilder);
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
                c cVar = this.d;
                String str2 = str + "  ";
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(cVar.a);
                printWriter.print(" mListener=");
                printWriter.println(cVar.b);
                if (cVar.d || cVar.g || cVar.h) {
                    printWriter.print(str2);
                    printWriter.print("mStarted=");
                    printWriter.print(cVar.d);
                    printWriter.print(" mContentChanged=");
                    printWriter.print(cVar.g);
                    printWriter.print(" mProcessingChange=");
                    printWriter.println(cVar.h);
                }
                if (cVar.e || cVar.f) {
                    printWriter.print(str2);
                    printWriter.print("mAbandoned=");
                    printWriter.print(cVar.e);
                    printWriter.print(" mReset=");
                    printWriter.println(cVar.f);
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
