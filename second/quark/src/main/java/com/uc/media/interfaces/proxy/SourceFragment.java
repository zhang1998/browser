package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;
import java.nio.ByteBuffer;

@Reflection
/* compiled from: ProGuard */
public interface SourceFragment {
    int afterRead();

    ByteBuffer beforeRead();

    String brief();

    void close();

    int dataSize();

    boolean empty();

    boolean exhaust();

    Consumer getConsumer();

    Range getRange();

    SourceInfo getSourceInfo();

    boolean haveData();

    long length();

    void open();

    SourceFragment setConsumer(Consumer consumer);

    void setMaxAttempts(int i);
}
