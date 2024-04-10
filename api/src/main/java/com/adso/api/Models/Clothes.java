package com.adso.api.Models;



import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="clothes")
public class Clothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "type")
    private String type;
    @Column(name = "size")
    private int size;
    @Column(name =  "color")
    private String color;
    @Column(name =  "createAt")
    @CreatedDate
    private Date createAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
    this.color = color;
    }
    public Date getCreateAt() {
    return createAt;
    }
    public void setCreateAt(Date createAt) {
    this.createAt = createAt;
    }

}