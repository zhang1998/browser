package com.ucpro.feature.t;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class h implements p {
    ArrayList<q> a;
    ArrayList<WeakReference> b = new ArrayList();
    ArrayList<Integer> c = new ArrayList();
    boolean d;
    private Drawable e;
    private Drawable f;

    public final void a(ArrayList<Integer> arrayList, SparseArray<Drawable> sparseArray, SparseArray<String> sparseArray2) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            q qVar = new q();
            qVar.c = ((Integer) arrayList.get(size)).intValue();
            qVar.a = (Drawable) sparseArray.get(qVar.c);
            if (qVar.a == null) {
                qVar.a = b();
            }
            qVar.b = (String) sparseArray2.get(qVar.c);
            if (qVar.b == null) {
                qVar.b = "";
            }
            if (qVar.b.equals(a.d((int) R.string.homepage))) {
                qVar.a = c();
            }
            arrayList2.add(qVar);
        }
        this.a = arrayList2;
        d();
    }

    public final void a(Drawable drawable, int i) {
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                q qVar = (q) it.next();
                if (qVar.c == i) {
                    qVar.a = drawable;
                    if (qVar.a == null) {
                        qVar.a = b();
                    }
                    if (qVar.b.equals(a.d((int) R.string.homepage))) {
                        qVar.a = c();
                    }
                    it = this.b.iterator();
                    while (it.hasNext()) {
                        g gVar = (g) ((WeakReference) it.next()).get();
                        if (gVar != null) {
                            gVar.a(i, drawable);
                        }
                    }
                    return;
                }
            }
        }
    }

    private Drawable b() {
        if (this.e == null) {
            this.e = a.a("multiwindow_default_icon.svg");
        }
        return this.e;
    }

    private Drawable c() {
        if (this.f == null) {
            this.f = a.a("multiwindow_home.svg");
        }
        return this.f;
    }

    public final List<q> a() {
        return this.a;
    }

    public final void a(g gVar) {
        this.b.add(new WeakReference(gVar));
    }

    public final void b(g gVar) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            if (((g) ((WeakReference) this.b.get(size)).get()) == gVar) {
                this.b.remove(size);
                return;
            }
        }
    }

    private void d() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((WeakReference) it.next()).get();
        }
    }
}
