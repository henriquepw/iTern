public class Student{
    private Integer id;
    private String name;
    private Date birthday;
    private String address_street;
    private String address_number;
    private String address_city;
    private String address_postal_code;
    private String address_state;
    private String lattes;
    private Integer cpf;
    private Integer rg;
    private String birthplace;
    private String citizenship;
    private String email;
    private String password;

    public Student(){}

    public Student(Integer id, String name, Date birthday, String address_street, String address_number, String address_city, String address_postal_code, String address_state, String lattes, Integer cpf, Integer rg, String birthplace, String citizenship, String email, String password) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address_street = address_street;
        this.address_number = address_number;
        this.address_city = address_city;
        this.address_postal_code = address_postal_code;
        this.address_state = address_state;
        this.lattes = lattes;
        this.cpf = cpf;
        this.rg = rg;
        this.birthplace = birthplace;
        this.citizenship = citizenship;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_postal_code() {
        return address_postal_code;
    }

    public void setAddress_postal_code(String address_postal_code) {
        this.address_postal_code = address_postal_code;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address_street='" + address_street + '\'' +
                ", address_number='" + address_number + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_postal_code='" + address_postal_code + '\'' +
                ", address_state='" + address_state + '\'' +
                ", lattes='" + lattes + '\'' +
                ", cpf=" + cpf +
                ", rg=" + rg +
                ", birthplace='" + birthplace + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


