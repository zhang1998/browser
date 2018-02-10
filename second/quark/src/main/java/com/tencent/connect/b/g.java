package com.tencent.connect.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.a.b.n;
import com.tencent.a.b.r;
import com.tencent.connect.a.a;
import com.tencent.tauth.b;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public final class g {
    public h a;
    private f b = new f(this.a);

    private g(String str, Context context) {
        this.a = new h(str);
        a.a(context, this.a);
    }

    public final int a(Activity activity, String str, b bVar) {
        String str2;
        String packageName = activity.getApplicationContext().getPackageName();
        for (ApplicationInfo applicationInfo : activity.getPackageManager().getInstalledApplications(128)) {
            if (packageName.equals(applicationInfo.packageName)) {
                str2 = applicationInfo.sourceDir;
                break;
            }
        }
        str2 = null;
        if (str2 != null) {
            try {
                String a = r.a(new File(str2));
                if (!TextUtils.isEmpty(a)) {
                    str2 = "";
                    com.tencent.connect.common.a.g = true;
                    if (a.equals("")) {
                        packageName = "null";
                    } else {
                        packageName = a;
                    }
                    if (a.equals("")) {
                        a = "null";
                    }
                    if (str2.equals("")) {
                        str2 = "null";
                    }
                    com.tencent.connect.common.a.e = a;
                    com.tencent.connect.common.a.d = packageName;
                    com.tencent.connect.common.a.f = str2;
                    return this.b.a(activity, str, bVar);
                }
            } catch (IOException e) {
            }
        }
        com.tencent.connect.common.a.g = false;
        return this.b.a(activity, str, bVar);
    }

    public static g a(String str, Context context) {
        n.a = context.getApplicationContext();
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            return new g(str, context);
        } catch (NameNotFoundException e) {
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }
}
