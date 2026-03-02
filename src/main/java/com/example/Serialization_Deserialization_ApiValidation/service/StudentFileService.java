package com.example.Serialization_Deserialization_ApiValidation.service;

import com.example.Serialization_Deserialization_ApiValidation.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class StudentFileService {

    private final String FILE_NAME = "student.ser";

    //  Serialization (Object → File)
    public String saveStudent(StudentDto student) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(student);   // convert to byte stream

        out.close();
        fileOut.close();

        return "Student Serialized to file!";
    }

    //  Deserialization (File → Object)
    public StudentDto readStudent() throws IOException, ClassNotFoundException {

        FileInputStream fileIn = new FileInputStream(FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(fileIn);

        StudentDto student = (StudentDto) in.readObject();

        in.close();
        fileIn.close();

        return student;
    }
}
