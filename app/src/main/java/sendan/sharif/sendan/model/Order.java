package sendan.sharif.sendan.model;

import java.util.ArrayList;
import java.util.List;

import sendan.sharif.sendan.R;

public class Order {
  private int id;
  private int image_resource;
  private String rate;
  private String address;
  private String description;


  public static List<Order> getFakeData(){
//    order.setImage_resource();
//    order.setRate("10%");
//    order.setDescription("شما میتوانید برنج خود را از این فروشگاه تهیه کنید");
//    order.setAddress("خیابان ولیعصر جنب باک ملی");

    List<Order> orders = new ArrayList<>();

    for (int i=0 ; i<20 ; i++){
      Order order = new Order();
      order.setImage_resource(R.drawable.ic_intro1);
      order.setRate("76%");
      order.setDescription("شما میتوانید برنج خود را از این فروشگاه تهیه کنید");
      order.setAddress("خیابان ولیعصر جنب باک ملی");
      orders.add(order);
    }


    return orders;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getImage_resource() {
    return image_resource;
  }

  public void setImage_resource(int image_resource) {
    this.image_resource = image_resource;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
