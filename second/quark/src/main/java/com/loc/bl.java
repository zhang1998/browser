package com.loc;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: ProGuard */
public final class bl {
    private bn a;
    private bp b;

    public bl(bp bpVar) {
        this(bpVar, (byte) 0);
    }

    private bl(bp bpVar, byte b) {
        this.b = bpVar;
        this.a = new bn(this.b.c, this.b.d, bpVar.e == null ? null : bpVar.e);
        this.a.c = -1;
        this.a.d = 0;
    }

    public final void a(bk bkVar) {
        HttpURLConnection a;
        Throwable e;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2 = null;
        int i = 1;
        bn bnVar = this.a;
        String c = this.b.c();
        Map b = this.b.b();
        Map a2 = this.b.a();
        if (bkVar != null) {
            try {
                String a3 = bn.a(a2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(c);
                if (a3 != null) {
                    stringBuffer.append("?").append(a3);
                }
                a = bnVar.a(stringBuffer.toString(), b, false);
                try {
                    a.setRequestProperty("RANGE", "bytes=" + bnVar.d + "-");
                    a.connect();
                    int responseCode = a.getResponseCode();
                    int i2 = responseCode != 200 ? 1 : 0;
                    if (responseCode == SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED) {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        dw dwVar = new dw("网络异常原因：" + a.getResponseMessage() + " 网络异常状态码：" + responseCode);
                        bkVar.a();
                    }
                    InputStream inputStream3 = a.getInputStream();
                    try {
                        Object obj = new byte[1024];
                        while (!Thread.interrupted() && !bnVar.b) {
                            int read = inputStream3.read(obj, 0, 1024);
                            if (read > 0 && (bnVar.c == -1 || bnVar.d < bnVar.c)) {
                                if (read == 1024) {
                                    bkVar.a(obj, bnVar.d);
                                } else {
                                    Object obj2 = new byte[read];
                                    System.arraycopy(obj, 0, obj2, 0, read);
                                    bkVar.a(obj2, bnVar.d);
                                }
                                bnVar.d += (long) read;
                            }
                        }
                        if (bnVar.b) {
                            bkVar.c();
                        } else {
                            bkVar.b();
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable e2) {
                                es.a(e2, "HttpUrlUtil", "makeDownloadGetRequest");
                            } catch (Throwable e22) {
                                es.a(e22, "HttpUrlUtil", "makeDownloadGetRequest");
                            }
                        }
                        if (a != null) {
                            try {
                                a.disconnect();
                            } catch (Throwable e222) {
                                es.a(e222, "HttpUrlUtil", "makeDownloadGetRequest");
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream3;
                        e222 = th;
                    }
                } catch (Throwable th22) {
                    th = th22;
                    inputStream2 = null;
                    e222 = th;
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e222;
                }
            } catch (Throwable e3) {
                inputStream2 = null;
                e222 = e3;
                a = null;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                throw e222;
            }
        }
    }
}
