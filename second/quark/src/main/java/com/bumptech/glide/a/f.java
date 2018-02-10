package com.bumptech.glide.a;

import com.uc.apollo.impl.SettingsConst;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
public final class f implements Closeable {
    final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private long i = 0;
    private Writer j;
    private final LinkedHashMap<String, d> k = new LinkedHashMap(0, 0.75f, true);
    private int l;
    private long m = 0;
    private final Callable<Void> n = new a(this);

    private f(File file, long j) {
        this.b = file;
        this.f = 1;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = 1;
        this.g = j;
    }

    public static f a(File file, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        f fVar = new f(file, j);
        if (fVar.c.exists()) {
            try {
                fVar.b();
                fVar.c();
                return fVar;
            } catch (IOException e) {
                PrintStream printStream = System.out;
                new StringBuilder("DiskLruCache ").append(file).append(" is corrupt: ").append(e.getMessage()).append(", removing");
                fVar.a();
            }
        }
        file.mkdirs();
        fVar = new f(file, j);
        fVar.d();
        return fVar;
    }

    private void b() throws IOException {
        Object obj;
        Closeable hVar = new h(new FileInputStream(this.c), i.a);
        int i;
        try {
            String a = hVar.a();
            String a2 = hVar.a();
            String a3 = hVar.a();
            String a4 = hVar.a();
            String a5 = hVar.a();
            if ("libcore.io.DiskLruCache".equals(a) && SettingsConst.TRUE.equals(a2) && Integer.toString(this.f).equals(a3) && Integer.toString(this.h).equals(a4) && "".equals(a5)) {
                i = 0;
                while (true) {
                    a4 = hVar.a();
                    int indexOf = a4.indexOf(32);
                    if (indexOf == -1) {
                        throw new IOException("unexpected journal line: " + a4);
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = a4.indexOf(32, i2);
                    d dVar;
                    if (indexOf2 != -1) {
                        a3 = a4.substring(i2, indexOf2);
                        dVar = (d) this.k.get(a3);
                        if (dVar == null) {
                            dVar = new d(this, a3);
                            this.k.put(a3, dVar);
                        }
                        if (indexOf2 == -1) {
                        }
                        if (indexOf2 != -1) {
                        }
                        if (indexOf2 == -1) {
                            break;
                        }
                        break;
                    }
                    a = a4.substring(i2);
                    if (indexOf == 6 && a4.startsWith("REMOVE")) {
                        this.k.remove(a);
                    } else {
                        a3 = a;
                        dVar = (d) this.k.get(a3);
                        if (dVar == null) {
                            dVar = new d(this, a3);
                            this.k.put(a3, dVar);
                        }
                        if (indexOf2 == -1 && indexOf == 5 && a4.startsWith("CLEAN")) {
                            String[] split = a4.substring(indexOf2 + 1).split(" ");
                            dVar.e = true;
                            dVar.f = null;
                            d.a(dVar, split);
                        } else if (indexOf2 != -1 && indexOf == 5 && a4.startsWith("DIRTY")) {
                            dVar.f = new c(this, dVar);
                        } else if (indexOf2 == -1 && indexOf == 4 && a4.startsWith("READ")) {
                        }
                    }
                    i++;
                }
                throw new IOException("unexpected journal line: " + a4);
            }
            throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
        } catch (EOFException e) {
            this.l = i - this.k.size();
            if (hVar.b == -1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                d();
            } else {
                this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), i.a));
            }
            i.a(hVar);
        } catch (Throwable th) {
            i.a(hVar);
        }
    }

    private void c() throws IOException {
        a(this.d);
        Iterator it = this.k.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i;
            if (dVar.f == null) {
                for (i = 0; i < this.h; i++) {
                    this.i += dVar.b[i];
                }
            } else {
                dVar.f = null;
                for (i = 0; i < this.h; i++) {
                    a(dVar.c[i]);
                    a(dVar.d[i]);
                }
                it.remove();
            }
        }
    }

    private synchronized void d() throws IOException {
        if (this.j != null) {
            this.j.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), i.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(SettingsConst.TRUE);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.k.values()) {
                if (dVar.f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.c.exists()) {
                a(this.c, this.e, true);
            }
            a(this.d, this.c, false);
            this.e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), i.a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized e a(String str) throws IOException {
        e eVar = null;
        synchronized (this) {
            f();
            d dVar = (d) this.k.get(str);
            if (dVar != null) {
                if (dVar.e) {
                    for (File exists : dVar.c) {
                        if (!exists.exists()) {
                            break;
                        }
                    }
                    this.l++;
                    this.j.append("READ");
                    this.j.append(' ');
                    this.j.append(str);
                    this.j.append('\n');
                    if (e()) {
                        this.a.submit(this.n);
                    }
                    eVar = new e(this, str, dVar.g, dVar.c, dVar.b);
                }
            }
        }
        return eVar;
    }

    public final synchronized c b(String str) throws IOException {
        c cVar;
        f();
        d dVar = (d) this.k.get(str);
        if (-1 == -1 || (dVar != null && dVar.g == -1)) {
            d dVar2;
            if (dVar == null) {
                dVar = new d(this, str);
                this.k.put(str, dVar);
                dVar2 = dVar;
            } else if (dVar.f != null) {
                cVar = null;
            } else {
                dVar2 = dVar;
            }
            cVar = new c(this, dVar2);
            dVar2.f = cVar;
            this.j.append("DIRTY");
            this.j.append(' ');
            this.j.append(str);
            this.j.append('\n');
            this.j.flush();
        } else {
            cVar = null;
        }
        return cVar;
    }

    private synchronized void a(c cVar, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            d dVar = cVar.a;
            if (dVar.f != cVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!dVar.e) {
                    int i2 = 0;
                    while (i2 < this.h) {
                        if (!cVar.b[i2]) {
                            cVar.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!dVar.d[i2].exists()) {
                            cVar.b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.h) {
                File file = dVar.d[i];
                if (!z) {
                    a(file);
                } else if (file.exists()) {
                    File file2 = dVar.c[i];
                    file.renameTo(file2);
                    long j = dVar.b[i];
                    long length = file2.length();
                    dVar.b[i] = length;
                    this.i = (this.i - j) + length;
                }
                i++;
            }
            this.l++;
            dVar.f = null;
            if ((dVar.e | z) != 0) {
                dVar.e = true;
                this.j.append("CLEAN");
                this.j.append(' ');
                this.j.append(dVar.a);
                this.j.append(dVar.a());
                this.j.append('\n');
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    dVar.g = j2;
                }
            } else {
                this.k.remove(dVar.a);
                this.j.append("REMOVE");
                this.j.append(' ');
                this.j.append(dVar.a);
                this.j.append('\n');
            }
            this.j.flush();
            if (this.i > this.g || e()) {
                this.a.submit(this.n);
            }
        }
    }

    private boolean e() {
        return this.l >= SettingsConst.GLOBAL_SETTINGS && this.l >= this.k.size();
    }

    private synchronized boolean c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            f();
            d dVar = (d) this.k.get(str);
            if (dVar == null || dVar.f != null) {
                z = false;
            } else {
                while (i < this.h) {
                    File file = dVar.c[i];
                    if (!file.exists() || file.delete()) {
                        this.i -= dVar.b[i];
                        dVar.b[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + file);
                    }
                }
                this.l++;
                this.j.append("REMOVE");
                this.j.append(' ');
                this.j.append(str);
                this.j.append('\n');
                this.k.remove(str);
                if (e()) {
                    this.a.submit(this.n);
                }
                z = true;
            }
        }
        return z;
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void close() throws IOException {
        if (this.j != null) {
            Iterator it = new ArrayList(this.k.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f != null) {
                    dVar.f.b();
                }
            }
            g();
            this.j.close();
            this.j = null;
        }
    }

    private void g() throws IOException {
        while (this.i > this.g) {
            c((String) ((Entry) this.k.entrySet().iterator().next()).getKey());
        }
    }

    public final void a() throws IOException {
        close();
        i.a(this.b);
    }
}
