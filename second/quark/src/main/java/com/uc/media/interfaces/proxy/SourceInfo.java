package com.uc.media.interfaces.proxy;

import com.uc.media.interfaces.Context;
import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public class SourceInfo implements Cloneable {
    public String id;
    public long keyDataPosition;
    public long length;
    Context m3u8;
    public String pageTitle;
    public String pageUrl;
    String proxyUrl;
    public int type;
    public String url;
    public String url302;
    public String userAgent;

    public Context getM3U8() {
        return this.m3u8;
    }

    public String proxyUrl() {
        return this.proxyUrl;
    }

    protected void clear() {
        this.url = null;
        this.url302 = null;
        this.userAgent = null;
        this.pageUrl = null;
        this.pageTitle = null;
        this.id = null;
        this.type = -1;
        this.length = Long.MAX_VALUE;
        this.keyDataPosition = -1;
    }

    public SourceInfo() {
        clear();
    }

    public SourceInfo(String str) {
        this();
        this.url = str;
    }

    public SourceInfo(SourceInfo sourceInfo) {
        this.url = sourceInfo.url;
        this.url302 = sourceInfo.url302;
        this.userAgent = sourceInfo.userAgent;
        this.pageUrl = sourceInfo.pageUrl;
        this.pageTitle = sourceInfo.pageTitle;
        this.id = sourceInfo.id;
        this.type = sourceInfo.type;
        this.length = sourceInfo.length;
        this.keyDataPosition = sourceInfo.keyDataPosition;
    }

    public SourceInfo clone() {
        return new SourceInfo(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append("[url: ").append(this.url).append("]");
        stringBuilder.append("[type: ").append(SourceType.getFileExt(this.type)).append("]");
        stringBuilder.append("[length: ").append(this.length == Long.MAX_VALUE ? "unknown" : String.valueOf(this.length)).append("]");
        stringBuilder.append("[keyDataPos: ").append(this.keyDataPosition).append("]");
        return stringBuilder.toString();
    }
}
