package br.com.ram_automation.agenda.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

import static br.com.ram_automation.agenda.R.drawable.ic_man;
import static br.com.ram_automation.agenda.R.drawable.ic_woman;

public class CustomBaseAdapter extends BaseAdapter {


    private final List<Aluno> totalAlunos;
    private final Context context;

    public CustomBaseAdapter(List<Aluno> alunos, Context context) {
        this.totalAlunos  = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.totalAlunos.size();
    }

    @Override
    public Object getItem(int position){
        return this.totalAlunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = (Activity) context;
        View inflate = activity.getLayoutInflater().inflate(R.layout.list_view_celula, parent,false);

        fillFieldsOfView(inflate,position);

        return inflate;
    }

    private void fillFieldsOfView(View inflate, int position) {
        ImageView imageView = inflate.findViewById(R.id.lv_image);
        TextView textViewNome = inflate.findViewById(R.id.lv_nome);
        TextView textViewTelefone = inflate.findViewById(R.id.lv_telefone);
        TextView textViewEmail = inflate.findViewById(R.id.lv_email);

        Aluno aluno = totalAlunos.get(position);

        if (aluno.getSexoAluno()) {
            imageView.setImageResource(ic_man);
        }else {
            imageView.setImageResource(ic_woman);
        }

        textViewNome.setText(aluno.getNomeAluno());
        textViewTelefone.setText(aluno.getTelefoneAluno());
        textViewEmail.setText(aluno.getEmailAluno());


    }
}