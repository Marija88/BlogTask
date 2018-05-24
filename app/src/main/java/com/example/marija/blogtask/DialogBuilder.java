package com.example.marija.blogtask;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Marija on 24/5/2018.
 */

public class DialogBuilder {

    public static final int BTN_OK = -1;
    public static final int BTN_CANCEL = -2;




    public DialogBuilder() {
    }


    public static AlertDialog createAlertDialog(final Context context, DialogInterface.OnClickListener onClickListener, String message, String title, String okBtn, String cancelBtn) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.customDialogStyle);
        if(message != null) {
            builder.setMessage(message);
        }

        if(okBtn != null && onClickListener != null) {
            builder.setPositiveButton(okBtn, onClickListener);
        }


        if(cancelBtn != null && onClickListener != null) {
            builder.setNegativeButton(cancelBtn, onClickListener);
        }
        if (title != null)
            builder.setTitle(title);

        builder.setCancelable(true);

        return builder.create();
    }

}


