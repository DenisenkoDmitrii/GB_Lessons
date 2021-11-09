package Lesson_05;

public class AppData {
    String[] header = {"SN", "Weight", "Ammount", "SizeL,mm", "SizeH,mm", "SizeD,mm"};
    int[][] data = {{1, 10, 5, 10, 10, 10}, {2, 15, 3, 20, 15, 10}, {3, 20, 1, 20, 20, 20}};

    public String getHeader() {
        String value = "";
        for (String header : header) {
            value += header + ";";
        }
        value = value.substring(0, value.length() - 1) + "\r\n";
        return value;
    }

    public String getData() {
        String value = "";
        for (int[] data1 : data) {
            for (int data2 : data1) {
                value += data2 + ";";
            }
            value = value.substring(0, value.length() - 1) + "\r\n";
            //value = value + "\r\n";
        }
        return value;
    }
}
