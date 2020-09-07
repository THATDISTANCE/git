package warehouse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;

public class JSONArray extends GenericUDTF {

    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {

        if(argOIs.getAllStructFieldRefs().size() != 1){
            new UDFArgumentException("shadiaoba");
        }

        if(!argOIs.getAllStructFieldRefs().get(0).getFieldObjectInspector().getTypeName().equals("string")){
            new UDFArgumentException("shadiaoba");
        }

        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
        fieldNames.add("coll");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,
                fieldOIs);

    }

    @Override
    public void process(Object[] objects) throws HiveException {

        String json = objects[0].toString();

        org.json.JSONArray jsonArray = new org.json.JSONArray(json);

        for (int i = 0; i < objects.length; i++) {
            String[] s = new String[1];
            s[0] = jsonArray.getString(i);
            forward(s);
        }

    }

    public void close() throws HiveException {

    }

}
