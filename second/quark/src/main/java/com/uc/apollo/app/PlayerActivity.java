package com.uc.apollo.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import com.uc.apollo.android.GuideDialog;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.media.base.g;
import com.uc.apollo.media.widget.a;
import com.uc.apollo.util.f;
import com.uc.apollo.widget.VideoView;

@KeepForRuntime
/* compiled from: ProGuard */
public class PlayerActivity extends Activity {
    private static final String TAG = "ucmedia.PlayerActivity";
    private a mFullScreenExecutor = new a(this);
    private VideoView mVideoView;

    private void destroyVideoView() {
        if (this.mVideoView != null) {
            this.mVideoView.getListener().onEnterFullScreen(false);
            this.mVideoView.stopPlayback();
            this.mVideoView.destroy();
            this.mVideoView = null;
        }
    }

    private void exit() {
        destroyVideoView();
        new Handler().post(new b(this));
    }

    protected void onDestroy() {
        destroyVideoView();
        super.onDestroy();
    }

    protected void onPause() {
        if (this.mVideoView != null) {
            this.mVideoView.getController().pause();
        }
        super.onPause();
        VideoView.onActivityPause();
    }

    public void onResume() {
        super.onResume();
        VideoView.onActivityResume();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            exit();
            return;
        }
        Uri data = intent.getData();
        String stringExtra = intent.getStringExtra("page_uri");
        String stringExtra2 = intent.getStringExtra(GuideDialog.TITLE);
        String stringExtra3 = intent.getStringExtra("mediaplayer_id");
        int i = 0;
        if (f.b(stringExtra3)) {
            i = Integer.parseInt(stringExtra3);
        }
        new StringBuilder("onCreate [uri, pageUri, title, domId] ").append(data).append(", ").append(stringExtra).append(", ").append(stringExtra2).append(",").append(i);
        if (i != 0) {
            this.mVideoView = new VideoView((Context) this, true, i);
        } else if (data == null || !f.b(data.toString())) {
            exit();
            return;
        } else {
            this.mVideoView = new VideoView((Context) this, true, g.a());
            this.mVideoView.setVideoURI(data);
        }
        setContentView(this.mVideoView);
        setRequestedOrientation(this.mVideoView.getVideoHeight() <= this.mVideoView.getVideoWidth() ? 6 : 7);
        this.mVideoView.getController().setTitleAndPageURI(stringExtra2, stringExtra);
        this.mVideoView.getListener().onEnterFullScreen(true);
        this.mVideoView.setFullScreenExecutor(this.mFullScreenExecutor);
        this.mVideoView.start();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            exit();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
