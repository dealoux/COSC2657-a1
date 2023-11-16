package ducle.fieldFinder.activities.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ducle.fieldFinder.R;
import ducle.fieldFinder.activities.browse.BrowseActivity;
import ducle.fieldFinder.activities.login.LoginActivity;
import ducle.fieldFinder.activities.reservation.ReservationActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String username = (String) intent.getExtras().get("username");
        String password = (String) intent.getExtras().get("password");
        String response = (String) intent.getExtras().get("response");

        String text = response + ": " + username + " (" + password + ")";
        Toast.makeText(HomeActivity.this, text, Toast.LENGTH_LONG).show();

        Button buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
                intent1.putExtra("response", "Logged out");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                    }
                });

        Button buttonHomeBrowse = (Button) findViewById(R.id.buttonHomeBrowse);
        buttonHomeBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, BrowseActivity.class);
                launcher.launch(intent1);
            }
        });

        Button buttonHomeReservations = (Button) findViewById(R.id.buttonHomeReservation);
        buttonHomeReservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, ReservationActivity.class);
                launcher.launch(intent1);
            }
        });
    }
}