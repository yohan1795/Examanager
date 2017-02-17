package com.yohan.examanager.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Admin on 13-02-17.
 */

public class CommonUtils {

    public static void showErrorDialog(Context mCtx, String msg)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void showProgressDialog(Context mCtx, String msg)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        builder.setMessage(msg);
        builder.setCancelable(false);

        final AlertDialog dialog = builder.create();
        dialog.show();
    }


}
