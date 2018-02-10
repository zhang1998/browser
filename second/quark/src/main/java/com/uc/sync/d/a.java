package com.uc.sync.d;

import android.os.Environment;
import android.util.Log;
import com.ucweb.common.util.i.b;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: ProGuard */
public final class a {
    public static File a;
    public static BufferedWriter b = null;
    private static boolean c = com.uc.sync.c.a.h().d();

    public static void a(String str) {
        com.uc.sync.c.a.h();
        if (!com.uc.sync.c.a.j() && c) {
            Log.e("hjw-sync", str);
            try {
                b bVar = new b("sync", str);
                if (a == null || !a.exists()) {
                    File file = new File(a());
                    a = file;
                    file.createNewFile();
                }
                if (a.length() >= 20480) {
                    a.delete();
                    a.createNewFile();
                }
                if (b == null) {
                    b = new BufferedWriter(new FileWriter(a, true));
                }
                b.write(b.a(bVar.toString().getBytes(), "UTF-8").replaceAll("[\\s*\t\n\r]", "") + "\n");
                b.flush();
            } catch (IOException e) {
            }
        }
    }

    public static String a() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/sync_log.txt";
    }
}
