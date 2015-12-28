package com.mycompany.ssms.dao;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.JavaType;

public abstract class JsonHelperClass {

    public static String snapShotEntity(Object src) {
        ObjectMapper o = new ObjectMapper();
        try {
            SimpleBeanPropertyFilter sf = SimpleBeanPropertyFilter.serializeAllExcept(new String[]{"createUserId", "dateCreated", "locId", "lastAssessed", "curLvl", "prvLvl", "currUserId", "docStatus", "remarks", "strReferred", "strWorkflow", "strComments", "workflowArchive", "referred", "workflow", "comments", "referTo", "approved", "rejected", "saved", "pending", "viewOnlyMode", "snapShotId", "jd", "finalLevel"});
            FilterProvider fp = new SimpleFilterProvider().addFilter("excludeWorkflow", sf);
            return o.writer(fp).writeValueAsString(src);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String Object2String(Object src) {
        ObjectMapper o = new ObjectMapper();
        try {
            return o.writeValueAsString(src);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <E> List<E> str2List(String src, Class<E> d) {
        ObjectMapper o = new ObjectMapper();
        try {
            JavaType type = o.getTypeFactory().constructCollectionType(List.class, d);
            return (List) o.readValue(src, type);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T str2Object(String src, Class<T> d) {
        ObjectMapper o = new ObjectMapper();
        try {
            return (T) o.readValue(src, d);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    
//    public static List<Comments> Json2Comments(String src) {
//        if (!StringUtils.hasText(src)) {
//            return new ArrayList();
//        }
//        try {
//            ObjectMapper o = new ObjectMapper();
//            List<Comments> comments = (List) o.readValue(src, new TypeReference() {
//            });
//            FileUploadService fs = (FileUploadService) AppContext.getSpringBean(FileUploadService.class);
//            for (Comments com : comments) {
//                if ((com.getFileIds() != null) && (com.getFileIds().size() > 0)) {
//                    com.setFiles(fs.getFiles(com.getFileIds()));
//                }
//            }
//            return comments;
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

//    public static List<Map<String, Object>> Json2WorkflowSnapShot(String src) {
//        if (!StringUtils.hasText(src)) {
//            return new ArrayList();
//        }
//        try {
//            ObjectMapper o = new ObjectMapper();
//            (List) o.readValue(src, new TypeReference() {
//            });
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

//    public Map<Long, Map<Integer, String>> json2VenRes(String data) {
//        ObjectMapper o = new ObjectMapper();
//        try {
//            (Map) o.readValue(data, new TypeReference() {
//            });
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
}
