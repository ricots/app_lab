package com.acer.app_lab;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

/**
 * Created by ACER on 2016-02-06.
 */
public class detail_berita extends Fragment {
    ProgressDialog PD;
    Toolbar toolbar;

    public detail_berita() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_berita_lab, container, false);
        TextView dtl_judul = (TextView) rootView.findViewById(R.id.detail_judul);
        ImageView dtl_gambar = (ImageView) rootView.findViewById(R.id.detail_image_view);
        TextView dtl_kegiatan = (TextView) rootView.findViewById(R.id.detail_kegiatan);
        TextView dtl_tgl = (TextView) rootView.findViewById(R.id.detail_tanggal);

        Bundle bundle = this.getArguments();
        String myInt = bundle.getString(config.KEY_JUDUL);
        String id = bundle.getString(config.KEY_ID);
        String kgt = bundle.getString(config.KEY_DESKIRIPSI);
        String d_tnggl = bundle.getString(config.KEY_TGL);
        String gambr = getArguments().getString(config.KEY_GAMBAR);


        dtl_judul.setText(myInt);
        dtl_kegiatan.setText(id);
        dtl_kegiatan.setText(kgt);
        dtl_tgl.setText(d_tnggl);
        Picasso.with(getActivity()).load(gambr).into(dtl_gambar);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("detail berita");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setHasOptionsMenu(false);

        /*TextView dtl_mulai = (TextView) rootView.findViewById(R.id.jam_mulai);
        TextView dtl_selesai = (TextView) rootView.findViewById(R.id.jam_selesai);
        Intent in = getActivity().getIntent();

        String detail_jdl = in.getStringExtra(config.KEY_JUDUL);
        String detail_keg = in.getStringExtra(config.KEY_DESKIRIPSI);
        String detail_tgl = in.getStringExtra(config.KEY_TGL);
        String detail_mlai = in.getStringExtra(config.KEY_MULAI);
        String detail_finish = in.getStringExtra(config.KEY_SELESAI);

        dtl_judul.setText(detail_jdl);
        dtl_kegiatan.setText(detail_keg);
        dtl_tgl.setText(detail_tgl);
        dtl_mulai.setText(detail_mlai);
        dtl_selesai.setText(detail_finish);
        PD = new ProgressDialog(getActivity());
        PD.setMessage("please wait.....");
        PD.setCancelable(false);*/

        /*imageLoader.get(config.BERITA_URL, new ImageLoader.ImageListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("Image Load Error: ", error.getMessage());
            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null) {
                    // load image into imageview
                    dtl_gambar.setImageBitmap(response.getBitmap());
                }
            }
        });*/
        return rootView;
    }

    /* @Override
     public void onActivityCreated(Bundle bundle){

         TextView dtl_judul = (TextView) getView().findViewById(R.id.detail_judul);
         ImageView dtl_gambar = (ImageView) getView().findViewById(R.id.detail_image_view);
         TextView dtl_kegiatan = (TextView) getView().findViewById(R.id.detail_kegiatan);
         //TextView dtl_tgl = (TextView) getView().findViewById(R.id.detail_tanggal);
         bundle = this.getArguments();
         String myInt = bundle.getString(config.KEY_JUDUL);
         String id = bundle.getString(config.KEY_ID);
         String kgt = bundle.getString(config.KEY_DESKIRIPSI);
         String gambr = getArguments().getString(config.KEY_GAMBAR);
         dtl_judul.setText(myInt);
         dtl_kegiatan.setText(id);
         //dtl_tgl.setText(kgt);
         Picasso.with(getActivity()).load(gambr).into(dtl_gambar);
     }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            getFragmentManager().popBackStack();
            NavUtils.navigateUpFromSameTask(getActivity());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

