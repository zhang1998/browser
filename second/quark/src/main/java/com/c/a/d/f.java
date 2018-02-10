package com.c.a.d;

import android.util.Base64;

/* compiled from: ProGuard */
public final class f {
    private static String a = "I2V4dGVuc2lvbiBHTF9PRVNfRUdMX2ltYWdlX2V4dGVybmFsIDogcmVxdWlyZQ0KcHJlY2lzaW9uIG1lZGl1bXAgZmxvYXQ7DQpwcmVjaXNpb24gaGlnaHAgc2FtcGxlckV4dGVybmFsT0VTOw0KdW5pZm9ybSBzYW1wbGVyRXh0ZXJuYWxPRVMgdV9UZXh0dXJlOw0KdmFyeWluZyB2ZWMyIHZfVGV4Q29vcmRpbmF0ZTsNCnZvaWQgbWFpbigpDQp7DQogICAgLy8gZ2xfRnJhZ0NvbG9yID0gIHZlYzQodl9UZXhDb29yZGluYXRlLCAwLjAsIDEuMCk7DQogICAgZ2xfRnJhZ0NvbG9yID0gIHRleHR1cmUyRCh1X1RleHR1cmUsIHZfVGV4Q29vcmRpbmF0ZSk7DQp9";
    private static String b = "cHJlY2lzaW9uIG1lZGl1bXAgZmxvYXQ7Cgp1bmlmb3JtIHNhbXBsZXIyRCB1X1RleHR1cmU7CiAgCnZhcnlpbmcgdmVjMiB2X1RleENvb3JkaW5hdGU7Cgp2b2lkIG1haW4oKSAgICAgICAgICAgICAgICAgICAgCQkKeyAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgZ2xfRnJhZ0NvbG9yID0gIHRleHR1cmUyRCh1X1RleHR1cmUsIHZfVGV4Q29vcmRpbmF0ZSk7Cn0gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAJCg==";
    private static String c = "dW5pZm9ybSBtYXQ0IHVfTVZQTWF0cml4Ow0KdW5pZm9ybSBtYXQ0IG1haW5UZXh0dXJlVHJhbnNmb3JtOw0KYXR0cmlidXRlIHZlYzQgYV9Qb3NpdGlvbjsNCmF0dHJpYnV0ZSB2ZWMyIGFfVGV4Q29vcmRpbmF0ZTsNCnZhcnlpbmcgdmVjMiB2X1RleENvb3JkaW5hdGU7DQp2b2lkIG1haW4oKQ0Kew0KICAgIHZlYzQgdG1wID0gdmVjNChhX1RleENvb3JkaW5hdGUueCwgMS4wIC0gYV9UZXhDb29yZGluYXRlLnksIDAuMCwgMS4wKTsNCiAgICB2X1RleENvb3JkaW5hdGUgPSAobWFpblRleHR1cmVUcmFuc2Zvcm0gKiB0bXApLnh5Ow0KICAgIGdsX1Bvc2l0aW9uID0gdV9NVlBNYXRyaXggKiBhX1Bvc2l0aW9uOw0KfQ==";
    private static String d = "dW5pZm9ybSBtYXQ0IHVfTVZQTWF0cml4Ow0KYXR0cmlidXRlIHZlYzQgYV9Qb3NpdGlvbjsNCmF0dHJpYnV0ZSB2ZWMyIGFfVGV4Q29vcmRpbmF0ZTsNCnZhcnlpbmcgdmVjMiB2X1RleENvb3JkaW5hdGU7DQp2b2lkIG1haW4oKQ0Kew0KICAgIHZfVGV4Q29vcmRpbmF0ZSA9IGFfVGV4Q29vcmRpbmF0ZTsNCiAgICBnbF9Qb3NpdGlvbiA9IHVfTVZQTWF0cml4ICogYV9Qb3NpdGlvbjsNCn0=";

    private static String a() {
        return new String(Base64.decode(a, 0));
    }

    public static String a(int i) {
        switch (i) {
            case 0:
                return new String(Base64.decode(c, 0));
            case 1:
                return a();
            case 2:
                return a();
            case 3:
                return new String(Base64.decode(d, 0));
            default:
                throw new RuntimeException("undefined type");
        }
    }
}
