package com.tony.coder.im.view.dialog;

/**
 * 项目名称：Coder
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2016/3/29 15:46
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

import android.content.Context;

/**
 * 提示对话框，有一个确认、一个返回按钮
 */
public class DialogTips extends DialogBase {
    boolean hasNegative;
    boolean hasTitle;

    public DialogTips(Context context, String title, String message,
                      String buttonText, boolean hasNegative, boolean hasTitle) {
        super(context);
        super.setMessage(message);
        super.setNamePositiveButton(buttonText);
        this.hasNegative = hasNegative;
        this.hasTitle = hasTitle;
    }

    /**
     * 下线通知的对话框样式
     *
     * @param context
     * @param message
     * @param buttonText
     */
    public DialogTips(Context context, String message, String buttonText) {
        super(context);
        super.setMessage(message);
        super.setNamePositiveButton(buttonText);
        this.hasNegative = false;
        this.hasTitle = true;
        super.setTitle("提示");
        super.setIsCancel(false);
    }

    public DialogTips(Context context, String message, String buttonText,
                      String negativeText, String title, boolean isCancel) {
        super(context);
        super.setMessage(message);
        super.setNamePositiveButton(buttonText);
        this.hasNegative = false;
        super.setNamePositiveButton(negativeText);
        this.hasTitle = true;
        super.setTitle(title);
        super.setIsCancel(isCancel);
    }

    @Override
    protected void onDismiss() {

    }

    @Override
    protected void OnClickNegativeButton() {
        if (onCancelListener != null) {
            onCancelListener.onClick(this, 0);
        }
    }

    /**
     * 确认按钮，触发onSuccessListener的onClick
     */
    @Override
    protected boolean OnClickPositiveButton() {
        if (onSuccessListener != null) {
            onSuccessListener.onClick(this, 1);
        }
        return true;
    }

    /**
     * 创建对话框
     */
    @Override
    protected void onBuilding() {
        super.setWidth(dip2px(mainContext, 300));
        if (hasNegative) {
            super.setNameNegativeButton("取消");
        }
        if (!hasTitle) {
            super.setHasTitle(false);
        }
    }

    private int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (scale * dipValue + 0.5f);
    }
}