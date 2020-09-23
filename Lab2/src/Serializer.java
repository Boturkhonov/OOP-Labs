import java.io.*;

public class Serializer <T> {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public boolean serialization (T myObject) {
        boolean flag = false;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(myObject);
            oos.flush();
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public T deserialization () {
        ObjectInputStream ois = null;
        T myObject = null;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            myObject = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return myObject;
    }
}
