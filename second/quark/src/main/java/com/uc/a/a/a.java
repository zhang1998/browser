package com.uc.a.a;

import android.text.TextUtils;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a {
    public b a;

    public a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = new b();
            b bVar = this.a;
            if (!TextUtils.isEmpty(str)) {
                bVar.a = str;
            }
        }
    }

    public final void a(Object obj) {
        if (this.a != null) {
            b bVar = this.a;
            if (obj instanceof String) {
                bVar.a((String) obj);
            } else if (obj instanceof HashMap) {
                HashMap hashMap = (HashMap) obj;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("map data, size=");
                if (hashMap == null || hashMap.isEmpty()) {
                    stringBuilder.append("0, content: (empty)");
                } else {
                    stringBuilder.append(hashMap.size() + ", content: ");
                    for (Entry entry : hashMap.entrySet()) {
                        stringBuilder.append(((String) entry.getKey()) + ":" + ((String) entry.getValue()));
                        stringBuilder.append(", ");
                    }
                }
                bVar.a(stringBuilder.toString());
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                r0 = new StringBuilder();
                r0.append("byte[] data, len=");
                if (bArr == null || bArr.length <= 0) {
                    r0.append("0 bytes, content: (emtpy)");
                } else {
                    r0.append(bArr.length + " bytes, content: ");
                    r0.append(Base64.encodeToString(bArr, 0));
                }
                bVar.a(r0.toString());
            } else {
                r0 = new StringBuilder("not supported type data:");
                if (obj == null) {
                    obj = "";
                }
                bVar.a(r0.append(obj).toString());
            }
        }
    }
}
