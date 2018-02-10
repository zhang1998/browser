package com.ucpro.feature.video.player.c;

import android.os.Handler;
import com.uc.media.interfaces.IApolloHelper.Apollo;
import com.uc.media.interfaces.IApolloHelper.ContextUtils;
import com.ucweb.common.util.d;
import com.ucweb.common.util.e;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.io.File;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class l {
    c a;
    int b = 0;
    HashMap<String, String> c = new HashMap();
    boolean d = false;
    boolean e = false;
    Handler f;
    boolean g = false;

    public l(c cVar) {
        this.a = cVar;
        this.f = new e(getClass().getName());
    }

    public final void a(String str, String str2, String str3, int i) {
        this.g = true;
        m.a(new o(this, str, str2, str3, i));
    }

    private boolean b(String str) {
        if (this.c == null || this.c.size() == 0) {
            return true;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        String str2 = (String) this.c.get(file2.getName());
                        if (!(a.a(str2) || com.ucweb.common.util.k.a.a(file2, str2, 5000))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    final boolean a(String str, String str2, String str3, String str4) {
        try {
            File file = new File(str3);
            if (file.exists()) {
                com.ucweb.common.util.k.a.b(file);
            }
            while (this.b < 3) {
                boolean extractLibs = Apollo.extractLibs(str, str3, str4);
                this.b++;
                if (extractLibs && b(str3)) {
                    if (file.exists() && file.isDirectory()) {
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            com.ucweb.common.util.k.a.b(file2);
                        }
                        file.renameTo(file2);
                    }
                    this.b = 0;
                    return true;
                }
                com.ucweb.common.util.k.a.b(file);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    final void a(String str) {
        if (!a.a(str)) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String str22;
                    if (!a.a(str22)) {
                        String[] split2 = str22.split(":");
                        if (split2 != null && split2.length == 2) {
                            String str3 = split2[0];
                            str22 = split2[1];
                            if (!(a.a(str3) || a.a(str22))) {
                                this.c.put(str3.trim(), str22.trim());
                            }
                        }
                    }
                }
            }
        }
    }

    static void a() {
        File file = new File(ContextUtils.getDataDir(d.a()) + "VitamioMd5");
        if (file.exists()) {
            file.delete();
        }
    }
}
