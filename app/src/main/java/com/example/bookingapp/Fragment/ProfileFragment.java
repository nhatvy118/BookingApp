package com.example.bookingapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingapp.R;
import com.example.bookingapp.SignInScreen;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {


    private TextView ProfileInfo;
    private TextView profilePayment;
    private TextView profileSave;
    private TextView profileSetting;
    private TextView profileHistory;
    private TextView profileName;
    private SharedPreferences pref;

    public ProfileFragment() {
        // Required empty public constructor
    }

    private static final String ARG_FIRST_NAME = "argFirstName";
    private static final String ARG_IMAGE_URI = "argImageUri";
    private  String name;
    private String uri;
    private ShapeableImageView profileImage;
    private Button end;

    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String Name, String imageUri) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FIRST_NAME, Name);
        args.putString(ARG_IMAGE_URI, imageUri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_FIRST_NAME);
            uri = getArguments().getString(ARG_IMAGE_URI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ProfileInfo = view.findViewById(R.id.personal_information);
        profilePayment = view.findViewById(R.id.payment_and_cards);
        profileSave = view.findViewById(R.id.saved);
        profileSetting = view.findViewById(R.id.settings);
        profileHistory = view.findViewById(R.id.booking_history);

        profileName = view.findViewById(R.id.profile_name);
        profileName.setText(name);
        profileImage = view.findViewById(R.id.profile_image);
        if (!Objects.equals(uri, "Default")) {
            profileImage.setImageURI(Uri.parse(uri));
        }
        end = view.findViewById(R.id.end_session);
        end.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent = new Intent(getActivity(), SignInScreen.class);
                                       startActivity(intent);

                                   }
                               });

        ProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref = getActivity().getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
                String firstName = pref.getString("FirstName", "");
                String lastName = pref.getString("LastName", "");
                String phone = pref.getString("PhoneNumber", "");
                String email = pref.getString("Email", "");
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, com.example.bookingapp.Fragment.ProfileInfo.newInstance(firstName,lastName,phone,email,uri));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        profilePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This function will be developed", Toast.LENGTH_SHORT).show();
            }
        });
        profileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This function will be developed", Toast.LENGTH_SHORT).show();
            }

        });
        profileHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This function will be developed", Toast.LENGTH_SHORT).show();
            }
        });
        profileSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This function will be developed", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}