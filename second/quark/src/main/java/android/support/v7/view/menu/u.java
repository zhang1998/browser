package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.e.a.c;
import android.support.v4.view.bl;
import android.support.v4.view.dw;
import android.support.v7.c.i;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
public class u implements c {
    private static final int[] a = new int[]{1, 4, 5, 3, 2, 0};
    final Context b;
    public z c;
    ArrayList<i> d;
    public ArrayList<i> e;
    public int f = 1;
    CharSequence g;
    Drawable h;
    View i;
    boolean j = false;
    i k;
    public boolean l;
    private final Resources m;
    private boolean n;
    private boolean o;
    private ArrayList<i> p;
    private boolean q;
    private ArrayList<i> r;
    private boolean s;
    private ContextMenuInfo t;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private ArrayList<i> x = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<r>> y = new CopyOnWriteArrayList();

    public u(Context context) {
        boolean z = true;
        this.b = context;
        this.m = context.getResources();
        this.d = new ArrayList();
        this.p = new ArrayList();
        this.q = true;
        this.e = new ArrayList();
        this.r = new ArrayList();
        this.s = true;
        if (this.m.getConfiguration().keyboard == 1 || !this.m.getBoolean(i.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z = false;
        }
        this.o = z;
    }

    public final void a(r rVar) {
        a(rVar, this.b);
    }

    public final void a(r rVar, Context context) {
        this.y.add(new WeakReference(rVar));
        rVar.a(context, this);
        this.s = true;
    }

    public final void b(r rVar) {
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            r rVar2 = (r) weakReference.get();
            if (rVar2 == null || rVar2 == rVar) {
                this.y.remove(weakReference);
            }
        }
    }

    public final void a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = dw.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (dw.c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((a) item.getSubMenu()).a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    public final void b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(d());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = dw.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((a) item.getSubMenu()).b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    dw.b(item);
                }
            }
        }
    }

    protected String d() {
        return "android:menu:actionviewstates";
    }

    public void a(z zVar) {
        this.c = zVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.m.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.m.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.m.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        i iVar = (i) a(i, i2, i3, charSequence);
        a aVar = new a(this.b, this, iVar);
        iVar.a(aVar);
        return aVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.m.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.b.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((i) this.d.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.d.size() - size;
            int i3 = 0;
            while (true) {
                i2 = i3 + 1;
                if (i3 >= size2 || ((i) this.d.get(size)).getGroupId() != i) {
                    b(true);
                } else {
                    a(size, false);
                    i3 = i2;
                }
            }
            b(true);
        }
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.d.size()) {
            this.d.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    public void clear() {
        if (this.k != null) {
            b(this.k);
        }
        this.d.clear();
        b(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.d.get(i2);
            if (iVar.getGroupId() == i) {
                iVar.a(z2);
                iVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.d.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            i iVar = (i) this.d.get(i2);
            if (iVar.getGroupId() == i && iVar.b(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.d.get(i2);
            if (iVar.getGroupId() == i) {
                iVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.l) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((i) this.d.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.d.get(i2);
            if (iVar.getItemId() == i) {
                return iVar;
            }
            if (iVar.hasSubMenu()) {
                MenuItem findItem = iVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.d.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.d.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.n = z;
        b(false);
    }

    boolean a() {
        return this.n;
    }

    public boolean b() {
        return this.o;
    }

    boolean a(u uVar, MenuItem menuItem) {
        return this.c != null && this.c.a(uVar, menuItem);
    }

    private static int a(ArrayList<i> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((i) arrayList.get(size)).a <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            a(true);
        }
        return z;
    }

    private void a(List<i> list, int i, KeyEvent keyEvent) {
        boolean a = a();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = (i) this.d.get(i2);
                if (iVar.hasSubMenu()) {
                    ((u) iVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = a ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (a && alphabeticShortcut == '\b' && i == 67)) && iVar.isEnabled())) {
                    list.add(iVar);
                }
            }
        }
    }

    private i a(int i, KeyEvent keyEvent) {
        List list = this.x;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (i) list.get(0);
        }
        boolean a = a();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) list.get(i2);
            char alphabeticShortcut = a ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return iVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return iVar;
            }
            if (a && alphabeticShortcut == '\b' && i == 67) {
                return iVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public final boolean a(MenuItem menuItem, r rVar, int i) {
        boolean z = false;
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean z2;
        boolean b = iVar.b();
        bl blVar = iVar.d;
        if (blVar == null || !blVar.e()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean expandActionView;
        if (iVar.i()) {
            expandActionView = iVar.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            a(true);
            return expandActionView;
        } else if (iVar.hasSubMenu() || z2) {
            a(false);
            if (!iVar.hasSubMenu()) {
                iVar.a(new a(this.b, this, iVar));
            }
            a aVar = (a) iVar.getSubMenu();
            if (z2) {
                blVar.a((SubMenu) aVar);
            }
            if (!this.y.isEmpty()) {
                if (rVar != null) {
                    z = rVar.a(aVar);
                }
                Iterator it = this.y.iterator();
                boolean z3 = z;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    r rVar2 = (r) weakReference.get();
                    if (rVar2 == null) {
                        this.y.remove(weakReference);
                    } else {
                        if (z3) {
                            z = z3;
                        } else {
                            z = rVar2.a(aVar);
                        }
                        z3 = z;
                    }
                }
                z = z3;
            }
            expandActionView = b | r2;
            if (expandActionView) {
                return expandActionView;
            }
            a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                a(true);
            }
            return b;
        }
    }

    public final void a(boolean z) {
        if (!this.w) {
            this.w = true;
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                r rVar = (r) weakReference.get();
                if (rVar == null) {
                    this.y.remove(weakReference);
                } else {
                    rVar.a(this, z);
                }
            }
            this.w = false;
        }
    }

    public void close() {
        a(true);
    }

    public final void b(boolean z) {
        if (this.u) {
            this.v = true;
            return;
        }
        if (z) {
            this.q = true;
            this.s = true;
        }
        if (!this.y.isEmpty()) {
            e();
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                r rVar = (r) weakReference.get();
                if (rVar == null) {
                    this.y.remove(weakReference);
                } else {
                    rVar.a(z);
                }
            }
            f();
        }
    }

    public final void e() {
        if (!this.u) {
            this.u = true;
            this.v = false;
        }
    }

    public final void f() {
        this.u = false;
        if (this.v) {
            this.v = false;
            b(true);
        }
    }

    final void g() {
        this.q = true;
        b(true);
    }

    final void h() {
        this.s = true;
        b(true);
    }

    public final ArrayList<i> i() {
        if (!this.q) {
            return this.p;
        }
        this.p.clear();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            i iVar = (i) this.d.get(i);
            if (iVar.isVisible()) {
                this.p.add(iVar);
            }
        }
        this.q = false;
        this.s = true;
        return this.p;
    }

    public final void j() {
        ArrayList i = i();
        if (this.s) {
            Iterator it = this.y.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                r rVar = (r) weakReference.get();
                if (rVar == null) {
                    this.y.remove(weakReference);
                } else {
                    i2 = rVar.b() | i2;
                }
            }
            if (i2 != 0) {
                this.e.clear();
                this.r.clear();
                i2 = i.size();
                for (int i3 = 0; i3 < i2; i3++) {
                    i iVar = (i) i.get(i3);
                    if (iVar.f()) {
                        this.e.add(iVar);
                    } else {
                        this.r.add(iVar);
                    }
                }
            } else {
                this.e.clear();
                this.r.clear();
                this.r.addAll(i());
            }
            this.s = false;
        }
    }

    public final ArrayList<i> k() {
        j();
        return this.r;
    }

    public void clearHeader() {
        this.h = null;
        this.g = null;
        this.i = null;
        b(false);
    }

    final void a(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.i = view;
            this.g = null;
            this.h = null;
        } else {
            if (charSequence != null) {
                this.g = charSequence;
            }
            if (drawable != null) {
                this.h = drawable;
            }
            this.i = null;
        }
        b(false);
    }

    protected final u a(CharSequence charSequence) {
        a(charSequence, null, null);
        return this;
    }

    protected final u a(Drawable drawable) {
        a(null, drawable, null);
        return this;
    }

    public u c() {
        return this;
    }

    public boolean a(i iVar) {
        boolean z = false;
        if (!this.y.isEmpty()) {
            e();
            Iterator it = this.y.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                r rVar = (r) weakReference.get();
                if (rVar == null) {
                    this.y.remove(weakReference);
                } else {
                    z = rVar.a(iVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            f();
            if (z) {
                this.k = iVar;
            }
        }
        return z;
    }

    public boolean b(i iVar) {
        boolean z = false;
        if (!this.y.isEmpty() && this.k == iVar) {
            e();
            Iterator it = this.y.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                r rVar = (r) weakReference.get();
                if (rVar == null) {
                    this.y.remove(weakReference);
                } else {
                    z = rVar.b(iVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            f();
            if (z) {
                this.k = null;
            }
        }
        return z;
    }

    private MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= a.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (a[i4] << 16) | (65535 & i3);
        MenuItem iVar = new i(this, i, i2, i3, i5, charSequence, this.f);
        if (this.t != null) {
            iVar.e = this.t;
        }
        this.d.add(a(this.d, i5), iVar);
        b(true);
        return iVar;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((i) this.d.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        a(i2, true);
    }
}
