
public class BinarySearch {
    public static final <T extends Number> int searchNumber(T[] arrDef,T numberCheckDef){
        double[] arr=convertToDoubleArray(arrDef);
        double numberCheck=numberCheckDef.doubleValue();
        int
            leftIndex=0,
            rightIndex=arr.length-1,
            index=0;
        while (leftIndex<rightIndex){
            index = (leftIndex + rightIndex + 1) >>> 1;
            if(arr[index]==numberCheck)
                return index;
            if(arr[index]>numberCheck)
                rightIndex=index-1;
            else
                leftIndex=index+1;
        }
        return -1;
    }
    private static <T extends Number> double[] convertToDoubleArray(T[] arr) {
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].doubleValue();
        }

        return result;
    }
}
