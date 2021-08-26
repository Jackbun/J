public class Star{
    public static void main(String[] args){
 int row = 0;
 int SIZE = 5;
 while (SIZE > row){
     int col = 0;
     while (row >= col){
       System.out.print("*");
       col = col + 1;
     }
     row = row + 1;

 }
}
}
