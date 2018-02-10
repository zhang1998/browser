package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.d.g;
import android.support.v4.d.j;
import android.support.v4.d.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class FragmentActivity extends i {
    final Handler a = new bu(this);
    public final am b = new am(new cm(this));
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    int i;
    boolean j;
    g<String> k;

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.b.a();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.k.a(i4);
            this.k.b(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            } else if (this.b.a(str) == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                Fragment.h();
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.b.a.e.c()) {
            c();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.a.e.a(configuration);
    }

    public void onCreate(@Nullable Bundle bundle) {
        am amVar = this.b;
        amVar.a.e.a(amVar.a, amVar.a, null);
        super.onCreate(bundle);
        ai aiVar = (ai) getLastNonConfigurationInstance();
        if (aiVar != null) {
            this.b.a.f = aiVar.c;
        }
        if (bundle != null) {
            List list;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            am amVar2 = this.b;
            if (aiVar != null) {
                list = aiVar.b;
            } else {
                list = null;
            }
            amVar2.a.e.a(parcelable, list);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.k = new g(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        g gVar = this.k;
                        int i2 = intArray[i];
                        String str = stringArray[i];
                        int a = j.a(gVar.c, gVar.e, i2);
                        if (a >= 0) {
                            gVar.d[a] = str;
                        } else {
                            a ^= -1;
                            if (a >= gVar.e || gVar.d[a] != g.a) {
                                if (gVar.b && gVar.e >= gVar.c.length) {
                                    gVar.a();
                                    a = j.a(gVar.c, gVar.e, i2) ^ -1;
                                }
                                if (gVar.e >= gVar.c.length) {
                                    int a2 = j.a(gVar.e + 1);
                                    Object obj = new int[a2];
                                    Object obj2 = new Object[a2];
                                    System.arraycopy(gVar.c, 0, obj, 0, gVar.c.length);
                                    System.arraycopy(gVar.d, 0, obj2, 0, gVar.d.length);
                                    gVar.c = obj;
                                    gVar.d = obj2;
                                }
                                if (gVar.e - a != 0) {
                                    System.arraycopy(gVar.c, a, gVar.c, a + 1, gVar.e - a);
                                    System.arraycopy(gVar.d, a, gVar.d, a + 1, gVar.e - a);
                                }
                                gVar.c[a] = i2;
                                gVar.d[a] = str;
                                gVar.e++;
                            } else {
                                gVar.c[a] = i2;
                                gVar.d[a] = str;
                            }
                        }
                    }
                }
            }
        }
        if (this.k == null) {
            this.k = new g();
            this.i = 0;
        }
        this.b.a.e.h();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        am amVar = this.b;
        onCreatePanelMenu |= amVar.a.e.a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.b.a.e.a(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        a(false);
        this.b.a.e.m();
        bm bmVar = this.b.a;
        if (bmVar.h != null) {
            bmVar.h.g();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.a.e.n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.b.a.e.a(menuItem);
            case 6:
                return this.b.a.e.b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.b.a.e.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            d();
        }
        this.b.a.e.a(4);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.a();
    }

    public void onStateNotSaved() {
        this.b.a();
    }

    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.b();
    }

    public void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        d();
        this.b.b();
    }

    protected final void d() {
        this.b.a.e.k();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.h) {
            this.h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(0, view, menu) | this.b.a.e.a(menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        List list;
        if (this.e) {
            a(true);
        }
        ah ahVar = this.b.a.e;
        if (ahVar.f != null) {
            list = null;
            for (int i = 0; i < ahVar.f.size(); i++) {
                Fragment fragment = (Fragment) ahVar.f.get(i);
                if (fragment != null && fragment.F) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fragment);
                    fragment.G = true;
                    fragment.o = fragment.n != null ? fragment.n.k : -1;
                    if (ah.a) {
                        new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                    }
                }
            }
        } else {
            list = null;
        }
        s c = this.b.c();
        if (list == null && c == null) {
            return null;
        }
        ai aiVar = new ai();
        aiVar.a = null;
        aiVar.b = list;
        aiVar.c = c;
        return aiVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable g = this.b.a.e.g();
        if (g != null) {
            bundle.putParcelable("android:support:fragments", g);
        }
        if (this.k.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.k.b()];
            String[] strArr = new String[this.k.b()];
            for (int i = 0; i < this.k.b(); i++) {
                iArr[i] = this.k.c(i);
                strArr[i] = (String) this.k.d(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.e = false;
        this.f = false;
        this.a.removeMessages(1);
        if (!this.c) {
            this.c = true;
            this.b.a.e.i();
        }
        this.b.a();
        this.b.b();
        bm bmVar = this.b.a;
        if (!bmVar.j) {
            bmVar.j = true;
            if (bmVar.h != null) {
                bmVar.h.b();
            } else if (!bmVar.i) {
                bmVar.h = bmVar.a("(root)");
                if (!(bmVar.h == null || bmVar.h.e)) {
                    bmVar.h.b();
                }
            }
            bmVar.i = true;
        }
        this.b.a.e.j();
        bm bmVar2 = this.b.a;
        if (bmVar2.f != null) {
            int i;
            int size = bmVar2.f.size();
            cs[] csVarArr = new cs[size];
            for (i = size - 1; i >= 0; i--) {
                csVarArr[i] = (cs) bmVar2.f.c(i);
            }
            for (i = 0; i < size; i++) {
                cs csVar = csVarArr[i];
                if (csVar.f) {
                    if (cs.a) {
                        new StringBuilder("Finished Retaining in ").append(csVar);
                    }
                    csVar.f = false;
                    for (int b = csVar.b.b() - 1; b >= 0; b--) {
                        cd cdVar = (cd) csVar.b.d(b);
                        if (cdVar.i) {
                            if (cs.a) {
                                new StringBuilder("  Finished Retaining: ").append(cdVar);
                            }
                            cdVar.i = false;
                            if (!(cdVar.h == cdVar.j || cdVar.h)) {
                                cdVar.a();
                            }
                        }
                        if (cdVar.h && cdVar.e && !cdVar.k) {
                            cdVar.a(cdVar.d, cdVar.g);
                        }
                    }
                }
                csVar.f();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.e = true;
        this.a.sendEmptyMessage(1);
        this.b.a.e.l();
    }

    public void a() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print("mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f);
        bm bmVar = this.b.a;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(bmVar.j);
        if (bmVar.h != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(bmVar.h)));
            printWriter.println(":");
            bmVar.h.a(str2 + "  ", fileDescriptor, printWriter);
        }
        this.b.a.e.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final void a(boolean z) {
        if (!this.f) {
            this.f = true;
            this.g = z;
            this.a.removeMessages(1);
            am amVar = this.b;
            boolean z2 = this.g;
            bm bmVar = amVar.a;
            bmVar.g = z2;
            if (bmVar.h != null && bmVar.j) {
                bmVar.j = false;
                if (z2) {
                    bmVar.h.d();
                } else {
                    bmVar.h.c();
                }
            }
            this.b.a.e.a(2);
        }
    }

    public static void e() {
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.j || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.k.a(i3);
            this.k.b(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            } else if (this.b.a(str) == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                Fragment.i();
            }
        }
    }
}
