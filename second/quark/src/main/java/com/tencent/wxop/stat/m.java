package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.e;
import com.tencent.wxop.stat.a.n;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

final class m implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ k b;
    final /* synthetic */ n c;

    m(n nVar, List list, k kVar) {
        this.c = nVar;
        this.a = list;
        this.b = kVar;
    }

    public final void run() {
        int i = 0;
        n nVar = this.c;
        List list = this.a;
        k kVar = this.b;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            Throwable th;
            try {
                String str;
                nVar.d.delete(0, nVar.d.length());
                nVar.d.append("[");
                String str2 = "rc4";
                for (int i2 = 0; i2 < size; i2++) {
                    nVar.d.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        nVar.d.append(",");
                    }
                }
                nVar.d.append("]");
                String stringBuilder = nVar.d.toString();
                int length = stringBuilder.length();
                String str3 = i.p() + "/?index=" + nVar.f;
                nVar.f++;
                if (i.b()) {
                    n.a.a("[" + str3 + "]Send request(" + length + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost httpHost = d.a(n.e).d;
                httpPost.addHeader("Content-Encoding", str2);
                if (httpHost == null) {
                    nVar.b.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (i.b()) {
                        n.a.g("proxy:" + httpHost.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    nVar.b.getParams().setParameter("http.route.default-proxy", httpHost);
                    httpPost.addHeader("X-Online-Host", i.l);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length2 = bytes.length;
                if (length > i.p) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (httpHost != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                    if (i.b()) {
                        n.a.g("before Gzip:" + length2 + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(e.a(bytes)));
                HttpResponse execute = nVar.b.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                length = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (i.b()) {
                    n.a.a("http recv response status code:" + length + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    n.a.e("Server response no data.");
                    if (kVar != null) {
                        kVar.b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = e.b(n.a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = n.a(e.b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = n.a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = e.b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (i.b()) {
                        n.a.a("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (length == 200) {
                        n.a(jSONObject);
                        if (kVar != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                kVar.a();
                            } else {
                                n.a.d("response error data.");
                                kVar.b();
                            }
                        }
                    } else {
                        n.a.d("Server response error code:" + length + ", error:" + new String(bytes, "UTF-8"));
                        if (kVar != null) {
                            kVar.b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    n.a.a(th);
                    if (kVar != null) {
                        try {
                            kVar.b();
                        } catch (Throwable th2) {
                            n.a.b(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        nVar.d = null;
                        nVar.d = new StringBuilder(2048);
                    }
                    d a = d.a(n.e);
                    a.e = (a.e + 1) % a.a.size();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }
}
