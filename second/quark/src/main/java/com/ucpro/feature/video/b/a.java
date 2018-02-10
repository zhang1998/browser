package com.ucpro.feature.video.b;

import com.uc.apollo.widget.VideoView;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public final class a {
    public static VideoView a(VideoView videoView) {
        if (videoView == null) {
            return null;
        }
        try {
            VideoView videoView2;
            Field declaredField = VideoView.class.getDeclaredField("mFullScreenVideoView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(videoView);
            if (obj == null || !(obj instanceof VideoView)) {
                videoView2 = null;
            } else {
                videoView2 = (VideoView) obj;
            }
            return videoView2;
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        }
    }
}
