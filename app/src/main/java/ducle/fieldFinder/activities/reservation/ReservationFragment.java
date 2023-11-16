package ducle.fieldFinder.activities.reservation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ducle.fieldFinder.R;
import ducle.fieldFinder.activities.utils.ActivityUtils;

public class ReservationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText customer = (EditText) view.findViewById(R.id.customerReservation);
        EditText field = (EditText) view.findViewById(R.id.fieldReservation);
        EditText dateReservation = (EditText) view.findViewById(R.id.dateReservation);
        EditText timeslot = (EditText) view.findViewById(R.id.timeReservation);
        Button buttonConfirm = (Button) view.findViewById(R.id.buttonReservationConfirm);
        Button buttonCancel = (Button) view.findViewById(R.id.buttonReservationCancel);

        dateReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.datePickerDialog(getActivity().getSupportFragmentManager());
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        getParentFragmentManager().popBackStack();
    }
}