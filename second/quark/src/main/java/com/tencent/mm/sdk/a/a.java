package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.h;
import com.tencent.mm.sdk.constants.ConstantsAPI;

public final class a {

    public final class a {
        public String W;
        public String X;
        public String Y;
        public Bundle Z;
        public int flags = -1;

        public final String toString() {
            return "targetPkgName:" + this.W + ", targetClassName:" + this.X + ", content:" + this.Y + ", flags:" + this.flags + ", bundle:" + this.Z;
        }
    }

    public static boolean a(Context context, a aVar) {
        if (context == null) {
            b.b("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (h.h(aVar.W)) {
            b.b("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + aVar.W);
            return false;
        } else {
            if (h.h(aVar.X)) {
                aVar.X = aVar.W + ".wxapi.WXEntryActivity";
            }
            b.e("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + aVar.W + ", targetClassName = " + aVar.X);
            Intent intent = new Intent();
            intent.setClassName(aVar.W, aVar.X);
            if (aVar.Z != null) {
                intent.putExtras(aVar.Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.Y);
            intent.putExtra(ConstantsAPI.CHECK_SUM, com.tencent.mm.sdk.a.a.b.a(aVar.Y, 587268097, packageName));
            if (aVar.flags == -1) {
                intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN).addFlags(134217728);
            } else {
                intent.setFlags(aVar.flags);
            }
            try {
                context.startActivity(intent);
                b.e("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                b.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
