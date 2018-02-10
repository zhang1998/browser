package com.loc;

import java.io.InputStream;

/* compiled from: ProGuard */
public final class bx {
    static byte[] a(bc bcVar, String str) {
        Throwable th;
        Throwable th2;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        byte[] bArr = new byte[0];
        ba a;
        try {
            a = bcVar.a(str);
            if (a == null) {
                if (inputStream != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th3) {
                    }
                }
                if (a != null) {
                    try {
                        a.close();
                    } catch (Throwable th4) {
                    }
                }
                return bArr;
            }
            try {
                inputStream = a.a[0];
                if (inputStream == null) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    return bArr;
                }
                bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                bcVar.c(str);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                if (a != null) {
                    a.close();
                }
                return bArr;
            } catch (Throwable th7) {
                th = th7;
                try {
                    es.a(th, "Utils", "readSingleLog");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th8) {
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    return bArr;
                } catch (Throwable th9) {
                    th2 = th9;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th10) {
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th11) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th12) {
            th2 = th12;
            a = inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.close();
            }
            throw th2;
        }
    }
}
