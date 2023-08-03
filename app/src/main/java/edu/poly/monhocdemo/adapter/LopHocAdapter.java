package edu.poly.monhocdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.model.LopHoc;

public class LopHocAdapter extends BaseAdapter {
    private Context context;
    private List<LopHoc> list;

    public LopHocAdapter(Context context, List<LopHoc> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_item_qllh, null);
        }

        TextView tvLopId = view.findViewById(R.id.tvLopId);
        TextView tvTenLop = view.findViewById(R.id.tvTenLop);
        TextView tvPhongHoc = view.findViewById(R.id.tvPhongHoc);
        TextView tvDiaChiLH = view.findViewById(R.id.tvDiaChiLH);

        LopHoc cls = list.get(i);
        tvLopId.setText(""+cls.getId());
        tvTenLop.setText(""+cls.getTenlop());
        tvPhongHoc.setText(""+cls.getPhonghoc());
        tvDiaChiLH.setText(cls.getDiachi());
        return view;
    }
}