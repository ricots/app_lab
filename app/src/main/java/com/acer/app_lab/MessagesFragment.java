package com.acer.app_lab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ravi on 29/07/15.
 */
public class MessagesFragment extends Fragment {

    public MessagesFragment() {
        // Required empty public constructor
    }

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml initialization
          // static initialization
         }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_messages, container, false);

        Button in1 = (Button) rootView.findViewById(R.id.inet1);
        Button in2 = (Button) rootView.findViewById(R.id.inet2);
        Button ap1 = (Button) rootView.findViewById(R.id.apli1);
        Button ap2 = (Button) rootView.findViewById(R.id.apli2);
        Button ap3 = (Button) rootView.findViewById(R.id.apli3);
        /*MaterialRippleLayout.on(in1)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();*/

        in1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new detail_jadwal();
                String kata1 = "Lab Internet 1";
                Bundle bundle = new Bundle();
                bundle.putString("btn",kata1);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                // title = "detail berita";
                fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
            }
        });

        in2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new detail_jadwal();
                String kata2 = "Lab Internet 2";
                Bundle bundle = new Bundle();
                bundle.putString("btn",kata2);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                // title = "detail berita";
                fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
            }
        });

        ap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new detail_jadwal();
                String kata3 = "Lab Aplikasi 1";
                Bundle bundle = new Bundle();
                bundle.putString("btn",kata3);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                // title = "detail berita";
                fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
            }
        });

        ap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new detail_jadwal();
                String kata4 = "Lab Aplikasi 2";
                Bundle bundle = new Bundle();
                bundle.putString("btn",kata4);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                // title = "detail berita";
                fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
            }
        });

        ap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new detail_jadwal();
                String kata5 = "Lab Aplikasi 3";
                Bundle bundle = new Bundle();
                bundle.putString("btn",kata5);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                // title = "detail berita";
                fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

   @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
