package com.ucpro.base.system;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ucweb.common.util.c;
import java.io.File;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    f(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final void run() {
        if (this.a != null) {
            String str = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
            new StringBuilder("uriString:").append(this.b);
            try {
                Uri fromFile;
                File file = new File("/mnt/" + this.b);
                if (file.exists()) {
                    fromFile = Uri.fromFile(file);
                } else {
                    file = new File(this.b);
                    if (file.exists()) {
                        fromFile = Uri.fromFile(file);
                    } else {
                        fromFile = Uri.parse(this.b);
                    }
                }
                this.a.sendBroadcast(new Intent(str, fromFile));
            } catch (Exception e) {
                c.a(e.toString());
            }
        }
    }
}
