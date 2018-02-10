package com.ucpro.feature.video.cache.e;

import com.alibaba.wireless.security.SecExceptionCode;
import com.ucpro.c.b;
import com.ucpro.feature.video.cache.e.b.e;
import com.ucpro.services.f.g;
import com.ucweb.common.util.c;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import okhttp3.Call;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ i b;

    a(i iVar, boolean z) {
        this.b = iVar;
        this.a = z;
    }

    public final void run() {
        String str;
        Exception e;
        Throwable th;
        String str2;
        i iVar = this.b;
        if (this.a) {
            str = iVar.a.b;
        } else {
            str = iVar.a.k;
        }
        String str3 = str;
        int i = 0;
        Closeable closeable = null;
        while (i < 5) {
            int i2 = i + 1;
            try {
                Call newCall = g.a().newCall(new Builder().url(str3).method(SpdyRequest.GET_METHOD, null).build());
                com.ucpro.feature.video.d.a.b();
                Response execute = newCall.execute();
                if (execute == null) {
                    com.ucpro.feature.video.d.a.b();
                    iVar.b.b("m3u8下载response，response == null 失败!");
                    com.ucpro.feature.video.cache.g.a.a("response_is_null", str3);
                    com.ucweb.common.util.o.a.a(closeable);
                    return;
                }
                int code = execute.code();
                com.ucpro.feature.video.d.a.b();
                if (code == 200) {
                    Closeable byteStream = execute.body().byteStream();
                    new StringBuilder("m3u8文件:\n").append(execute.headers().toString());
                    com.ucpro.feature.video.d.a.b();
                    byte[] a = com.ucpro.feature.video.cache.a.a.a((InputStream) byteStream);
                    if (a != null) {
                        com.ucpro.feature.video.d.a.b();
                        com.ucpro.feature.video.d.a.b();
                        try {
                            e eVar;
                            c.a(iVar.a.h);
                            byte[] d = com.ucweb.common.util.k.a.d(com.ucweb.common.util.n.a.a(iVar.a.h, "/", "index.m3u8"));
                            if (d == null || d.length <= 0) {
                                eVar = null;
                                closeable = null;
                            } else {
                                closeable = new ByteArrayInputStream(d);
                                try {
                                    eVar = e.a(closeable);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        iVar.b.b("发生解析异常..Exception:" + e.toString());
                                        new StringBuilder("发生解析异常.. onM3u8RequestSuccessed Exception:").append(e.toString());
                                        com.ucpro.feature.video.d.a.b();
                                        if (b.b()) {
                                            com.ucweb.common.util.k.a.a(com.ucpro.c.c.b("log").getAbsolutePath() + "/", "error" + System.currentTimeMillis() + ".m3u8.txt", a, a.length);
                                        }
                                        com.ucpro.feature.video.cache.g.a.a("parse_error_" + e.toString(), iVar.a.b);
                                        com.ucweb.common.util.o.a.a(closeable);
                                        com.ucweb.common.util.o.a.a(byteStream);
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        com.ucweb.common.util.o.a.a(closeable);
                                        throw th;
                                    }
                                }
                            }
                            Object a2 = com.ucpro.feature.video.cache.a.a.a(a);
                            if (a2 == null || a2.a == null || a2.a.size() == 0) {
                                iVar.b.b("m3u8解析失败, 无有效内容");
                                com.ucpro.feature.video.cache.g.a.a("playlist_empty", iVar.a.b);
                                com.ucpro.feature.video.d.a.b();
                                com.ucweb.common.util.o.a.a(closeable);
                            } else {
                                new StringBuilder("m3u8 meta data解析成功，二进制文件大小：").append(a.length).append(", playlist size:").append(a2.a.size());
                                com.ucpro.feature.video.d.a.b();
                                int a3 = com.ucpro.feature.video.cache.a.a.a(eVar, (e) a2);
                                if (eVar == null || a3 == com.ucpro.feature.video.cache.a.b.a) {
                                    com.ucpro.feature.video.d.a.b();
                                    c.a(a2);
                                    List list = a2.a;
                                    c.a((Object) list);
                                    str = com.ucpro.feature.video.cache.a.a.a(list);
                                    if (com.ucweb.common.util.n.a.b(str)) {
                                        iVar.a.k = com.ucpro.feature.video.cache.a.a.a(iVar.a.b, str);
                                        iVar.a.j = Boolean.valueOf(true);
                                        iVar.a(false);
                                        com.ucpro.feature.video.cache.g.a.b(iVar.a.k);
                                        new StringBuilder("m3u8 meta data 的确需要二次解析ing，mUrl：").append(iVar.a.k);
                                        com.ucpro.feature.video.d.a.b();
                                    } else {
                                        com.ucpro.feature.video.d.a.b();
                                        com.ucpro.feature.video.cache.a.a.b(iVar.a.h);
                                        File file = new File(iVar.a.h, "index.m3u8");
                                        if (!(file.exists() && file.isFile())) {
                                            try {
                                                file.createNewFile();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        if (com.ucweb.common.util.k.a.a(file, a, a.length)) {
                                            iVar.a.i = file.getAbsolutePath();
                                            new StringBuilder("m3u8 meta data 文件落地， 路径：").append(file.getAbsolutePath());
                                            com.ucpro.feature.video.d.a.b();
                                            iVar.b.a(file.getAbsolutePath());
                                        } else {
                                            com.ucpro.feature.video.d.a.b();
                                            iVar.b.b("m3u8文件落地失败");
                                        }
                                    }
                                } else {
                                    new StringBuilder("m3u8 meta data 二次解析请求回来的数据跟前面的完全不一致， 下载出错：不一致type:").append(a3 - 1);
                                    com.ucpro.feature.video.d.a.b();
                                    iVar.b.b("m3u8换源拿回来的文件跟原文件不一致，进入下载出错状态..type:" + (a3 - 1));
                                    com.ucpro.feature.video.cache.g.a.a("re_request_failed", iVar.a.b);
                                }
                                try {
                                    com.ucweb.common.util.o.a.a(closeable);
                                } catch (Throwable th3) {
                                    th = th3;
                                    closeable = byteStream;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            closeable = null;
                            iVar.b.b("发生解析异常..Exception:" + e.toString());
                            new StringBuilder("发生解析异常.. onM3u8RequestSuccessed Exception:").append(e.toString());
                            com.ucpro.feature.video.d.a.b();
                            if (b.b()) {
                                com.ucweb.common.util.k.a.a(com.ucpro.c.c.b("log").getAbsolutePath() + "/", "error" + System.currentTimeMillis() + ".m3u8.txt", a, a.length);
                            }
                            com.ucpro.feature.video.cache.g.a.a("parse_error_" + e.toString(), iVar.a.b);
                            com.ucweb.common.util.o.a.a(closeable);
                            com.ucweb.common.util.o.a.a(byteStream);
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            closeable = null;
                            com.ucweb.common.util.o.a.a(closeable);
                            throw th;
                        }
                    }
                    com.ucpro.feature.video.d.a.b();
                    iVar.b.b("m3u8下载response，数据为空");
                    com.ucpro.feature.video.cache.g.a.a("no_right_data", str3);
                    com.ucweb.common.util.o.a.a(byteStream);
                    return;
                } else if (code < SecExceptionCode.SEC_ERROR_STA_ENC || code > 307) {
                    iVar.b.b("m3u8文件下载返回码错误，本次失败");
                    com.ucpro.feature.video.cache.g.a.a("code_bad_" + code, str3);
                    com.ucpro.feature.video.d.a.b();
                    com.ucweb.common.util.o.a.a(closeable);
                    return;
                } else {
                    str2 = com.ucpro.feature.video.cache.a.a.a(str3, execute.header("location"));
                    try {
                        com.ucpro.feature.video.cache.g.a.b("code_" + code, str2);
                        com.ucpro.feature.video.d.a.b();
                        com.ucweb.common.util.o.a.a(closeable);
                        i = i2;
                        str3 = str2;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            new StringBuilder("m3u8 meta-data下载过程失败，").append(th.getMessage());
                            com.ucpro.feature.video.d.a.b();
                            c.a("m3u8 dwnload error", th);
                            com.ucpro.feature.video.cache.g.a.a("request_exception_" + th.toString(), str2);
                            com.ucweb.common.util.o.a.a(closeable);
                            i = i2;
                            str3 = str2;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                str2 = str3;
            }
        }
        return;
        com.ucweb.common.util.o.a.a(closeable);
        throw th;
    }
}
