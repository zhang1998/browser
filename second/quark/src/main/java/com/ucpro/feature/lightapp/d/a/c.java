package com.ucpro.feature.lightapp.d.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import com.ucpro.b.d.a;
import com.ucpro.business.stat.m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class c {
    public i a;
    private Context b;
    private int c = 10;
    private int d = 10;
    private g e;
    private g f;

    public c(Context context) {
        this.b = context;
    }

    public final synchronized i a() {
        String str;
        String[] strArr;
        Throwable th;
        i iVar;
        boolean z = true;
        synchronized (this) {
            m.a("lightapp", "operate_db", new String[0]);
            if (this.a == null) {
                this.a = new i(this.b);
                i iVar2 = this.a;
                long uptimeMillis = SystemClock.uptimeMillis();
                iVar2.a = new j(iVar2.c);
                j jVar = iVar2.a;
                if (!jVar.a()) {
                    jVar.getReadableDatabase();
                    try {
                        InputStream open = jVar.c.getAssets().open(jVar.b);
                        OutputStream fileOutputStream = new FileOutputStream(jVar.a);
                        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(open);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        com.ucpro.feature.lightapp.m.a("cache_copy_error", "first_run_after_install", String.valueOf(a.c()), "error_msg", e.getMessage());
                    }
                }
                try {
                    jVar = iVar2.a;
                    jVar.d = SQLiteDatabase.openDatabase(jVar.a, null, 0);
                    iVar2.b = jVar.d;
                    str = "lightapp";
                    m.a(str, "cache_db_open_time_cost", "time_cost", String.valueOf(SystemClock.uptimeMillis() - uptimeMillis), "first_run_after_install", String.valueOf(a.c()), "open_db_result", "true");
                } catch (SQLException e2) {
                    strArr = new String[]{"first_run_after_install", String.valueOf(a.c()), "error_msg", e2.getMessage()};
                    m.a("lightapp", "cache_open_db_error", strArr);
                    str = "lightapp";
                    m.a(str, "cache_db_open_time_cost", "time_cost", String.valueOf(SystemClock.uptimeMillis() - uptimeMillis), "first_run_after_install", String.valueOf(a.c()), "open_db_result", "false");
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                    strArr = new String[]{"time_cost", String.valueOf(SystemClock.uptimeMillis() - uptimeMillis), "first_run_after_install", String.valueOf(a.c()), "open_db_result", String.valueOf(z)};
                    m.a("lightapp", "cache_db_open_time_cost", strArr);
                    throw th;
                }
            }
            iVar = this.a;
        }
        return iVar;
    }

    public final synchronized g b() {
        if (this.e == null) {
            this.e = new g(this.c);
            this.e.a = new a(this);
        }
        return this.e;
    }

    public final synchronized g c() {
        if (this.f == null) {
            this.f = new g(this.d);
            this.f.a = new e(this);
        }
        return this.f;
    }
}
