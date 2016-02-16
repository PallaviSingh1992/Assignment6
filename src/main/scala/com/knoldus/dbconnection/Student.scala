package com.knoldus.dbconnection
import java.sql.{Connection,DriverManager,ResultSet}
import org.slf4j.LoggerFactory

object Student {

  val connectionString = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root"
  Class.forName("com.mysql.jdbc.Driver")
  val conn = DriverManager.getConnection(connectionString)
  val logger=LoggerFactory.getLogger(this.getClass())

  /**Method to view all the records existing in database
    *
    * @return: True if records are returned else False
    */
  def viewStudentRecords(): Boolean = {
    try {
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      val rs = statement.executeQuery("SELECT * FROM studentdb.student;")
      if (rs != null) {
        while (rs.next())
        {
          logger.debug("Successful View of records")
          println("ID:" + rs.getString(1) + " ,Name:" + rs.getString(2) + " ,Email:" + rs.getString(3) + " ,Mobile:" + rs.getString(4))
        }
        true
      }
      else {
        logger.debug("Records not Displayed.")
        false}
    } finally {
     // conn.close()
    }
  }

  /**
    *
    * @param id
    * @param name
    * @param email
    * @param mobile
    * @return: True if record is inserted else false is returned.
    */
  def addStudentRecords(id: Int, name: String, email: String, mobile:Int): Boolean = {
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
    try {
      val prep = conn.prepareStatement("INSERT INTO `studentdb`.`student`(`idstudent`,`name`,`email`,`mobile`)VALUES(?,?,?,?);")
      prep.setInt(1, id)
      prep.setString(2, name)
      prep.setString(3, email)
      prep.setInt(4,mobile)
      val st = prep.executeUpdate()
      if (st > 0) true else false
    } finally {
      //conn.close()
    }

  }

  /**
    *
    * @param id
    * @return:Returns true id the record is deleted else False is returned.
    */
   def removeStudentRecord(id:Int):Boolean={
     val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
     try{
       val prep = conn.prepareStatement("DELETE FROM `studentdb`.`student`WHERE idstudent=?;")
        prep.setInt(1,id)
       val res=prep.executeUpdate()
       if(res > 0) true else false
     }finally{
       //conn.close()
     }
   }

  /**
    *
    * @param id
    * @param name
    * @param email
    * @param mobile
    * @return:true if record is updated else False
    */
   def updateStudentRecord(id:Int,name:String,email:String,mobile:Int):Boolean={

     val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

     try{

       val prep = conn.prepareStatement("UPDATE `studentdb`.`student` SET `idstudent` = ?, `name` = ?, `email` = ?, `mobile` = ? WHERE `idstudent` = ? ;")
       prep.setInt(1,id)
       prep.setString(2,name)
       prep.setString(3,email)
       prep.setInt(4,mobile)
       prep.setInt(5,id)
       val res=prep.executeUpdate()
       if(res > 0) true else false

     }finally{
       //conn.close()
     }
   }

}





