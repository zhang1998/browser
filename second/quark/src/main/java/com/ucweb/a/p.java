package com.ucweb.a;

import com.ucweb.a.a.c;
import java.io.File;
import java.util.HashMap;

/* compiled from: ProGuard */
final class p implements Runnable {
    private HashMap<String, j> a;

    public p(HashMap<String, j> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            this.a = (HashMap) hashMap.clone();
        }
    }

    public final void run() {
        if (this.a != null) {
            HashMap hashMap = this.a;
            if (hashMap != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[UpgradeDataBegin]\r\n");
                for (j jVar : hashMap.values()) {
                    stringBuilder.append(jVar.e).append(";");
                    stringBuilder.append(jVar.a).append(";");
                    stringBuilder.append(jVar.b).append(";");
                    String str = jVar.c;
                    if (str == null) {
                        str = "";
                    }
                    stringBuilder.append(str).append(";");
                    stringBuilder.append(jVar.d);
                    stringBuilder.append("\r\n");
                }
                stringBuilder.append("[UpgradeDataEnd]");
                String H = c.c().H();
                if (H != null) {
                    byte[] a = c.b().a(stringBuilder.toString().getBytes());
                    if (a != null) {
                        File file = new File(H);
                        H = file.getParent();
                        if (!H.endsWith(File.separator)) {
                            H = H + File.separator;
                        }
                        c.b().a(H, file.getName(), a, a.length);
                    }
                }
            }
        }
    }
}
