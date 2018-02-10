package com.ui.edittext;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Selection.PositionIterator;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* compiled from: ProGuard */
public final class a extends b implements h {
    private static final Object a = new Object();
    private static a b;

    private static boolean b(Spannable spannable) {
        return g.a((CharSequence) spannable, 1) == 1 || g.a((CharSequence) spannable, 2048) != 0;
    }

    private static int a(Spannable spannable, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(spannable)));
    }

    private static int g(TextView textView) {
        Rect rect = new Rect();
        return textView.getGlobalVisibleRect(rect) ? rect.height() : 0;
    }

    protected final boolean a(TextView textView, Spannable spannable, int i, int i2, KeyEvent keyEvent) {
        switch (i) {
            case 23:
                if (KeyEvent.metaStateHasNoModifiers(i2) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && g.a((CharSequence) spannable, 2048) != 0) {
                    return textView.showContextMenu();
                }
        }
        return super.a(textView, spannable, i, i2, keyEvent);
    }

    protected final boolean a(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b(spannable)) {
            return Selection.extendLeft(spannable, layout);
        }
        return Selection.moveLeft(spannable, layout);
    }

    protected final boolean b(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b(spannable)) {
            return Selection.extendRight(spannable, layout);
        }
        return Selection.moveRight(spannable, layout);
    }

    protected final boolean c(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b(spannable)) {
            return Selection.extendUp(spannable, layout);
        }
        return Selection.moveUp(spannable, layout);
    }

    protected final boolean d(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b(spannable)) {
            return Selection.extendDown(spannable, layout);
        }
        return Selection.moveDown(spannable, layout);
    }

    protected final boolean e(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        boolean b = b(spannable);
        int a = a(spannable, layout) - g(textView);
        boolean z = false;
        do {
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (b) {
                Selection.extendUp(spannable, layout);
            } else {
                Selection.moveUp(spannable, layout);
            }
            if (Selection.getSelectionEnd(spannable) == selectionEnd) {
                break;
            }
            z = true;
        } while (a(spannable, layout) > a);
        return z;
    }

    protected final boolean f(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        boolean b = b(spannable);
        int g = g(textView) + a(spannable, layout);
        boolean z = false;
        do {
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (b) {
                Selection.extendDown(spannable, layout);
            } else {
                Selection.moveDown(spannable, layout);
            }
            if (Selection.getSelectionEnd(spannable) == selectionEnd) {
                break;
            }
            z = true;
        } while (a(spannable, layout) < g);
        return z;
    }

    protected final boolean g(TextView textView, Spannable spannable) {
        if (b(spannable)) {
            Selection.extendSelection(spannable, 0);
        } else {
            Selection.setSelection(spannable, 0);
        }
        return true;
    }

    protected final boolean h(TextView textView, Spannable spannable) {
        if (b(spannable)) {
            Selection.extendSelection(spannable, spannable.length());
        } else {
            Selection.setSelection(spannable, spannable.length());
        }
        return true;
    }

    protected final boolean i(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b(spannable)) {
            return Selection.extendToLeftEdge(spannable, layout);
        }
        return Selection.moveToLeftEdge(spannable, layout);
    }

    protected final boolean j(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b(spannable)) {
            return Selection.extendToRightEdge(spannable, layout);
        }
        return Selection.moveToRightEdge(spannable, layout);
    }

    protected final boolean k(TextView textView, Spannable spannable) {
        int selectionEnd = textView.getSelectionEnd();
        PositionIterator wordIterator = textView.getWordIterator();
        wordIterator.setCharSequence(spannable, selectionEnd, selectionEnd);
        return Selection.moveToPreceding(spannable, wordIterator, b(spannable));
    }

    protected final boolean l(TextView textView, Spannable spannable) {
        int selectionEnd = textView.getSelectionEnd();
        PositionIterator wordIterator = textView.getWordIterator();
        wordIterator.setCharSequence(spannable, selectionEnd, selectionEnd);
        return Selection.moveToFollowing(spannable, wordIterator, b(spannable));
    }

    protected final boolean m(TextView textView, Spannable spannable) {
        return i(textView, spannable);
    }

    protected final boolean n(TextView textView, Spannable spannable) {
        return j(textView, spannable);
    }

    public final boolean a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int i;
        int i2 = -1;
        int action = motionEvent.getAction();
        if (action == 1) {
            aw[] awVarArr = (aw[]) spannable.getSpans(0, spannable.length(), aw.class);
            i = awVarArr.length > 0 ? awVarArr[0].c : -1;
            awVarArr = (aw[]) spannable.getSpans(0, spannable.length(), aw.class);
            if (awVarArr.length > 0) {
                i2 = awVarArr[0].d;
            }
        } else {
            i = -1;
        }
        boolean a = ax.a(textView, spannable, motionEvent);
        if (!textView.isFocused() || textView.d) {
            return a;
        }
        if (action == 0) {
            if (!b(spannable)) {
                return a;
            }
            i = textView.a(motionEvent.getX(), motionEvent.getY());
            spannable.setSpan(a, i, i, 34);
            textView.getParent().requestDisallowInterceptTouchEvent(true);
            return a;
        } else if (action == 2) {
            if (!b(spannable) || !a) {
                return a;
            }
            textView.cancelLongPress();
            Selection.extendSelection(spannable, textView.a(motionEvent.getX(), motionEvent.getY()));
            return true;
        } else if (action != 1) {
            return a;
        } else {
            if ((i2 < 0 || i2 == textView.getScrollY()) && (r1 < 0 || r1 == textView.getScrollX())) {
                int a2 = textView.a(motionEvent.getX(), motionEvent.getY());
                if (b(spannable)) {
                    spannable.removeSpan(a);
                    Selection.extendSelection(spannable, a2);
                } else if (!textView.c) {
                    Selection.setSelection(spannable, a2);
                }
                g.b(spannable);
                g.c(spannable);
                return true;
            }
            textView.i();
            return true;
        }
    }

    public final boolean a() {
        return true;
    }

    public final void a(Spannable spannable) {
        Selection.setSelection(spannable, 0);
    }

    public final void a(TextView textView, Spannable spannable, int i) {
        if ((i & 130) == 0 || textView.getLayout() == null) {
            Selection.setSelection(spannable, spannable.length());
        }
    }

    public static h b() {
        if (b == null) {
            b = new a();
        }
        return b;
    }
}
