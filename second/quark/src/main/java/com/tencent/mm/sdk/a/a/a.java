package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.h;
import com.tencent.mm.sdk.constants.ConstantsAPI;

public final class a {

    public final class a {
        public String Y;
        public Bundle Z;
        public String aa;
        public String ab;
    }

    public static boolean a(Context context, a aVar) {
        if (context == null) {
            b.b("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (h.h(aVar.ab)) {
            b.b("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = null;
            if (!h.h(aVar.aa)) {
                str = aVar.aa + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.ab);
            if (aVar.Z != null) {
                intent.putExtras(aVar.Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.Y);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.Y, 587268097, packageName));
            context.sendBroadcast(intent, str);
            b.e("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
