package com.uc.a.a;

import android.text.TextUtils;
import com.uc.base.b.c.c.a;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class b {
    String a = "debuglog.txt";
    private File b;
    private ArrayList<String> c = new ArrayList();
    private SimpleDateFormat d = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]<<<< ");
    private int e = 20;

    public final void a(String str) {
        if (str != null) {
            this.c.add(this.d.format(Long.valueOf(System.currentTimeMillis())) + str);
            if (this.e > 0 && this.c.size() >= this.e) {
                a();
            }
        }
    }

    public final void a() {
        if (!TextUtils.isEmpty(this.a)) {
            this.b = a.d(this.a);
        }
        if (this.b != null) {
            try {
                File file = this.b;
                Collection collection = this.c;
                String[] strArr = (String[]) collection.toArray(new String[collection.size()]);
                File parentFile = file.getParentFile();
                if (!(parentFile == null || parentFile.exists())) {
                    parentFile.mkdirs();
                }
                PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
                for (String println : strArr) {
                    printWriter.println(println);
                }
                printWriter.close();
                this.c.clear();
            } catch (Throwable th) {
                com.uc.base.b.b.a.a(th);
            }
        }
    }
}
