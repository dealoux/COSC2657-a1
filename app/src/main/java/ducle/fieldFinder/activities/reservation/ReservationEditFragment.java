package ducle.fieldFinder.activities.reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ducle.fieldFinder.AppRepository;
import ducle.fieldFinder.R;
import ducle.fieldFinder.activities.browse.BrowseActivity;
import ducle.fieldFinder.activities.utils.ActivityUtils;
import ducle.fieldFinder.models.field.Reservation;

public class ReservationEditFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_reservation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Intent intent = getActivity().getIntent();
        Bundle bundle = getArguments();

        EditText reservationId = (EditText) view.findViewById(R.id.reservationId);
        EditText customerData = (EditText) view.findViewById(R.id.customerReservation);
        EditText fieldData = (EditText) view.findViewById(R.id.fieldReservation);
        EditText dateReservation = (EditText) view.findViewById(R.id.dateReservation);
        AutoCompleteTextView timeslot = (AutoCompleteTextView) view.findViewById(R.id.timeReservation);
        Button buttonConfirm = (Button) view.findViewById(R.id.buttonReservationConfirm);
        Button buttonCancel = (Button) view.findViewById(R.id.buttonReservationCancel);

        if(bundle != null){
            reservationId.setText(bundle.getString("reservationId"));
            customerData.setText(bundle.getString("userId"));
            fieldData.setText(bundle.getString("fieldId"));
            dateReservation.setText(bundle.getString("date"));
            timeslot.setText(bundle.getString("timeslot"));
        }
        else{
            reservationId.setText(AppRepository.Instance().getReservationManager().nextReservationId());
            customerData.setText(intent.getStringExtra("userId"));
            fieldData.setText(intent.getStringExtra("fieldId"));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Reservation.TIME_SLOTS);
        timeslot.setAdapter(adapter);

        dateReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.datePickerDialog(getActivity().getSupportFragmentManager());
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bundle == null){
                    String result = AppRepository.Instance().getReservationManager().addReservation(
                            reservationId.getText().toString(), intent.getStringExtra("userId"), intent.getStringExtra("fieldId"),
                            dateReservation.getText().toString(), timeslot.getText().toString());

                    Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                }

                popStack();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popStack();
            }
        });
    }

    private void popStack(){
//        Intent intent1 = new Intent(getActivity(), BrowseActivity.class);
//        getActivity().setResult(getActivity().RESULT_OK, intent1);
        getActivity().finish();
    }
}