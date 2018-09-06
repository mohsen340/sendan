package sendan.sharif.sendan.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.view.my_views.MyViews;


public class FragmentFinance extends Fragment {

  View view;
  Button btn_income, btn_cost;
  TextView txt_transactions;
  Dialog dialog;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_finance, container, false);

    btn_income = view.findViewById(R.id.btn_income);
    btn_cost = view.findViewById(R.id.btn_cost);
    txt_transactions = view.findViewById(R.id.txt_transactions);

    dialog = new Dialog(getContext());
    dialog.setContentView(R.layout.custom_dialog_insert_cost);
    dialog.setTitle("درج");

    btn_income.setTypeface(MyViews.getIranSansUltraLightFont(getContext()));
    btn_cost.setTypeface(MyViews.getIranSansUltraLightFont(getContext()));
    txt_transactions.setTypeface(MyViews.getIranSansBoldFont(getContext()));

    return view;
  }












}
