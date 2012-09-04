package com.ciriscr.salattest

import com.novus.salat.annotations.Salat
import com.novus.salat.dao.SalatDAO
import org.bson.types.ObjectId
import com.novus.salat.global._
import com.novus.salat._
import com.mongodb.casbah.Imports._


object Exe{

  def main(a: Array[String]){

    println(dog.getClass.getInterfaces.map(_.getName).mkString("[", ", ", "]"))
    println("Product, CaseClass or anything 'salat-able' should be there, but isn't D=")

    val dbodog = grater[Dog].asDBObject(dog)
    val dbomale = grater[Male].asDBObject(male)
    val dbojoe = grater[Joe].asDBObject(joe)
    val dbommm = grater[IceCream].asDBObject(mmm)

    println(grater[Dog].asObject(dbodog))
    println(grater[Male].asObject(dbomale))
    println(grater[Joe].asObject(dbojoe))
    println(grater[IceCream].asObject(dbommm))

    AnimalDAO.insert(dog)
    HumanDAO.insert(male)
    PersonDAO.insert(joe)
    DogDAO.insert(dog)
    MaleDAO.insert(male)
    JoeDAO.insert(joe)
    IceCreamDAO.insert(mmm)

    println(AnimalDAO.find(MongoDBObject.empty))
    println(HumanDAO.find(MongoDBObject.empty))
    println(PersonDAO.find(MongoDBObject.empty))
    println(DogDAO.find(MongoDBObject.empty))
    println(MaleDAO.find(MongoDBObject.empty))
    println(JoeDAO.find(MongoDBObject.empty))
    println(IceCreamDAO.find(MongoDBObject.empty))



  }

  @Salat
  trait Animal extends Product{
    var value1: String
  }

  @Salat
  abstract class Human(value2: Int) extends Product

  @Salat
  abstract class Person(value1: String) extends Animal

  case class Dog(var value1: String) extends Animal
  case class Male(value2: Int) extends Human(value2)
  case class Joe(var value1: String) extends Person(value1)

  case class IceCream(value: Boolean)

  object AnimalDAO extends SalatDAO[Animal, ObjectId](MongoConnection("localhost")("test")("salat"))
  object HumanDAO extends SalatDAO[Human, ObjectId](MongoConnection("localhost")("test")("salat"))
  object PersonDAO extends SalatDAO[Person, ObjectId](MongoConnection("localhost")("test")("salat"))

  object DogDAO extends SalatDAO[Dog, ObjectId](MongoConnection("localhost")("test")("salat"))
  object MaleDAO extends SalatDAO[Male, ObjectId](MongoConnection("localhost")("test")("salat"))
  object JoeDAO extends SalatDAO[Joe, ObjectId](MongoConnection("localhost")("test")("salat"))

  object IceCreamDAO extends SalatDAO[IceCream, ObjectId](MongoConnection("localhost")("test")("salat"))

  val dog = Dog("Bobby")
  val male = Male(30)
  val joe = Joe("Average")
  val mmm = IceCream(true)


}


