/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package example.model

import org.apache.avro.Schema

import org.oedura.scavro.{AvroMetadata, AvroReader, AvroSerializeable}

import example.{User => JUser}

case class User(name: String, favorite_number: Option[Int], favorite_color: Option[String]) extends AvroSerializeable {
  type J = JUser
  override def toAvro: JUser = {
    new JUser(name, favorite_number match {
      case Some(x) => x
      case None => null
    }, favorite_color match {
      case Some(x) => x
      case None => null
    })
  }
}

object User {
  implicit def reader = new AvroReader[User] {
    override type J = JUser
  }
  implicit val metadata: AvroMetadata[User, JUser] = new AvroMetadata[User, JUser] {
    override val avroClass: Class[JUser] = classOf[JUser]
    override val schema: Schema = JUser.getClassSchema()
    override val fromAvro: (JUser) => User = {
      (j: JUser) => User(j.getName.toString, j.getFavorite_number match {
        case null => None
        case _ => Some(j.getFavorite_number.toInt)
      }, j.getFavorite_color match {
        case null => None
        case _ => Some(j.getFavorite_color.toString)
      })
    }
  }
}