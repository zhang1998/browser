package com.a.a.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class az extends as {
    private static final Pattern d = Pattern.compile("UTDID\">([^<]+)");
    private Context e;

    public az(Context context) {
        super("utdid");
        this.e = context;
    }

    public final String b() {
        try {
            return (String) Class.forName("com.e.a.a").getMethod("getUtdid", new Class[]{Context.class}).invoke(null, new Object[]{this.e});
        } catch (Exception e) {
            return c();
        }
    }

    private String c() {
        File d = d();
        if (d == null || !d.exists()) {
            return null;
        }
        InputStream fileInputStream;
        try {
            String group;
            fileInputStream = new FileInputStream(d);
            CharSequence a = fu.a(fileInputStream);
            if (a != null) {
                Matcher matcher = d.matcher(a);
                if (matcher.find()) {
                    group = matcher.group(1);
                    fu.c(fileInputStream);
                    return group;
                }
            }
            group = null;
            fu.c(fileInputStream);
            return group;
        } catch (Exception e) {
            return null;
        } catch (Throwable th) {
            fu.c(fileInputStream);
        }
    }

    private File d() {
        if (!ey.a(this.e, "android.permission.WRITE_EXTERNAL_STORAGE") || !Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        } catch (Exception e) {
            return null;
        }
    }
}
