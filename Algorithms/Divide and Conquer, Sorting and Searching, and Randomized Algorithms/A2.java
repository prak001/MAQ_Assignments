import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Q {

  public static void main(String[] args) throws FileNotFoundException {
    int[] ay;
    ay = getay();
    System.out.println(qS(ay, 0, ay.length, new FirstEpp()));
    ay = getay();
    System.out.println(qS(ay, 0, ay.length, new LastEpp()));
    ay = getay();
    System.out.println(qS(ay, 0, ay.length, new mnOfThreepp()));
  } 
  private static int qS(int[] ay, int b, int e, pp picker) {
    
    if (e - b < 2) {
      return 0;
    }
    
    picker.moveToFront(ay, b, e);
  
    int ptPosition = pn(ay, b, e);
    
    return e - b - 1 + qS(ay, b, ptPosition, picker) + qS(ay, ptPosition + 1, e, picker);
  }
  private interface pp {
   
    void moveToFront(int[] ay, int b, int e);
  }
  private static class LastEpp implements pp {
    @Override
    public void moveToFront(int[] ay, int b, int e) {
      // Moving the last E to the front
      int temp = ay[b];
      ay[b] = ay[e - 1];
      ay[e - 1] = temp;
    }
  }

  private static class mnOfThreepp implements pp {
    @Override
    public void moveToFront(int[] ay, int b, int e) {
      int mn;
      int m = (b + e - 1) / 2;
      if (ay[b] < ay[m]) {
        if (ay[m] < ay[e - 1]) {
          mn = m;
        } else if (ay[b] < ay[e - 1]) {
          mn = e - 1;
        } else {
          mn = b;
        }
      } else {
        if (ay[e - 1] < ay[m]) {
          mn = m;
        } else if (ay[e - 1] < ay[b]) {
          mn = e -1;
        } else {
          mn = b;
        }
      }
      // Moving the mn E to the front
      int temp = ay[b];
      ay[b] = ay[mn];
      ay[mn] = temp;
    }
  }

  private static int pn(int[] ay, int b, int e) {
    int pt = ay[b];
    int ptPosition = b;
    // Sweeping the ay interval to determine the pt position
    for (int i = ptPosition + 1; i < e; i++) {
          if (ay[i] < pt) {
        int temp = ay[ptPosition + 1];
        ay[ptPosition + 1] = ay[i];
        ay[i] = temp;
        ptPosition++;
      }
    }
    ay[b] = ay[ptPosition];
    ay[ptPosition] = pt;
    return ptPosition;
  }

  private static int[] getay() throws FileNotFoundException {
    Scanner in = new Scanner(new File("Desktop/qS.txt"));
    try {
      int[] ay = new int[10000];
      for (int i = 0; i < 10000; i++) {
        ay[i] = in.nextInt();
      }
      return ay;
    } finally {
      in.close();
    }
  }
}