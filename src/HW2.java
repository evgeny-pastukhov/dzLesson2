public class HW2 {

    static String[][] arr1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "6", "7", "8"}, {"5", "6", "7", "8"}};
    static String[][] arr2 = {{"1", "2"}, {"1", "6",}, {"9", "6"}, {"5", "6"}};
    static String[][] arr3 = {{"1", "2", "3", "4"}, {"7", "6", "7", "8"}, {"9", "ш", "7", "8"}, {"5", "6", "7", "8"}};
    static int sizeI = 4;
    static int sizeJ = 4;

    public static void main(String[] args) {
        try {
            System.out.println("Сумма массива: " + getSum(arr1));
        } catch (MyArrSizeException | MyArrDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSum(arr2));
        } catch (MyArrSizeException | MyArrDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSum(arr3));
        } catch (MyArrSizeException | MyArrDataException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void check(String[][] arr) throws MyArrSizeException{
        if(arr.length!=sizeI || arr[0].length!=sizeJ) throw new MyArrSizeException();

    }

    static Integer getSum(String[][] arr) throws MyArrDataException,MyArrSizeException{
        check(arr);
        Integer result = 0;
        int i = 0;
        int j = 0;
        try {
            for (i=0; i < arr.length; i++) {
                j =0;
                for (j=0; j < arr.length; j++) {
                    result += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException ex){
            throw new  MyArrDataException("Ошибка в позиции: " + i+","+j);
        }

        return result;
    }

    public static class MyArrSizeException extends Exception {
        public MyArrSizeException(){

            super("Ошибка размера");

        }
    }

    public static class MyArrDataException extends Exception {
        public MyArrDataException(String message){
            super(message);

        }
    }

}