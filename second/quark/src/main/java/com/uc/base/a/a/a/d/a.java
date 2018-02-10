package com.uc.base.a.a.a.d;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.uc.base.a.a.a.c;
import com.uc.base.a.a.a.g.b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class a {
    private static String b(TreeMap<String, String> treeMap) {
        String str = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : treeMap.entrySet()) {
            stringBuilder.append((String) entry.getKey()).append("=").append((String) entry.getValue());
        }
        String a = c.a().a(stringBuilder.toString());
        return a != null ? a : str;
    }

    private static String c(TreeMap<String, String> treeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            if (!TextUtils.isEmpty(str)) {
                if (obj == null) {
                    stringBuilder.append("&");
                } else {
                    obj = null;
                }
                String str2 = (String) entry.getValue();
                stringBuilder.append(str).append("=").append(str2 != null ? URLEncoder.encode(str2) : "");
            }
        }
        return stringBuilder.toString();
    }

    public static b a(TreeMap<String, String> treeMap) {
        b bVar = new b();
        try {
            b aVar = new com.uc.base.a.a.a.g.a();
            aVar.a(com.uc.base.a.a.a.b.a.a());
            aVar.b(SpdyRequest.POST_METHOD);
            aVar.a();
            aVar.b();
            OutputStream c = aVar.c();
            treeMap.put("locale", c.a.o());
            TreeMap treeMap2 = new TreeMap();
            treeMap2.put("t", String.valueOf(System.currentTimeMillis()));
            treeMap2.put("request_id", UUID.randomUUID().toString());
            treeMap2.put("client_id", c.a.a());
            treeMap2.put("device_id", c.a.i());
            treeMap2.put("sdk_v", "1.0");
            treeMap2.put("server_v", "1.2");
            treeMap2.put("os", "android");
            treeMap2.put("fr", VERSION.RELEASE);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ip:").append(c.a.b());
            stringBuilder.append("`");
            stringBuilder.append("imei:").append(c.a.c());
            stringBuilder.append("`");
            stringBuilder.append("imsi:").append(c.a.d());
            stringBuilder.append("`");
            stringBuilder.append("sn:").append(c.a.e());
            stringBuilder.append("`");
            stringBuilder.append("machine:").append(c.a.g());
            stringBuilder.append("`");
            stringBuilder.append("app_name:").append(c.a.f());
            stringBuilder.append("`");
            stringBuilder.append("os:Android");
            stringBuilder.append("`");
            stringBuilder.append("mac:").append(c.a.h());
            stringBuilder.append("`");
            stringBuilder.append("idfa:");
            stringBuilder.append("`");
            stringBuilder.append("utdid:").append(c.a.i());
            stringBuilder.append("`");
            stringBuilder.append("version:1.0");
            stringBuilder.append("`");
            stringBuilder.append("port:");
            stringBuilder.append("`");
            stringBuilder.append("game_id:").append(c.a.j());
            stringBuilder.append("`");
            stringBuilder.append("net_type:").append(c.a.k());
            stringBuilder.append("`");
            stringBuilder.append("ssid:").append(c.a.l());
            stringBuilder.append("`");
            stringBuilder.append("bssid:").append(c.a.m());
            stringBuilder.append("`");
            stringBuilder.append("net_id:").append(c.a.n());
            stringBuilder.append("`");
            stringBuilder.append("client_identity:");
            treeMap2.put("client_info", stringBuilder.toString());
            treeMap2.putAll(treeMap);
            treeMap2.put("sign", b(treeMap2));
            byte[] bytes = c(treeMap2).getBytes();
            bVar.d = new String(bytes);
            c.write(bytes);
            aVar.e();
            bVar.a = aVar.f();
            bVar.b = aVar.g();
            InputStream d = aVar.d();
            StringBuilder stringBuilder2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder2.append(readLine);
            }
            bVar.c = stringBuilder2.toString();
        } catch (Throwable th) {
            bVar.a = -1;
            bVar.b = th.getMessage();
        }
        return bVar;
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(1000);
            int responseCode = httpURLConnection.getResponseCode();
            bVar.a = responseCode;
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                bVar.c = stringBuilder.toString();
            }
            return bVar;
        } catch (Exception e) {
            bVar.a = -1;
            bVar.b = e.getMessage();
            return bVar;
        }
    }
}
