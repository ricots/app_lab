package com.acer.app_lab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ACER on 2016-01-31.
 */
public class Adapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Activity activity;
    private List<Item> items;
    ImageLoader imageLoader=AppController.getInstance().getmImageLoader();
    public Adapter(Activity activity,List<Item> items){
        this.activity=activity;
        this.items=items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView ==null){
            convertView=inflater.inflate(R.layout.list_berita,null);
        }
        if(imageLoader==null);
            imageLoader=AppController.getInstance().getmImageLoader();
        NetworkImageView imageView= (NetworkImageView) convertView.findViewById(R.id.image_view);
        TextView title= (TextView) convertView.findViewById(R.id.judul);
        TextView id= (TextView) convertView.findViewById(R.id.id_kgt);
        TextView desk= (TextView) convertView.findViewById(R.id.kegiatan);
        TextView tgl= (TextView) convertView.findViewById(R.id.tanggal);
        TextView kgt_mlai= (TextView) convertView.findViewById(R.id.jam);
        TextView kgt_slsai= (TextView) convertView.findViewById(R.id.slsai);

        Item item=items.get(position);
        imageView.setImageUrl(item.getGambar(), imageLoader);
        //title
        title.setText(item.getJdl());
        id.setText("" +item.getId_kegiatan());
        desk.setText(item.getKegiatan());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tgl.setText(simpleDateFormat.format(item.getTgl()));
        kgt_mlai.setText((CharSequence) item.getJam());
        kgt_slsai.setText((CharSequence) item.getSelesai());

        TextView nama_ruang= (TextView) convertView.findViewById(R.id.id_kgt);
        TextView kgt_lab= (TextView) convertView.findViewById(R.id.kegiatan_lab);
        TextView jam_lab= (TextView) convertView.findViewById(R.id.jam_lab);
        TextView selesai_lab= (TextView) convertView.findViewById(R.id.slsai_lab);
        TextView prodi_lab= (TextView) convertView.findViewById(R.id.prodi_lab);

        Item it=items.get(position);
        //kgt_lab.setText(it.getKegiatan_lab());
        /*SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        jam_lab.setText(sdf.format(item.getJam_lab()));
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
        selesai_lab.setText(sf.format(item.getSelesai_lab()));*/
        // prodi_lab.setText(it.getProdi());

        return convertView;
    }
}
