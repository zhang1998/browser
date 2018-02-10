package com.ucpro.feature.defaultbrowser;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.ValueCallback;
import com.ucpro.b.a.a;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.feature.defaultbrowser.view.SetDefaultTipsActivity;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class m extends e implements j {
    private String c;
    private boolean d;
    private x e;
    private e f;
    private String g;

    protected final void a(b bVar) {
        super.a(bVar);
        this.c = this.b.getPackageName();
        this.d = false;
        c.a;
        x xVar = null;
        switch (f.a[d.f().ordinal()]) {
            case 1:
                xVar = new q(this);
                break;
            case 2:
            case 3:
                xVar = new v(this);
                break;
            case 4:
            case 5:
            case 6:
                xVar = new h(this);
                break;
            case 7:
            case 8:
                if (VERSION.SDK_INT >= 21) {
                    xVar = new r(this);
                    break;
                }
                break;
            default:
                if (VERSION.SDK_INT > 14) {
                    if (VERSION.SDK_INT > 14) {
                        xVar = new h(this);
                        break;
                    }
                }
                xVar = new v(this);
                break;
                break;
        }
        if (xVar == null) {
            xVar = new h(this);
        }
        this.e = xVar;
        a(this.e.c());
    }

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.bx) {
            if (!i()) {
                this.f.a(1, message);
            }
        } else if (i == com.ucpro.base.a.e.by) {
            ((ValueCallback) message.obj).onReceiveValue(Boolean.valueOf(j()));
        }
    }

    public final void b(int i, Message message) {
    }

    public final void q_() {
        super.q_();
        if (!i()) {
            this.f.a(3, null);
        }
    }

    public final void a(e eVar) {
        if (eVar != null && this.f != eVar) {
            this.f = eVar;
            this.f.b();
        }
    }

    public final void a(boolean z) {
        if (z) {
            if (!j()) {
                if (k()) {
                    a(this.e.b());
                } else {
                    a(this.e.a());
                }
            }
        } else if (l()) {
            this.g = b(this.b);
        }
    }

    public final void c() {
        this.d = false;
        ComponentName componentName = new ComponentName("android", "com.android.internal.app.ResolverActivity");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        b(intent);
        intent.putExtra("intent_sender_package_name", this.c);
        intent.setComponent(componentName);
        c(n().putExtra("intent", intent));
    }

    public final void d() {
        String str = this.g;
        Intent intent = new Intent();
        int i = VERSION.SDK_INT;
        if (i >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", str, null));
        } else {
            String str2 = i == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra(str2, str);
        }
        c(n().putExtra("intent", intent));
    }

    public final void f() {
        Parcelable intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.applications.PreferredListSettings");
        c(n().putExtra("intent", intent));
    }

    public final boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("intent_sender_package_name");
        if (stringExtra == null || !stringExtra.equals(this.c)) {
            this.d = false;
        } else {
            this.d = true;
        }
        return this.d;
    }

    private boolean j() {
        try {
            Object obj;
            List<ResolveInfo> a = a(this.b);
            if (a != null) {
                for (ResolveInfo resolveInfo : a) {
                    if (!resolveInfo.activityInfo.packageName.equalsIgnoreCase(this.c)) {
                        obj = null;
                        break;
                    }
                }
            }
            int i = 1;
            if (obj != null) {
                return true;
            }
            String b = b(this.b);
            this.g = b;
            if (b == null || !b.equalsIgnoreCase(this.c)) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            Log.e("DefaultBrowser", "isUCDefaultBrowser", e);
            c.a(e.toString());
            return false;
        }
    }

    private static List<ResolveInfo> a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse("http://wap.ucweb.com?flag=set_default_browser"));
        return packageManager.queryIntentActivities(intent, 65536);
    }

    private String b(Context context) {
        List arrayList;
        String str;
        if (VERSION.SDK_INT >= 19) {
            List<ResolveInfo> arrayList2 = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> a = a(context);
            arrayList = new ArrayList();
            List arrayList3 = new ArrayList();
            for (ResolveInfo resolveInfo : a) {
                if (!(resolveInfo == null || resolveInfo.activityInfo == null)) {
                    if (a(packageManager, arrayList, arrayList3, resolveInfo.activityInfo.packageName)) {
                        arrayList2.add(resolveInfo);
                    }
                    arrayList.clear();
                    arrayList3.clear();
                }
            }
            for (ResolveInfo resolveInfo2 : arrayList2) {
                if (!(resolveInfo2 == null || resolveInfo2.activityInfo == null)) {
                    str = resolveInfo2.activityInfo.packageName;
                    if (str != null) {
                        if (str.equalsIgnoreCase(this.c)) {
                            return this.c;
                        }
                        return str;
                    }
                }
            }
            return null;
        }
        PackageManager packageManager2 = context.getPackageManager();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        b(intent);
        try {
            ResolveInfo resolveActivity = packageManager2.resolveActivity(intent, 65536);
            if (!(resolveActivity == null || resolveActivity.activityInfo == null)) {
                List arrayList4 = new ArrayList();
                arrayList = new ArrayList();
                boolean a2 = a(packageManager2, arrayList4, arrayList, resolveActivity.activityInfo.packageName);
                arrayList4.clear();
                arrayList.clear();
                if (a2) {
                    str = resolveActivity.activityInfo.packageName;
                    return str;
                }
            }
            str = null;
            return str;
        } catch (Throwable e) {
            c.a("fail", e);
            return null;
        }
    }

    private static boolean a(PackageManager packageManager, List<IntentFilter> list, List<ComponentName> list2, String str) {
        packageManager.getPreferredActivities(list, list2, str);
        for (IntentFilter intentFilter : list) {
            if ((intentFilter.hasCategory("android.intent.category.BROWSABLE") || intentFilter.hasCategory("android.intent.category.DEFAULT")) && intentFilter.hasDataScheme("http")) {
                return true;
            }
        }
        return false;
    }

    private static void b(Intent intent) {
        intent.setData(Uri.parse("http://wap.ucweb.com?flag=set_default_browser"));
    }

    private void m() {
        com.ucweb.common.util.h.m.a(2, new n(this), 500);
    }

    private void c(Intent intent) {
        com.ucweb.common.util.h.m.a(2, new y(this, intent), 300);
    }

    private Intent n() {
        Intent intent = new Intent(this.b, SetDefaultTipsActivity.class);
        if (this.f != null) {
            intent.putExtra("mask_view", this.f.a());
        }
        return intent;
    }

    public static boolean i() {
        if (a.b()) {
            return true;
        }
        switch (i.a[d.f().ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                if (VERSION.SDK_INT < 11 || VERSION.SDK_INT >= 23) {
                    return true;
                }
                return false;
        }
    }

    public final void r_() {
        if (j()) {
            m();
        } else {
            com.ucweb.common.util.h.m.a(2, new b(this), 500);
            k();
        }
        a(this.e.c());
    }

    public final void e() {
        if (j()) {
            m();
            a(this.e.c());
        } else if (k()) {
            com.ucweb.common.util.h.m.a(2, new u(this), 500);
            a(this.e.c());
        } else {
            a(this.e.a());
        }
    }

    private boolean k() {
        String b = b(this.b);
        this.g = b;
        if (b == null || b.equalsIgnoreCase("android") || b.equalsIgnoreCase(this.c)) {
            return false;
        }
        return true;
    }

    private boolean l() {
        try {
            this.b.getPackageManager().clearPackagePreferredActivities(this.c);
            return true;
        } catch (Throwable e) {
            c.a("fail", e);
            return false;
        }
    }
}
