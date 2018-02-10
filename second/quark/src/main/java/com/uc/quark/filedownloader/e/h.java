package com.uc.quark.filedownloader.e;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: ProGuard */
public class h {
    public final int a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;

    public static h a() {
        return g.a;
    }

    private h() {
        if (e.a() == null) {
            throw new IllegalStateException("Please invoke the FileDownloader#init in Application#onCreate first.");
        }
        String property;
        long currentTimeMillis = System.currentTimeMillis();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = e.a().getAssets().open("filedownloader.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                str = properties.getProperty("http.lenient");
                str2 = properties.getProperty("process.non-separate");
                str3 = properties.getProperty("download.min-progress-step");
                str4 = properties.getProperty("download.min-progress-time");
                str5 = properties.getProperty("download.max-network-thread-count");
                property = properties.getProperty("download.max-video-thread-count");
            } else {
                property = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            if ((e2 instanceof FileNotFoundException) && j.a) {
                j.d(h.class, "not found filedownloader.properties", new Object[0]);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    property = null;
                } catch (IOException e3) {
                    property = null;
                }
            } else {
                property = null;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        if (str == null) {
            this.c = true;
        } else if (str.equals("true") || str.equals("false")) {
            this.c = str.equals("true");
        } else {
            throw new IllegalStateException(b.a("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", "false"));
        }
        if (str2 == null) {
            this.d = false;
        } else if (str2.equals("true") || str2.equals("false")) {
            this.d = str2.equals("true");
        } else {
            throw new IllegalStateException(b.a("the value of '%s' must be '%s' or '%s'", "process.non-separate", "true", "false"));
        }
        if (str3 != null) {
            this.a = Math.max(0, Integer.valueOf(str3).intValue());
        } else {
            this.a = 65536;
        }
        if (str4 != null) {
            this.b = Math.max(0, Long.valueOf(str4).longValue());
        } else {
            this.b = 2000;
        }
        if (str5 != null) {
            this.e = a(Integer.valueOf(str5).intValue());
        } else {
            this.e = 3;
        }
        if (property != null) {
            this.f = a(Integer.valueOf(property).intValue());
        } else {
            this.f = 3;
        }
        if (j.a) {
            j.c(h.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "http.lenient", Boolean.valueOf(this.c), "process.non-separate", Boolean.valueOf(this.d), "download.min-progress-step", Integer.valueOf(this.a), "download.min-progress-time", Long.valueOf(this.b), "download.max-network-thread-count", Integer.valueOf(this.e));
        }
    }

    public static int a(int i) {
        if (i > 12) {
            j.e(h.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), Integer.valueOf(12), Integer.valueOf(12));
            return 12;
        } else if (i > 0) {
            return i;
        } else {
            j.e(h.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
            return 1;
        }
    }
}
