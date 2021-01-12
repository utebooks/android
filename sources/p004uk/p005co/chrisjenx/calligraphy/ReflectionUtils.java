package p004uk.p005co.chrisjenx.calligraphy;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: uk.co.chrisjenx.calligraphy.ReflectionUtils */
class ReflectionUtils {
    private static final String TAG = ReflectionUtils.class.getSimpleName();

    ReflectionUtils() {
    }

    static Field getField(Class clazz, String fieldName) {
        try {
            Field f = clazz.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    static Object getValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    static void setValue(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
        }
    }

    static Method getMethod(Class clazz, String methodName) {
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    static void invokeMethod(Object object, Method method, Object... args) {
        if (method != null) {
            try {
                method.invoke(object, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.d(TAG, "Can't invoke method using reflection", e);
            }
        }
    }
}
