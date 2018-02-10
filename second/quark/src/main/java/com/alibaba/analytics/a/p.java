package com.alibaba.analytics.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: ProGuard */
public final class p {
    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
            } catch (Exception e) {
                gZIPOutputStream = bArr2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    return bArr2;
                }
                try {
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (IOException e3) {
                    return bArr2;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                gZIPOutputStream = bArr2;
                th = th3;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                } catch (IOException e6) {
                }
                try {
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (IOException e7) {
                    return bArr2;
                }
            } catch (Exception e8) {
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    return bArr2;
                }
                byteArrayOutputStream.close();
                return bArr2;
            } catch (Throwable th4) {
                th = th4;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            gZIPOutputStream = bArr2;
            byteArrayOutputStream = bArr2;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                return bArr2;
            }
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th22) {
            byteArrayOutputStream = bArr2;
            byte[] bArr3 = bArr2;
            th = th22;
            gZIPOutputStream = bArr3;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr2 = null;
        GZIPInputStream gZIPInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr3 = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr3, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr3, 0, read);
                        } catch (Exception e) {
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    byteArrayOutputStream.flush();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e3) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                    }
                } catch (Exception e5) {
                    byteArrayOutputStream = bArr2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    return bArr2;
                } catch (Throwable th4) {
                    th2 = th4;
                    byteArrayOutputStream = bArr2;
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e9) {
                        }
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e10) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e11) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e12) {
                byteArrayOutputStream = bArr2;
                gZIPInputStream = bArr2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return bArr2;
            } catch (Throwable th42) {
                gZIPInputStream = bArr2;
                byte[] bArr4 = bArr2;
                th = th42;
                byteArrayOutputStream = bArr4;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
        } catch (Exception e13) {
            byteArrayOutputStream = bArr2;
            gZIPInputStream = bArr2;
            byteArrayInputStream = bArr2;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return bArr2;
        } catch (Throwable th422) {
            gZIPInputStream = bArr2;
            byteArrayInputStream = bArr2;
            th2 = th422;
            byteArrayOutputStream = bArr2;
            th = th2;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
        return bArr2;
    }

    public static byte[] a(String str) {
        GZIPOutputStream gZIPOutputStream;
        byte[] a;
        Throwable th;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream.flush();
                try {
                    gZIPOutputStream.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                a = w.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
                byteArrayOutputStream.close();
                return a;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                gZIPOutputStream2 = gZIPOutputStream;
                th = th3;
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            gZIPOutputStream = null;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            a = w.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
            byteArrayOutputStream.close();
            return a;
        } catch (Throwable th4) {
            th = th4;
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            throw th;
        }
        a = w.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
        try {
            byteArrayOutputStream.close();
        } catch (Exception e6) {
        }
        return a;
    }
}
