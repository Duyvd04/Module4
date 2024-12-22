package org.example.springbootdemo.model;

import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDTO implements Validator {
    private Integer id;
//    @NotBlank(message="Ten khong duoc de trong")
//    @Size(min = 5, max = 50, message = "Nhieu hon 5 ki tu")
//    @Pattern(regexp = "", message="Khong dung format")
    private String name;
    private Clazz clazz;
    /*
    NotBlank
    NotEmpty
    NotNull
    Size
    Min/Max
    */
    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    // Chỉ hoạt động khi sử dụng với @InitBinder để đăng kí validator
    // Ý nghĩa sử dụng: Chỉ định các class có thể sử dụng validate này
    @Override
    public boolean supports(Class<?> clazz) {
//        return StudentDTO.class.isAssignableFrom(clazz);
//        return StudentDTO.class.equals(clazz);
        return false;

    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        String name = studentDTO.getName();
        if(name==null || name.trim().isEmpty()) {
            errors.rejectValue("name", "name.null");
        } else if (name.length() < 5 || name.length()>50) {
            errors.rejectValue("name", "name.length");
        }
//        else if (name.matches("")) {
//            errors.rejectValue("name", "", "Vui long nhap dung format");
//        }
    }
}
