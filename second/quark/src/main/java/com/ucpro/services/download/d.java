package com.ucpro.services.download;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.quark.ac;
import com.uc.quark.ah;
import com.ucpro.business.stat.m;
import com.ucpro.c.b;
import com.ucpro.services.f.g;
import com.ucweb.common.util.n.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: ProGuard */
final class d implements ac {
    private Builder a;
    private Call b;
    private Response c;
    private Request d;
    private String e;
    private BufferedSink f;
    private BufferedSource g;
    private Buffer h;

    private d(String str) throws IOException {
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = new Builder();
        this.e = str;
    }

    public final void a(String str, String str2) {
        if (b.b()) {
            Log.e("vanda", "name = " + str + "   value = " + str2);
        }
        this.a.addHeader(str, str2);
    }

    public final InputStream h() throws IOException {
        return this.c.body().byteStream();
    }

    public final Map<String, List<String>> b() {
        if (this.d != null) {
            return this.d.headers().toMultimap();
        }
        return null;
    }

    public final Map<String, List<String>> c() {
        if (this.c != null) {
            return this.c.headers().toMultimap();
        }
        return null;
    }

    public final String a(String str) {
        return this.c.header(str);
    }

    public final void a(int i, String str) throws IOException {
        RequestBody requestBody = null;
        if (i == ah.a && a.b(str)) {
            if (str.contains("--WebKitFormBoundary")) {
                requestBody = RequestBody.create(null, str.getBytes());
                this.a.addHeader("Content-Type", "multipart/form-data; boundary=" + b(str));
            } else {
                HashMap hashMap = new HashMap();
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
                FormBody.Builder builder = new FormBody.Builder();
                for (Entry entry : hashMap.entrySet()) {
                    builder.add((String) entry.getKey(), (String) entry.getValue());
                }
                requestBody = builder.build();
            }
        }
        this.a.cacheControl(CacheControl.FORCE_NETWORK);
        this.d = i == ah.a ? this.a.url(this.e).post(requestBody).build() : this.a.url(this.e).get().build();
        this.b = g.a().newCall(this.d);
        this.c = this.b.execute();
        this.g = this.c.body().source();
        new StringBuilder("head = ").append(this.c.headers().toString()).append("  mSource = ").append(this.g);
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str) || str.length() <= 2) {
            return null;
        }
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new StringReader(str));
            try {
                String readLine = bufferedReader3.readLine();
                if (readLine.length() > 2) {
                    readLine = readLine.substring(2);
                    try {
                        bufferedReader3.close();
                        return readLine;
                    } catch (IOException e) {
                        return readLine;
                    }
                }
                try {
                    bufferedReader3.close();
                    return readLine;
                } catch (IOException e2) {
                    return readLine;
                }
            } catch (Exception e3) {
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public final int d() throws IOException {
        return this.c.code();
    }

    public final void e() {
        if (this.c != null) {
            this.c.close();
        }
    }

    public final void a(OutputStream outputStream) {
        this.f = Okio.buffer(Okio.sink(outputStream));
        this.h = this.f.buffer();
    }

    public final long a(long j) throws IOException {
        return this.g.read(this.h, j);
    }

    public final void f() throws IOException {
        this.f.emit();
    }

    public final void g() throws IOException {
        if (this.g != null) {
            this.g.close();
        }
        if (this.f != null) {
            this.f.close();
        }
    }

    public final void a() {
        try {
            Toast.makeText(com.ucweb.common.util.d.a(), com.ucweb.common.util.d.c().getString(R.string.app_name) + com.ucweb.common.util.d.c().getString(R.string.download_network_switch_tips), 1).show();
        } catch (Exception e) {
        }
    }

    public final void a(String str, Throwable th) {
        String str2;
        String str3;
        String[] strArr;
        String th2;
        m.a("download", "task_err", new String[0]);
        if (th instanceof com.uc.quark.filedownloader.a.b) {
            str2 = "download";
            str3 = "sd_excep";
            strArr = new String[2];
            strArr[0] = "exception";
            strArr[1] = th != null ? th.toString() : "null";
            m.a(str2, str3, strArr);
        }
        str2 = "download";
        str3 = INoCaptchaComponent.status;
        strArr = new String[4];
        strArr[0] = "url";
        strArr[1] = str;
        strArr[2] = "exception";
        if (th != null) {
            th2 = th.toString();
        } else {
            th2 = "null";
        }
        strArr[3] = th2;
        m.a(str2, str3, strArr);
    }

    public final void j() {
        m.a("download", "task_complete", new String[0]);
    }

    public final void k() {
        m.a("download", "add_task", new String[0]);
    }

    public final void l() {
        m.a("download", "start_task", "start_task_num", SettingsConst.TRUE);
    }

    public final boolean i() {
        boolean c = com.ucpro.business.e.d.g.a().c("is_read_write_separation");
        if (b.b()) {
            return com.ucpro.model.a.a.a.a("read_write_separation", false);
        }
        return c;
    }
}
