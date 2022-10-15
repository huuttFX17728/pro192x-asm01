public class Province {
    Province(){}

    Province(String provinceName, String provinceCode) {
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
    }

    private String provinceName;
    private String provinceCode;

    public String getProvinceCode() {
        return provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void printProvince () {
        System.out.println("Tinh: " + this.provinceName + " | " + this.provinceCode);
    }
}
