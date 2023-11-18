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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ducle.fieldFinder.AppRepository;
import ducle.fieldFinder.R;
import ducle.fieldFinder.activities.browse.BrowseActivity;
import ducle.fieldFinder.activities.utils.ActivityUtils;
import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.field.Reservation;
import ducle.fieldFinder.models.user.Customer;

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

        TextView reservationId = (TextView) view.findViewById(R.id.reservationId);
        TextView centreData = (TextView) view.findViewById(R.id.centreReservation);
        TextView fieldData = (TextView) view.findViewById(R.id.fieldReservation);
        TextView customerData = (TextView) view.findViewById(R.id.customerReservation);
        EditText dateReservation = (EditText) view.findViewById(R.id.dateReservation);
        AutoCompleteTextView timeslot = (AutoCompleteTextView) view.findViewById(R.id.timeReservation);
        Button buttonConfirm = (Button) view.findViewById(R.id.buttonReservationConfirm);
        Button buttonCancel = (Button) view.findViewById(R.id.buttonReservationCancel);

        Field field;
        Customer customer;

        if(bundle != null){
            getActivity().setTitle("Edit Reservation");
            field = AppRepository.Instance().findField(bundle.getString("fieldId"));
            customer = AppRepository.Instance().getUserManager().getCustomerManager().get(bundle.getString("userId"));
            reservationId.setText(bundle.getString("reservationId"));
            dateReservation.setText(bundle.getString("date"));
            timeslot.setText(bundle.getString("timeslot"));
        }
        else{
            getActivity().setTitle("Make Reservation");
            field = AppRepository.Instance().findField(intent.getStringExtra("fieldId"));
            customer = AppRepository.Instance().getUserManager().getCustomerManager().get(intent.getStringExtra("userId"));
            reservationId.setText(AppRepository.Instance().getReservationManager().nextReservationId());
        }

        centreData.setText(field.getCentre().toString());
        fieldData.setText(field.toString());
        customerData.setText(customer.toString());

        timeslot.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Reservation.TIME_SLOTS));

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