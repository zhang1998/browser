package com.alibaba.analytics.a;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class f {
    static {
        System.setProperty("http.keepAlive", "true");
    }

    public static ad a(int i, String str, Map<String, Object> map) {
        DataOutputStream dataOutputStream;
        Throwable th;
        InputStream inputStream;
        ad adVar = new ad();
        if (TextUtils.isEmpty(str)) {
            return adVar;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection != null) {
                if (i == 2 || i == 3) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setDoInput(true);
                if (i == 2 || i == 3) {
                    try {
                        httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
                    } catch (ProtocolException e) {
                        return adVar;
                    }
                }
                httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setRequestProperty("Connection", "close");
                httpURLConnection.setInstanceFollowRedirects(true);
                byte[] bArr = null;
                if (i == 2 || i == 3) {
                    byte[] bArr2;
                    int length;
                    if (i == 2) {
                        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                    } else if (i == 3) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    if (map == null || map.size() <= 0) {
                        bArr2 = null;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Set keySet = map.keySet();
                        String[] strArr = new String[keySet.size()];
                        keySet.toArray(strArr);
                        for (String str2 : n.a().a(strArr)) {
                            if (i == 2) {
                                bArr = (byte[]) map.get(str2);
                                if (bArr != null) {
                                    try {
                                        byteArrayOutputStream.write(String.format("--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n", new Object[]{str2, str2}).getBytes());
                                        byteArrayOutputStream.write(bArr);
                                        byteArrayOutputStream.write("\r\n".getBytes());
                                    } catch (IOException e2) {
                                    }
                                }
                            } else if (i == 3) {
                                String str3 = (String) map.get(str2);
                                if (byteArrayOutputStream.size() > 0) {
                                    try {
                                        byteArrayOutputStream.write(("&" + str2 + "=" + str3).getBytes());
                                    } catch (IOException e3) {
                                    }
                                } else {
                                    try {
                                        byteArrayOutputStream.write((str2 + "=" + str3).getBytes());
                                    } catch (IOException e4) {
                                    }
                                }
                            }
                        }
                        if (i == 2) {
                            try {
                                byteArrayOutputStream.write("--GJircTeP--\r\n".getBytes());
                            } catch (IOException e5) {
                            }
                        }
                        bArr2 = byteArrayOutputStream.toByteArray();
                    }
                    if (bArr2 != null) {
                        length = bArr2.length;
                    } else {
                        length = 0;
                    }
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
                    bArr = bArr2;
                }
                long currentTimeMillis = System.currentTimeMillis();
                DataOutputStream dataOutputStream2 = null;
                try {
                    httpURLConnection.connect();
                    if ((i == 2 || i == 3) && bArr != null && bArr.length > 0) {
                        DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream3.write(bArr);
                            dataOutputStream3.flush();
                            dataOutputStream2 = dataOutputStream3;
                        } catch (Exception e6) {
                            dataOutputStream = dataOutputStream3;
                            try {
                                adVar.c = System.currentTimeMillis() - currentTimeMillis;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e7) {
                                    }
                                }
                                return adVar;
                            } catch (Throwable th2) {
                                dataOutputStream2 = dataOutputStream;
                                th = th2;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream3;
                            if (dataOutputStream2 != null) {
                                dataOutputStream2.close();
                            }
                            throw th;
                        }
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e9) {
                        }
                    }
                    try {
                        adVar.a = httpURLConnection.getResponseCode();
                    } catch (IOException e10) {
                    }
                    adVar.c = System.currentTimeMillis() - currentTimeMillis;
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    InputStream dataInputStream;
                    try {
                        dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        try {
                            System.currentTimeMillis();
                            byte[] bArr3 = new byte[2048];
                            while (true) {
                                int read = dataInputStream.read(bArr3, 0, 2048);
                                if (read != -1) {
                                    byteArrayOutputStream2.write(bArr3, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e11) {
                                    }
                                }
                            }
                            dataInputStream.close();
                            if (byteArrayOutputStream2.size() > 0) {
                                adVar.b = byteArrayOutputStream2.toByteArray();
                            }
                        } catch (IOException e12) {
                            inputStream = dataInputStream;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            return adVar;
                        } catch (Throwable th4) {
                            th = th4;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e15) {
                        inputStream = null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return adVar;
                    } catch (Throwable th5) {
                        th = th5;
                        dataInputStream = null;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    dataOutputStream = null;
                    adVar.c = System.currentTimeMillis() - currentTimeMillis;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    return adVar;
                } catch (Throwable th6) {
                    th = th6;
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    throw th;
                }
            }
            return adVar;
        } catch (MalformedURLException e17) {
            return adVar;
        } catch (IOException e18) {
            return adVar;
        }
    }
}
