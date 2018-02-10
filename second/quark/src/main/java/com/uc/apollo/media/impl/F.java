package com.uc.apollo.media.impl;

/* compiled from: ProGuard */
public enum F {
    UNKNOWN(-4),
    ERROR(-3),
    END(-2),
    STOPPED(-1),
    IDLE(0),
    INITIALIZED(1),
    PREPARING(2),
    PREPARED(3),
    STARTED(4),
    PAUSED(5),
    COMPLETED(6);
    
    public final int l;

    public static F[] a() {
        return (F[]) m.clone();
    }

    private F(int i) {
        this.l = i;
    }

    public static F a(int i) {
        switch (i) {
            case -3:
                return ERROR;
            case -2:
                return END;
            case -1:
                return STOPPED;
            case 0:
                return IDLE;
            case 1:
                return INITIALIZED;
            case 2:
                return PREPARING;
            case 3:
                return PREPARED;
            case 4:
                return STARTED;
            case 5:
                return PAUSED;
            case 6:
                return COMPLETED;
            default:
                return UNKNOWN;
        }
    }

    public final String toString() {
        switch (this) {
            case COMPLETED:
                return "COMPLETED";
            case END:
                return "END";
            case ERROR:
                return "ERROR";
            case STOPPED:
                return "STOPPED";
            case IDLE:
                return "IDLE";
            case INITIALIZED:
                return "INITIALIZED";
            case PAUSED:
                return "PAUSED";
            case PREPARED:
                return "PREPARED";
            case PREPARING:
                return "PREPARING";
            case STARTED:
                return "STARTED";
            default:
                return "UNKNOWN";
        }
    }
}
