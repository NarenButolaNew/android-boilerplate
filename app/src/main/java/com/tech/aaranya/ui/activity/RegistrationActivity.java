package com.tech.aaranya.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.tech.aaranya.R;
import com.tech.aaranya.data.model.RegistrationDetail;
import com.tech.aaranya.data.model.User;

import java.util.Date;

import butterknife.Bind;


public class RegistrationActivity extends AppCompatActivity {
    @Bind(R.id.app_bar)
    public Toolbar toolbar;
    private User user;
    private String deviceid = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setSupportActionBar(toolbar);

        user = (User) getIntent().getSerializableExtra("user");
        deviceid = (String) getIntent().getExtras().get("deviceid");

        final TextView viewById = (TextView) findViewById(R.id.usernameText);
        viewById.setText(user.nameDisplay() + deviceid);
        System.out.println("Temporary Registration : " + getIntent().getExtras().get("activeTemporaryRegistration"));
    }

    public void register(View view) {
        final Firebase userRef = new Firebase("https://random12.firebaseio.com/amrit-enterprise/users");
        Firebase registrationRef = userRef.child(userRef.getAuth().getUid()).child("registrationDetails");
        RegistrationDetail registrationDetail = new RegistrationDetail();
        registrationDetail.setActivationDate(new Date());
        registrationDetail.setDeviceId(this.deviceid);
        registrationDetail.setActive(true);
        registrationDetail.setTemporary(false);
        registrationRef.push().setValue(registrationDetail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.register_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int res_id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_dropdown1:
                Toast.makeText(getApplicationContext(), "You have selected logout", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
