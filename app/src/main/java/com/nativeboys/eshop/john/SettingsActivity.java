package com.nativeboys.eshop.john;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.nativeboys.eshop.R;

public class SettingsActivity extends DialogFragment {

    private Button help;
    private Button aboutUs;
    private Button bug;
    private Button logOut;
    private AlertDialog dialogHelp;
    private AlertDialog dialogAboutUS;
    private AlertDialog dialogBug;
    private AlertDialog dialogLogOut;
    private AlertDialog.Builder helpD;
    private AlertDialog.Builder aboutUsD;
    private AlertDialog.Builder bugD;
    private AlertDialog.Builder logOutD;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FadeFragmentTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        help = view.findViewById(R.id.help_btn);
        aboutUs = view.findViewById(R.id.about_us_btn);
        bug = view.findViewById(R.id.bug_btn);
        logOut = view.findViewById(R.id.logout_btn);


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogHelp.show();
            }
        });

        helpD = new AlertDialog.Builder(getContext());
        helpD.setRecycleOnMeasureEnabled(true);
        helpD.setTitle("If you need support contact us at vMallSupport@gmail.com");
        helpD.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogHelp = helpD.create();

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAboutUS.show();
            }
        });

        aboutUsD = new AlertDialog.Builder(getContext());
        aboutUsD.setRecycleOnMeasureEnabled(true);
        aboutUsD.setTitle("we are just trying to figure out how the fuck android works");
        aboutUsD.setPositiveButton("NICE TO KNOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogAboutUS = aboutUsD.create();

        bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBug.show();
            }
        });

        bugD = new AlertDialog.Builder(getContext());
        bugD.setRecycleOnMeasureEnabled(true);
        bugD.setTitle("To report a bug contact us at vMallBugReport@gmail.com");
        bugD.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogBug = bugD.create();

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogOut.show();
            }
        });

        logOutD = new AlertDialog.Builder(getContext());
        logOutD.setRecycleOnMeasureEnabled(true);
        logOutD.setTitle("Are you sure you want to log out ?");
        logOutD.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        logOutD.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogLogOut = logOutD.create();
    }

}