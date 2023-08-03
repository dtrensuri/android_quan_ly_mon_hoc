package edu.poly.monhocdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.model.ChuongTrinhDaoTao;

public class ChuongTrinhDaoTaoAdapter extends BaseAdapter {
    private Context context;
    private List<ChuongTrinhDaoTao> list;

    public ChuongTrinhDaoTaoAdapter(Context context, List<ChuongTrinhDaoTao> list) {
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
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_qlctdt, null);
        }

        TextView tvChuongTrinhDT = view.findViewById(R.id.tvChuongTrinhDT);
        TextView tvTenChuongTrinhDT = view.findViewById(R.id.tvTenChuongTrinhDT);
        TextView tvSoTinDT = view.findViewById(R.id.tvSoTinDT);
        TextView tvNamBatDauDT = view.findViewById(R.id.tvNamBatDauDT);

        ChuongTrinhDaoTao ctdt = list.get(i);

        tvChuongTrinhDT.setText(ctdt.getIdchuongtrinhdt());
        tvTenChuongTrinhDT.setText(ctdt.getTenchuongtrinhdt());
        tvSoTinDT.setText(String.valueOf(ctdt.getSotinchidt()));
        tvNamBatDauDT.setText(ctdt.getNambatdaudt());
        
        return view;
    }
}