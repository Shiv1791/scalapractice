/*
import java.util.ArrayList;

public class Product {

    public static void main(String[] args) {
        int x[] =  {8,9};
        int y[] =  {8, 8};

        product(x,y);

    }

    public static void product(int x[],int y[]) {
        int yLength = y.length -1;
        int xLength = x.length -1;
        int arr[] = new int[xLength + yLength];
        int count = 0;
        int carry = 0;

        for (int i = 0; i <= xLength; i++) {
            count = 0;
            carry = 0;
            for (int j = yLength; j >= 0 && count<=yLength; j--) {
                int xa = (x[xLength-i] * y[yLength]);
                if(xa>9) {
                    xa = xa + carry;
                    arr[count] = xa % 10;
                    carry = xa / 10;

                }
                else {
                    arr[i]= xa;
                }
                count++;
            }
            int product[] = new int[convertIntoNumber(arr, carry).length];
            product = convertIntoNumber(arr, carry);
            printarray(product);
        }
    }

    public static void printarray(int arr[]) {
        int x = 0;
        int arrayLength = arr.length;

        for (int i = 0; i < arrayLength; i++)
            System.out.println("print arrar"+arr[i]);
    }

    public static int[] convertIntoNumber(int arr[], int carry){
        int x= 0;
        int arrayLength = arr.length;

        for (int i = 0; i< arrayLength; i++)
            carry = carry*10;

        for (int i =arrayLength-1 ; i >=0 ; i--) {
            x = 10*x+ arr[i];
        }
        int product  = (carry+x);
        int[]digits = Integer.toString(product).chars().map(c -> c-'0').toArray();
        return digits;
    }


}
*/
