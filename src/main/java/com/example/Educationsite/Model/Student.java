package com.example.Educationsite.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student_Info")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Student_Id")
    private int id;

    @Column(name = "Student_name")
    private String student_name;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Admission_no")
    private String adm_no;

    @Column(name = "Courses_enrolled")
    private String[] courses_enrolled;

    @Column(name = "EmailId")
    private String email;

    @Column(name = "Student_Password")
    @Value("${st.password}")
    private String password;

    @JsonFormat(pattern = "DD/MM/YYYY")
    @Column(name = "Date-Of-Birth")
    private String dob;

    @Column(name = "Contact_number")
    private String contact_no;

    @Column(name = "Address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdm_no() {
        return adm_no;
    }

    public void setAdm_no(String adm_no) {
        this.adm_no = adm_no;
    }

    public String[] getCourses_enrolled() {
        return courses_enrolled;
    }

    public void setCourses_enrolled(String[] courses_enrolled) {
        this.courses_enrolled = courses_enrolled;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
