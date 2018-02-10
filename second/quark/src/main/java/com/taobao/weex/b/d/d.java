package com.taobao.weex.b.d;

import com.uc.apollo.widget.VideoView;

/* compiled from: ProGuard */
public enum d {
    CLOSE_NORMAL(1000),
    CLOSE_GOING_AWAY(1001),
    CLOSE_PROTOCOL_ERROR(1002),
    CLOSE_UNSUPPORTED(1003),
    CLOSE_NO_STATUS(1005),
    CLOSE_ABNORMAL(1006),
    UNSUPPORTED_DATA(1007),
    POLICY_VIOLATION(1008),
    CLOSE_TOO_LARGE(1009),
    MISSING_EXTENSION(1010),
    INTERNAL_ERROR(1011),
    SERVICE_RESTART(1012),
    TRY_AGAIN_LATER(VideoView.VIDEO_INFO_ON_SET_TITLE),
    TLS_HANDSHAKE(VideoView.VIDEO_INFO_ON_STOP_PLAYBACK);
    
    int o;

    private d(int i) {
        this.o = i;
    }
}
