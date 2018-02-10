package com.ucpro.feature.video.player;

import com.uc.apollo.widget.MediaController;
import com.uc.apollo.widget.MediaController.MediaControllerFactory;
import com.uc.apollo.widget.VideoView;
import com.ucpro.feature.video.b.a;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class k implements MediaControllerFactory {
    MediaController a;
    private HashMap<VideoView, MediaController> b;

    private k() {
        this.b = new HashMap();
    }

    public static k a() {
        return o.a;
    }

    public final MediaController getMediaController(VideoView videoView) {
        if (this.a != null) {
            this.b.put(videoView, this.a);
            this.a = null;
        }
        MediaController mediaController = (MediaController) this.b.get(videoView);
        if (mediaController != null) {
            return mediaController;
        }
        for (VideoView videoView2 : this.b.keySet()) {
            VideoView a = a.a(videoView2);
            if (a != null && a == videoView) {
                return (MediaController) this.b.get(videoView2);
            }
        }
        return mediaController;
    }

    public final void recycleMediaController(VideoView videoView) {
        this.b.remove(videoView);
    }
}
