package com.uc.apollo.media.service;

import com.uc.apollo.annotation.KeepForRuntime;
import java.util.HashMap;

@KeepForRuntime
/* compiled from: ProGuard */
public interface LittleWindowActionStatistic {
    public static final String[] ACTION_NAMES = new String[]{"play", "pause", "playDC", "pauseDC", "forward", "backward", "full", "move", "zoomOut", "zoomIn", "zoomOutDF", "zoomInDF"};
    public static final int BACKWARD = 5;
    public static final int ENTER_FULL_SCREEN = 6;
    public static final int FORWARD = 4;
    public static final int MOVE = 7;
    public static final int PAUSE = 1;
    public static final int PAUSE_BY_DBL_CLK = 3;
    public static final int PLAY = 0;
    public static final int PLAY_BY_DBL_CLK = 2;
    public static final int ZOOM_IN = 9;
    public static final int ZOOM_IN_BY_DBL_FLINGER = 11;
    public static final int ZOOM_OUT = 8;
    public static final int ZOOM_OUT_BY_DBL_FLINGER = 10;

    @KeepForRuntime
    /* compiled from: ProGuard */
    public class Factory {
        static LittleWindowActionStatistic sInstance;

        public static LittleWindowActionStatistic getInstance() {
            if (sInstance == null) {
                sInstance = new a();
            }
            return sInstance;
        }

        public static void setsInstance(LittleWindowActionStatistic littleWindowActionStatistic) {
            sInstance = littleWindowActionStatistic;
        }
    }

    /* compiled from: ProGuard */
    public final class a implements LittleWindowActionStatistic {
        private boolean a;
        private int[] b = new int[ACTION_NAMES.length];

        public final boolean valid() {
            return this.a;
        }

        public final HashMap<String, String> toMap() {
            HashMap<String, String> hashMap = new HashMap();
            for (int i = 0; i != this.b.length; i++) {
                hashMap.put(ACTION_NAMES[i], Integer.toString(this.b[i]));
            }
            return hashMap;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.b.length * 16);
            stringBuilder.append('{');
            for (int i = 0; i != this.b.length; i++) {
                stringBuilder.append(ACTION_NAMES[i]).append(": ").append(this.b[i]).append(", ");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final void reset() {
            this.a = false;
            for (int i = 0; i != this.b.length; i++) {
                this.b[i] = 0;
            }
        }

        public final void onAction(int i) {
            onAction(i, this.b[i] + 1);
        }

        public final void onAction(int i, int i2) {
            this.b[i] = i2;
            this.a = true;
        }
    }

    void onAction(int i);

    void onAction(int i, int i2);

    void reset();

    HashMap<String, String> toMap();

    boolean valid();
}
