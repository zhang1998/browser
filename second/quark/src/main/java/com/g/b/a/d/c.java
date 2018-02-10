package com.g.b.a.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;

/* compiled from: ProGuard */
public final class c {
    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            String str = "18da2bf10352443a00a5e046d9fca6bd";
            if (signatureArr == null) {
                return false;
            }
            for (Signature toByteArray : signatureArr) {
                if (str.equals(d.a(toByteArray.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }
}
