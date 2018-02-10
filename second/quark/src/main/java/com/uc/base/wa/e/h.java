package com.uc.base.wa.e;

import android.util.Log;
import com.uc.base.wa.a.c;
import com.uc.base.wa.config.b;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
final class h {
    HashMap<Integer, Integer> a = new HashMap();
    int[] b;
    int[] c;
    private long d = System.currentTimeMillis();
    private int[] e = b.d;
    private ByteArrayOutputStream[] f;
    private OutputStreamWriter[] g;
    private BufferedWriter[] h;

    public h() throws UnsupportedEncodingException {
        int length = this.e.length;
        this.b = new int[length];
        this.c = new int[length];
        this.f = new ByteArrayOutputStream[length];
        this.g = new OutputStreamWriter[length];
        this.h = new BufferedWriter[length];
        for (int i = 0; i < length; i++) {
            this.a.put(Integer.valueOf(this.e[i]), Integer.valueOf(i));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Writer outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            this.b[i] = 0;
            this.c[i] = b.a(this.e[i]);
            this.f[i] = byteArrayOutputStream;
            this.g[i] = outputStreamWriter;
            this.h[i] = bufferedWriter;
        }
    }

    public final void a() throws IOException {
        int length = this.e.length;
        for (int i = 0; i < length; i++) {
            if (this.h[i] != null) {
                this.h[i].close();
            }
            if (this.g[i] != null) {
                this.g[i].close();
            }
            if (this.f[i] != null) {
                this.f[i].close();
            }
        }
    }

    public final void a(int i, List<b> list, String str) throws IOException {
        Integer num = (Integer) this.a.get(Integer.valueOf(i));
        int[] iArr = this.b;
        int intValue = num.intValue();
        iArr[intValue] = iArr[intValue] + list.size();
        BufferedWriter bufferedWriter = this.h[num.intValue()];
        for (b bVar : list) {
            byte[] b;
            bufferedWriter.newLine();
            try {
                b = c.a().b(bVar.c);
            } catch (Throwable e) {
                Log.e("gzm_SessionService", "", e);
                c.a().b(e.toString());
                b = null;
            }
            if (b == null) {
                Log.e("gzm_SessionService", "decode fail", new Throwable());
                c.a().b("decode fail");
                bufferedWriter.write(str + "null");
            } else {
                bufferedWriter.write(str + new String(b, "utf-8"));
            }
        }
    }

    public final int b() {
        int i = 0;
        int length = this.e.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte[] toByteArray = this.f[i2].toByteArray();
            if (!(toByteArray == null || toByteArray.length == 0 || toByteArray == null || toByteArray.length <= 0)) {
                int i3 = this.e[i2];
                String a = com.uc.base.wa.c.c.a(i3, "session", this.d);
                File file = new File(b.i() + "/" + a);
                if (c.a().a(toByteArray, file)) {
                    File file2 = new File(com.uc.base.wa.c.c.a(i3) + "/" + a);
                    if (file.renameTo(file2)) {
                        i = (int) (file2.length() + ((long) i));
                    }
                } else {
                    Log.e("gzm_SessionService", "encodeData2File fail");
                }
            }
        }
        return i;
    }
}
