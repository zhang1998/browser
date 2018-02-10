package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener an;
    private String aq;
    private int aw;
    private String url;

    final class a {
        public OAuthErrCode ap;
        public String ax;
        public int ay;

        a() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.sdk.diffdev.a.f.a e(byte[] r8) {
            /*
            r7 = 1;
            r6 = 0;
            r0 = new com.tencent.mm.sdk.diffdev.a.f$a;
            r0.<init>();
            if (r8 == 0) goto L_0x000c;
        L_0x0009:
            r1 = r8.length;
            if (r1 != 0) goto L_0x0018;
        L_0x000c:
            r1 = "MicroMsg.SDK.NoopingResult";
            r2 = "parse fail, buf is null";
            android.util.Log.e(r1, r2);
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            r0.ap = r1;
        L_0x0017:
            return r0;
        L_0x0018:
            r1 = new java.lang.String;	 Catch:{ Exception -> 0x0060 }
            r2 = "utf-8";
            r1.<init>(r8, r2);	 Catch:{ Exception -> 0x0060 }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0047 }
            r2.<init>(r1);	 Catch:{ Exception -> 0x0047 }
            r1 = "wx_errcode";
            r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0047 }
            r0.ay = r1;	 Catch:{ Exception -> 0x0047 }
            r1 = "nooping uuidStatusCode = %d";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0047 }
            r4 = 0;
            r5 = r0.ay;	 Catch:{ Exception -> 0x0047 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0047 }
            r3[r4] = r5;	 Catch:{ Exception -> 0x0047 }
            java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0047 }
            r1 = r0.ay;	 Catch:{ Exception -> 0x0047 }
            switch(r1) {
                case 402: goto L_0x0090;
                case 403: goto L_0x0095;
                case 404: goto L_0x0086;
                case 405: goto L_0x0079;
                case 408: goto L_0x008b;
                case 500: goto L_0x009b;
                default: goto L_0x0042;
            };	 Catch:{ Exception -> 0x0047 }
        L_0x0042:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
        L_0x0047:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse json fail, ex = %s";
            r4 = new java.lang.Object[r7];
            r1 = r1.getMessage();
            r4[r6] = r1;
            r1 = java.lang.String.format(r3, r4);
            android.util.Log.e(r2, r1);
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.ap = r1;
            goto L_0x0017;
        L_0x0060:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse fail, build String fail, ex = %s";
            r4 = new java.lang.Object[r7];
            r1 = r1.getMessage();
            r4[r6] = r1;
            r1 = java.lang.String.format(r3, r4);
            android.util.Log.e(r2, r1);
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.ap = r1;
            goto L_0x0017;
        L_0x0079:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            r1 = "wx_code";
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0047 }
            r0.ax = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
        L_0x0086:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
        L_0x008b:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
        L_0x0090:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
        L_0x0095:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
        L_0x009b:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0047 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0047 }
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.diffdev.a.f.a.e(byte[]):com.tencent.mm.sdk.diffdev.a.f$a");
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.aq = str;
        this.an = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (this.aq == null || this.aq.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            a aVar = new a();
            aVar.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.aw == 0 ? "" : "&last=" + this.aw);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] b = e.b(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar = a.e(b);
            String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, aVar.ap.toString(), Integer.valueOf(aVar.ay), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            if (aVar.ap == OAuthErrCode.WechatAuth_Err_OK) {
                this.aw = aVar.ay;
                if (aVar.ay == g.UUID_SCANED.getCode()) {
                    this.an.onQrcodeScanned();
                } else if (aVar.ay != g.UUID_KEEP_CONNECT.getCode() && aVar.ay == g.UUID_CONFIRM.getCode()) {
                    if (aVar.ax != null && aVar.ax.length() != 0) {
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    aVar.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{aVar.ap.toString(), Integer.valueOf(aVar.ay)}));
            return aVar;
        }
        aVar = new a();
        aVar.ap = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return aVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.an.onAuthFinish(aVar.ap, aVar.ax);
    }
}
