package sendan.sharif.sendan.view.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.view.fragment.FragmentIntro1;
import sendan.sharif.sendan.view.fragment.FragmentIntro2;
import sendan.sharif.sendan.view.fragment.FragmentIntro3;
import sendan.sharif.sendan.view.my_views.MyViews;


//create intro view for first time
public class ActivityIntro extends AppCompatActivity {

  Button btn_per, btn_next;

  int current_fragment = 1;
  FragmentTransaction ft;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro);

    btn_per = (Button) findViewById(R.id.btn_per);
    btn_next = (Button) findViewById(R.id.btn_next);

    //set typeface to views
    btn_per.setTypeface(MyViews.getIranSansFont(ActivityIntro.this));
    btn_next.setTypeface(MyViews.getIranSansLightFont(ActivityIntro.this));


    btn_per.setVisibility(View.INVISIBLE);
    ft = getSupportFragmentManager().beginTransaction();
    ft.setCustomAnimations(R.anim.anim_enter_from_left, R.anim.anim_exit_to_right);
    ft.replace(R.id.lyt_intro, new FragmentIntro1());
    ft.commit();


    btn_per.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Animation rotation = AnimationUtils.loadAnimation(ActivityIntro.this, R.anim.rotate);
        btn_per.startAnimation(rotation);
       if(current_fragment == 2){
         ft = getSupportFragmentManager().beginTransaction();
         ft.setCustomAnimations(R.anim.anim_enter_from_left, R.anim.anim_exit_to_right);
         btn_per.setVisibility(View.INVISIBLE);
         ft.replace(R.id.lyt_intro, new FragmentIntro1());
         ft.commit();
         current_fragment--;
       }else  if(current_fragment == 3){
         btn_next.setText("بعدی");
         ft = getSupportFragmentManager().beginTransaction();
         ft.setCustomAnimations(R.anim.anim_enter_from_left, R.anim.anim_exit_to_right);
         btn_per.setVisibility(View.VISIBLE);
         ft.replace(R.id.lyt_intro, new FragmentIntro2());
         ft.commit();
         current_fragment--;
       }
      }
    });

    btn_next.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Animation rotation = AnimationUtils.loadAnimation(ActivityIntro.this, R.anim.rotate);
        btn_next.startAnimation(rotation);
        if(current_fragment == 1){
          ft = getSupportFragmentManager().beginTransaction();
          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
          btn_per.setVisibility(View.VISIBLE);
          ft.replace(R.id.lyt_intro, new FragmentIntro2());
          ft.commit();
          current_fragment++;
        }else if(current_fragment == 2){
          ft = getSupportFragmentManager().beginTransaction();
          ft.setCustomAnimations(R.anim.anim_enter_from_right, R.anim.anim_exit_to_left);
          ft.replace(R.id.lyt_intro, new FragmentIntro3());
          ft.commit();
          btn_next.setText("تمام");
          current_fragment++;
        }
        else if(current_fragment == 3){
          Intent intent = new Intent(ActivityIntro.this, ActivityMain.class);
          startActivity(intent);
          finish();
        }

      }
    });

  }
}
