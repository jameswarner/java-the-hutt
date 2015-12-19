package com.mse.android.javathehutt;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment
    implements TimePickerDialog.OnTimeSetListener    {

    private Button mButton;

    TimePickerFragment (Button in_button) {
        mButton = in_button;
    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    public void onTimeSet(TimePicker view, int hour, int minute) {
        mButton.setText(hour + ":" + minute);
    }

}
