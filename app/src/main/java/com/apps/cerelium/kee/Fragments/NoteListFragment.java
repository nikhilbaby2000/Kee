package com.apps.cerelium.kee.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.apps.cerelium.kee.ListAdapters.NoteListAdapter;
import com.apps.cerelium.kee.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NoteListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NoteListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteListFragment extends Fragment {

    NoteListAdapter noteListAdapter;

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        try {


            noteListAdapter = new NoteListAdapter(getActivity().getApplicationContext());
            ListView listView = (ListView) view.findViewById(R.id.listView);
            listView.setAdapter(noteListAdapter);



        }
        catch (Exception e) {}

        // Inflate the layout for this fragment
        return view;
    }



}
