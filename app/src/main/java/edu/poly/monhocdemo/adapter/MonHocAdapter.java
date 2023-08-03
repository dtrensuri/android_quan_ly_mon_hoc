package edu.poly.monhocdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.model.MonHoc;

public class MonHocAdapter extends BaseAdapter {
    private Context context;
    private List<MonHoc> list;

    public MonHocAdapter(Context context, List<MonHoc> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_qlmh, null);
        }
        TextView tvIdmonhoc = view.findViewById(R.id.tvIdmonhoc);
        TextView tvTenmh = view.findViewById(R.id.tvTenmh);
        TextView tvSotin = view.findViewById(R.id.tvSotin);
        TextView tvMuctieudaura = view.findViewById(R.id.tvMuctieudaura);
        TextView tvHinhthucdanhgia = view.findViewById(R.id.tvHinhthucdanhgia);
        TextView tvNganh = view.findViewById(R.id.tvNganh);

        MonHoc mh = list.get(i);
        tvIdmonhoc.setText(mh.getIdmonhoc());
        tvTenmh.setText(mh.getTenmh());
        tvSotin.setText(mh.getSotin().toString());
        tvMuctieudaura.setText(mh.getMuctieudaura());
        tvHinhthucdanhgia.setText(mh.getHinhthucdanhgia());
        tvNganh.setText(mh.getNganh());

        return view;
    }
}
