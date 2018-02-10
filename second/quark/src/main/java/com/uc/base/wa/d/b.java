package com.uc.base.wa.d;

import android.util.Log;
import com.uc.base.wa.a.c;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: ProGuard */
final class b implements Runnable {
    private FileChannel a;
    private FileLock b;
    private FileOutputStream c;
    private Runnable d;

    public b(Runnable runnable) {
        this.d = runnable;
    }

    private boolean a() {
        if (this.c == null) {
            try {
                this.c = new FileOutputStream(new File(com.uc.base.wa.config.b.j()));
            } catch (Throwable e) {
                Log.e("gzm_wa_WaNet", "", e);
                c.a().b(e.toString());
                return false;
            }
        }
        if (this.a == null) {
            this.a = this.c.getChannel();
        }
        if (this.b == null) {
            try {
                this.b = this.a.lock();
            } catch (Throwable e2) {
                Log.e("gzm_wa_WaNet", "", e2);
                c.a().b(e2.toString());
            }
        }
        if (this.b == null) {
            return false;
        }
        return true;
    }

    private void b() {
        if (this.b != null) {
            try {
                this.b.release();
            } catch (Throwable e) {
                Log.e("gzm_wa_WaNet", "", e);
                c.a().b(e.toString());
            }
            this.b = null;
        }
        if (this.a != null) {
            try {
                this.a.close();
            } catch (Throwable e2) {
                Log.e("gzm_wa_WaNet", "", e2);
                c.a().b(e2.toString());
            }
            this.a = null;
        }
        if (this.c != null) {
            try {
                this.c.close();
            } catch (Throwable e22) {
                Log.e("gzm_wa_WaNet", "", e22);
                c.a().b(e22.toString());
            }
            this.c = null;
        }
    }

    public final void run() {
        if (a()) {
            try {
                this.d.run();
            } finally {
                b();
            }
        }
    }
}
