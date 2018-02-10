package com.loc;

import com.uc.apollo.impl.SettingsConst;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class bc implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream q = new ax();
    bd b;
    final ThreadPoolExecutor c = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File d;
    private final File e;
    private final File f;
    private final File g;
    private final int h;
    private long i;
    private final int j;
    private long k = 0;
    private Writer l;
    private final LinkedHashMap<String, bb> m = new LinkedHashMap(0, 0.75f, true);
    private int n;
    private long o = 0;
    private final Callable<Void> p = new aw(this);

    private bc(File file, long j) {
        this.d = file;
        this.h = 1;
        this.e = new File(file, "journal");
        this.f = new File(file, "journal.tmp");
        this.g = new File(file, "journal.bkp");
        this.j = 1;
        this.i = j;
    }

    public static bc a(File file, long j) throws IOException {
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
        bc bcVar = new bc(file, j);
        if (bcVar.e.exists()) {
            try {
                bcVar.d();
                bcVar.e();
                bcVar.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bcVar.e, true), bg.a));
                return bcVar;
            } catch (Throwable th) {
                bcVar.close();
                bg.a(bcVar.d);
            }
        }
        file.mkdirs();
        bcVar = new bc(file, j);
        bcVar.f();
        return bcVar;
    }

    private synchronized void a(az azVar, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            bb bbVar = azVar.a;
            if (bbVar.d != azVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!bbVar.c) {
                    int i2 = 0;
                    while (i2 < this.j) {
                        if (!azVar.b[i2]) {
                            azVar.c();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!bbVar.b(i2).exists()) {
                            azVar.c();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.j) {
                File b = bbVar.b(i);
                if (!z) {
                    a(b);
                } else if (b.exists()) {
                    File a = bbVar.a(i);
                    b.renameTo(a);
                    long j = bbVar.b[i];
                    long length = a.length();
                    bbVar.b[i] = length;
                    this.k = (this.k - j) + length;
                }
                i++;
            }
            this.n++;
            bbVar.d = null;
            if ((bbVar.c | z) != 0) {
                bbVar.c = true;
                this.l.write("CLEAN " + bbVar.a + bbVar.a() + '\n');
                if (z) {
                    long j2 = this.o;
                    this.o = 1 + j2;
                    bbVar.e = j2;
                }
            } else {
                this.m.remove(bbVar.a);
                this.l.write("REMOVE " + bbVar.a + '\n');
            }
            this.l.flush();
            if (this.k > this.i || g()) {
                this.c.submit(this.p);
            }
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

    private void d() throws IOException {
        Closeable bfVar = new bf(new FileInputStream(this.e), bg.a);
        int i;
        try {
            String a = bfVar.a();
            String a2 = bfVar.a();
            String a3 = bfVar.a();
            String a4 = bfVar.a();
            String a5 = bfVar.a();
            if ("libcore.io.DiskLruCache".equals(a) && SettingsConst.TRUE.equals(a2) && Integer.toString(this.h).equals(a3) && Integer.toString(this.j).equals(a4) && "".equals(a5)) {
                i = 0;
                while (true) {
                    a3 = bfVar.a();
                    int indexOf = a3.indexOf(32);
                    if (indexOf == -1) {
                        throw new IOException("unexpected journal line: " + a3);
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = a3.indexOf(32, i2);
                    bb bbVar;
                    if (indexOf2 != -1) {
                        a2 = a3.substring(i2, indexOf2);
                        bbVar = (bb) this.m.get(a2);
                        if (bbVar == null) {
                            bbVar = new bb(this, a2);
                            this.m.put(a2, bbVar);
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
                    String substring = a3.substring(i2);
                    if (indexOf == 6 && a3.startsWith("REMOVE")) {
                        this.m.remove(substring);
                    } else {
                        a2 = substring;
                        bbVar = (bb) this.m.get(a2);
                        if (bbVar == null) {
                            bbVar = new bb(this, a2);
                            this.m.put(a2, bbVar);
                        }
                        if (indexOf2 == -1 && indexOf == 5 && a3.startsWith("CLEAN")) {
                            String[] split = a3.substring(indexOf2 + 1).split(" ");
                            bbVar.c = true;
                            bbVar.d = null;
                            bb.a(bbVar, split);
                        } else if (indexOf2 != -1 && indexOf == 5 && a3.startsWith("DIRTY")) {
                            bbVar.d = new az(this, bbVar);
                        } else if (indexOf2 == -1 && indexOf == 4 && a3.startsWith("READ")) {
                        }
                    }
                    i++;
                }
                throw new IOException("unexpected journal line: " + a3);
            }
            throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
        } catch (EOFException e) {
            this.n = i - this.m.size();
            bg.a(bfVar);
        } catch (Throwable th) {
            bg.a(bfVar);
        }
    }

    private static void d(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private void e() throws IOException {
        a(this.f);
        Iterator it = this.m.values().iterator();
        while (it.hasNext()) {
            bb bbVar = (bb) it.next();
            int i;
            if (bbVar.d == null) {
                for (i = 0; i < this.j; i++) {
                    this.k += bbVar.b[i];
                }
            } else {
                bbVar.d = null;
                for (i = 0; i < this.j; i++) {
                    a(bbVar.a(i));
                    a(bbVar.b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void f() throws IOException {
        if (this.l != null) {
            this.l.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f), bg.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(SettingsConst.TRUE);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.j));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (bb bbVar : this.m.values()) {
                if (bbVar.d != null) {
                    bufferedWriter.write("DIRTY " + bbVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bbVar.a + bbVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.e.exists()) {
                a(this.e, this.g, true);
            }
            a(this.f, this.e, false);
            this.g.delete();
            this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e, true), bg.a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private boolean g() {
        return this.n >= SettingsConst.GLOBAL_SETTINGS && this.n >= this.m.size();
    }

    private void h() {
        if (this.l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void i() throws IOException {
        while (this.k > this.i) {
            String str = (String) ((Entry) this.m.entrySet().iterator().next()).getKey();
            c(str);
            if (this.b != null) {
                this.b.a(str);
            }
        }
    }

    public final synchronized ba a(String str) throws IOException {
        int i;
        ba baVar = null;
        synchronized (this) {
            h();
            d(str);
            bb bbVar = (bb) this.m.get(str);
            if (bbVar != null) {
                if (bbVar.c) {
                    InputStream[] inputStreamArr = new InputStream[this.j];
                    int i2 = 0;
                    while (i2 < this.j) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(bbVar.a(i2));
                            i2++;
                        } catch (FileNotFoundException e) {
                            i = 0;
                            while (i < this.j && inputStreamArr[i] != null) {
                                bg.a(inputStreamArr[i]);
                                i++;
                            }
                        }
                    }
                    this.n++;
                    this.l.append("READ " + str + '\n');
                    if (g()) {
                        this.c.submit(this.p);
                    }
                    baVar = new ba(this, str, bbVar.e, inputStreamArr, bbVar.b);
                }
            }
        }
        return baVar;
    }

    public final synchronized boolean a() {
        return this.l == null;
    }

    final synchronized az b(String str) throws IOException {
        az azVar;
        h();
        d(str);
        bb bbVar = (bb) this.m.get(str);
        if (-1 == -1 || (bbVar != null && bbVar.e == -1)) {
            bb bbVar2;
            if (bbVar == null) {
                bbVar = new bb(this, str);
                this.m.put(str, bbVar);
                bbVar2 = bbVar;
            } else if (bbVar.d != null) {
                azVar = null;
            } else {
                bbVar2 = bbVar;
            }
            azVar = new az(this, bbVar2);
            bbVar2.d = azVar;
            this.l.write("DIRTY " + str + '\n');
            this.l.flush();
        } else {
            azVar = null;
        }
        return azVar;
    }

    public final synchronized void b() throws IOException {
        h();
        i();
        this.l.flush();
    }

    public final synchronized boolean c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            h();
            d(str);
            bb bbVar = (bb) this.m.get(str);
            if (bbVar == null || bbVar.d != null) {
                z = false;
            } else {
                while (i < this.j) {
                    File a = bbVar.a(i);
                    if (!a.exists() || a.delete()) {
                        this.k -= bbVar.b[i];
                        bbVar.b[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.n++;
                this.l.append("REMOVE " + str + '\n');
                this.m.remove(str);
                if (g()) {
                    this.c.submit(this.p);
                }
                z = true;
            }
        }
        return z;
    }

    public final synchronized void close() throws IOException {
        if (this.l != null) {
            Iterator it = new ArrayList(this.m.values()).iterator();
            while (it.hasNext()) {
                bb bbVar = (bb) it.next();
                if (bbVar.d != null) {
                    bbVar.d.c();
                }
            }
            i();
            this.l.close();
            this.l = null;
        }
    }
}
