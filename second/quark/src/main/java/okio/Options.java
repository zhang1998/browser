package okio;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;

    private Options(ByteString[] byteStringArr) {
        this.byteStrings = byteStringArr;
    }

    public static Options of(ByteString... byteStringArr) {
        return new Options((ByteString[]) byteStringArr.clone());
    }

    public final ByteString get(int i) {
        return this.byteStrings[i];
    }

    public final int size() {
        return this.byteStrings.length;
    }
}
