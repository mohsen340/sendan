package sendan.sharif.sendan.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.view.my_views.MyViews;


public class FragmentFinance extends Fragment {

  View view;
  Button btn_income, btn_cost;
  TextView txt_transactions;
  Dialog dialog;
  //dialog buttons
  Button btn_ok, btn_cancel;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_finance, container, false);

    btn_income = view.findViewById(R.id.btn_income);
    btn_cost = view.findViewById(R.id.btn_cost);

    btn_income.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          dialog.show();
      }
    });

    btn_cost.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dialog.show();
      }
    });


    txt_transactions = view.findViewById(R.id.txt_transactions);


    //add dialog feature
    dialog = new Dialog(getContext());
    dialog.setContentView(R.layout.custom_dialog_insert_cost);
    btn_ok = dialog.findViewById(R.id.btn_ok);
    btn_cancel = dialog.findViewById(R.id.btn_cancel);
//    dialog.setTitle("");
    btn_ok.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        MyViews.makeText((AppCompatActivity) getActivity(), "درج شد", Toast.LENGTH_SHORT);
      }
    });

    btn_ok.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dialog.dismiss();
      }
    });


    btn_income.setTypeface(MyViews.getIranSansUltraLightFont(getContext()));
    btn_cost.setTypeface(MyViews.getIranSansUltraLightFont(getContext()));
    txt_transactions.setTypeface(MyViews.getIranSansBoldFont(getContext()));

    return view;
  }












}
