package hbadapter;

import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class HibernateProxyAdapterFactory implements TypeAdapterFactory {
    public TypeAdapter create(Gson gson, TypeToken type) {
        return (HibernateProxy.class.isAssignableFrom(type.getRawType()) ?  new HibernateProxyTypeAdapter(gson) : null);
    }
}
