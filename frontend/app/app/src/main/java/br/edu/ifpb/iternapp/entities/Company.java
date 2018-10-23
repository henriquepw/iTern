public class Company{
    private String email;
    private String password;
    private String Fantasy_name;
    private Integer cnpj;
    private String razao_social;
    private String address_street;
    private String address_number;
    private String address_neighborhood;
    private String address_city;
    private String address_postal_code;
    private String address_state;
    private String address_country;

    public Company(){
    }

    public Company(String email, String password, String fantasy_name, Integer cnpj, String razao_social, String address_street, String address_number, String address_neighborhood, String address_city, String address_postal_code, String address_state, String address_country) {
        this.email = email;
        this.password = password;
        Fantasy_name = fantasy_name;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.address_street = address_street;
        this.address_number = address_number;
        this.address_neighborhood = address_neighborhood;
        this.address_city = address_city;
        this.address_postal_code = address_postal_code;
        this.address_state = address_state;
        this.address_country = address_country;
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

    public String getFantasy_name() {
        return Fantasy_name;
    }

    public void setFantasy_name(String fantasy_name) {
        Fantasy_name = fantasy_name;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
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

    public String getAddress_neighborhood() {
        return address_neighborhood;
    }

    public void setAddress_neighborhood(String address_neighborhood) {
        this.address_neighborhood = address_neighborhood;
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

    public String getAddress_country() {
        return address_country;
    }

    public void setAddress_country(String address_country) {
        this.address_country = address_country;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Company{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Fantasy_name='" + Fantasy_name + '\'' +
                ", cnpj=" + cnpj +
                ", razao_social='" + razao_social + '\'' +
                ", address_street='" + address_street + '\'' +
                ", address_number='" + address_number + '\'' +
                ", address_neighborhood='" + address_neighborhood + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_postal_code='" + address_postal_code + '\'' +
                ", address_state='" + address_state + '\'' +
                ", address_country='" + address_country + '\'' +
                '}';
    }
}