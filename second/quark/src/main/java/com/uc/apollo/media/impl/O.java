package com.uc.apollo.media.impl;

/* compiled from: ProGuard */
public enum O {
    PARSE_FAILURE(-4),
    UNSUPPORT(-3),
    PARSING(-2),
    UNPARSE(-1),
    UNKNOWN(0),
    MP4(1),
    M3U8(2),
    M3U8_LIVE(3);
    
    public final int i;

    public static O[] a() {
        return (O[]) j.clone();
    }

    private O(int i) {
        this.i = i;
    }

    public static boolean a(O o) {
        return o == M3U8 || o == M3U8_LIVE;
    }

    public static boolean b(O o) {
        return o == M3U8_LIVE;
    }

    public static O a(int i) {
        switch (i) {
            case -4:
                return PARSE_FAILURE;
            case -3:
                return UNSUPPORT;
            case -2:
                return PARSING;
            case -1:
                return UNPARSE;
            case 0:
                return UNKNOWN;
            case 1:
                return MP4;
            case 2:
                return M3U8;
            case 3:
                return M3U8_LIVE;
            default:
                return UNKNOWN;
        }
    }

    public final String toString() {
        switch (this) {
            case UNKNOWN:
                return "unknown";
            case MP4:
                return "mp4";
            case M3U8:
                return "m3u8";
            case M3U8_LIVE:
                return "m3u8 live";
            case UNSUPPORT:
                return "unsupport";
            case PARSE_FAILURE:
                return "parse failure";
            case PARSING:
                return "parsing";
            default:
                return "unparse";
        }
    }
}
