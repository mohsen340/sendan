package sendan.sharif.sendan.neural_network;

import android.util.Log;

public class Hebb {
  //create 4 user    each user is(4*1) matrix
  private int[][] user1 = new int[4][1];
  private int[][] user2 = new int[4][1];
  private int[][] user3 = new int[4][1];
  private int[][] user4 = new int[4][1];

  //create 4 type    each type is(1*4) matrix
  private int[][] type1 = new int[1][4];
  private int[][] type2 = new int[1][4];
  private int[][] type3 = new int[1][4];
  private int[][] type4 = new int[1][4];


  private int[][]  weights = new int[4][4];



  public Hebb(){
    //init users
    user1[0][0] = 1;
    user1[1][0] = 0;
    user1[2][0] = 0;
    user1[3][0] = 0;

    user2[0][0] = 1;
    user2[1][0] = 1;
    user2[2][0] = 0;
    user2[3][0] = 0;

    user3[0][0] = 1;
    user3[1][0] = 0;
    user3[2][0] = 1;
    user3[3][0] = 0;

    user4[0][0] = 1;
    user4[1][0] = 0;
    user4[2][0] = 0;
    user4[3][0] = 1;

    //init types
    type1[0][0] = 1;
    type1[0][1] = 0;
    type1[0][2] = 0;
    type1[0][3] = 0;

    type2[0][0] = 0;
    type2[0][1] = 1;
    type2[0][2] = 0;
    type2[0][3] = 0;

    type3[0][0] = 0;
    type3[0][1] = 0;
    type3[0][2] = 1;
    type3[0][3] = 0;

    type4[0][0] = 0;
    type4[0][1] = 0;
    type4[0][2] = 0;
    type4[0][3] = 1;








  }


  public void findUsersType(){
    setUser1Buys();
    setUser2Buys();
    setUser3Buys();
    setUser4Buys();

    int[][] row_user1 = new int[1][4];
    for (int i=0 ; i<user1.length ; i++){
      row_user1[0][i] = user1[i][0];
    }
    int[][] row_user2 = new int[1][4];
    for (int i=0 ; i<user2.length ; i++){
      row_user2[0][i] = user2[i][0];
    }
    int[][] row_user3 = new int[1][4];
    for (int i=0 ; i<user3.length ; i++){
      row_user3[0][i] = user3[i][0];
    }
    int[][] row_user4 = new int[1][4];
    for (int i=0 ; i<user4.length ; i++){
      row_user4[0][i] = user4[i][0];
    }

    int[][] user1_type = matrixMul(row_user1, weights);
    int[][] user2_type = matrixMul(row_user2, weights);
    int[][] user3_type = matrixMul(row_user3, weights);
    int[][] user4_type = matrixMul(row_user4, weights);

    for (int i=0; i<4 ; i++){
      Log.i("HEBB", "user1 = " + user1_type[0][i]);
    }

    for (int i=0; i<4 ; i++){
      Log.i("HEBB", "user 2 = " + user2_type[0][i]);
    }

    for (int i=0; i<4 ; i++){
      Log.i("HEBB", "user 3 = " + user3_type[0][i]);
    }

    for (int i=0; i<4 ; i++){
      Log.i("HEBB", "user 4 = " + user4_type[0][i]);
    }
  }









  private int[][] setUser1Buys(){
    int[][] buys = new int[4][4];

    //user1 type1 buy count = 2
    for (int i=0 ; i<2000 ; i++){
        buys = matrixMul(user1, type1);
        weights = matrixSum(buys, weights);
    }

    //user1 type2 buy count = 1
    for (int i=0 ; i<10000 ; i++){
      buys = matrixMul(user1, type2);
      weights = matrixSum(buys, weights);
    }

    //user1 type3 buy count = 4
    for (int i=0 ; i<400 ; i++){
      buys = matrixMul(user1, type3);
      weights = matrixSum(buys, weights);
    }


    //user1 type1 buy count = 0
    for (int i=0 ; i<100 ; i++){
      buys = matrixMul(user1, type4);
      weights = matrixSum(buys, weights);
    }

    return buys;
  }


  private int[][] setUser2Buys(){
    int[][] buys = new int[4][4];

    for (int i=0 ; i<1000 ; i++){
      buys = matrixMul(user2, type1);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<4000 ; i++){
      buys = matrixMul(user2, type2);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<400 ; i++){
      buys = matrixMul(user2, type3);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<100 ; i++){
      buys = matrixMul(user2, type4);
      weights = matrixSum(buys, weights);
    }

    return buys;
  }


  private int[][] setUser3Buys(){
    int[][] buys = new int[4][4];

    for (int i=0 ; i<1000 ; i++){
      buys = matrixMul(user3, type1);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<10000 ; i++){
      buys = matrixMul(user3, type2);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<2000 ; i++){
      buys = matrixMul(user3, type3);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<10 ; i++){
      buys = matrixMul(user3, type4);
      weights = matrixSum(buys, weights);
    }

    return buys;
  }

  private int[][] setUser4Buys(){
    int[][] buys = new int[4][4];

    for (int i=0 ; i<10 ; i++){
      buys = matrixMul(user4, type1);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<20000 ; i++){
      buys = matrixMul(user4, type2);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<100 ; i++){
      buys = matrixMul(user4, type3);
      weights = matrixSum(buys, weights);
    }

    for (int i=0 ; i<30000 ; i++){
      buys = matrixMul(user4, type4);
      weights = matrixSum(buys, weights);
    }

    return buys;
  }





  private int[][] matrixMul(int[][] user, int[][] type){
    int aRows = user.length;
    int aColumns = user[0].length;
    int bRows = type.length;
    int bColumns = type[0].length;

    int [][] ans = new int[aRows][bColumns];


    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
        ans[i][j] = 0;
      }
    }

    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
        for (int k = 0; k < aColumns; k++) {
          ans[i][j] += user[i][k] * type[k][j];
        }
      }
    }

    return ans;
  }


  private int[][] matrixSum(int[][] buys, int[][] weights){
    int aRows = buys.length;
    int aColumns = buys[0].length;

    int [][] ans = new int[aRows][aColumns];


    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < aColumns; j++) {
        ans[i][j] = buys[i][j] + weights[i][j];
      }
    }

    return ans;
  }



}
