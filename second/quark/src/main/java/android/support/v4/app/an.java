package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.d.b;
import android.support.v4.d.c;
import android.support.v4.d.l;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ProGuard */
final class an extends ay implements Runnable {
    static final boolean a = (VERSION.SDK_INT >= 21);
    final ah b;
    ae c;
    ae d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m = true;
    String n;
    boolean o;
    int p = -1;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList<String> u;
    ArrayList<String> v;

    static /* synthetic */ b a(an anVar, cb cbVar, boolean z, Fragment fragment) {
        b a;
        Map bVar = new b();
        View view = fragment.M;
        if (!(view == null || anVar.u == null)) {
            ab.a(bVar, view);
            if (z) {
                a = a(anVar.u, anVar.v, (b) bVar);
            } else {
                l.a(bVar, anVar.v);
            }
        }
        bk bkVar;
        if (z) {
            if (fragment.ac != null) {
                bkVar = fragment.ac;
            }
            anVar.a(cbVar, a, true);
        } else {
            if (fragment.ab != null) {
                bkVar = fragment.ab;
            }
            b(cbVar, a, true);
        }
        return a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.n);
            printWriter.print(" mIndex=");
            printWriter.print(this.p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.o);
            if (this.j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.k));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.h == 0 && this.i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (!(this.q == 0 && this.r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.r);
            }
            if (!(this.s == 0 && this.t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.t);
            }
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            ae aeVar = this.c;
            while (aeVar != null) {
                String str3;
                switch (aeVar.c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aeVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aeVar.d);
                if (z) {
                    if (!(aeVar.e == 0 && aeVar.f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aeVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aeVar.f));
                    }
                    if (!(aeVar.g == 0 && aeVar.h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aeVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aeVar.h));
                    }
                }
                if (aeVar.i != null && aeVar.i.size() > 0) {
                    for (int i2 = 0; i2 < aeVar.i.size(); i2++) {
                        printWriter.print(str2);
                        if (aeVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aeVar.i.get(i2));
                    }
                }
                aeVar = aeVar.a;
                i++;
            }
        }
    }

    public an(ah ahVar) {
        this.b = ahVar;
    }

    final void a(ae aeVar) {
        if (this.c == null) {
            this.d = aeVar;
            this.c = aeVar;
        } else {
            aeVar.b = this.d;
            this.d.a = aeVar;
            this.d = aeVar;
        }
        aeVar.e = this.f;
        aeVar.f = this.g;
        aeVar.g = this.h;
        aeVar.h = this.i;
        this.e++;
    }

    public final ay a(Fragment fragment, String str) {
        b(0, fragment, str);
        return this;
    }

    public final ay a(int i, Fragment fragment, String str) {
        b(i, fragment, str);
        return this;
    }

    private void b(int i, Fragment fragment, String str) {
        fragment.w = this.b;
        if (str != null) {
            if (fragment.C == null || str.equals(fragment.C)) {
                fragment.C = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.C + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.A == 0 || fragment.A == i) {
                fragment.A = i;
                fragment.B = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.A + " now " + i);
            }
        }
        ae aeVar = new ae();
        aeVar.c = 1;
        aeVar.d = fragment;
        a(aeVar);
    }

    public final ay a(Fragment fragment) {
        ae aeVar = new ae();
        aeVar.c = 6;
        aeVar.d = fragment;
        a(aeVar);
        return this;
    }

    public final ay b(Fragment fragment) {
        ae aeVar = new ae();
        aeVar.c = 7;
        aeVar.d = fragment;
        a(aeVar);
        return this;
    }

    final void a(int i) {
        if (this.l) {
            if (ah.a) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            for (ae aeVar = this.c; aeVar != null; aeVar = aeVar.a) {
                Fragment fragment;
                if (aeVar.d != null) {
                    fragment = aeVar.d;
                    fragment.v += i;
                    if (ah.a) {
                        new StringBuilder("Bump nesting of ").append(aeVar.d).append(" to ").append(aeVar.d.v);
                    }
                }
                if (aeVar.i != null) {
                    for (int size = aeVar.i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) aeVar.i.get(size);
                        fragment.v += i;
                        if (ah.a) {
                            new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.v);
                        }
                    }
                }
            }
        }
    }

    public final int a() {
        return a(false);
    }

    public final int b() {
        return a(true);
    }

    private int a(boolean z) {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (ah.a) {
            new StringBuilder("Commit: ").append(this);
            a("  ", new PrintWriter(new c("FragmentManager")));
        }
        this.o = true;
        if (this.l) {
            this.p = this.b.a(this);
        } else {
            this.p = -1;
        }
        ah ahVar = this.b;
        if (!z) {
            ahVar.d();
        }
        synchronized (ahVar) {
            if (ahVar.u || ahVar.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (ahVar.c == null) {
                ahVar.c = new ArrayList();
            }
            ahVar.c.add(this);
            if (ahVar.c.size() == 1) {
                ahVar.o.c.removeCallbacks(ahVar.z);
                ahVar.o.c.post(ahVar.z);
            }
        }
        return this.p;
    }

    public final void run() {
        if (ah.a) {
            new StringBuilder("Run: ").append(this);
        }
        if (!this.l || this.p >= 0) {
            cb a;
            a(1);
            if (!a || this.b.n <= 0) {
                Object obj = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                b(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            }
            int i = a != null ? 0 : this.k;
            int i2 = a != null ? 0 : this.j;
            ae aeVar = this.c;
            while (aeVar != null) {
                int i3 = a != null ? 0 : aeVar.e;
                int i4 = a != null ? 0 : aeVar.f;
                Fragment fragment;
                switch (aeVar.c) {
                    case 1:
                        fragment = aeVar.d;
                        fragment.K = i3;
                        this.b.a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = aeVar.d;
                        int i5 = fragment2.B;
                        if (this.b.g != null) {
                            int size = this.b.g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.b.g.get(size);
                                if (ah.a) {
                                    new StringBuilder("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment);
                                }
                                if (fragment.B == i5) {
                                    if (fragment == fragment2) {
                                        aeVar.d = null;
                                        fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (aeVar.i == null) {
                                            aeVar.i = new ArrayList();
                                        }
                                        aeVar.i.add(fragment);
                                        fragment.K = i4;
                                        if (this.l) {
                                            fragment.v++;
                                            if (ah.a) {
                                                new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.v);
                                            }
                                        }
                                        this.b.a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.K = i3;
                        this.b.a(fragment2, false);
                        break;
                    case 3:
                        fragment = aeVar.d;
                        fragment.K = i4;
                        this.b.a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = aeVar.d;
                        fragment.K = i4;
                        this.b.b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = aeVar.d;
                        fragment.K = i3;
                        this.b.c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = aeVar.d;
                        fragment.K = i4;
                        this.b.d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = aeVar.d;
                        fragment.K = i3;
                        this.b.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aeVar.c);
                }
                aeVar = aeVar.a;
            }
            this.b.a(this.b.n, i2, i, true);
            if (this.l) {
                ah ahVar = this.b;
                if (ahVar.i == null) {
                    ahVar.i = new ArrayList();
                }
                ahVar.i.add(this);
                ahVar.f();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.B;
            if (i != 0 && !fragment.D) {
                if (fragment.f() && fragment.M != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.B;
            if (i != 0) {
                if (!fragment.f()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.f <= 0 && this.b.n > 0) {
                this.b.a(fragment);
                this.b.a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.p.a()) {
            for (ae aeVar = this.c; aeVar != null; aeVar = aeVar.a) {
                switch (aeVar.c) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 2:
                        Fragment fragment = aeVar.d;
                        if (this.b.g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.b.g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.b.g.get(i);
                                if (fragment2 == null || fragment3.B == fragment2.B) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.B);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.p.a()) {
            for (ae aeVar = this.d; aeVar != null; aeVar = aeVar.b) {
                switch (aeVar.c) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 2:
                        if (aeVar.i != null) {
                            for (int size = aeVar.i.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) aeVar.i.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aeVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final cb a(cb cbVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (ah.a) {
            new StringBuilder("popFromBackStack: ").append(this);
            a("  ", new PrintWriter(new c("FragmentManager")));
        }
        if (a && this.b.n > 0 && !(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
            cbVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
        }
        a(-1);
        int i = cbVar != null ? 0 : this.k;
        int i2 = cbVar != null ? 0 : this.j;
        ae aeVar = this.d;
        while (aeVar != null) {
            int i3 = cbVar != null ? 0 : aeVar.g;
            int i4 = cbVar != null ? 0 : aeVar.h;
            Fragment fragment;
            Fragment fragment2;
            switch (aeVar.c) {
                case 1:
                    fragment = aeVar.d;
                    fragment.K = i4;
                    this.b.a(fragment, ah.b(i2), i);
                    break;
                case 2:
                    fragment = aeVar.d;
                    if (fragment != null) {
                        fragment.K = i4;
                        this.b.a(fragment, ah.b(i2), i);
                    }
                    if (aeVar.i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aeVar.i.size(); i5++) {
                        fragment2 = (Fragment) aeVar.i.get(i5);
                        fragment2.K = i3;
                        this.b.a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = aeVar.d;
                    fragment2.K = i3;
                    this.b.a(fragment2, false);
                    break;
                case 4:
                    fragment2 = aeVar.d;
                    fragment2.K = i3;
                    this.b.c(fragment2, ah.b(i2), i);
                    break;
                case 5:
                    fragment = aeVar.d;
                    fragment.K = i4;
                    this.b.b(fragment, ah.b(i2), i);
                    break;
                case 6:
                    fragment2 = aeVar.d;
                    fragment2.K = i3;
                    this.b.e(fragment2, ah.b(i2), i);
                    break;
                case 7:
                    fragment2 = aeVar.d;
                    fragment2.K = i3;
                    this.b.d(fragment2, ah.b(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aeVar.c);
            }
            aeVar = aeVar.b;
        }
        this.b.a(this.b.n, ah.b(i2), i, true);
        if (this.p >= 0) {
            ah ahVar = this.b;
            i4 = this.p;
            synchronized (ahVar) {
                ahVar.k.set(i4, null);
                if (ahVar.l == null) {
                    ahVar.l = new ArrayList();
                }
                boolean z = ah.a;
                ahVar.l.add(Integer.valueOf(i4));
            }
            this.p = -1;
        }
        return null;
    }

    private cb a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        cb cbVar = new cb(this);
        cbVar.d = new View(this.b.o.b);
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (a(sparseArray.keyAt(i2), cbVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && a(i4, cbVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return cbVar;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, b<String, View> bVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = fragment.M;
        if (obj == null) {
            return obj;
        }
        ab.a((ArrayList) arrayList, view2);
        if (bVar != null) {
            arrayList.removeAll(bVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        ab.b((Transition) obj, arrayList);
        return obj;
    }

    private b<String, View> a(cb cbVar, Fragment fragment, boolean z) {
        b bVar = new b();
        if (this.u != null) {
            ab.a((Map) bVar, fragment.M);
            if (z) {
                l.a((Map) bVar, this.v);
            } else {
                bVar = a(this.u, this.v, bVar);
            }
        }
        bk bkVar;
        if (z) {
            if (fragment.ab != null) {
                bkVar = fragment.ab;
            }
            a(cbVar, bVar, false);
        } else {
            if (fragment.ac != null) {
                bkVar = fragment.ac;
            }
            b(cbVar, bVar, false);
        }
        return bVar;
    }

    private boolean a(int i, cb cbVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.b.p.a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Object obj3;
        Transition transition;
        Object obj4;
        Object obj5;
        ArrayList arrayList;
        View view2;
        w btVar;
        ArrayList arrayList2;
        Map bVar;
        boolean z2;
        Transition transition2;
        Transition transition3;
        TransitionSet transitionSet;
        Object transitionSet2;
        View view3;
        ArrayList arrayList3;
        Transition transition4;
        Transition transition5;
        Transition transition6;
        Transition transition7;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        if (fragment == null) {
            obj = null;
        } else {
            if (!z) {
                obj2 = fragment.T;
            } else if (fragment.W == Fragment.e) {
                obj2 = fragment.V;
            } else {
                obj2 = fragment.W;
            }
            obj = ab.a(obj2);
        }
        if (fragment == null || fragment2 == null) {
            obj3 = null;
        } else {
            if (!z) {
                obj2 = fragment.X;
            } else if (fragment2.Y == Fragment.e) {
                obj2 = fragment2.X;
            } else {
                obj2 = fragment2.Y;
            }
            if (obj2 == null) {
                obj3 = null;
            } else {
                transition = (Transition) obj2;
                if (transition == null) {
                    obj3 = null;
                } else {
                    obj3 = new TransitionSet();
                    obj3.addTransition(transition);
                }
            }
        }
        if (fragment2 == null) {
            obj4 = null;
        } else {
            if (!z) {
                obj2 = fragment2.V;
            } else if (fragment2.U == Fragment.e) {
                obj2 = fragment2.T;
            } else {
                obj2 = fragment2.U;
            }
            obj4 = ab.a(obj2);
        }
        Map map = null;
        ArrayList arrayList4 = new ArrayList();
        if (obj3 != null) {
            map = a(cbVar, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj5 = null;
                if (obj != null && obj5 == null && obj4 == null) {
                    return false;
                }
                arrayList = new ArrayList();
                obj3 = a(obj4, fragment2, arrayList, (b) map, cbVar.d);
                if (!(this.v == null || map == null)) {
                    view2 = (View) map.get(this.v.get(0));
                    if (view2 != null) {
                        if (obj3 != null) {
                            ab.a(obj3, view2);
                        }
                        if (obj5 != null) {
                            ab.a(obj5, view2);
                        }
                    }
                }
                btVar = new bt(this, fragment);
                arrayList2 = new ArrayList();
                bVar = new b();
                if (fragment == null) {
                    boolean booleanValue = z ? fragment.Z != null ? true : fragment.Z.booleanValue() : fragment.aa != null ? true : fragment.aa.booleanValue();
                    z2 = booleanValue;
                } else {
                    z2 = true;
                }
                transition = (Transition) obj;
                transition2 = (Transition) obj3;
                transition3 = (Transition) obj5;
                if (transition == null || transition2 == null) {
                    z2 = true;
                }
                if (z2) {
                    if (transition2 == null && transition != null) {
                        transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
                    } else if (transition2 != null) {
                        transition = transition2;
                    } else if (transition == null) {
                        transition = null;
                    }
                    if (transition3 == null) {
                        transitionSet = new TransitionSet();
                        if (transition != null) {
                            transitionSet.addTransition(transition);
                        }
                        transitionSet.addTransition(transition3);
                    } else {
                        Transition transition8 = transition;
                    }
                } else {
                    transitionSet2 = new TransitionSet();
                    if (transition != null) {
                        transitionSet2.addTransition(transition);
                    }
                    if (transition2 != null) {
                        transitionSet2.addTransition(transition2);
                    }
                    if (transition3 != null) {
                        transitionSet2.addTransition(transition3);
                    }
                }
                if (transitionSet2 != null) {
                    ab.a(obj, obj5, view, btVar, cbVar.d, cbVar.c, cbVar.a, arrayList2, map, bVar, arrayList4);
                    view.getViewTreeObserver().addOnPreDrawListener(new ck(this, view, cbVar, i, transitionSet2));
                    ab.a(transitionSet2, cbVar.d, true);
                    a(cbVar, i, transitionSet2);
                    TransitionManager.beginDelayedTransition(view, (Transition) transitionSet2);
                    view3 = cbVar.d;
                    arrayList3 = cbVar.b;
                    transition4 = (Transition) obj;
                    transition5 = (Transition) obj3;
                    transition6 = (Transition) obj5;
                    transition7 = (Transition) transitionSet2;
                    if (transition7 != null) {
                        view.getViewTreeObserver().addOnPreDrawListener(new ad(view, transition4, arrayList2, transition5, arrayList, transition6, arrayList4, bVar, arrayList3, transition7, view3));
                    }
                }
                if (transitionSet2 == null) {
                    return true;
                }
                return false;
            }
            if ((z ? fragment2.ab : fragment.ab) != null) {
                ArrayList arrayList5 = new ArrayList(map.keySet());
                arrayList5 = new ArrayList(map.values());
            }
            view.getViewTreeObserver().addOnPreDrawListener(new bi(this, view, obj3, arrayList4, cbVar, z, fragment, fragment2));
        }
        obj5 = obj3;
        if (obj != null) {
        }
        arrayList = new ArrayList();
        obj3 = a(obj4, fragment2, arrayList, (b) map, cbVar.d);
        view2 = (View) map.get(this.v.get(0));
        if (view2 != null) {
            if (obj3 != null) {
                ab.a(obj3, view2);
            }
            if (obj5 != null) {
                ab.a(obj5, view2);
            }
        }
        btVar = new bt(this, fragment);
        arrayList2 = new ArrayList();
        bVar = new b();
        if (fragment == null) {
            z2 = true;
        } else {
            if (z) {
                if (fragment.Z != null) {
                }
            }
            z2 = booleanValue;
        }
        transition = (Transition) obj;
        transition2 = (Transition) obj3;
        transition3 = (Transition) obj5;
        z2 = true;
        if (z2) {
            if (transition2 == null) {
            }
            if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 == null) {
                Transition transition82 = transition;
            } else {
                transitionSet = new TransitionSet();
                if (transition != null) {
                    transitionSet.addTransition(transition);
                }
                transitionSet.addTransition(transition3);
            }
        } else {
            transitionSet2 = new TransitionSet();
            if (transition != null) {
                transitionSet2.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet2.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet2.addTransition(transition3);
            }
        }
        if (transitionSet2 != null) {
            ab.a(obj, obj5, view, btVar, cbVar.d, cbVar.c, cbVar.a, arrayList2, map, bVar, arrayList4);
            view.getViewTreeObserver().addOnPreDrawListener(new ck(this, view, cbVar, i, transitionSet2));
            ab.a(transitionSet2, cbVar.d, true);
            a(cbVar, i, transitionSet2);
            TransitionManager.beginDelayedTransition(view, (Transition) transitionSet2);
            view3 = cbVar.d;
            arrayList3 = cbVar.b;
            transition4 = (Transition) obj;
            transition5 = (Transition) obj3;
            transition6 = (Transition) obj5;
            transition7 = (Transition) transitionSet2;
            if (transition7 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new ad(view, transition4, arrayList2, transition5, arrayList, transition6, arrayList4, bVar, arrayList3, transition7, view3));
            }
        }
        if (transitionSet2 == null) {
            return false;
        }
        return true;
    }

    private static b<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, b<String, View> bVar) {
        if (bVar.isEmpty()) {
            return bVar;
        }
        b<String, View> bVar2 = new b();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) bVar.get(arrayList.get(i));
            if (view != null) {
                bVar2.put(arrayList2.get(i), view);
            }
        }
        return bVar2;
    }

    private void a(cb cbVar, int i, Object obj) {
        if (this.b.g != null) {
            for (int i2 = 0; i2 < this.b.g.size(); i2++) {
                Fragment fragment = (Fragment) this.b.g.get(i2);
                if (!(fragment.M == null || fragment.L == null || fragment.B != i)) {
                    if (!fragment.D) {
                        ab.a(obj, fragment.M, false);
                        cbVar.b.remove(fragment.M);
                    } else if (!cbVar.b.contains(fragment.M)) {
                        ab.a(obj, fragment.M, true);
                        cbVar.b.add(fragment.M);
                    }
                }
            }
        }
    }

    private static void a(b<String, String> bVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < bVar.size(); i++) {
                if (str.equals(bVar.c(i))) {
                    bVar.a(i, (Object) str2);
                    return;
                }
            }
            bVar.put(str, str2);
        }
    }

    private void a(cb cbVar, b<String, View> bVar, boolean z) {
        int size = this.v == null ? 0 : this.v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.u.get(i);
            View view = (View) bVar.get((String) this.v.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(cbVar.a, str, transitionName);
                } else {
                    a(cbVar.a, transitionName, str);
                }
            }
        }
    }

    private static void b(cb cbVar, b<String, View> bVar, boolean z) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) bVar.b(i);
            String transitionName = ((View) bVar.c(i)).getTransitionName();
            if (z) {
                a(cbVar.a, str, transitionName);
            } else {
                a(cbVar.a, transitionName, str);
            }
        }
    }

    static /* synthetic */ void a(an anVar, b bVar, cb cbVar) {
        if (anVar.v != null && !bVar.isEmpty()) {
            View view = (View) bVar.get(anVar.v.get(0));
            if (view != null) {
                cbVar.c.a = view;
            }
        }
    }

    static /* synthetic */ void a(Fragment fragment, Fragment fragment2, boolean z, b bVar) {
        if ((z ? fragment2.ab : fragment.ab) != null) {
            ArrayList arrayList = new ArrayList(bVar.keySet());
            arrayList = new ArrayList(bVar.values());
        }
    }
}
