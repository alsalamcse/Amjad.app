package com.draz.amjad.amjadapp.myFragments;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.draz.amjad.amjadapp.R;
import com.draz.amjad.amjadapp.data.Proudct;

/**
 * Created by user on 05/03/2018.
 */

public class ProudctAdapter extends ArrayAdapter<Proudct> {
    public ProudctAdapter(@NonNull Context context, @LayoutRes int resource)
    {
        super(context, resource);
    }

    /**
     *
     * @param position the index of one data item from the data source. starting from
     * @param convertView
     * todo הממשק שיכול להציג את אוסף ניתונים לדוגמה
     * @param parent
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.proudctitem,parent,false);
        TextView tvName= view.findViewById(R.id.itmTvName);
        TextView tvPrice= view.findViewById(R.id.itmTvPrice);
        TextView tvAmount= view.findViewById(R.id.itmTvAmount);
        ImageView tvImage=view.findViewById(R.id.itmImage);
        CheckBox chxcompleted=view.findViewById(R.id.itmChblsCompleted);
        Proudct p=getItem(position);
        tvName.setText(p.getMainMeal());
        tvPrice.setText(p.getDrinks()+"");
        tvAmount.setText(p.getSecondMeal()+"");
        chxcompleted.setChecked(p.isCompleted());
        return view;
    }

}
