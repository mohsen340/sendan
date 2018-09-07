package sendan.sharif.sendan.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.adapter.ClassificationAdapter;
import sendan.sharif.sendan.view.my_views.MyViews;


public class FragmentSuggest extends Fragment {

  ViewPager viewPager;
  ClassificationAdapter adapter;
  TabLayout tabLayout;
   int item;

  View view;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_suggest, container, false);


    tabLayout = view.findViewById(R.id.tab_layout);
    viewPager = view.findViewById(R.id.view_pager);


    setViewPager();
    tabLayout.setupWithViewPager(viewPager);


    for (int i = 0; i < tabLayout.getTabCount(); i++) {
      TextView tv = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_custom_tab, null);
      tv.setTypeface(MyViews.getIranSansLightFont(getContext()));
//      tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
      tabLayout.getTabAt(i).setCustomView(tv);
    }
    return view;
  }










  private void setViewPager() {

//    adapter = new ClassificationAdapter(getActivity().getSupportFragmentManager());
    adapter = new ClassificationAdapter(this.getFragmentManager());
    viewPager.setAdapter(adapter);
//    viewPager.setCurrentItem(2);


  }




}
