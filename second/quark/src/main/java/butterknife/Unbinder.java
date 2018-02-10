package butterknife;

/* compiled from: ProGuard */
public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() {
        public final void unbind() {
        }
    };

    void unbind();
}
