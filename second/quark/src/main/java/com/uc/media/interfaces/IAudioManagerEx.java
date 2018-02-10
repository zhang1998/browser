package com.uc.media.interfaces;

/* compiled from: ProGuard */
public interface IAudioManagerEx {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final int AUDIOFOCUS_LOSS = -1;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
    public static final int AUDIO_NOTIFY_FROM_AUDIO = 0;
    public static final int AUDIO_NOTIFY_FROM_PHONE = 1;
    public static final int STREAM_MUSIC = 3;

    /* compiled from: ProGuard */
    public interface OnAudioFocusChangeListener {
        void OnAudioFocusChange(int i);

        boolean isPlaying();

        boolean isVideo();
    }

    boolean hasPlayingAudios();

    int requestAudioFocus(OnAudioFocusChangeListener onAudioFocusChangeListener);

    int requestPhoneFocus(OnAudioFocusChangeListener onAudioFocusChangeListener);

    void unregistListener();
}
