package com.knoldus.dbconnection
import org.scalatest.FunSuite


class StudentTest extends FunSuite {

  val obj=Student
  test("Database Connectivity: View all Records"){
    val res=obj.viewStudentRecords()
    assert(res==true)
  }

  test("Database Connectivity: Insert new Records"){
    val res=obj.addStudentRecords(5,"Mayank","mayanksayshello@my.com",5632)
    assert(res==true)
  }

  test("Database Connectivity: Delete Records by Id"){
    val res=obj.removeStudentRecord(5)
    assert(res==true)
  }

  test("Database Connectivity: Update Record by Id"){
    val res=obj.updateStudentRecord(3,"Pranavi","pranavi@gmail.com",9568)
    assert(res==true)

  }
}
