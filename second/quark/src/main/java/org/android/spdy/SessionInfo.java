package org.android.spdy;

/* compiled from: ProGuard */
public class SessionInfo {
    private int connTimeoutMs = -1;
    private String domain;
    private String host;
    private int mode;
    private int port;
    private String proxyHost;
    private int proxyPort;
    private int pubkey_seqnum = 0;
    private SessionCb sessionCb;
    private Object sessionUserData;

    public SessionInfo(String str, int i, String str2, String str3, int i2, Object obj, SessionCb sessionCb, int i3) {
        this.host = str;
        this.port = i;
        this.domain = str2;
        this.proxyHost = str3;
        this.proxyPort = i2;
        this.sessionUserData = obj;
        this.sessionCb = sessionCb;
        this.mode = i3;
    }

    String getAuthority() {
        if (this.proxyHost == null || this.proxyPort == 0) {
            return this.host + ":" + this.port;
        }
        return this.host + ":" + this.port + "/" + this.proxyHost + ":" + this.proxyPort;
    }

    Object getSessonUserData() {
        return this.sessionUserData;
    }

    SessionCb getSessionCb() {
        return this.sessionCb;
    }

    int getMode() {
        return this.mode;
    }

    String getDomain() {
        return this.domain;
    }

    public void setConnectionTimeoutMs(int i) {
        this.connTimeoutMs = i;
    }

    int getConnectionTimeoutMs() {
        return this.connTimeoutMs;
    }

    public void setPubKeySeqNum(int i) {
        this.pubkey_seqnum = i;
    }

    int getPubKeySeqNum() {
        return this.pubkey_seqnum;
    }
}
