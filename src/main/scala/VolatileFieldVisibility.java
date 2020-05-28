
//case: Happens Before
public class VolatileFieldVisibility {

    int a = 0, b= 0,c = 0;
    int x = 0;

    public void writeThread() {
        a = 1;
        b = 1;
        c = 1;
            x = 1;
    }

    public void readThread(){

        int r2 = x;
        int d1 = a;
        int d2 = b;
        int d3 = c;
        System.out.println("The values are coming " + r2 +" " +d1+ " " +d2+" " + d3);

    }


    public static void main(String[] args) {
        VolatileFieldVisibility s = new VolatileFieldVisibility();
        s.writeThread();
        s.readThread();//try to read without update
    }
}
