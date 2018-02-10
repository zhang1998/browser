package com.ucpro.business.stat.b;

import android.util.Log;
import com.uc.base.wa.q;
import com.ucweb.common.util.k.a;
import hugo.weaving.DebugLog;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: ProGuard */
final class d implements q {
    final /* synthetic */ File a;
    final /* synthetic */ f b;

    d(f fVar, File file) {
        this.b = fVar;
        this.a = file;
    }

    @DebugLog
    public final void a(int i, ByteArrayOutputStream byteArrayOutputStream) {
        String str;
        byte[] toByteArray;
        if (i == 0) {
            str = "wa_upload_" + System.currentTimeMillis() + ".log";
            toByteArray = byteArrayOutputStream.toByteArray();
        } else {
            str = "wa_upload_fail_" + System.currentTimeMillis() + ".log";
            toByteArray = new String("errorCode = " + i).getBytes();
        }
        try {
            a.a(new File(this.a, str), toByteArray);
        } catch (Throwable e) {
            Log.e("WA", "write test log fail", e);
        }
    }
}
