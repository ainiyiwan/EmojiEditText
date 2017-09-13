package com.zhimadai.cctvmall.emojiedittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;

/**
 * Author ： zhangyang
 * Date   ： 2017/9/13
 * Email  :  18610942105@163.com
 * Description  :
 */

public class EmojiFilterEditText extends AppCompatEditText {

    public EmojiFilterEditText(Context context) {
        super(context);
        init();
    }

    public EmojiFilterEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmojiFilterEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setFilters(new InputFilter[]{new EmojiExcludeFilter()});
    }

    private class EmojiExcludeFilter implements InputFilter {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                int type = Character.getType(source.charAt(i));
                if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
                    return "";
                }
            }
            return null;
        }
    }
}
