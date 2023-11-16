package ducle.fieldFinder.activities.reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ducle.fieldFinder.AppRepository;
import ducle.fieldFinder.R;
import ducle.fieldFinder.models.field.Reservation;

public class ReservationBrowseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation_browse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Intent intent = getActivity().getIntent();

        ListView reservationListView = (ListView) view.findViewById(R.id.browseReservationListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, AppRepository.Instance().reservationsList(intent.getStringExtra("userId")));
        reservationListView.setAdapter(arrayAdapter);

        reservationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long id) {
                Reservation reservation = (Reservation) adapterView.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putString("reservationId", reservation.getId());
                bundle.putString("userId", reservation.getCustomer().getId());
                bundle.putString("fieldId", reservation.getField().getId());
                bundle.putString("date", reservation.getDate());
                bundle.putString("timeslot", reservation.getTimeslot());

                ReservationEditFragment reservationEditFragment = new ReservationEditFragment();
                reservationEditFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.manageReservationFragmentFl, reservationEditFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void popStack(){
        getParentFragmentManager().popBackStack();
    }
}