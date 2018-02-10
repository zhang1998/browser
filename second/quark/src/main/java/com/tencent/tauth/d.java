package com.tencent.tauth;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.a.b.n;
import com.tencent.connect.b.g;
import com.tencent.connect.b.h;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public final class d {
    private static d b;
    public final g a;

    private d(String str, Context context) {
        n.a = context.getApplicationContext();
        this.a = g.a(str, context);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (NameNotFoundException e) {
                new StringBuilder(String.valueOf("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.")).append("\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>");
                return false;
            }
        } catch (NameNotFoundException e2) {
            new StringBuilder(String.valueOf("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.")).append("\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent").append(str).append("\" />\n</intent-filter>\n</activity>");
            return false;
        }
    }

    public static synchronized d a(String str, Context context) {
        d dVar = null;
        synchronized (d.class) {
            n.a = context.getApplicationContext();
            if (b == null) {
                b = new d(str, context);
            } else if (!str.equals(b.a.a.a)) {
                d dVar2 = b;
                h hVar = dVar2.a.a;
                String str2 = SettingsConst.FALSE;
                hVar.b = null;
                hVar.d = 0;
                hVar.d = (Long.parseLong(str2) * 1000) + System.currentTimeMillis();
                dVar2.a.a.c = null;
                b = new d(str, context);
            }
            if (a(context, str)) {
                dVar = b;
            }
        }
        return dVar;
    }
}
