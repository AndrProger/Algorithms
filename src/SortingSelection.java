public class SortingSelection   {

    public static <T extends Number> double[] sortMinToMax(T[] arrDef) {
        double[] arr=convertToDoubleArray(arrDef);
        double[] sortArr=new double[arrDef.length];
        for(int i=0;i<arr.length;i++){
            double min=Double.MAX_VALUE;
            int indexMin=0;
            for(int j=0;j<arr.length;j++){
                if(min>arr[j])
                {
                    min=arr[j];
                    indexMin=j;
                }
            }
            arr[indexMin]=Double.MAX_VALUE;
            sortArr[i]=min;
        }
        return sortArr;
    }


    public static <T extends Number> double[] sortMaxToMin(T[] arrDef) {
        double[] arr=convertToDoubleArray(arrDef);
        double[] sortArr=new double[arrDef.length];
        for(int i=0;i<arr.length;i++){
            double max=Double.MIN_VALUE;
            int indexMax=0;
            for(int j=0;j<arr.length;j++){
                if(max<arr[j])
                {
                    max=arr[j];
                    indexMax=j;
                }
            }
            arr[indexMax]=Double.MIN_VALUE;
            sortArr[i]=max;
        }
        return sortArr;
    }
    private static <T extends Number> double[] convertToDoubleArray(T[] arr) {
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].doubleValue();
        }

        return result;
    }
}
