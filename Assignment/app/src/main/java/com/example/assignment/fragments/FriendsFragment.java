package com.example.assignment.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.ContactModel;
import com.example.assignment.R;
import com.example.assignment.RecyclerContactsAdapter;

import java.util.ArrayList;

public class FriendsFragment extends Fragment {


    private static final String TAG = "Contact page";

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        initialize array
        ArrayList<ContactModel> arrayContact = new ArrayList<>();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        RecyclerContactsAdapter contactsAdapter;
//        recycler view
        RecyclerView recyclerView = view.findViewById(R.id.contactRecycler);
//        set linear layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), new String[] {Manifest.permission.READ_CONTACTS}, 0);
        }

//        Initialize uri
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

//        Initialize cursor
        Cursor cursor = requireActivity().getContentResolver().query(uri,
                null,
                null,
                null,
                null);

        Log.d(TAG, "onCreateView: " + cursor.getCount());
//        arrayContact.add(new ContactModel());
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                arrayContact.add(new ContactModel(contactNumber, contactName));
            }
        }

        contactsAdapter = new RecyclerContactsAdapter(getActivity(), arrayContact);
        recyclerView.setAdapter(contactsAdapter);
        cursor.close();

        return view;
    }
}