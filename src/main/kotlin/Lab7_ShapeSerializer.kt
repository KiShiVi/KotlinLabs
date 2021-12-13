import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import java.io.File
import java.io.IOException
import kotlin.jvm.Throws

object ShapeSerializer {
    val json = Json {
        serializersModule = SerializersModule {
            polymorphic(Shape::class) {
                subclass(Circle::class)
                subclass(Square::class)
                subclass(Rectangle::class)
                subclass(Triangle::class)
            }
        }
    }

    inline fun <reified T> encode(value: T): String = json.encodeToString(value)
    inline fun <reified T> decode(string: String): T = json.decodeFromString(string)
}

object FileIO {
    @Throws (IOException::class)
    fun fileWriter(value: String, path: String) = File(path).writeText(value)
    @Throws (IOException::class)
    fun fileReader(path: String): String = File(path).readText()
}