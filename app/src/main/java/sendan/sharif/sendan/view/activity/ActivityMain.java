package sendan.sharif.sendan.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.view.fragment.FragmentFinance;
import sendan.sharif.sendan.view.fragment.FragmentIntro1;
import sendan.sharif.sendan.view.my_views.MyViews;


public class ActivityMain extends AppCompatActivity {

  Button btn_profile, btn_suggest, btn_report, btn_finance;
  FragmentTransaction ft;
  int current_fragment = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btn_profile = (Button) findViewById(R.id.btn_profile);
    btn_suggest = (Button) findViewById(R.id.btn_suggest);
    btn_report = (Button) findViewById(R.id.btn_report);
    btn_finance = (Button) findViewById(R.id.btn_finance);

    setTypeFace();

    ft = getSupportFragmentManager().beginTransaction();
    ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
    ft.replace(R.id.lyt_action, new FragmentFinance());
    ft.commit();


    btn_finance.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(current_fragment != 1) {
          ft = getSupportFragmentManager().beginTransaction();
          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
          ft.replace(R.id.lyt_action, new FragmentFinance());
          ft.commit();
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
}
