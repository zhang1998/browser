package com.ucpro.feature.video.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.UCMobile.Apollo.MediaPlayer;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
final class d implements l {
    d() {
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (h.c != i || f.g()) {
            hVar.dismiss();
        } else {
            Context a = com.ucweb.common.util.d.a();
            Intent intent;
            if (VERSION.SDK_INT >= 23) {
                if (a != null) {
                    intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    intent.setData(Uri.fromParts("package", a.getPackageName(), null));
                    intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                    a.startActivity(intent);
                }
            } else if (a != null) {
                String packageName = a.getPackageName();
                if (f.e()) {
                    if (f.h()) {
                        intent = new Intent("android.intent.action.MAIN");
                        intent.setClassName("com.android.settings", "com.android.settings.applications.InstalledAppDetailsTop");
                        intent.setData(Uri.fromParts("package", packageName, null));
                        intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                        a.startActivity(intent);
                    } else if (f.i()) {
                        intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                        intent.putExtra("extra_pkgname", packageName);
                        intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                        a.startActivity(intent);
                    }
                } else if (f.f()) {
                    intent = new Intent();
                    intent.setAction("com.smartisanos.security.action.SWITCHED_PERMISSIONS_NEW");
                    intent.putExtra("index", 16);
                    intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                    a.startActivity(intent);
                } else {
                    Intent intent2 = new Intent();
                    int i2 = VERSION.SDK_INT;
                    if (i2 >= 9) {
                        intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent2.setData(Uri.fromParts("package", packageName, null));
                    } else {
                        String str = i2 == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
                        intent2.setAction("android.intent.action.VIEW");
                        intent2.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                        intent2.putExtra(str, packageName);
                    }
                    intent2.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                    a.startActivity(intent2);
                }
            }
        }
        return false;
    }
}
