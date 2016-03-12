package com.tech.aaranya.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.tech.aaranya.R;
import com.tech.aaranya.constants.StringConstant;
import com.tech.aaranya.data.model.RegistrationDetail;
import com.tech.aaranya.data.model.User;
import com.tech.aaranya.ui.base.BaseActivity;
import com.tech.aaranya.util.DeviceIdRetervier;
import com.tech.aaranya.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.mobileNo)
    public EditText txtMobileNo;
    @Bind(R.id.password)
    public EditText txtPassword;
    private Firebase myFirebaseRef = null;
    private String deviceId = null;
    private ProgressDialog progressDialog;
    private Context context = this;
    private User user;

    private void navigateToAppRegistration() {
        Intent registerIntent = new Intent(context, RegistrationActivity.class);
        registerIntent.putExtra("user", user);
        startActivity(registerIntent);
        finish();
    }

    /**
     * Show errors to users
     */
    public void showErrorDialog(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        myFirebaseRef = new Firebase(StringConstant.FIREBASE_BASE_URL);
        myFirebaseRef.unauth();
        final AuthData user = myFirebaseRef.getAuth();
        if (user != null) {
            setUserData(myFirebaseRef);
            navigateToAppRegistration();
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        deviceId = DeviceIdRetervier.getDeviceIdAndroid(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        txtPassword.setTypeface(txtMobileNo.getTypeface());
    }

    public void doLogin(View view) {
        boolean validationError = false;
        String username = txtMobileNo.getText().toString();
        String password = txtPassword.getText().toString();

        boolean isUsernameNumeric = Validator.isNumeric(username);

        if (isUsernameNumeric && !Validator.isValidMobileNumber(username)) {
            txtMobileNo.setError(StringConstant.INVALID_MOBILE_NUMBER);
            validationError = true;
        } else if (!isUsernameNumeric && !Validator.isValidEmail(username)) {
            txtMobileNo.setError(StringConstant.INVALID_EMAIL_ID);
            validationError = true;
        }

        if (!Validator.isValidPassword(password)) {
            txtPassword.setError(StringConstant.INVALID_PASSWORD);
            validationError = true;
        }

        if (validationError) {
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(StringConstant.AUTHENTICATING_THE_USER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        myFirebaseRef.authWithPassword(username, password, new AuthResultHandler(StringConstant.PASSWORD));

    }

    private void userRegistrationAction() {
        final Map<String, RegistrationDetail> registrationDetails = user.getRegistrationDetails();
        boolean deviceIdMatchButInactive = false;
        boolean deviceIdMatchButActive = false;
        ArrayList<RegistrationDetail> temporaryRegistrations = new ArrayList<>();
        if (registrationDetails != null && registrationDetails.keySet().size() > 0) {
            for (Map.Entry<String, RegistrationDetail> registration : registrationDetails.entrySet()) {
                final RegistrationDetail value = registration.getValue();
                if (this.deviceId.equals(value.getDeviceId())) {
                    if (!value.isActive()) {
                        deviceIdMatchButInactive = true;
                    } else {
                        deviceIdMatchButActive = true;
                    }
                    if (value.isTemporary()) {
                        temporaryRegistrations.add(value);
                    }
                }
            }
        }

        if (deviceIdMatchButInactive) {
            showErrorDialog("The device is registered but user has been deactivated. Please contact Admin!");
        }

        if (temporaryRegistrations.size() > 0 || (!deviceIdMatchButActive && !deviceIdMatchButInactive)) {
            Intent registerIntent = new Intent(context, RegistrationActivity.class);
            registerIntent.putExtra("user", user);
            registerIntent.putExtra("activeTemporaryRegistration", temporaryRegistrations);
            registerIntent.putExtra("deviceid", this.deviceId);
            startActivity(registerIntent);
            finish();
        } else if (deviceIdMatchButActive) {
            //TODO navigate to orderdetails
//            Intent registerIntent = new Intent(context, RegisterPage.class);
//            startActivity(registerIntent);
//            finish();
        }
    }

    private boolean checkIsActive(List<RegistrationDetail> registrationDetails) {
        boolean active = false;
        if (registrationDetails != null && registrationDetails.size() > 0) {
            for (RegistrationDetail registration : registrationDetails) {
                if (registration.isActive() && deviceId.equals(registration.getDeviceId())) {
                    active = true;
                    break;
                }
            }
        }
        return active;
    }


    /**
     * Utility class for authentication results
     */
    private class AuthResultHandler implements Firebase.AuthResultHandler {


        private final String provider;

        public AuthResultHandler(String provider) {
            this.provider = provider;
        }


        @Override
        public void onAuthenticated(AuthData authData) {
            progressDialog.hide();
            Log.i(TAG, provider + StringConstant.AUTH_SUCCESSFUL);
            final Firebase userRef = new Firebase("https://random12.firebaseio.com/amrit-enterprise/users");
            setUserData(userRef);
            //setAuthticateduser(authData);

        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
            progressDialog.hide();
            String message = firebaseError.getMessage();
            showErrorDialog(message);
        }
    }

    private void setUserData(Firebase userRef) {
        AuthData authData = userRef.getAuth();
        userRef.child(authData.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                userRegistrationAction();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("naren " + firebaseError);
            }
        });
    }
}













































