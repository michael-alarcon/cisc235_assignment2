package cisc235_assignment2;

/**
 * @author Michael Alarcon Student ID - 10172841 I confirm that this submission
 * is my own work and is consistent with the Queen's regulations on Academic
 * Integrity.
 */
public class Cisc235_assignment2 {

    public static void main(String[] args) {

        int[] array = new int[1000];
        int index = 0;

        for (int x = 1; x <= 1000; x++) {
            array[x - 1] = x;
        }

        double[] checkPoints = new double[10];
        int counter = 0;

        System.out.println("\n--------EXPERIMENT 1----------\n");

        for (int x = 0; x < 500; x++) {
            RedBlackTree rbTree = new RedBlackTree();

            for (int y = 1; y <= 1000; y++) {
                index = (int) (Math.random() * (1000));
                rbTree.insert(array[index]);
                if (y % 100 == 0 && y != 0) {
//                    System.out.println("Total rotations after " + y + " inserts: " + rbTree.getRotations() + "\n");
                    checkPoints[counter] += rbTree.getRotations();
                    rbTree.resetRotations();
                    counter++;
                }
            }
            counter = 0;
        }

        counter = 0;
        for (int x = 100; x <= 1000; x += 100) {
            System.out.print("Average rotations for " + x + " inserts: ");
            System.out.printf("%.2f\n", checkPoints[counter] / 500);
            counter++;
        }
        counter = 0;

        System.out.println("\n--------EXPERIMENT 2--------\n");

        int[] n = {1000, 2000, 4000, 8000, 16000, 32000};
        int value;
        double ratio;
        double[][] ratioArray = new double[6][5];

        for (int z = 0; z < n.length; z++) {
            for (int x = 0; x < 500; x++) {
                RedBlackTree rbTree = new RedBlackTree();
                BinarySearchTree sTree = new BinarySearchTree();
                for (int y = 0; y < n[counter]; y++) {
                    value = (int) (Math.random() * (n[counter] + 1));
                    rbTree.insert(value);
                    sTree.insert(value);
                }
                ratio = (double) sTree.totalDepth() / rbTree.totalDepth();
                if (ratio < 0.75) {
                    ratioArray[counter][0]++;
                } else if (ratio > 0.75 && ratio < 1) {
                    ratioArray[counter][1]++;
                } else if (ratio > 1 && ratio < 1.25) {
                    ratioArray[counter][2]++;
                } else if (ratio > 1.25 && ratio < 1.5) {
                    ratioArray[counter][3]++;
                } else {
                    ratioArray[counter][4]++;
                }
            }
            counter++;
        }

        counter = 0;
        for (int x = 1000; x <= 32000; x *= 2) {
            System.out.println("Ratio percentage for " + x + ": (ratio < 0.75, 0.75 < ratio < 1, 1 < ratio < 1.25, 1.25 < ratio < 1.5, ratio > 1.5)");
            for (int y = 0; y < 5; y++) {
                System.out.printf("%.2f", (ratioArray[counter][y] / 500) * 100);
                System.out.println("%");
            }
            counter++;
        }
    }
}
