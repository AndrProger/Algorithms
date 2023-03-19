import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class QuickSort {
    public static <T extends Number> double[] sortMinToMax(T[] arrDef){
        double[] arr=convertToDoubleArray(arrDef);
        sortMaxRight(arr);
        return arr;
    }

    private static double[] sortMaxRight(double[] arr) {
        if(arr.length<=1)
            return arr;
        else{
            double pivot = arr[arr.length / 2];
            double left[]= Arrays.stream(arr).filter(value -> value<pivot).toArray();
            double middle[]= Arrays.stream(arr).filter(value -> value==pivot).toArray();
            double right[]= Arrays.stream(arr).filter(value -> value>pivot).toArray();
            left=sortMaxRight(left);
            left= DoubleStream.concat(Arrays.stream(left),Arrays.stream(middle)).toArray();
            right=sortMaxRight(right);
            return DoubleStream.concat(Arrays.stream(left),Arrays.stream(right)).toArray();
        }
    }

    public static <T extends Number> double[] sortMaxToMin(T[] arrDef){
        double[] arr=convertToDoubleArray(arrDef);

        return arr;
    }
    private static <T extends Number> double[] convertToDoubleArray(T[] arr) {
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].doubleValue();
        }

        return result;
    }
}
