package cisc235_assignment2;

/**
 * @author Michael Alarcon Student ID - 10172841 I confirm that this submission
 * is my own work and is consistent with the Queen's regulations on Academic
 * Integrity.
 */
public class Cisc235_assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        BinarySearchTree sTree = new BinarySearchTree();
//
//        sTree.insert(6);
//        sTree.insert(10);
//        sTree.insert(20);
//        sTree.insert(8);
//        sTree.insert(3);
//        System.out.println(sTree.searchPath(3));
//        System.out.println(sTree.totalDepth());
//
//
//        rbTree.insert(6);
//        rbTree.insert(10);
//        rbTree.insert(20);
//        rbTree.insert(8);
//        rbTree.insert(3);
//        System.out.println(rbTree.searchPath(3));
//        System.out.println(rbTree.totalDepth());
        int[] array = new int[1000];
        int index = 0;

        for (int x = 1; x <= 1000; x++) {
            array[x - 1] = x;
        }

        double[] checkPoints = new double[10];
        int counter = 0;
        
        for (int x = 0; x < 500; x++) {
            RedBlackTree rbTree = new RedBlackTree();
            
            for (int y = 1; y <= 1000; y++) {
                index = (int) (Math.random() * 1000);
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
    }
}
