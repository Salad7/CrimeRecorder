package com.example.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CrimeListFragment extends Fragment {

    private RecyclerView recyclerView;
    private CrimeAdapter crimeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_list,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return  v;
    }

    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        crimeAdapter = new CrimeAdapter(crimeLab.getCrimes());
        recyclerView.setAdapter(crimeAdapter);
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> crimes;
        public CrimeAdapter(List<Crime> crimes){
            this.crimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.list_item_crime, parent, false);




            return new CrimeHolder(v);

        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = crimes.get(position);
            holder.bindCrime(crime);



        }

        @Override
        public int getItemCount() {
            return crimes.size();
        }
    }

    private class CrimeHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView date;
        public CheckBox check;
        public CrimeHolder(View itemView){
            super(itemView);
             title = (TextView) itemView.findViewById(R.id.list_crime_title);
             date = (TextView) itemView.findViewById(R.id.list_crime_date);
             check = (CheckBox) itemView.findViewById(R.id.list_crime_issolved);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(getContext(),CrimeActivity.class);
                     intent.putExtra("KEY",title.getText());
                     startActivity(intent);
                 }
             });
        }



        public void bindCrime(Crime c){
            title.setText(c.getTitle());
            check.setChecked(c.isSolved());
            date.setText(c.getDate().toString());
        }



    }
}
