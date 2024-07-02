package com.example.bookingapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bookingapp.HomePage;
import com.example.bookingapp.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView transportButton;
    private TextInputEditText searchBarEditText;

    public HomePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        transportButton = view.findViewById(R.id.transport);
        searchBarEditText = view.findViewById(R.id.textInputEditText);
        transportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((HomePage) requireActivity()).navigateToBookingFragment();
                TransportBooking transportBookingFragment = new TransportBooking();

                // Pass the name of the previous fragment as an argument
                Bundle args = new Bundle();
                args.putString("previous_fragment", "HomePageFragment");
                transportBookingFragment.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).
                        replace(R.id.fragment_container, transportBookingFragment,null).
                        addToBackStack(null).commit();
            }
        });
        ImageView searchBtn = view.findViewById(R.id.search_icon);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchDialog();
            }
        });

        return view;
    }
    private void showSearchDialog() {
        if (searchBarEditText != null) {
            String searchText = searchBarEditText.getText().toString().trim();
            if (!searchText.isEmpty()) {
                new MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Search not found")
                        .setMessage("You searched for: " + searchText)
                        .setPositiveButton("OK", null)
                        .show();
            } else {
                Toast.makeText(requireContext(), "Please enter a search query.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}