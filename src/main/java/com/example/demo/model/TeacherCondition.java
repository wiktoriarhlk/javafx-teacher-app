package com.example.demo.model;

public enum TeacherCondition {
    OBECNY{
        public String toString() {
            return "Obecny";
        }
    },
    DELEGACJA{
        public String toString() {
            return "Delegacja";
        }
    },
    CHORY{
        public String toString() {
            return "Chory";
        }
    },
    NIEOBECNY{
        public String toString() {
            return "Nieobecny";
        }
    }
}
