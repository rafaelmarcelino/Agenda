package br.com.ram_automation.agenda.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.ram_automation.agenda.Model.Student;
import br.com.ram_automation.agenda.R;

import static br.com.ram_automation.agenda.R.drawable.ic_man;
import static br.com.ram_automation.agenda.R.drawable.ic_woman;

public class CustomBaseAdapter extends BaseAdapter {


    private final List <Student> totalStudents;
    private final Context context;

    public CustomBaseAdapter(List<Student> students, Context context) {
        this.totalStudents = students;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.totalStudents.size();
    }

    @Override
    public Object getItem(int position){
        return this.totalStudents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.totalStudents.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = (Activity) context;
        View inflate = activity.getLayoutInflater().inflate(R.layout.list_view_celula, parent,false);

        fillFieldsOfView(inflate,position);

        return inflate;
    }

    @SuppressLint("ResourceAsColor")
    private void fillFieldsOfView(View inflate, int position) {
        ImageView imageView = inflate.findViewById(R.id.lv_image);
        TextView textViewNome = inflate.findViewById(R.id.lv_nome);
        TextView textViewTelefone = inflate.findViewById(R.id.lv_telefone);
        TextView textViewEmail = inflate.findViewById(R.id.lv_email);

        Student student = totalStudents.get(position);
        int color;
        if (student.getGenderStudent()) {
            imageView.setImageResource(ic_man);
            color = Color.parseColor("#008577");
        }else {
            imageView.setImageResource(ic_woman);
            color = Color.parseColor("#D81B60");
        }

        imageView.setColorFilter(color);
        textViewNome.setText(student.getNameStudent());
        textViewTelefone.setText(student.getTelephoneStudent());
        textViewEmail.setText(student.getEmailStudent());
    }

}
