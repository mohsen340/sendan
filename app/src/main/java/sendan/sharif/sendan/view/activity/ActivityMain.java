package sendan.sharif.sendan.view.activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.neural_network.Hebb;
import sendan.sharif.sendan.view.fragment.FragmentFinance;
import sendan.sharif.sendan.view.fragment.FragmentIntro1;
import sendan.sharif.sendan.view.fragment.FragmentReport;
import sendan.sharif.sendan.view.fragment.FragmentSuggest;
import sendan.sharif.sendan.view.my_views.MyViews;


public class ActivityMain extends AppCompatActivity {

  Button btn_profile, btn_suggest, btn_report, btn_finance;
  FragmentTransaction ft;
  int current_fragment = 1;
  FrameLayout lyt_action;

  AppBarLayout lyt_toolbar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Hebb hebb = new Hebb();
    hebb.findUsersType();

    btn_profile = (Button) findViewById(R.id.btn_profile);
    btn_suggest = (Button) findViewById(R.id.btn_suggest);
    btn_report = (Button) findViewById(R.id.btn_report);
    btn_finance = (Button) findViewById(R.id.btn_finance);
    lyt_action = (FrameLayout) findViewById(R.id.lyt_action);
    lyt_toolbar = (AppBarLayout) findViewById(R.id.lyt_toolbar);

    setTypeFace();

    ft = getSupportFragmentManager().beginTransaction();
    ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
    ft.replace(R.id.lyt_action, new FragmentFinance());
    ft.commit();
    resetChoose();
    btn_finance.setAlpha(1f);
    Drawable top = getResources().getDrawable(R.drawable.ic_finance_ch);
    btn_finance.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);


    btn_finance.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(current_fragment != 1) {
          current_fragment = 1;
          ft = getSupportFragmentManager().beginTransaction();
          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
          ft.replace(R.id.lyt_action, new FragmentFinance());
          ft.commit();

          resetChoose();
          btn_finance.setAlpha(1f);
          Drawable top = getResources().getDrawable(R.drawable.ic_finance_ch);
          btn_finance.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
        }
      }
    });


    btn_report.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(current_fragment != 2) {
          current_fragment = 2;
          ft = getSupportFragmentManager().beginTransaction();
          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
          ft.replace(R.id.lyt_action, new FragmentReport());
          ft.commit();

          resetChoose();
          btn_report.setAlpha(1f);
          Drawable top = getResources().getDrawable(R.drawable.ic_report_ch);
          btn_report.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
        }
      }
    });

    btn_suggest.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(current_fragment != 3) {
          current_fragment = 3;
          ft = getSupportFragmentManager().beginTransaction();
          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
          ft.replace(R.id.lyt_action, new FragmentSuggest());
          ft.commit();

          resetChoose();
          btn_suggest.setAlpha(1f);
          Drawable top = getResources().getDrawable(R.drawable.ic_offer_ch);
          btn_suggest.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);





        }
      }
    });


    btn_profile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(current_fragment != 4) {
          current_fragment = 4;
//          ft = getSupportFragmentManager().beginTransaction();
//          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
//          ft.replace(R.id.lyt_action, new FragmentFinance());
//          ft.commit();

          resetChoose();
          btn_profile.setAlpha(1f);
          Drawable top = getResources().getDrawable(R.drawable.ic_home_ch);
          btn_profile.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);

        }
      }
    });






  }

  private void setTypeFace(){
    btn_profile.setTypeface(MyViews.getIranSansFont(ActivityMain.this));
    btn_suggest.setTypeface(MyViews.getIranSansFont(ActivityMain.this));
    btn_report.setTypeface(MyViews.getIranSansFont(ActivityMain.this));
    btn_finance.setTypeface(MyViews.getIranSansFont(ActivityMain.this));
  }


  private void resetChoose(){
    btn_finance.setAlpha(0.6f);
    Drawable top1 = getResources().getDrawable(R.drawable.ic_finance);
    btn_finance.setCompoundDrawablesWithIntrinsicBounds(null, top1 , null, null);

    btn_report.setAlpha(0.6f);
    Drawable top2 = getResources().getDrawable(R.drawable.ic_report);
    btn_report.setCompoundDrawablesWithIntrinsicBounds(null, top2 , null, null);

    btn_suggest.setAlpha(0.6f);
    Drawable top3 = getResources().getDrawable(R.drawable.ic_offer);
    btn_suggest.setCompoundDrawablesWithIntrinsicBounds(null, top3 , null, null);

    btn_profile.setAlpha(0.6f);
    Drawable top4 = getResources().getDrawable(R.drawable.ic_home);
    btn_profile.setCompoundDrawablesWithIntrinsicBounds(null, top4 , null, null);
  }


//  private void setActionBar(){
//    lyt_toolbar.setVisibility(View.VISIBLE);
//    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) lyt_action.getLayoutParams();
//    params.setMargins(0, 56, 0, 0);
//    lyt_action.setLayoutParams(params);
//  }
}
