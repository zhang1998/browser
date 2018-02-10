package com.uc.media.interfaces;

import com.uc.webview.export.annotations.Api;
import java.util.Map;

@Api
/* compiled from: ProGuard */
public class VideoViewParams {
    private Controller mController;
    private Listener mListener;
    private String mPosterUrl;
    private Object mUserData;

    /* compiled from: ProGuard */
    public interface Controller {
        void enterLittleWin();
    }

    /* compiled from: ProGuard */
    public interface Listener {
        void onHadAttachedToLittleWindow(boolean z, int i);

        void onPause();

        void onSetVideoUri(String str, Map<String, String> map);

        void onStart();
    }

    public VideoViewParams(Controller controller, Listener listener, Object obj) {
        this.mController = controller;
        this.mListener = listener;
        this.mUserData = obj;
    }

    public VideoViewParams(Controller controller, Object obj) {
        this(controller, null, obj);
    }

    public VideoViewParams(Controller controller) {
        this(controller, null, null);
    }

    public VideoViewParams(Listener listener) {
        this(null, listener, null);
    }

    public VideoViewParams(Listener listener, Object obj) {
        this(null, listener, obj);
    }

    public VideoViewParams(Object obj) {
        this(null, null, obj);
    }

    public VideoViewParams() {
        this(null, null, null);
    }

    public String getPosterUrl() {
        return this.mPosterUrl;
    }

    public void setPosterUrl(String str) {
        this.mPosterUrl = str;
    }

    public Controller getController() {
        return this.mController;
    }

    public void setController(Controller controller) {
        this.mController = controller;
    }

    public Listener getListener() {
        return this.mListener;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public Object getUserData() {
        return this.mUserData;
    }

    public void setUserData(Object obj) {
        this.mUserData = obj;
    }

    public String toString() {
        return "VideoViewParams - controller/listener/userData " + this.mController + "/" + this.mListener + "/" + this.mUserData;
    }
}
