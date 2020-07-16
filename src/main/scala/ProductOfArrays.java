/*
import java.lang.reflect.Array;

public class ProductOfArrays {

    static void productSubArrays(int arr[],int n){


        int product = 1;
        int tmp[] = new int[4];
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++) {
                System.out.println("The coming number  is  "+ i + " =  "+ j);
                product *= arr[j];
            }
        }

        System.out.println("product = " + product);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2};
        productSubArrays(arr, arr.length);
    }
}

class SumOfArrays{

    static public void sumSubArrays(int [] arrA, int target){

        int arrSize = arrA.length;
        //start point
        for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <=arrSize ; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(arrA[j] + " ");
                }
                aaa(arrA, target);
                System.out.println();
            }
        }
    }

    static void aaa(int arr[], int target){
        int sum = 0;
        for (int k = 0; k < arr.length; k++) {
            sum+=arr[k];
        }

        if (sum == target) {
            System.out.println("sum = " + sum);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        sumSubArrays(arr, arr.length);
    }
}


class PerfectSumProblem{

    static void findSubSets(int arr[], int n, int k) {

        int x = (int) Math.pow(2, n);
        for (int i = 1; i < x; i++){
            System.out.println("the arr "+ arr);
            sumSubSets(arr, i, k);
        }
    }

    static void sumSubSets(int arr[], int n, int k){
        int sum = 0;
        int tmp[] = new int[arr.length];
        int j = arr.length - 1;
        while (n>0){
            tmp[j] = n%2;
            n=n/2;
            j--;
        }

        for(int i = 0; i<arr.length; i++){
            if(tmp[i]==1)
                sum+=arr[i];
        }

        {
            System.out.print("{");
            for (int i = 0; i < arr.length; i++)
                if (tmp[i] == 1)
                    System.out.print(arr[i] + ", ");
            System.out.print("} ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, 12, 13, 15, 18 };
        int K = 30;

        findSubSets(arr, arr.length,K);
    }
}
*/
