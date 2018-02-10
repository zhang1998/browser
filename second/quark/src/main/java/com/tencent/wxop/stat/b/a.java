package com.tencent.wxop.stat.b;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public String a;
    public JSONArray b;
    public JSONObject c = null;

    public a(String str, Properties properties) {
        this.a = str;
        this.c = new JSONObject();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return toString().equals(((a) obj).toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.a).append(",");
        if (this.b != null) {
            stringBuilder.append(this.b.toString());
        }
        if (this.c != null) {
            stringBuilder.append(this.c.toString());
        }
        return stringBuilder.toString();
    }
}
