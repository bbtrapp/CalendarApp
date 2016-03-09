package com.example.bradley.calendarapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.io.*;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DayFragment extends Fragment{


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DATE = "dateParam";
    private static final String TITLE = "titleParam";
    private static final String TIME = "timeParam";
    private static final String WHAT = "whatParam";

    private OnFragmentInteractionListener mListener;

    private String mParamDate;
    private String mParamTitle;
    private String mParamTime;
    private String mParamWhat;
    private String FILENAME = "calFile";
    FileOutputStream fOS;


    private TextView d;
    private ListView listView;
    private Button calendar;
    private Button edit;
    public DayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment DayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DayFragment newInstance(String param1, String param2, String param3, String param4) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putString(DATE, param1);
        args.putString(TITLE, param2);
        args.putString(TIME, param2);
        args.putString(WHAT, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamDate = getArguments().getString(DATE);
            mParamTitle = getArguments().getString(TITLE);
            mParamTime = getArguments().getString(TIME);
            mParamWhat = getArguments().getString(WHAT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //TODO file stuff
        String line = null;
        try{
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                //read in events
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            FILENAME + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + FILENAME + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }



        View view = inflater.inflate(R.layout.fragment_day, container, false);
        d = (TextView) view.findViewById(R.id.Date);
        d.setText(mParamDate);
        edit = (Button) view.findViewById(R.id.Edit);
        calendar = (Button) view.findViewById(R.id.Back);
        listView = (ListView)view.findViewById((R.id.LISTVIEW));
        //TODO handle the whats possible editing a file
        /*if(mParamWhat.equals("add")){

        }
        else if(mParamWhat.equals("delete")){

        }
        else if(mParamWhat.equals("edit")){

        }
        */
        //TODO fill in listview using file
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //question answer
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.main_fragment_container, CalendarFragment.newInstance(mParamDate, "take out this param"))
                        .commit();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.main_fragment_container, EditFragment.newInstance(mParamDate, "take out this param"))
                        .commit();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
