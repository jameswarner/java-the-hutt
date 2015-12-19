package com.mse.android.javathehutt;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;


public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

    private Button mButton;
    private Date in_date;

    DatePickerFragment(Button in_button, Date date) {
        mButton = in_button;
        in_date = date;
    }
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        in_date.setYear(year);
        in_date.setMonth(month);
        in_date.setDate(day);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        mButton.setText(month + "/" + day + "/" + year);
    }
}
