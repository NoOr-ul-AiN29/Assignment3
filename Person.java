package com.example.myjavaapp;

public class Person {
        private String name;
        private String fatherName;
        private String cnic;
        private String dateOfBirth;
        private String gender;
        private String city;

        public Person(String name, String fatherName, String cnic, String dateOfBirth, String gender, String city) {
            this.name = name;
            this.fatherName = fatherName;
            this.cnic = cnic;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.city = city;
        }

    public String getCnic() {
        return cnic;
    }


    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }


    public String getFatherName() {
        return fatherName;
    }


    public String getCity() {
        return city;
    }



}
