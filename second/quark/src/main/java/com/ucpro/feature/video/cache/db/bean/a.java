package com.ucpro.feature.video.cache.db.bean;

/* compiled from: ProGuard */
public class a {
    public Long a;
    public Long b;
    public String c;
    public String d;
    public Integer e;
    public String f;

    public a(Long l, Long l2, String str, String str2, Integer num, String str3) {
        this.a = l;
        this.b = l2;
        this.c = str;
        this.d = str2;
        this.e = num;
        this.f = str3;
    }

    public final int a() {
        return this.e == null ? 0 : this.e.intValue();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("M3u8TsSubTask{");
        stringBuffer.append("tsDownloadId=").append(this.a);
        stringBuffer.append(", videoCacheTaskId=").append(this.b);
        stringBuffer.append(", tsTaskUrl='").append(this.c).append('\'');
        stringBuffer.append(", tsTaskPath='").append(this.d).append('\'');
        stringBuffer.append(", tsTaskStatus=").append(this.e);
        stringBuffer.append(", tsTaskErrorMsg='").append(this.f).append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
