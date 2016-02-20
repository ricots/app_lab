package com.acer.app_lab;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ACER on 2016-02-11.
 */
public class detail_jadwal extends Fragment {
    private ProgressDialog dialog;
    private List<Item> array = new ArrayList<Item>();
    private ListView listView_jadwal;
    private Adapter adapter;
    private static final String TAG = detail_jadwal.class.getSimpleName();
    private int contentView;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    TextView lokasi;
    private String JSON_STRING;

    public detail_jadwal(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new Adapter(detail_jadwal.this.getActivity(),array);
        //      listView.setAdapter(adapter);

        dialog=new ProgressDialog(getActivity());
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
        long delayInMillis = 5000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, delayInMillis);

        String url = config.JADWAL + lokasi;
                //Creat volley request obj
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();
                //parsing json
                for(int i=0;i<response.length();i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Item item = new Item();
                        item.setKegiatan_lab(obj.getString(config.KEY_KEGIATAN_LAB));
                        item.setProdi(obj.getString(config.KEY_PRODI_LAB));


                        array.add(item);
                    } catch (JSONException ex) {
                        ex.printStackTrace();


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.jadwal, container, false);
        listView_jadwal = (ListView) rootView.findViewById(R.id.list_jadwal);
        //adapter=new Adapter(detail_jadwal.this.getActivity(),array);
        listView_jadwal.setAdapter(adapter);

        Bundle bundle = this.getArguments();
        String t = bundle.getString("btn");
        lokasi = (TextView) rootView.findViewById(R.id.tempat);
        lokasi.setText(t);
        return rootView;
    }

    /*private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(config.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String lab_kgt = jo.getString(config.KEY_KEGIATAN_LAB);

                HashMap<String,String> lab = new HashMap<>();
                lab.put(config.KEY_KEGIATAN_LAB,lab_kgt);
                list.add(lab);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                detail_jadwal.this, list, R.layout.detail_berita_lab,
                new String[]{config.KEY_KEGIATAN_LAB},
                new int[]{R.id.detail_kegiatan, R.id.tv_author});

        listView_jadwal.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(detail_jadwal.this,"Fetching Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(url_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }*/
}
