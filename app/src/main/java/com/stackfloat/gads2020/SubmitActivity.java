package com.stackfloat.gads2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.stackfloat.gads2020.services.LeadersService;
import com.stackfloat.gads2020.services.LeadersServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    private static final String TAG = SubmitActivity.class.getSimpleName();
    private EditText mEditFirstName;
    private EditText mEditLastName;
    private EditText mEditEmail;
    private EditText mEditProjectLink;
    private LeadersService mLeadersService;
    private AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mEditFirstName = findViewById(R.id.edit_first_name);
        mEditLastName = findViewById(R.id.edit_last_name);
        mEditEmail = findViewById(R.id.edit_email);
        mEditProjectLink = findViewById(R.id.edit_project_link);
        setSupportActionBar(toolbar);
        mLeadersService = LeadersServiceBuilder.buildService(LeadersService.class);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void submitProject(View view) {
        showMyDialog(R.layout.submission_prompt);
    }

    private void continueSubmission() {
        String firstName = mEditFirstName.getText().toString();
        String lastName = mEditLastName.getText().toString();
        String email = mEditEmail.getText().toString();
        String projectLink = mEditProjectLink.getText().toString();
        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !projectLink.isEmpty()) {
            Call<Void> submitForm = mLeadersService.submitForm(getString(R.string.form_url), email, firstName, lastName, projectLink);
            submitForm.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Log.i(TAG, "onResponse:  " + response.message());
                    if (response.code() >= 200 && response.code() < 299) {
                        showMyDialog(R.layout.success_dialog);
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e(TAG, "onFailure: ", t);
                    showMyDialog(R.layout.failure_dialog);
                }
            });
        }else {
            showSnackBar(mEditEmail, R.string.emty_field);
        }
    }

    private void showMyDialog(int resLayoutId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SubmitActivity.this)
                .setView(resLayoutId);
        mDialog = builder.create();
        mDialog.setCanceledOnTouchOutside(true);
        if (mDialog.getWindow() != null) {
            mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        mDialog.show();
    }

    public void confirmSubmit(View view) {
        if (mDialog.isShowing()) {
            showSnackBar(view, R.string.confirmed_sumbit);
            mDialog.dismiss();
            continueSubmission();
        }
    }

    private void showSnackBar(View view, int resId) {
        Snackbar.make(mEditEmail, resId, Snackbar.LENGTH_LONG).show();
    }

    public void cancelSubmit(View view) {
        if (mDialog.isShowing()) {
            showSnackBar(view, R.string.submit_canceled);
            mDialog.dismiss();
        }
    }
}