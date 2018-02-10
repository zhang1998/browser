package android.mini.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.mini.support.annotation.CallSuper;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.c;
import android.mini.support.v4.d.q;
import android.mini.support.v4.d.r;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: ProGuard */
public class FragmentActivity extends k {
    final Handler c = new o(this);
    final s d = new s(new p(this));
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    int k;
    r<String> l;

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.d.a();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.l.a(i4);
            this.l.b(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            } else if (this.d.a(str) == null) {
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
        if (!this.d.a.f.b()) {
            a();
        }
    }

    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        this.d.a.f.a(z);
    }

    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        this.d.a.f.b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.a.f.a(configuration);
    }

    protected void onCreate(@Nullable Bundle bundle) {
        s sVar = this.d;
        sVar.a.f.a(sVar.a, sVar.a, null);
        super.onCreate(bundle);
        q qVar = (q) getLastNonConfigurationInstance();
        if (qVar != null) {
            this.d.a.g = qVar.c;
        }
        if (bundle != null) {
            ac acVar;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            s sVar2 = this.d;
            if (qVar != null) {
                acVar = qVar.b;
            } else {
                acVar = null;
            }
            sVar2.a.f.a(parcelable, acVar);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.l = new r(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        r rVar = this.l;
                        int i2 = intArray[i];
                        String str = stringArray[i];
                        int a = c.a(rVar.c, rVar.e, i2);
                        if (a >= 0) {
                            rVar.d[a] = str;
                        } else {
                            a ^= -1;
                            if (a >= rVar.e || rVar.d[a] != r.a) {
                                if (rVar.b && rVar.e >= rVar.c.length) {
                                    rVar.a();
                                    a = c.a(rVar.c, rVar.e, i2) ^ -1;
                                }
                                if (rVar.e >= rVar.c.length) {
                                    int a2 = c.a(rVar.e + 1);
                                    Object obj = new int[a2];
                                    Object obj2 = new Object[a2];
                                    System.arraycopy(rVar.c, 0, obj, 0, rVar.c.length);
                                    System.arraycopy(rVar.d, 0, obj2, 0, rVar.d.length);
                                    rVar.c = obj;
                                    rVar.d = obj2;
                                }
                                if (rVar.e - a != 0) {
                                    System.arraycopy(rVar.c, a, rVar.c, a + 1, rVar.e - a);
                                    System.arraycopy(rVar.d, a, rVar.d, a + 1, rVar.e - a);
                                }
                                rVar.c[a] = i2;
                                rVar.d[a] = str;
                                rVar.e++;
                            } else {
                                rVar.c[a] = i2;
                                rVar.d[a] = str;
                            }
                        }
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new r();
            this.k = 0;
        }
        this.d.a.f.g();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        s sVar = this.d;
        onCreatePanelMenu |= sVar.a.f.a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a.f.a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.d.a.f.l();
        t tVar = this.d.a;
        if (tVar.i != null) {
            tVar.i.g();
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
        this.d.a.f.m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.d.a.f.a(menuItem);
            case 6:
                return this.d.a.f.b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.d.a.f.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            b();
        }
        this.d.a.f.b(4);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.a();
    }

    public void onStateNotSaved() {
        this.d.a();
    }

    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.b();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        b();
        this.d.b();
    }

    protected final void b() {
        this.d.a.f.j();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.j) {
            this.j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(0, view, menu) | this.d.a.f.a(menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        int i;
        q qVar;
        int i2 = 0;
        if (this.g) {
            a(true);
        }
        ac e = this.d.a.f.e();
        t tVar = this.d.a;
        if (tVar.g != null) {
            int size = tVar.g.size();
            ap[] apVarArr = new ap[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                apVarArr[i3] = (ap) tVar.g.c(i3);
            }
            boolean z = tVar.h;
            i = 0;
            while (i2 < size) {
                ap apVar = apVarArr[i2];
                if (!apVar.f && z) {
                    if (!apVar.e) {
                        apVar.b();
                    }
                    apVar.d();
                }
                if (apVar.f) {
                    i = true;
                } else {
                    apVar.g();
                    tVar.g.remove(apVar.d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            qVar = tVar.g;
        } else {
            qVar = null;
        }
        if (e == null && qVar == null) {
            return null;
        }
        Object qVar2 = new q();
        qVar2.a = null;
        qVar2.b = e;
        qVar2.c = qVar;
        return qVar2;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable f = this.d.a.f.f();
        if (f != null) {
            bundle.putParcelable("android:support:fragments", f);
        }
        if (this.l.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.k);
            int[] iArr = new int[this.l.b()];
            String[] strArr = new String[this.l.b()];
            for (int i = 0; i < this.l.b(); i++) {
                iArr[i] = this.l.c(i);
                strArr[i] = (String) this.l.d(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if (!this.e) {
            this.e = true;
            this.d.a.f.h();
        }
        this.d.a();
        this.d.b();
        this.d.c();
        this.d.a.f.i();
        t tVar = this.d.a;
        if (tVar.g != null) {
            int i;
            int size = tVar.g.size();
            ap[] apVarArr = new ap[size];
            for (i = size - 1; i >= 0; i--) {
                apVarArr[i] = (ap) tVar.g.c(i);
            }
            for (i = 0; i < size; i++) {
                ap apVar = apVarArr[i];
                if (apVar.f) {
                    if (ap.a) {
                        new StringBuilder("Finished Retaining in ").append(apVar);
                    }
                    apVar.f = false;
                    for (int b = apVar.b.b() - 1; b >= 0; b--) {
                        ao aoVar = (ao) apVar.b.d(b);
                        if (aoVar.i) {
                            if (ap.a) {
                                new StringBuilder("  Finished Retaining: ").append(aoVar);
                            }
                            aoVar.i = false;
                            if (!(aoVar.h == aoVar.j || aoVar.h)) {
                                aoVar.a();
                            }
                        }
                        if (aoVar.h && aoVar.e && !aoVar.k) {
                            aoVar.a(aoVar.d, aoVar.g);
                        }
                    }
                }
                apVar.f();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.g = true;
        this.c.sendEmptyMessage(1);
        this.d.a.f.k();
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
        printWriter.print(this.e);
        printWriter.print("mResumed=");
        printWriter.print(this.f);
        printWriter.print(" mStopped=");
        printWriter.print(this.g);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.h);
        t tVar = this.d.a;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(tVar.k);
        if (tVar.i != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(tVar.i)));
            printWriter.println(":");
            tVar.i.a(str2 + "  ", fileDescriptor, printWriter);
        }
        this.d.a.f.a(str, fileDescriptor, printWriter, strArr);
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
        if (!this.h) {
            this.h = true;
            this.i = z;
            this.c.removeMessages(1);
            this.d.a(this.i);
            this.d.a.f.b(2);
        } else if (z) {
            this.d.c();
            this.d.a(true);
        }
    }

    public static void c() {
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            i.a(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.l.a(i3);
            this.l.b(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            } else if (this.d.a(str) == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                Fragment.i();
            }
        }
    }
}
