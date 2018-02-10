package android.mini.support.v4.app;

import android.mini.support.v4.d.b;
import android.mini.support.v4.d.e;
import android.mini.support.v4.d.l;
import android.os.Build.VERSION;
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
final class f extends FragmentTransaction implements Runnable {
    static final boolean a = (VERSION.SDK_INT >= 21);
    final ab b;
    d c;
    d d;
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

    static /* synthetic */ b a(f fVar, e eVar, boolean z, Fragment fragment) {
        b a;
        Map bVar = new b();
        View view = fragment.S;
        if (!(view == null || fVar.u == null)) {
            al.a(bVar, view);
            if (z) {
                a = a(fVar.u, fVar.v, (b) bVar);
            } else {
                l.a(bVar, fVar.v);
            }
        }
        ar arVar;
        if (z) {
            if (fragment.ai != null) {
                arVar = fragment.ai;
            }
            fVar.a(eVar, a, true);
        } else {
            if (fragment.ah != null) {
                arVar = fragment.ah;
            }
            b(eVar, a, true);
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
            d dVar = this.c;
            while (dVar != null) {
                String str3;
                switch (dVar.c) {
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
                        str3 = "cmd=" + dVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(dVar.d);
                if (z) {
                    if (!(dVar.e == 0 && dVar.f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f));
                    }
                    if (!(dVar.g == 0 && dVar.h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.h));
                    }
                }
                if (dVar.i != null && dVar.i.size() > 0) {
                    for (int i2 = 0; i2 < dVar.i.size(); i2++) {
                        printWriter.print(str2);
                        if (dVar.i.size() == 1) {
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
                        printWriter.println(dVar.i.get(i2));
                    }
                }
                dVar = dVar.a;
                i++;
            }
        }
    }

    public f(ab abVar) {
        this.b = abVar;
    }

    final void a(d dVar) {
        if (this.c == null) {
            this.d = dVar;
            this.c = dVar;
        } else {
            dVar.b = this.d;
            this.d.a = dVar;
            this.d = dVar;
        }
        dVar.e = this.f;
        dVar.f = this.g;
        dVar.g = this.h;
        dVar.h = this.i;
        this.e++;
    }

    public final FragmentTransaction a(Fragment fragment) {
        d dVar = new d();
        dVar.c = 3;
        dVar.d = fragment;
        a(dVar);
        return this;
    }

    final void a(int i) {
        if (this.l) {
            if (ab.a) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            for (d dVar = this.c; dVar != null; dVar = dVar.a) {
                Fragment fragment;
                if (dVar.d != null) {
                    fragment = dVar.d;
                    fragment.A += i;
                    if (ab.a) {
                        new StringBuilder("Bump nesting of ").append(dVar.d).append(" to ").append(dVar.d.A);
                    }
                }
                if (dVar.i != null) {
                    for (int size = dVar.i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) dVar.i.get(size);
                        fragment.A += i;
                        if (ab.a) {
                            new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.A);
                        }
                    }
                }
            }
        }
    }

    public final int a() {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (ab.a) {
            new StringBuilder("Commit: ").append(this);
            a("  ", new PrintWriter(new e("FragmentManager")));
        }
        this.o = true;
        if (this.l) {
            this.p = this.b.a(this);
        } else {
            this.p = -1;
        }
        this.b.a((Runnable) this, true);
        return this.p;
    }

    public final void run() {
        if (ab.a) {
            new StringBuilder("Run: ").append(this);
        }
        if (!this.l || this.p >= 0) {
            e a;
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
            d dVar = this.c;
            while (dVar != null) {
                int i3 = a != null ? 0 : dVar.e;
                int i4 = a != null ? 0 : dVar.f;
                Fragment fragment;
                switch (dVar.c) {
                    case 1:
                        fragment = dVar.d;
                        fragment.Q = i3;
                        this.b.a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = dVar.d;
                        int i5 = fragment2.H;
                        if (this.b.g != null) {
                            int size = this.b.g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.b.g.get(size);
                                if (ab.a) {
                                    new StringBuilder("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment);
                                }
                                if (fragment.H == i5) {
                                    if (fragment == fragment2) {
                                        dVar.d = null;
                                        fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (dVar.i == null) {
                                            dVar.i = new ArrayList();
                                        }
                                        dVar.i.add(fragment);
                                        fragment.Q = i4;
                                        if (this.l) {
                                            fragment.A++;
                                            if (ab.a) {
                                                new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.A);
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
                        fragment2.Q = i3;
                        this.b.a(fragment2, false);
                        break;
                    case 3:
                        fragment = dVar.d;
                        fragment.Q = i4;
                        this.b.a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = dVar.d;
                        fragment.Q = i4;
                        this.b.b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = dVar.d;
                        fragment.Q = i3;
                        this.b.c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = dVar.d;
                        fragment.Q = i4;
                        this.b.d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = dVar.d;
                        fragment.Q = i3;
                        this.b.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + dVar.c);
                }
                dVar = dVar.a;
            }
            this.b.a(this.b.n, i2, i, true);
            if (this.l) {
                ab abVar = this.b;
                if (abVar.i == null) {
                    abVar.i = new ArrayList();
                }
                abVar.i.add(this);
                abVar.d();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.H;
            if (i != 0 && !fragment.J) {
                if (fragment.f() && fragment.S != null && sparseArray.get(i) == null) {
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
            int i = fragment.H;
            if (i != 0) {
                if (!fragment.f()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.k <= 0 && this.b.n > 0) {
                this.b.a(fragment);
                this.b.a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.p.a()) {
            for (d dVar = this.c; dVar != null; dVar = dVar.a) {
                switch (dVar.c) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 2:
                        Fragment fragment = dVar.d;
                        if (this.b.g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.b.g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.b.g.get(i);
                                if (fragment2 == null || fragment3.H == fragment2.H) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.H);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.p.a()) {
            for (d dVar = this.d; dVar != null; dVar = dVar.b) {
                switch (dVar.c) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 2:
                        if (dVar.i != null) {
                            for (int size = dVar.i.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) dVar.i.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, dVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final e a(boolean z, e eVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (ab.a) {
            new StringBuilder("popFromBackStack: ").append(this);
            a("  ", new PrintWriter(new e("FragmentManager")));
        }
        if (a && this.b.n > 0) {
            if (eVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    eVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                a(eVar, this.v, this.u);
            }
        }
        a(-1);
        int i = eVar != null ? 0 : this.k;
        int i2 = eVar != null ? 0 : this.j;
        d dVar = this.d;
        while (dVar != null) {
            int i3 = eVar != null ? 0 : dVar.g;
            int i4 = eVar != null ? 0 : dVar.h;
            Fragment fragment;
            Fragment fragment2;
            switch (dVar.c) {
                case 1:
                    fragment = dVar.d;
                    fragment.Q = i4;
                    this.b.a(fragment, ab.c(i2), i);
                    break;
                case 2:
                    fragment = dVar.d;
                    if (fragment != null) {
                        fragment.Q = i4;
                        this.b.a(fragment, ab.c(i2), i);
                    }
                    if (dVar.i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < dVar.i.size(); i5++) {
                        fragment2 = (Fragment) dVar.i.get(i5);
                        fragment2.Q = i3;
                        this.b.a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = dVar.d;
                    fragment2.Q = i3;
                    this.b.a(fragment2, false);
                    break;
                case 4:
                    fragment2 = dVar.d;
                    fragment2.Q = i3;
                    this.b.c(fragment2, ab.c(i2), i);
                    break;
                case 5:
                    fragment = dVar.d;
                    fragment.Q = i4;
                    this.b.b(fragment, ab.c(i2), i);
                    break;
                case 6:
                    fragment2 = dVar.d;
                    fragment2.Q = i3;
                    this.b.e(fragment2, ab.c(i2), i);
                    break;
                case 7:
                    fragment2 = dVar.d;
                    fragment2.Q = i3;
                    this.b.d(fragment2, ab.c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar.c);
            }
            dVar = dVar.b;
        }
        if (z) {
            this.b.a(this.b.n, ab.c(i2), i, true);
            eVar = null;
        }
        if (this.p >= 0) {
            ab abVar = this.b;
            i4 = this.p;
            synchronized (abVar) {
                abVar.k.set(i4, null);
                if (abVar.l == null) {
                    abVar.l = new ArrayList();
                }
                boolean z2 = ab.a;
                abVar.l.add(Integer.valueOf(i4));
            }
            this.p = -1;
        }
        return eVar;
    }

    private e a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i;
        int i2 = 0;
        e eVar = new e(this);
        eVar.d = new View(this.b.o.c);
        int i3 = 0;
        int i4 = 0;
        while (i3 < sparseArray.size()) {
            if (a(sparseArray.keyAt(i3), eVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i = 1;
            } else {
                i = i4;
            }
            i3++;
            i4 = i;
        }
        while (i2 < sparseArray2.size()) {
            i = sparseArray2.keyAt(i2);
            if (sparseArray.get(i) == null && a(i, eVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            }
            i2++;
        }
        if (i4 == 0) {
            return null;
        }
        return eVar;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, b<String, View> bVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = fragment.S;
        if (obj == null) {
            return obj;
        }
        al.a((ArrayList) arrayList, view2);
        if (bVar != null) {
            arrayList.removeAll(bVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        al.b((Transition) obj, arrayList);
        return obj;
    }

    private b<String, View> a(e eVar, Fragment fragment, boolean z) {
        b bVar = new b();
        if (this.u != null) {
            al.a((Map) bVar, fragment.S);
            if (z) {
                l.a((Map) bVar, this.v);
            } else {
                bVar = a(this.u, this.v, bVar);
            }
        }
        ar arVar;
        if (z) {
            if (fragment.ah != null) {
                arVar = fragment.ah;
            }
            a(eVar, bVar, false);
        } else {
            if (fragment.ai != null) {
                arVar = fragment.ai;
            }
            b(eVar, bVar, false);
        }
        return bVar;
    }

    private boolean a(int i, e eVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.b.p.a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Object obj3;
        Transition transition;
        Object obj4;
        b bVar;
        Object obj5;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        if (fragment == null) {
            obj = null;
        } else {
            if (!z) {
                obj2 = fragment.Z;
            } else if (fragment.ac == Fragment.j) {
                obj2 = fragment.ab;
            } else {
                obj2 = fragment.ac;
            }
            obj = al.a(obj2);
        }
        if (fragment == null || fragment2 == null) {
            obj3 = null;
        } else {
            if (!z) {
                obj2 = fragment.ad;
            } else if (fragment2.ae == Fragment.j) {
                obj2 = fragment2.ad;
            } else {
                obj2 = fragment2.ae;
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
                obj2 = fragment2.ab;
            } else if (fragment2.aa == Fragment.j) {
                obj2 = fragment2.Z;
            } else {
                obj2 = fragment2.aa;
            }
            obj4 = al.a(obj2);
        }
        ArrayList arrayList = new ArrayList();
        if (obj3 != null) {
            b a = a(eVar, fragment2, z);
            if (a.isEmpty()) {
                bVar = null;
                obj5 = null;
            } else {
                if ((z ? fragment2.ah : fragment.ah) != null) {
                    ArrayList arrayList2 = new ArrayList(a.keySet());
                    arrayList2 = new ArrayList(a.values());
                }
                if (obj3 != null) {
                    view.getViewTreeObserver().addOnPreDrawListener(new b(this, view, obj3, arrayList, eVar, obj, obj4, z, fragment, fragment2));
                }
                bVar = a;
                obj5 = obj3;
            }
        } else {
            bVar = null;
            obj5 = obj3;
        }
        if (obj == null && obj5 == null && obj4 == null) {
            return false;
        }
        boolean z2;
        Object obj6;
        ArrayList arrayList3 = new ArrayList();
        obj3 = a(obj4, fragment2, arrayList3, bVar, eVar.d);
        if (!(this.v == null || bVar == null)) {
            View view2 = (View) bVar.get(this.v.get(0));
            if (view2 != null) {
                if (obj3 != null) {
                    al.a(obj3, view2);
                }
                if (obj5 != null) {
                    al.a(obj5, view2);
                }
            }
        }
        ak aVar = new a(this, fragment);
        ArrayList arrayList4 = new ArrayList();
        Map bVar2 = new b();
        if (fragment != null) {
            boolean booleanValue = z ? fragment.af == null ? true : fragment.af.booleanValue() : fragment.ag == null ? true : fragment.ag.booleanValue();
            z2 = booleanValue;
        } else {
            z2 = true;
        }
        transition = (Transition) obj;
        Transition transition2 = (Transition) obj3;
        Transition transition3 = (Transition) obj5;
        if (transition == null || transition2 == null) {
            z2 = true;
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            obj6 = transitionSet;
        } else {
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                obj6 = new TransitionSet();
                if (transition != null) {
                    obj6.addTransition(transition);
                }
                obj6.addTransition(transition3);
            } else {
                transition2 = transition;
            }
        }
        if (obj6 != null) {
            View view3 = eVar.d;
            aj ajVar = eVar.c;
            Map map = eVar.a;
            Transition transition4 = (Transition) obj;
            Transition transition5 = (Transition) obj3;
            transition = (Transition) obj5;
            al.a(transition4, transition5, arrayList3, true);
            if (!(obj == null && obj5 == null)) {
                if (transition4 != null) {
                    transition4.addTarget(view3);
                }
                if (obj5 != null) {
                    al.a((Object) transition, view3, (Map) bVar, arrayList);
                    al.a(transition4, transition, arrayList, true);
                    al.a(transition5, transition, arrayList, true);
                }
                view.getViewTreeObserver().addOnPreDrawListener(new ag(view, transition4, view3, aVar, map, bVar2, arrayList4, transition5));
                if (transition4 != null) {
                    transition4.setEpicenterCallback(new ah(ajVar));
                }
            }
            view.getViewTreeObserver().addOnPreDrawListener(new c(this, view, eVar, i, obj6));
            al.a(obj6, eVar.d, true);
            a(eVar, i, obj6);
            TransitionManager.beginDelayedTransition(view, (Transition) obj6);
            View view4 = eVar.d;
            ArrayList arrayList5 = eVar.b;
            Transition transition6 = (Transition) obj;
            Transition transition7 = (Transition) obj3;
            Transition transition8 = (Transition) obj5;
            Transition transition9 = (Transition) obj6;
            if (transition9 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new ai(view, transition6, arrayList4, transition7, arrayList3, transition8, arrayList, bVar2, arrayList5, transition9, view4));
            }
        }
        if (obj6 != null) {
            return true;
        }
        return false;
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

    private void a(e eVar, int i, Object obj) {
        if (this.b.g != null) {
            for (int i2 = 0; i2 < this.b.g.size(); i2++) {
                Fragment fragment = (Fragment) this.b.g.get(i2);
                if (!(fragment.S == null || fragment.R == null || fragment.H != i)) {
                    if (!fragment.J) {
                        al.a(obj, fragment.S, false);
                        eVar.b.remove(fragment.S);
                    } else if (!eVar.b.contains(fragment.S)) {
                        al.a(obj, fragment.S, true);
                        eVar.b.add(fragment.S);
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

    private static void a(e eVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(eVar.a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void a(e eVar, b<String, View> bVar, boolean z) {
        int size = this.v == null ? 0 : this.v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.u.get(i);
            View view = (View) bVar.get((String) this.v.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(eVar.a, str, transitionName);
                } else {
                    a(eVar.a, transitionName, str);
                }
            }
        }
    }

    private static void b(e eVar, b<String, View> bVar, boolean z) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) bVar.b(i);
            String transitionName = ((View) bVar.c(i)).getTransitionName();
            if (z) {
                a(eVar.a, str, transitionName);
            } else {
                a(eVar.a, transitionName, str);
            }
        }
    }

    static /* synthetic */ void a(f fVar, b bVar, e eVar) {
        if (fVar.v != null && !bVar.isEmpty()) {
            View view = (View) bVar.get(fVar.v.get(0));
            if (view != null) {
                eVar.c.a = view;
            }
        }
    }

    static /* synthetic */ void a(Fragment fragment, Fragment fragment2, boolean z, b bVar) {
        if ((z ? fragment2.ah : fragment.ah) != null) {
            ArrayList arrayList = new ArrayList(bVar.keySet());
            arrayList = new ArrayList(bVar.values());
        }
    }
}
