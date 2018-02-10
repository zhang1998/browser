package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

/* compiled from: ProGuard */
public class u extends ExpandableListViewEx implements OnScrollListener, OnGroupClickListener, OnGroupExpandListener {
    public int a = 1;
    private boolean b = true;
    private int c;
    private int d;
    private Rect e = new Rect();
    private int f = -1;
    private View g;
    private q h;

    public u(Context context) {
        super(context);
        setOnScrollListener(this);
        setOnGroupClickListener(this);
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(getLeft(), this.e.bottom, getRight(), getBottom());
        super.dispatchDraw(canvas);
        canvas.restore();
        if (this.a == 1) {
            drawChild(canvas, this.g, getDrawingTime());
        }
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        this.h = (q) expandableListAdapter;
        this.g = this.h.a(this.g, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a == 1 && this.g != null) {
            this.g.layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g != null) {
            measureChild(this.g, i, i2);
            this.d = this.g.getMeasuredWidth();
            this.c = this.g.getMeasuredHeight();
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.a == 1) {
            int packedPositionGroup = getPackedPositionGroup(getExpandableListPosition(i));
            if (packedPositionGroup >= 0 && this.h != null) {
                if (this.f != packedPositionGroup) {
                    this.g = this.h.a(this.g, packedPositionGroup);
                    this.f = packedPositionGroup;
                }
                int flatListPosition = getFlatListPosition(getPackedPositionForGroup(packedPositionGroup + 1)) - i;
                int i4 = this.c;
                if (getChildCount() <= 0) {
                    packedPositionGroup = 0;
                } else {
                    packedPositionGroup = getChildAt(0).getTop();
                    int i5 = 0;
                    while (i5 < flatListPosition && i5 < getChildCount()) {
                        int height = getChildAt(i5).getHeight() + packedPositionGroup;
                        i5++;
                        packedPositionGroup = height;
                    }
                }
                packedPositionGroup = i4 - packedPositionGroup;
                if (packedPositionGroup <= 0 || packedPositionGroup >= this.c) {
                    this.e.set(0, 0, this.d, this.c);
                } else {
                    this.e.set(0, -packedPositionGroup, this.d, this.c - packedPositionGroup);
                }
                if (this.g != null && this.g.getTop() != this.e.top) {
                    requestLayout();
                }
            }
        }
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return this.b;
    }

    public void onGroupExpand(int i) {
    }

    public void setGroupUnExpandable(boolean z) {
        this.b = z;
    }

    protected void handleDataChanged() {
        super.handleDataChanged();
        if (this.g != null) {
            int packedPositionGroup = getPackedPositionGroup(getExpandableListPosition(getFirstVisiblePosition()));
            if (packedPositionGroup >= 0 && this.h != null) {
                this.g = this.h.a(this.g, packedPositionGroup);
                this.f = packedPositionGroup;
            }
        }
    }
}
