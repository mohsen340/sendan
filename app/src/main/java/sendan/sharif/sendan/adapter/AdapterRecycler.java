package sendan.sharif.sendan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import sendan.sharif.sendan.R;
import sendan.sharif.sendan.model.Order;
import sendan.sharif.sendan.view.my_views.MyViews;


public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ListViewHolder>{


  private Context context;
  private List<Order> orders;

  public AdapterRecycler(Context context, List<Order> orders){

    this.context = context;
    this.orders = orders;
  }

  @Override
  public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(context).inflate(R.layout.item_suggest,parent,false);
    return new ListViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ListViewHolder holder, int position) {
    final Order order = orders.get(position);

      holder.img_order.setImageResource(order.getImage_resource());
      holder.txt_rate.setText(order.getRate());
      holder.txt_description.setText(order.getDescription());
      holder.txt_address.setText(order.getAddress());




//    holder.itemView.setOnClickListener(new View.OnClickListener() {
//      @Override
////      public void onClick(View v) {
////        Intent intent = new Intent(context, ActivityShowRent.class);
////        intent.putExtra("ID", order.getId());
////        context.startActivity(intent);
////      }
//    });


  }

  @Override
  public int getItemCount() {
    return orders.size();
  }

  public class ListViewHolder extends RecyclerView.ViewHolder{

    private ImageView img_order;
    private TextView txt_rate;
    private TextView txt_description;
    private TextView txt_address;
    private Button txt_buy;

    public ListViewHolder(View itemView) {
      super(itemView);
      img_order = itemView.findViewById(R.id.img_order);
      txt_rate = itemView.findViewById(R.id.txt_rate);
      txt_description = itemView.findViewById(R.id.txt_description);
      txt_address = itemView.findViewById(R.id.txt_address);
      txt_buy = itemView.findViewById(R.id.txt_buy);
      setFont();

    }

    private void setFont(){
      txt_rate.setTypeface(MyViews.getIranSansLightFont(context));
      txt_description.setTypeface(MyViews.getIranSansFont(context));
      txt_address.setTypeface(MyViews.getIranSansFont(context));
      txt_buy.setTypeface(MyViews.getIranSansFont(context));
    }


  }


  public void notifyData(List<Order> games1) {
    //Log.d("notifyData ", myList.size() + "");
    if (games1.size() > 0) {
      for (int i = 0; i < games1.size(); i++) {
        this.orders.add(games1.get(i));
      }
      this.notifyItemInserted(orders.size() - 1);

      //notifyDataSetChanged();
    }
  }


  public void clear() {
    final int size = orders.size();
    orders.clear();
    notifyItemRangeRemoved(0, size);
  }





}