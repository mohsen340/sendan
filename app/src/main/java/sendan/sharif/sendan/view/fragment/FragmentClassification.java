package sendan.sharif.sendan.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.adapter.AdapterRecycler;
import sendan.sharif.sendan.model.Order;


public class FragmentClassification extends Fragment {

  View view;
  RecyclerView rcv_classification;
  int item;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_classification, container, false);

    setRecyclerView();
    fillRecyclerView();





    return view;
  }



  private void setRecyclerView(){
    rcv_classification = view.findViewById(R.id.rcv_classification);
    rcv_classification.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
    rcv_classification.setHasFixedSize(true);

  }

  private void fillRecyclerView(){
    List<Order> orders = Order.getFakeData();
    AdapterRecycler listAdapter = new AdapterRecycler(getContext(), orders);
//    SlideInBottomAnimationAdapter alphaAdapter = new SlideInBottomAnimationAdapter(listAdapter);
//    recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));

    rcv_classification.setAdapter(listAdapter);
  }




  public void setItem(int item){
    this.item = item;
  }





}
