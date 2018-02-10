package com.loc;

import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.extension.UCCore;
import java.util.zip.CRC32;

/* compiled from: ProGuard */
public final class dc {
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public String F = null;
    public byte[] G = null;
    public String a = SettingsConst.TRUE;
    public short b = (short) 0;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x = null;
    public String y = null;
    public String z = null;

    private String a(String str, int i) {
        String[] split = this.B.split("\\*")[i].split(",");
        return str.equals("lac") ? split[0] : str.equals("cellid") ? split[1] : str.equals("signal") ? split[2] : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r8) {
        /*
        r7 = this;
        r6 = 2;
        r2 = 0;
        r5 = 6;
        r0 = ":";
        r0 = r8.split(r0);
        r1 = new byte[r5];
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r3 = r0.length;	 Catch:{ Throwable -> 0x0042 }
        if (r3 == r5) goto L_0x001d;
    L_0x0010:
        r0 = 6;
        r0 = new java.lang.String[r0];	 Catch:{ Throwable -> 0x0042 }
        r3 = r2;
    L_0x0014:
        if (r3 >= r5) goto L_0x001d;
    L_0x0016:
        r4 = "0";
        r0[r3] = r4;	 Catch:{ Throwable -> 0x0042 }
        r3 = r3 + 1;
        goto L_0x0014;
    L_0x001d:
        r3 = r0.length;	 Catch:{ Throwable -> 0x0042 }
        if (r2 >= r3) goto L_0x0040;
    L_0x0020:
        r3 = r0[r2];	 Catch:{ Throwable -> 0x0042 }
        r3 = r3.length();	 Catch:{ Throwable -> 0x0042 }
        if (r3 <= r6) goto L_0x0032;
    L_0x0028:
        r3 = r0[r2];	 Catch:{ Throwable -> 0x0042 }
        r4 = 0;
        r5 = 2;
        r3 = r3.substring(r4, r5);	 Catch:{ Throwable -> 0x0042 }
        r0[r2] = r3;	 Catch:{ Throwable -> 0x0042 }
    L_0x0032:
        r3 = r0[r2];	 Catch:{ Throwable -> 0x0042 }
        r4 = 16;
        r3 = java.lang.Integer.parseInt(r3, r4);	 Catch:{ Throwable -> 0x0042 }
        r3 = (byte) r3;	 Catch:{ Throwable -> 0x0042 }
        r1[r2] = r3;	 Catch:{ Throwable -> 0x0042 }
        r2 = r2 + 1;
        goto L_0x001d;
    L_0x0040:
        r0 = r1;
    L_0x0041:
        return r0;
    L_0x0042:
        r0 = move-exception;
        r1 = "Req";
        r2 = new java.lang.StringBuilder;
        r3 = "getMacBa ";
        r2.<init>(r3);
        r2 = r2.append(r8);
        r2 = r2.toString();
        com.loc.cq.a(r0, r1, r2);
        r0 = "00:00:00:00:00:00";
        r0 = r7.a(r0);
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.dc.a(java.lang.String):byte[]");
    }

    private String b(String str) {
        if (!this.A.contains(str + ">")) {
            return SettingsConst.FALSE;
        }
        int indexOf = this.A.indexOf(str + ">");
        return this.A.substring((indexOf + str.length()) + 1, this.A.indexOf("</" + str));
    }

    public final byte[] a() {
        Object bytes;
        Throwable th;
        Object d;
        int length;
        Object d2;
        int i;
        String[] split;
        String[] split2;
        CRC32 crc32;
        Object a;
        if (TextUtils.isEmpty(this.a)) {
            this.a = "";
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = "";
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = "";
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = "";
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = "";
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = "";
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = "";
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = "";
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = SettingsConst.FALSE;
        } else if (!(this.j.equals(SettingsConst.TRUE) || this.j.equals(Global.APOLLO_SERIES))) {
            this.j = SettingsConst.FALSE;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = SettingsConst.FALSE;
        } else if (!(this.k.equals(SettingsConst.FALSE) || this.k.equals(SettingsConst.TRUE))) {
            this.k = SettingsConst.FALSE;
        }
        if (TextUtils.isEmpty(this.l)) {
            this.l = "";
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = "";
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = "";
        }
        if (TextUtils.isEmpty(this.o)) {
            this.o = "";
        }
        if (TextUtils.isEmpty(this.p)) {
            this.p = "";
        }
        if (TextUtils.isEmpty(this.q)) {
            this.q = "";
        }
        if (TextUtils.isEmpty(this.r)) {
            this.r = "";
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = "";
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = "";
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = "";
        }
        if (TextUtils.isEmpty(this.v)) {
            this.v = "";
        }
        if (TextUtils.isEmpty(this.w)) {
            this.w = "";
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = "";
        }
        if (TextUtils.isEmpty(this.y)) {
            this.y = SettingsConst.FALSE;
        } else if (!(this.y.equals(SettingsConst.TRUE) || this.y.equals(Global.APOLLO_SERIES))) {
            this.y = SettingsConst.FALSE;
        }
        if (TextUtils.isEmpty(this.z)) {
            this.z = SettingsConst.FALSE;
        } else if (!(this.z.equals(SettingsConst.TRUE) || this.z.equals(Global.APOLLO_SERIES))) {
            this.z = SettingsConst.FALSE;
        }
        if (TextUtils.isEmpty(this.A)) {
            this.A = "";
        }
        if (TextUtils.isEmpty(this.B)) {
            this.B = "";
        }
        if (TextUtils.isEmpty(this.C)) {
            this.C = "";
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = "";
        }
        if (TextUtils.isEmpty(this.E)) {
            this.E = "";
        }
        if (TextUtils.isEmpty(this.F)) {
            this.F = "";
        }
        if (this.G == null) {
            this.G = new byte[0];
        }
        int i2 = 3072;
        if (this.G != null) {
            i2 = (this.G.length + 1) + 3072;
        }
        Object obj = new byte[i2];
        obj[0] = Byte.parseByte(this.a);
        System.arraycopy(dm.b(this.b), 0, obj, 1, 2);
        int i3 = 3;
        try {
            bytes = this.c.getBytes("GBK");
            obj[3] = (byte) bytes.length;
            try {
                System.arraycopy(bytes, 0, obj, 4, bytes.length);
                i3 = bytes.length + 4;
            } catch (Throwable th2) {
                th = th2;
                i3 = 4;
                cq.a(th, "Req", "buildV4Dot2");
                obj[i3] = null;
                i3++;
                bytes = this.d.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.o.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.e.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.f.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.g.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.u.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.h.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.p.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.q.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                if (TextUtils.isEmpty(this.t)) {
                    obj[i3] = (byte) 0;
                    i3++;
                } else {
                    bytes = a(this.t);
                    obj[i3] = (byte) bytes.length;
                    i3++;
                    System.arraycopy(bytes, 0, obj, i3, bytes.length);
                    i3 += bytes.length;
                }
                bytes = this.v.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.w.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = this.x.getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i2 = bytes.length + i3;
                obj[i2] = Byte.parseByte(this.y);
                i2++;
                obj[i2] = Byte.parseByte(this.j);
                i2++;
                obj[i2] = Byte.parseByte(this.z);
                i2++;
                if (!this.z.equals(SettingsConst.TRUE)) {
                    d = dm.d(b("mcc"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    d = dm.d(b("mnc"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    d = dm.d(b("lac"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    System.arraycopy(dm.e(b("cellid")), 0, obj, i2, 4);
                    i3 = i2 + 4;
                    i2 = Integer.parseInt(b("signal"));
                    if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                        i2 = 0;
                    }
                    obj[i3] = (byte) i2;
                    i2 = i3 + 1;
                    if (this.B.length() == 0) {
                        obj[i2] = null;
                        i2++;
                    } else {
                        length = this.B.split("\\*").length;
                        obj[i2] = (byte) length;
                        i2++;
                        i3 = 0;
                        while (i3 < length) {
                            d2 = dm.d(a("lac", i3));
                            System.arraycopy(d2, 0, obj, i2, d2.length);
                            i2 += d2.length;
                            System.arraycopy(dm.e(a("cellid", i3)), 0, obj, i2, 4);
                            i = i2 + 4;
                            i2 = Integer.parseInt(a("signal", i3));
                            if (i2 <= UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                                i2 = 0;
                            }
                            obj[i] = (byte) i2;
                            i3++;
                            i2 = i + 1;
                        }
                    }
                } else if (this.z.equals(Global.APOLLO_SERIES)) {
                    d = dm.d(b("mcc"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    d = dm.d(b("sid"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    d = dm.d(b("nid"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    d = dm.d(b("bid"));
                    System.arraycopy(d, 0, obj, i2, d.length);
                    i2 += d.length;
                    System.arraycopy(dm.e(b("lon")), 0, obj, i2, 4);
                    i2 += 4;
                    System.arraycopy(dm.e(b("lat")), 0, obj, i2, 4);
                    i3 = i2 + 4;
                    i2 = Integer.parseInt(b("signal"));
                    if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                        i2 = 0;
                    }
                    obj[i3] = (byte) i2;
                    i2 = i3 + 1;
                    obj[i2] = null;
                    i2++;
                }
                if (this.C.length() == 0) {
                    obj[i2] = null;
                    i2++;
                } else {
                    obj[i2] = 1;
                    i3 = i2 + 1;
                    try {
                        split = this.C.split(",");
                        bytes = a(split[0]);
                        System.arraycopy(bytes, 0, obj, i3, bytes.length);
                        i3 += bytes.length;
                        bytes = split[2].getBytes("GBK");
                        obj[i3] = (byte) bytes.length;
                        i3++;
                        System.arraycopy(bytes, 0, obj, i3, bytes.length);
                        i3 += bytes.length;
                    } catch (Throwable th3) {
                        cq.a(th3, "Req", "buildV4Dot216");
                        bytes = a("00:00:00:00:00:00");
                        System.arraycopy(bytes, 0, obj, i3, bytes.length);
                        i2 = bytes.length + i3;
                        obj[i2] = null;
                        i2++;
                        obj[i2] = Byte.parseByte(SettingsConst.FALSE);
                        i2++;
                    }
                    i2 = Integer.parseInt(split[1]);
                    if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                        i2 = 0;
                    }
                    obj[i3] = Byte.parseByte(String.valueOf(i2));
                    i2 = i3 + 1;
                }
                split2 = this.D.split("\\*");
                if (!TextUtils.isEmpty(this.D)) {
                }
                obj[i2] = null;
                i3 = i2 + 1;
                bytes = this.F.getBytes("GBK");
                if (bytes.length > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    bytes = null;
                }
                if (bytes == null) {
                    obj[i3] = (byte) 0;
                    i2 = i3 + 1;
                } else {
                    obj[i3] = (byte) bytes.length;
                    i3++;
                    System.arraycopy(bytes, 0, obj, i3, bytes.length);
                    i2 = bytes.length + i3;
                }
                i3 = this.G != null ? this.G.length : 0;
                System.arraycopy(dm.b(i3), 0, obj, i2, 2);
                i2 += 2;
                if (i3 > 0) {
                    System.arraycopy(this.G, 0, obj, i2, this.G.length);
                    i2 += this.G.length;
                }
                d = new byte[i2];
                System.arraycopy(obj, 0, d, 0, i2);
                crc32 = new CRC32();
                crc32.update(d);
                a = dm.a(crc32.getValue());
                d2 = new byte[(i2 + 8)];
                System.arraycopy(d, 0, d2, 0, i2);
                System.arraycopy(a, 0, d2, i2, 8);
                return d2;
            }
        } catch (Throwable th4) {
            th3 = th4;
            cq.a(th3, "Req", "buildV4Dot2");
            obj[i3] = null;
            i3++;
            bytes = this.d.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.o.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.e.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.f.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.g.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.u.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.h.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.p.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.q.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            if (TextUtils.isEmpty(this.t)) {
                bytes = a(this.t);
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
            } else {
                obj[i3] = (byte) 0;
                i3++;
            }
            bytes = this.v.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.w.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = this.x.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i2 = bytes.length + i3;
            obj[i2] = Byte.parseByte(this.y);
            i2++;
            obj[i2] = Byte.parseByte(this.j);
            i2++;
            obj[i2] = Byte.parseByte(this.z);
            i2++;
            if (!this.z.equals(SettingsConst.TRUE)) {
                d = dm.d(b("mcc"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                d = dm.d(b("mnc"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                d = dm.d(b("lac"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                System.arraycopy(dm.e(b("cellid")), 0, obj, i2, 4);
                i3 = i2 + 4;
                i2 = Integer.parseInt(b("signal"));
                if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    i2 = 0;
                }
                obj[i3] = (byte) i2;
                i2 = i3 + 1;
                if (this.B.length() == 0) {
                    length = this.B.split("\\*").length;
                    obj[i2] = (byte) length;
                    i2++;
                    i3 = 0;
                    while (i3 < length) {
                        d2 = dm.d(a("lac", i3));
                        System.arraycopy(d2, 0, obj, i2, d2.length);
                        i2 += d2.length;
                        System.arraycopy(dm.e(a("cellid", i3)), 0, obj, i2, 4);
                        i = i2 + 4;
                        i2 = Integer.parseInt(a("signal", i3));
                        if (i2 <= UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                            i2 = 0;
                        }
                        obj[i] = (byte) i2;
                        i3++;
                        i2 = i + 1;
                    }
                } else {
                    obj[i2] = null;
                    i2++;
                }
            } else if (this.z.equals(Global.APOLLO_SERIES)) {
                d = dm.d(b("mcc"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                d = dm.d(b("sid"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                d = dm.d(b("nid"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                d = dm.d(b("bid"));
                System.arraycopy(d, 0, obj, i2, d.length);
                i2 += d.length;
                System.arraycopy(dm.e(b("lon")), 0, obj, i2, 4);
                i2 += 4;
                System.arraycopy(dm.e(b("lat")), 0, obj, i2, 4);
                i3 = i2 + 4;
                i2 = Integer.parseInt(b("signal"));
                if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    i2 = 0;
                }
                obj[i3] = (byte) i2;
                i2 = i3 + 1;
                obj[i2] = null;
                i2++;
            }
            if (this.C.length() == 0) {
                obj[i2] = 1;
                i3 = i2 + 1;
                split = this.C.split(",");
                bytes = a(split[0]);
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                bytes = split[2].getBytes("GBK");
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
                i2 = Integer.parseInt(split[1]);
                if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    i2 = 0;
                }
                obj[i3] = Byte.parseByte(String.valueOf(i2));
                i2 = i3 + 1;
            } else {
                obj[i2] = null;
                i2++;
            }
            split2 = this.D.split("\\*");
            if (TextUtils.isEmpty(this.D)) {
            }
            obj[i2] = null;
            i3 = i2 + 1;
            bytes = this.F.getBytes("GBK");
            if (bytes.length > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                bytes = null;
            }
            if (bytes == null) {
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i2 = bytes.length + i3;
            } else {
                obj[i3] = (byte) 0;
                i2 = i3 + 1;
            }
            if (this.G != null) {
            }
            System.arraycopy(dm.b(i3), 0, obj, i2, 2);
            i2 += 2;
            if (i3 > 0) {
                System.arraycopy(this.G, 0, obj, i2, this.G.length);
                i2 += this.G.length;
            }
            d = new byte[i2];
            System.arraycopy(obj, 0, d, 0, i2);
            crc32 = new CRC32();
            crc32.update(d);
            a = dm.a(crc32.getValue());
            d2 = new byte[(i2 + 8)];
            System.arraycopy(d, 0, d2, 0, i2);
            System.arraycopy(a, 0, d2, i2, 8);
            return d2;
        }
        try {
            bytes = this.d.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th32) {
            cq.a(th32, "Req", "buildV4Dot21");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.o.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th322) {
            cq.a(th322, "Req", "buildV4Dot22");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.e.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th3222) {
            cq.a(th3222, "Req", "buildV4Dot23");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.f.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th32222) {
            cq.a(th32222, "Req", "buildV4Dot24");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.g.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th322222) {
            cq.a(th322222, "Req", "buildV4Dot25");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.u.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th3222222) {
            cq.a(th3222222, "Req", "buildV4Dot26");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.h.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th32222222) {
            cq.a(th32222222, "Req", "buildV4Dot27");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.p.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th322222222) {
            cq.a(th322222222, "Req", "buildV4Dot28");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.q.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th3222222222) {
            cq.a(th3222222222, "Req", "buildV4Dot29");
            obj[i3] = null;
            i3++;
        }
        try {
            if (TextUtils.isEmpty(this.t)) {
                obj[i3] = (byte) 0;
                i3++;
            } else {
                bytes = a(this.t);
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i3 += bytes.length;
            }
        } catch (Throwable th32222222222) {
            cq.a(th32222222222, "Req", "buildV4Dot219");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.v.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th322222222222) {
            cq.a(th322222222222, "Req", "buildV4Dot211");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.w.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
        } catch (Throwable th3222222222222) {
            cq.a(th3222222222222, "Req", "buildV4Dot212");
            obj[i3] = null;
            i3++;
        }
        try {
            bytes = this.x.getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i2 = bytes.length + i3;
        } catch (Throwable th32222222222222) {
            cq.a(th32222222222222, "Req", "buildV4Dot213");
            obj[i3] = null;
            i2 = i3 + 1;
        }
        obj[i2] = Byte.parseByte(this.y);
        i2++;
        obj[i2] = Byte.parseByte(this.j);
        i2++;
        obj[i2] = Byte.parseByte(this.z);
        i2++;
        if (!this.z.equals(SettingsConst.TRUE)) {
            d = dm.d(b("mcc"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            d = dm.d(b("mnc"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            d = dm.d(b("lac"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            System.arraycopy(dm.e(b("cellid")), 0, obj, i2, 4);
            i3 = i2 + 4;
            i2 = Integer.parseInt(b("signal"));
            if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                i2 = 0;
            }
            obj[i3] = (byte) i2;
            i2 = i3 + 1;
            if (this.B.length() == 0) {
                obj[i2] = null;
                i2++;
            } else {
                length = this.B.split("\\*").length;
                obj[i2] = (byte) length;
                i2++;
                i3 = 0;
                while (i3 < length) {
                    d2 = dm.d(a("lac", i3));
                    System.arraycopy(d2, 0, obj, i2, d2.length);
                    i2 += d2.length;
                    System.arraycopy(dm.e(a("cellid", i3)), 0, obj, i2, 4);
                    i = i2 + 4;
                    i2 = Integer.parseInt(a("signal", i3));
                    if (i2 <= UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                        i2 = 0;
                    }
                    obj[i] = (byte) i2;
                    i3++;
                    i2 = i + 1;
                }
            }
        } else if (this.z.equals(Global.APOLLO_SERIES)) {
            d = dm.d(b("mcc"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            d = dm.d(b("sid"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            d = dm.d(b("nid"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            d = dm.d(b("bid"));
            System.arraycopy(d, 0, obj, i2, d.length);
            i2 += d.length;
            System.arraycopy(dm.e(b("lon")), 0, obj, i2, 4);
            i2 += 4;
            System.arraycopy(dm.e(b("lat")), 0, obj, i2, 4);
            i3 = i2 + 4;
            i2 = Integer.parseInt(b("signal"));
            if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                i2 = 0;
            }
            obj[i3] = (byte) i2;
            i2 = i3 + 1;
            obj[i2] = null;
            i2++;
        }
        if (this.C.length() == 0) {
            obj[i2] = null;
            i2++;
        } else {
            obj[i2] = 1;
            i3 = i2 + 1;
            split = this.C.split(",");
            bytes = a(split[0]);
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            bytes = split[2].getBytes("GBK");
            obj[i3] = (byte) bytes.length;
            i3++;
            System.arraycopy(bytes, 0, obj, i3, bytes.length);
            i3 += bytes.length;
            i2 = Integer.parseInt(split[1]);
            if (i2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                i2 = 0;
            }
            obj[i3] = Byte.parseByte(String.valueOf(i2));
            i2 = i3 + 1;
        }
        split2 = this.D.split("\\*");
        if (TextUtils.isEmpty(this.D) || split2.length == 0) {
            obj[i2] = null;
            i3 = i2 + 1;
        } else {
            obj[i2] = (byte) split2.length;
            i3 = i2 + 1;
            for (String split3 : split2) {
                String[] split4 = split3.split(",");
                try {
                    a = a(split4[0]);
                } catch (Throwable th5) {
                    cq.a(th5, "Req", "buildV4Dot2110");
                    a = a("00:00:00:00:00:00");
                }
                System.arraycopy(a, 0, obj, i3, a.length);
                int length2 = a.length + i3;
                try {
                    d = split4[2].getBytes("GBK");
                    obj[length2] = (byte) d.length;
                    length2++;
                    System.arraycopy(d, 0, obj, length2, d.length);
                    i3 = d.length + length2;
                } catch (Throwable th6) {
                    cq.a(th6, "Req", "buildV4Dot217");
                    obj[length2] = null;
                    i3 = length2 + 1;
                }
                length2 = Integer.parseInt(split4[1]);
                if (length2 > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                    length2 = 0;
                }
                obj[i3] = Byte.parseByte(String.valueOf(length2));
                i3++;
            }
            System.arraycopy(dm.b(Integer.parseInt(this.E)), 0, obj, i3, 2);
            i3 += 2;
        }
        try {
            bytes = this.F.getBytes("GBK");
            if (bytes.length > UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) {
                bytes = null;
            }
            if (bytes == null) {
                obj[i3] = (byte) 0;
                i2 = i3 + 1;
            } else {
                obj[i3] = (byte) bytes.length;
                i3++;
                System.arraycopy(bytes, 0, obj, i3, bytes.length);
                i2 = bytes.length + i3;
            }
        } catch (Throwable th322222222222222) {
            cq.a(th322222222222222, "Req", "buildV4Dot218");
            obj[i3] = null;
            i2 = i3 + 1;
        }
        if (this.G != null) {
        }
        System.arraycopy(dm.b(i3), 0, obj, i2, 2);
        i2 += 2;
        if (i3 > 0) {
            System.arraycopy(this.G, 0, obj, i2, this.G.length);
            i2 += this.G.length;
        }
        d = new byte[i2];
        System.arraycopy(obj, 0, d, 0, i2);
        crc32 = new CRC32();
        crc32.update(d);
        a = dm.a(crc32.getValue());
        d2 = new byte[(i2 + 8)];
        System.arraycopy(d, 0, d2, 0, i2);
        System.arraycopy(a, 0, d2, i2, 8);
        return d2;
    }
}
