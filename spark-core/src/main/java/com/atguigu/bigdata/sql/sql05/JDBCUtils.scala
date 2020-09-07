package com.atguigu.bigdata.sql.sql05

import java.sql.{Connection, DriverManager}

object JDBCUtils {

  def getConnection(): Connection ={
    val driverClass = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/list"
    val user = "root"
    val password = "root"
    Class.forName(driverClass)
    val conn = DriverManager.getConnection(url, user, password)
    conn
  }

}
