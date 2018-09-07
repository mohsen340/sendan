package sendan.sharif.sendan.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import sendan.sharif.sendan.view.fragment.FragmentClassification;


public class ClassificationAdapter extends FragmentPagerAdapter {

  Context context;

  public ClassificationAdapter(FragmentManager fm) {
    super(fm);
  }

  public ClassificationAdapter(FragmentManager fm , Context context) {
    super(fm);
    this.context=context;
  }





  @Override
  public Fragment getItem(int position) {
    FragmentClassification fragment = new FragmentClassification();
    fragment.setItem(position);
    return fragment;
  }


  @Override
  public int getCount() {
    return 3;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "پوشاک";
      case 1:
        return "خوراک";
      case 2:
        return "تفریح";
      default:
        return "";
    }




  }





}

