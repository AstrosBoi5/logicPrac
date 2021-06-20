/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Tim so duplicate nhieu nhat trong day array
// 1 for

package hashmap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 *
 * @author Babel
 */
public class Hashmap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        bai99();
//        bai100();
//            bai101();
//            bai102();
//            bai104();
//            bai105();
//                bai106();
//                bai107();
                checkExponentiation();
        
    }   
    public static int hashmapPrac(){
        HashMap<Integer, Integer> mapDup = new HashMap<Integer, Integer>();
        int arrNum[] = {1,2,2,2,6,8,9};
        int temp = 0;
        int valEl = 0 ;
        
        // insert value 
        for(int el: arrNum){
            if(el == temp){
                if(mapDup.containsKey(el)){
                    valEl = mapDup.get(el);
                    valEl++;
                    mapDup.put(el, valEl);
                }
            }else{
                mapDup.put(el,1);
                temp = el;
            }
        }
        System.out.println(mapDup);
        
        int value = Collections.max(mapDup.values());
        
        for(Entry<Integer, Integer> entry: mapDup.entrySet()) {
            if(entry.getValue() == value) {
                System.out.println("THE MOST DUPLICATE NUMBER IS " + entry.getKey());
                break;
            }
        }    
        return 0;
    }
    // 1 
    public static void bai99(){
        //Bài 99: Viết chương trình nhập vào 3 số thực. Hãy in 3 số ấy ra màn hình theo thứ tự tang dần mà chỉ dùng tối đa 1 biến phụ
        Scanner sc= new Scanner(System.in);
        float temp = 0;
        System.out.print("Enter first number- ");  
        float a= sc.nextFloat();  
        System.out.print("Enter second number- ");  
        float b= sc.nextFloat();  
        System.out.print("Enter third number- ");  
        float c= sc.nextFloat();  
        
        
        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }
        if(a > c){
            temp = a;
            a = c; 
            c = temp;
        }
        if(b > c){
            temp = b;
            b = c;
            c = temp;
        }
        
        System.out.println("Increase: "+a+" "+ b+" "+c);
    }
    
    public static void bai100(){
        //Viết chương trình giải phương trình bậc 2
       Scanner sc= new Scanner(System.in);
        System.out.print("Enter first number- ");  
        int a= sc.nextInt();
        System.out.print("Enter second number- ");  
        int b= sc.nextInt(); 
        System.out.print("Enter third number- ");  
        int c= sc.nextInt();
        
        if(a == 0){
            if(b == 0){
                System.out.println("Phuong trinh vo nghiem");
            }else{
                if(c == 0){
                    System.out.println("Phuong trinh co vo so nghiem");
                }else{
                    int x = -c/b;
                    System.out.println("Phuong trinh co 1 nghiem: "+ x);
                }
            }
                
        }else{
            int d = b*b - 4*a*c;
            if(d == 0){
                int x = -b / 2*a;
                System.out.println("Phuong co 1 nghiem: "+x);
                
            }else{
                double posR = (-b + Math.sqrt(d)) / 2*a;
                double negR = (-b - Math.sqrt(d)) / 2*a;
                System.out.println("Phuong trinh co 2 nghiem: 1 n Duong: "+ posR +" 1 n am:"+negR);
            }
            
        }
        
        
    }
    public static void bai101(){
        //Viết chương trình nhập tháng, năm. Hãy cho biết tháng đó có bao nhiêu ngày
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Year- ");  
        int year= sc.nextInt();
        if(year < 0){
            System.out.println("This function only allow positive year");
            return;
        }
        System.out.print("Enter Month- ");  
        int month= sc.nextInt(); 
        if(month < 0 || month > 12){
            System.out.println("Month is not available");
            return;
        }

        
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang " + month + " co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang "+month+"co 30 ngay");
                break;
            case 2:
                boolean check = checkLeapYear(year);
                if(check == true){
                    System.out.println("Thang 2 co 29 ngay");
                    break;
                }else{
                    System.out.println("Thang 2 co 28 ngay");
                    break;
                }
            
        }
        
    }
    public static boolean checkLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static boolean checkValidInput(int year, int month,int day){
        if(year < 0){
            System.out.println("This function only allow positive year");
            return false;
        }
        if(month < 0 || month > 12){
            System.out.println("Month is not available");
            return false;
        }
        boolean check = checkValidDay(year, month, day);
        if(check == false) return false;
        
        return true;
    }
    
    public static boolean checkValidDay(int year,int month, int day){
        boolean check = checkLeapYear(year);
        
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(day < 0 || day > 31){
                    System.out.println("Day is not available - only from 1 to 31");
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(day < 0 || day > 30){
                    System.out.println("Day is not available - only from 1 to 30");
                    return false;
                }
                break;
            case 2:
                if(check == true){
                    if(day < 0 || day > 29){
                        System.out.println("Day is not available - only from 1 to 29");
                        return false;
                    }
                }else{
                    if(day < 0 || day > 28){
                        System.out.println("Day is not available - only from 1 to 28");
                        return false;
                    }
                }
            break;
        }
        
        return true;
    }
    
    public static void bai102(){
//         Viết chương trình nhập vào 1 ngày ( ngày, tháng, năm). Tìm ngày kế ngày vừa nhập (ngày, tháng, năm)
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Year- ");  
        int year= sc.nextInt();
        
        System.out.print("Enter Month- ");  
        int month= sc.nextInt(); 
        
        System.out.print("Enter Day- ");  
        int day= sc.nextInt();
        
        boolean check = checkValidInput(year, month, day);
        
        if(check == true){
            switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(day == 31){
                    month++;
                    System.out.println("Ngay ke la 1/"+month+"/"+year);
                    break;
                }else{
                    day++;
                    System.out.println("Ngay ke la "+ day +"/"+month+"/"+year);
                    break;
                }
            case 12:
                if(day == 31){
                    month = 1;
                    year++;
                    System.out.println("Ngay ke la 1/"+month+"/"+year);
                    break;
                }else{
                    day++;
                    System.out.println("Ngay ke la "+ day +"/"+month+"/"+year);
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if(day == 31){
                    month = 1;
                    year++;
                    System.out.println("Ngay ke la 1/"+month+"/"+year);
                    break;
                }else{
                    day++;
                    System.out.println("Ngay ke la "+ day +"/"+month+"/"+year);
                    break;
                }
            case 2:
                boolean checkLeapYear = checkLeapYear(year);
                    if(checkLeapYear == true){
                        if(day == 29){
                            month++;
                            System.out.println("Ngay ke la 1/"+month+"/"+year);
                        }else{
                            day++;
                            System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                        }
                        break;
                    }else{
                        if(day == 28){
                            month++;
                            System.out.println("Ngay ke la 1/"+month+"/"+year);
                        }else{
                            day++;
                            System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                        }
                        break;
                    }
            
            }
        }
        
        
    }
    public static void bai103(){
//         Viết chương trình nhập vào 1 ngày ( ngày, tháng, năm). Tìm ngày trước ngày vừa nhập (ngày, tháng, năm)
        Scanner sc= new Scanner(System.in);
                System.out.print("Enter Year- ");  
        int year= sc.nextInt();
        if(year < 0){
            System.out.println("This function only allow positive year");
            return;
        }
        System.out.print("Enter Month- ");  
        int month= sc.nextInt(); 
        if(month < 0 || month > 12){
            System.out.println("Month is not available");
            return;
        }
        System.out.print("Enter Day- ");  
        int day= sc.nextInt();
        if(day < 0 || day > 31){
            System.out.println("Day is not available");
            return;
        }
        
        switch(month){
            case 1:
                if(day == 1){
                    year -= 1;
                    System.out.println("Ngay truoc la: 31/12/"+year);
                    break;
                }else{
                    day -=1;
                    System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                    break;
                }
            case 3:
                if(day == 1){
                    month -= 1;
                    boolean check = checkLeapYear(year);
                    if(check == true){
                        System.out.println("Ngay truoc la 29/"+month+"/"+year);
                        break;
                    }else{
                        System.out.println("Ngay truoc la 28/"+month+"/"+year);
                        break;
                    }
                }else{
                    day -=1;
                    System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                    break;
                }
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(day == 1){
                    month -= 1;
                    System.out.println("Ngay truoc la: 30"+"/"+month+"/"+year);
                    break;
                }else{
                    day -=1;
                    System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if(day == 1){
                    month -= 1;
                    System.out.println("Ngay truoc la: 31"+"/"+month+"/"+year);
                    break;
                }else{
                    day -=1;
                    System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                    break;
                }
            case 2:
                boolean check = checkLeapYear(year);
                if(day == 1){
                    month -= 1;
                    System.out.println("Ngay truoc la: 31"+"/"+month+"/"+year);
                    break;
                }else{
                    if(check == true){
                        if(day > 29){
                            System.out.println("There is no date like that");
                        }else{
                            day -=1;
                            System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                        }
                        break;
                    }else{
                        if(day > 28){
                            System.out.println("There is no date like that");
                        }else{
                            day -=1;
                            System.out.println("Ngay truoc la:" + day +"/" + month+"/"+year);
                        }
                        break;
                    }
                }
            
        }
        
    }
    
    public static void bai104(){
//        Viết chương trình nhập ngày, tháng, năm. Tính xem ngày đó là ngày thứ bao nhiêu trong năm
        Scanner sc= new Scanner(System.in);
        int dayCount = 0;
        System.out.print("Enter Year- ");  
        int year= sc.nextInt();
        
        System.out.print("Enter Month- ");  
        int month= sc.nextInt(); 
        
        System.out.print("Enter Day- ");  
        int day= sc.nextInt();
        
        boolean check = checkValidInput(year, month, day);
        
        if(check == true){
            for(int i = 1; i < month;i++){
                if(i == 1 || i == 3|| i == 5|| i == 7|| i == 8|| i == 10 || i == 12 ){
                    dayCount += 31;
                }else if(i == 4 ||i == 6 ||i == 9 ||i == 11){
                    dayCount += 30;
                }else if(i == 2){
                    boolean checkLeapYear = checkLeapYear(year);
                    if(checkLeapYear == true){
                        dayCount += 29;
                    }else{
                        dayCount += 28;
                    }
                }
            }
            dayCount += day;
        }
        
        
        System.out.println(day+" /"+month+" /"+year+" la ngay thu "+dayCount+" trong nam");
    }
    
    public static void bai105(){
        //Viết chương trình nhập 1 số nguyên có 2 chữ số.  Hãy in ra cách đọc của số nguyên này
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number- ");  
        int Number= sc.nextInt();
        
        if(Number < 10 || Number > 99){
            System.out.println("Number is not availble in this one- only from 10 to 99");
            return;
        }
        int units = Number % 10;
        int tens = Number / 10;
        System.out.println("");
        switch(tens){
            case 2:
                System.out.print("Hai ");
                break;
            case 3:
                System.out.print("Ba ");
                break;
            case 4:
                System.out.print("Bon ");
                break;
            case 5:
                System.out.print("Nam ");
                break;
            case 6:
                System.out.print("Sau ");
                break;
            case 7:
                System.out.print("Bay ");
                break;
            case 8: 
                System.out.print("Tam ");
                break;
            case 9:
                System.out.print("Chin ");
                break;
            default:
                break;
        }
        System.out.print("Muoi ");
        switch(units){
            case 1:
                System.out.print("Mot");
                break;
            case 2:
                System.out.print("Hai");
                break;
            case 3:
                System.out.print("Ba");
                break;
            case 4:
                System.out.print("Bon");
                break;
            case 5:
                System.out.print("Nam");
                break;
            case 6:
                System.out.print("Sau");
                break;
            case 7:
                System.out.print("Bay");
                break;
            case 8: 
                System.out.print("Tam");
                break;
            case 9:
                System.out.print("Chin");
                break;
        }
    }
    
    public static void bai106(){
        //Viết chương trình nhập 1 số nguyên có 3 chữ số.  Hãy in ra cách đọc của số nguyên này
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number- ");  
        int Number= sc.nextInt();
        
        if(Number < 100 || Number > 999){
            System.out.println("Number is not availble in this one- only from 100 to 999");
            return;
        }
        
        int units = Number % 10;
        Number /= 10;  // 12
        int tens = Number % 10;
        int hundreds = Number / 10;
        
        System.out.println("");
        switch(hundreds){
            case 2:
                System.out.print("Hai ");
                break;
            case 3:
                System.out.print("Ba ");
                break;
            case 4:
                System.out.print("Bon ");
                break;
            case 5:
                System.out.print("Nam ");
                break;
            case 6:
                System.out.print("Sau ");
                break;
            case 7:
                System.out.print("Bay ");
                break;
            case 8: 
                System.out.print("Tam ");
                break;
            case 9:
                System.out.print("Chin ");
                break;
            default:
                break;
        }
        System.out.print("Tram ");
        switch(tens){
            case 2:
                System.out.print("Hai ");
                break;
            case 3:
                System.out.print("Ba ");
                break;
            case 4:
                System.out.print("Bon ");
                break;
            case 5:
                System.out.print("Nam ");
                break;
            case 6:
                System.out.print("Sau ");
                break;
            case 7:
                System.out.print("Bay ");
                break;
            case 8: 
                System.out.print("Tam ");
                break;
            case 9:
                System.out.print("Chin ");
                break;
            default:
                break;
        }
        System.out.print("Muoi ");
        switch(units){
            case 1:
                System.out.print("Mot");
                break;
            case 2:
                System.out.print("Hai");
                break;
            case 3:
                System.out.print("Ba");
                break;
            case 4:
                System.out.print("Bon");
                break;
            case 5:
                System.out.print("Nam");
                break;
            case 6:
                System.out.print("Sau");
                break;
            case 7:
                System.out.print("Bay");
                break;
            case 8: 
                System.out.print("Tam");
                break;
            case 9:
                System.out.print("Chin");
                break;
        }
    }
    
    public static void bai107(){
        //Viết hàm tính S = CanBacN(x)
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number- ");  
        double Number= sc.nextInt();
        System.out.println("Enter Square- ");
        double N = sc.nextInt();
        
        N = 1/N;
        double result = Math.pow(Number, N);
        System.out.println("S = "+result);
    }
    
    public static void checkExponentiation(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number- ");  
        int Number= sc.nextInt();
        
        for(int i = 2; i < Number;i++){
            if(Number % i == 0){
//                // use getBaseLog
//                double result = getBaseLog(Number, i);
//                if(result == (int)result){
//                    System.out.println(Number + " la so luy thua cua "+ i);
//                    break;
//                }
                // use checkBaseLog
                double result = checkBaseLog(Number, i);
                if(result == 1){
                    System.out.println(Number + " la so luy thua cua "+ i);
                    break;
                }
            }
            if(i == Number - 1 ){
                System.out.println(Number + " khong la so luy thua cua so nao ca");
            }
        } 
    }
    public static double getBaseLog(int Number,int x){
        return (Math.log(Number) /Math.log(x));
    }
    
    public static double checkBaseLog(int Number, int x){
        double temp = Number;
        for(int i = 0; i < Number;i++){
            temp = temp / x;
            if(temp <= 1){
                return temp;
            } 
        }
        return 0;
    }
}
