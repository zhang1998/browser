package com.a.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class cn implements Serializable {
    List<String> a = new ArrayList();
    List<String> b = new ArrayList();
    long c = 0;
    long d = 0;
    long e = 0;
    String f = null;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[key: ").append(this.a).append("] [label: ").append(this.b).append("][ totalTimeStamp").append(this.f).append("][ value").append(this.d).append("][ count").append(this.e).append("][ timeWindowNum").append(this.f).append("]");
        return stringBuffer.toString();
    }
}
