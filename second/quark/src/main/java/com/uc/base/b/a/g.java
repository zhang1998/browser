package com.uc.base.b.a;

import android.util.Log;
import com.uc.base.b.c.c.a;
import java.io.File;

/* compiled from: ProGuard */
public final class g implements b {
    private String a;
    private c b;

    public final boolean a(String str, String str2, byte b, byte[] bArr, byte[] bArr2, boolean z) {
        if (bArr2 == null) {
            return false;
        }
        try {
            return a.a(a.a(this.a, "/", str, "/"), a.a(str2, ".ucmd"), bArr, bArr2, bArr2.length, z);
        } catch (Throwable e) {
            if (com.uc.base.b.b.a.a()) {
                Object obj;
                StringBuilder append = new StringBuilder().append(e.toString() + ", stacktrace:\n" + Log.getStackTraceString(e)).append("please check why java bean save fail, file path: ").append(a.a(this.a, "/", str, "/")).append(", file name: ");
                String[] strArr = new String[2];
                strArr[0] = str2;
                StringBuilder stringBuilder = new StringBuilder(".ucmd");
                if (b == (byte) 1) {
                    obj = "";
                } else {
                    obj = Byte.valueOf(b);
                }
                strArr[1] = stringBuilder.append(obj).toString();
                com.uc.base.b.b.a.a(append.append(a.a(strArr)).append(", body data length: ").append(bArr2.length).toString());
            }
            return false;
        }
    }

    public final a a(String str, String str2) {
        File file;
        String str3 = ".ucmd";
        String a = a.a(this.a, "/", str, "/", str2, ".ucmd");
        if (new File(a).exists()) {
            File file2 = new File(a.b(a));
            if (file2.exists() && !a.a(file2, a)) {
                str3 = a.b(str3);
            }
            file = new File(a.a(this.a, "/", str, "/", str2, str3));
        } else {
            file = null;
        }
        if (file == null) {
            file = new File(a.a(this.a, "/", str, "/", str2));
        }
        return new a(file, a.a(file));
    }

    public final boolean b(String str, String str2) {
        int c;
        String str3 = ".ucmd";
        if (new File(a.a(this.a, "/", str, "/", str2, str3)).exists()) {
            c = a.c(a.a(this.a, "/", str, "/", str2, str3)) | 0;
        } else {
            c = 0;
        }
        return c | a.c(a.a(this.a, "/", str, "/", str2));
    }

    public final void a(c cVar) {
        this.b = cVar;
        this.a = this.b.a;
    }
}
