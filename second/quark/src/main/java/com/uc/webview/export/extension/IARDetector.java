package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IARDetector {

    @Api
    /* compiled from: ProGuard */
    public interface ResultListener {
        void onInit(int i);

        void onResult(String str);
    }

    @Api
    /* compiled from: ProGuard */
    public class ARDetector implements IARDetector {
        protected ResultListener mListener = null;

        public final boolean isDetector() {
            return true;
        }

        public void setResultListener(ResultListener resultListener) {
            this.mListener = resultListener;
        }

        public void init(int i, int i2, int i3, int i4, int i5) {
        }

        public void stop() {
        }

        public void setARSessionFrame(ARSessionFrame aRSessionFrame) {
        }

        public final String setARSessionFrameFilter(ARSessionFrame aRSessionFrame) {
            return null;
        }

        public void pause() {
        }

        public void resume() {
        }

        public void setMarkers(String[] strArr) {
        }

        public void removeMarkers() {
        }

        public void setOption(String str) {
        }

        public String getVersion() {
            return "-1";
        }
    }

    @Api
    /* compiled from: ProGuard */
    public class ARFilter implements IARDetector {
        protected ResultListener mListener = null;

        public final boolean isDetector() {
            return false;
        }

        public void setResultListener(ResultListener resultListener) {
            this.mListener = resultListener;
        }

        public void init(int i, int i2, int i3, int i4, int i5) {
        }

        public void stop() {
        }

        public final void setARSessionFrame(ARSessionFrame aRSessionFrame) {
        }

        public String setARSessionFrameFilter(ARSessionFrame aRSessionFrame) {
            return "";
        }

        public void pause() {
        }

        public void resume() {
        }

        public void setMarkers(String[] strArr) {
        }

        public void removeMarkers() {
        }

        public void setOption(String str) {
        }

        public String getVersion() {
            return "-1";
        }
    }

    @Api
    /* compiled from: ProGuard */
    public class ARSessionFrame {
        public byte[] data;
        public int format;
        public int frameId;
        public int height;
        public int rotation;
        public int width;
    }

    String getVersion();

    void init(int i, int i2, int i3, int i4, int i5);

    boolean isDetector();

    void pause();

    void removeMarkers();

    void resume();

    void setARSessionFrame(ARSessionFrame aRSessionFrame);

    String setARSessionFrameFilter(ARSessionFrame aRSessionFrame);

    void setMarkers(String[] strArr);

    void setOption(String str);

    void setResultListener(ResultListener resultListener);

    void stop();
}
