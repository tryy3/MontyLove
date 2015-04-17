package us.tryy3.montylove2.gson.typeadapter;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import us.tryy3.montylove2.geom.Direction;
import us.tryy3.montylove2.geom.Directions;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class DirectionTypeAdapterFactory implements TypeAdapterFactory
{
    public static class DirectionTypeAdapter<T> extends TypeAdapter<T>
    {
        @Override
        public void write(JsonWriter writer, T obj) throws IOException
        {
            if (obj == Direction.NONE)
            {
                writer.value("NONE");
                return;
            }

            Direction dir = (Direction) obj;
            writer.beginObject();
            writer.name("yaw");
            writer.value(dir.getYaw());
            writer.name("pitch");
            writer.value(dir.getPitch());
            writer.endObject();
        }

        @Override
        public T read(JsonReader reader) throws IOException
        {
            if (reader.peek() == JsonToken.STRING && reader.nextString().equals("NONE"))
            {
                return (T) Direction.NONE;
            }

            reader.beginObject();
            reader.nextName();
            float yaw = (float) reader.nextDouble();
            reader.nextName();
            float pitch = (float) reader.nextDouble();
            reader.endObject();
            return (T) Directions.fromYawAndPitch(yaw, pitch);
        }
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type)
    {
        if (!Direction.class.isAssignableFrom(type.getRawType()))
        {
            return null;
        }

        return new DirectionTypeAdapter<>();
    }
}
