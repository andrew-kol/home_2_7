package bidimentionarray;

import java.util.ArrayList;
import java.util.List;

public class BiDimArray {
    private List<List<String>> biDimArrList = new ArrayList<>();

    void example() {

        for (int i = 0; i < 8; i++) {
            biDimArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    biDimArrList.get(i).add(j, "◯");
                } else {
                    biDimArrList.get(i).add(j, "●");
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDimArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BiDimArray a = new BiDimArray();
        a.example();
    }

}
