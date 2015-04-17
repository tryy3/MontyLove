package us.tryy3.montylove2.gson.typeadapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import us.tryy3.montylove2.gson.GsonLoadRuntimeException;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by tryy3 on 2015-04-17.
 */
public class EnumTypeAdapterFactory implements TypeAdapterFactory
{
    public static class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T>
    {
        private final Class<T> enumClass;

        public EnumTypeAdapter(Class<T> enumClass)
        {
            this.enumClass = enumClass;
        }

        @Override
        public T read(JsonReader reader) throws IOException
        {
            if(reader.peek() == JsonToken.NULL)
            {
                return null;
            }

            String name = reader.nextString().toLowerCase(Locale.US);
            for (T element : enumClass.getEnumConstants())
            {
                if(element.name().toLowerCase(Locale.US).equals(name))
                {
                    return element;
                }
            }

            throw new GsonLoadRuntimeException("Unknown value : " + name);
        }

        @Override
        public void write(JsonWriter writer, T value) throws IOException
        {
            if (value == null)
            {
                writer.nullValue();
            }
            else
            {
                writer.value(value.name());
            }
        }
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> token)
    {
        if(!token.getRawType().isEnum())
        {
            return null;
        }

        return new EnumTypeAdapter((Class<T>) token.getRawType());
    }
}
