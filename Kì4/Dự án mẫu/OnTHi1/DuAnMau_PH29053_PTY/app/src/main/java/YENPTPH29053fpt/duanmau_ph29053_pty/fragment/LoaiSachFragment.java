package YENPTPH29053fpt.duanmau_ph29053_pty.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import YENPTPH29053fpt.duanmau_ph29053_pty.DAO.LoaiSachDao;
import YENPTPH29053fpt.duanmau_ph29053_pty.DTO.LoaiSach;
import YENPTPH29053fpt.duanmau_ph29053_pty.R;
import YENPTPH29053fpt.duanmau_ph29053_pty.adapter.LoaiSachAdapter;


public class LoaiSachFragment extends Fragment {
    ListView lv;
    ArrayList<LoaiSach> list;
    FloatingActionButton fab,fab_searh;
    Dialog dialog;
    EditText edMaLoaiSach, edTenLoaiSach,edNhaCungCap;
    Button btnLuu, btnHuy;

    static LoaiSachDao dao;
    LoaiSachAdapter adapter;
    LoaiSach item;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loai_sach, container, false);
        lv = view.findViewById(R.id.lvLoaiSach);
        fab = view.findViewById(R.id.fab_add_LoaiSach);
        fab_searh=view.findViewById(R.id.fab_search);
        dao = new LoaiSachDao(getActivity());
        capNhatLv();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity(), 0);
            }
        });

        fab_searh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimKiem(getActivity());
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = list.get(i);
                openDialog(getActivity(), 1);
                return false;
            }
        });
        return view;
    }

    protected void openDialog(final Context context, final int type) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_loai_sach);

        edMaLoaiSach = dialog.findViewById(R.id.edMaLoaiSach);
        edTenLoaiSach = dialog.findViewById(R.id.edTenLoaiSach);
        edNhaCungCap = dialog.findViewById(R.id.edNhaCungCap);

        btnHuy = dialog.findViewById(R.id.btnHuyLS);
        btnLuu = dialog.findViewById(R.id.btnLuuLS);

        edMaLoaiSach.setEnabled(false);
        if (type != 0){
            edMaLoaiSach.setText( String.valueOf(item.maLoai));
            edTenLoaiSach.setText( item.tenLoai );
            edNhaCungCap.setText(item.nhaCungCap);
        }
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = new LoaiSach();
                item.tenLoai = edTenLoaiSach.getText().toString();
                item.nhaCungCap = edNhaCungCap.getText().toString();
                if (validate() >0){
                    if (type == 0){
                        if ( dao.insertLoaiSach(item) >0){
                            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        item.maLoai = Integer.parseInt( edMaLoaiSach.getText().toString());
                        if (dao.updateLoaiSach(item) >0){
                            Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, "Sửa không thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                    capNhatLv();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }


    public void xoa(final String id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có chắc chắn muốn xóa?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (dao.deleteLoaiSach(id) >0){
                    capNhatLv();
                    Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();
                }
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        builder.show();
    }
    void capNhatLv(){
        list = (ArrayList<LoaiSach>) dao.getAll();
        adapter = new LoaiSachAdapter(getActivity(), this, list);
        lv.setAdapter(adapter);
    }
    public int validate(){
        int check = 1;
        if (edTenLoaiSach.getText().toString().length() == 0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

    protected void TimKiem(final Context context){
        dialog=new Dialog(context);//khởi tạo dialog
        dialog.setContentView(R.layout.dialog_search);// set dialog layout

        EditText ednhaCungCap = dialog.findViewById(R.id.ednhaCungCap_search);
        Button btnTimKiem = dialog.findViewById(R.id.btnTimKiem);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();//bấm vào nút huỷ xong sẽ tắt

            }
        });
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nhaCungCap = ednhaCungCap.getText().toString();
                if(ednhaCungCap.getText().toString().equals("")){
                    Toast.makeText(context, "Nhap ten nha cung cap", Toast.LENGTH_SHORT).show();
                }else{
                    dao.getNhaCC(nhaCungCap);
                    capNhat(nhaCungCap);
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    void capNhat (String nhaCC){
        list = (ArrayList<LoaiSach>) dao.getNhaCC(nhaCC);
        adapter = new LoaiSachAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
    }
}
