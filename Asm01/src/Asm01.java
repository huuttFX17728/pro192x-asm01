import java.util.*;

public class Asm01 {
    Asm01(){
//        String a = randomCode();
        welcomeScreen();
        run();
    }

    public  String  AUTHOR  = "FX17728";
    private String VERSION = "v1.0.0";
    private String copyright = AUTHOR.toUpperCase() + "@" + VERSION;

//    private ArrayList<Province> provincesList = new ArrayList<Province>();

    private Province provinces[] =  {
            new Province("Hà Nội","001"),
            new Province("Hà Giang","002"),
            new Province("Cao Bằng","004"),
            new Province("Bắc Kạn","006"),
            new Province("Tuyên Quang","008"),
            new Province("Lào Cai","010"),
            new Province("Điện Biên","011"),
            new Province("Lai Châu","012"),
            new Province("Sơn La","014"),
            new Province("Yên Bái","015"),
            new Province("Hòa Bình","017"),
            new Province("Thái Nguyên","019"),
            new Province("Lạng Sơn","020"),
            new Province("Quảng Ninh","022"),
            new Province("Bắc Giang","024"),
            new Province("Phú Thọ","025"),
            new Province("Vĩnh Phúc","026"),
            new Province("Bắc Ninh","027"),
            new Province("Hải Dương","030"),
            new Province("Hải Phòng","031"),
            new Province("Hưng Yên","033"),
            new Province("Thái Bình","034"),
            new Province("Hà Nam","035"),
            new Province("Nam Định","036"),
            new Province("Ninh Bình","037"),
            new Province("Thanh Hóa","038"),
            new Province("Nghệ An","040"),
            new Province("Hà Tĩnh","042"),
            new Province("Quảng Bình","044"),
            new Province("Quảng Trị","045"),
            new Province("Thừa Thiên Huế","046"),
            new Province("Đà Nẵng","048"),
            new Province("Quảng Nam","049"),
            new Province("Quảng Ngãi","051"),
            new Province("Bình Định","052"),
            new Province("Phú Yên","054"),
            new Province("Khánh Hòa","056"),
            new Province("Ninh Thuận","058"),
            new Province("Bình Thuận","060"),
            new Province("Kon Tum","062"),
            new Province("Gia Lai","064"),
            new Province("Đắk Lắk","066"),
            new Province("Đắk Nông","067"),
            new Province("Lâm Đồng","068"),
            new Province("Bình Phước","070"),
            new Province("Tây Ninh","072"),
            new Province("Bình Dương","074"),
            new Province("Đồng Nai","075"),
            new Province("Bà Rịa - Vũng Tàu","077"),
            new Province("Hồ Chí Minh","079"),
            new Province("Long An","080"),
            new Province("Tiền Giang","082"),
            new Province("Bến Tre","083"),
            new Province("Trà Vinh","084"),
            new Province("Vĩnh Long","086"),
            new Province("Đồng Tháp","087"),
            new Province("An Giang","089"),
            new Province("Kiên Giang","091"),
            new Province("Cần Thơ","092"),
            new Province("Hậu Giang","093"),
            new Province("Sóc Trăng","094"),
            new Province("Bạc Liêu","095"),
            new Province("Cà Mau","096")
    };
    private Province myProvince;
    private int myBirthYear;
    private String myGender;
    private String myCode;



    private void welcomeScreen(){
        String cpr = copyright +  new String(new char[30-copyright.length()]).replace('\0', ' ');
        System.out.println("+----------------+---------------------------------+");
        System.out.println("| NGAN HANG SO   |   " +  cpr + "|");
        System.out.println("+----------------+---------------------------------+");
        System.out.println("| 1. Nhap CCCD                                     |");
        System.out.println("| 0. Thoat                                         |");
        System.out.println("+----------------+---------------------------------+");

    }

    private void run(){
        Scanner scanner  = new Scanner(System.in);

        System.out.print(" Chon chuc nang (1/0): ");

        while (true) {
            boolean isInt = scanner.hasNextInt();

            if(isInt) {
                int c = scanner.nextInt();
                if(c == 1) {
//                    if(validate(scanner)){
                    if(validateByString(scanner)){
                        if(inputIDCode(scanner)){
                            screen2(scanner);
                        } else {
                            System.out.println("Nhap CCCD that bai. Nhan Enter de thoat.");
                            scanner.nextLine();
                            System.exit(-1);
                        }
                    } else {
                        System.out.println("Nhap ma xac thuc that bai. Nhan Enter de thoat.");
                        scanner.nextLine();
                        System.exit(-1);
                    }
                    break;
                }
                else if (c==0){
                    scanner.close();

                    System.exit(1);
                }
                else {
                    System.out.print("Vui long chon lai (1/0): ");
                }
            } else {
                System.out.print("Vui long chon lai (1/0): ");
            }

            scanner.nextLine();
        }

        scanner.close();


    }


    //    Ma xac thuc
    private boolean validate(Scanner scanner){

        int count = 1;

        while (true){
            int validateCode = (new Random()).nextInt(900) +100;
            System.out.println("Ma xac thuc: " + validateCode);
            System.out.print("Nhap ma xac thuc: ");

            boolean isInt = scanner.hasNextInt();

            if(isInt){
                int inputCode = scanner.nextInt();
                if(inputCode == validateCode){
                    return true;
                }
                else {
                    String code = scanner.nextLine();
                    count ++ ;
                    System.out.println("Ma xac thuc khong dung. Vui long thu lai (lan " + count +"/5)");
                }
            }
            else {
                count ++ ;
                System.out.println("Ma xac thuc khong dung. Vui long thu lai (lan " + count +"/5)");

            }


            if(count == 5) {
                return false;
            }

            scanner.nextLine();


        }
    }

    private boolean checkIDValidate(String idCode){

        try {
            Double.parseDouble(idCode);
            if(idCode.length() != 12) {
                new Exception("Loi nhap CCCD: So CCCD khong du 12 so");
                return false;
            }
            Province province = new Province();
            int n = provinces.length;
            String pv = idCode.substring(0,3);
            int ok = -1;
            for(int i=0;i<provinces.length;i++){
                if(Objects.equals( pv,this.provinces[i].getProvinceCode())){
                    ok = i;
                    myProvince = new Province(provinces[i].getProvinceName(), provinces[i].getProvinceCode());
                    myGender = (Integer.parseInt(idCode.substring(3,4))%2 == 0)?"Nam":"Nữ";
                    myCode = idCode.substring(6);
                    int fr = Integer.parseInt(idCode.substring(3,4));
                    fr = ((fr%2 == 1)?fr-1:fr)/2;
                    int ls = Integer.parseInt(idCode.substring(4,6));
                    myBirthYear = (19 + fr) * 100 + ls;
                }
            }
            if(ok == -1) {
                System.out.println("Loi nhap CCCD: 3 so dau cua CCCD khong dung voi ma tinh");
                return false;
            }
            return true;
        } catch (Exception e){
            return false;
        }
        /*
        int l = idCode.length();
        System.out.println(idCode);
        if(l != 12) {
            System.out.println("Loi nhap CCCD: So CCCD khong du 12 so");
            return false;
        }
        for(int i=0;i<l;i++){
            if((idCode.charAt(i) - '0' <0) && (idCode.charAt(i)-'0' >= 10)) {
                System.out.println("Loi nhap CCCD: 12 so cua CCCD phai la so");
                return false;
            }
        }
        */



    }

    private boolean inputIDCode(Scanner scanner){
        int times = 1;
        System.out.print("Vui long nhap so CCCD: ");

        while(true){
            boolean ip = scanner.hasNext();
            if(ip) {
                String cccd = scanner.next();
//                System.out.println("cccd = " + cccd);
                if (cccd.toLowerCase() == "no") {
                    return false;
                } else if (checkIDValidate(cccd)) {
                    return true;
                } else {

                    times++;
                    System.out.println("So CCCD khong hop le");
                    System.out.print("Vui long nhap lai lan " + times + "/5 hoac 'No' de thoat: ");
                }
            }

            if (times == 5) {
                return false;

            }
            scanner.nextLine();
        }

    }

    private void screen2(Scanner scanner){
        while (true){
            System.out.println("    | 1. Kiem tra noi sinh");
            System.out.println("    | 2. Kiem tra tuoi, gioi tinh");
            System.out.println("    | 3. Kiem tra so ngau nhien");
            System.out.println("    | 0. Thoat");
            System.out.print("Chuc nang: ");

            boolean next = scanner.hasNextInt();

            if(next){
                int funct = scanner.nextInt();
                switch (funct){
                    case 0:
                        System.out.println("Cam on ban. Hen gap lai.");
                        scanner.close();
                        System.exit(1);
                        return;
                    case 1:
                        System.out.println("Noi sinh: " + this.myProvince.getProvinceName());
                        break;
                    case 2:
                        System.out.println("Gioi tinh: " + this.myGender + " | " + this.myBirthYear);
                        break;
                    case 3:
                        System.out.println("So ngau nhien: " + this.myCode);
                        break;
                    default:
                        System.out.println("Vui long nhap dung chuc nang (0/1/2/3)");
                        break;

                }
            } else {
                System.out.println("Vui long nhap dung chuc nang (0/1/2/3)");
            }


            scanner.nextLine();

        }
    }

    //    26+26+10 = [a..z][A..Z][0..9]
    private String randomCode(){
        String validateCode = "";
        int number = 0; // 0-9 : '0'-'9'
        int lower = 10; // 10-35: [a-z]
        int upper = 36; // 36-61 [A-Z]
        int max = upper + 25;

        for(int i=0;i<6;i++){
            int ran = (new Random()).nextInt(max) ;
            char c;

            if(ran >= upper) {
                c = (char) ('A' +  ( ran - upper));
            } else if(ran >= lower) {
                c = (char) ('a' +  ( ran - lower));
            } else {
                c = (char) ('0' +   ( ran - number));
            }
            validateCode = validateCode + c;
        }
        return validateCode;
    }

    private boolean validateByString(Scanner scanner){

        int count = 1;

        while (true) {
            String validateCode = randomCode();
            System.out.println("Ma xac thuc: " + validateCode);
            System.out.print("Nhap ma xac thuc: ");

            boolean isInt = scanner.hasNext();

            if (isInt) {
                String inputCode = scanner.next();
                if (Objects.equals( validateCode,inputCode)) {
                    return true;
                } else {
                    String code = scanner.nextLine();
                    count++;
                    System.out.println("Ma xac thuc khong dung. Vui long thu lai (lan " + count + "/5)");
                }
            } else {
                count++;
                System.out.println("Ma xac thuc khong dung. Vui long thu lai (lan " + count + "/5)");
            }

            if (count == 5) {
                return false;
            }

//            scanner.nextLine();
        }
    }
}

