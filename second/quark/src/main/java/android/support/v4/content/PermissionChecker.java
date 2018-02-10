package android.support.v4.content;

import android.content.Context;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v4.app.bj;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class PermissionChecker {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface PermissionResult {
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String a = bj.a(str);
        if (a != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (bj.a(context, a, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }
}
