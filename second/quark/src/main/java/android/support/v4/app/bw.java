package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

/* compiled from: ProGuard */
final class bw extends bo {
    private bw() {
        super();
    }

    public final String a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public final int a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
