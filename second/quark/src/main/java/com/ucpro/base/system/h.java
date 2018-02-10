package com.ucpro.base.system;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.ucpro.business.stat.m;
import com.ucpro.c.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ Context a;

    h(Context context) {
        this.a = context;
    }

    public final void run() {
        e.e = e.d(this.a);
        if (e.e != null && e.e.size() <= 0) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!((!readLine.contains("fat") && !readLine.contains("fuse") && !readLine.contains("storage")) || readLine.contains("secure") || readLine.contains("asec") || readLine.contains("firmware") || readLine.contains("shell") || readLine.contains("obb") || readLine.contains("legacy") || readLine.contains("data"))) {
                        String[] split = readLine.split(" ");
                        if (1 < split.length) {
                            String str = split[1];
                            if (!(!str.contains("/") || str.contains("data") || str.contains("Data") || str.equals(externalStorageDirectory.getAbsolutePath()))) {
                                File file = new File(new File(str), "Quark");
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                boolean i = e.l(str + "/Quark");
                                if (b.b()) {
                                    Log.e("vanda", "path:" + str + "   isSucess:" + i);
                                }
                                m.a("download", "ext_sd_write", i ? 1 : 0, new String[0]);
                                if (i) {
                                    readLine = str + "/Quark/Download";
                                    file = new File(readLine);
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    e.e.add(readLine);
                                } else {
                                    File externalFilesDir = this.a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                                    if (externalFilesDir != null) {
                                        readLine = externalFilesDir.getAbsolutePath();
                                        readLine = str + readLine.substring(readLine.indexOf("/Android/data/"), readLine.length());
                                        if (e.l(readLine)) {
                                            e.e.add(readLine);
                                        }
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (IOException e) {
            }
            if (e.e.size() == 0) {
                e.e.addAll(e.b(this.a));
            }
        }
    }
}
