package cc.wybxc;

public class Main {

    public static void main(String[] args) {
        ICollection<MyDate> dates = new LinkedList<>();
        System.out.printf("今天是%s。\n", new MyDate());
        while (true) {
            System.out.print("请输入日期（格式：yyyy-MM-dd，输入空行结束）：");
            String line = System.console().readLine();
            if (line.isEmpty()) {
                break;
            }
            try {
                dates.add(new MyDate(line));
            } catch (Exception e) {
                System.out.println("输入的日期格式不正确！");
            }
        }
        System.out.println("输入的日期为：");
        for (MyDate date : dates.toArray(MyDate[]::new)) {
            System.out.println(date);
        }
    }
}
