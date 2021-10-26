import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class OnTap {
    public static ArrayList<String> layDanhSachBaiOn(){
        ArrayList<String> danhSachBaiOn=new ArrayList<String>();
        try {
            FileInputStream fis=new FileInputStream("ontap\\danhsach.txt");
            InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
            BufferedReader br=new BufferedReader(isr);
            String tenBai;
            do {
                tenBai=br.readLine();
                if(tenBai!=null)
                    danhSachBaiOn.add(tenBai);
            }
            while (tenBai!=null);

            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }


        return danhSachBaiOn;
    }
    public static void luuDanhSachBaiOn(ArrayList<String> danhSachBaiOn){
        try {
            FileOutputStream fos=new FileOutputStream("ontap\\danhsach.txt");
            OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            for (int i=0;i<danhSachBaiOn.size();i++)
            {
                bw.write(danhSachBaiOn.get(i));
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void taoBaiOn(HashMap<String,String> danhSachTu,String tenBai)
    {
        String path="ontap\\"+tenBai+".txt";
        try {
            FileOutputStream fos=new FileOutputStream(path);
            OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);

            Collection<String> keys=danhSachTu.keySet();
            for(String s: keys)
            {
                bw.write(s);
                bw.newLine();
                bw.write(danhSachTu.get(s));
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            ArrayList<String> danhSachBaiOn=layDanhSachBaiOn();
            if (danhSachBaiOn.contains(tenBai)==false)
                danhSachBaiOn.add(tenBai);
            System.out.println(danhSachBaiOn);
            luuDanhSachBaiOn(danhSachBaiOn);


        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static HashMap<String,String> layDanhSachTu(String tenBaiOn){
        HashMap<String,String> layDanhSachTu=new HashMap<String,String>();
        String path="ontap\\"+tenBaiOn+".txt";
        try{
            FileInputStream fis=new FileInputStream(path);
            InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
            BufferedReader br=new BufferedReader(isr);
            String key;
            String value;
            do {
                key=br.readLine();
                value=br.readLine();
                if (key!=null && value!=null)
                {
                    layDanhSachTu.put(key,value);
                }

            }
            while (key!=null && value!=null);

            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return layDanhSachTu;
    }
}
