/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Tim so duplicate nhieu nhat trong day array
// 1 for

package hashmap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
    public static void bai099(){
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
                if(day == 30){
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
        //Viết hàm tính S = x^y
        double temp = Number;
        for(int i = 0; i < Number;i++){
            temp = temp / x;
            if(temp <= 1){
                return temp;
            } 
        }
        return 0;
    }
    
    public static void bai108(){
        // Viết chương trình in bảng cửu chương ra màn hình
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter X- ");  
        int x= sc.nextInt(); 
        System.out.print("Enter Y- ");  
        int y= sc.nextInt(); 
        
        int Sum = (int) Math.pow(x, y);
        
        System.out.println("S =x^y: S= "+ Sum);
    }
    
    public static void bai109(){
        for(int i = 1; i <= 10;i++){
            for(int j = 1; j <= 10;j++){
                System.out.println(i + " *"+ j+" = "+i*j);
            }
        }
    }
    
    public static int[] twoSum(int[] nums, int target){
//        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length;i++){
            int competent = target - nums[i];
            if(map.containsKey(competent) && map.get(competent) != i){
                return new int[]{i,map.get(competent)};
            }
        }
         throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void bai110(){
        //Cần có tổng 200000 đồng từ 3 loại giấy bạc 1000 đồng, 2000 đồng, 5000 đồng. Lập chương trình để tìm ra tất cả các phương án có thể
        // x + 2y + 5z = 200
        int i,j,k;
        int count = 0;
        for(i =0;i <= 200;++i){
            for(j = 0; j <= 100; ++j){
                for(k = 0; k <=40;++k){
                    if(1000*i + 2000*j +5000*k == 200000){
//                        System.out.println(i+" *1000 + "+ j+" 2000 + " + k+" *5000 = 2000000");
                        count++;
                    }
                }
            }
        }
        System.out.println(count + " co tong bay nhieu cach tinh");
    }
    public static boolean check10(int num){
        if(num < 0 || num > 10){
            return false;
        }
        return true;
    }
    
    public static int calSum(int math, int lit){
        int sum;
        sum = (math + lit) /2;
        return sum;
    }
    public static void sysout(int val){
        System.out.println("Result is "+ val);
    }
    public static void bai115(){
        //Viết chương trình nhập họ tên, điểm toán, điểm văn của 1 học sinh. Tính điểm trung bình và xuất ra kết quả
        Scanner sc = new Scanner(System.in);
        String name;
        int math,lit;
        System.out.println("please insert name");
        name = sc.nextLine();
        System.out.println("please insert math score");
        math = sc.nextInt();
        System.out.println("please insert liturate score");
        lit = sc.nextInt();
        
        if(check10(math) && check10(lit)){
            int sum = calSum(math, lit);
            sysout(sum);
        }else{
            System.out.println("The insert value is invalid. Please check Math or Lit");
        }
        
        
    }
    public static int input(){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Please input value: ");
        num = sc.nextInt();
        
        return num;
    }
    
    public static int findX(){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Please input value X: ");
        num = sc.nextInt();
        
        return num;
    }
    
    public static int multiSum(int val){
        int sum = 0;
        for(int i = 1; i <= val;i++){
            sum += i;
        }
        return sum;
    }
    
    public static int timeSum(int val, int x){
        int sum = 0;
        for(int i = 1; i <= val;i++){
            sum += Math.pow(x,i);
        }
        return sum;
    }
    public static void output(int sum){
        System.out.println("the result is " + sum);
    }
    
    
    public static void bai116(){
        // Bài 116: Viết chương trình nhập n và tính tổng S = 1 + 2 + 3 + … + n
        output(multiSum(input()));
        
    }
    
    public static void bai117(){
        //Bài 117: Viết chương trình nhập n và tính tổng S(n) = x + x^2 + x^3 + … + x^n
        output(timeSum(input(), findX()));
    }
    
    public static boolean checkPrimeNo(int val){
        
        if (val < 2){
            return false;
        } else if (val > 2){
            if (val % 2 == 0){
                return false;
            }
            for (int i = 3; i <= Math.sqrt((float)val); i += 2){
            if (val % i == 0)
            {
                return false;
            }
        }
    }
        return true;
    }
    
    public static void showPrimeNum (){
        int num = input();
        for(int i = 1; i < num;i++ ){
            if(checkPrimeNo(i) == true){
                System.out.println("Prime Num below "+ num + " is "+ i);
            }
        }
    }
    
    public static void bai119(){
        //Liệt kê tất cả các số nguyên tố nhỏ hơn n
        showPrimeNum();
    }
    
    
    public static boolean checkSquareNum(int val){
        float check1 = (float) Math.sqrt(val);
        int check2 = (int) Math.sqrt(val);
        
        if(check1 == check2){
            return true;
        }else{
            return false;
        }
        
    }
    public static void showSquareNum(int val){
        if(checkSquareNum(val) == true){
            System.out.println("This Number "+ val + " is Squares Number");
        }else{
            System.out.println("This Number "+ val + " is not Squares Number");
        }
    }
    public static void bai120(){
        // Liệt kê tất cả các số chính phương nhỏ hơn n
        showSquareNum(input());
    }
    
    public static ArrayList<Float> inputMultiNum(){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        ArrayList<Float> arrNum = new ArrayList<>();
        do{
            System.out.println("Hay nhap so luong Num:");
            n = sc.nextInt();
            if(n <= 0 || n > 10){
                System.out.println("Xin hay nhap so tu 0 - 10");
            }
        }while(n <= 0 || n > 10);
        
        for(int i = 0; i < n;i++){
            int count = i + 1;
            System.out.println("Xin hay nhap so thu "+ count +" : ");
            float val = sc.nextFloat();
            arrNum.add(val);
        }
        return arrNum;
    }
    
    public static float checkVastNum(ArrayList<Float> arrNum){
        float vastNum = arrNum.get(0);
        
        for(float val : arrNum){
            if(val > vastNum){
                vastNum = val;
            }
        }
        return vastNum;
    }
    public static void bai122(){
        // Viết hàm tìm giá trị lớn nhất trong mảng 1 chiều các số thực
        
        ArrayList<Float> arrRes = inputMultiNum();
        float vastNum = checkVastNum(arrRes);
        
        System.out.println("The biggest real num is "+ vastNum);
    }
    
    public static int checkSmlLoc(ArrayList<Float> arrNum){
        int smlLoc = 0;
        
        for(int i = 0; i < arrNum.size(); i++){
            if(arrNum.get(i) < arrNum.get(smlLoc)){
                smlLoc = i;
            }
        }
        return smlLoc;
    }
    public static void bai123(){
        // Viết hàm tìm 1 vị trí mà giá trị tại vị trí đó là giá trị nhỏ nhất trong mảng 1 chiều các số nguyên
        ArrayList<Float> arrRes = inputMultiNum();
        int smlLoc = checkSmlLoc(arrRes);
        
        System.out.println("The small number on " + smlLoc);
        
    }
    public static int checkOdd2004(ArrayList<Float> arrNum){
        int flag = 0;
         for(int i = 0; i < arrNum.size(); i++){
            if(arrNum.get(i) % 2 == 0 && arrNum.get(i) < 2004){
                flag++;
            }
        }
        return 0;
    }
    public static void bai124(){
        //  Viết hàm kiểm tra trong mảng các số nguyên có tồn tại giá trị chẵn nhỏ hơn 2004 hay không
        ArrayList<Float> arrRes = inputMultiNum();
        int flag = checkOdd2004(arrRes);
        if(flag > 0){
            System.out.println("The array ");;
        }
    }
    
    public static int countPrimeNo(){
        int count = 0;
        for(int i = 1; i < 100;i++){
            if(checkPrimeNo(i) == true){
                count++;
            }
        }
        return count;
    }
    
    public static void bai125(){
        // Viết hàm đếm số lượng số nguyên tố nhỏ hơn 100 trong mảng
        System.out.println("So luong so nguyen to < 100 la "+ countPrimeNo());
    }
    
    public static int sumMinus(ArrayList<Float> arrNum){
        int sumM = 0;
        
        for(float val : arrNum){
            if(val < 0){
                sumM += val;
            }
        }
        return sumM;
    }
    
    public static void bai126(){
        //Viết hàm tính tổng các giá trị âm trong mảng 1 chiều các số thực
        int sumM = sumMinus(inputMultiNum());
        System.out.println("Sum Minus Number is " + sumM);
    }
    
    public static ArrayList<Float> sortAscNum(ArrayList<Float> arrNum){
        for(int i = 0; i < arrNum.size();i++){
            for(int j = i +1; j < arrNum.size(); j++){
                if(arrNum.get(i) > arrNum.get(j)){
                    Collections.swap(arrNum, i, j);
                }
            }
        }
        
        return arrNum;
    }
    
    
    public static void bai127(){
        //Viết hàm sắp xếp mảng 1 chiều các số thực tăng dần
         ArrayList<Float> arrNum = sortAscNum(inputMultiNum());
         for(int i = 0; i < arrNum.size();i++){
             System.out.println(arrNum.get(i));
         }
    }
    
    public static void outputRealNum (ArrayList<Float> arrNum){
        for(int i = 0; i < arrNum.size();i++){
            System.out.println(arrNum.get(i));
        }
    }
    
    public static void bai128v130(){
        // Viết hàm nhập, xuất mảng 1 chiều các số thực
        outputRealNum(inputMultiNum());
    }
    
    public static ArrayList<Integer> inputInteger(){
         Scanner sc = new Scanner(System.in);
        int n = 0;
        ArrayList<Integer> arrNum = new ArrayList<>();
        do{
            System.out.println("Hay nhap so luong Num:");
            n = sc.nextInt();
            if(n <= 0 || n > 10){
                System.out.println("Xin hay nhap so tu 0 - 10");
            }
        }while(n <= 0 || n > 10);
        
        for(int i = 0; i < n;i++){
            int count = i + 1;
            System.out.println("Xin hay nhap so thu "+ count +" : ");
            int val = sc.nextInt();
            arrNum.add(val);
        }
        return arrNum;
    }
    
    public static void outputIntegerNum (ArrayList<Integer> arrNum){
        for(int i = 0; i < arrNum.size();i++){
            System.out.println(arrNum.get(i));
        }
    }
    
    public static void bai129v131(){
        // Viết hàm nhập, xuất mảng 1 chiều các số nguyên
        outputIntegerNum(inputInteger());
    }
    
    public static String inputStringMAC(){
        String MAC = null;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please input MAC series");
        MAC = sc.nextLine();
        
        return MAC;
    }
    
    public static boolean checkValidMAC (String MAC){
        ArrayList<String> arrMAC = new ArrayList<>();
        ArrayList<String> eachSer = new ArrayList<>();
        
        for(String val : MAC.split("-")){
            arrMAC.add(val);
        }
        //check 6 value
        if(arrMAC.size() != 6 ){
            return false;
        }
        //check 2 digit
        for(int i = 0; i < arrMAC.size(); i++){
           for(String val : arrMAC.get(i).split("")){
               eachSer.add(val);
           }
           if(eachSer.size() != 2){
               return false;
           }
           // check valid characters
           for(int j = 0; j < eachSer.size();j++){
               int test = eachSer.get(j).charAt(0);
               if((test >= 48 && test <= 57) || (test >= 65 && test <= 70)){
                   
               }else{
                   return false;
               }
           }
           eachSer.clear();
        }
        return true;
    }
    public static void baiToan2(){
        // Valid Mac (xx-xx-xx-xx-xx-xx ) - 0-9 v A-F
//        outputMAC(inputStringMAC());
        boolean result = checkValidMAC(inputStringMAC());
        if(result == true){
            System.out.println("This Series is valid");
        }else{
            System.out.println("This Series is invalid");
        }
    }
    
    public static void main(String[] args) {
//        int[] nums ={3,2,4};
//        twoSum(nums, 6);

       baiToan2();
    }
    
}
