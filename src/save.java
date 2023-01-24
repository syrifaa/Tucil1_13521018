import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class save {
    public File file;

    public static final String dateFormat = "[yyyy-MM-dd_HH.mm.ss]";
    public static String now() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(cal.getTime());
    }


    public void saveToFile()  {
        try {
            String tanggal = now();
            this.file = new File("..\\test\\output\\solution"+tanggal+".txt");
            PrintStream printStream = new PrintStream(this.file);
            System.setOut(printStream);
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
    }

    public void closeFile()  {
        PrintStream consoleStream = new PrintStream(
            new FileOutputStream(FileDescriptor.out));
        System.setOut(consoleStream);
        System.out.println("");
        System.out.println("Berhasil menyimpan file sebagai "+this.file.getName());
    }
}
