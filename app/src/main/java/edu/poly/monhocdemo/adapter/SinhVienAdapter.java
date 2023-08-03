package edu.poly.monhocdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.poly.monhocdemo.R;
import edu.poly.monhocdemo.helper.DataTimeHelper;

import edu.poly.monhocdemo.model.SinhVien;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> list;

    public SinhVienAdapter(Context context, List<SinhVien> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_item_qlsv, null);
        }
        TextView tvIdSV = view.findViewById(R.id.tvIdSV);
        TextView tvHoTensv = view.findViewById(R.id.tvHoTensv);
        TextView tvGioiTinhsv = view.findViewById(R.id.tvGioiTinhsv);
        TextView tvNgaySinhsv = view.findViewById(R.id.tvNgaySinhsv);
        TextView tvDiaChisv = view.findViewById(R.id.tvDiaChisv);
        TextView tvGmailsv = view.findViewById(R.id.tvGmailsv);
        TextView tvSDTsv = view.findViewById(R.id.tvSDTsv);

        SinhVien sv = list.get(i);

        tvIdSV.setText(sv.getIdsinhvien());
        tvHoTensv.setText(sv.getHotensv());
        tvGioiTinhsv.setText(sv.getGioitinhsv());
        tvNgaySinhsv.setText(DataTimeHelper.toString(sv.getNgaysinhsv()));
        tvDiaChisv.setText(sv.getDiachisv());
        tvGmailsv.setText(sv.getGmailsv());
        tvSDTsv.setText(sv.getSdtsv());

        return view;
    }
}
