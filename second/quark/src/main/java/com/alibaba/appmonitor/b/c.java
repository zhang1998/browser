package com.alibaba.appmonitor.b;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.uc.apollo.impl.SettingsConst;

@TableName("alarm_temp")
/* compiled from: ProGuard */
public class c extends b {
    @Column("err_code")
    public String a;
    @Column("err_msg")
    public String b;
    @Column("arg")
    public String h;
    @Column("success")
    public String i;

    public c(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        super(str, str2, str6, str7);
        this.h = str3;
        this.a = str4;
        this.b = str5;
        this.i = z ? SettingsConst.TRUE : SettingsConst.FALSE;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TempAlarm{");
        stringBuilder.append(" module='").append(this.c).append('\'');
        stringBuilder.append(", monitorPoint='").append(this.d).append('\'');
        stringBuilder.append(", commitTime=").append(this.e);
        stringBuilder.append(", access='").append(this.f).append('\'');
        stringBuilder.append(", accessSubType='").append(this.g).append('\'');
        stringBuilder.append(", arg='").append(this.h).append('\'');
        stringBuilder.append(", errCode='").append(this.a).append('\'');
        stringBuilder.append(", errMsg='").append(this.b).append('\'');
        stringBuilder.append(", success='").append(this.i).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
