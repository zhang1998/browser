package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public final class SourceType {
    public static final int M3U8 = 1;
    public static final int M3U8_LIVE = 2;
    public static final int M3U8_LIVE_RN = 4;
    public static final int M3U8_RN = 3;
    public static final int MP4 = 5;
    public static final int UNKNOWN = 0;
    public static final int UNPARSE = -1;

    public static boolean isM3U8(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public static final String desc(int i) {
        switch (i) {
            case 1:
                return "m3u8";
            case 2:
                return "m3u8.live";
            case 3:
                return "m3u8.rn";
            case 4:
                return "m3u8.live.rn";
            case 5:
                return "mp4";
            default:
                return "unknown";
        }
    }

    public static String getFileExt(int i) {
        switch (i) {
            case -1:
                return "unparse";
            case 1:
            case 2:
            case 3:
            case 4:
                return "m3u8";
            case 5:
                return "mp4";
            default:
                return "unknown";
        }
    }
}
