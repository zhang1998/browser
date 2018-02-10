package com.uc.crashsdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ProGuard */
public final class r {
    public static PendingIntent a = null;

    public static void a() {
        if (a == null && p.h() >= 0) {
            try {
                Context a = e.a();
                Intent launchIntentForPackage = a.getPackageManager().getLaunchIntentForPackage(a.getPackageName());
                launchIntentForPackage.addFlags(335544320);
                a = PendingIntent.getActivity(a, 0, launchIntentForPackage, 0);
            } catch (Throwable th) {
                a.a(th, false);
            }
        }
    }

    public static boolean b() {
        if (a == null) {
            c.c("Restart intent is null!");
            return false;
        }
        try {
            c.b("restarting ...");
            ((AlarmManager) e.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, a);
            return true;
        } catch (Throwable th) {
            a.a(th, false);
            return false;
        }
    }

    public static void a(Context context) {
        Throwable e;
        Throwable th;
        boolean z = true;
        c.a("restartBrowser");
        if (context != null) {
            int c = c();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (p.h() < 0 || (c > 0 && currentTimeMillis - ((long) c) <= ((long) p.h()))) {
                z = false;
            } else {
                long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                b.m();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(new File(b.d()));
                    try {
                        fileOutputStream.write(String.valueOf(currentTimeMillis2).getBytes());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                                a.a(e, true);
                                c.a("restartBrowser, lastTime: " + c + ", currentTime: " + currentTimeMillis + ", needRestart: " + z);
                                if (z) {
                                    try {
                                        d.a(true);
                                    } catch (Throwable th2) {
                                        a.a(th2, false);
                                    }
                                    b();
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            a.a(e, true);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e = e4;
                                    a.a(e, true);
                                    c.a("restartBrowser, lastTime: " + c + ", currentTime: " + currentTimeMillis + ", needRestart: " + z);
                                    if (z) {
                                        d.a(true);
                                        b();
                                    }
                                }
                            }
                            c.a("restartBrowser, lastTime: " + c + ", currentTime: " + currentTimeMillis + ", needRestart: " + z);
                            if (z) {
                                d.a(true);
                                b();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e5) {
                                    a.a(e5, true);
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    e5 = e6;
                    fileOutputStream = null;
                    a.a(e5, true);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    c.a("restartBrowser, lastTime: " + c + ", currentTime: " + currentTimeMillis + ", needRestart: " + z);
                    if (z) {
                        d.a(true);
                        b();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
            c.a("restartBrowser, lastTime: " + c + ", currentTime: " + currentTimeMillis + ", needRestart: " + z);
            if (z) {
                d.a(true);
                b();
            }
        }
    }

    private static int c() {
        Throwable e;
        Throwable th;
        int i = -1;
        File file = new File(b.d());
        if (file.exists()) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[((int) file.length())];
                    if (fileInputStream.read(bArr) > 0) {
                        i = Integer.parseInt(new String(bArr));
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            a.a(e, true);
                            return i;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        a.a(e, true);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e = e4;
                                a.a(e, true);
                                return i;
                            }
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e5) {
                                a.a(e5, true);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e5 = e6;
                fileInputStream = null;
                a.a(e5, true);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return i;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return i;
    }
}
