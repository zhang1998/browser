package com.ucweb.c.c.b.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.uc.apollo.android.GuideDialog;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.c.b.b;
import java.util.List;

/* compiled from: ProGuard */
public final class c {
    static void a(b bVar) {
        Intent intent = new Intent();
        intent.setPackage("com.qzone");
        try {
            String str = bVar.c;
            String str2 = bVar.a;
            if (str2 == null) {
                str2 = str;
            } else if (str != null) {
                str2 = str + " " + str2;
            }
            intent.putExtra("android.intent.extra.TEXT", str2);
            com.ucweb.c.c.b.a().startActivity(intent);
        } catch (Exception e) {
            if (com.ucweb.c.d.c.b("com.qzone")) {
                c();
            } else {
                b();
            }
        }
    }

    static void a(Uri uri) {
        if (uri != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.tencent.mobileqq");
            intent.setData(uri);
            try {
                com.ucweb.c.c.b.a().startActivity(intent);
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    static void b(b bVar) {
        Object obj;
        Intent intent = new Intent();
        intent.setPackage("com.qzone");
        intent.setType(bVar.h);
        List<ResolveInfo> queryIntentActivities = com.ucweb.c.c.b.a().getPackageManager().queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || queryIntentActivities.size() == 0)) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if ("com.qzone".equals(activityInfo.packageName) && activityInfo.name != null && activityInfo.name.contains("QZonePublishMoodActivity")) {
                    intent.setClassName(activityInfo.packageName, activityInfo.name);
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        Object obj2;
        if (obj != null) {
            try {
                String str = bVar.c;
                String str2 = bVar.a;
                if (str2 == null) {
                    str2 = str;
                } else if (str != null) {
                    str2 = str + " " + str2;
                }
                intent.putExtra("android.intent.extra.TEXT", str2);
                com.ucweb.c.c.b.a().startActivity(intent);
                obj2 = null;
            } catch (Exception e) {
                int i = 1;
            }
        } else {
            obj2 = null;
        }
        if (obj != null && r0 == null) {
            return;
        }
        if (com.ucweb.c.d.c.b("com.qzone")) {
            c();
        } else {
            b();
        }
    }

    public static boolean a() {
        return com.ucweb.c.d.c.b("com.qzone") || com.ucweb.c.d.c.b("com.tencent.mobileqq");
    }

    static void c(b bVar) {
        Uri uri;
        if (bVar == null) {
            uri = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
            Object obj = bVar.b;
            Object obj2 = bVar.c;
            Object obj3 = bVar.a;
            Object obj4 = "";
            Object a = a(com.ucweb.c.c.b.a());
            if (!TextUtils.isEmpty(bVar.g)) {
                stringBuffer.append("&image_url=" + Base64.encodeToString(bVar.g.getBytes(), 2));
            }
            if (!TextUtils.isEmpty(obj)) {
                stringBuffer.append("&title=" + Base64.encodeToString(obj.getBytes(), 2));
            }
            if (!TextUtils.isEmpty(obj2)) {
                stringBuffer.append("&description=" + Base64.encodeToString(obj2.getBytes(), 2));
            }
            if (!TextUtils.isEmpty(com.ucweb.c.a.b.QQ.i)) {
                stringBuffer.append("&share_id=" + com.ucweb.c.a.b.QQ.i);
            }
            if (!TextUtils.isEmpty(obj3)) {
                stringBuffer.append("&url=" + Base64.encodeToString(obj3.getBytes(), 2));
            }
            if (!TextUtils.isEmpty(a)) {
                stringBuffer.append("&app_name=" + Base64.encodeToString(a.getBytes(), 2));
            }
            if (!TextUtils.isEmpty(obj4)) {
                stringBuffer.append("&audioUrl=" + Base64.encodeToString(obj4.getBytes(), 2));
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(SettingsConst.TRUE.getBytes(), 2));
            uri = Uri.parse(stringBuffer.toString());
        }
        a(uri);
    }

    static void d(b bVar) {
        Bundle bundle = new Bundle();
        bundle.putString(GuideDialog.TITLE, bVar.b);
        String str = bVar.c;
        if (str == null) {
            str = "uc share";
        }
        bundle.putString("summary", str);
        str = bVar.a;
        if (str == null) {
            str = "http://uc.cn";
        }
        bundle.putString("targetUrl", str);
        str = bVar.g;
        if (str != null && str.startsWith("file://")) {
            str = str.substring(7);
        }
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 1);
        bundle.putString("action", "shareToQQ");
        bundle.putString("appId", com.ucweb.c.a.b.QQ.i);
        bundle.putString("sdkp", "a");
        bundle.putString("sdkv", "1.7");
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        str = a(com.ucweb.c.c.b.a());
        if (str != null) {
            bundle.putString("appName", str);
        }
        str = bundle.getString("content");
        if (str != null && str.length() > 10) {
            bundle.putString("content", str.substring(0, 40) + "...");
        }
        str = bundle.getString("summary");
        if (str != null && str.length() > 80) {
            bundle.putString("summary", str.substring(0, 80) + "...");
        }
        str = "http://openmobile.qq.com/api/check?page=shareindex.html&style=9";
        String a = com.ucweb.c.d.c.a(bundle);
        if (a != null) {
            new StringBuilder().append(str).append("&").append(a.replaceAll("\\+", "%20"));
        }
    }

    static void e(b bVar) {
        Bundle bundle = new Bundle();
        bundle.putString(GuideDialog.TITLE, bVar.b);
        String str = bVar.c;
        if (str == null) {
            str = "uc share";
        }
        bundle.putString("summary", str);
        str = bVar.a;
        if (str == null) {
            str = "http://uc.cn";
        }
        bundle.putString("targetUrl", str);
        str = bVar.g;
        if (str != null && str.startsWith("file://")) {
            str = str.substring(7);
        }
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 1);
        a(a(bundle));
    }

    static Uri a(Bundle bundle) {
        Object string = bundle.getString(GuideDialog.TITLE);
        Object string2 = bundle.getString("summary");
        Object string3 = bundle.getString("targetUrl");
        Object string4 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 2);
        String a = a(com.ucweb.c.c.b.a());
        if (a == null) {
            a = bundle.getString("appName");
        }
        Object string5 = bundle.getString("imageLocalUrl");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(string5.getBytes(), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(string.getBytes(), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(string2.getBytes(), 2));
        }
        if (!TextUtils.isEmpty(com.ucweb.c.a.b.QQ.i)) {
            stringBuffer.append("&share_id=" + com.ucweb.c.a.b.QQ.i);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(string3.getBytes(), 2));
        }
        if (!TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(a.getBytes(), 2));
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(string4.getBytes(), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(String.valueOf(i).getBytes(), 2));
        return Uri.parse(stringBuffer.toString());
    }

    static final String a(Context context) {
        if (context != null) {
            CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            if (applicationLabel != null) {
                return applicationLabel.toString();
            }
        }
        return null;
    }

    static boolean a(String str) {
        int i = -1;
        PackageInfo a = com.ucweb.c.d.c.a("com.tencent.mobileqq");
        if (a != null) {
            i = com.ucweb.c.d.c.a(a.versionName, str);
        }
        return i < 0;
    }

    static boolean b(String str) {
        int i = -1;
        PackageInfo a = com.ucweb.c.d.c.a("com.qzone");
        if (a != null) {
            i = com.ucweb.c.d.c.a(a.versionName, str);
        }
        return i < 0;
    }

    static void b() {
        Toast.makeText(com.ucweb.c.c.b.a(), "您还没有安装!", 1).show();
    }

    public static void c() {
        Toast.makeText(com.ucweb.c.c.b.a(), "您的软件版本较低,暂不支持分享!", 1).show();
    }
}
