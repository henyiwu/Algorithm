package leetcode;

public class ArrayUtils {

    public static void merge(int[] arrayA, int[] arrayB, int[] arrayC){
        int aDex = 0,bDex = 0,cDex = 0;
        while (aDex < arrayA.length && bDex < arrayB.length){
            if (arrayA[aDex] < arrayB[bDex]){
                arrayC[cDex++] = arrayA[aDex++];
            }else{
                arrayC[cDex++] = arrayB[bDex++];
            }
        }
        while (aDex < arrayA.length){
            arrayC[cDex++] = arrayA[aDex++];
        }
        while (bDex < arrayB.length){
            arrayC[cDex++] = arrayB[bDex++];
        }
    }
}
