package com.acer.app_lab;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ravi on 29/07/15.
 */
public class BeritaFragment extends Fragment implements FragmentDrawer.FragmentDrawerListener{
    private ProgressDialog dialog;
    private List<Item> array = new ArrayList<Item>();
    private ListView listView;
    private Adapter adapter;
    private static final String TAG = BeritaFragment.class.getSimpleName();
    private int contentView;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    public BeritaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new Adapter(BeritaFragment.this.getActivity(),array);
  //      listView.setAdapter(adapter);

        dialog=new ProgressDialog(getActivity());
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
        long delayInMillis = 1000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, delayInMillis);

        //Creat volley request obj
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(config.BERITA_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();
                //parsing json
                for(int i=0;i<response.length();i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Item item = new Item();
                        item.setJdl(obj.getString(config.KEY_JUDUL));
                        item.setId_kegiatan(obj.getInt(config.KEY_ID));
                        item.setKegiatan(obj.getString(config.KEY_DESKIRIPSI));
                        String tes = obj.getString(config.KEY_TGL);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date tgl_kgt = simpleDateFormat.parse(tes);
                        item.setTgl(tgl_kgt);
                        /*item.setTgl((Date) obj.get(config.KEY_TGL));
                        item.setJam((Time) obj.get(config.KEY_MULAI));
                        item.setJam((Time) obj.get(config.KEY_SELESAI));*/
                        item.setGambar(obj.getString(config.KEY_GAMBAR));

                        array.add(item);
                    } catch (JSONException ex) {
                        ex.printStackTrace();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequesQueue(jsonArrayRequest);
    }
    public void hideDialog(){
        if(dialog !=null){
            dialog.dismiss();
            dialog=null;
        }
    }





    public static BeritaFragment newInstance() {
        BeritaFragment fragment = new BeritaFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_berita, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);
        //adapter=new Adapter(BeritaFragment.this.getActivity(),array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String d_jdl = ((TextView) view.findViewById(R.id.judul)).getText().toString();
                String d_gmbr = ((NetworkImageView) view.findViewById(R.id.image_view)).toString();
                String d_id = ((TextView) view.findViewById(R.id.id_kgt)).getText().toString();
                String d_kgt = ((TextView) view.findViewById(R.id.kegiatan)).getText().toString();
                String d_tngl = ((TextView) view.findViewById(R.id.tanggal)).getText().toString();
                String d_jam = ((TextView) view.findViewById(R.id.jam)).getText().toString();
                String d_slsai = ((TextView) view.findViewById(R.id.slsai)).getText().toString();
                //String title = getString(R.string.app_name);
                Fragment fragment = new detail_berita();
                Bundle bundle = new Bundle();
                bundle.putString(config.KEY_GAMBAR, d_gmbr);
                bundle.putString(config.KEY_JUDUL, d_jdl);
                bundle.putString(config.KEY_ID, d_id);
                bundle.putString(config.KEY_DESKIRIPSI, d_kgt);
                bundle.putString(config.KEY_TGL, d_tngl);
                bundle.putString(config.KEY_MULAI, d_jam);
                bundle.putString(config.KEY_SELESAI, d_slsai);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
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


    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {

    }
}