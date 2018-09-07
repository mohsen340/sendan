package sendan.sharif.sendan.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.view.activity.ActivityIntro;


public class FragmentReport extends Fragment {

  View view;
  ImageView img_chart;
  ImageView img_red, img_blue , img_green;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_report, container, false);
    img_red = view.findViewById(R.id.img_red);
    img_blue = view.findViewById(R.id.img_blue);
    img_green = view.findViewById(R.id.img_green);
    img_chart = view.findViewById(R.id.img_chart);

    img_red.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        img_red.setAlpha((float) 1);
        img_blue.setAlpha((float) 0.4);
        img_green.setAlpha((float) 0.4);
        img_chart.setImageResource(R.drawable.cost_chart);
        setAnim();

      }
    });
    img_blue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        img_blue.setAlpha((float) 1);
        img_red.setAlpha((float) 0.4);
        img_green.setAlpha((float) 0.4);
        img_chart.setImageResource(R.drawable.weekly_chart);
        setAnim();
      }
    });
    img_green.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        img_green.setAlpha((float) 1);
        img_blue.setAlpha((float) 0.4);
        img_red.setAlpha((float) 0.4);
        img_chart.setImageResource(R.drawable.income_chart);
        setAnim();
      }
    });



    return view;
  }



  private void setAnim(){
    Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_chart_enter_from_left);
    img_chart.startAnimation(rotation);
  }









}
