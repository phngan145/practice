package com.kits.ngan.entity;
//저자 
public class BlogAuthor {

 // 저자 아이디 
 private Integer id;

 // 필명 
 private String displayName;

 // 성 
 private String firstName;

 // 이름 
 private String lastName;

 public Integer getId() {
     return id;
 }

 public void setId(Integer id) {
     this.id = id;
 }

 public String getDisplayName() {
     return displayName;
 }

 public void setDisplayName(String displayName) {
     this.displayName = displayName;
 }

 public String getFirstName() {
     return firstName;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 // BlogAuthor 모델 복사
 public void CopyData(BlogAuthor param)
 {
     this.id = param.getId();
     this.displayName = param.getDisplayName();
     this.firstName = param.getFirstName();
     this.lastName = param.getLastName();
 }
}