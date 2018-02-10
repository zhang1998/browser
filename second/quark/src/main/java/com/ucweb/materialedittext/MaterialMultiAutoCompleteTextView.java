package com.ucweb.materialedittext;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.uc.imagecodec.export.IPictureView;
import com.ucweb.materialedittext.validation.METLengthChecker;
import com.ucweb.materialedittext.validation.METValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class MaterialMultiAutoCompleteTextView extends AppCompatMultiAutoCompleteTextView {
    public static final int FLOATING_LABEL_HIGHLIGHT = 2;
    public static final int FLOATING_LABEL_NONE = 0;
    public static final int FLOATING_LABEL_NORMAL = 1;
    private Typeface accentTypeface;
    private boolean autoValidate;
    private int baseColor;
    private int bottomEllipsisSize;
    private float bottomLines;
    ObjectAnimator bottomLinesAnimator;
    private int bottomSpacing;
    private int bottomTextSize;
    private boolean charactersCountValid;
    private boolean checkCharactersCountAtBeginning;
    private Bitmap[] clearButtonBitmaps;
    private boolean clearButtonClicking;
    private boolean clearButtonTouched;
    private float currentBottomLines;
    private int errorColor;
    private int extraPaddingBottom;
    private int extraPaddingLeft;
    private int extraPaddingRight;
    private int extraPaddingTop;
    private boolean firstShown;
    private boolean floatingLabelAlwaysShown;
    private boolean floatingLabelAnimating;
    private boolean floatingLabelEnabled;
    private float floatingLabelFraction;
    private int floatingLabelPadding;
    private boolean floatingLabelShown;
    private CharSequence floatingLabelText;
    private int floatingLabelTextColor;
    private int floatingLabelTextSize;
    private ArgbEvaluator focusEvaluator = new ArgbEvaluator();
    private float focusFraction;
    private String helperText;
    private boolean helperTextAlwaysShown;
    private int helperTextColor = -1;
    private boolean hideUnderline;
    private boolean highlightFloatingLabel;
    private Bitmap[] iconLeftBitmaps;
    private int iconOuterHeight;
    private int iconOuterWidth;
    private int iconPadding;
    private Bitmap[] iconRightBitmaps;
    private int iconSize;
    OnFocusChangeListener innerFocusChangeListener;
    private int innerPaddingBottom;
    private int innerPaddingLeft;
    private int innerPaddingRight;
    private int innerPaddingTop;
    ObjectAnimator labelAnimator;
    ObjectAnimator labelFocusAnimator;
    private METLengthChecker lengthChecker;
    private int maxCharacters;
    private int minBottomLines;
    private int minBottomTextLines;
    private int minCharacters;
    OnFocusChangeListener outerFocusChangeListener;
    Paint paint = new Paint(1);
    private int primaryColor;
    private boolean showClearButton;
    private boolean singleLineEllipsis;
    private String tempErrorText;
    private ColorStateList textColorHintStateList;
    private ColorStateList textColorStateList;
    StaticLayout textLayout;
    TextPaint textPaint = new TextPaint(1);
    private Typeface typeface;
    private int underlineColor;
    private boolean validateOnFocusLost;
    private List<METValidator> validators;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface FloatingLabelType {
    }

    public MaterialMultiAutoCompleteTextView(Context context) {
        super(context);
        init(context, null);
    }

    public MaterialMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.iconSize = getPixel(32);
        this.iconOuterWidth = getPixel(48);
        this.iconOuterHeight = getPixel(32);
        this.bottomSpacing = getResources().getDimensionPixelSize(R.dimen.inner_components_spacing);
        this.bottomEllipsisSize = getResources().getDimensionPixelSize(R.dimen.bottom_ellipsis_height);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialEditText);
        this.textColorStateList = obtainStyledAttributes.getColorStateList(R.styleable.MaterialEditText_met_textColor);
        this.textColorHintStateList = obtainStyledAttributes.getColorStateList(R.styleable.MaterialEditText_met_textColorHint);
        this.baseColor = obtainStyledAttributes.getColor(R.styleable.MaterialEditText_met_baseColor, -16777216);
        TypedValue typedValue = new TypedValue();
        int i;
        try {
            if (VERSION.SDK_INT >= 21) {
                context.getTheme().resolveAttribute(16843827, typedValue, true);
                i = typedValue.data;
                this.primaryColor = obtainStyledAttributes.getColor(R.styleable.MaterialEditText_met_primaryColor, i);
                setFloatingLabelInternal(obtainStyledAttributes.getInt(R.styleable.MaterialEditText_met_floatingLabel, 0));
                this.errorColor = obtainStyledAttributes.getColor(R.styleable.MaterialEditText_met_errorColor, Color.parseColor("#e7492E"));
                this.minCharacters = obtainStyledAttributes.getInt(R.styleable.MaterialEditText_met_minCharacters, 0);
                this.maxCharacters = obtainStyledAttributes.getInt(R.styleable.MaterialEditText_met_maxCharacters, 0);
                this.singleLineEllipsis = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_singleLineEllipsis, false);
                this.helperText = obtainStyledAttributes.getString(R.styleable.MaterialEditText_met_helperText);
                this.helperTextColor = obtainStyledAttributes.getColor(R.styleable.MaterialEditText_met_helperTextColor, -1);
                this.minBottomTextLines = obtainStyledAttributes.getInt(R.styleable.MaterialEditText_met_minBottomTextLines, 0);
                String string = obtainStyledAttributes.getString(R.styleable.MaterialEditText_met_accentTypeface);
                if (!(string == null || isInEditMode())) {
                    this.accentTypeface = getCustomTypeface(string);
                    this.textPaint.setTypeface(this.accentTypeface);
                }
                string = obtainStyledAttributes.getString(R.styleable.MaterialEditText_met_typeface);
                if (!(string == null || isInEditMode())) {
                    this.typeface = getCustomTypeface(string);
                    setTypeface(this.typeface);
                }
                this.floatingLabelText = obtainStyledAttributes.getString(R.styleable.MaterialEditText_met_floatingLabelText);
                if (this.floatingLabelText == null) {
                    this.floatingLabelText = getHint();
                }
                this.floatingLabelPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_floatingLabelPadding, this.bottomSpacing);
                this.floatingLabelTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_floatingLabelTextSize, getResources().getDimensionPixelSize(R.dimen.floating_label_text_size));
                this.floatingLabelTextColor = obtainStyledAttributes.getColor(R.styleable.MaterialEditText_met_floatingLabelTextColor, -1);
                this.floatingLabelAnimating = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_floatingLabelAnimating, true);
                this.bottomTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_bottomTextSize, getResources().getDimensionPixelSize(R.dimen.bottom_text_size));
                this.hideUnderline = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_hideUnderline, false);
                this.underlineColor = obtainStyledAttributes.getColor(R.styleable.MaterialEditText_met_underlineColor, -1);
                this.autoValidate = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_autoValidate, false);
                this.iconLeftBitmaps = generateIconBitmaps(obtainStyledAttributes.getResourceId(R.styleable.MaterialEditText_met_iconLeft, -1));
                this.iconRightBitmaps = generateIconBitmaps(obtainStyledAttributes.getResourceId(R.styleable.MaterialEditText_met_iconRight, -1));
                this.showClearButton = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_clearButton, false);
                this.clearButtonBitmaps = generateIconBitmaps(R.drawable.met_ic_clear);
                this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_iconPadding, getPixel(16));
                this.floatingLabelAlwaysShown = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_floatingLabelAlwaysShown, false);
                this.helperTextAlwaysShown = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_helperTextAlwaysShown, false);
                this.validateOnFocusLost = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_validateOnFocusLost, false);
                this.checkCharactersCountAtBeginning = obtainStyledAttributes.getBoolean(R.styleable.MaterialEditText_met_checkCharactersCountAtBeginning, true);
                this.innerPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_innerPaddingLeft, 0);
                this.innerPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_innerPaddingTop, 0);
                this.innerPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_innerPaddingRight, 0);
                this.innerPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialEditText_met_innerPaddingBottom, 0);
                obtainStyledAttributes.recycle();
                if (VERSION.SDK_INT >= 16) {
                    setBackground(null);
                } else {
                    setBackgroundDrawable(null);
                }
                if (this.singleLineEllipsis) {
                    TransformationMethod transformationMethod = getTransformationMethod();
                    setSingleLine();
                    setTransformationMethod(transformationMethod);
                }
                initMinBottomLines();
                initPadding();
                initText();
                initFloatingLabel();
                initTextWatcher();
                checkCharactersCount();
                return;
            }
            throw new RuntimeException("SDK_INT less than LOLLIPOP");
        } catch (Exception e) {
            int identifier = getResources().getIdentifier("colorPrimary", "attr", getContext().getPackageName());
            if (identifier != 0) {
                context.getTheme().resolveAttribute(identifier, typedValue, true);
                i = typedValue.data;
            } else {
                throw new RuntimeException("colorPrimary not found");
            }
        } catch (Exception e2) {
            i = this.baseColor;
        }
    }

    private void initText() {
        if (TextUtils.isEmpty(getText())) {
            resetHintTextColor();
        } else {
            CharSequence text = getText();
            setText(null);
            resetHintTextColor();
            setText(text);
            setSelection(text.length());
            this.floatingLabelFraction = IPictureView.DEFAULT_MIN_SCALE;
            this.floatingLabelShown = true;
        }
        resetTextColor();
    }

    private void initTextWatcher() {
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                MaterialMultiAutoCompleteTextView.this.checkCharactersCount();
                if (MaterialMultiAutoCompleteTextView.this.autoValidate) {
                    MaterialMultiAutoCompleteTextView.this.validate();
                } else {
                    MaterialMultiAutoCompleteTextView.this.setError(null);
                }
                MaterialMultiAutoCompleteTextView.this.postInvalidate();
            }
        });
    }

    private Typeface getCustomTypeface(@NonNull String str) {
        return Typeface.createFromAsset(getContext().getAssets(), str);
    }

    public void setIconLeft(@DrawableRes int i) {
        this.iconLeftBitmaps = generateIconBitmaps(i);
        initPadding();
    }

    public void setIconLeft(Drawable drawable) {
        this.iconLeftBitmaps = generateIconBitmaps(drawable);
        initPadding();
    }

    public void setIconLeft(Bitmap bitmap) {
        this.iconLeftBitmaps = generateIconBitmaps(bitmap);
        initPadding();
    }

    public void setIconRight(@DrawableRes int i) {
        this.iconRightBitmaps = generateIconBitmaps(i);
        initPadding();
    }

    public void setIconRight(Drawable drawable) {
        this.iconRightBitmaps = generateIconBitmaps(drawable);
        initPadding();
    }

    public void setIconRight(Bitmap bitmap) {
        this.iconRightBitmaps = generateIconBitmaps(bitmap);
        initPadding();
    }

    public boolean isShowClearButton() {
        return this.showClearButton;
    }

    public void setShowClearButton(boolean z) {
        this.showClearButton = z;
        correctPaddings();
    }

    private Bitmap[] generateIconBitmaps(@DrawableRes int i) {
        int i2 = 1;
        if (i == -1) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i, options);
        int max = Math.max(options.outWidth, options.outHeight);
        if (max > this.iconSize) {
            i2 = max / this.iconSize;
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return generateIconBitmaps(BitmapFactory.decodeResource(getResources(), i, options));
    }

    private Bitmap[] generateIconBitmaps(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return generateIconBitmaps(Bitmap.createScaledBitmap(createBitmap, this.iconSize, this.iconSize, false));
    }

    private Bitmap[] generateIconBitmaps(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap[] bitmapArr = new Bitmap[4];
        Bitmap scaleIcon = scaleIcon(bitmap);
        bitmapArr[0] = scaleIcon.copy(Config.ARGB_8888, true);
        new Canvas(bitmapArr[0]).drawColor((Colors.isLight(this.baseColor) ? -16777216 : -1979711488) | (this.baseColor & 16777215), Mode.SRC_IN);
        bitmapArr[1] = scaleIcon.copy(Config.ARGB_8888, true);
        new Canvas(bitmapArr[1]).drawColor(this.primaryColor, Mode.SRC_IN);
        bitmapArr[2] = scaleIcon.copy(Config.ARGB_8888, true);
        new Canvas(bitmapArr[2]).drawColor((Colors.isLight(this.baseColor) ? 1275068416 : 1107296256) | (this.baseColor & 16777215), Mode.SRC_IN);
        bitmapArr[3] = scaleIcon.copy(Config.ARGB_8888, true);
        new Canvas(bitmapArr[3]).drawColor(this.errorColor, Mode.SRC_IN);
        return bitmapArr;
    }

    private Bitmap scaleIcon(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int max = Math.max(width, height);
        if (max == this.iconSize || max <= this.iconSize) {
            return bitmap;
        }
        int i;
        if (width > this.iconSize) {
            i = this.iconSize;
            max = (int) (((float) this.iconSize) * (((float) height) / ((float) width)));
        } else {
            max = this.iconSize;
            i = (int) (((float) this.iconSize) * (((float) width) / ((float) height)));
        }
        return Bitmap.createScaledBitmap(bitmap, i, max, false);
    }

    public float getFloatingLabelFraction() {
        return this.floatingLabelFraction;
    }

    public void setFloatingLabelFraction(float f) {
        this.floatingLabelFraction = f;
        invalidate();
    }

    public float getFocusFraction() {
        return this.focusFraction;
    }

    public void setFocusFraction(float f) {
        this.focusFraction = f;
        invalidate();
    }

    public float getCurrentBottomLines() {
        return this.currentBottomLines;
    }

    public void setCurrentBottomLines(float f) {
        this.currentBottomLines = f;
        initPadding();
    }

    public boolean isFloatingLabelAlwaysShown() {
        return this.floatingLabelAlwaysShown;
    }

    public void setFloatingLabelAlwaysShown(boolean z) {
        this.floatingLabelAlwaysShown = z;
        invalidate();
    }

    public boolean isHelperTextAlwaysShown() {
        return this.helperTextAlwaysShown;
    }

    public void setHelperTextAlwaysShown(boolean z) {
        this.helperTextAlwaysShown = z;
        invalidate();
    }

    @Nullable
    public Typeface getAccentTypeface() {
        return this.accentTypeface;
    }

    public void setAccentTypeface(Typeface typeface) {
        this.accentTypeface = typeface;
        this.textPaint.setTypeface(typeface);
        postInvalidate();
    }

    public boolean isHideUnderline() {
        return this.hideUnderline;
    }

    public void setHideUnderline(boolean z) {
        this.hideUnderline = z;
        initPadding();
        postInvalidate();
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    public void setUnderlineColor(int i) {
        this.underlineColor = i;
        postInvalidate();
    }

    public CharSequence getFloatingLabelText() {
        return this.floatingLabelText;
    }

    public void setFloatingLabelText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getHint();
        }
        this.floatingLabelText = charSequence;
        postInvalidate();
    }

    public int getFloatingLabelTextSize() {
        return this.floatingLabelTextSize;
    }

    public void setFloatingLabelTextSize(int i) {
        this.floatingLabelTextSize = i;
        initPadding();
    }

    public int getFloatingLabelTextColor() {
        return this.floatingLabelTextColor;
    }

    public void setFloatingLabelTextColor(int i) {
        this.floatingLabelTextColor = i;
        postInvalidate();
    }

    public int getBottomTextSize() {
        return this.bottomTextSize;
    }

    public void setBottomTextSize(int i) {
        this.bottomTextSize = i;
        initPadding();
    }

    private int getPixel(int i) {
        return Density.dp2px(getContext(), (float) i);
    }

    private void initPadding() {
        int i = 0;
        this.extraPaddingTop = this.floatingLabelEnabled ? this.floatingLabelTextSize + this.floatingLabelPadding : this.floatingLabelPadding;
        this.textPaint.setTextSize((float) this.bottomTextSize);
        FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.extraPaddingBottom = (this.hideUnderline ? this.bottomSpacing : this.bottomSpacing * 2) + ((int) ((fontMetrics.descent - fontMetrics.ascent) * this.currentBottomLines));
        this.extraPaddingLeft = this.iconLeftBitmaps == null ? 0 : this.iconOuterWidth + this.iconPadding;
        if (this.iconRightBitmaps != null) {
            i = this.iconPadding + this.iconOuterWidth;
        }
        this.extraPaddingRight = i;
        correctPaddings();
    }

    private void initMinBottomLines() {
        int i;
        int i2 = 1;
        if (this.minCharacters > 0 || this.maxCharacters > 0 || this.singleLineEllipsis || this.tempErrorText != null || this.helperText != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.minBottomTextLines > 0) {
            i2 = this.minBottomTextLines;
        } else if (i == 0) {
            i2 = 0;
        }
        this.minBottomLines = i2;
        this.currentBottomLines = (float) i2;
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
    }

    public void setPaddings(int i, int i2, int i3, int i4) {
        this.innerPaddingTop = i2;
        this.innerPaddingBottom = i4;
        this.innerPaddingLeft = i;
        this.innerPaddingRight = i3;
        correctPaddings();
    }

    private void correctPaddings() {
        int i = 0;
        int buttonsCount = this.iconOuterWidth * getButtonsCount();
        if (!isRTL()) {
            int i2 = buttonsCount;
            buttonsCount = 0;
            i = i2;
        }
        super.setPadding(buttonsCount + (this.innerPaddingLeft + this.extraPaddingLeft), this.innerPaddingTop + this.extraPaddingTop, i + (this.innerPaddingRight + this.extraPaddingRight), this.innerPaddingBottom + this.extraPaddingBottom);
    }

    private int getButtonsCount() {
        return isShowClearButton() ? 1 : 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.firstShown) {
            this.firstShown = true;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            adjustBottomLines();
        }
    }

    private boolean adjustBottomLines() {
        if (getWidth() == 0) {
            return false;
        }
        int i;
        this.textPaint.setTextSize((float) this.bottomTextSize);
        if (this.tempErrorText == null && this.helperText == null) {
            i = this.minBottomLines;
        } else {
            Alignment alignment = ((getGravity() & 5) == 5 || isRTL()) ? Alignment.ALIGN_OPPOSITE : (getGravity() & 3) == 3 ? Alignment.ALIGN_NORMAL : Alignment.ALIGN_CENTER;
            this.textLayout = new StaticLayout(this.tempErrorText != null ? this.tempErrorText : this.helperText, this.textPaint, (((getWidth() - getBottomTextLeftOffset()) - getBottomTextRightOffset()) - getPaddingLeft()) - getPaddingRight(), alignment, IPictureView.DEFAULT_MIN_SCALE, 0.0f, true);
            i = Math.max(this.textLayout.getLineCount(), this.minBottomTextLines);
        }
        if (this.bottomLines != ((float) i)) {
            getBottomLinesAnimator((float) i).start();
        }
        this.bottomLines = (float) i;
        return true;
    }

    public int getInnerPaddingTop() {
        return this.innerPaddingTop;
    }

    public int getInnerPaddingBottom() {
        return this.innerPaddingBottom;
    }

    public int getInnerPaddingLeft() {
        return this.innerPaddingLeft;
    }

    public int getInnerPaddingRight() {
        return this.innerPaddingRight;
    }

    private void initFloatingLabel() {
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (!MaterialMultiAutoCompleteTextView.this.floatingLabelEnabled) {
                    return;
                }
                if (editable.length() == 0) {
                    if (MaterialMultiAutoCompleteTextView.this.floatingLabelShown) {
                        MaterialMultiAutoCompleteTextView.this.floatingLabelShown = false;
                        MaterialMultiAutoCompleteTextView.this.getLabelAnimator().reverse();
                    }
                } else if (!MaterialMultiAutoCompleteTextView.this.floatingLabelShown) {
                    MaterialMultiAutoCompleteTextView.this.floatingLabelShown = true;
                    MaterialMultiAutoCompleteTextView.this.getLabelAnimator().start();
                }
            }
        });
        this.innerFocusChangeListener = new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (MaterialMultiAutoCompleteTextView.this.floatingLabelEnabled && MaterialMultiAutoCompleteTextView.this.highlightFloatingLabel) {
                    if (z) {
                        MaterialMultiAutoCompleteTextView.this.getLabelFocusAnimator().start();
                    } else {
                        MaterialMultiAutoCompleteTextView.this.getLabelFocusAnimator().reverse();
                    }
                }
                if (MaterialMultiAutoCompleteTextView.this.validateOnFocusLost && !z) {
                    MaterialMultiAutoCompleteTextView.this.validate();
                }
                if (MaterialMultiAutoCompleteTextView.this.outerFocusChangeListener != null) {
                    MaterialMultiAutoCompleteTextView.this.outerFocusChangeListener.onFocusChange(view, z);
                }
            }
        };
        super.setOnFocusChangeListener(this.innerFocusChangeListener);
    }

    public boolean isValidateOnFocusLost() {
        return this.validateOnFocusLost;
    }

    public void setValidateOnFocusLost(boolean z) {
        this.validateOnFocusLost = z;
    }

    public void setBaseColor(int i) {
        if (this.baseColor != i) {
            this.baseColor = i;
        }
        initText();
        postInvalidate();
    }

    public void setPrimaryColor(int i) {
        this.primaryColor = i;
        postInvalidate();
    }

    public void setMetTextColor(int i) {
        this.textColorStateList = ColorStateList.valueOf(i);
        resetTextColor();
    }

    public void setMetTextColor(ColorStateList colorStateList) {
        this.textColorStateList = colorStateList;
        resetTextColor();
    }

    private void resetTextColor() {
        if (this.textColorStateList == null) {
            r1 = new int[2][];
            r1[0] = new int[]{16842910};
            r1[1] = EMPTY_STATE_SET;
            this.textColorStateList = new ColorStateList(r1, new int[]{(this.baseColor & 16777215) | -553648128, (this.baseColor & 16777215) | 1140850688});
        }
        setTextColor(this.textColorStateList);
    }

    public void setMetHintTextColor(int i) {
        this.textColorHintStateList = ColorStateList.valueOf(i);
        resetHintTextColor();
    }

    public void setMetHintTextColor(ColorStateList colorStateList) {
        this.textColorHintStateList = colorStateList;
        resetHintTextColor();
    }

    private void resetHintTextColor() {
        if (this.textColorHintStateList == null) {
            setHintTextColor((this.baseColor & 16777215) | 1140850688);
        } else {
            setHintTextColor(this.textColorHintStateList);
        }
    }

    private void setFloatingLabelInternal(int i) {
        switch (i) {
            case 1:
                this.floatingLabelEnabled = true;
                this.highlightFloatingLabel = false;
                return;
            case 2:
                this.floatingLabelEnabled = true;
                this.highlightFloatingLabel = true;
                return;
            default:
                this.floatingLabelEnabled = false;
                this.highlightFloatingLabel = false;
                return;
        }
    }

    public void setFloatingLabel(int i) {
        setFloatingLabelInternal(i);
        initPadding();
    }

    public int getFloatingLabelPadding() {
        return this.floatingLabelPadding;
    }

    public void setFloatingLabelPadding(int i) {
        this.floatingLabelPadding = i;
        postInvalidate();
    }

    public boolean isFloatingLabelAnimating() {
        return this.floatingLabelAnimating;
    }

    public void setFloatingLabelAnimating(boolean z) {
        this.floatingLabelAnimating = z;
    }

    public void setSingleLineEllipsis() {
        setSingleLineEllipsis(true);
    }

    public void setSingleLineEllipsis(boolean z) {
        this.singleLineEllipsis = z;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public int getMaxCharacters() {
        return this.maxCharacters;
    }

    public void setMaxCharacters(int i) {
        this.maxCharacters = i;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public int getMinCharacters() {
        return this.minCharacters;
    }

    public void setMinCharacters(int i) {
        this.minCharacters = i;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public int getMinBottomTextLines() {
        return this.minBottomTextLines;
    }

    public void setMinBottomTextLines(int i) {
        this.minBottomTextLines = i;
        initMinBottomLines();
        initPadding();
        postInvalidate();
    }

    public boolean isAutoValidate() {
        return this.autoValidate;
    }

    public void setAutoValidate(boolean z) {
        this.autoValidate = z;
        if (z) {
            validate();
        }
    }

    public int getErrorColor() {
        return this.errorColor;
    }

    public void setErrorColor(int i) {
        this.errorColor = i;
        postInvalidate();
    }

    public void setHelperText(CharSequence charSequence) {
        this.helperText = charSequence == null ? null : charSequence.toString();
        if (adjustBottomLines()) {
            postInvalidate();
        }
    }

    public String getHelperText() {
        return this.helperText;
    }

    public int getHelperTextColor() {
        return this.helperTextColor;
    }

    public void setHelperTextColor(int i) {
        this.helperTextColor = i;
        postInvalidate();
    }

    public void setError(CharSequence charSequence) {
        this.tempErrorText = charSequence == null ? null : charSequence.toString();
        if (adjustBottomLines()) {
            postInvalidate();
        }
    }

    public CharSequence getError() {
        return this.tempErrorText;
    }

    private boolean isInternalValid() {
        return this.tempErrorText == null && isCharactersCountValid();
    }

    @Deprecated
    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile(str).matcher(getText()).matches();
    }

    @Deprecated
    public boolean validate(String str, CharSequence charSequence) {
        boolean isValid = isValid(str);
        if (!isValid) {
            setError(charSequence);
        }
        postInvalidate();
        return isValid;
    }

    public boolean validateWith(@NonNull METValidator mETValidator) {
        CharSequence text = getText();
        boolean isValid = mETValidator.isValid(text, text.length() == 0);
        if (!isValid) {
            setError(mETValidator.getErrorMessage());
        }
        postInvalidate();
        return isValid;
    }

    public boolean validate() {
        boolean z = true;
        if (!(this.validators == null || this.validators.isEmpty())) {
            CharSequence text = getText();
            boolean z2 = text.length() == 0;
            boolean z3 = true;
            for (METValidator mETValidator : this.validators) {
                if (z3 && mETValidator.isValid(text, z2)) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    setError(mETValidator.getErrorMessage());
                    z = z3;
                    break;
                }
            }
            z = z3;
            if (z) {
                setError(null);
            }
            postInvalidate();
        }
        return z;
    }

    public boolean hasValidators() {
        return (this.validators == null || this.validators.isEmpty()) ? false : true;
    }

    public MaterialMultiAutoCompleteTextView addValidator(METValidator mETValidator) {
        if (this.validators == null) {
            this.validators = new ArrayList();
        }
        this.validators.add(mETValidator);
        return this;
    }

    public void clearValidators() {
        if (this.validators != null) {
            this.validators.clear();
        }
    }

    @Nullable
    public List<METValidator> getValidators() {
        return this.validators;
    }

    public void setLengthChecker(METLengthChecker mETLengthChecker) {
        this.lengthChecker = mETLengthChecker;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        if (this.innerFocusChangeListener == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.outerFocusChangeListener = onFocusChangeListener;
        }
    }

    private ObjectAnimator getLabelAnimator() {
        if (this.labelAnimator == null) {
            this.labelAnimator = ObjectAnimator.ofFloat(this, "floatingLabelFraction", new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        }
        this.labelAnimator.setDuration(this.floatingLabelAnimating ? 300 : 0);
        return this.labelAnimator;
    }

    private ObjectAnimator getLabelFocusAnimator() {
        if (this.labelFocusAnimator == null) {
            this.labelFocusAnimator = ObjectAnimator.ofFloat(this, "focusFraction", new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        }
        return this.labelFocusAnimator;
    }

    private ObjectAnimator getBottomLinesAnimator(float f) {
        if (this.bottomLinesAnimator == null) {
            this.bottomLinesAnimator = ObjectAnimator.ofFloat(this, "currentBottomLines", new float[]{f});
        } else {
            this.bottomLinesAnimator.cancel();
            this.bottomLinesAnimator.setFloatValues(new float[]{f});
        }
        return this.bottomLinesAnimator;
    }

    protected void onDraw(@NonNull Canvas canvas) {
        int scrollX = getScrollX() + (this.iconLeftBitmaps == null ? 0 : this.iconOuterWidth + this.iconPadding);
        int scrollX2 = getScrollX() + (this.iconRightBitmaps == null ? getWidth() : (getWidth() - this.iconOuterWidth) - this.iconPadding);
        int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
        this.paint.setAlpha(255);
        if (this.iconLeftBitmaps != null) {
            Bitmap[] bitmapArr = this.iconLeftBitmaps;
            int i = !isInternalValid() ? 3 : !isEnabled() ? 2 : hasFocus() ? 1 : 0;
            Bitmap bitmap = bitmapArr[i];
            canvas.drawBitmap(bitmap, (float) (((scrollX - this.iconPadding) - this.iconOuterWidth) + ((this.iconOuterWidth - bitmap.getWidth()) / 2)), (float) (((this.bottomSpacing + scrollY) - this.iconOuterHeight) + ((this.iconOuterHeight - bitmap.getHeight()) / 2)), this.paint);
        }
        if (this.iconRightBitmaps != null) {
            bitmapArr = this.iconRightBitmaps;
            i = !isInternalValid() ? 3 : !isEnabled() ? 2 : hasFocus() ? 1 : 0;
            bitmap = bitmapArr[i];
            canvas.drawBitmap(bitmap, (float) ((this.iconPadding + scrollX2) + ((this.iconOuterWidth - bitmap.getWidth()) / 2)), (float) (((this.bottomSpacing + scrollY) - this.iconOuterHeight) + ((this.iconOuterHeight - bitmap.getHeight()) / 2)), this.paint);
        }
        if (hasFocus() && this.showClearButton && !TextUtils.isEmpty(getText()) && isEnabled()) {
            this.paint.setAlpha(255);
            if (isRTL()) {
                i = scrollX;
            } else {
                i = scrollX2 - this.iconOuterWidth;
            }
            Bitmap bitmap2 = this.clearButtonBitmaps[0];
            canvas.drawBitmap(bitmap2, (float) (i + ((this.iconOuterWidth - bitmap2.getWidth()) / 2)), (float) (((this.bottomSpacing + scrollY) - this.iconOuterHeight) + ((this.iconOuterHeight - bitmap2.getHeight()) / 2)), this.paint);
        }
        if (!this.hideUnderline) {
            int i2 = scrollY + this.bottomSpacing;
            if (!isInternalValid()) {
                this.paint.setColor(this.errorColor);
                canvas.drawRect((float) scrollX, (float) i2, (float) scrollX2, (float) (getPixel(2) + i2), this.paint);
                scrollY = i2;
            } else if (!isEnabled()) {
                this.paint.setColor(this.underlineColor != -1 ? this.underlineColor : (this.baseColor & 16777215) | 1140850688);
                float pixel = (float) getPixel(1);
                for (float f = 0.0f; f < ((float) getWidth()); f = (IPictureView.DEFAULT_MAX_SCALE * pixel) + f) {
                    canvas.drawRect(((float) scrollX) + f, (float) i2, (((float) scrollX) + f) + pixel, (float) (getPixel(1) + i2), this.paint);
                }
                scrollY = i2;
            } else if (hasFocus()) {
                this.paint.setColor(this.primaryColor);
                canvas.drawRect((float) scrollX, (float) i2, (float) scrollX2, (float) (getPixel(2) + i2), this.paint);
                scrollY = i2;
            } else {
                if (this.underlineColor != -1) {
                    i = this.underlineColor;
                } else {
                    i = (this.baseColor & 16777215) | 503316480;
                }
                this.paint.setColor(i);
                canvas.drawRect((float) scrollX, (float) i2, (float) scrollX2, (float) (getPixel(1) + i2), this.paint);
                scrollY = i2;
            }
        }
        this.textPaint.setTextSize((float) this.bottomTextSize);
        FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float f2 = (-fontMetrics.ascent) - fontMetrics.descent;
        float f3 = (((float) this.bottomTextSize) + fontMetrics.ascent) + fontMetrics.descent;
        if ((hasFocus() && hasCharactersCounter()) || !isCharactersCountValid()) {
            this.textPaint.setColor(isCharactersCountValid() ? (this.baseColor & 16777215) | 1140850688 : this.errorColor);
            String charactersCounterText = getCharactersCounterText();
            canvas.drawText(charactersCounterText, isRTL() ? (float) scrollX : ((float) scrollX2) - this.textPaint.measureText(charactersCounterText), f2 + ((float) (this.bottomSpacing + scrollY)), this.textPaint);
        }
        if (this.textLayout != null && (this.tempErrorText != null || ((this.helperTextAlwaysShown || hasFocus()) && !TextUtils.isEmpty(this.helperText)))) {
            i = this.tempErrorText != null ? this.errorColor : this.helperTextColor != -1 ? this.helperTextColor : (this.baseColor & 16777215) | 1140850688;
            this.textPaint.setColor(i);
            canvas.save();
            if (isRTL()) {
                canvas.translate((float) (scrollX2 - this.textLayout.getWidth()), ((float) (this.bottomSpacing + scrollY)) - f3);
            } else {
                canvas.translate((float) (getBottomTextLeftOffset() + scrollX), ((float) (this.bottomSpacing + scrollY)) - f3);
            }
            this.textLayout.draw(canvas);
            canvas.restore();
        }
        if (this.floatingLabelEnabled && !TextUtils.isEmpty(this.floatingLabelText)) {
            this.textPaint.setTextSize((float) this.floatingLabelTextSize);
            this.textPaint.setColor(((Integer) this.focusEvaluator.evaluate(this.focusFraction * ((float) (isEnabled() ? 1 : 0)), Integer.valueOf(this.floatingLabelTextColor != -1 ? this.floatingLabelTextColor : (this.baseColor & 16777215) | 1140850688), Integer.valueOf(this.primaryColor))).intValue());
            float measureText = this.textPaint.measureText(this.floatingLabelText.toString());
            if ((getGravity() & 5) == 5 || isRTL()) {
                i = (int) (((float) scrollX2) - measureText);
            } else if ((getGravity() & 3) == 3) {
                i = scrollX;
            } else {
                i = ((int) (((((float) ((getWidth() - getInnerPaddingLeft()) - getInnerPaddingRight())) - measureText) / 2.0f) + ((float) getInnerPaddingLeft()))) + scrollX;
            }
            int scrollY2 = (int) ((((float) ((this.innerPaddingTop + this.floatingLabelTextSize) + this.floatingLabelPadding)) - ((this.floatingLabelAlwaysShown ? IPictureView.DEFAULT_MIN_SCALE : this.floatingLabelFraction) * ((float) this.floatingLabelPadding))) + ((float) getScrollY()));
            this.textPaint.setAlpha((int) ((this.floatingLabelTextColor != -1 ? IPictureView.DEFAULT_MIN_SCALE : ((float) Color.alpha(this.floatingLabelTextColor)) / 256.0f) * ((255.0f * (this.floatingLabelAlwaysShown ? IPictureView.DEFAULT_MIN_SCALE : this.floatingLabelFraction)) * ((((float) (isEnabled() ? 1 : 0)) * (this.focusFraction * 0.74f)) + 0.26f))));
            canvas.drawText(this.floatingLabelText.toString(), (float) i, (float) scrollY2, this.textPaint);
        }
        if (hasFocus() && this.singleLineEllipsis && getScrollX() != 0) {
            this.paint.setColor(isInternalValid() ? this.primaryColor : this.errorColor);
            float f4 = (float) (this.bottomSpacing + scrollY);
            if (isRTL()) {
                scrollX = scrollX2;
            }
            i = isRTL() ? -1 : 1;
            canvas.drawCircle((float) (((this.bottomEllipsisSize * i) / 2) + scrollX), ((float) (this.bottomEllipsisSize / 2)) + f4, (float) (this.bottomEllipsisSize / 2), this.paint);
            canvas.drawCircle((float) ((((this.bottomEllipsisSize * i) * 5) / 2) + scrollX), ((float) (this.bottomEllipsisSize / 2)) + f4, (float) (this.bottomEllipsisSize / 2), this.paint);
            canvas.drawCircle((float) ((((i * this.bottomEllipsisSize) * 9) / 2) + scrollX), f4 + ((float) (this.bottomEllipsisSize / 2)), (float) (this.bottomEllipsisSize / 2), this.paint);
        }
        super.onDraw(canvas);
    }

    @TargetApi(17)
    private boolean isRTL() {
        if (VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private int getBottomTextLeftOffset() {
        return isRTL() ? getCharactersCounterWidth() : getBottomEllipsisWidth();
    }

    private int getBottomTextRightOffset() {
        return isRTL() ? getBottomEllipsisWidth() : getCharactersCounterWidth();
    }

    private int getCharactersCounterWidth() {
        return hasCharactersCounter() ? (int) this.textPaint.measureText(getCharactersCounterText()) : 0;
    }

    private int getBottomEllipsisWidth() {
        return this.singleLineEllipsis ? (this.bottomEllipsisSize * 5) + getPixel(4) : 0;
    }

    private void checkCharactersCount() {
        boolean z = false;
        if ((this.firstShown || this.checkCharactersCountAtBeginning) && hasCharactersCounter()) {
            CharSequence text = getText();
            int checkLength = text == null ? 0 : checkLength(text);
            if (checkLength >= this.minCharacters && (this.maxCharacters <= 0 || checkLength <= this.maxCharacters)) {
                z = true;
            }
        } else {
            z = true;
        }
        this.charactersCountValid = z;
    }

    public boolean isCharactersCountValid() {
        return this.charactersCountValid;
    }

    private boolean hasCharactersCounter() {
        return this.minCharacters > 0 || this.maxCharacters > 0;
    }

    private String getCharactersCounterText() {
        return this.minCharacters <= 0 ? isRTL() ? this.maxCharacters + " / " + checkLength(getText()) : checkLength(getText()) + " / " + this.maxCharacters : this.maxCharacters <= 0 ? isRTL() ? "+" + this.minCharacters + " / " + checkLength(getText()) : checkLength(getText()) + " / " + this.minCharacters + "+" : isRTL() ? this.maxCharacters + "-" + this.minCharacters + " / " + checkLength(getText()) : checkLength(getText()) + " / " + this.minCharacters + "-" + this.maxCharacters;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.singleLineEllipsis || getScrollX() <= 0 || motionEvent.getAction() != 0 || motionEvent.getX() >= ((float) getPixel(20)) || motionEvent.getY() <= ((float) ((getHeight() - this.extraPaddingBottom) - this.innerPaddingBottom)) || motionEvent.getY() >= ((float) (getHeight() - this.innerPaddingBottom))) {
            if (hasFocus() && this.showClearButton && isEnabled()) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (insideClearButton(motionEvent)) {
                            this.clearButtonTouched = true;
                            this.clearButtonClicking = true;
                            return true;
                        }
                        break;
                    case 1:
                        if (this.clearButtonClicking) {
                            if (!TextUtils.isEmpty(getText())) {
                                setText(null);
                            }
                            this.clearButtonClicking = false;
                        }
                        if (!this.clearButtonTouched) {
                            this.clearButtonTouched = false;
                            break;
                        }
                        this.clearButtonTouched = false;
                        return true;
                    case 2:
                        if (this.clearButtonClicking && !insideClearButton(motionEvent)) {
                            this.clearButtonClicking = false;
                        }
                        if (this.clearButtonTouched) {
                            return true;
                        }
                        break;
                    case 3:
                        this.clearButtonTouched = false;
                        this.clearButtonClicking = false;
                        break;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        setSelection(0);
        return false;
    }

    private boolean insideClearButton(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int scrollX = getScrollX() + (this.iconLeftBitmaps == null ? 0 : this.iconOuterWidth + this.iconPadding);
        int width = (this.iconRightBitmaps == null ? getWidth() : (getWidth() - this.iconOuterWidth) - this.iconPadding) + getScrollX();
        if (isRTL()) {
            width = scrollX;
        } else {
            width -= this.iconOuterWidth;
        }
        scrollX = (((getScrollY() + getHeight()) - getPaddingBottom()) + this.bottomSpacing) - this.iconOuterHeight;
        if (x < ((float) width) || x >= ((float) (width + this.iconOuterWidth)) || y < ((float) scrollX) || y >= ((float) (this.iconOuterHeight + scrollX))) {
            return false;
        }
        return true;
    }

    private int checkLength(CharSequence charSequence) {
        if (this.lengthChecker == null) {
            return charSequence.length();
        }
        return this.lengthChecker.getLength(charSequence);
    }
}
