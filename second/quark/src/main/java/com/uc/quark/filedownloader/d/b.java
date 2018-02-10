package com.uc.quark.filedownloader.d;

import android.text.TextUtils;
import com.uc.quark.ah;
import com.uc.quark.filedownloader.f.c;
import com.uc.quark.filedownloader.f.i;
import com.uc.quark.filedownloader.f.l;
import com.uc.quark.filedownloader.f.o;
import com.uc.quark.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class b implements g {
    protected URLConnection a;
    c b;
    l c;
    o d;

    public b(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    private b(URL url, a aVar) throws IOException {
        if (aVar == null || aVar.a == null) {
            this.a = url.openConnection();
        } else {
            this.a = url.openConnection(aVar.a);
        }
        if (aVar != null) {
            if (aVar.b != null) {
                this.a.setReadTimeout(aVar.b.intValue());
            }
            if (aVar.c != null) {
                this.a.setConnectTimeout(aVar.c.intValue());
            }
        }
    }

    public final void a(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    public final InputStream h() throws IOException {
        return this.a.getInputStream();
    }

    public final Map<String, List<String>> b() {
        return this.a.getRequestProperties();
    }

    public final Map<String, List<String>> c() {
        return this.a.getHeaderFields();
    }

    public final String a(String str) {
        return this.a.getHeaderField(str);
    }

    private static String a(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Entry entry : hashMap.entrySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append("&");
                obj2 = obj;
            }
            stringBuilder.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            obj = obj2;
        }
        return stringBuilder.toString();
    }

    public final void a(int i, String str) throws IOException {
        if (i != ah.a || TextUtils.isEmpty(str)) {
            this.a.connect();
        } else {
            boolean contains = str.contains("WebKitFormBoundary");
            HashMap hashMap = new HashMap();
            if (contains) {
                this.a.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + b(str));
            } else {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            this.a.setDoInput(true);
            this.a.setDoOutput(true);
            OutputStream outputStream = this.a.getOutputStream();
            Writer outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            if (!contains) {
                str = a(hashMap);
            }
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }
        this.b = i.a(this.a.getInputStream());
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
        if (this.a instanceof HttpURLConnection) {
            return ((HttpURLConnection) this.a).getResponseCode();
        }
        return 0;
    }

    public final void e() {
    }

    public final void a(OutputStream outputStream) {
        this.c = i.a(i.a(outputStream));
        this.d = this.c.a();
    }

    public final long a(long j) throws IOException {
        return this.b.b(this.d, j);
    }

    public final void f() throws IOException {
        this.c.b();
    }

    public final void g() throws IOException {
        if (this.b != null) {
            this.b.close();
        }
        if (this.c != null) {
            this.c.close();
        }
    }

    public final boolean i() {
        return true;
    }
}
