package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.a.a.b;
import com.uc.webview.browser.interfaces.SettingKeys;
import java.io.File;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class bd {
    private final byte[] a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private final int b = 1;
    private final int c = 0;
    private String d = "1.0";
    private String e = null;
    private byte[] f = null;
    private byte[] g = null;
    private byte[] h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private byte[] l = null;
    private byte[] m = null;
    private boolean n = false;

    private bd(byte[] bArr, String str, byte[] bArr2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.e = str;
        this.k = bArr.length;
        this.l = fh.a(bArr);
        this.j = (int) (System.currentTimeMillis() / 1000);
        this.m = bArr2;
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("signature", null);
    }

    private void a(String str) {
        this.f = fg.a(str);
    }

    public static bd a(Context context, String str, byte[] bArr) {
        try {
            String m = ey.m(context);
            String c = ey.c(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
            String string = sharedPreferences.getString("signature", null);
            int i = sharedPreferences.getInt("serial", 1);
            bd bdVar = new bd(bArr, str, (c + m).getBytes());
            bdVar.a(string);
            bdVar.i = i;
            bdVar.b();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", fg.a(bdVar.f)).commit();
            bdVar.b(context);
            return bdVar;
        } catch (Exception e) {
            return null;
        }
    }

    public static bd b(Context context, String str, byte[] bArr) {
        try {
            String m = ey.m(context);
            String c = ey.c(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
            String string = sharedPreferences.getString("signature", null);
            int i = sharedPreferences.getInt("serial", 1);
            bd bdVar = new bd(bArr, str, (c + m).getBytes());
            bdVar.n = true;
            bdVar.a(string);
            bdVar.i = i;
            bdVar.b();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", fg.a(bdVar.f)).commit();
            bdVar.b(context);
            return bdVar;
        } catch (Exception e) {
            return null;
        }
    }

    private void b() {
        if (this.f == null) {
            this.f = a(this.a, (int) (System.currentTimeMillis() / 1000));
        }
        if (this.n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f, 1, bArr, 0, 16);
                this.l = fg.a(this.l, bArr);
            } catch (Exception e) {
            }
        }
        this.g = a(this.f, this.j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fg.a(this.f));
        stringBuilder.append(this.i);
        stringBuilder.append(this.j);
        stringBuilder.append(this.k);
        stringBuilder.append(fg.a(this.g));
        this.h = fg.b(stringBuilder.toString().getBytes());
    }

    private byte[] a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        byte[] b = fg.b(this.m);
        byte[] b2 = fg.b(this.l);
        int length = b.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (i2 = 0; i2 < length; i2++) {
            bArr2[i2 * 2] = b2[i2];
            bArr2[(i2 * 2) + 1] = b[i2];
        }
        for (i2 = 0; i2 < 2; i2++) {
            bArr2[i2] = bArr[i2];
            bArr2[(bArr2.length - i2) - 1] = bArr[(bArr.length - i2) - 1];
        }
        byte[] bArr3 = new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        while (i3 < bArr2.length) {
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr3[i3 % 4]);
            i3++;
        }
        return bArr2;
    }

    public final byte[] a() {
        int i;
        byte[] bArr = null;
        c bnVar = new bn();
        bnVar.a = this.d;
        bnVar.b = this.e;
        bnVar.c = fg.a(this.f);
        bnVar.d = this.i;
        bnVar.a();
        bnVar.e = this.j;
        bnVar.b();
        bnVar.f = this.k;
        bnVar.c();
        byte[] bArr2 = this.l;
        bnVar.g = bArr2 == null ? bArr : ByteBuffer.wrap(bArr2);
        if (this.n) {
            i = 1;
        } else {
            i = 0;
        }
        bnVar.j = i;
        bnVar.e();
        bnVar.h = fg.a(this.g);
        bnVar.i = fg.a(this.h);
        try {
            bArr = new e().a(bnVar);
        } catch (Exception e) {
        }
        return bArr;
    }

    private void b(Context context) {
        String str = this.e;
        String str2 = bb.a(context).c.d;
        String a = fg.a(this.f);
        byte[] bArr = new byte[16];
        System.arraycopy(this.f, 2, bArr, 0, 16);
        String a2 = fg.a(fg.b(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (str2 != null) {
                jSONObject.put(SettingKeys.UserMachineID, str2);
            }
            jSONObject.put("signature", a);
            jSONObject.put("checksum", a2);
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            fu.a(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", str);
            jSONObject2.put("channel", b.b(context));
            if (str2 != null) {
                jSONObject2.put(SettingKeys.UserMachineID, fu.b(str2));
            }
            fu.a(new File(context.getFilesDir(), "exid.dat"), jSONObject2.toString());
        } catch (Throwable th2) {
        }
    }

    public final String toString() {
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("version : %s\n", new Object[]{this.d}));
        stringBuilder.append(String.format("address : %s\n", new Object[]{this.e}));
        stringBuilder.append(String.format("signature : %s\n", new Object[]{fg.a(this.f)}));
        stringBuilder.append(String.format("serial : %s\n", new Object[]{Integer.valueOf(this.i)}));
        stringBuilder.append(String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.j)}));
        stringBuilder.append(String.format("length : %d\n", new Object[]{Integer.valueOf(this.k)}));
        stringBuilder.append(String.format("guid : %s\n", new Object[]{fg.a(this.g)}));
        stringBuilder.append(String.format("checksum : %s ", new Object[]{fg.a(this.h)}));
        String str = "codex : %d";
        Object[] objArr = new Object[1];
        if (!this.n) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
