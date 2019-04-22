package com.example.jadzan.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jadzan.R;
import com.example.jadzan.data.model.JadzanResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.jadzan.data.model.JadzanResponse.*;

public class JadzanAdapter extends RecyclerView.Adapter<JadzanAdapter.CustomViewHolder> {

    private List<DataBean> data;

    public JadzanAdapter (List<DataBean> dataBeans){

        this.data = dataBeans;
    }


    @NonNull
    @Override
    public JadzanAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jadzanlist, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        DataBean dataBean = data.get(position);
        holder.title.setText(dataBean.getDate().getGregorian().getWeekday().getEn());
        holder.date.setText(dataBean.getDate().getReadable());
        holder.time.setText(dataBean.getTimings().getFajr());
        holder.hijriah.setText(dataBean.getDate().getHijri().getDate());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView time, date, title, hijriah;

        public CustomViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.setnya);
            time = view.findViewById(R.id.waktu);
            date = view.findViewById(R.id.date);
            hijriah = view.findViewById(R.id.hijri);
        }
    }
}


