package ducle.fieldFinder.activities.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ducle.fieldFinder.R;
import ducle.fieldFinder.activities.browse.BrowseActivity;
import ducle.fieldFinder.activities.login.LoginActivity;
import ducle.fieldFinder.activities.reservation.ManageReservationActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        String userId = (String) intent.getExtras().get("userId");
        String userFname = (String) intent.getExtras().get("userFname");

        setTitle("Welcome " + userFname);

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
                intent1.putExtras(intent);
                launcher.launch(intent1);
            }
        });

        Button buttonHomeReservations = (Button) findViewById(R.id.buttonHomeReservation);
        buttonHomeReservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, ManageReservationActivity.class);
                intent1.putExtras(intent);
                launcher.launch(intent1);
            }
        });
    }
}