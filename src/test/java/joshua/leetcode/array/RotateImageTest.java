package joshua.leetcode.array;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {


    private int[][] matrix;

    @Before
    public void setUp() {
        matrix = new int[][]{
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}};
//        matrix = new int[][]{
//                {0, 1},
//                {4, 5}};
    }

    @Test
    public void testSolution1() {
        RotateImage image = new RotateImage.Solution1();
        image.rotate(matrix);
        System.out.println(ArrayUtils.toString(image));
        for (int i =0; i< matrix.length; i++) {
            for(int j = 0; j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

}