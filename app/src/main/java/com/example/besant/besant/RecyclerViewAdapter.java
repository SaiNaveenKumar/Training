package com.example.besant.besant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sai Naveen Kumar on 9/7/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<Dataprovider> arrayList=new ArrayList<Dataprovider>();

    public RecyclerViewAdapter(RecyclerViewActivity recyclerViewActivity, ArrayList<Dataprovider> arrayList)
    {
       this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {
        Dataprovider dataprovider=arrayList.get(position);
        holder.imageView.setImageResource(dataprovider.getImg_res());
        holder.itemname.setText(dataprovider.getItem_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView itemname;

        public RecyclerViewHolder(View view)
        {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.carimage);
            itemname=(TextView)view.findViewById(R.id.carname);

        }

    }
}
